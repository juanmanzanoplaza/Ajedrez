package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

public class Caballo {
	private Color color;
	private Posicion posicion;

	//Constructor por defecto
	public Caballo() {
		setColor(Color.NEGRO);
		setPosicion(new Posicion(8,'b'));
	}

	//Constructor con color
	public Caballo(Color color) {
		setColor(color);
		if(color.name().equals("BLANCO"))
			setPosicion(new Posicion(1, 'b'));
		else
			setPosicion(new Posicion(8, 'b'));
	}

	//Constructor con color y columna
	public Caballo(Color color, char columna) {
		setColor(color);
		if(columna!='b' && columna!='g')
			throw new IllegalArgumentException("ERROR: Columna inicial no válida.");
		if(color.name().equals("BLANCO"))
			setPosicion(new Posicion(1, columna));
		else
			setPosicion(new Posicion(8, columna));
	}

	/*
	//Constructor copia
	public Caballo(Caballo caballo) {
		if(caballo == null)
			throw new IllegalArgumentException("ERROR: El caballo a copiar no puede ser nulo.");
		setColor(caballo.getColor());
		setPosicion(new Posicion(caballo.getPosicion().getFila(), caballo.getPosicion().getColumna()));
	}
	*/

	public Color getColor() {
		return color;
	}

	private void setColor(Color color) {
		if(color == null)
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		this.color = color;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	private void setPosicion(Posicion posicion) {
		if(posicion == null)
			throw new IllegalArgumentException("ERROR: La posición del caballo no puede ser nula.");
		this.posicion = posicion;
	}

	public void mover(Direccion direccion) throws OperationNotSupportedException {
		if(direccion.equals(null))
			throw new IllegalArgumentException("");
		char aux;
		try {
			switch(direccion) {
			case ABAJO_DERECHA:
				aux = this.getPosicion().getColumna();
				aux++;
				setPosicion(new Posicion(this.getPosicion().getFila()-2, aux));
				break;
			case ABAJO_IZQUIERDA:
				aux = this.getPosicion().getColumna();
				aux--;
				setPosicion(new Posicion(this.getPosicion().getFila()-2, aux));
				break;
			case ARRIBA_DERECHA:
				aux = this.getPosicion().getColumna();
				aux++;
				setPosicion(new Posicion(this.getPosicion().getFila()+2, aux));
				break;
			case ARRIBA_IZQUIERDA:
				aux = this.getPosicion().getColumna();
				aux--;
				setPosicion(new Posicion(this.getPosicion().getFila()+2, aux));
				break;
			case DERECHA_ABAJO:
				aux = this.getPosicion().getColumna();
				aux++;
				aux++;
				setPosicion(new Posicion(this.getPosicion().getFila()-1, aux));
				break;
			case DERECHA_ARRIBA:
				aux = this.getPosicion().getColumna();
				aux++;
				aux++;
				setPosicion(new Posicion(this.getPosicion().getFila()+1, aux));
				break;
			case IZQUIERDA_ABAJO:
				aux = this.getPosicion().getColumna();
				aux--;
				aux--;
				setPosicion(new Posicion(this.getPosicion().getFila()-1, aux));
				break;
			case IZQUIERDA_ARRIBA:
				aux = this.getPosicion().getColumna();
				aux--;
				aux--;
				setPosicion(new Posicion(this.getPosicion().getFila()+1, aux));
			}
		} catch (IllegalArgumentException e) {
			throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
		}
	}

	public boolean equals(Object o) {
		if(!(o instanceof Caballo))
			return false;
		Caballo caballo = (Caballo) o;
		if(this.color.equals(caballo.getColor()) && this.posicion.equals(caballo.getPosicion()))
			return true;
		return false;
	}

	public String toString() {
		String cadena = "Caballo [posición=" + this.getPosicion();
		cadena += ", color=" + this.getColor().name() + "]";
		return cadena;
	}

}
