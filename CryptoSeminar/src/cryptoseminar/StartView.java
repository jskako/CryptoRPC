/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptoseminar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.net.URL;
import java.util.List;
import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;

/**
 *
 * @author josips
 */
public class StartView extends javax.swing.JFrame {

    /**
     * Creates new form StartView
     */
    private Connection conn;
    private String username;
    static final String user = "student";
    static final String password = "WYVyF5DTERJASAiIiYGg4UkRH";
    static final String host = "blockchain.oss.unist.hr";
    static final String port = "8332";

    String[] arraypk = null;
    String[] arrayjk = null;

    int userID = 0;

    //Spajanje na bazu
    ResultSet RS = null;
    ExecuteScriptsOnDatabase CALIzb = new ExecuteScriptsOnDatabase();

    public StartView(Connection Conn, String Username) {
        this.conn = Conn;
        this.username = Username;
        initComponents();
        postaviUser();
    }

    private void postaviUser() {
        String ime = "";
        String prezime = "";
        try {
            //Dohvati ID
            RS = CALIzb.main(conn, "select F01IME, F01PRE from users where F01USR = '" + username + "'");
            while (RS.next()) {
                ime = RS.getString("F01IME");
                prezime = RS.getString("F01PRE");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        welcomeLabelText.setText("Welcome " + ime + " " + prezime + "  ( " + username + " )");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        blockExplorerPanel = new javax.swing.JPanel();
        blockButton = new javax.swing.JButton();
        welcomePane = new javax.swing.JPanel();
        blockchainWelcome = new javax.swing.JLabel();
        exitLabel = new javax.swing.JLabel();
        welcomeLabelText = new javax.swing.JLabel();
        passwordChangeButton = new javax.swing.JButton();
        blockchainTextLabel = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        blockExplorerPanel.setBackground(new java.awt.Color(209, 209, 209));

        blockButton.setText("ENTER");
        blockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout blockExplorerPanelLayout = new javax.swing.GroupLayout(blockExplorerPanel);
        blockExplorerPanel.setLayout(blockExplorerPanelLayout);
        blockExplorerPanelLayout.setHorizontalGroup(
            blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(blockButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        blockExplorerPanelLayout.setVerticalGroup(
            blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, blockExplorerPanelLayout.createSequentialGroup()
                .addContainerGap(373, Short.MAX_VALUE)
                .addComponent(blockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        welcomePane.setBackground(new java.awt.Color(232, 232, 232));

        blockchainWelcome.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        blockchainWelcome.setForeground(new java.awt.Color(255, 255, 255));
        blockchainWelcome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/shield.png"))); // NOI18N
        blockchainWelcome.setToolTipText("");

        exitLabel.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        exitLabel.setForeground(new java.awt.Color(255, 255, 255));
        exitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/rsz_exit.png"))); // NOI18N
        exitLabel.setToolTipText("");
        exitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabelMouseClicked(evt);
            }
        });

        welcomeLabelText.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        welcomeLabelText.setText("Welcome");

        passwordChangeButton.setText("Promjena šifre");
        passwordChangeButton.setToolTipText("");
        passwordChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordChangeButtonActionPerformed(evt);
            }
        });

        blockchainTextLabel.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        blockchainTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        blockchainTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        blockchainTextLabel.setText("Blockchain Explorer");

        javax.swing.GroupLayout welcomePaneLayout = new javax.swing.GroupLayout(welcomePane);
        welcomePane.setLayout(welcomePaneLayout);
        welcomePaneLayout.setHorizontalGroup(
            welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(blockchainWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blockchainTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                    .addGroup(welcomePaneLayout.createSequentialGroup()
                        .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(welcomeLabelText)
                            .addComponent(passwordChangeButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitLabel)))
                .addContainerGap())
        );
        welcomePaneLayout.setVerticalGroup(
            welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(welcomePaneLayout.createSequentialGroup()
                        .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exitLabel)
                            .addComponent(welcomeLabelText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordChangeButton)
                        .addGap(28, 28, 28)
                        .addComponent(blockchainTextLabel))
                    .addComponent(blockchainWelcome))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(blockExplorerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(welcomePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blockExplorerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseClicked
        LoginFormGUI CALLogin = new LoginFormGUI(conn);
        CALLogin.setLocationRelativeTo(null);
        CALLogin.setVisible(true);
        dispose();
    }//GEN-LAST:event_exitLabelMouseClicked

    private void passwordChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordChangeButtonActionPerformed
        UserPasswordChange CalPasC = new UserPasswordChange(conn, userID);
        CalPasC.setLocationRelativeTo(null);
        CalPasC.setVisible(true);
    }//GEN-LAST:event_passwordChangeButtonActionPerformed

    private void blockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockButtonActionPerformed
        try {
            String connection = "http://" + user + ':' + password + "@" + host + ":" + port + "/";
            System.out.println(connection);
            URL url = new URL(connection.trim());
            BitcoinJSONRPCClient client = new BitcoinJSONRPCClient(url);
            List<String> rawMempool = client.getRawMemPool();
            Double rawHex = client.getBalance("1KFHE7w8BhaENAswwryaoccDb6qcT6DbYY");
            System.out.println(Integer.toString(rawMempool.size()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_blockButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blockButton;
    private javax.swing.JPanel blockExplorerPanel;
    private javax.swing.JLabel blockchainTextLabel;
    private javax.swing.JLabel blockchainWelcome;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton passwordChangeButton;
    private javax.swing.JLabel welcomeLabelText;
    private javax.swing.JPanel welcomePane;
    // End of variables declaration//GEN-END:variables
}
