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
import java.util.Calendar;
import java.util.List;
import vod.IdGenerator;
import vod.NamesBase;
import vod.ProgressGenerator;

/**
 *
 * @author kamil_2
 */
public abstract class Multimedia implements Serializable {

    /**
     * @return the arriveDate
     */
    public Calendar getArriveDate() {
        return arriveDate;
    }

    /**
     * @param arriveDate the arriveDate to set
     */
    public void setArriveDate(Calendar arriveDate) {
        this.arriveDate = arriveDate;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    /**
    *Creates new Object of class Multimedia
    */
    public Multimedia(){
        this.id = IdGenerator.giveId();
        this.country = "USA";
        this.description = "There is no description.";
        this.distributor = null;
        this.dateProduction = Calendar.getInstance();
        this.duration = 60;
        this.name = "Unknown";
        this.rating = 5;
        this.imgPath = "pictures\\unknown.jpg";
        this.viewership = new ArrayList();
        this.arriveDate = Calendar.getInstance();
        this.arriveDate.set(ProgressGenerator.getDate().get(Calendar.YEAR), 
                ProgressGenerator.getDate().get(Calendar.MONTH), 
                ProgressGenerator.getDate().get(Calendar.DAY_OF_MONTH), 0,0,0);
        viewership.add(0);
    }
    /**
    *Creates new Object of class Multimedia
     * @param distributor
    */
    public Multimedia(Distributor distributor){
        this();
        this.distributor = distributor;
    }
    /**
    *Creates new Object of class Multimedia
     * @param distributor
     * @param random random number, to initiate random values of fields
    */
    public Multimedia(Distributor distributor, int random){
        this(distributor);
        dateProduction = Calendar.getInstance();
        this.country = NamesBase.getCountries()[random % NamesBase.getCountries().length];
        this.dateProduction.set(Calendar.YEAR, random % 119 + 1899);
        this.dateProduction.set(Calendar.MONTH, random % 12 );
        this.dateProduction.set(Calendar.DAY_OF_MONTH, random % 28 );
        this.duration = (random % 120 + 60);
        this.rating = random % 10 + 1;
    }
    /**
     *
     * @return
     */
    public String getImgPath() {
        return imgPath;
    }
    
    /**
     *
     * @param imgPath
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public Calendar getDateProduction() {
        return dateProduction;
    }

    /**
     *
     * @param dateProduction
     */
    public void setDateProduction(Calendar dateProduction) {
        this.dateProduction = dateProduction;
    }

    /**
     *
     * @return
     */
    public int getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     *
     * @return
     */
    public Distributor getDistributor() {
        return distributor;
    }

    /**
     *
     * @param distributor
     */
    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     */
    public int getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
//    private static int number;
    private final int id;
    private String imgPath;
    private String name;
    private String description;
    private Calendar dateProduction;
    private int duration;
    private Distributor distributor;
    private String country;
    private int rating;
    private List<Integer> viewership;
    private Calendar arriveDate;//date when was added to simulation


    public void show(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(id + " " + name + " " + description + " " + 
                formatter.format(dateProduction.getTime()) + " " +
                duration + " " + distributor.getDistName() + " " + country + " " + rating);
    }

    /**
     * @return the viewership
     */
    public List<Integer> getViewership() {
        return viewership;
    }

    /**
     * @param viewership the viewership to set
     */
    public void setViewership(List<Integer> viewership) {
        this.viewership = viewership;
    }

    
}
