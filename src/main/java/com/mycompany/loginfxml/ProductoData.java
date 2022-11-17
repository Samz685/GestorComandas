/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginfxml;

import java.util.ArrayList;
import models.Producto;

/**
 *
 * @author Syzer
 */
public class ProductoData {
 
    private static ArrayList<Producto> producto;

    public static ArrayList<Producto> getProducto() {
        return producto;
    }

    public static void setProducto(ArrayList<Producto> producto) {
        ProductoData.producto = producto;
    }
    
}
