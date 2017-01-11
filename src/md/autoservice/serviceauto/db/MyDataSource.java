package md.autoservice.serviceauto.db;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import md.autoservice.serviceauto.util.MyUtil;

/**
 *
 * @author iurasun
 */
public class MyDataSource {

    private Properties props;

    private static final Logger LOG = Logger.getLogger(MyDataSource.class.getName());

    //Singleton
    private static MyDataSource instance;

    public static MyDataSource getInstace() {

        if (instance == null) {

            instance = new MyDataSource();
        }

        return instance;
    }

    private MyDataSource() {
        //pentru testare signleton
        contor++;

        try {
            loadProperties();
            LOG.info("proprietatile incarcate cu succes");

            loadDriver();
            LOG.info("driver incarcat cu succes");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "DATA-source", ex);
        }
    }

//pentru testare signleton    
    private static int contor;
//pentru testare signleton    

    public void show() {
        System.out.println("contor=" + contor);
    }

    private void loadProperties() throws Exception {
        props = new Properties();
        props.load(new FileReader(MyUtil.PROPS_FILE_NAME));

        if (MyUtil.DEBUG) { // DEBUG == true
            props.list(System.out);
            System.out.println("PAROLA=" + props.getProperty("db.password"));
        }

    }

    private void loadDriver() throws Exception {
        Class.forName(props.getProperty("db.driver"));
    }

    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password"));
    }

}
/*
db.password=free
db.user=root
db.url=jdbc:mysql://localhost:3306/autoservice
db.driver=com.mysql.jdbc.Driver
*/
