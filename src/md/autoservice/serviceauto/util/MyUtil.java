package md.autoservice.serviceauto.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iurasun
 */
public class MyUtil {

    //constants
    public static String PROPS_FILE_NAME = "db.properties";
    public static boolean DEBUG = true;

    public static int getNrRows(Connection conn, String tabelaName) {

        int nr = 0;

        try (Statement stat = conn.createStatement();) {

            ResultSet rs = stat.executeQuery("SELECT COUNT(*) FROM " + tabelaName);
            if (rs.next()) {
                nr = rs.getInt(1);
            }
            rs.close();
            stat.close();

        } catch (SQLException ex) {
            Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nr;
    }

    public static int getMaxId(Connection conn, String tabelaName) {

        int nr = 0;

        try (Statement stat = conn.createStatement();) {

            ResultSet rs = stat.executeQuery("SELECT MAX(id) FROM " + tabelaName);
            if (rs.next()) {
                nr = rs.getInt(1);
            }

            rs.close();
            stat.close();

        } catch (SQLException ex) {
            Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nr;
    }

    public static void closeConnection(Connection conn) throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
