/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO.dao;

import CONEXIONES.MysqlBD;
import INTERFACES.ObligacionBD;
import MODELO.dto.EmpleadoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author User
 */
public class EmpleadoDAO implements ObligacionBD<EmpleadoDTO> {
    
    private static final String SQL_CREATE = "INSERT INTO empleado(id_e, contrasena, nombre, correo, telefono, estado_e, usuario) VALUES(?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_DELETE = "DELETE FROM empleado WHERE id_e = ? ";

    private static final String SQL_UPDATE = "UPDATE empleado SET contrasena = ?, correo = ?, telefono = ?, estado_e = ?, usuario = ? WHERE id_e = ? ";

    private static final String SQL_READ = "SELECT * FROM empleado WHERE id_e = ? ";

    private static final String SQL_READALL = "SELECT * FROM empleado";
    
    private static final String SQL_VALIDAR = "SELECT * FROM empleado WHERE usuario = ? AND contrasena = ?";

    private static MysqlBD con = MysqlBD.getInstance();
    ResultSet rs;
    PreparedStatement ps;
    boolean flag=false;
    
    public EmpleadoDTO validar(String usuario, String contrasena){
        EmpleadoDTO em = new EmpleadoDTO();
        
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_VALIDAR);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            while (rs.next()){
                em.setId(rs.getInt("id_e"));
                em.setUser(rs.getString("usuario"));
                em.setContrasena(rs.getString("contrasena"));
                em.setNombre(rs.getString("nombre"));
                em.setCorreo(rs.getString("correo"));
            }
        } catch (SQLException e) {
            System.out.println("error en validar el login " + e.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return em;
    }

    @Override
    public boolean create(EmpleadoDTO nuevo) {
        flag = false;
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_CREATE);
            ps.setInt(1, nuevo.getId());
            ps.setString(2, nuevo.getContrasena());
            ps.setString(3, nuevo.getNombre());
            ps.setString(4, nuevo.getCorreo());
            ps.setString(5, nuevo.getTel());
            ps.setInt(6, nuevo.getEstado());
            ps.setString(7, nuevo.getUser());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.out.println("error en crear el empleado " + e.getMessage());
            flag = false;
        } finally {
            con.cerrarConexion();
        }
        return flag;
    }

    @Override
    public List<EmpleadoDTO> readAll() {
        List<EmpleadoDTO> lista = new ArrayList<>();
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_READALL);
            rs = ps.executeQuery();
            while(rs.next()){
                EmpleadoDTO em = new EmpleadoDTO();
                em.setId(rs.getInt(1));
                em.setContrasena(rs.getString(2));
                em.setNombre(rs.getString(3));
                em.setCorreo(rs.getString(4));
                em.setTel(rs.getString(5));
                em.setEstado(rs.getInt(6));
                em.setUser(rs.getString(7));
                lista.add(em);
            }
        } catch (SQLException e) {
            System.out.println("error en listar el empleado " + e.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return lista;
    }

    @Override
    public EmpleadoDTO read(EmpleadoDTO filter) {
        EmpleadoDTO em = new EmpleadoDTO();
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_READ);
            ps.setInt(1, filter.getId());
            rs = ps.executeQuery();
            while(rs.next()){
                em.setId(rs.getInt(1));
                em.setContrasena(rs.getString(2));
                em.setNombre(rs.getString(3));
                em.setCorreo(rs.getString(4));
                em.setTel(rs.getString(5));
                em.setEstado(rs.getInt(6));
                em.setUser(rs.getString(7));
            }
        } catch (SQLException e) {
            System.out.println("error en buscar el empleado " + e.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return em;
    }

    @Override
    public boolean update(EmpleadoDTO item) {
        flag = false;
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_UPDATE);
            
            ps.setString(1, item.getContrasena());
            ps.setString(2, item.getCorreo());
            ps.setString(3, item.getTel());
            ps.setInt(4, item.getEstado());
            ps.setString(5, item.getUser());
            ps.setInt(6, item.getId());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.out.println("error en actualizar el empleado " + e.getMessage());
            flag = false;
        } finally {
            con.cerrarConexion();
        }
        return flag;
    }

    @Override
    public boolean delete(EmpleadoDTO item) {
        flag = false;
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_DELETE);
            ps.setInt(1, item.getId());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.out.println("error en borrar el empleado " + e.getMessage());
            flag = false;
        } finally {
            con.cerrarConexion();
        }
        return flag;
    }

    
    
}
