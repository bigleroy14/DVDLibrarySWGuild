/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarymvc.dao;

import com.sg.dvdlibrarymvc.model.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DvdLibraryDaoImpl implements DvdLibraryDao {

    ArrayList<DVD> dvdArray = new ArrayList();
    private static int idCounter =0;
    
    @Override
    public DVD getDVDById(int id){
        DVD findDvd = new DVD();
        for(DVD dvd : dvdArray){
            if(dvd.getDvdId() == id){
                findDvd = dvd;
            }
        }
        return findDvd;
    }
    
    
    @Override
    public ArrayList getArrayList() {
        return dvdArray;
    }
    
    @Override
    public ArrayList addDVD(DVD dvd){
        dvd.setDvdId(idCounter);
        idCounter++;
        dvdArray.add(dvd);
        return dvdArray;
    }

    @Override
    public ArrayList removeDVD(int id) {
        int index = 0;
        for (DVD dvd: dvdArray) {
            if (dvd.getDvdId()==id) {
                index = dvdArray.indexOf(dvd);
            }
            
        }
        dvdArray.remove(index);
        return dvdArray;
    }

    

    @Override
    public DVD displayInfo(String title) {
        DVD d = new DVD();
        for (DVD dvd : dvdArray) {
            if (dvd.getTitle().equals(title)) {
                d = dvd;
            }
        }
        return d;
    }

    @Override
    public ArrayList searchForDVD(String title) {
        ArrayList<DVD> DVDTemp2 = new ArrayList();
        dvdArray.stream().filter((dvd) -> (dvd.getTitle().contains(title))).forEach((dvd) -> {
            DVDTemp2.add(dvd);
        });
        return DVDTemp2;
    }

    @Override
    public boolean importFile(String file) throws FileNotFoundException {
        boolean error = true;
        try (Scanner in = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (in.hasNext()) {
                //String fileAB = in.nextLine();
                //String[] entryDVD = fileAB.split("::");
                //addDVD(entryDVD[0], LocalDate.parse(entryDVD[1]), entryDVD[2], entryDVD[3], entryDVD[4], entryDVD[5]);

            }
        } catch (FileNotFoundException e) {
            error = false;
        }
        return error;
    }

    @Override
    public boolean exportFile(String file) {
        boolean error = false;
        try (PrintWriter pr = new PrintWriter(new FileWriter(file))) {
            dvdArray.stream().forEach((dvd) -> {
                pr.println(dvd.export());
            });

            pr.flush();
            pr.close();
        } catch (Exception e) {
            error = true;
        }

        return error;
    }

    @Override
    public DVD edit(DVD updatedDvd) {
        for (DVD dvd : dvdArray) {
            if (dvd.getDvdId()==updatedDvd.getDvdId()) {
                        dvd.setTitle(updatedDvd.getTitle());
                        dvd.setYear(updatedDvd.getYear());
                        dvd.setRating(updatedDvd.getRating());
                        dvd.setDirector(updatedDvd.getDirector());
                        dvd.setStudio(updatedDvd.getStudio());
                        dvd.setUserRating(updatedDvd.getUserRating());
                }
            }
        
        return updatedDvd;

    }

    @Override
    public List findMovieLastNYears(int n) {
        List<DVD> nYears = new ArrayList<>();
        //List<DVD> nYears = dvdArray.stream().filter(d -> d.getYear().until(LocalDate.now()).getYears() < n).collect(Collectors.toList());
        return nYears;
    }

    @Override
    public List findMPAA(String rating) {
        List<DVD> ratingSearch = dvdArray.stream().filter(d -> d.getRating().equals(rating)).collect(Collectors.toList());
        return ratingSearch;
    }

    @Override
    public List findByDirector(String dir) {
        List<DVD> dirSearch = dvdArray.stream().filter(d -> d.getDirector().equals(dir)).collect(Collectors.toList());
        List<DVD> ratedG = dirSearch.stream().filter(d -> d.getRating().equalsIgnoreCase("g")).collect(Collectors.toList());
        List<DVD> ratedPG = dirSearch.stream().filter(d -> d.getRating().equalsIgnoreCase("pg")).collect(Collectors.toList());
        List<DVD> ratedPG13 = dirSearch.stream().filter(d -> d.getRating().equalsIgnoreCase("pg-13")).collect(Collectors.toList());
        List<DVD> ratedR = dirSearch.stream().filter(d -> d.getRating().equalsIgnoreCase("R")).collect(Collectors.toList());
        List<DVD> Unrated = dirSearch.stream().filter(d -> d.getRating().equalsIgnoreCase("Unrated")).collect(Collectors.toList());
        List<List<DVD>> MPAA = new ArrayList();
        MPAA.add(ratedG);
        MPAA.add(ratedPG);
        MPAA.add(ratedPG13);
        MPAA.add(ratedR);
        MPAA.add(Unrated);
        return MPAA;
    }

    @Override
    public List searchByStudio(String studio) {
        List<DVD> studioSearch = dvdArray.stream().filter(d -> d.getStudio().equals(studio)).collect(Collectors.toList());
        return studioSearch;
    }

    @Override
    public double avgAge() {
        double avg = 0;
                //dvdArray.stream().mapToLong(DVD::getAge).average().getAsDouble();
        return avg;
    }

    @Override
    public List findNewest() {
        List<DVD> min = new ArrayList<>();
        //double minAge = dvdArray.stream().mapToLong(DVD::getAge).min().getAsLong();
        //List<DVD> min = dvdArray.stream().filter(d -> d.getAge() == minAge).collect(Collectors.toList());
        return min;
    }

    @Override
    public List findOldest() {
        List<DVD> max = new ArrayList<>();
        //double maxAge = dvdArray.stream().mapToLong(DVD::getAge).max().getAsLong();
        //List<DVD> max = dvdArray.stream().filter(d -> d.getAge() == maxAge).collect(Collectors.toList());
        return max;
    }

    
}
