/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptoseminar;

/**
 *
 * @author josips
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Arrays;
import javax.swing.Timer;

public class UserPasswordChange extends javax.swing.JFrame {

    private Connection conn;
    private int userID;
    boolean PasswordNijeIsti;

    String ime = "";
    String prezime = "";
    String username = "";
    String oldPwd = "";

    //Spajanje na bazu
    ResultSet RS = null;
    ExecuteScriptsOnDatabase CALIzb = new ExecuteScriptsOnDatabase();

    /**
     * Creates new form UserPasswordChange
     */
    public UserPasswordChange(Connection Conn, int id) {
        this.conn = Conn;
        this.userID = id;
        initComponents();
        postaviUser();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pchangePanel = new javax.swing.JPanel();
        useridLabel = new javax.swing.JLabel();
        oldPassLabel = new javax.swing.JLabel();
        newPassLabel = new javax.swing.JLabel();
        passRetype = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        okButton = new javax.swing.JButton();
        cancleButton = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        retypePass = new javax.swing.JPasswordField();
        passwordCheckLabel = new javax.swing.JLabel();
        showPassword = new javax.swing.JLabel();
        oldPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(66, 76, 82));
        setUndecorated(true);

        pchangePanel.setBackground(new java.awt.Color(0, 126, 167));
        pchangePanel.setToolTipText("");

        useridLabel.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        useridLabel.setForeground(new java.awt.Color(255, 255, 255));
        useridLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        useridLabel.setText("User");

        oldPassLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        oldPassLabel.setForeground(new java.awt.Color(255, 255, 255));
        oldPassLabel.setText("Old password");

        newPassLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        newPassLabel.setForeground(new java.awt.Color(255, 255, 255));
        newPassLabel.setText("New password");

        passRetype.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        passRetype.setForeground(new java.awt.Color(255, 255, 255));
        passRetype.setText("Retype");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/pic_admin.png"))); // NOI18N

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancleButton.setText("Cancle");
        cancleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleButtonActionPerformed(evt);
            }
        });

        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });

        retypePass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                retypePassFocusLost(evt);
            }
        });

        passwordCheckLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/notvaild.png"))); // NOI18N

        showPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/check_psw.png"))); // NOI18N
        showPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showPasswordMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                showPasswordMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pchangePanelLayout = new javax.swing.GroupLayout(pchangePanel);
        pchangePanel.setLayout(pchangePanelLayout);
        pchangePanelLayout.setHorizontalGroup(
            pchangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(pchangePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pchangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pchangePanelLayout.createSequentialGroup()
                        .addGroup(pchangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newPassLabel)
                            .addComponent(passRetype)
                            .addComponent(oldPassLabel))
                        .addGap(18, 18, 18)
                        .addGroup(pchangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pchangePanelLayout.createSequentialGroup()
                                .addGroup(pchangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(password)
                                    .addComponent(retypePass))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordCheckLabel))
                            .addComponent(oldPassword)))
                    .addComponent(useridLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pchangePanelLayout.createSequentialGroup()
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(showPassword)
                        .addGap(31, 31, 31)
                        .addComponent(cancleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pchangePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo)
                .addGap(140, 140, 140))
        );
        pchangePanelLayout.setVerticalGroup(
            pchangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pchangePanelLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(useridLabel)
                .addGap(23, 23, 23)
                .addGroup(pchangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPassLabel)
                    .addComponent(oldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pchangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pchangePanelLayout.createSequentialGroup()
                        .addGroup(pchangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newPassLabel)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pchangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passRetype)
                            .addComponent(retypePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(passwordCheckLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pchangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pchangePanelLayout.createSequentialGroup()
                        .addComponent(showPassword)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pchangePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pchangePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancleButtonActionPerformed

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        if (Arrays.equals(retypePass.getPassword(), password.getPassword())) {
            passwordCheckLabel.setVisible(false);
            PasswordNijeIsti = true;
        } else {
            passwordCheckLabel.setVisible(true);
            PasswordNijeIsti = false;

            useridLabel.setText("Unesite jednake šifre!");
            Timer timer = new Timer(2000, e -> useridLabel.setText(ime + " " + prezime + "  ( " + username + " )"));
            timer.setRepeats(false);
            timer.start();
        }
    }//GEN-LAST:event_passwordFocusLost

    private void showPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPasswordMousePressed
        password.setEchoChar((char) 0);
        retypePass.setEchoChar((char) 0);
        oldPassword.setEchoChar((char) 0);
    }//GEN-LAST:event_showPasswordMousePressed

    private void showPasswordMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPasswordMouseReleased
        password.setEchoChar('*');
        retypePass.setEchoChar('*');
        oldPassword.setEchoChar('*');
    }//GEN-LAST:event_showPasswordMouseReleased

    private void retypePassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_retypePassFocusLost
        if (Arrays.equals(retypePass.getPassword(), password.getPassword())) {
            passwordCheckLabel.setVisible(false);
            PasswordNijeIsti = true;
        } else {
            passwordCheckLabel.setVisible(true);
            PasswordNijeIsti = false;

            useridLabel.setText("Unesite jednake šifre!");
            Timer timer = new Timer(2000, e -> useridLabel.setText(ime + " " + prezime + "  ( " + username + " )"));
            timer.setRepeats(false);
            timer.start();
        }
    }//GEN-LAST:event_retypePassFocusLost

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        PopError CALError = new PopError();

        //Kriptiranje sifre
        String passText = new String(oldPassword.getPassword());
        EncryptDecryptString KS = new EncryptDecryptString();

        passText = KS.KriptirajString(passText, 1);

        if (passText == null ? oldPwd == null : passText.equals(oldPwd)) {
            String pass = new String(password.getPassword());
            String passRE = new String(retypePass.getPassword());
            if (pass == null ? passRE == null : pass.equals(passRE)) {
                String newPassText = new String(password.getPassword());
                newPassText = KS.KriptirajString(newPassText, 1);
                RS = CALIzb.main(conn, "update users set F01PWD = '" + newPassText + "' where F01ID = '" + userID + "'");
                CALError.infoBox("Your password has been changed!", "success!");
                dispose();
            } else {
                CALError.infoBox("Your new passwords doesn't match!", "Failed!");
            }

        } else {
            CALError.infoBox("Your old password is not correct!", "Failed!");
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void postaviUser() {
        try {
            //Dohvati ID
            RS = CALIzb.main(conn, "select F01IME, F01PRE, F01USR, F01PWD from users where F01ID = '" + userID + "'");
            while (RS.next()) {
                ime = RS.getString("F01IME");
                prezime = RS.getString("F01PRE");
                username = RS.getString("F01USR");
                oldPwd = RS.getString("F01PWD");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        useridLabel.setText(ime + " " + prezime + "  ( " + username + " )");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancleButton;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel newPassLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel oldPassLabel;
    private javax.swing.JPasswordField oldPassword;
    private javax.swing.JLabel passRetype;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordCheckLabel;
    private javax.swing.JPanel pchangePanel;
    private javax.swing.JPasswordField retypePass;
    private javax.swing.JLabel showPassword;
    private javax.swing.JLabel useridLabel;
    // End of variables declaration//GEN-END:variables
}
