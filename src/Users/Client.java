/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Multimedias.LiveStream;
import Multimedias.Movie;
import Multimedias.Multimedia;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import vod.DataBase;
import vod.IdGenerator;
import vod.NamesBase;
import vod.ProgressGenerator;
import vod.Transaction;

/**
 *
 * @author kamil_2
 */
public class Client extends Thread implements Serializable {

    /**
     * @return the id
     */
    public int getCltId() {
        return id;
    }
    /**
    *Creates new Object of class Client
    */
    
    public Client(){
        this.id = IdGenerator.giveId();
        this.birth = Calendar.getInstance();
        this.name = "unknown";
        this.nickname = "unknown";
        this.code = "unknown";
        this.email = "unknown";
        this.cardNumber = "unknown";
        this.tran = null;
        this.live = true;
    }

    /**
     * @param random
     */
    public Client(int random){
        this();
        this.name = NamesBase.getCltNames()[random % NamesBase.getCltNames().length];
        this.nickname = NamesBase.getCltNames()[(random * 2) % NamesBase.getCltNames().length];
        this.code = "";
        for(int i = 1; i < random % 11 + 5; i++)
            this.code += (char)((random * i) % (125 - 32) + 32);
        this.birth.set(Calendar.YEAR, random % 119 + 1899);
        this.birth.set(Calendar.MONTH, random % 12 );
        this.birth.set(Calendar.DAY_OF_MONTH, random % 28 );
        this.email = name + "." + nickname + "@gmail.com";
        this.cardNumber = "";
        Random generator = new Random();
        for(int i = 1; i < 21; i++){
            this.cardNumber += (char)(generator.nextInt(10000) % 10 + 48);
        }
    }
//    private static int number;
    private final int id;
    private String name;
    private String nickname;
    private String code;
    private Calendar birth;
    private String email;
    private String cardNumber;
    private Transaction tran;
    private boolean live;
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
    public String getCltName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setCltName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getNickname() {
        return nickname;
    }

    /**
     *
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public Calendar getBirth() {
        return birth;
    }

    /**
     *
     * @param birth
     */
    public void setBirth(Calendar birth) {
        this.birth = birth;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     *
     * @param cardNumber
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    /**
     * buy new product and create transaction conected with this product
     */
    public void createTransaction(){
        Multimedia mult;
        int index;
        Transaction trans;
        
        if(!getDb().getMultimedias().isEmpty()){
            if(ProgressGenerator.getGenerator().nextInt(2) == 1){
                index = ProgressGenerator.getGenerator().nextInt(getDb().getMultimedias().size());
                mult = getDb().getMultimedias().get(index);
                trans = new Transaction(mult);
            }
            else{
                trans = new Transaction(ProgressGenerator.getGenerator().nextInt(3));
            }
            setTran(trans);
            getDb().getTransactions().add(trans);
        }
    }
    //paying to Distributor money if it's not lump sum
    private void payToDist(Multimedia mult){
        float price = 0;
        if(!mult.getDistributor().getCont().isLump_sum()){
            price = mult.getDistributor().getCont().getPrice();
        }
        getDb().addFloatToBalance(price * (-1));
    }
    /**
     * watching bought product
     * @return false if there is no bought products
     */
    public boolean watch(){
        Multimedia mult;
        List<Integer> viewership;
        if(getTran() == null){//There is no transaction
            return false;
        }
        if(getTran().isTimeTrans() && getTran().getValidityDate().compareTo(ProgressGenerator.getDate()) < 0 
                || getTran().getMultimedia() == null){//Transaction is out of date or product has been removed
            setTran(null);
            return false;
        }
        if(getTran().getSubscription() != Transaction.Subscription.OneTime){//There is Subscription to realize
            do{
                mult = getDb().getMultimedias().get(ProgressGenerator.getGenerator().nextInt(getDb().getMultimedias().size()));
            }while(mult instanceof LiveStream);
            viewership = mult.getViewership();
            viewership.set(viewership.size() - 1, viewership.get(viewership.size() - 1) + 1);
            payToDist(mult);
            
            return true;
        }
        //There is One time, with one possible watch Transaction to realize
        mult = getTran().getMultimedia();
        viewership = mult.getViewership();
        viewership.set(viewership.size() - 1, viewership.get(viewership.size() - 1) + 1);
        payToDist(mult);
        if(!(mult instanceof Movie)){
            getDb().getTransactions().remove(getTran());
            setTran(null);
        }
        return true;
    }

    /**
     * thread of Client
     * buy and consume products
     */
    @Override
    public void run() {
        while(live){
            try {
                Thread.sleep(ProgressGenerator.getGenerator().nextInt(10000));
                if(!watch()){
                    createTransaction();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
     * @return the tran
     */
    public Transaction getTran() {
        return tran;
    }

    /**
     * @param tran the tran to set
     */
    public void setTran(Transaction tran) {
        this.tran = tran;
    }
}
