package org.iesalandalus.programacion.caballoajedrez;

public class Caballo {
	private Color color;
	private Posicion posicion;

	//Constructor por defecto
	public Caballo() {
		setColor(Color.NEGRO);
		setPosicion(new Posicion(8,'b'));
	}

	public Color getColor() {
		return color;
	}

	private void setColor(Color color) {
		if(color == null)
			throw new IllegalArgumentException("");
		this.color = color;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	private void setPosicion(Posicion posicion) {
		if(posicion == null)
			throw new IllegalArgumentException("");
		this.posicion = posicion;
	}

}
