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
		if(color == null)
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		setColor(color);
		if(color.name().equals("BLANCO"))
			setPosicion(new Posicion(1, 'b'));
		else
			setPosicion(new Posicion(8, 'b'));
	}

	//Constructor con color y columna
	public Caballo(Color color, char columna) {
		if(color==null)
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		if(columna!='b' && columna!='g')
			throw new IllegalArgumentException("ERROR: Columna inicial no válida.");
		setColor(color);
		if(color.name().equals("BLANCO"))
			setPosicion(new Posicion(1, columna));
		else
			setPosicion(new Posicion(8, columna));
	}

	//Constructor copia
	/*
	public Caballo(Caballo caballo) {
		if(caballo == null)
			throw new IllegalArgumentException("");
		setColor(caballo.getColor());
		setPosicion(new Posicion(caballo.getPosicion().getFila(), caballo.getPosicion().getColumna()));
	}
	*/

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
				break;
			}
		} catch (IllegalArgumentException e) {
			throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
		}
	}

}
