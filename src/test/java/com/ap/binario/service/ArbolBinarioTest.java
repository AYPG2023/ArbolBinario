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
        assertNull(raiz.izq);
        assertNull(raiz.der);
    }

    @Test
    public void testInsertarIzquierdaYDerecha() {
        raiz = arbol.insertar(raiz, 20);
        raiz = arbol.insertar(raiz, 10);
        raiz = arbol.insertar(raiz, 30);

        // Raíz
        assertEquals(20, raiz.id);

        // Hijo izquierdo
        assertNotNull(raiz.izq);
        assertEquals(10, raiz.izq.id);
        assertNull(raiz.izq.izq);
        assertNull(raiz.izq.der);

        // Hijo derecho
        assertNotNull(raiz.der);
        assertEquals(30, raiz.der.id);
        assertNull(raiz.der.izq);
        assertNull(raiz.der.der);
    }

    @Test
    public void testInsertarDuplicadoNoCreaNodo() {
        // La segunda inserción de 5 no crea un nuevo nodo
        raiz = arbol.insertar(raiz, 5);
        raiz = arbol.insertar(raiz, 5);
        assertEquals(5, raiz.id);
        assertNull(raiz.izq);
        assertNull(raiz.der);
    }

    @Test
    public void testInsertarVariasVecesConstruyeBST() {
        // Inserto: 15,10,20,8,12,17,25,20(duplicado)
        int[] valores = {15, 10, 20, 8, 12, 17, 25, 20};
        for (int v : valores) {
            raiz = arbol.insertar(raiz, v);
        }

        // Raíz
        assertEquals(15, raiz.id);

        // Subárbol izquierdo: 10 con hijos 8 y 12
        assertEquals(10, raiz.izq.id);
        assertEquals(8,  raiz.izq.izq.id);
        assertEquals(12, raiz.izq.der.id);

        // Subárbol derecho: 20 con hijos 17 y 25
        assertEquals(20, raiz.der.id);
        assertEquals(17, raiz.der.izq.id);
        assertEquals(25, raiz.der.der.id);
    }
}
