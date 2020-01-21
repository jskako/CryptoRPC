/*
 Ovo će nam služiti za ispis popup poruka
 */
package cryptoseminar;

import javax.swing.JOptionPane;

/**
 *
 * @author josips
 */
public class PopError {

    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
