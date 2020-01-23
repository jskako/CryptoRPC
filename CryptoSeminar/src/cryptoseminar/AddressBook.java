/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptoseminar;

import java.io.IOException;
import java.net.MalformedURLException;
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
    int visible = 0;

    public AddressBook(Connection Conn, String UID) throws IOException {
        this.conn = Conn;
        this.uID = UID;
        initComponents();
        getAdrr();
        AddActionListener();
        addSetVisible();
    }

    private void addSetVisible() {
        addLabel.setVisible(false);
        addressText.setVisible(false);
        confirm.setVisible(false);
    }

    private void getAdrr() throws MalformedURLException, IOException {

        RS = CALIzb.main(conn, "Select F04ID as ID, F04ADDRESS as Address from AddressBook where F04USR = '" + uID.trim() + "'");
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
                    //Akcija
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        adrTable = new javax.swing.JTable();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        qr = new javax.swing.JButton();
        addressText = new javax.swing.JTextField();
        confirm = new javax.swing.JButton();
        addLabel = new javax.swing.JLabel();

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

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        qr.setText("QR generator");

        confirm.setText("Confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        addLabel.setText("Address");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(qr, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addLabel)
                        .addGap(18, 18, 18)
                        .addComponent(addressText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirm)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(add)
                    .addComponent(qr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirm)
                    .addComponent(addLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        RS = CALIzb.main(conn, "delete from AddressBook where F04ID = '" + rowClicked.trim() + "'");
        PopError CALError = new PopError();
        CALError.infoBox("Address deleted!", "Error!");
        dispose();
    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        if (visible == 0) {
            addLabel.setVisible(true);
            addressText.setVisible(true);
            confirm.setVisible(true);
            visible = 1;
        } else {
            addLabel.setVisible(false);
            addressText.setVisible(false);
            confirm.setVisible(false);
            visible = 0;
        }
    }//GEN-LAST:event_addActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        if (!addressText.getText().trim().equals("")) {
            RS = CALIzb.main(conn, "insert into AddressBook values ('" + uID.trim() + "','" + addressText.getText().trim() + "');");
            PopError CALError = new PopError();
            CALError.infoBox("Address has been added!", "Success!");
            dispose();
        } else {
            PopError CALError = new PopError();
            CALError.infoBox("Address field is empty!", "Error!");
        }
    }//GEN-LAST:event_confirmActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel addLabel;
    private javax.swing.JTextField addressText;
    private javax.swing.JTable adrTable;
    private javax.swing.JButton confirm;
    private javax.swing.JButton delete;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton qr;
    // End of variables declaration//GEN-END:variables
}
