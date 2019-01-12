package org.iesalandalus.programacion.caballoajedrez;

import static org.junit.Assert.*;

import javax.naming.OperationNotSupportedException;

import org.junit.Test;

public class CaballoTest {
	
	private Posicion posicionDefectoNegro = new Posicion(8, 'b');
	private Posicion posicionDefectoBlanco = new Posicion(1, 'b');
	private Posicion posicionNegroG = new Posicion(8, 'g');
	private Posicion posicionBlancoG = new Posicion(1, 'g');

	@Test
	public void constructorDefectoTest() {
		Caballo caballo = new Caballo();
		assertEquals(Color.NEGRO, caballo.getColor());
		assertEquals(posicionDefectoNegro, caballo.getPosicion());
	}
	
	@Test
	public void constructorUnParametroValidoTest() {
		Caballo caballoBlanco = new Caballo(Color.BLANCO);
		Caballo caballoNegro = new Caballo(Color.NEGRO);
		assertEquals(Color.NEGRO, caballoNegro.getColor());
		assertEquals(posicionDefectoNegro, caballoNegro.getPosicion());
		assertEquals(Color.BLANCO, caballoBlanco.getColor());
		assertEquals(posicionDefectoBlanco, caballoBlanco.getPosicion());
	}
	
	@Test
	public void constructorUnParametroNoValidoTest() {
		Caballo caballo = null;
		try {
			caballo = new Caballo(null);
			fail("Deber�a haber saltado una excepci�n indicando que no se puede crear un caballo de ning�n color.");
		} catch (Exception e) {
			assertEquals("ERROR: No se puede asignar un color nulo.", e.getMessage());
			assertNull(caballo);
		}
	}
	
	@Test
	public void constructorDosParametrosValidoTest() {
		Caballo caballoBlancoDefecto = new Caballo(Color.BLANCO, 'b');
		Caballo caballoNegroDefecto = new Caballo(Color.NEGRO, 'b');
		Caballo caballoBlancoG = new Caballo(Color.BLANCO, 'g');
		Caballo caballoNegroG = new Caballo(Color.NEGRO, 'g');
		assertEquals(posicionDefectoBlanco, caballoBlancoDefecto.getPosicion());
		assertEquals(posicionDefectoNegro, caballoNegroDefecto.getPosicion());
		assertEquals(posicionBlancoG, caballoBlancoG.getPosicion());
		assertEquals(posicionNegroG, caballoNegroG.getPosicion());
	}
	
	@Test
	public void constructorDosParametrosNoValidoTest() {
		Caballo caballoMalPosicionadoInicialmente = null;
		try {
			caballoMalPosicionadoInicialmente = new Caballo(Color.BLANCO, 'd');
			caballoMalPosicionadoInicialmente = new Caballo(Color.BLANCO, '`');
			caballoMalPosicionadoInicialmente = new Caballo(Color.BLANCO, 'i');
			caballoMalPosicionadoInicialmente = new Caballo(Color.NEGRO, 'd');
			caballoMalPosicionadoInicialmente = new Caballo(Color.NEGRO, '`');
			caballoMalPosicionadoInicialmente = new Caballo(Color.NEGRO, 'i');
			fail("Deber�a haber saltado una excepci�n indicando que la columna inicial no era v�lida");
		} catch (IllegalArgumentException e) {
			assertEquals("ERROR: Columna inicial no v�lida.", e.getMessage());
			assertNull(caballoMalPosicionadoInicialmente);
		}
		try {
			caballoMalPosicionadoInicialmente = new Caballo(null, 'g');
			fail("Deber�a haber saltado una excepci�n indicando que no se puede crear un caballo de ning�n color");
		} catch (IllegalArgumentException e) {
			assertEquals("ERROR: No se puede asignar un color nulo.", e.getMessage());
			assertNull(caballoMalPosicionadoInicialmente);
		}
	}
	
	@Test
	public void movimientoValidoTest() {
		Caballo caballoNegroDefecto = new Caballo();
		try {
			caballoNegroDefecto.mover(Direccion.ABAJO_IZQUIERDA);
			assertEquals(new Posicion(6, 'a'), caballoNegroDefecto.getPosicion());
			caballoNegroDefecto.mover(Direccion.ABAJO_DERECHA);
			assertEquals(new Posicion(4, 'b'), caballoNegroDefecto.getPosicion());
			caballoNegroDefecto.mover(Direccion.ARRIBA_IZQUIERDA);
			assertEquals(new Posicion(6, 'a'), caballoNegroDefecto.getPosicion());
			caballoNegroDefecto.mover(Direccion.ARRIBA_DERECHA);
			assertEquals(new Posicion(8, 'b'), caballoNegroDefecto.getPosicion());
			caballoNegroDefecto.mover(Direccion.DERECHA_ABAJO);
			assertEquals(new Posicion(7, 'd'), caballoNegroDefecto.getPosicion());
			caballoNegroDefecto.mover(Direccion.IZQUIERDA_ABAJO);
			assertEquals(new Posicion(6, 'b'), caballoNegroDefecto.getPosicion());
			caballoNegroDefecto.mover(Direccion.DERECHA_ARRIBA);
			assertEquals(new Posicion(7, 'd'), caballoNegroDefecto.getPosicion());
			caballoNegroDefecto.mover(Direccion.IZQUIERDA_ARRIBA);
			assertEquals(new Posicion(8, 'b'), caballoNegroDefecto.getPosicion());
		} catch (OperationNotSupportedException e) {
			// No deber�a saltar ninguna excepci�n ya que los movimientos son v�lidos
		}
	}
	
