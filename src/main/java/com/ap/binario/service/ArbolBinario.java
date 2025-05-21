package com.ap.binario.service;

import com.ap.binario.service.eddLineales.NodoAB;

public class ArbolBinario {

    public NodoAB insertar(NodoAB  raiz, int valor) {
        if (raiz == null) {
            return new NodoAB (valor);
        }
        if (valor < raiz.id) {
            // Va a la izquierda
            raiz.izq = insertar(raiz.izq, valor);
        } else if (valor > raiz.id) {
            // Va a la derecha
            raiz.der = insertar(raiz.der, valor);
        } else {
            // Repetitido
            raiz.frecuencia++;
        }
        return raiz;
    }
}


