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
import Windows.AppWindow.AppFrame;
import Windows.ControlPanel.ControlFrame;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * keeps all Data in system
 * @author kamil_2
 */
public class DataBase implements Serializable{

    /**
     * Create new Object of class DataBase
     */
    public DataBase() {
        this.contracts = new ArrayList();
        this.transactions = new ArrayList();
        this.multimedias = new ArrayList();
        this.clients = new ArrayList();
        this.date = Calendar.getInstance();
        this.distributors = new ArrayList();
        this.balance = 0;
        this.Balancechanging = new Object();
        this.SubPrices = new float[3];
        SubPrices[0] = 100;
        SubPrices[1] = 200;
        SubPrices[2] = 300;
    }
    void connectToOthers(){
        Distributor.setDb(this);
        ProgressGenerator.setDb(this);
        Client.setDb(this);
        Transaction.setDb(this);
        ControlFrame.setDb(this);
        AppFrame.setDb(this);
    }
    /**
     * @return the transactions
     */
    public synchronized List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * @param transactions the transactions to set
     */
    public synchronized void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * @return the contracts
     */
    public synchronized List<Contract> getContracts() {
        return contracts;
    }

    /**
     * @param contracts the contracts to set
     */
    public synchronized void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    /**
     * @return the date
     */
    public synchronized Calendar getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public synchronized void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * @return the distributors
     */
    public synchronized List<Distributor> getDistributors() {
        return distributors;
    }

    /**
     * @param distributors the distributors to set
     */
    public synchronized void setDistributors(List<Distributor> distributors) {
        this.distributors = distributors;
    }

    /**
     * @return the clients
     */
    public synchronized List<Client> getClients() {
        return clients;
    }

    /**
     * @param clients the clients to set
     */
    public synchronized void setClients(List<Client> clients) {
        this.clients = clients;
    }

    /**
     * @return the multimedias
     */
    public synchronized List<Multimedia> getMultimedias() {
        return multimedias;
    }

    /**
     * @param multimedias the multimedias to set
     */
    public synchronized void setMultimedias(List<Multimedia> multimedias) {
        this.multimedias = multimedias;
    }
    private Calendar date;
    private float balance;
    private List<Distributor> distributors;
    private List<Client> clients;
    private List<Multimedia> multimedias;
    private List<Transaction> transactions;
    private List<Contract> contracts;
    private float SubPrices[];
    transient private Object Balancechanging;
    
    /**
     * half-deep copy  of oldList to newList - the same objects, but another List
     * @param <T>
     * @param oldList
     * @param newList
     */
    public<T> void semiDeepCopy(List<T> oldList, List<T> newList){
        oldList.forEach(newList::add);
    }
    
