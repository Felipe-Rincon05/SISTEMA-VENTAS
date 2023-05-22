/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO.dao;

import CONEXIONES.MysqlBD;
import INTERFACES.ObligacionBD;
import MODELO.dto.ProductoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe Rincón
 */
public class ProductoDAO implements ObligacionBD<ProductoDTO>{
    
    private static final String SQL_CREATE = "INSERT INTO producto (id_producto, nombre, precio, stock, estado) VALUES(?, ?, ?, ?, ?)";

    private static final String SQL_DELETE = "DELETE FROM producto WHERE id_producto = ? ";

    private static final String SQL_UPDATE = "UPDATE producto SET nombre = ?, precio = ?, stock = ?, estado = ? WHERE id_producto = ? ";

    private static final String SQL_READ = "SELECT * FROM producto WHERE id_producto = ? ";

    private static final String SQL_READALL = "SELECT * FROM producto";
    
    private static final String SQL_UPDATE_STOCK = "UPDATE producto SET stock = ? WHERE id_producto = ? ";
    
    
    
    private static MysqlBD con = MysqlBD.getInstance();
    ResultSet rs;
    PreparedStatement ps;
    boolean flag=false;
    
    public boolean updateStock (int stock, int id_pr) {
        flag = false;
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_UPDATE_STOCK);
            
            ps.setInt(1, stock);
            ps.setInt(2, id_pr);
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.out.println("error en actualizar el stock " + e.getMessage());
            flag = false;
        } finally {
            con.cerrarConexion();
        }
        return flag;
    }
    
    public ProductoDTO buscar(int id_p) {
        ProductoDTO pr = new ProductoDTO();
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_READ);
            ps.setInt(1, id_p);
            rs = ps.executeQuery();
            while(rs.next()){
                pr.setId_producto(rs.getInt(1));
                pr.setNombre(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getInt(5));
            }
        } catch (SQLException e) {
            System.out.println("error en buscar el producto " + e.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return pr;
    }
    
    @Override
    public boolean create(ProductoDTO nuevo) {
        flag = false;
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_CREATE);
            ps.setInt(1, nuevo.getId_producto());
            ps.setString(2, nuevo.getNombre());
            ps.setDouble(3, nuevo.getPrecio());
            ps.setInt(4, nuevo.getStock());
            ps.setInt(5, nuevo.getEstado());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.out.println("error en crear el producto " + e.getMessage());
            flag = false;
        } finally {
            con.cerrarConexion();
        }
        return flag;
    }

    @Override
    public List<ProductoDTO> readAll() {
        List<ProductoDTO> lista = new ArrayList<>();
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_READALL);
            rs = ps.executeQuery();
            while(rs.next()){
                ProductoDTO pr = new ProductoDTO();
                pr.setId_producto(rs.getInt(1));
                pr.setNombre(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getInt(5));
                lista.add(pr);
            }
        } catch (SQLException e) {
            System.out.println("error en listar el producto " + e.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return lista;
    }

    @Override
    public ProductoDTO read(ProductoDTO filter) {
        ProductoDTO pr = new ProductoDTO();
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_READ);
            ps.setInt(1, filter.getId_producto());
            rs = ps.executeQuery();
            while(rs.next()){
                pr.setId_producto(rs.getInt(1));
                pr.setNombre(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getInt(5));
            }
        } catch (SQLException e) {
            System.out.println("error en buscar el producto " + e.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return pr;
    }

    @Override
    public boolean update(ProductoDTO item) {
        flag = false;
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_UPDATE);
            
            ps.setString(1, item.getNombre());
            ps.setDouble(2, item.getPrecio());
            ps.setInt(3, item.getStock());
            ps.setInt(4, item.getEstado());
            ps.setInt(5, item.getId_producto());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.out.println("error en actualizar el producto " + e.getMessage());
            flag = false;
        } finally {
            con.cerrarConexion();
        }
        return flag;
    }

    @Override
    public boolean delete(ProductoDTO item) {
        flag = false;
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_DELETE);
            ps.setInt(1, item.getId_producto());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.out.println("error en borrar el producto " + e.getMessage());
            flag = false;
        } finally {
            con.cerrarConexion();
        }
        return flag;
    }
    
}
