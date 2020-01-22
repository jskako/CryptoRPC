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
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
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

    public ViewAdr(String Hight, BitcoinJSONRPCClient Client) throws IOException {
        this.height = Hight;
        this.client = Client;
        initComponents();
        getAdrr();
        AddActionListener();
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
                    try {
                        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                            Desktop.getDesktop().browse(new URI("https://www.blockchain.com/btc/address/"+rowClicked.trim()));
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
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