    /**
     * Finding index of first Distributor with given name
     * @param name
     * @return
     */
    public int findDistIndex(String name){
        Distributor dist;
        for (int i = 0; i < getDistributors().size(); i++) {
            dist = getDistributors().get(i);
            if( dist.getDistName().equals(name)){
                return i;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Nie znalazlem Dystrybutora o takim id :(");
    }

    /**
     * Finding first Distributor with given name and return him as a 
     * Object of type Distributor
     * @param name
     * @return
     */
    public Distributor findDist(String name){
        Distributor dist;
        for (int i = 0; i < getDistributors().size(); i++) {
            dist = getDistributors().get(i);
            if( dist.getDistName().equals(name)){
                return dist;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Nie znalazlem Dystrybutora:(");
    }
    
    /**
     * Finding first Distributor with given id and return him as a 
     * Object of type Distributor
     * throw ArrayIndexOutOfBoundsException if didn't found any Transaction
     * @param id
     * @return
     */
    public Distributor findDistById(int id){
        Distributor dist;
        for (int i = 0; i < getDistributors().size(); i++) {
            dist = getDistributors().get(i);
            if( dist.getDistId() == id){
                return dist;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Nie znalazlem Dystrybutora o takim id :(");
    }
    
    /**
     * Finding first Client with given id and return him as a 
     * Object of type Client
     * throw ArrayIndexOutOfBoundsException if didn't found any Transaction
     * @param id
     * @return
     */
    public Client findClientById(int id){
        Client client;
        for (int i = 0; i < getClients().size(); i++) {
            client = getClients().get(i);
            if( client.getCltId() == id){
                return client;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Nie znalazlem Klienta o takim id :(");
    }
    
    /**
     * Finding first Multimedia with given id and return it as a 
     * Object of type Multimedia
     * throw ArrayIndexOutOfBoundsException if didn't found any Transaction
     * @param id
     * @return
     */
    public Multimedia findMultById(int id){
        Multimedia mult;
        for (int i = 0; i < getMultimedias().size(); i++) {
            mult = getMultimedias().get(i);
            if( mult.getId() == id){
                return mult;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Nie znalazlem Produktu o takim id :(");
    }
    
    /**
     * Finding first Transaction with given id and return it as a 
     * Object of type Transaction
     * throw ArrayIndexOutOfBoundsException if didn't found any Transaction
     * @param id
     * @return
     */
    public Transaction findTransactionById(int id){
        Transaction trans;
        for (int i = 0; i < getTransactions().size(); i++) {
            trans = getTransactions().get(i);
            if( trans.getId() == id){
                return trans;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Nie znalazlem tranzakcji o takim id :(");
    }
    
    /**
     * Finding first Contract with given id and return it as a 
     * Object of type Contract
     * @param id
     * @return
     * throw ArrayIndexOutOfBoundsException if didn't found any Transaction
     */
    public Contract findContractById(int id){
        Contract contr;
        for (int i = 0; i < getContracts().size(); i++) {
            contr = getContracts().get(i);
            if( contr.getId() == id){
                return contr;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Nie znalazlem kontraktu o takim id :(");
    }
    
    /**
     * finding Mutlimedias fitting to choosed types
     * @param filtered
     * @param movies
     * @param series
     * @param ls
     */
    public void filterTypes(List<Multimedia> filtered, boolean movies, boolean series, boolean ls){
        for(int i  = filtered.size() - 1; i >= 0; i-- ){
            if((!movies && filtered.get(i) instanceof Movie) ||
               (!series && filtered.get(i) instanceof Series) ||
               (!ls && filtered.get(i) instanceof LiveStream) )
                filtered.remove(i);
        }
    }

    private<T> void filterByNames(List<T> filtered, List<String> names, String name){
        for(int i  = filtered.size() - 1; i >= 0; i-- ){
           if(!names.get(i).contains(name))
               filtered.remove(i);
        }
    }
    
    /**
     * finding Mutlimedias fitting to choosed types and with choosed name
     * @param filtered
     * @param name
     * @param movies
     * @param series
     * @param LS
     */
    public void findMultByName(List<Multimedia> filtered, String name, boolean movies, boolean series, boolean LS){
        List<String> names = new ArrayList();
        filterTypes(filtered, movies, series, LS);
        for(int i  = 0; i < filtered.size() ; i++ ){
           names.add(filtered.get(i).getName());
        }
        filterByNames(filtered, names, name);
    }

    /**
     *  finding Distributor with choosed name
     * @param filtered
     * @param name
     */
    public void findDistByName(List<Distributor> filtered, String name){
        List<String> names = new ArrayList();
        for(int i  = 0; i < filtered.size() ; i++){
           names.add(filtered.get(i).getDistName());
        }
        filterByNames(filtered, names, name);
    }

    /**
     * finding Clients with choosed name
     * @param filtered
     * @param name
     */
    public void findClientsByName(List<Client> filtered, String name){
        List<String> names = new ArrayList();
        for(int i  = 0; i < filtered.size() ; i++){
           names.add(filtered.get(i).getCltName());
        }
        filterByNames(filtered, names, name);
    }

    /**
     * finding Mutlimedias fitting to choosed types and with choosed actor
     * @param filtered
     * @param actor
     * @param movies
     * @param series
     */
    public void findMultByActor(List<Multimedia> filtered, String actor, boolean movies, boolean series){
        filterTypes(filtered, movies, series, false);
        Multimedia mult;
        boolean contain;
        List<String> actorsList = new ArrayList(); 
        for(int i  = filtered.size() - 1; i >= 0; i-- ){
            contain = false;
            mult = filtered.get(i);
            if(mult instanceof Movie){
                actorsList = ((Movie) mult).getActors();
            }
            else
                if(mult instanceof Series)
                actorsList = ((Series) mult).getActors();
            for(int j = actorsList.size() - 1; j >=0; j--){
                if(actorsList.get(j).contains(actor))
                    contain = true;
            }
            if(!contain)
                filtered.remove(i);
        }
    }
    /**
     * save DatabBase to file
     */
    public synchronized void serializeAll(){
        ObjectOutputStream outputStream;
        try{
            outputStream = new ObjectOutputStream(new BufferedOutputStream (new FileOutputStream("dataBase.bin")));
            outputStream.writeInt(IdGenerator.getIdNumber());
            outputStream.writeObject(ProgressGenerator.getDate());
            outputStream.writeObject(this);
            outputStream.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Nie udalo sie uzyskac dostepu do pliku ");
        }
        catch(IOException e){
            System.out.println("Jestem w serializacji  wyskoczyl wyjatek "
                    + "IOException " + e.getMessage());
        }
    }
    /**
     * load DatabBase from file
     */
    public synchronized void deserializeAll(){
        ObjectInputStream inputStream;
        DataBase db = new DataBase();
        getDistributors().forEach((Distributor val) ->{//to kill threads
            val.setLive(false);
        });
        getClients().forEach((Client val) ->{//to kill threads
            val.setLive(false);
        });
        try{
            inputStream = new ObjectInputStream(new BufferedInputStream (new FileInputStream("dataBase.bin")));
            IdGenerator.setIdNumber(inputStream.readInt());
            ProgressGenerator.setDate((Calendar)inputStream.readObject());
            db = (DataBase)inputStream.readObject();
            inputStream.close();
        }
        catch(InvalidClassException e){
            System.out.println("W deserializacji wyskoczyl wyjatek InvalidClassException "
                    + e.getMessage());
        }
        catch(StreamCorruptedException e){
            System.out.println("W deserializacji wyskoczyl wyjatek StreamCorruptedException "
                    + e.getMessage());
        }
        catch(OptionalDataException e){
            System.out.println("W deserializacji wyskoczyl wyjatek OptionalDataException "
                    + e.getMessage());
        }
        catch(FileNotFoundException e){
            System.out.println("Nie udalo sie uzyskac dostepu do pliku");
        }
        catch(IOException e){
            System.out.println("W deserializacji wyskoczyl wyjatek IOException ");
        }
        catch(ClassNotFoundException e){
            System.out.println("W deserializacji wyskoczyl wyjatek "
                    + "ClassNotFoundException" + e.getMessage());
        }
        db.setBalancechanging(new Object());
        this.setMultimedias(db.getMultimedias());
        this.setDistributors(db.getDistributors());
        this.setClients(db.getClients());
        this.setContracts(db.getContracts());
        this.setTransactions(db.getTransactions());
        this.setDate(db.getDate());
        this.setBalance(db.getBalance());
        connectToOthers();
        getDistributors().forEach((Distributor val) ->{
            val.start();
        });
        getClients().forEach((Client val) ->{
            val.start();
        });
    }

    /**
     * check if the simulation earn money
     * @return
     */
    public boolean profitability(){
        return false;
    }
    
    /**
     * @return the balance
     */
    public float getBalance() {
        synchronized(getBalancechanging()){
            return balance;
        }
    }
    /**
     * adding int value to Balance
     * @param val
     */
    public void addIntToBalance(int val) {
        synchronized(getBalancechanging()){
            setBalance(getBalance() + ((float)val));
        }
    }
    /**
     * adding float value to Balance
     * @param val
     */
    public void addFloatToBalance(float val) {
        synchronized(getBalancechanging()){
            setBalance(getBalance() + val);
        }
    }
    /**
     * @param balance the balance to set
     */
    public void setBalance(float balance) {
        synchronized(getBalancechanging()){
            this.balance = balance;
        }
    }

    /**
     * @return the Balancechanging
     */
    public Object getBalancechanging() {
        return Balancechanging;
    }

    /**
     * @param Balancechanging the Balancechanging to set
     */
    public void setBalancechanging(Object Balancechanging) {
        this.Balancechanging = Balancechanging;
    }

    /**
     * @return the SubPrices
     */
    public float[] getSubPrices() {
        return SubPrices;
    }

    /**
     * @param SubPrices the SubPrices to set
     */
    public void setSubPrices(float[] SubPrices) {
        this.SubPrices = SubPrices;
    }
} 
