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
import Users.Client;
import Users.Distributor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kamil_2
 */
public class ProgressGenerator extends Thread implements Serializable{
    
    /**
     * Create new object of class ProgressGenerator
     */
    public ProgressGenerator(){
        setGenerator(new Random());
        setStartDate(Calendar.getInstance());
        setDate(Calendar.getInstance());
        getDate().set(getDate().get(Calendar.YEAR), getDate().get(Calendar.MONTH), getDate().get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        setDaemon(true);
    }

    /**
     * Create new object of class ProgressGenerator
     * @param date2
     */
    public ProgressGenerator(Calendar date2){
        this();
        setStartDate(date2);
        setDate(getStartDate());
    }
    private static Random generator;
    private static volatile DataBase db;
    private static volatile Calendar date;
    private static volatile Calendar startDate;
    private static int debt;
    /**
     * @return the db
     */
    public DataBase getDb() {
        return db;
    }

    /**
     * @param dbb
     */
    public static void setDb(DataBase dbb) {
        db = dbb;
        setDebt(0);
    }
    
    /**
     * @return the date
     */
    public synchronized static Calendar getDate() {
        return date;
    }

    /**
     * @param aDate the date to set
     */
    public synchronized static void setDate(Calendar aDate) {
        date = aDate;
    }
    
    private synchronized void setNewClients(int n){
        Client clt;
        for(int i = 0; i < n; i++){
            clt = new Client(getGenerator().nextInt(10000));
            clt.start();
            getDb().getClients().add(clt);
        }
    }
    private void nextMonth(){
        getDb().getMultimedias().forEach((Multimedia val) -> {
            val.getViewership().add(0);
        });
        getDb().getDistributors().forEach((Distributor dist) ->{
            if(dist.getCont().isLump_sum()){
                getDb().addFloatToBalance(dist.getCont().getPrice() * (-1));
            }
        });
    }

    /**
     * thread, which add new clients, and change time
     */
    @Override
    public void run() {
        int currMult;
        float ClientsInc = 0;
        DecimalFormat df = new DecimalFormat("#.##");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        while(true){
            try {
                if(getDate().get(Calendar.DAY_OF_MONTH) == 1){
                    nextMonth();
                    if(getDb().getBalance() < 0)setDebt(getDebt() + 1);
                    else setDebt(0);
                    if(debt > 2){
                        JOptionPane.showMessageDialog(null, "Symulacja zakończyła się. Firma musiała zostać\n sprzedana w związku z długami.");
                        System.exit(0);
                    }
                }
                currMult = getDb().getMultimedias().size();
                ClientsInc += ((float)( currMult) / 10);
                if(ClientsInc > 1){
                    setNewClients((int)ClientsInc);
                    ClientsInc--;
                }
                Thread.sleep(1000);
                System.out.println("Data: " + formatter.format(getDate().getTime()));
                System.out.println("Bilans: " + df.format(getDb().getBalance()));
                getDate().add(Calendar.DATE, 1);
            } catch (InterruptedException ex) {
                System.out.println("Wyjatek w klasie ProgressGenerator");
                Logger.getLogger(ProgressGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the generator
     */
    public static Random getGenerator() {
        return generator;
    }

    /**
     * @param generator the generator to set
     */
    public final void setGenerator(Random generator) {
        ProgressGenerator.generator = generator;
    }

    /**
     * @return the startDate
     */
    public static Calendar getStartDate() {
        return startDate;
    }

    /**
     * @param aStartDate the startDate to set
     */
    public static void setStartDate(Calendar aStartDate) {
        startDate = aStartDate;
    }

    /**
     * @return the debt
     */
    public static int getDebt() {
        return debt;
    }

    /**
     * @param aDebt the debt to set
     */
    public static void setDebt(int aDebt) {
        debt = aDebt;
    }
}
