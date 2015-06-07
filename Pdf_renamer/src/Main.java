
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

import mainviewgroup.StartingFrame;
import org.apache.pdfbox.pdmodel.PDDocument;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mesbah
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DocumentException, IOException {
            
        
            // TODO code application logic here
            //Map <String,String> inf =new HashMap<String,String>();
            //StartingFrame startingframe =new StartingFrame();
            //startingframe.setVisible(true);
                PdfReader reader =new PdfReader("C:\\Users\\MASURA\\Downloads\\bassbaba-sumon_walter-white.mp3");
                Map<String,String> info =reader.getInfo();
                System.out.print(info.get("Bit rate"));
        
    }
    
}
