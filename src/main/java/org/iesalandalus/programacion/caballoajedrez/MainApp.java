package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Caballo caballo;

	public static void main(String[] args) {
		int opcion;
		do {
			mostrarMenu();
			opcion = elegirOpcion();
			ejecutarOpcion(opcion);
		} while (opcion!=5);
	}

	private static void mostrarMenu() {
		System.out.println("*************************************************************");
		System.out.println("*      PROGRAMA QUE CONTROLA EL MOVIMIENTO DEL CABALLO      *");
		System.out.println("*************************************************************");
		System.out.println("* 1 - Crear caballo por defecto.                            *");
		System.out.println("* 2 - Crear caballo de un color.                            *");
		System.out.println("* 3 - Crear caballo de un color en la columna seleccionada. *");
		System.out.println("* 4 - Mover el caballo.                                     *");
		System.out.println("* 5 - Salir.                                                *");
		System.out.println("*************************************************************");

	}

	private static int elegirOpcion() {
		//Hay que comprobar que está dentro del rango de opciones.
		int lectura;
		do {
			System.out.println("¿Cuál de las opciones desea ejecutar? (1-5)");
			lectura = Entrada.entero();
		}while(lectura<1 || lectura>5);
		return lectura;
	}

	private static void ejecutarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			crearCaballoDefecto();
			break;
		case 2:
			crearCaballoDefectoColor();
			break;
		case 3:
			crearCaballoColorPosicion();
			break;
		case 4:
			mover();
		}

	}

	private static void crearCaballoDefecto() {
		caballo = new Caballo();
	}

	private static void crearCaballoDefectoColor() {
		caballo = new Caballo(elegirColor());
	}

	private static Color elegirColor() {
		char color;
		do {
			System.out.println("¿De qué color desea que sea el caballo? (B/N)");
			color = Entrada.caracter();
		}while(color!='B' && color!='N');
		if(color=='B')
			return Color.BLANCO;
		return Color.NEGRO;

	}

	private static void crearCaballoColorPosicion() {
		caballo = new Caballo(elegirColor(), elegirColumnaInicial());
	}

	private static char elegirColumnaInicial() {
		char columna;
		do {
			System.out.println("¿Cuál desea que sea la columna inicial del caballo? (b/g)");
			columna = Entrada.caracter();
		}while(columna!='b' && columna!='g');
		return columna;
	}

	private static void mover() {
		try {
			caballo.mover(elegirDireccion());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("La posición actual del caballo es: " + caballo.getPosicion());
	}

	private static Direccion elegirDireccion() {
		int lectura;
		do {
			System.out.println("Los movimientos que puede realizar un caballo son:");
			System.out.println("1 - Arriba izquierda.");
			System.out.println("2 - Arriba derecha.");
			System.out.println("3 - Derecha arriba.");
			System.out.println("4 - Derecha abajo.");
			System.out.println("5 - Abajo derecha.");
			System.out.println("6 - Abajo izquierda.");
			System.out.println("7 - Izquierda arriba.");
			System.out.println("8 - Izquierda abajo.");
			System.out.println("¿Cuál de estos movimientos le gustaría que intentase realizar el caballo? (1-8)");
			lectura = Entrada.entero();
		} while (lectura<1 || lectura>8);
		switch(lectura) {
		case 1:
			return Direccion.ARRIBA_IZQUIERDA;
		case 2:
			return Direccion.ARRIBA_DERECHA;
		case 3:
			return Direccion.DERECHA_ARRIBA;
		case 4:
			return Direccion.DERECHA_ABAJO;
		case 5:
			return Direccion.ABAJO_DERECHA;
		case 6:
			return Direccion.ABAJO_IZQUIERDA;
		case 7:
			return Direccion.IZQUIERDA_ARRIBA;
		case 8:
			return Direccion.IZQUIERDA_ABAJO;
		default:
			return null;
		}
	}
}