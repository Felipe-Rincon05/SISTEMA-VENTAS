/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO.dto;

import java.util.Objects;

/**
 *
 * @author Felipe Rincón
 */
public class ClienteDTO {
    private int id_c;
    private String nombre;
    private String correo;
    private String direccion;
    private int estado;

    public ClienteDTO() {
    }

    public ClienteDTO(int id_c, String nombre, String correo, String direccion, int estado) {
        this.id_c = id_c;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteDTO other = (ClienteDTO) obj;
        if (this.id_c != other.id_c) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return Objects.equals(this.direccion, other.direccion);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id_c;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.correo);
        hash = 17 * hash + Objects.hashCode(this.direccion);
        hash = 17 * hash + this.estado;
        return hash;
    }

       
    @Override
    public String toString() {
        return nombre + " - " + id_c;
    }
    
    
    
}
