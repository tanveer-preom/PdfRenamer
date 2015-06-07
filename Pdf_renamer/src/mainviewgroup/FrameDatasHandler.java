/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainviewgroup;

/**
 *
 * @author Mesbah
 */
public interface FrameDatasHandler {
    public String getField(String fieldName);
    public boolean isMatched(String data,String field);
    public boolean isExactMatchTicked(String field);
    public String getDirectory();
}
