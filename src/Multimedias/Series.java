/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multimedias;

import Users.Distributor;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import vod.NamesBase;

/**
 *
 * @author kamil_2
 */
public class Series extends Multimedia implements Serializable {

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
     * Creates new Object of class Series
     */
    public Series(){
        super();
        this.setType(Series.Type.sensacyjny); 
        this.setPrice(5);
        this.setActors(new ArrayList());
        this.setSeasones(new ArrayList());
        getSeasones().add(new Season());
    }

    /**
     * Creates new Object of class Series
     * @param distributor
     */
    public Series(Distributor distributor){
        this();
        super.setDistributor(distributor);
    }
    
    /**
     * Creates new Object of class Series
     * @param distributor
     * @param random
     */
    public Series(Distributor distributor, int random){
        super(distributor, random);
        super.setName(NamesBase.getSeriesNames()[random % NamesBase.getSeriesNames().length]);
        int actorsNumber = random % 3 + 2, seasonsNumb = random % 4 + 1;
        this.price = random % 10 + 10;
        switch(random % 6){
            case 0:
                this.type = Series.Type.akcja; 
                super.setImgPath("pictures\\action.jpg");
                break;
            case 1:
                this.type = Series.Type.dokumentalny; 
                super.setImgPath("pictures\\documental.jpg");
                break;
            case 2:
                this.type = Series.Type.dramat; 
                super.setImgPath("pictures\\drama.jpg");
                break;
            case 3:
                this.type = Series.Type.dzieciecy; 
                super.setImgPath("pictures\\children.jpg");
                break;
            case 4:
                this.type = Series.Type.komedia; 
                super.setImgPath("pictures\\comedy.jpg");
                break;
            case 5:
                this.type = Series.Type.sensacyjny; 
                super.setImgPath("pictures\\sensational.jpg");
                break;
        }
        this.actors = new ArrayList();
        for(int i = 0; i < actorsNumber; i++){
            this.actors.add(NamesBase.getActors()[(random * (i + 5)) % NamesBase.getActors().length]);
        }
        this.setSeasones(new ArrayList());
        for(int i = 0; i < actorsNumber; i++){
            this.seasones.add(new Season(random * (i + 5)));
        }
        
    }
    /**
     * Type of Multimedias
     */
    public static enum Type{
        sensacyjny,dramat,komedia,dzieciecy,dokumentalny, akcja;
    }
    private Type type;
    private List<String> actors;
    private float price;
    private List<Season> seasones;
    
    /**
     *
     * @param i
     * @return
     */
    public Season getSeason(int i) { return this.getSeasones().get(i); }

    /**
     *
     * @param season
     */
    public void setSeason( Season season ) { this.getSeasones().add(season); }

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
     * @return
     */
    public Type getType() {return type;}

    /**
     *
     * @param type
     */
    public void setType(Type type) {this.type = type; }

    /**
     *
     * @return
     */
    public float getPrice() {return price;}

    /**
     *
     * @param price
     */
    public void setPrice(float price) {this.price = price;}

    /**
     * @return the seasones
     */
    public List<Season> getSeasones() {
        return seasones;
    }

    /**
     * @param seasones the seasones to set
     */
    public void setSeasones(List<Season> seasones) {
        this.seasones = seasones;
    }

    /**
     *shows Series on Console
     */
    @Override
    public void show(){
        super.show();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(type + " " + price);
        getActors().forEach(System.out::println);
        getSeasones().forEach((val) -> {
            System.out.println("Sezon");
            val.getEpisodes().forEach((val2) -> {
                System.out.println("Episode " + val2.getDuration() + " " + formatter.format(val2.getPremiere().getTime()));
           });
        });
    }
}
