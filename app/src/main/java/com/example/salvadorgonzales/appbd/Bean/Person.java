package com.example.salvadorgonzales.appbd.Bean;

/**
 * Created by Salvador Gonzales on 02/05/2017.
 */

public class Person {

    public Integer id;
    public String codProducto;
    public String desProducto;
    public int cantidad;
    public int precioReal;
    public int totalReal;

    public Person(){}

    public Person(Integer id, String codProducto, String desProducto, int cantidad, int precioReal, int totalReal) {
        this.id = id;
        this.codProducto = codProducto;
        this.desProducto = desProducto;
        this.cantidad = cantidad;
        this.precioReal = precioReal;
        this.totalReal = totalReal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getDesProducto() {
        return desProducto;
    }

    public void setDesProducto(String desProducto) {
        this.desProducto = desProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioReal() {
        return precioReal;
    }

    public void setPrecioReal(int precioReal) {
        this.precioReal = precioReal;
    }

    public int getTotalReal() {
        return totalReal;
    }

    public void setTotalReal(int totalReal) {
        this.totalReal = totalReal;
    }

    @Override
    public String toString() {
        return id + " " + codProducto + " " + desProducto + " " + cantidad + " " + precioReal + " " + totalReal;}

}
