/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

/**
 *
 * @author kamil_2
 */
public class IdGenerator {
    private static volatile int idNumber = 0;


    /**
     * @param aIdNumber the idNumber to set
     */
    public synchronized static void setIdNumber(int aIdNumber) {
        idNumber = aIdNumber;
    }

    /**
     *
     * @return new, unique ID
     */
    public synchronized static int giveId() {
        return idNumber++;
    }

    /**
     *
     * @return
     */
    public synchronized static int getIdNumber() {
        return idNumber;
    }
}
