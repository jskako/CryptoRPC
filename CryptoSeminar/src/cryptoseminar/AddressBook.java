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
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import net.proteanit.sql.DbUtils;
import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;

/**
 *
 * @author josips
 */
public class AddressBook extends javax.swing.JFrame {

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

    public AddressBook(Connection Conn, String UID) throws IOException {
        this.conn = Conn;
        this.uID = UID;
        initComponents();
        getAdrr();
        AddActionListener();
    }

    private void getAdrr() throws MalformedURLException, IOException {
        
        RS = CALIzb.main(conn, "Select F04ID as ID, F04ADDRESS as Address from AddressBook where F04USR = '"+uID.trim()+"'");
        adrTable.setModel(DbUtils.resultSetToTableModel(RS));
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
                    try {
                        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                            Desktop.getDesktop().browse(new URI("https://www.blockchain.com/btc/address/" + rowClicked.trim()));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        adrTable = new javax.swing.JTable();

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
        jScrollPane2.setViewportView(adrTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable adrTable;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
