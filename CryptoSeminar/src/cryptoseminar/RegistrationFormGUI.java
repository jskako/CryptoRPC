/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptoseminar;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Arrays;
import javax.swing.Timer;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author josips
 */
public class RegistrationFormGUI extends javax.swing.JFrame {

    /**
     * Creates new form RegistrationFormGUI
     */
    // PARAMETRI 
    private Connection conn;
    int CharUserLeft = 20;
    boolean userPostoji;
    boolean PasswordNijeIsti;
    int godRazlika = 0;
    int godinaRodenja;
    int mjesecRodenja;
    int danRodenja;
    int MyIDNumber = 0;

    // Prvo Punjenje
    int MyFirstLogUsername = 0;
    int MyFirstLogName = 0;
    int MyFirstLogSurname = 0;
    int MyFirstLogPass = 0;
    int MyFirstLogPassSec = 0;
    int MyFirstLogMail = 0;
    int MyFirstLogBrTel = 0;
    int MyFirstLogDrzava = 0;
    int MyFirstLogGradRodenja = 0;
    int MyFirstLogAdresa = 0;
    int MyFirstLogPostBroj = 0;
    int MyFirstLogArea = 0;

    //Spajanje na bazu
    ResultSet RS = null;
    ExecuteScriptsOnDatabase CALIzb = new ExecuteScriptsOnDatabase();

