/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarymvc.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class DVD {
    private int dvdId;
    @NotEmpty(message="You must supply a title")
    @Length(max=210, message="The longest movie title is of all time is \"Night of the Day of the" 
            +"\r"+"Dawn of the Son of the Bride of the Return of the Revenge of the" 
            +"\r"+"Terror of the Attack of the Evil, Mutant, Alien, Flesh Eating, Hellbound, "
            +"\r"+"Zombified Living Dead Part 2: In Shocking 2D\" and this is not that movie")
    private String title;
    @NotEmpty(message="You must supply the release year")
    private String year;
    @Length(max=5, message="Please enter a valid MPAA rating")
    private String rating = "unknown";
    @Length(max=50, message="If the name is really over 50 characters, please abreviate")
    private String director = "unknown";
    @Length(max=50, message="No more than 50 charaters")
    private String studio = "unknown";
    private String userRating = "none";

    /**
     */
    public DVD(){
        
    }
    
   
    
    public DVD(String title,String year,String rating,String director,String studio,String userRating){
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.director = director;
        this.studio = studio;
        this.userRating = userRating;
    }
    
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param raiting the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the studio
     */
    public String getStudio() {
        return studio;
    }

    /**
     * @param studio the studio to set
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }

    /**
     * @return the userRaiting
     */
    public String getUserRating() {
        return userRating;
    }

    /**
     * @param userRaiting the userRaiting to set
     */
    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
    
    @Override
    public String toString(){
        return "title: "+title+" \rReleased In: "+year+" MPAA: "+rating+" Director: "+director+" Studio: "+studio+ " \rYour notes on the film: "+userRating;
    }
    
    public String export(){
        return title+"::"+year+"::"+rating+"::"+director+"::"+studio+"::"+userRating;
    }
    
//    public long getAge(){
//        Period p = getYear().until(LocalDate.now());
//        return p.getYears();
//    }
    
    
    /**
     * @return the dvdId
     */
    public int getDvdId() {
        return dvdId;
    }

    /**
     * @param dvdId the dvdId to set
     */
    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }
}
