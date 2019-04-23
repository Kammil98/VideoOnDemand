/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multimedias;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kamil_2
 */
public class Season implements Serializable{
    
    /**
     *Creates new Object of class Season
     */
    public Season(){
        this.episodes = new ArrayList();
    }
    /**
     *Creates new Object of class Season
     * @param random
     */
    public Season(int random){
        this();
        int epiNumb = random % 11 + 10;
        for(int i = 0; i < epiNumb; i++){
            this.episodes.add(new Episode(random * (i + 2)));
        }
    }
    private List<Episode> episodes;

    /**
     * 
     * @param i
     * @return
     */
    public Episode getEpisode(int i) { return this.getEpisodes().get(i); }

    /**
     * removing last Episode on position i and set new, given episode
     * @param episode
     * @param i
     */
    public void setEpisode( Episode episode, int i) { 
        this.getEpisodes().remove(i);
        this.getEpisodes().add(i, episode); 
    }

    /**
     * add new episode at the end of List Episodes
     * @param episode
     */
    public void addEpisode( Episode episode) {this.getEpisodes().add(episode);}

    /**
     * @return the episodes
     */
    public List<Episode> getEpisodes() {
        return episodes;
    }

    /**
     * @param episodes the episodes to set
     */
    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }
}

