/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionMysql;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rudy Bravo
 */
public class Conexion {

    String db = "punto_venta";
    String user = "root";
    String password = "Mysql@123";
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/";
    Connection con;
    Statement stmt;

    public Conexion() {
        //this.con = con;
    }

    // metodo para conectarse a la base de datos
    public Connection conectar() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + db, user, password);
            stmt = con.createStatement();
            
            System.out.println("Conexión exitosa a la Base de Datos");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en la conexión a la base de datos " + db);
            // Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void desconectar() {
        try {
            con.close();
            System.out.println("Base de datos desconectada");
        } catch (SQLException ex) {
            System.out.println("La conexion a la base de datos ha quedado abierta");
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
