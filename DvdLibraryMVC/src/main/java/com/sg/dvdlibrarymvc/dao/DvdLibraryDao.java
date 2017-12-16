/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarymvc.dao;
import com.sg.dvdlibrarymvc.model.DVD;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface DvdLibraryDao {
    public ArrayList addDVD(DVD dvd);
    public ArrayList removeDVD(int id);
    public ArrayList getArrayList();
    public DVD displayInfo(String title);
    public ArrayList searchForDVD(String title);
    public boolean importFile(String file) throws FileNotFoundException;
    public boolean exportFile(String file);
    public DVD edit(DVD dvd);
    public List findMovieLastNYears(int n);
    public List findMPAA(String rating);
    public List findByDirector(String dir);
    public List searchByStudio(String studio);   
    public double avgAge();
    public List findNewest();   
    public List findOldest();
    public DVD getDVDById(int id);
}
