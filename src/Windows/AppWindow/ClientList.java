/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows.AppWindow;

import Users.Client;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import vod.DataBase;

/**
 *
 * @author kamil_2
 */
public class ClientList extends javax.swing.JPanel {

    /**
     * @return the filtered
     */
    public List<Client> getFiltered() {
        return filtered;
    }

    /**
     * @param filtered the filtered to set
     */
    public void setFiltered(List<Client> filtered) {
        this.filtered = filtered;
    }
    /** 
     * Class created to block editability of cells in table
     */
    public class MyModel extends DefaultTableModel{
        /**
        * @param row
        * @param column
        * @return the db
        */
       @Override
       public boolean isCellEditable(int row, int column) {
          return false;
       }
    }
    
    /**
     *
     * @return
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
    
    private static DataBase db;
    private List<Client> filtered;
    
    /**
     * Creates new form ClientList
     */
    public ClientList() {
        initComponents();
        setFiltered(new ArrayList());
        getDb().semiDeepCopy(getDb().getClients(), filtered);
        setBounds(0, 0, 600, 500);
        setTable(getDb().getClients());
    }
    
    private void setTable(List<Client> newList){
        DefaultTableModel dtm = new MyModel();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        tClient.setModel(dtm);
        dtm.setColumnIdentifiers(new String[]{ "id", "nazwa", "numer karty", 
            "data urodzin", "e-mail"});
        newList.forEach((Client val) -> {
            dtm.addRow(new Object[] { val.getCltId(), val.getCltName(), val.getCardNumber(),
                formatter.format(val.getBirth().getTime()), 
                val.getEmail() });
        });
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

        bBack = new javax.swing.JButton();
        bChoose = new javax.swing.JButton();
        tElement = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tClient = new javax.swing.JTable();

        bBack.setText("Powrot");
        bBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBackActionPerformed(evt);
            }
        });

        bChoose.setText("Wybierz");
        bChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChooseActionPerformed(evt);
            }
        });

        jLabel1.setText("Wyszukaj po nazwie");

        bSearch.setText("Szukaj");
        bSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSearchActionPerformed(evt);
            }
        });

        tClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "nazwa", "numer karty", "data urodzin", "email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tClient.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tClient);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(bBack, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(tElement, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSearch)
                    .addComponent(tElement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bChoose)
                    .addComponent(bBack))
                .addContainerGap(52, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackActionPerformed
        swapPanels(new MainAppPanel());
    }//GEN-LAST:event_bBackActionPerformed

    private void bSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchActionPerformed
        getFiltered().clear();
        getDb().semiDeepCopy(getDb().getClients(), filtered);
        getDb().findClientsByName(getFiltered(), tElement.getText());
        setTable(getFiltered());
    }//GEN-LAST:event_bSearchActionPerformed

    private void bChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bChooseActionPerformed
        if(tClient.getSelectedRowCount() != 1 || tClient.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Należy wybrać dokładnie jednego klienta.");
        }
        else{
            int id = Integer.valueOf(String.valueOf(tClient.getValueAt(tClient.getSelectedRow(), 0)));
            Client clt = getDb().findClientById(id );
            swapPanels(new CltDetails(clt));
        }
    }//GEN-LAST:event_bChooseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBack;
    private javax.swing.JButton bChoose;
    private javax.swing.JButton bSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tClient;
    private javax.swing.JTextField tElement;
    // End of variables declaration//GEN-END:variables
}