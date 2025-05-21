package com.ap.binario.service.eddLineales;

public class NodoAB {


    public int id;
    public NodoAB izq;
    public NodoAB der;

    public NodoAB(int id) {
        this.id = id;
        this.izq = null;
        this.der = null;
    }
}




