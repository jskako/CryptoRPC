/*
 Registiranje konekcije te izvršavanje skripte na bazi
 */
package cryptoseminar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jskako
 */
public class ExecuteScriptsOnDatabase {

    private Connection CONN;
    private String SQL;
    ResultSet rs;
    public  ResultSet main(Connection conn, String sql) {
        this.CONN = conn;
        this.SQL = sql;
        System.out.println(SQL);
        try {
            Statement stmt = CONN.createStatement();
            rs = stmt.executeQuery(SQL);
        } catch (SQLException e) {

        } 
        
        return rs;

    }
}
