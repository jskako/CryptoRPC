/*
 Login uz mogućnost registracije
 */
package cryptoseminar;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.Timer;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author josips
 */
public class LoginFormGUI extends javax.swing.JFrame {

    private Connection Conn;

    //Spajanje na bazu
    ResultSet RS = null;
    ExecuteScriptsOnDatabase CALIzb = new ExecuteScriptsOnDatabase();

    //Init potrebnih parametara
    int MyFirstLogUsername = 0;
    int MyFirstLogPassword = 0;
    int KorisnikNeaktivan = 0;
    int time = 10000;
    PopError CALError = new PopError();

    /**
     * Creates new form LoginForm
     *
     * @param conn
     */
    public LoginFormGUI(Connection conn) {
        this.Conn = conn;
        initComponents();

        //Brišemo title bar
        Frame loginFrame = new Frame();
        loginFrame.setUndecorated(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        avatarPicture = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        emptyRowSep = new javax.swing.JSeparator();
        username = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        emptyRowSepN = new javax.swing.JSeparator();
        exitPicture = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        registrationButton = new javax.swing.JButton();
        showPassword = new javax.swing.JLabel();
        mailRecovery = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("loginFrame"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(66, 76, 82));
        jPanel1.setToolTipText("");

        jPanel3.setBackground(new java.awt.Color(0, 126, 167));

        avatarPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/rsz_login-avatar.png"))); // NOI18N

        userLabel.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        userLabel.setForeground(new java.awt.Color(255, 255, 255));
        userLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLabel.setText("USER LOGIN");

        username.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setText("username");
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFocusGained(evt);
            }
        });
        username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameMouseClicked(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(0, 168, 232));
        loginButton.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("L O G I N");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        exitPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/rsz_exit.png"))); // NOI18N
        exitPicture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitPictureMouseClicked(evt);
            }
        });

        password.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setText("thisismypass");
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
        });
        password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordMouseClicked(evt);
            }
        });
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        registrationButton.setBackground(new java.awt.Color(0, 126, 167));
        registrationButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        registrationButton.setForeground(new java.awt.Color(255, 255, 255));
        registrationButton.setText("REGISTRACIJA");
        registrationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationButtonActionPerformed(evt);
            }
        });

        showPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/check_psw.png"))); // NOI18N
        showPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showPasswordMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                showPasswordMouseReleased(evt);
            }
        });

        mailRecovery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/forgot_pass.png"))); // NOI18N
        mailRecovery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mailRecoveryMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emptyRowSep)
            .addComponent(emptyRowSepN)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(registrationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mailRecovery)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(showPassword))
                            .addComponent(username)
                            .addComponent(loginButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(avatarPicture)
                        .addGap(90, 90, 90)
                        .addComponent(exitPicture)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(exitPicture)
                        .addGap(0, 148, Short.MAX_VALUE))
                    .addComponent(avatarPicture, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(11, 11, 11)
                .addComponent(userLabel)
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(emptyRowSep, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showPassword)))
                    .addComponent(mailRecovery))
                .addGap(18, 18, 18)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(emptyRowSepN, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registrationButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleName("HTR");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitPictureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitPictureMouseClicked

        System.exit(0);
    }//GEN-LAST:event_exitPictureMouseClicked

    private void usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseClicked

    }//GEN-LAST:event_usernameMouseClicked

    private void passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseClicked

    }//GEN-LAST:event_passwordMouseClicked

    private void registrationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationButtonActionPerformed
        RegistrationFormGUI CALRegistration = new RegistrationFormGUI(Conn);
        CALRegistration.setLocationRelativeTo(null);
        CALRegistration.setVisible(true);
        dispose();
    }//GEN-LAST:event_registrationButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        //Kriptiranje sifre
        String decryptedPassword;
        EncryptDecryptString KS = new EncryptDecryptString();
        decryptedPassword = KS.KriptirajString(password.getText().trim(), 1);
        
        // Da li postoji user?
        try {
            RS = CALIzb.main(Conn, "select * from users where F01USR = '" + username.getText().trim() + "' and F01PWD = '" + decryptedPassword + "'");

            if (RS.next()) {
                // Provjera da li je user aktivan
                RS = CALIzb.main(Conn, "select F01AKT from users where F01USR = '" + username.getText().trim() + "' and F01PWD = '" + decryptedPassword + "'");
                String isUserActive = null;
                while (RS.next()) {
                    isUserActive = RS.getString("F01AKT");
                    if (Integer.parseInt(isUserActive.trim()) == 1) {
                        // Logiram se te idem dalje, upisujemo zadnji login date-time
                        RS = CALIzb.main(Conn, "update users set F01DVL = GETDATE() where F01USR = '" + username.getText().trim() + "'");
                        StartView CALUser = new StartView(Conn, username.getText().trim());
                        CALUser.setLocationRelativeTo(null);
                        CALUser.setVisible(true);
                        dispose();

                    } else {
                        userLabel.setText("Korisnik neaktivan!");
                        Timer timer = new Timer(1000, e -> userLabel.setText("USER LOGIN"));
                        timer.setRepeats(false);
                        timer.start();
                    }
                }
            } else {
                userLabel.setText("Korisnik ne postoji!");
                Timer timer = new Timer(1000, e -> userLabel.setText("USER LOGIN"));
                timer.setRepeats(false);
                timer.start();

                KorisnikNeaktivan += 1;
                if (KorisnikNeaktivan == 3) {
                    setTimer();
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void setTimer() {
        try {
            int myTime = time / 1000;
            CALError.infoBox("Too many login attempts!", "Warning!");
            loginButton.setEnabled(false);
            loginButton.paintImmediately(loginButton.getVisibleRect());
            KorisnikNeaktivan = 0;
            time = time * 2;
            while (myTime > 0) {
                userLabel.setText(Integer.toString(myTime));
                userLabel.paintImmediately(userLabel.getVisibleRect());
                TimeUnit.SECONDS.sleep(1);
                myTime = myTime - 1;
            }
            userLabel.setText("USER LOGIN");
            loginButton.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusGained

        if (MyFirstLogUsername == 0) {
            username.setText("");
            MyFirstLogUsername++;
        }
    }//GEN-LAST:event_usernameFocusGained

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained

        if (MyFirstLogPassword == 0) {
            password.setText("");
            MyFirstLogPassword++;
        }
    }//GEN-LAST:event_passwordFocusGained

    private void showPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPasswordMousePressed

        password.setEchoChar((char) 0);
    }//GEN-LAST:event_showPasswordMousePressed

    private void showPasswordMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPasswordMouseReleased

        password.setEchoChar('*');
    }//GEN-LAST:event_showPasswordMouseReleased

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed

        char vChar = evt.getKeyChar();
        if (vChar == KeyEvent.VK_ENTER) {
            loginButtonActionPerformed(null);
        }
    }//GEN-LAST:event_passwordKeyPressed

    private void mailRecoveryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mailRecoveryMouseClicked
        //MailRecoveryGUI CALMailGui = new MailRecoveryGUI(Conn);
        //CALMailGui.setLocationRelativeTo(null);
        //CALMailGui.setVisible(true);
    }//GEN-LAST:event_mailRecoveryMouseClicked

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed

    }//GEN-LAST:event_passwordActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatarPicture;
    private javax.swing.JSeparator emptyRowSep;
    private javax.swing.JSeparator emptyRowSepN;
    private javax.swing.JLabel exitPicture;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel mailRecovery;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton registrationButton;
    private javax.swing.JLabel showPassword;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
