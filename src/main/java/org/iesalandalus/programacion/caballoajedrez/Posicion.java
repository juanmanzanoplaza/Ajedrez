package org.iesalandalus.programacion.caballoajedrez;

public class Posicion {
	private int fila;
	private char columna;

	public Posicion(int fila, char columna) throws IllegalArgumentException{
		setFila(fila);
		setColumna(columna);
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) throws IllegalArgumentException{
		if(fila<1 || fila>8)
			throw new IllegalArgumentException("ERROR: El número de fila debe estar entre 1 y 8.");
		this.fila = fila;
	}

	public char getColumna() {
		return columna;
	}

	public void setColumna(char columna) throws IllegalArgumentException{
		if(columna!='a' && columna!='b' && columna!='c' && columna!='d'
				&& columna!='e' && columna!='f' && columna!='g' && columna!='h')
			throw new IllegalArgumentException("ERROR: El carácter de columna debe estar entre a y h.");
		this.columna = columna;
	}

}
