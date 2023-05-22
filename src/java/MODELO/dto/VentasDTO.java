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
public class VentasDTO {
    private int id;
    private int item;
    private int id_cliente;
    private int id_empleado;
    private int id_producto;
    private String num_serie;
    private String descripcion_p;
    private String fecha;
    private double precio;
    private int cantidad;
    private double subtotal;
    private double monto;
    private int estado;

    public VentasDTO() {
    }

    public VentasDTO(int id, int item, int id_cliente, int id_empleado, int id_producto, String num_serie, String descripcion_p, String fecha, double precio, int cantidad, double subtotal, double monto, int estado) {
        this.id = id;
        this.item = item;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.id_producto = id_producto;
        this.num_serie = num_serie;
        this.descripcion_p = descripcion_p;
        this.fecha = fecha;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.monto = monto;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public String getDescripcion_p() {
        return descripcion_p;
    }

    public void setDescripcion_p(String descripcion_p) {
        this.descripcion_p = descripcion_p;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.id;
        hash = 11 * hash + this.item;
        hash = 11 * hash + this.id_cliente;
        hash = 11 * hash + this.id_empleado;
        hash = 11 * hash + this.id_producto;
        hash = 11 * hash + Objects.hashCode(this.num_serie);
        hash = 11 * hash + Objects.hashCode(this.descripcion_p);
        hash = 11 * hash + Objects.hashCode(this.fecha);
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 11 * hash + this.cantidad;
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.subtotal) ^ (Double.doubleToLongBits(this.subtotal) >>> 32));
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.monto) ^ (Double.doubleToLongBits(this.monto) >>> 32));
        hash = 11 * hash + this.estado;
        return hash;
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
        final VentasDTO other = (VentasDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.item != other.item) {
            return false;
        }
        if (this.id_cliente != other.id_cliente) {
            return false;
        }
        if (this.id_empleado != other.id_empleado) {
            return false;
        }
        if (this.id_producto != other.id_producto) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (Double.doubleToLongBits(this.subtotal) != Double.doubleToLongBits(other.subtotal)) {
            return false;
        }
        if (Double.doubleToLongBits(this.monto) != Double.doubleToLongBits(other.monto)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.num_serie, other.num_serie)) {
            return false;
        }
        if (!Objects.equals(this.descripcion_p, other.descripcion_p)) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }

    @Override
    public String toString() {
        return fecha +" - "+ monto;
    }
    
    
}


