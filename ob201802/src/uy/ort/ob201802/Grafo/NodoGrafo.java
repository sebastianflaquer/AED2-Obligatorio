/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.ob201802.Grafo;

public class NodoGrafo<T> implements INodoGrafo<T>{

    T dato;
    private double coordX;
    private double coordY;

    public NodoGrafo(T dato, double coordX, double coordY) {
        this.dato = dato;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }
    
    @Override
    public T obtener() {
        return dato;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "[" + coordX + ", " + coordY + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(coordX);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(coordY);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
                return true;
        if (obj == null)
                return false;
        if (getClass() != obj.getClass())
                return false;
        NodoGrafo other = (NodoGrafo) obj;
        if (Double.doubleToLongBits(coordX) != Double.doubleToLongBits(other.coordX))
                return false;
        if (Double.doubleToLongBits(coordY) != Double.doubleToLongBits(other.coordY))
                return false;
        return true;
    }
}

