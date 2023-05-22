/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO.dao;

import CONEXIONES.MysqlBD;
import INTERFACES.ObligacionBD;
import MODELO.dto.DetallesVenDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Felipe Rincón
 */
public class DetallesVenDAO implements ObligacionBD<DetallesVenDTO>{
    
    private static final String SQL_CREATE = "INSERT INTO detalles_ventas(id_detven, cantidad, precio_venta, id_ventas, id_producto) VALUES(?, ?, ?, ?, ?)";

    private static MysqlBD con = MysqlBD.getInstance();
    ResultSet rs;
    PreparedStatement ps;
    boolean flag=false;

    @Override
    public boolean create(DetallesVenDTO nuevo) {
        flag = false;
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_CREATE);
            ps.setInt(1, nuevo.getId());
            ps.setInt(2, nuevo.getCantidad());
            ps.setDouble(3, nuevo.getPrecio());
            ps.setInt(4, nuevo.getId_ventas());
            ps.setInt(5, nuevo.getId_prodcuto());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.out.println("error en crear el detalle venta " + e.getMessage());
            flag = false;
        } finally {
            con.cerrarConexion();
        }
        return flag;
    }

    @Override
    public List<DetallesVenDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetallesVenDTO read(DetallesVenDTO filter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(DetallesVenDTO item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(DetallesVenDTO item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
