package Multimedias;


import Users.Distributor;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import vod.NamesBase;
import vod.ProgressGenerator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kamil_2
 */
public class LiveStream extends Multimedia implements Serializable{

    /**
     * Creates new Object of class LiveStream
     */
    public LiveStream(){
        super();
        super.setImgPath("pictures\\liveStream.jpg");
        this.streamTime = Calendar.getInstance();
        this.price = 10;
        this.promotion = null;
    }
    /**
     * Creates new Object of class LiveStream
     * @param distributor
     */
    public LiveStream(Distributor distributor){
        this();
        super.setDistributor(distributor);
    }
    /**
     * Creates new Object of class LiveStream
     * @param distributor
     * @param random
     */
    public LiveStream(Distributor distributor, int random){
        super(distributor, random);
        super.setName(NamesBase.getLsNames()[random % NamesBase.getLsNames().length]);
        super.setImgPath("pictures\\liveStream.jpg");
        this.streamTime = Calendar.getInstance();
        this.streamTime.set(Calendar.DAY_OF_MONTH, ProgressGenerator.getDate().get(Calendar.DAY_OF_MONTH));
        this.streamTime.set(Calendar.MONTH, ProgressGenerator.getDate().get(Calendar.MONTH));
        this.streamTime.set(Calendar.YEAR, ProgressGenerator.getDate().get(Calendar.YEAR));
        this.price = random % 10 + 15;
        if(random % 2 == 0) 
            this.promotion = new Promotion(random);
        else 
            this.promotion = null;
    }
    private float price;
    private Calendar streamTime; 
    private Promotion promotion;
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
    public Calendar getStreamTime() {
        return streamTime;
    }

    /**
     *
     * @param streamTime
     */
    public void setStreamTime(Calendar streamTime) {
        this.streamTime = streamTime;
    }
    
    /**
     * shows Live Stream on Console
     */
    @Override
    public void show(){
       super.show();
       SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(formatter.format(streamTime.getTime()) + " " + price);
    }
}
