/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multimedias;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author kamil_2
 */
public class Episode implements Serializable{

    /**
     *Creates new Object of class Episodes
     */
    public Episode(){
        this.premiere = Calendar.getInstance();
        this.duration = 60;
    }
    /**
     *Creates new Object of class Episodes
     * @param premiere
     * @param duration
     */
    public Episode(Calendar premiere, int duration){
        this.premiere = premiere;
        this.duration = duration;
    }
    /**
     *Creates new Object of class Episodes
     * @param random
     */
    public Episode(int random){
        this.premiere = Calendar.getInstance();
        premiere.set(Calendar.DAY_OF_MONTH, random % 28 + 1);
        premiere.set(Calendar.MONTH, random % 12);
        premiere.set(Calendar.YEAR, random % 119 + 1899);
        this.duration = random % 31 + 30;
    }
    private Calendar premiere;
    private int duration;

    /**
     *
     * @return
     */
    public Calendar getPremiere() {return premiere;}

    /**
     *
     * @param premiere
     */
    public void setPremiere(Calendar premiere) {this.premiere = premiere;}

    /**
     *
     * @return
     */
    public int getDuration() {return duration;}

    /**
     *
     * @param duration
     */
    public void setDuration(int duration) {this.duration = duration;}
}

