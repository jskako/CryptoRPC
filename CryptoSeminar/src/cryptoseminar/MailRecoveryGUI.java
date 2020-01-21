package cryptoseminar;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.Timer;

/**
 *
 * @author josips
 */
public class MailRecoveryGUI extends javax.swing.JFrame {

    /**
     * Creates new form MailRecoveryGUI
     */
    //Spajanje na bazu
    ResultSet RS = null;
    ExecuteScriptsOnDatabase CALIzb = new ExecuteScriptsOnDatabase();

    private Connection Conn;

    String myPassword;
    String myUserName;

    public MailRecoveryGUI(Connection conn) {

        this.Conn = conn;

        initComponents();
        Frame MailRecoveryGUI = new Frame();
        MailRecoveryGUI.setUndecorated(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pic_MailRecovery = new javax.swing.JLabel();
        myMainLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        lbl_myMail = new javax.swing.JTextField();
        btnSendMail = new javax.swing.JButton();
        lbl_Exit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(66, 76, 82));
        setName("MailRecoveryGUI"); // NOI18N
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(66, 76, 82));

        jPanel2.setBackground(new java.awt.Color(0, 126, 167));

        pic_MailRecovery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htr/Images/mail_recovery_avatar.png"))); // NOI18N

        myMainLabel.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        myMainLabel.setForeground(new java.awt.Color(255, 255, 255));
        myMainLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myMainLabel.setText("Password Recovery");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Your mail");

        lbl_myMail.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_myMail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbl_myMail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_myMailFocusLost(evt);
            }
        });

        btnSendMail.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnSendMail.setText("Pošalji password");
        btnSendMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMailActionPerformed(evt);
            }
        });

        lbl_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htr/Images/rsz_exit.png"))); // NOI18N
        lbl_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_myMail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSendMail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(pic_MailRecovery)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(lbl_Exit))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(myMainLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pic_MailRecovery)
                    .addComponent(lbl_Exit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myMainLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_myMail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSendMail, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ExitMouseClicked
        dispose();
    }//GEN-LAST:event_lbl_ExitMouseClicked

    private void lbl_myMailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_myMailFocusLost

    }//GEN-LAST:event_lbl_myMailFocusLost

    private void btnSendMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMailActionPerformed

        if (!lbl_myMail.getText().toLowerCase().contains("@")) {
            myMainLabel.setText("Error!");
            Timer timer = new Timer(1000, e -> myMainLabel.setText("Password Recovery"));
            timer.setRepeats(false);
            timer.start();
            lbl_myMail.setText(null);
        } else {
            try {
                RS = CALIzb.main(Conn, "select * from users where F01EMA = '" + lbl_myMail.getText().trim() + "'");

                if (RS.next() || lbl_myMail.getText().isEmpty()) {
                    //Mail postoji te je ispravan

                    //Dohvacam mail i password
                    RS = CALIzb.main(Conn, "select F01USR from Users where F01EMA = '" + lbl_myMail.getText().trim() + "'");
                    while (RS.next()) {
                        myUserName = RS.getString("F01USR");
                    }
                    RS = CALIzb.main(Conn, "select F01PWD from Users where F01EMA = '" + lbl_myMail.getText().trim() + "'");
                    while (RS.next()) {
                        myPassword = RS.getString("F01PWD");
                    }
                    //Dekriptiranje sifre
                    String decryptedPassword;
                    EncryptDecryptString KS = new EncryptDecryptString();
                    decryptedPassword = KS.KriptirajString(myPassword, 2);
                    //Zovem funkciju
                    MailRecovery CALMRecovery = new MailRecovery();
                    CALMRecovery.MailRecovery(lbl_myMail.getText().trim(), decryptedPassword, myUserName);
                    PopError CALSucess = new PopError();
                    CALSucess.infoBox("Podaci su poslani na mail!", "Success!");
                    dispose();

                } else {
                    myMainLabel.setText("Error!");
                    lbl_myMail.setText("");
                    Timer timer = new Timer(2000, e -> myMainLabel.setText("Password Recovery"));
                    timer.setRepeats(false);
                    timer.start();
                }
            } catch (Exception e) {

            }
        }


    }//GEN-LAST:event_btnSendMailActionPerformed

    /**
     * @param args the command line arguments
     */
    public void MailRecoveryGUI(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendMail;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_Exit;
    private javax.swing.JTextField lbl_myMail;
    private javax.swing.JLabel myMainLabel;
    private javax.swing.JLabel pic_MailRecovery;
    // End of variables declaration//GEN-END:variables
}
