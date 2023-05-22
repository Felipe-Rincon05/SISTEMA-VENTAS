/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO.dto;

/**
 *
 * @author Felipe Rincón
 */
public class DetallesVenDTO {
    private int id;
    private int cantidad;
    private double precio;
    private int id_ventas;
    private int id_prodcuto;

    public DetallesVenDTO() {
    }

    public DetallesVenDTO(int id, int cantidad, double precio, int id_ventas, int id_prodcuto) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.id_ventas = id_ventas;
        this.id_prodcuto = id_prodcuto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_ventas() {
        return id_ventas;
    }

    public void setId_ventas(int id_ventas) {
        this.id_ventas = id_ventas;
    }

    public int getId_prodcuto() {
        return id_prodcuto;
    }

    public void setId_prodcuto(int id_prodcuto) {
        this.id_prodcuto = id_prodcuto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + this.cantidad;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 89 * hash + this.id_ventas;
        hash = 89 * hash + this.id_prodcuto;
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
        final DetallesVenDTO other = (DetallesVenDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.id_ventas != other.id_ventas) {
            return false;
        }
        return this.id_prodcuto == other.id_prodcuto;
    }

    @Override
    public String toString() {
        return id + " - " + precio;
    }
    
    
}
