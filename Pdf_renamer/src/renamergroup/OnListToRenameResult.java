/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renamergroup;

import java.util.Queue;
import mainviewgroup.FrameDatasHandler;

/**
 *
 * @author Mesbah
 */
public interface OnListToRenameResult {
    public void initListToRename(String result);
    public String getDirectory();
    public boolean fileExploreEnded();
    public void setFileExploreStatus(boolean status);
    public FrameDatasHandler getRoot();
   public void fileExploreExecuted();
}
