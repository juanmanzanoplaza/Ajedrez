package org.iesalandalus.programacion.caballoajedrez;

import static org.junit.Assert.*;

import org.junit.Test;

public class PosicionTest {

	@Test
	public void constructorValidoTest() {
		Posicion posicion;
		posicion = new Posicion(1, 'a');
		assertEquals(1, posicion.getFila());
		assertEquals('a', posicion.getColumna());
	}

	@Test
	public void constructorNoValidoTest() {
		Posicion posicion = null;
		try {
			posicion = new Posicion(0, 'a');
			fail("Deber�a haber saltado una excepci�n indicando que la fila es incorrecta");
		} catch (IllegalArgumentException e) {
			assertEquals("ERROR: Fila no v�lida.", e.getMessage());
			assertNull(posicion);
		}
		assertNull(posicion);
		try {
			posicion = new Posicion(1, 'i');
			fail("Deber�a haber saltado una excepci�n indicando que la columna es incorrecta");
		} catch (IllegalArgumentException e) {
			assertEquals("ERROR: Columna no v�lida.", e.getMessage());
			assertNull(posicion);
		}
	}

	@Test
	public void constructorCopiaTest() {
		Posicion posicion = new Posicion(1, 'a');
		Posicion nuevaPosicion = new Posicion(posicion);
		assertEquals(posicion, nuevaPosicion);
		try {
			nuevaPosicion = new Posicion(null);
			fail("Deber�a haber saltado una excepci�n indicando que no se puede copiar una posici�n nula.");
		} catch (Exception e) {
			assertEquals("ERROR: No es posible copiar una posici�n nula.", e.getMessage());
			assertEquals(posicion, nuevaPosicion);
		}
	}

	@Test
	public void setFilaNoValidaTest() {
		Posicion posicion = new Posicion(1, 'a');
		try {
			posicion.setFila(0);
			fail("Deber�a haber saltado una excepci�n indicando que la fila es incorrecta");
		} catch (IllegalArgumentException e) {
			assertEquals("ERROR: Fila no v�lida.", e.getMessage());
			assertEquals(1, posicion.getFila());
		}
		try {
			posicion.setFila(9);
			fail("Deber�a haber saltado una excepci�n indicando que la fila es incorrecta");
		} catch (IllegalArgumentException e) {
			assertEquals("ERROR: Fila no v�lida.", e.getMessage());
			assertEquals(1, posicion.getFila());
		}
	}

	@Test
	public void setColumnaNoValidaTest() {
		Posicion posicion = new Posicion(1, 'a');
		try {
			posicion.setColumna('`');
			fail("Deber�a haber saltado una excepci�n indicando que la columna es incorrecta");
		} catch (IllegalArgumentException e) {
			assertEquals("ERROR: Columna no v�lida.", e.getMessage());
			assertEquals('a', posicion.getColumna());
		}
		try {
			posicion.setColumna('i');
			fail("Deber�a haber saltado una excepci�n indicando que la columna es incorrecta");
		} catch (IllegalArgumentException e) {
			assertEquals("ERROR: Columna no v�lida.", e.getMessage());
			assertEquals('a', posicion.getColumna());
		}
	}

	@Test
	public void igualdadTest() {
		Posicion posicion1, posicion2, posicion3, posicion4, posicion5;
		posicion1 = new Posicion(1, 'a');
		posicion2 = new Posicion(1, 'b');
		posicion3 = new Posicion(2, 'a');
		posicion4 = new Posicion(2, 'c');
		posicion5 = new Posicion(posicion1);
		assertNotEquals(posicion1, "Prueba");
		assertNotEquals(posicion1, null);
		assertNotEquals(posicion1, posicion2);
		assertNotEquals(posicion1, posicion3);
		assertNotEquals(posicion2, posicion3);
		assertNotEquals(posicion2, posicion4);
		assertEquals(posicion1, posicion5);
		assertEquals(posicion1, posicion1);
	}

	@Test
	public void toStringTest() {
		Posicion posicion = new Posicion(1, 'a');
		assertEquals("[fila=1, columna=a]", posicion.toString());
	}

}
