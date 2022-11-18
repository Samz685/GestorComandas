/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginfxml;

/**
 *
 * @author Syzer
 */
public class ProductoVenta {
    
    private String nombre;
    private Integer venta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVenta() {
        return venta;
    }

    public void setVenta(Integer venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "ProductoVenta{" + "nombre=" + nombre + ", venta=" + venta + '}';
    }
    
    
    
}
