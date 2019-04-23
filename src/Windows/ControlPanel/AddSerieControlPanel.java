/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows.ControlPanel;

import Multimedias.Episode;
import Multimedias.Multimedia;
import Multimedias.Season;
import Multimedias.Series;
import Multimedias.Series.Type;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import vod.DataBase;

/**
 *
 * @author kamil_2
 */
public class AddSerieControlPanel extends javax.swing.JPanel {

    /**
     * @return the serie
     */
    public Series getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(Series serie) {
        this.serie = serie;
    }

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

    
    private Series serie;
    private static DataBase db;
    /**
     * Creates new form AddSerieControlPanel
     */
    public AddSerieControlPanel() {
        initComponents();
        setBounds(0, 0, 600, 500);
        SpinnerModel model = new SpinnerNumberModel(1, 1, 300, 1);
        sTime.setModel(model);
        cbType.setModel(new DefaultComboBoxModel<>(Type.values()));
    }
    /**
     * Creates new form AddSerieControlPanel
     * @param multimediaa
     */
    public AddSerieControlPanel(Multimedia multimediaa) {
        this();
        serie = (Series) multimediaa;
    }
    /**
     * swaping current with given JPanel
     */
    private void swapPanels(JPanel panel){
        setVisible(false);
        getParent().add(panel);
        panel.setVisible(true);  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbType = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tActor = new javax.swing.JTextField();
        bAddActor = new javax.swing.JButton();
        bBack = new javax.swing.JButton();
        bAdd = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        bAddEpisode = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbYear = new javax.swing.JComboBox<>();
        cbDay = new javax.swing.JComboBox<>();
        cbMonth = new javax.swing.JComboBox<>();
        bAddSeason = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        sTime = new javax.swing.JSpinner();

        setPreferredSize(new java.awt.Dimension(600, 500));

        jLabel2.setText("Typ filmu");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Dodawanie serialu");

        jLabel3.setText("Cena PLN(grosze po kropce)*");

        jLabel4.setText("Aktor (jeden na raz)");

        bAddActor.setText("Dodaj Kolejnego Aktora");
        bAddActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActorActionPerformed(evt);
            }
        });

        bBack.setText("Cofnij");
        bBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBackActionPerformed(evt);
            }
        });

        bAdd.setText("Dodaj");
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });

        jLabel9.setText("*wymagane pola");

        bAddEpisode.setText("Dodaj odcinek do Sezonu");
        bAddEpisode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddEpisodeActionPerformed(evt);
            }
        });

        jLabel5.setText("Dlugosc odcinka(w minutach)");

        jLabel6.setText("Premiera odcinka");

        cbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "rok", "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018" }));

        cbDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dzien", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbDay.setToolTipText("");

        cbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Miesiac", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        bAddSeason.setText("Dodaj Sezon**");
        bAddSeason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddSeasonActionPerformed(evt);
            }
        });

        jLabel7.setText("<html>**Wszystkie później dodane odcinki <br>będą wliczane do kolejnego sezonu</html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(bAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bBack, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(bAddSeason)
                .addGap(104, 104, 104))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tActor)
                                    .addComponent(tPrice)
                                    .addComponent(cbType, 0, 141, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bAddActor, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(sTime, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(bAddEpisode, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(179, 179, 179))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tActor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bAddActor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bAddEpisode)
                                .addComponent(sTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAddSeason)
                        .addGap(25, 25, 25)))
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bBack, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Check if the Data for Episode have proper values and saving 
     * values in serie + return true if it's proper or return false it's not
     */
    private boolean takeEpisodesData(){
        if(cbDay.getSelectedIndex() <= 0 || cbMonth.getSelectedIndex() <= 0 || 
                cbYear.getSelectedIndex() <= 0){
            return false;
        }
        else{
            Calendar premiere = Calendar.getInstance();
            Episode epi;
            premiere.set(Calendar.YEAR, cbYear.getSelectedIndex() + 1899);
            premiere.set(Calendar.MONTH, cbMonth.getSelectedIndex());
            premiere.set(Calendar.DAY_OF_MONTH, cbDay.getSelectedIndex());
            epi = new Episode(premiere, (int) sTime.getValue());
            getSerie().getSeason(getSerie().getSeasones().size()-1).addEpisode(epi);
            cbDay.setSelectedIndex(0);
            cbMonth.setSelectedIndex(0);
            cbYear.setSelectedIndex(0);
            sTime.setValue(1);
        }
        return true;
    }
    /**
     * Check if the Data have proper values and saving values in serie if it's proper 
     * or send notifications for user if it's not
     */
    private boolean takeData(){
        try{
            getSerie().setPrice(Float.parseFloat(tPrice.getText()));
            if(!tActor.getText().equals(""));
                getSerie().setActor(tActor.getText());
            takeEpisodesData();
        }
        catch(NullPointerException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Proszę sprawdzić, czy wszystkie wymagane pola, \nzostały wypełnione poprawnie.");
            return false;
        }
        getSerie().setType((Type)cbType.getSelectedItem());
        return true;
    }
    private void bAddActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActorActionPerformed
        if(tActor.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Nie wpisano aktora, proszę wypelnić pole \"Aktor\".");
        }
        else{
            getSerie().setActor(tActor.getText());
            tActor.setText("");
        }
    }//GEN-LAST:event_bAddActorActionPerformed

    private void bBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackActionPerformed
        swapPanels(new AddMultimediaControlPanel(getSerie(), true));
    }//GEN-LAST:event_bBackActionPerformed

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        if(takeData()){
            getDb().getMultimedias().add(getSerie());
            swapPanels(new MainControlPanel());
        }
    }//GEN-LAST:event_bAddActionPerformed

    private void bAddSeasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddSeasonActionPerformed
        takeEpisodesData();
        getSerie().getSeasones().add(new Season());
    }//GEN-LAST:event_bAddSeasonActionPerformed

    private void bAddEpisodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddEpisodeActionPerformed
        if(!takeEpisodesData()){
            JOptionPane.showMessageDialog(null, "Proszę sprawdzić, czy wszystkie wymagane pola, \nzostały wypełnione poprawnie.");
        }
    }//GEN-LAST:event_bAddEpisodeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bAddActor;
    private javax.swing.JButton bAddEpisode;
    private javax.swing.JButton bAddSeason;
    private javax.swing.JButton bBack;
    private javax.swing.JComboBox<String> cbDay;
    private javax.swing.JComboBox<String> cbMonth;
    private javax.swing.JComboBox<Type> cbType;
    private javax.swing.JComboBox<String> cbYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner sTime;
    private javax.swing.JTextField tActor;
    private javax.swing.JTextField tPrice;
    // End of variables declaration//GEN-END:variables
}