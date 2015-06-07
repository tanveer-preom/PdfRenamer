/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renamergroup;

import com.itextpdf.text.pdf.PdfReader;
import java.io.IOException;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainviewgroup.FrameDatasHandler;

/**
 *
 * @author Mesbah
 */
class FileFinderThread extends Thread{
    private Queue<String> fileList;
    OnListToRenameResult renamerframe;
    FrameDatasHandler mainframe;
    FileFinderThread(OnListToRenameResult renamerframe,Queue<String>fileList)
    {
        this.renamerframe=renamerframe;
        this.fileList=fileList;
        mainframe=renamerframe.getRoot();
    }
    
    public void run()
    {
        while(!renamerframe.fileExploreEnded() || !fileList.isEmpty())
        {
            try { 
                String fileDir=fileList.poll();
                if(fileDir==null)
                continue;    
                PdfReader reader =new PdfReader(fileDir);
                Map<String,String> info =reader.getInfo();
                String author = info.get("Author");
                String title = info.get("Title");
                String subject =info.get("Subject");
                String keywords =info.get("Keywords");
                if(mainframe.isMatched(author, "author")
                  || mainframe.isMatched(title, "title")
                  ||  mainframe.isMatched(subject, "subject")
                  ||  mainframe.isMatched(keywords, "keywords")
                  )
                {
                  renamerframe.initListToRename(fileDir);
                }
                info.clear();
                reader.close();
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
        }
        
    }
}
