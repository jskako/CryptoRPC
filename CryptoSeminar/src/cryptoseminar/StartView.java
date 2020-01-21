/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptoseminar;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.Block;

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
    String connection;
    URL url;
    BitcoinJSONRPCClient client;
    String[] arraypk = null;
    String[] arrayjk = null;
    int userID = 0;
    //Spajanje na bazu
    ResultSet RS = null;
    ExecuteScriptsOnDatabase CALIzb = new ExecuteScriptsOnDatabase();
    ArrayList<String> dataList = new ArrayList<String>();

    public StartView(Connection Conn, String Username) {
        this.conn = Conn;
        this.username = Username;
        initComponents();
        postaviUser();
        spajanjeRPC();
    }

    private void spajanjeRPC() {
        try {
            connection = "http://" + user + ':' + password + "@" + host + ":" + port + "/";
            url = new URL(connection.trim());
            client = new BitcoinJSONRPCClient(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        hashTable = new javax.swing.JTable();
        welcomePane = new javax.swing.JPanel();
        blockchainWelcome = new javax.swing.JLabel();
        exitLabel = new javax.swing.JLabel();
        welcomeLabelText = new javax.swing.JLabel();
        passwordChangeButton = new javax.swing.JButton();
        blockchainTextLabel = new javax.swing.JLabel();
        heightTextField = new javax.swing.JTextField();
        heightLabel = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        depthLabel = new javax.swing.JLabel();
        depthTextField = new javax.swing.JTextField();

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

        hashTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Hash"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(hashTable);

        javax.swing.GroupLayout blockExplorerPanelLayout = new javax.swing.GroupLayout(blockExplorerPanel);
        blockExplorerPanel.setLayout(blockExplorerPanelLayout);
        blockExplorerPanelLayout.setHorizontalGroup(
            blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockExplorerPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        blockExplorerPanelLayout.setVerticalGroup(
            blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
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
        blockchainTextLabel.setText("Blockchain Explorer History");

        heightTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                heightTextFieldKeyTyped(evt);
            }
        });

        heightLabel.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        heightLabel.setText("Block height");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        depthLabel.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        depthLabel.setText("Block depth");

        depthTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                depthTextFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout welcomePaneLayout = new javax.swing.GroupLayout(welcomePane);
        welcomePane.setLayout(welcomePaneLayout);
        welcomePaneLayout.setHorizontalGroup(
            welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(welcomePaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(blockchainTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(heightLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(depthLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(depthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(welcomePaneLayout.createSequentialGroup()
                        .addComponent(blockchainWelcome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(welcomeLabelText)
                            .addComponent(passwordChangeButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitLabel)
                        .addContainerGap())))
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
                        .addGap(64, 64, 64))
                    .addComponent(blockchainWelcome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blockchainTextLabel)
                    .addComponent(heightLabel)
                    .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depthLabel)
                    .addComponent(depthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addContainerGap())
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try {
            if (heightTextField.getText().trim().equals("")) {
                //Podigni Error
                PopError CALError = new PopError();
                CALError.infoBox("You entered wrong height!", "Error!");
            } else {
                //Očisti array
                dataList.clear();
                //Očisti listu
                DefaultTableModel model = (DefaultTableModel) hashTable.getModel();
                model.setRowCount(0);
                Block myBlock = client.getBlock(Integer.parseInt(heightTextField.getText().trim()));
                dataList.add(myBlock.hash());
                int tmp = Integer.parseInt(depthTextField.getText().trim());
                while (tmp > 0) {
                    if (!myBlock.previousHash().equals("")) {
                        dataList.add(myBlock.previousHash());
                        myBlock = client.getBlock(myBlock.previousHash());
                        tmp = tmp - 1;
                    } else {
                        break;
                    }
                }
                ispisListe(model);
            }
            //System.out.println("Previous hash: " + myBlock.previousHash());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void ispisListe(DefaultTableModel model) {
        for (int i = 0; i < dataList.size(); i++) {
            String index = dataList.get(i);
            Object[] data = {index};
            model.addRow(data);
        }
    }

    private void heightTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_heightTextFieldKeyTyped
        ZabraniSlova(evt);
    }//GEN-LAST:event_heightTextFieldKeyTyped

    private void depthTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_depthTextFieldKeyTyped
        ZabraniSlova(evt);
    }//GEN-LAST:event_depthTextFieldKeyTyped

    public void ZabraniBrojeve(java.awt.event.KeyEvent evt) {
        char vChar = evt.getKeyChar();
        if ((Character.isDigit(vChar)
                || (vChar == KeyEvent.VK_BACK_SPACE)
                || (vChar == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }

    public void ZabraniSlova(java.awt.event.KeyEvent evt) {
        char vChar = evt.getKeyChar();
        if ((!Character.isDigit(vChar)
                || (vChar == KeyEvent.VK_BACK_SPACE)
                || (vChar == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel blockExplorerPanel;
    private javax.swing.JLabel blockchainTextLabel;
    private javax.swing.JLabel blockchainWelcome;
    private javax.swing.JLabel depthLabel;
    private javax.swing.JTextField depthTextField;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JTable hashTable;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JTextField heightTextField;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton passwordChangeButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel welcomeLabelText;
    private javax.swing.JPanel welcomePane;
    // End of variables declaration//GEN-END:variables
}
