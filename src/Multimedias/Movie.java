/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multimedias;

import Users.Distributor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import vod.NamesBase;



/**
 *
 * @author kamil_2
 */

public class Movie extends Multimedia implements Serializable{

    /**
     * @return the promotion
     */
    public Promotion getPromotion() {
        return promotion;
    }

    /**
     * @param promotion the promotion to set
     */
    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    /**
     * @return the actors
     */
    public List<String> getActors() {
        return actors;
    }

    /**
     * @param actors the actors to set
     */
    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    /**
     * @return the links
     */
    public List<String> getLinks() {
        return links;
    }

    /**
     * @param links the links to set
     */
    public void setLinks(List<String> links) {
        this.links = links;
    }

    /**
     * Creates new Object of class Movie
     */
    public Movie(){
        super();
        this.type = Movie.Type.sensacyjny;
        this.price = 10;
        this.timeToWatch = 5;
        this.promotion = new Promotion();
        this.actors = new ArrayList();
        this.links = new ArrayList();
    }
    
    /**
     * Creates new Object of class Movie
     * @param distributor
     */
    public Movie(Distributor distributor){
        this();
        super.setDistributor(distributor);
    }
    /**
     * Creates new Object of class Movie
     * @param distributor 
     * @param random random number, to initiate random values of fields
     */
    public Movie(Distributor distributor, int random){
        super(distributor, random);
        super.setName(NamesBase.getMovieNames()[random % NamesBase.getMovieNames().length]);
        int actorsNumber = random % 3 + 2;
        switch(random % 6){
            case 0:
                this.type = Movie.Type.akcja; 
                super.setImgPath("pictures\\action.jpg");
                break;
            case 1:
                this.type = Movie.Type.dokumentalny; 
                super.setImgPath("pictures\\documental.jpg");
                break;
            case 2:
                this.type = Movie.Type.dramat; 
                super.setImgPath("pictures\\drama.jpg");
                break;
            case 3:
                this.type = Movie.Type.dzieciecy; 
                super.setImgPath("pictures\\children.jpg");
                break;
            case 4:
                this.type = Movie.Type.komedia; 
                super.setImgPath("pictures\\comedy.jpg");
                break;
            case 5:
                this.type = Movie.Type.sensacyjny; 
                super.setImgPath("pictures\\sensational.jpg");
                break;
        }
        this.price = random % 10 + 10;
        this.timeToWatch = random % 5 + 10; 
        if(random % 2 == 0) 
            this.promotion = new Promotion(random);
        else 
            this.promotion = null;
        this.actors = new ArrayList();
        for(int i = 0; i < actorsNumber; i++){
            this.actors.add(NamesBase.getActors()[(random * (i + 5)) % NamesBase.getActors().length]);
        }
        this.links = new ArrayList();
    }
    /**
     * Type of Multimedia
     */
    public static enum Type{
        sensacyjny,dramat,komedia,dzieciecy,dokumentalny, akcja;
    }
    private Type type;
    private List<String> actors;
    private List<String> links;
    private float price;
    private int timeToWatch; //time in days - how long we will be able to watch Movie after buying
    private Promotion promotion;

    /**
     *
     * @return
     */
    public Type getType() { return this.type; }

    /**
     *
     * @param type
     */
    public void setType( Type type ) { this.type = type; }

    /**
     *
     * @param i
     * @return
     */
    public String getActor(int i) { return (String)this.getActors().get(i); }

    /**
     *
     * @param actor
     */
    public void setActor( String actor ) { this.getActors().add(actor); }

    /**
     *
     * @param i
     * @return
     */
    public String getLink(int i) { return (String)this.getLinks().get(i); }

    /**
     *
     * @param link
     */
    public void setLink( String link ) { this.getLinks().add(link); }

    /**
     *
     * @return
     */
    public float getPrice() { return this.price; }

    /**
     *
     * @param price
     */
    public void setPrice( float price ) { this.price = price; }

    /**
     *
     * @return
     */
    public int getTimeToWatch() { return this.timeToWatch; }

    /**
     *
     * @param timeToWatch
     */
    public void setTimeToWatch( int timeToWatch ) { this.timeToWatch = timeToWatch; }
    
    /**
     *shows Movie on Console
     */
    @Override
    public void show(){
       super.show();
        System.out.println(type + " " + price + " " + timeToWatch);
        actors.forEach(System.out::println);
        links.forEach(System.out::println);
    }
}
