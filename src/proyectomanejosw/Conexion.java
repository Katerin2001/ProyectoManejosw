package proyectomanejosw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Erik
 */
public class Conexion {
//METODO PARA CONECTAR A LA BASE DE DATOS

    Connection con;

    public Connection conectar() {

        String driverCon = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driverCon);
            con = DriverManager.getConnection("jdbc:mysql://localhost/proyectomcs", "root", "");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la Base de datos");

        }
        return con;
    }
}
