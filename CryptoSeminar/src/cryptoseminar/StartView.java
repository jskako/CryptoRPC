/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptoseminar;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
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
    String rowClicked;
    Block myBlock;
    DefaultTableModel model;

    public StartView(Connection Conn, String Username) {
        this.conn = Conn;
        this.username = Username;
        initComponents();
        postaviUser();
        spajanjeRPC();
        AddActionListener();
        getLastBlock();
        getUserID();
        initTableFromDatabase();
    }

    private void getUserID() {
        RS = CALIzb.main(conn, "select F01ID from users where F01USR = '" + username.trim() + "'");
        try {
            while (RS.next()) {
                userID = RS.getInt("F01ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteDatabase() {
        RS = CALIzb.main(conn, "delete from LastSearch where F03USR = '" + String.valueOf(userID).trim() + "'");
    }

    private void insertDatabase() {
        deleteDatabase();
        for (String lst : dataList) {
            RS = CALIzb.main(conn, "insert into LastSearch values ('" + String.valueOf(userID).trim() + "','" + lst.trim() + "');");
        }
    }

    private void initTableFromDatabase() {
        model = (DefaultTableModel) hashTable.getModel();
        dataList.clear();
        RS = CALIzb.main(conn, "select F03HASH from LastSearch where F03USR = '" + String.valueOf(userID).trim() + "'");
        try {
            while (RS.next()) {
                String hash = RS.getString("F03HASH");
                dataList.add(hash.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (dataList != null && !dataList.isEmpty()) {
            ispisListe(model);
        }
    }

    private void getLastBlock() {
        try {
            String sURL = "https://blockchain.info/latestblock"; //just a string
            // Connect to the URL using java's native library
            URL url = new URL(sURL);
            URLConnection request = url.openConnection();
            request.connect();
            // Convert to a JSON object to print data
            JsonParser jp = new JsonParser(); //from gson
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
            JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
            String hei = rootobj.get("height").getAsString(); //just grab the zipcode
            heightTextField.setText(hei.trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        bitsLabel = new javax.swing.JLabel();
        chainworkLabel = new javax.swing.JLabel();
        confirmationsLabel = new javax.swing.JLabel();
        difficultyLabel = new javax.swing.JLabel();
        hashLabel = new javax.swing.JLabel();
        nextHashLabel = new javax.swing.JLabel();
        previousHash = new javax.swing.JLabel();
        heightLbl = new javax.swing.JLabel();
        markleRootLabel = new javax.swing.JLabel();
        sizeLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        bits = new javax.swing.JTextField();
        chainwork = new javax.swing.JTextField();
        confirmations = new javax.swing.JTextField();
        difficulty = new javax.swing.JTextField();
        hash = new javax.swing.JTextField();
        nextHash = new javax.swing.JTextField();
        prvHash = new javax.swing.JTextField();
        heightVar = new javax.swing.JTextField();
        markleRoot = new javax.swing.JTextField();
        size = new javax.swing.JTextField();
        version = new javax.swing.JTextField();
        clearTable = new javax.swing.JButton();
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
        graphButton = new javax.swing.JButton();
        listAddr = new javax.swing.JButton();
        addressBook = new javax.swing.JButton();

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

        jPanel1.setBackground(new java.awt.Color(232, 232, 232));

        blockExplorerPanel.setBackground(new java.awt.Color(209, 209, 209));

        hashTable.setBackground(new java.awt.Color(232, 232, 232));
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

        bitsLabel.setText("Bits");

        chainworkLabel.setText("Chainwork");

        confirmationsLabel.setText("Confirmations");

        difficultyLabel.setText("Difficulty");

        hashLabel.setText("Hash");

        nextHashLabel.setText("Next hash");

        previousHash.setText("Previous hash");

        heightLbl.setText("Height");

        markleRootLabel.setText("Markle root");

        sizeLabel.setText("Size");

        jLabel11.setText("Version");

        clearTable.setText("Clear");
        clearTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout blockExplorerPanelLayout = new javax.swing.GroupLayout(blockExplorerPanel);
        blockExplorerPanel.setLayout(blockExplorerPanelLayout);
        blockExplorerPanelLayout.setHorizontalGroup(
            blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockExplorerPanelLayout.createSequentialGroup()
                .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(clearTable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(blockExplorerPanelLayout.createSequentialGroup()
                            .addComponent(chainworkLabel)
                            .addGap(35, 35, 35)
                            .addComponent(chainwork, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
                        .addGroup(blockExplorerPanelLayout.createSequentialGroup()
                            .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(previousHash)
                                .addComponent(heightLbl)
                                .addComponent(markleRootLabel)
                                .addComponent(sizeLabel)
                                .addComponent(jLabel11))
                            .addGap(18, 18, 18)
                            .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(prvHash)
                                .addComponent(heightVar)
                                .addComponent(markleRoot)
                                .addComponent(size)
                                .addComponent(version)))
                        .addGroup(blockExplorerPanelLayout.createSequentialGroup()
                            .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(difficultyLabel)
                                .addComponent(hashLabel)
                                .addComponent(nextHashLabel))
                            .addGap(36, 36, 36)
                            .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(hash, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(nextHash)
                                .addComponent(difficulty))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, blockExplorerPanelLayout.createSequentialGroup()
                        .addComponent(bitsLabel)
                        .addGap(68, 68, 68)
                        .addComponent(bits))
                    .addGroup(blockExplorerPanelLayout.createSequentialGroup()
                        .addComponent(confirmationsLabel)
                        .addGap(18, 18, 18)
                        .addComponent(confirmations, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        blockExplorerPanelLayout.setVerticalGroup(
            blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockExplorerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bitsLabel)
                    .addComponent(bits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chainworkLabel)
                    .addComponent(chainwork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmationsLabel)
                    .addComponent(confirmations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(difficultyLabel)
                    .addComponent(difficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hashLabel)
                    .addComponent(hash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextHashLabel)
                    .addComponent(nextHash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousHash)
                    .addComponent(prvHash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heightLbl)
                    .addComponent(heightVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(markleRootLabel)
                    .addComponent(markleRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sizeLabel)
                    .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(blockExplorerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(version, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(blockExplorerPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearTable))
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

        depthTextField.setText("1");
        depthTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                depthTextFieldKeyTyped(evt);
            }
        });

        graphButton.setText("Graph");
        graphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphButtonActionPerformed(evt);
            }
        });

        listAddr.setText("List address");
        listAddr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listAddrActionPerformed(evt);
            }
        });

        addressBook.setText("Address Book");
        addressBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressBookActionPerformed(evt);
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
                        .addContainerGap(91, Short.MAX_VALUE))
                    .addGroup(welcomePaneLayout.createSequentialGroup()
                        .addComponent(blockchainWelcome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(welcomePaneLayout.createSequentialGroup()
                                .addComponent(welcomeLabelText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exitLabel))
                            .addGroup(welcomePaneLayout.createSequentialGroup()
                                .addComponent(passwordChangeButton)
                                .addGap(18, 18, 18)
                                .addComponent(graphButton)
                                .addGap(18, 18, 18)
                                .addComponent(listAddr)
                                .addGap(18, 18, 18)
                                .addComponent(addressBook)
                                .addGap(0, 0, Short.MAX_VALUE)))
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
                        .addGroup(welcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordChangeButton)
                            .addComponent(graphButton)
                            .addComponent(listAddr)
                            .addComponent(addressBook))
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
                model.setRowCount(0);
                myBlock = client.getBlock(Integer.parseInt(heightTextField.getText().trim()));
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
                insertDatabase();
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

    private void graphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphButtonActionPerformed

        chart();
    }//GEN-LAST:event_graphButtonActionPerformed

    private void listAddrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listAddrActionPerformed

        ViewAdr vadr = null;
        try {
            vadr = new ViewAdr(heightVar.getText().trim(), client, conn, Integer.toString(userID));
        } catch (IOException ex) {
            Logger.getLogger(StartView.class.getName()).log(Level.SEVERE, null, ex);
        }
        vadr.setLocationRelativeTo(null);
        vadr.setVisible(true);
    }//GEN-LAST:event_listAddrActionPerformed

    private void clearTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTableActionPerformed
        model = (DefaultTableModel) hashTable.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_clearTableActionPerformed

    private void addressBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressBookActionPerformed
        AddressBook adb = null;
        try {
            adb = new AddressBook(conn, Integer.toString(userID));
        } catch (IOException ex) {
            Logger.getLogger(ViewAdr.class.getName()).log(Level.SEVERE, null, ex);
        }
        adb.setLocationRelativeTo(null);
        adb.setVisible(true);
    }//GEN-LAST:event_addressBookActionPerformed

    private ArrayList punjenjeListe() {
        ArrayList<String> listChart = new ArrayList<String>();
        if (dataList != null && !dataList.isEmpty()) {
            for (String dl : dataList) {
                myBlock = client.getBlock(dl);
                listChart.add(Integer.toString(myBlock.size()));
            }
        } else {
            PopError CALError = new PopError();
            CALError.infoBox("No informations to show at graph!", "Error!");
        }
        return listChart;
    }

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

    private void chart() {
        ArrayList<String> listChart = new ArrayList<String>();
        listChart = punjenjeListe();
        Chart chart = new Chart("Block size graph", listChart);
        chart.main(arraypk);
    }

    private void AddActionListener() {
        hashTable.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                //Get row to int
                try {
                    if (hashTable.getValueAt(hashTable.getSelectedRow(), 0).toString() != null) {
                        rowClicked = hashTable.getValueAt(hashTable.getSelectedRow(), 0).toString();
                    }
                } catch (NullPointerException e) {
                    System.out.println("NULL");
                }
                System.out.println(rowClicked);
                if (!rowClicked.trim().equals("")) {
                    try {
                        myBlock = client.getBlock(rowClicked);
                        bits.setText(myBlock.bits());
                        chainwork.setText(myBlock.chainwork());
                        confirmations.setText(Integer.toString(myBlock.confirmations()));
                        difficulty.setText(String.valueOf(myBlock.difficulty()));
                        hash.setText(myBlock.hash());
                        nextHash.setText(myBlock.nextHash());
                        prvHash.setText(myBlock.previousHash());
                        heightVar.setText(Integer.toString(myBlock.height()));
                        markleRoot.setText(myBlock.merkleRoot());
                        size.setText(Integer.toString(myBlock.size()));
                        version.setText(Integer.toString(myBlock.version()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addressBook;
    private javax.swing.JTextField bits;
    private javax.swing.JLabel bitsLabel;
    private javax.swing.JPanel blockExplorerPanel;
    private javax.swing.JLabel blockchainTextLabel;
    private javax.swing.JLabel blockchainWelcome;
    private javax.swing.JTextField chainwork;
    private javax.swing.JLabel chainworkLabel;
    private javax.swing.JButton clearTable;
    private javax.swing.JTextField confirmations;
    private javax.swing.JLabel confirmationsLabel;
    private javax.swing.JLabel depthLabel;
    private javax.swing.JTextField depthTextField;
    private javax.swing.JTextField difficulty;
    private javax.swing.JLabel difficultyLabel;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JButton graphButton;
    private javax.swing.JTextField hash;
    private javax.swing.JLabel hashLabel;
    private javax.swing.JTable hashTable;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JLabel heightLbl;
    private javax.swing.JTextField heightTextField;
    private javax.swing.JTextField heightVar;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listAddr;
    private javax.swing.JTextField markleRoot;
    private javax.swing.JLabel markleRootLabel;
    private javax.swing.JTextField nextHash;
    private javax.swing.JLabel nextHashLabel;
    private javax.swing.JButton passwordChangeButton;
    private javax.swing.JLabel previousHash;
    private javax.swing.JTextField prvHash;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField size;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JTextField version;
    private javax.swing.JLabel welcomeLabelText;
    private javax.swing.JPanel welcomePane;
    // End of variables declaration//GEN-END:variables
}
