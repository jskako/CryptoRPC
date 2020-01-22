/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptoseminar;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;

/**
 *
 * @author josips
 */
public class ViewAdr extends javax.swing.JFrame {

    /**
     * Creates new form ViewAdr
     */
    String height;
    List<String> addrList;
    String rowClicked;
    BitcoinJSONRPCClient client;
    Connection conn;
    String uID;
    //Spajanje na bazu
    ResultSet RS = null;
    ExecuteScriptsOnDatabase CALIzb = new ExecuteScriptsOnDatabase();

    public ViewAdr(String Hight, BitcoinJSONRPCClient Client, Connection Conn, String UID) throws IOException {
        this.height = Hight;
        this.client = Client;
        this.conn = Conn;
        this.uID = UID;
        initComponents();
        if (!height.trim().equals("")) {
            getAdrr();
            AddActionListener();
        }
    }

    private void getAdrr() throws MalformedURLException, IOException {
        String outStr = new Scanner(new URL("https://blockchain.info/block-height/" + height.trim() + "?format=json").openStream(), "UTF-8").useDelimiter("\\A").next();
        addrList = new ArrayList<>();
        // json is the String representing the input json
        JSONObject jsonObj = new JSONObject(outStr);
        JSONArray blocks = jsonObj.getJSONArray("blocks");
        for (int i = 0; i < blocks.length(); i++) {
            JSONObject block = blocks.getJSONObject(i);
            JSONArray tx = block.getJSONArray("tx");
            for (int j = 0; j < tx.length(); j++) {
                JSONObject txItem = tx.getJSONObject(j);
                JSONArray out = txItem.getJSONArray("out");
                for (int k = 0; k < out.length(); k++) {
                    JSONObject outItem = out.getJSONObject(k);
                    if (outItem.has("addr")) {
                        addrList.add(outItem.getString("addr"));
                    }
                }
            }
        }
        //addrList.forEach(item -> System.out.println(item));
        DefaultTableModel model = (DefaultTableModel) adrTable.getModel();
        ispisListe(model);
    }

    private void ispisListe(DefaultTableModel model) {
        for (int i = 0; i < addrList.size(); i++) {
            String index = addrList.get(i);
            Object[] data = {index};
            model.addRow(data);
        }
    }

    private void AddActionListener() {
        adrTable.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                //Get row to int
                try {
                    if (adrTable.getValueAt(adrTable.getSelectedRow(), 0).toString() != null) {
                        rowClicked = adrTable.getValueAt(adrTable.getSelectedRow(), 0).toString();
                    }
                } catch (NullPointerException e) {
                    System.out.println("NULL");
                }
                System.out.println(rowClicked);
                if (!rowClicked.trim().equals("")) {

                    //nothing
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        adrTable = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        addressBook = new javax.swing.JButton();
        view = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        adrTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Address"
            }
        ));
        adrTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adrTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(adrTable);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        addressBook.setText("Address Book");
        addressBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressBookActionPerformed(evt);
            }
        });

        view.setText("View");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addressBook, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressBook, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        RS = CALIzb.main(conn, "insert into AddressBook values ('" + uID.trim() + "','" + rowClicked.trim() + "');");

    }//GEN-LAST:event_saveButtonActionPerformed

    private void addressBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressBookActionPerformed
        AddressBook adb = null;
        try {
            adb = new AddressBook(conn, uID.trim());
        } catch (IOException ex) {
            Logger.getLogger(ViewAdr.class.getName()).log(Level.SEVERE, null, ex);
        }
        adb.setLocationRelativeTo(null);
        adb.setVisible(true);
    }//GEN-LAST:event_addressBookActionPerformed

    private void adrTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adrTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_adrTableMouseClicked

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("https://www.blockchain.com/btc/address/" + rowClicked.trim()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_viewActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addressBook;
    private javax.swing.JTable adrTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
