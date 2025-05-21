package com.ap.binario.service.eddLineales;

public class NodoAB {


    public int id;
    public int frecuencia;
    public NodoAB izq;
    public NodoAB der;

    public NodoAB(int id) {
        this.id = id;
        this.frecuencia = 1;
        this.izq = null;
        this.der = null;
    }
}




