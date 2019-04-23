/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Multimedias.LiveStream;
import Multimedias.Movie;
import Multimedias.Multimedia;
import Multimedias.Series;
import java.io.Serializable;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import vod.Contract;
import vod.DataBase;
import vod.IdGenerator;
import vod.ProgressGenerator;

/**
 *
 * @author kamil_2
 */
public class Distributor extends Thread implements Serializable{
    /**
     * @return the id
     */
    public int getDistId() {
        return id;
    }
    /**
    *Creates new Object of class Distributor
    */
    public Distributor(){
        this.id = IdGenerator.giveId();
        this.name = "unknown";
        this.money = 0;
        this.bankAccount = "unknown";
        this.live = true;
        this.cont = new Contract(ProgressGenerator.getGenerator().nextInt(100));
        setDaemon(true);
    }
    private final int id;
    private String name;
    private String bankAccount;
    private float money;
    private static DataBase db;
    private boolean live;
    private Contract cont;
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
    public String getDistName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setDistName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     *
     * @param bankAccount
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     *
     * @return
     */
    public float getMoney() {
        return money;
    }

    /**
     *
     * @param money
     */
    public void setMoney(float money) {
        this.money = money;
    }

    /**
     * Create new products and renegociate contract
     */
    @Override
    public void run() {
        int lastMonth = ProgressGenerator.getDate().get(Calendar.MONTH);
        while(isLive()){
            int random = ProgressGenerator.getGenerator().nextInt(10000);
            try {
                Thread.sleep(random);
            } catch (InterruptedException ex) {
                Logger.getLogger(Distributor.class.getName()).log(Level.SEVERE, null, ex);
            }
            if( isLive() ){
                sendProduct();
                if(ProgressGenerator.getGenerator().nextInt(20) == 0 && 
                        lastMonth != ProgressGenerator.getDate().get(Calendar.MONTH)){// to let transaction live at least one month
                    lastMonth = ProgressGenerator.getDate().get(Calendar.MONTH);
                    renegociate();
                }
            }
            
        }
    }

    /**
     * Creating product and saving it in DataBase
     */
    public void sendProduct(){
        int random = ProgressGenerator.getGenerator().nextInt(10000);
        Multimedia mult;
        switch(ProgressGenerator.getGenerator().nextInt(3)){
            case 0: 
                mult = new Movie(this, random);
                break;
            case 1:
                mult = new Series(this, random);
                break;
            default:
                mult = new LiveStream(this, random);
        }
        getDb().getMultimedias().add(mult);
    }
    /**
     * change the contract
     */
    public void renegociate(){
        Contract contr = new Contract(ProgressGenerator.getGenerator().nextInt(100));
        getDb().getContracts().remove(getCont());
        getDb().getContracts().add(contr);
        setCont(contr);
    }

    /**
     * @return the live
     */
    public boolean isLive() {
        return live;
    }

    /**
     * @param live the live to set
     */
    public void setLive(boolean live) {
        this.live = live;
    }

    /**
     * @return the cont
     */
    public Contract getCont() {
        return cont;
    }

    /**
     * @param cont the cont to set
     */
    public void setCont(Contract cont) {
        this.cont = cont;
    }
}
