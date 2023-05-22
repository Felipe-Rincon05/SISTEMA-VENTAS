/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONEXIONES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class MysqlBD {
    private static MysqlBD instance;
    String bd="proyecto_ventas";
    String url="jdbc:mysql:// localhost:3306/";
    String user="root";
    String password="Felipe!12345";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection con;
    private MysqlBD(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url+bd, user, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("error en driver bd " + ex.getMessage());
        } catch (SQLException ex){
            System.out.println("error en conexion bd " + ex.getMessage());
        }
    }
    
    //metodo que obtiene la instacia 
    public static synchronized MysqlBD getInstance() {
        if (instance == null) {
            instance = new MysqlBD();
        }
        return instance;
    }
    
     public void cerrarConexion() {
        instance = null;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
