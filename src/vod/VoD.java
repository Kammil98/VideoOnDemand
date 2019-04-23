/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import Users.Distributor;
import Windows.AppWindow.AppFrame;
import Windows.ControlPanel.ControlFrame;
import java.util.List;

/**
 *
 * @author kamil_2
 */
public class VoD {
    
    private static void initial_Data(List<Distributor> distributors)
    {
        Distributor dist = new Distributor();
        dist.setDistName("Inea");
        dist.setBankAccount("05462917283459679432");
        dist.start();
        distributors.add(dist);
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        DataBase db = new DataBase();
        db.connectToOthers();
        ProgressGenerator time = new ProgressGenerator();
        time.start();
        initial_Data(db.getDistributors());
        ControlFrame.main();
        AppFrame.main();
    }

    
    
}
