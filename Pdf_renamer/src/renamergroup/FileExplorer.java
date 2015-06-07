/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renamergroup;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Queue;

/**
 *
 * @author Mesbah
 */
class FileExplorer extends SimpleFileVisitor<Path>{
    private Queue<String> fileList;
    private String directory;
    FileExplorer(Queue<String> fileList,String dir)
    {
        this.fileList=fileList;
        directory=dir;
    }
    private boolean extensionCheck(char[] dir)
    {
        int i=dir.length;
        if(dir[i-1]=='f' && dir[i-2]=='d' && dir[i-3]=='p')
        return true;
        return false;
    }
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        //To change body of generated methods, choose Tools | Templates.
           return FileVisitResult.CONTINUE;
        
     }

   
    
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        //
        
        if((dir.toString()).equals(directory))//To change body of generated methods, choose Tools | Templates.
        {
           //System.out.print(dir.toAbsolutePath()); 
            return FileVisitResult.CONTINUE;
        }
        return FileVisitResult.SKIP_SUBTREE; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isSymbolicLink()) {
            System.out.format("Symbolic link: %s ", file);
        } else if (attrs.isRegularFile()) {
            if(extensionCheck(file.toString().toCharArray()))
            {
                fileList.add(file.toString());
            }
            
        } else {
            System.out.format("Other: %s ", file);
        }
        //System.out.println("(" + attrs.size() + "bytes)");
        return FileVisitResult.CONTINUE;
    }
    
    

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println(exc);
        return FileVisitResult.CONTINUE;  
    }

    
    
}
