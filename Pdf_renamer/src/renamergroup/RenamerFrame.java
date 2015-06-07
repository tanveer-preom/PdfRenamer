/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renamergroup;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import mainviewgroup.FrameDatasHandler;

/**
 *
 * @author Mesbah
 */
public class RenamerFrame extends javax.swing.JFrame implements ActionListener,OnListToRenameResult{

    /**
     * Creates new form RenamerFrame
     */
    private FrameDatasHandler mainframe;
    private String author,keyword,title,subject,directory;
    private Queue<String> filesToRename;
    private boolean fileExploreStatus;
    public RenamerFrame(FrameDatasHandler handler) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainframe=handler;
        
        initInstance();
        initUi();
        new FileExplorerThread(this).start();
        
    }
    private void initUi()
    {
        statusLabel.setText("Initializing.... Please Wait !!!");
        rename.setEnabled(false);
        dateandtime.setText(getTimeDate());
    }
    private String getTimeDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd_MM_YYYY HH_mm_ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    private void initInstance()
    {
        author =mainframe.getField("author");
        title=mainframe.getField("title");
        keyword=mainframe.getField("keyword");
        subject=mainframe.getField("subject");
        directory=mainframe.getDirectory();
        filesToRename =new LinkedList<String>();
        rename.addActionListener(this);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        filename = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        dateandtime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rename = new javax.swing.JButton();
        progressbar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        statusLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Enter a Format Below :");

        jLabel1.setText("_");

        jLabel3.setText("_");

        jLabel4.setText("(number)");

        rename.setText("Start");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(filename, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateandtime, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(rename, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addComponent(progressbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(filename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(dateandtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(rename)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dateandtime;
    private javax.swing.JTextField filename;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar progressbar;
    private javax.swing.JButton rename;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(rename.getActionCommand()))
        {
            rename.setEnabled(false);
            
            new Thread()
            {
              public void run()
              {
                  String setfileName = filename.getText().toString()+"_"+dateandtime.getText().toString();
                  int i=0;
                  double size =filesToRename.size();
            
            while(!filesToRename.isEmpty())
            {
                String fileDir = filesToRename.poll();
                File old =new File(fileDir);
                File renamed =new File(getDirectory()+"\\"+setfileName+"_"+(i++)+".pdf");
                try
                {old.renameTo(renamed);
                double progress = (size-filesToRename.size())/size*100;
                progressbar.setValue((int)progress);
                }
                catch(Exception ex)
                {
                    //alertdialog problem in renaming
                }
            }
              }
                
            }.start();
            
            //rename.setEnabled(true);
        }
    }
   

    @Override
    public void initListToRename(String result) {
        filesToRename.add(result);
    }
    public String getDirectory()
    {
        return mainframe.getDirectory();
    }

    @Override
    public boolean fileExploreEnded() {
        return fileExploreStatus;
    
    }

    @Override
    public void setFileExploreStatus(boolean status) {
        fileExploreStatus =status;
    }

    @Override
    public FrameDatasHandler getRoot() {
        return mainframe;
    }

    @Override
    public void fileExploreExecuted() {
        rename.setEnabled(true);
        statusLabel.setText(""+filesToRename.size()+" File(s) Found !!!");
    }
    
    
}
