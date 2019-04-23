/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import Multimedias.LiveStream;
import Multimedias.Movie;
import Multimedias.Multimedia;
import Multimedias.Series;
import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author kamil_2
 */
public class Transaction implements Serializable {
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * Creates new Object of class Transaction
    */
    public Transaction(){
        this.id = IdGenerator.giveId();
        this.deviceCount = 1;
        this.multimedia = null;
        this.price = 10;
        this.resolution = Resolution._480;
        this.subscription = Subscription.OneTime;
        this.validityDate = Calendar.getInstance();
        this.timeTrans = false;
    }
    /**
     * Creates one time transaction
     * @param multimedia
    */
    public Transaction(Multimedia multimedia){
        this();
        this.multimedia = multimedia;
        
        if(this.multimedia instanceof Movie){
            this.validityDate.set(ProgressGenerator.getDate().get(Calendar.YEAR), 
                    ProgressGenerator.getDate().get(Calendar.MONTH), ProgressGenerator.getDate().get(Calendar.DAY_OF_MONTH),0 , 0, 0);
            this.timeTrans = true;
            this.validityDate.add(Calendar.DATE, ((Movie)this.multimedia).getTimeToWatch());
            this.price = ((Movie) this.multimedia).getPrice();
            if(((Movie)this.multimedia).getPromotion() != null && 
                    ((Movie)this.multimedia).getPromotion().getTo().compareTo(ProgressGenerator.getDate()) > 0 ){
                this.price *= 1.0 - ((float)((Movie)this.multimedia).getPromotion().getDiscount()/100);
            }
        }
        if(this.multimedia instanceof Series){
            this.price = ((Series) this.multimedia).getPrice();
        }
        if(this.multimedia instanceof LiveStream){
            this.price = ((LiveStream) this.multimedia).getPrice();
             if(((LiveStream)this.multimedia).getPromotion() != null && 
                    ((LiveStream)this.multimedia).getPromotion().getTo().compareTo(ProgressGenerator.getDate()) > 0 ){
                this.price *= 1.0 - ((float)((LiveStream)this.multimedia).getPromotion().getDiscount()/100);
            }
        }
        
        getDb().addFloatToBalance(getPrice());
    }

    /**
     * create subscription
     * @param random
     */
    public Transaction(int random){ 
        this();
        this.timeTrans = true;
        this.validityDate.set(ProgressGenerator.getDate().get(Calendar.YEAR), 
                    ProgressGenerator.getDate().get(Calendar.MONTH), ProgressGenerator.getDate().get(Calendar.DAY_OF_MONTH),0 , 0, 0);
        this.validityDate.add(Calendar.MONTH, 1);
        switch(random % 3){
            case 0:
                this.subscription = Subscription.Basic;
                this.deviceCount = 2;
                this.price = getDb().getSubPrices()[0];
                this.resolution = Resolution._1080;
                break;
            case 1:
                this.subscription = Subscription.Premium;
                this.deviceCount = 5;
                this.price = getDb().getSubPrices()[2];
                this.resolution = Resolution._2k;
                break;
            default:
                this.subscription = Subscription.Family;
                this.deviceCount = 10;
                this.price = getDb().getSubPrices()[1];
                this.resolution = Resolution._720;
        }
        getDb().addFloatToBalance(getPrice());
    }

    /**
     * Type of Subscription
     */
    public enum Subscription{
        OneTime, Basic, Family, Premium;
    }

    /**
     * Type of Resolution
     */
    public enum Resolution{
        _480, _720, _1080, _2k
    }
    private final int id;
    private float price;
    private Multimedia multimedia;
    private Calendar validityDate;
    private Subscription subscription;
    private int deviceCount;
    private Resolution resolution;
    private boolean timeTrans;// true if transaction is limited by time
    private static DataBase db;
    /**
     * @return the db
     */
    public static DataBase getDb() {
        return db;
    }

    /**
     * @param aDb the db to set
     */
    public static void setDb(DataBase aDb) {
        db = aDb;
    }
    /**
     *
     * @return
     */
    public float getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public Multimedia getMultimedia() {
        return multimedia;
    }

    /**
     *
     * @param multimedia
     */
    public void setMultimedia(Multimedia multimedia) {
        this.multimedia = multimedia;
    }

    /**
     *
     * @return
     */
    public Calendar getValidityDate() {
        return validityDate;
    }

    /**
     *
     * @param validityDate
     */
    public void setValidityDate(Calendar validityDate) {
        this.validityDate = validityDate;
    }

    /**
     *
     * @return
     */
    public Subscription getSubscription() {
        return subscription;
    }

    /**
     *
     * @param subscription
     */
    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    /**
     *
     * @return
     */
    public int getDeviceCount() {
        return deviceCount;
    }

    /**
     *
     * @param deviceCount
     */
    public void setDeviceCount(int deviceCount) {
        this.deviceCount = deviceCount;
    }

    /**
     *
     * @return
     */
    public Resolution getResolution() {
        return resolution;
    }

    /**
     *
     * @param resolution
     */
    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    /**
     * @return the timeTrans
     */
    public boolean isTimeTrans() {
        return timeTrans;
    }

    /**
     * @param timeTrans the timeTrans to set
     */
    public void setTimeTrans(boolean timeTrans) {
        this.timeTrans = timeTrans;
    }
}
