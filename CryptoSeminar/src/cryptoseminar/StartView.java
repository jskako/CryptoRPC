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
        dohvatiKljuc();
        postavljanjeVarijable();
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

    private void postavljanjeVarijable() {
        pjkeyShow.setSelected(false);
        pjkeyShow.setText("Public key");
        pkey1.setVisible(false);
        pkey2.setVisible(false);
        jkey1.setVisible(true);
        jkey2.setVisible(true);
    }

    private void dohvatiKljuc() {
        // Provjera da li je user aktivan
        String privatniKljuc = null;
        String javniKljuc = null;
        try {
            //Dohvati ID
            RS = CALIzb.main(conn, "select F01ID from users where F01USR = '" + username + "'");
            while (RS.next()) {
                userID = RS.getInt("F01ID");
            }

            //Dohvati kljuceve
            RS = CALIzb.main(conn, "select F02PKEY, F02KEY from cryptokey where F02ID = '" + userID + "'");
            while (RS.next()) {
                privatniKljuc = RS.getString("F02PKEY");
                javniKljuc = RS.getString("F02KEY");
            }

            EncryptDecryptString KS = new EncryptDecryptString();

            privatniKljuc = KS.KriptirajString(privatniKljuc, 2);
            javniKljuc = KS.KriptirajString(javniKljuc, 2);

            String delimiter = ",";
            //Postavljanje privatnog kljuca
            arraypk = privatniKljuc.split(delimiter);
            pkey1.setText(arraypk[0]);
            pkey2.setText(arraypk[1]);
            //Postavljanje javnog kljuca
            arrayjk = javniKljuc.split(delimiter);
            jkey1.setText(arrayjk[0]);
            jkey2.setText(arrayjk[1]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        blockExplorerPanel = new javax.swing.JPanel();
        blockchainLabelPicture = new javax.swing.JLabel();
        blockchainTextLabel = new javax.swing.JLabel();
        blockButton = new javax.swing.JButton();
        walletPanel = new javax.swing.JPanel();
        walletLabelPicture = new javax.swing.JLabel();
        walletButton = new javax.swing.JButton();
        walletTextLabel = new javax.swing.JLabel();
        minePanel = new javax.swing.JPanel();
        mineLabelPicture = new javax.swing.JLabel();
        mineButton = new javax.swing.JButton();
        mineTextLabel = new javax.swing.JLabel();
        welcomePane = new javax.swing.JPanel();
        blockchainWelcome = new javax.swing.JLabel();
        exitLabel = new javax.swing.JLabel();
        welcomeLabelText = new javax.swing.JLabel();
        pkey1 = new javax.swing.JLabel();
        pkey2 = new javax.swing.JLabel();
        jkey1 = new javax.swing.JLabel();
        jkey2 = new javax.swing.JLabel();
        pjkeyShow = new javax.swing.JToggleButton();
        kopirajKeyButton = new javax.swing.JButton();
        passwordChangeButton = new javax.swing.JButton();

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

        blockchainLabelPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/blockchain.png"))); // NOI18N

        blockchainTextLabel.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        blockchainTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        blockchainTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        blockchainTextLabel.setText("Blockchain Explorer");

        blockButton.setText("ENTER");

        javax.swing.GroupLayout blockExplorerPanelLayout = new javax.swing.GroupLayout(blockExplorerPanel);
        blockExplorerPanel.setLayout(blockExplorerPanelLayout);
        blockExplorerPanelLayout.setHorizontalGroup(
            blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(blockButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(blockExplorerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, blockExplorerPanelLayout.createSequentialGroup()
                        .addComponent(blockchainTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(61, 61, 61))
                    .addGroup(blockExplorerPanelLayout.createSequentialGroup()
                        .addComponent(blockchainLabelPicture)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        blockExplorerPanelLayout.setVerticalGroup(
            blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, blockExplorerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(blockchainTextLabel)
                .addGap(32, 32, 32)
                .addComponent(blockchainLabelPicture)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(blockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        walletPanel.setBackground(new java.awt.Color(224, 122, 78));
        walletPanel.setPreferredSize(new java.awt.Dimension(351, 381));

        walletLabelPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/wallet.png"))); // NOI18N

        walletButton.setText("ENTER");

        walletTextLabel.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        walletTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        walletTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        walletTextLabel.setText("Wallet");

        javax.swing.GroupLayout walletPanelLayout = new javax.swing.GroupLayout(walletPanel);
        walletPanel.setLayout(walletPanelLayout);
        walletPanelLayout.setHorizontalGroup(
            walletPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(walletPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(walletPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(walletTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(walletPanelLayout.createSequentialGroup()
                        .addComponent(walletLabelPicture)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(walletButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        walletPanelLayout.setVerticalGroup(
            walletPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(walletPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(walletTextLabel)
                .addGap(18, 18, 18)
                .addComponent(walletLabelPicture)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(walletButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        minePanel.setBackground(new java.awt.Color(33, 39, 48));
        minePanel.setPreferredSize(new java.awt.Dimension(351, 381));

        mineLabelPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/mining.png"))); // NOI18N

        mineButton.setText("ENTER");
        mineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mineButtonActionPerformed(evt);
            }
        });

        mineTextLabel.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        mineTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        mineTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mineTextLabel.setText("Mine coins");

        javax.swing.GroupLayout minePanelLayout = new javax.swing.GroupLayout(minePanel);
        minePanel.setLayout(minePanelLayout);
        minePanelLayout.setHorizontalGroup(
            minePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(minePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(minePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mineTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(minePanelLayout.createSequentialGroup()
                        .addComponent(mineLabelPicture)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        minePanelLayout.setVerticalGroup(
            minePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(minePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mineTextLabel)
                .addGap(28, 28, 28)
                .addComponent(mineLabelPicture)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        pkey1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        pkey1.setText("Privatni kljuc: ");
        pkey1.setEnabled(false);

        pkey2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        pkey2.setText("Privatni kljuc: ");
        pkey2.setEnabled(false);

        jkey1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jkey1.setText("Javni kljuc:");
        jkey1.setEnabled(false);

        jkey2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jkey2.setText("Javni kljuc:");
        jkey2.setEnabled(false);

        pjkeyShow.setText("Privatni \\ Javni");
        pjkeyShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pjkeyShowActionPerformed(evt);
            }
        });

        kopirajKeyButton.setText("Kopiraj");
        kopirajKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kopirajKeyButtonActionPerformed(evt);
            }
        });

        passwordChangeButton.setText("Promjena šifre");
        passwordChangeButton.setToolTipText("");
        passwordChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordChangeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout welcomePaneLayout = new javax.swing.GroupLayout(welcomePane);
        welcomePane.setLayout(welcomePaneLayout);
        welcomePaneLayout.setHorizontalGroup(
            welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(blockchainWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(welcomePaneLayout.createSequentialGroup()
                        .addComponent(welcomeLabelText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitLabel))
                    .addGroup(welcomePaneLayout.createSequentialGroup()
                        .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(welcomePaneLayout.createSequentialGroup()
                                .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pkey2)
                                    .addComponent(pkey1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jkey1)
                                    .addComponent(jkey2)))
                            .addGroup(welcomePaneLayout.createSequentialGroup()
                                .addComponent(pjkeyShow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kopirajKeyButton)
                                .addGap(18, 18, 18)
                                .addComponent(passwordChangeButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        welcomePaneLayout.setVerticalGroup(
            welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(welcomePaneLayout.createSequentialGroup()
                        .addComponent(blockchainWelcome)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(welcomePaneLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exitLabel)
                            .addGroup(welcomePaneLayout.createSequentialGroup()
                                .addComponent(welcomeLabelText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pjkeyShow)
                                    .addComponent(kopirajKeyButton)
                                    .addComponent(passwordChangeButton))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pkey1)
                            .addComponent(jkey1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pkey2)
                            .addComponent(jkey2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(blockExplorerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(walletPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(welcomePane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(welcomePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(minePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                    .addComponent(blockExplorerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(walletPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)))
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

    private void pjkeyShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pjkeyShowActionPerformed
        // TODO add your handling code here:
        if (pjkeyShow.isSelected()) {
            //Prikazi privatni
            pjkeyShow.setText("Private key");
            pkey1.setVisible(true);
            pkey2.setVisible(true);
            jkey1.setVisible(false);
            jkey2.setVisible(false);
        } else {
            //Prikazi javni
            pjkeyShow.setText("Public key");
            pkey1.setVisible(false);
            pkey2.setVisible(false);
            jkey1.setVisible(true);
            jkey2.setVisible(true);
        }
    }//GEN-LAST:event_pjkeyShowActionPerformed

    private void kopirajKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kopirajKeyButtonActionPerformed
        String kljuc = "";
        if (pjkeyShow.isSelected()) {
            kljuc = pkey1.getText().trim() + "," + pkey2.getText().trim();
        } else {
            kljuc = jkey1.getText().trim() + "," + jkey2.getText().trim();
        }

        kljuc = kljuc.replaceAll("\\s", ""); //brisemo space (razmak)
        StringSelection stringSelection = new StringSelection(kljuc);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        PopError CALError = new PopError();
        CALError.infoBox(pjkeyShow.getText().trim() + " has been copied to clipboard!", "Success!");
    }//GEN-LAST:event_kopirajKeyButtonActionPerformed

    private void passwordChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordChangeButtonActionPerformed
        UserPasswordChange CalPasC = new UserPasswordChange(conn, userID);
        CalPasC.setLocationRelativeTo(null);
        CalPasC.setVisible(true);
    }//GEN-LAST:event_passwordChangeButtonActionPerformed

    private void mineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mineButtonActionPerformed
        try {
            String connection = "http://" + user + ':' + password + "@" + host + ":" + port + "/";
            System.out.println(connection);
            URL url = new URL(connection.trim());
            BitcoinJSONRPCClient client = new BitcoinJSONRPCClient(url);
            List<String> rawMempool = client.getRawMemPool();
            System.out.println(Integer.toString(rawMempool.size()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_mineButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blockButton;
    private javax.swing.JPanel blockExplorerPanel;
    private javax.swing.JLabel blockchainLabelPicture;
    private javax.swing.JLabel blockchainTextLabel;
    private javax.swing.JLabel blockchainWelcome;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jkey1;
    private javax.swing.JLabel jkey2;
    private javax.swing.JButton kopirajKeyButton;
    private javax.swing.JButton mineButton;
    private javax.swing.JLabel mineLabelPicture;
    private javax.swing.JPanel minePanel;
    private javax.swing.JLabel mineTextLabel;
    private javax.swing.JButton passwordChangeButton;
    private javax.swing.JToggleButton pjkeyShow;
    private javax.swing.JLabel pkey1;
    private javax.swing.JLabel pkey2;
    private javax.swing.JButton walletButton;
    private javax.swing.JLabel walletLabelPicture;
    private javax.swing.JPanel walletPanel;
    private javax.swing.JLabel walletTextLabel;
    private javax.swing.JLabel welcomeLabelText;
    private javax.swing.JPanel welcomePane;
    // End of variables declaration//GEN-END:variables
}