    /**
     * Creates new form LoginFormGUI
     *
     * @param Conn
     */
    public RegistrationFormGUI(Connection Conn) {
        this.conn = Conn;
        initComponents();
        userNotFoundLabel.setVisible(false);
        userFoundLabel.setVisible(false);
        passwordCheckLabel.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jPanel1 = new javax.swing.JPanel();
        txt_BrTel = new javax.swing.JPanel();
        korisnickoIme = new javax.swing.JTextField();
        korisnickoImeLabel = new javax.swing.JLabel();
        ime = new javax.swing.JTextField();
        prezime = new javax.swing.JTextField();
        imeLabel = new javax.swing.JLabel();
        prezimeLabel = new javax.swing.JLabel();
        sifraLabel = new javax.swing.JLabel();
        ponovljenaSifraLabel = new javax.swing.JLabel();
        mailLabel = new javax.swing.JLabel();
        godRodLabel = new javax.swing.JLabel();
        gradRodLabel = new javax.swing.JLabel();
        drzLabel = new javax.swing.JLabel();
        adresaLabel = new javax.swing.JLabel();
        posBrojLabel = new javax.swing.JLabel();
        brojTelLabel = new javax.swing.JLabel();
        sifra = new javax.swing.JPasswordField();
        ponSifra = new javax.swing.JPasswordField();
        mail = new javax.swing.JTextField();
        telefon = new javax.swing.JTextField();
        gradRodenja = new javax.swing.JTextField();
        adresa = new javax.swing.JTextField();
        postanskiBroj = new javax.swing.JTextField();
        praznaLinija = new javax.swing.JSeparator();
        avatarLabel = new javax.swing.JLabel();
        registrationLabel = new javax.swing.JLabel();
        praznaLinijaN = new javax.swing.JSeparator();
        brojacZnakovaUser = new javax.swing.JLabel();
        maxBrojacZnakovaUser = new javax.swing.JLabel();
        godinaRod = new com.toedter.calendar.JYearChooser();
        mjesecRodLabel = new javax.swing.JLabel();
        danRodLabel = new javax.swing.JLabel();
        danRod = new javax.swing.JComboBox<>();
        agreemLabelZero = new javax.swing.JLabel();
        agreemLabelOne = new javax.swing.JLabel();
        agreemLabelTwo = new javax.swing.JLabel();
        agreeCheckBox = new javax.swing.JCheckBox();
        mjRod = new javax.swing.JComboBox<>();
        exitLabel = new javax.swing.JLabel();
        userFoundLabel = new javax.swing.JLabel();
        userNotFoundLabel = new javax.swing.JLabel();
        passwordCheckLabel = new javax.swing.JLabel();
        registrirajButton = new javax.swing.JButton();
        drzava = new javax.swing.JComboBox<>();
        areaCode = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("formRegistration"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(66, 76, 82));

        txt_BrTel.setBackground(new java.awt.Color(0, 126, 167));
        txt_BrTel.setForeground(new java.awt.Color(255, 255, 0));
        txt_BrTel.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N

        korisnickoIme.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        korisnickoIme.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        korisnickoIme.setText("example");
        korisnickoIme.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                korisnickoImeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                korisnickoImeFocusLost(evt);
            }
        });
        korisnickoIme.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                korisnickoImePropertyChange(evt);
            }
        });
        korisnickoIme.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                korisnickoImeKeyPressed(evt);
            }
        });

        korisnickoImeLabel.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        korisnickoImeLabel.setForeground(new java.awt.Color(255, 255, 255));
        korisnickoImeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        korisnickoImeLabel.setText("KORISNIČKO IME");

        ime.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        ime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ime.setText("example");
        ime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                imeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                imeFocusLost(evt);
            }
        });
        ime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                imeKeyTyped(evt);
            }
        });

        prezime.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        prezime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prezime.setText("example");
        prezime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                prezimeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                prezimeFocusLost(evt);
            }
        });
        prezime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prezimeKeyTyped(evt);
            }
        });

        imeLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        imeLabel.setForeground(new java.awt.Color(255, 255, 255));
        imeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imeLabel.setText("IME");

        prezimeLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        prezimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        prezimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prezimeLabel.setText("PREZIME");

        sifraLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        sifraLabel.setForeground(new java.awt.Color(255, 255, 255));
        sifraLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sifraLabel.setText("ŠIFRA");

        ponovljenaSifraLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        ponovljenaSifraLabel.setForeground(new java.awt.Color(255, 255, 255));
        ponovljenaSifraLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ponovljenaSifraLabel.setText("PONOVLJENA ŠIFRA");

        mailLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        mailLabel.setForeground(new java.awt.Color(255, 255, 255));
        mailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mailLabel.setText("MAIL");

        godRodLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        godRodLabel.setForeground(new java.awt.Color(255, 255, 255));
        godRodLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        godRodLabel.setText("GODINA ROĐENJA");

        gradRodLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        gradRodLabel.setForeground(new java.awt.Color(255, 255, 255));
        gradRodLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gradRodLabel.setText("GRAD");

        drzLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        drzLabel.setForeground(new java.awt.Color(255, 255, 255));
        drzLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        drzLabel.setText("DRŽAVA");

        adresaLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        adresaLabel.setForeground(new java.awt.Color(255, 255, 255));
        adresaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adresaLabel.setText("ADRESA");

        posBrojLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        posBrojLabel.setForeground(new java.awt.Color(255, 255, 255));
        posBrojLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posBrojLabel.setText("POŠTANSKI BROJ");

        brojTelLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        brojTelLabel.setForeground(new java.awt.Color(255, 255, 255));
        brojTelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        brojTelLabel.setText("BROJ TELEFONA");

        sifra.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        sifra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sifra.setText("mytestpassword");
        sifra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sifraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sifraFocusLost(evt);
            }
        });

        ponSifra.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        ponSifra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ponSifra.setText("mytestpassword");
        ponSifra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ponSifraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ponSifraFocusLost(evt);
            }
        });

        mail.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        mail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mail.setText("example@example.com");
        mail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                mailFocusLost(evt);
            }
        });
        mail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mailKeyTyped(evt);
            }
        });

        telefon.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        telefon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telefon.setText("111111111");
        telefon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                telefonFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                telefonFocusLost(evt);
            }
        });
        telefon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonActionPerformed(evt);
            }
        });
        telefon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonKeyTyped(evt);
            }
        });

        gradRodenja.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        gradRodenja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gradRodenja.setText("example");
        gradRodenja.setToolTipText("");
        gradRodenja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                gradRodenjaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                gradRodenjaFocusLost(evt);
            }
        });
        gradRodenja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gradRodenjaKeyTyped(evt);
            }
        });

        adresa.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        adresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        adresa.setText("example");
        adresa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adresaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                adresaFocusLost(evt);
            }
        });
        adresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                adresaKeyTyped(evt);
            }
        });

        postanskiBroj.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        postanskiBroj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        postanskiBroj.setText("11111");
        postanskiBroj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                postanskiBrojFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                postanskiBrojFocusLost(evt);
            }
        });
        postanskiBroj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                postanskiBrojKeyTyped(evt);
            }
        });

        avatarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/user_registration.png"))); // NOI18N
        avatarLabel.setToolTipText("");

        registrationLabel.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        registrationLabel.setForeground(new java.awt.Color(255, 255, 255));
        registrationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrationLabel.setText("REGISTRATION");

        brojacZnakovaUser.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        brojacZnakovaUser.setForeground(new java.awt.Color(255, 255, 255));
        brojacZnakovaUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        brojacZnakovaUser.setText("20");

        maxBrojacZnakovaUser.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        maxBrojacZnakovaUser.setForeground(new java.awt.Color(255, 255, 255));
        maxBrojacZnakovaUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maxBrojacZnakovaUser.setText("/ 20");

        godinaRod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                godinaRodFocusLost(evt);
            }
        });
        godinaRod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                godinaRodKeyTyped(evt);
            }
        });

        mjesecRodLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        mjesecRodLabel.setForeground(new java.awt.Color(255, 255, 255));
        mjesecRodLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mjesecRodLabel.setText("MJESEC ROĐENJA");

        danRodLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        danRodLabel.setForeground(new java.awt.Color(255, 255, 255));
        danRodLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        danRodLabel.setText("DAN ROĐENJA");

        danRod.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        danRod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        agreemLabelZero.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        agreemLabelZero.setForeground(new java.awt.Color(255, 255, 255));
        agreemLabelZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        agreemLabelZero.setText("Korištenjem ove aplikacije potvrđujete da ste stariji od 18 godina, ");

        agreemLabelOne.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        agreemLabelOne.setForeground(new java.awt.Color(255, 255, 255));
        agreemLabelOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        agreemLabelOne.setText("odnosno da imate dovoljno godina za kupnju i prodaju kriptovalute u državi iz koje pristupate našoj stranici");

        agreemLabelTwo.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        agreemLabelTwo.setForeground(new java.awt.Color(255, 255, 255));
        agreemLabelTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        agreemLabelTwo.setText("Slažem se te se želim registrirati:");

        agreeCheckBox.setBackground(new java.awt.Color(0, 126, 167));
        agreeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agreeCheckBoxActionPerformed(evt);
            }
        });

        mjRod.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        mjRod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        exitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/rsz_exit.png"))); // NOI18N
        exitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabelMouseClicked(evt);
            }
        });

        userFoundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/notvaild.png"))); // NOI18N

        userNotFoundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/vaild.png"))); // NOI18N
        userNotFoundLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        passwordCheckLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/notvaild.png"))); // NOI18N
        passwordCheckLabel.setToolTipText("");

        registrirajButton.setBackground(new java.awt.Color(0, 126, 167));
        registrirajButton.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        registrirajButton.setForeground(new java.awt.Color(255, 255, 0));
        registrirajButton.setText("Registriraj se");
        registrirajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrirajButtonActionPerformed(evt);
            }
        });

        drzava.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "{Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe" }));
        drzava.setToolTipText("");
        drzava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drzavaActionPerformed(evt);
            }
        });

        areaCode.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        areaCode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        areaCode.setText("+999");
        areaCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                areaCodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                areaCodeFocusLost(evt);
            }
        });
        areaCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaCodeActionPerformed(evt);
            }
        });
        areaCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                areaCodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                areaCodeKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout txt_BrTelLayout = new javax.swing.GroupLayout(txt_BrTel);
        txt_BrTel.setLayout(txt_BrTelLayout);
        txt_BrTelLayout.setHorizontalGroup(
            txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(praznaLinija)
            .addComponent(praznaLinijaN)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txt_BrTelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txt_BrTelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(avatarLabel)
                        .addGap(261, 261, 261)
                        .addComponent(exitLabel)
                        .addContainerGap())
                    .addGroup(txt_BrTelLayout.createSequentialGroup()
                        .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, txt_BrTelLayout.createSequentialGroup()
                                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adresaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(adresa, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(posBrojLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(txt_BrTelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(postanskiBroj, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(txt_BrTelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(korisnickoImeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, txt_BrTelLayout.createSequentialGroup()
                                        .addComponent(imeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(prezimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, txt_BrTelLayout.createSequentialGroup()
                                        .addComponent(korisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(brojacZnakovaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(maxBrojacZnakovaUser)
                                        .addGap(18, 18, 18)
                                        .addComponent(userFoundLabel)
                                        .addGap(26, 26, 26)
                                        .addComponent(userNotFoundLabel))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, txt_BrTelLayout.createSequentialGroup()
                                        .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(godinaRod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(godRodLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(danRodLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(danRod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(mjRod, 0, 92, Short.MAX_VALUE)
                                            .addComponent(mjesecRodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                                    .addComponent(agreemLabelOne, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(agreemLabelZero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, txt_BrTelLayout.createSequentialGroup()
                                        .addComponent(sifra, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(passwordCheckLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ponSifra))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, txt_BrTelLayout.createSequentialGroup()
                                        .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(txt_BrTelLayout.createSequentialGroup()
                                                .addComponent(ime)
                                                .addGap(18, 18, 18))
                                            .addGroup(txt_BrTelLayout.createSequentialGroup()
                                                .addComponent(sifraLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)))
                                        .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ponovljenaSifraLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(prezime)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, txt_BrTelLayout.createSequentialGroup()
                                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(drzLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                    .addComponent(mailLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mail, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(txt_BrTelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(brojTelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                            .addComponent(gradRodLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(txt_BrTelLayout.createSequentialGroup()
                                        .addComponent(areaCode, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(telefon))))
                            .addGroup(txt_BrTelLayout.createSequentialGroup()
                                .addComponent(drzava, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(gradRodenja, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8))))
            .addGroup(txt_BrTelLayout.createSequentialGroup()
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txt_BrTelLayout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(agreemLabelTwo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agreeCheckBox))
                    .addGroup(txt_BrTelLayout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(registrirajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txt_BrTelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(registrationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        txt_BrTelLayout.setVerticalGroup(
            txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txt_BrTelLayout.createSequentialGroup()
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txt_BrTelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(exitLabel))
                    .addGroup(txt_BrTelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(avatarLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registrationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(praznaLinija, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(korisnickoImeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(brojacZnakovaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userFoundLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(korisnickoIme)
                    .addComponent(maxBrojacZnakovaUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userNotFoundLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imeLabel)
                    .addComponent(prezimeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prezime, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ime, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sifraLabel)
                    .addComponent(ponovljenaSifraLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sifra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponSifra, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordCheckLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mailLabel)
                    .addComponent(brojTelLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telefon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(areaCode, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(drzLabel)
                    .addComponent(gradRodLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gradRodenja, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(drzava))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adresaLabel)
                    .addComponent(posBrojLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(postanskiBroj, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(adresa))
                .addGap(18, 18, 18)
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(godRodLabel)
                    .addComponent(mjesecRodLabel)
                    .addComponent(danRodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(godinaRod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(danRod, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txt_BrTelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(mjRod, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(praznaLinijaN, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(agreemLabelZero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agreemLabelOne)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txt_BrTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(agreemLabelTwo)
                    .addComponent(agreeCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registrirajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txt_BrTelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {areaCode, telefon});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_BrTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_BrTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agreeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agreeCheckBoxActionPerformed
        
        if (agreeCheckBox.isSelected()) {

            //BIRTH DAY, MONTH, YEAR
            danRodenja = Integer.parseInt(danRod.getSelectedItem().toString());
            mjesecRodenja = Integer.parseInt(mjRod.getSelectedItem().toString());
            godinaRodenja = godinaRod.getValue();

            //CURRENT DAY, MONTH, YEAR
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            int currentmonth = calendar.get(Calendar.MONTH) + 1;
            int currentYear = calendar.get(Calendar.YEAR);
            int dayOcurrentDay = calendar.get(Calendar.DAY_OF_MONTH);
            
            godRazlika = currentYear - godinaRodenja;
            if (currentmonth < mjesecRodenja) {
                godRazlika -= 1;
            } else if (currentmonth == mjesecRodenja) {
                if (dayOcurrentDay < danRodenja) {
                    godRazlika -= 1;
                }
            }
            
            if (godRazlika < 18) {
                agreeCheckBox.setSelected(false);
                registrationLabel.setText("Imate manje od 18 godina!");
                Timer timer = new Timer(2000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
            }
            
            if (godRazlika > 18) {
                setFieldsDisabled();
            }
            
            if ((korisnickoIme.getText().equals("") || korisnickoIme.getText().equals("example"))) {
                agreeCheckBox.setSelected(false);
                registrationLabel.setText("Popunite korisnicko ime!");
                Timer timer = new Timer(1000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
                setFieldsEnabled();
            }
            
            if ((ime.getText().equals("") || ime.getText().equals("example"))) {
                agreeCheckBox.setSelected(false);
                registrationLabel.setText("Popunite ime!");
                Timer timer = new Timer(1000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
                setFieldsEnabled();
            }
            
            if ((prezime.getText().equals("") || prezime.getText().equals("example"))) {
                agreeCheckBox.setSelected(false);
                registrationLabel.setText("Popunite prezime!");
                Timer timer = new Timer(1000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
                setFieldsEnabled();
            }
            
            if ((sifra.getText().equals("") || sifra.getText().equals("mytestpassword"))) {
                agreeCheckBox.setSelected(false);
                registrationLabel.setText("Popunite šifru!");
                Timer timer = new Timer(1000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
                setFieldsEnabled();
            }
            
            if ((ponSifra.getText().equals("") || ponSifra.getText().equals("mytestpassword"))) {
                agreeCheckBox.setSelected(false);
                registrationLabel.setText("Popunite šifru!");
                Timer timer = new Timer(1000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
                setFieldsEnabled();
            }
            
            if ((mail.getText().equals("") || mail.getText().equals("example@example.com"))) {
                agreeCheckBox.setSelected(false);
                registrationLabel.setText("Popunite mail!");
                Timer timer = new Timer(1000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
                setFieldsEnabled();
            }
            
            if ((telefon.getText().equals("") || telefon.getText().equals("111111111"))) {
                agreeCheckBox.setSelected(false);
                registrationLabel.setText("Popunite broj telefona!");
                Timer timer = new Timer(1000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
                setFieldsEnabled();
            }
            
            if ((drzava.getSelectedItem().toString().trim().equals("") || drzava.getSelectedItem().toString().trim().equals("example"))) {
                agreeCheckBox.setSelected(false);
                registrationLabel.setText("Popunite drzavu!");
                Timer timer = new Timer(1000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
                setFieldsEnabled();
            }
            
            if ((gradRodenja.getText().equals("") || gradRodenja.getText().equals("example"))) {
                agreeCheckBox.setSelected(false);
                registrationLabel.setText("Popunite grad rodenja!");
                Timer timer = new Timer(1000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
                setFieldsEnabled();
            }
            
            if ((adresa.getText().equals("") || adresa.getText().equals("example"))) {
                agreeCheckBox.setSelected(false);
                registrationLabel.setText("Popunite adresu");
                Timer timer = new Timer(1000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
                setFieldsEnabled();
            }
            
            if ((postanskiBroj.getText().equals("") || postanskiBroj.getText().equals("11111"))) {
                agreeCheckBox.setSelected(false);
                registrationLabel.setText("Popunite postanski broj");
                Timer timer = new Timer(1000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
                setFieldsEnabled();
            }
            
            if ((areaCode.getText().equals("") || areaCode.getText().equals("+") || areaCode.getText().equals("+999"))) {
                agreeCheckBox.setSelected(false);
                registrationLabel.setText("Popunite area code!");
                Timer timer = new Timer(1000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
                setFieldsEnabled();
            }
            
        } else {
            setFieldsEnabled();
        }
    }//GEN-LAST:event_agreeCheckBoxActionPerformed

    private void ponSifraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ponSifraFocusLost

        // Provjera passworda
        if (Arrays.equals(ponSifra.getPassword(), sifra.getPassword())) {
            passwordCheckLabel.setVisible(false);
            PasswordNijeIsti = true;
        } else {
            passwordCheckLabel.setVisible(true);
            PasswordNijeIsti = false;
            
            registrationLabel.setText("Unesite jednake šifre!");
            Timer timer = new Timer(2000, e -> registrationLabel.setText("REGISTRATION"));
            timer.setRepeats(false);
            timer.start();
            userPostoji = true;
        }
    }//GEN-LAST:event_ponSifraFocusLost
    
    public void setFieldsEnabled() {
        korisnickoIme.setEditable(true);
        ime.setEditable(true);
        prezime.setEditable(true);
        sifra.setEditable(true);
        ponSifra.setEditable(true);
        mail.setEditable(true);
        telefon.setEditable(true);
        drzava.setEditable(true);
        gradRodenja.setEditable(true);
        adresa.setEditable(true);
        postanskiBroj.setEditable(true);
        godinaRod.setEnabled(true);
        danRod.setEnabled(true);
        mjRod.setEnabled(true);
        areaCode.setEnabled(true);
    }
    
    public void setFieldsDisabled() {
        korisnickoIme.setEditable(false);
        ime.setEditable(false);
        prezime.setEditable(false);
        sifra.setEditable(false);
        ponSifra.setEditable(false);
        mail.setEditable(false);
        telefon.setEditable(false);
        drzava.setEditable(false);
        gradRodenja.setEditable(false);
        adresa.setEditable(false);
        postanskiBroj.setEditable(false);
        godinaRod.setEnabled(false);
        danRod.setEnabled(false);
        mjRod.setEnabled(false);
        areaCode.setEnabled(false);
    }
    

    private void sifraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sifraFocusLost
        
        if (Arrays.equals(ponSifra.getPassword(), sifra.getPassword())) {
            passwordCheckLabel.setVisible(false);
            PasswordNijeIsti = true;
        } else {
            passwordCheckLabel.setVisible(true);
            PasswordNijeIsti = false;
            
            registrationLabel.setText("Unesite jednake šifre!");
            Timer timer = new Timer(2000, e -> registrationLabel.setText("REGISTRATION"));
            timer.setRepeats(false);
            timer.start();
            userPostoji = true;
        }

    }//GEN-LAST:event_sifraFocusLost

    private void korisnickoImeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_korisnickoImeKeyPressed

        // Brojac UserName Charactera
        CharUserLeft = korisnickoIme.getText().length();
        CharUserLeft += 1;
        brojacZnakovaUser.setText(Integer.toString(CharUserLeft));
        
        if (CharUserLeft > 20) {
            brojacZnakovaUser.setForeground(Color.RED);
        } else {
            brojacZnakovaUser.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_korisnickoImeKeyPressed

    private void korisnickoImePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_korisnickoImePropertyChange

    }//GEN-LAST:event_korisnickoImePropertyChange

    private void korisnickoImeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_korisnickoImeFocusLost
        
        try {
            RS = CALIzb.main(conn, "select * from users where F01USR = '" + korisnickoIme.getText().trim() + "'");
            
            if (RS.next() || korisnickoIme.getText().isEmpty()) {
                userFoundLabel.setVisible(true);
                userNotFoundLabel.setVisible(false);
                
                registrationLabel.setText("Korisnik postoji!");
                Timer timer = new Timer(2000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
                userPostoji = true;
                korisnickoIme.setText("");
                
            } else {
                userNotFoundLabel.setVisible(true);
                userFoundLabel.setVisible(false);
                userPostoji = false;
                
            }
        } catch (Exception e) {
            
        }
        

    }//GEN-LAST:event_korisnickoImeFocusLost

    private void exitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseClicked
        
        LoginFormGUI CALLogin = new LoginFormGUI(conn);
        CALLogin.setLocationRelativeTo(null);
        CALLogin.setVisible(true);
        dispose();
    }//GEN-LAST:event_exitLabelMouseClicked

    private void telefonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonActionPerformed

    }//GEN-LAST:event_telefonActionPerformed

    private void registrirajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrirajButtonActionPerformed
        LoginFormGUI CALLogin = new LoginFormGUI(conn);
        CALLogin.setLocationRelativeTo(null);
        if (PasswordNijeIsti && agreeCheckBox.isSelected()) {
            try {
                //Dohvacanje zadnjeg ID-a
                RS = CALIzb.main(conn, "SELECT TOP 1 F01ID FROM users ORDER BY F01ID DESC");
                while (RS.next()) {
                    MyIDNumber = RS.getInt("F01ID");
                    MyIDNumber += 1;
                }
                if (MyIDNumber == 0) {
                    MyIDNumber += 1;
                }
                //Postavljanje datuma rodenja
                danRodenja = Integer.parseInt(danRod.getSelectedItem().toString());
                mjesecRodenja = Integer.parseInt(mjRod.getSelectedItem().toString());
                godinaRodenja = godinaRod.getValue();

                //Postavljanje dana i mjeseca u string
                String dRod = "";
                String mjRod = "";
                
                dRod = PostaviDatumMj(danRodenja);
                mjRod = PostaviDatumMj(mjesecRodenja);
                String datumRodenja = Integer.toString(godinaRodenja) + mjRod.trim() + dRod.trim();

                //Kriptiranje sifre
                String cryptedPassword;
                EncryptDecryptString KS = new EncryptDecryptString();
                cryptedPassword = KS.KriptirajString(sifra.getText().trim(), 1);

                //Kreiranje broja
                String tel = areaCode.getText().trim() + telefon.getText().trim();
                tel = tel.replaceAll("\\s", ""); //brisemo space (razmak)

                //Kreiranje korisnika
                RS = CALIzb.main(conn, "INSERT INTO Users VALUES ('" + MyIDNumber + "','" + korisnickoIme.getText().trim() + "','" + ime.getText().trim() + "','" + prezime.getText().trim() + "','" + cryptedPassword + "','" + mail.getText().trim() + "',convert(date,'" + datumRodenja.trim() + "',112),'" + gradRodenja.getText().trim() + "','" + drzava.getSelectedItem().toString().toUpperCase().trim() + "','" + adresa.getText().trim() + "','" + postanskiBroj.getText().trim() + "','" + tel + "', " + "GETDATE ( )  " + "," + "GETDATE ( )  " + ",'1')");
                
                PopError CALError = new PopError();
                CALError.infoBox("Registracija uspješna!", "Success!");
                CALLogin.setVisible(true);
                dispose();
                
            } catch (Exception e) {
                
            }
        } else {
            if (!PasswordNijeIsti) {
                registrationLabel.setText("Šifre nisu iste!");
                Timer timer = new Timer(2000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
            } else if (!agreeCheckBox.isSelected()) {
                registrationLabel.setText("Niste prihvatili sporazume!");
                Timer timer = new Timer(2000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
            }
        }
    }//GEN-LAST:event_registrirajButtonActionPerformed
    
    private String PostaviDatumMj(int broj) {
        String stBroj = "";
        if (broj > 0 && broj < 10) {
            stBroj = "0" + Integer.toString(broj);
            stBroj = stBroj.replaceAll("\\s", ""); //brisemo space (razmak)
        } else {
            stBroj = Integer.toString(broj);
        }
        return stBroj;
    }

    private void korisnickoImeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_korisnickoImeFocusGained
        
        if (MyFirstLogUsername == 0) {
            korisnickoIme.setText("");
            MyFirstLogUsername++;
        }
    }//GEN-LAST:event_korisnickoImeFocusGained

    private void imeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_imeFocusGained
        
        if (MyFirstLogName == 0) {
            ime.setText("");
            MyFirstLogName++;
        }
    }//GEN-LAST:event_imeFocusGained

    private void prezimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prezimeFocusGained
        
        if (MyFirstLogSurname == 0) {
            prezime.setText("");
            MyFirstLogSurname++;
        }
    }//GEN-LAST:event_prezimeFocusGained

    private void sifraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sifraFocusGained
        
        if (MyFirstLogPass == 0) {
            sifra.setText("");
            MyFirstLogPass++;
        }
    }//GEN-LAST:event_sifraFocusGained

    private void ponSifraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ponSifraFocusGained
        if (MyFirstLogPassSec == 0) {
            ponSifra.setText("");
            MyFirstLogPassSec++;
        }
    }//GEN-LAST:event_ponSifraFocusGained

    private void mailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mailFocusGained
        
        if (MyFirstLogMail == 0) {
            mail.setText("");
            MyFirstLogMail++;
        }
    }//GEN-LAST:event_mailFocusGained

    private void telefonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonFocusGained
        if (MyFirstLogBrTel == 0) {
            telefon.setText("");
            MyFirstLogBrTel++;
        }

    }//GEN-LAST:event_telefonFocusGained

    private void gradRodenjaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gradRodenjaFocusGained
        
        if (MyFirstLogGradRodenja == 0) {
            gradRodenja.setText("");
            MyFirstLogGradRodenja++;
        }
    }//GEN-LAST:event_gradRodenjaFocusGained

    private void adresaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adresaFocusGained
        
        if (MyFirstLogAdresa == 0) {
            adresa.setText("");
            MyFirstLogAdresa++;
        }
    }//GEN-LAST:event_adresaFocusGained

    private void postanskiBrojFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_postanskiBrojFocusGained
        
        if (MyFirstLogPostBroj == 0) {
            postanskiBroj.setText("");
            MyFirstLogPostBroj++;
        }
    }//GEN-LAST:event_postanskiBrojFocusGained

    private void imeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_imeFocusLost
        ime.setText(ime.getText().toUpperCase());
    }//GEN-LAST:event_imeFocusLost

    private void prezimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prezimeFocusLost
        prezime.setText(prezime.getText().toUpperCase());
    }//GEN-LAST:event_prezimeFocusLost

    private void mailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mailFocusLost
        mail.setText(mail.getText().toUpperCase());
        if (!mail.getText().toLowerCase().contains("@")) {
            registrationLabel.setText("Mail nije ispravan!");
            Timer timer = new Timer(1000, e -> registrationLabel.setText("REGISTRATION"));
            timer.setRepeats(false);
            timer.start();
            mail.setText(null);
        }
        
        try {
            RS = CALIzb.main(conn, "select * from users where F01EMA = '" + mail.getText().trim() + "'");
            
            if (RS.next() || mail.getText().isEmpty()) {
                
                registrationLabel.setText("Mail postoji!");
                mail.setText("");
                Timer timer = new Timer(2000, e -> registrationLabel.setText("REGISTRATION"));
                timer.setRepeats(false);
                timer.start();
                userPostoji = true;
                
            } else {
                
            }
        } catch (Exception e) {
            
        }
        

    }//GEN-LAST:event_mailFocusLost

    private void telefonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonFocusLost

    }//GEN-LAST:event_telefonFocusLost

    private void gradRodenjaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gradRodenjaFocusLost
        gradRodenja.setText(gradRodenja.getText().toUpperCase());
    }//GEN-LAST:event_gradRodenjaFocusLost

    private void adresaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adresaFocusLost
        adresa.setText(adresa.getText().toUpperCase());

    }//GEN-LAST:event_adresaFocusLost

    private void postanskiBrojFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_postanskiBrojFocusLost

    }//GEN-LAST:event_postanskiBrojFocusLost

    private void godinaRodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_godinaRodFocusLost
        

    }//GEN-LAST:event_godinaRodFocusLost

    private void telefonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonKeyTyped
        
        ZabraniSlova(evt);
    }//GEN-LAST:event_telefonKeyTyped

    private void postanskiBrojKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_postanskiBrojKeyTyped
        
        ZabraniSlova(evt);
    }//GEN-LAST:event_postanskiBrojKeyTyped

    private void godinaRodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_godinaRodKeyTyped

    }//GEN-LAST:event_godinaRodKeyTyped

    private void imeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imeKeyTyped
        
        ZabraniBrojeve(evt);
    }//GEN-LAST:event_imeKeyTyped

    private void prezimeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prezimeKeyTyped
        
        ZabraniBrojeve(evt);
    }//GEN-LAST:event_prezimeKeyTyped

    private void gradRodenjaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gradRodenjaKeyTyped
        
        ZabraniBrojeve(evt);
    }//GEN-LAST:event_gradRodenjaKeyTyped

    private void adresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adresaKeyTyped

    }//GEN-LAST:event_adresaKeyTyped

    private void mailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mailKeyTyped

    }//GEN-LAST:event_mailKeyTyped

    private void drzavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drzavaActionPerformed

    }//GEN-LAST:event_drzavaActionPerformed

    private void areaCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaCodeActionPerformed

    }//GEN-LAST:event_areaCodeActionPerformed

    private void areaCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_areaCodeFocusGained
        
        if (MyFirstLogArea == 0) {
            areaCode.setText("+");
            MyFirstLogArea++;
        }
    }//GEN-LAST:event_areaCodeFocusGained

    private void areaCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaCodeKeyTyped
        
        ZabraniSlova(evt);
    }//GEN-LAST:event_areaCodeKeyTyped

    private void areaCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_areaCodeFocusLost
        
        String area = areaCode.getText().trim();
        if (!area.startsWith("+")) {
            area = "+" + area;
            area = area.replaceAll("\\s", ""); //brisemo space (razmak)
            areaCode.setText(area);
        }
    }//GEN-LAST:event_areaCodeFocusLost

    private void areaCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaCodeKeyPressed
        if (areaCode.getText().trim().equals("")) {
            areaCode.setText("+");
        }
    }//GEN-LAST:event_areaCodeKeyPressed
    
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

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresa;
    private javax.swing.JLabel adresaLabel;
    private javax.swing.JCheckBox agreeCheckBox;
    private javax.swing.JLabel agreemLabelOne;
    private javax.swing.JLabel agreemLabelTwo;
    private javax.swing.JLabel agreemLabelZero;
    private javax.swing.JTextField areaCode;
    private javax.swing.JLabel avatarLabel;
    private javax.swing.JLabel brojTelLabel;
    private javax.swing.JLabel brojacZnakovaUser;
    private javax.swing.JComboBox<String> danRod;
    private javax.swing.JLabel danRodLabel;
    private javax.swing.JLabel drzLabel;
    private javax.swing.JComboBox<String> drzava;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JLabel godRodLabel;
    private com.toedter.calendar.JYearChooser godinaRod;
    private javax.swing.JLabel gradRodLabel;
    private javax.swing.JTextField gradRodenja;
    private javax.swing.JTextField ime;
    private javax.swing.JLabel imeLabel;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField korisnickoIme;
    private javax.swing.JLabel korisnickoImeLabel;
    private javax.swing.JTextField mail;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JLabel maxBrojacZnakovaUser;
    private javax.swing.JComboBox<String> mjRod;
    private javax.swing.JLabel mjesecRodLabel;
    private javax.swing.JLabel passwordCheckLabel;
    private javax.swing.JPasswordField ponSifra;
    private javax.swing.JLabel ponovljenaSifraLabel;
    private javax.swing.JLabel posBrojLabel;
    private javax.swing.JTextField postanskiBroj;
    private javax.swing.JSeparator praznaLinija;
    private javax.swing.JSeparator praznaLinijaN;
    private javax.swing.JTextField prezime;
    private javax.swing.JLabel prezimeLabel;
    private javax.swing.JLabel registrationLabel;
    private javax.swing.JButton registrirajButton;
    private javax.swing.JPasswordField sifra;
    private javax.swing.JLabel sifraLabel;
    private javax.swing.JTextField telefon;
    private javax.swing.JPanel txt_BrTel;
    private javax.swing.JLabel userFoundLabel;
    private javax.swing.JLabel userNotFoundLabel;
    // End of variables declaration//GEN-END:variables
}
