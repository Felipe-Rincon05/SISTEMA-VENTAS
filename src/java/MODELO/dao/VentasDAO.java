/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO.dao;

import CONEXIONES.MysqlBD;
import MODELO.dto.VentasDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Felipe Rincón
 */
public class VentasDAO {
    
    private static final String SQL_CREATE = "INSERT INTO ventas(id_ventas, numero_serie, fecha_venta, monto, estado, id_c, id_e) VALUES(?, ?, now(), ?, ?, ?, ?)";

    private static final String SQL_DELETE = "DELETE FROM ventas WHERE id_ventas = ? ";

    private static final String SQL_UPDATE = "UPDATE ventas SET estado = ? WHERE id_ventas = ? ";

    private static final String SQL_READ = "SELECT MAX(id_ventas) FROM ventas";

    private static final String SQL_READALL = "SELECT * FROM ventas";
    
    private static final String SQL_GENERAR_SERIE = "SELECT max(numero_serie) FROM ventas";

    private static MysqlBD con = MysqlBD.getInstance();
    ResultSet rs;
    PreparedStatement ps;
    boolean flag=false;
    
    public String generar_serie (){
        String numero_serie = "";
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_GENERAR_SERIE);
            rs = ps.executeQuery();
            while (rs.next()){
                numero_serie = rs.getNString(1);
            }
        } catch (SQLException e) {
            System.out.println("error en generar el numero de serie " + e.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return numero_serie;
    }
    
    
    public boolean create(VentasDTO nuevo) {
        flag = false;
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_CREATE);
            ps.setInt(1, nuevo.getId());
            ps.setString(2, nuevo.getNum_serie());
            ps.setDouble(3, nuevo.getMonto());
            ps.setInt(4, nuevo.getEstado());
            ps.setInt(5, nuevo.getId_cliente());
            ps.setInt(6, nuevo.getId_empleado());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.out.println("error en crear la venta " + e.getMessage());
            flag = false;
        } finally {
            con.cerrarConexion();
        }
        return flag;
    }

    public String read() {
        String id_ventas = "";
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_READ);
            rs = ps.executeQuery();
            while(rs.next()){
                id_ventas = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("error en buscar la venta " + e.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return id_ventas;
    }

}
