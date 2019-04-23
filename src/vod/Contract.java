/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import Users.Distributor;
import java.io.Serializable;

/**
 *
 * @author kamil_2
 */
public class Contract implements Serializable {
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
    *Creates new Object of class Contract
    */
    public Contract(){
        this.id = IdGenerator.giveId();
        this.lump_sum = true;
        this.price = 1000;
    }
    /**
    *Creates new Object of class Contract
     * @param random
    */
    public Contract(int random){
        this();
        if(random % 2  == 0){
            this.lump_sum = true;
            this.price += (random % 10) * 1000;
        }
        else{
            this.lump_sum = false;
            this.price = 5 + (random % 5);
        }
            
    }
    /**
    *Creates new Object of class Contract
     * @param dist
     * @param lumpsum
    */
    public Contract(Distributor dist, boolean lumpsum){
        this();
        this.lump_sum = lumpsum;
    }
    private final int id;
    private boolean lump_sum;
    private float price;
    

    /**
     *
     * @return
     */
    public boolean isLump_sum() {
        return lump_sum;
    }

    /**
     *
     * @param lump_sum
     */
    public void setLump_sum(boolean lump_sum) {
        this.lump_sum = lump_sum;
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
}
