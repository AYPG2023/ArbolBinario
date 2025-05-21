package com.ap.binario.service;

import com.ap.binario.service.eddLineales.NodoAB;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArbolBinarioTest {

    private ArbolBinario arbol;
    private NodoAB raiz;

    @Before
    public void setUp() {
        arbol = new ArbolBinario();
        raiz = null;
    }

    @Test
    public void testInsertarEnRaiz() {
        raiz = arbol.insertar(raiz, 10);
        assertNotNull(raiz);
        assertEquals(10, raiz.id);
        assertEquals(1, raiz.frecuencia);
        assertNull(raiz.izq);
        assertNull(raiz.der);
    }

    @Test
    public void testInsertarIzquierdaYDerecha() {
        raiz = arbol.insertar(raiz, 20);
        raiz = arbol.insertar(raiz, 10);
        raiz = arbol.insertar(raiz, 30);

        assertEquals(20, raiz.id);

        assertNotNull(raiz.izq);
        assertEquals(10, raiz.izq.id);
        assertNull(raiz.izq.izq);
        assertNull(raiz.izq.der);

        assertNotNull(raiz.der);
        assertEquals(30, raiz.der.id);
        assertNull(raiz.der.izq);
        assertNull(raiz.der.der);
    }

    @Test
    public void testInsertarDuplicado() {
        raiz = arbol.insertar(raiz, 5);
        raiz = arbol.insertar(raiz, 5);
        raiz = arbol.insertar(raiz, 5);

        assertEquals(5, raiz.id);
        assertEquals(3, raiz.frecuencia);
        assertNull(raiz.izq);
        assertNull(raiz.der);
    }

    @Test
    public void testInsertarVariasVecesConstruyeBST() {
        int[] valores = {15, 10, 20, 8, 12, 17, 25, 20};
        for (int v : valores) {
            raiz = arbol.insertar(raiz, v);
        }

        // Raíz
        assertEquals(15, raiz.id);
        // Rama izquierda
        assertEquals(10, raiz.izq.id);
        assertEquals(8,  raiz.izq.izq.id);
        assertEquals(12, raiz.izq.der.id);
        // Rama derecha
        assertEquals(20, raiz.der.id);
        assertEquals(1,  raiz.der.izq.id);
        assertEquals(25, raiz.der.der.id);
        assertEquals(2, raiz.der.frecuencia);
    }
}