	@Test
	public void movimientoNoValidoTest() {
		Caballo caballoNegroDefecto = new Caballo();
		Caballo caballoBlancoG = new Caballo(Color.BLANCO, 'g');
		try {
			caballoNegroDefecto.mover(Direccion.IZQUIERDA_ABAJO);
			fail("Deber�a haber saltado una excepci�n indicando que el movimiento no es v�lido.");
		} catch (OperationNotSupportedException e) {
			assertEquals("ERROR: Movimiento no v�lido.", e.getMessage());
			assertEquals(posicionDefectoNegro, caballoNegroDefecto.getPosicion());
		}
		try {
			caballoNegroDefecto.mover(Direccion.IZQUIERDA_ARRIBA);
			fail("Deber�a haber saltado una excepci�n indicando que el movimiento no es v�lido.");
		} catch (OperationNotSupportedException e) {
			assertEquals("ERROR: Movimiento no v�lido.", e.getMessage());
			assertEquals(posicionDefectoNegro, caballoNegroDefecto.getPosicion());
		}
		try {
			caballoNegroDefecto.mover(Direccion.ARRIBA_DERECHA);
			fail("Deber�a haber saltado una excepci�n indicando que el movimiento no es v�lido.");
		} catch (OperationNotSupportedException e) {
			assertEquals("ERROR: Movimiento no v�lido.", e.getMessage());
			assertEquals(posicionDefectoNegro, caballoNegroDefecto.getPosicion());
		}
		try {
			caballoNegroDefecto.mover(Direccion.ARRIBA_IZQUIERDA);
			fail("Deber�a haber saltado una excepci�n indicando que el movimiento no es v�lido.");
		} catch (OperationNotSupportedException e) {
			assertEquals("ERROR: Movimiento no v�lido.", e.getMessage());
			assertEquals(posicionDefectoNegro, caballoNegroDefecto.getPosicion());
		}
		try {
			caballoNegroDefecto.mover(Direccion.DERECHA_ARRIBA);
			fail("Deber�a haber saltado una excepci�n indicando que el movimiento no es v�lido.");
		} catch (OperationNotSupportedException e) {
			assertEquals("ERROR: Movimiento no v�lido.", e.getMessage());
			assertEquals(posicionDefectoNegro, caballoNegroDefecto.getPosicion());
		}
		try {
			caballoBlancoG.mover(Direccion.IZQUIERDA_ABAJO);
			fail("Deber�a haber saltado una excepci�n indicando que el movimiento no es v�lido.");
		} catch (OperationNotSupportedException e) {
			assertEquals("ERROR: Movimiento no v�lido.", e.getMessage());
			assertEquals(posicionBlancoG, caballoBlancoG.getPosicion());
		}
		try {
			caballoBlancoG.mover(Direccion.DERECHA_ABAJO);
			fail("Deber�a haber saltado una excepci�n indicando que el movimiento no es v�lido.");
		} catch (OperationNotSupportedException e) {
			assertEquals("ERROR: Movimiento no v�lido.", e.getMessage());
			assertEquals(posicionBlancoG, caballoBlancoG.getPosicion());
		}
		try {
			caballoBlancoG.mover(Direccion.DERECHA_ARRIBA);
			fail("Deber�a haber saltado una excepci�n indicando que el movimiento no es v�lido.");
		} catch (OperationNotSupportedException e) {
			assertEquals("ERROR: Movimiento no v�lido.", e.getMessage());
			assertEquals(posicionBlancoG, caballoBlancoG.getPosicion());
		}
		try {
			caballoBlancoG.mover(Direccion.ABAJO_DERECHA);
			fail("Deber�a haber saltado una excepci�n indicando que el movimiento no es v�lido.");
		} catch (OperationNotSupportedException e) {
			assertEquals("ERROR: Movimiento no v�lido.", e.getMessage());
			assertEquals(posicionBlancoG, caballoBlancoG.getPosicion());
		}
		try {
			caballoBlancoG.mover(Direccion.ABAJO_IZQUIERDA);
			fail("Deber�a haber saltado una excepci�n indicando que el movimiento no es v�lido.");
		} catch (OperationNotSupportedException e) {
			assertEquals("ERROR: Movimiento no v�lido.", e.getMessage());
			assertEquals(posicionBlancoG, caballoBlancoG.getPosicion());
		}
	}
	
	@Test
	public void toStringTest() {
		Caballo caballo = new Caballo();
		assertEquals("Caballo [posici�n=[fila=8, columna=b], color=NEGRO]", caballo.toString());
	}

}
