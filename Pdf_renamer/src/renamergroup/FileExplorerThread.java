/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renamergroup;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mesbah
 */
public class FileExplorerThread extends Thread{
    private OnListToRenameResult renamerframe;
    private Queue<String> fileDirs;
    private boolean fileImportStatus;
    private FileFinderThread[] filefinders;
    private static final int totFinderThread=2;
    FileExplorerThread(OnListToRenameResult frame)
    {
        renamerframe =frame;
        initInstance();
    }
    private void initInstance()
    {
        
        fileDirs =new LinkedList<String>();
        fileImportStatus=true;
    }
    private void startFinderThreads()
    {
        filefinders =new FileFinderThread[totFinderThread];
        for(int i=0;i<totFinderThread;i++)
        {
            filefinders[i]=new FileFinderThread(renamerframe,fileDirs);
            filefinders[i].setPriority(Thread.MAX_PRIORITY);
            filefinders[i].start();
        }
        
    }
    private void joinFinderThreads() throws InterruptedException
    {
        for(int i=0;i<totFinderThread;i++)
        {
            filefinders[i].join();
            
        }
    }
    
    public void run()
    {
       FileExplorer files =new FileExplorer(fileDirs,renamerframe.getDirectory()); 
       Path startingDir = FileSystems.getDefault().getPath(renamerframe.getDirectory());
       
        try {
            renamerframe.setFileExploreStatus(false);
            startFinderThreads();
            Files.walkFileTree(startingDir,files);
            renamerframe.setFileExploreStatus(true);
            joinFinderThreads();
            
            
        } catch (IOException ex) {
            //alertdialog for cannot done process
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        finally
        {
            fileDirs.clear();
            renamerframe.fileExploreExecuted();
        }
    }
}
