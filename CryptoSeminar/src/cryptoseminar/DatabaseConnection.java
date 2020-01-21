/*
 Spajanje na bazu
 */
package cryptoseminar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author josips
 */
public class DatabaseConnection {

//Definiranje parametara
    Statement stmt = null;
    String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    Connection conn = null;
    String DB_URL = null;
    private final String ConnectionDB = "brik"; 
    private final int portDB = 1433;
    private final String dataBaseName = "obuka"; 
    
    public void main() {
        
       
        try {
            
            DB_URL = "jdbc:sqlserver://" + ConnectionDB + ":" + portDB + ";"
                    + "databaseName=" + dataBaseName + ";integratedSecurity=true;";
            // 2. Registriranje drivera
            Class.forName(JDBC_DRIVER);
            // 3. Otvaranje i testiranje konekcije
            conn = DriverManager.getConnection(DB_URL);     
            //4. Zvanje log-in screen
       
            LoginFormGUI CALLogin = new LoginFormGUI(conn);
            CALLogin.setLocationRelativeTo(null);
            CALLogin.setVisible(true);
        } catch (SQLException f) {
            //Podigni Error
            PopError CALError = new PopError();
            CALError.infoBox("Neuspješno spajanje na bazu", "Error!");
            f.printStackTrace();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Zatvaranje resursa
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            
        }
        
    }
    
}
