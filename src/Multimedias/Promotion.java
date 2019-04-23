/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multimedias;

import java.io.Serializable;
import java.util.Calendar;
import vod.IdGenerator;
import vod.ProgressGenerator;

/**
 *
 * @author kamil_2
 */
public class Promotion implements Serializable{
    
    /**
    * Creates new Object of class Promotion
    */
    public Promotion(){
        this.id = IdGenerator.giveId();
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.discount = 0;
    }
    /**
    * Creates new Object of class Promotion
     * @param from
     * @param to
     * @param discount
    */
    public Promotion(Calendar from, Calendar to, int discount){
        this.id = IdGenerator.giveId();
        this.from = from;
        this.to = to;
        this.discount = discount;
    }
    /**
    * Creates new Object of class Promotion
     * @param random random number, to initiate random values of fields
    */
    public Promotion(int random){
        this();
        Calendar today = Calendar.getInstance();
        synchronized(this){
            today = ProgressGenerator.getDate();
            from.set(Calendar.YEAR, today.get(Calendar.YEAR));
            from.set(Calendar.MONTH, today.get(Calendar.MONTH));
            from.set(Calendar.DAY_OF_MONTH, today.get(Calendar.DAY_OF_MONTH));
        }
        int last = random % 10, day, month, year;
        day = (from.get(Calendar.DAY_OF_MONTH) + last - 1) % 
                (from.getActualMaximum(Calendar.DAY_OF_MONTH)) + 1;
        if((from.get(Calendar.DAY_OF_MONTH) + last) > from.getActualMaximum(Calendar.DAY_OF_MONTH)){
            if(from.get(Calendar.MONTH) >= 11){
                month = 0;
                year = from.get(Calendar.YEAR) + 1;
            }
            else{
                month = from.get(Calendar.MONTH) + 1;
                year = from.get(Calendar.YEAR);
            }
        }
        else{
            month = from.get(Calendar.MONTH);
            year = from.get(Calendar.YEAR);
        }
        to.set(Calendar.DAY_OF_MONTH, day);
        to.set(Calendar.MONTH, month);
        to.set(Calendar.YEAR, year);
        discount = (random % 46 + 5);
    }
    private final int id;
    private Calendar from;
    private Calendar to;
    private int discount;
    /**
     *
     * @return
     */
    public Calendar getFrom() {return from;}

    /**
     *
     * @param from
     */
    public void setFrom(Calendar from) {this.from = from;}

    /**
     *
     * @return
     */
    public Calendar getTo() {
        return to;
    }

    /**
     *
     * @param to
     */
    public void setTo(Calendar to) {
        this.to = to;
    }

    /**
     *
     * @return
     */
    public int getDiscount() {
        return discount;
    }

    /**
     *
     * @param discount
     */
    public void setDiscount(int discount) {
        if(discount > 50) {
            this.discount = 50;
        }
        else {
            if( discount < 5) this.discount = 5;
            else {
                this.discount = discount;
            }
        }
    } 

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
}
