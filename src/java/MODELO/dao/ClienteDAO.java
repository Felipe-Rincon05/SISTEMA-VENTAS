/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO.dao;

import CONEXIONES.MysqlBD;
import INTERFACES.ObligacionBD;
import MODELO.dto.ClienteDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe Rincón
 */
public class ClienteDAO implements ObligacionBD<ClienteDTO>{
    
    private static final String SQL_CREATE = "INSERT INTO cliente(id_c, nombre, correo, direccion, estado_c) VALUES(?, ?, ?, ?, ?)";

    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_c = ? ";

    private static final String SQL_UPDATE = "UPDATE cliente SET correo = ?, direccion = ?, estado_c = ? WHERE id_c = ? ";

    private static final String SQL_READ = "SELECT * FROM cliente WHERE id_c = ? ";

    private static final String SQL_READALL = "SELECT * FROM cliente";
    
    private static MysqlBD con = MysqlBD.getInstance();
    ResultSet rs;
    PreparedStatement ps;
    boolean flag=false;

    @Override
    public boolean create(ClienteDTO nuevo) {
        flag = false;
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_CREATE);
            ps.setInt(1, nuevo.getId_c());
            ps.setString(2, nuevo.getNombre());
            ps.setString(3, nuevo.getCorreo());
            ps.setString(4, nuevo.getDireccion());
            ps.setInt(5, nuevo.getEstado());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.out.println("error en crear el cliente " + e.getMessage());
            flag = false;
        } finally {
            con.cerrarConexion();
        }
        return flag;
    }

    @Override
    public List<ClienteDTO> readAll() {
        List<ClienteDTO> lista = new ArrayList<>();
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_READALL);
            rs = ps.executeQuery();
            while(rs.next()){
                ClienteDTO cl = new ClienteDTO();
                cl.setId_c(rs.getInt(1));
                cl.setNombre(rs.getString(2));
                cl.setCorreo(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setEstado(rs.getInt(5));
                lista.add(cl);
            }
        } catch (SQLException e) {
            System.out.println("error en listar el cliente " + e.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return lista;
    }

    @Override
    public ClienteDTO read(ClienteDTO filter) {
        ClienteDTO cl = new ClienteDTO();
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_READ);
            ps.setInt(1, filter.getId_c());
            rs = ps.executeQuery();
            while(rs.next()){
                cl.setId_c(rs.getInt(1));
                cl.setNombre(rs.getString(2));
                cl.setCorreo(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setEstado(rs.getInt(5));
            }
        } catch (SQLException e) {
            System.out.println("error en buscar el cliente " + e.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return cl;
    }

    @Override
    public boolean update(ClienteDTO item) {
        flag = false;
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_UPDATE);
            
            ps.setString(1, item.getCorreo());
            ps.setString(2, item.getDireccion());
            ps.setInt(3, item.getEstado());
            ps.setInt(4, item.getId_c());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.out.println("error en actualizar el cliente " + e.getMessage());
            flag = false;
        } finally {
            con.cerrarConexion();
        }
        return flag;
    }

    @Override
    public boolean delete(ClienteDTO item) {
        flag = false;
        try {
            con = MysqlBD.getInstance();
            ps = con.getCon().prepareStatement(SQL_DELETE);
            ps.setInt(1, item.getId_c());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.out.println("error en borrar el cliente " + e.getMessage());
            flag = false;
        } finally {
            con.cerrarConexion();
        }
        return flag;
    }
    
}
