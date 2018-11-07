/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.ob201802.Grafo;

import uy.ort.ob201802.Grafo.NodoCola;

public class Cola<T> {
	private NodoCola<T> inicio;
	private NodoCola<T> fin;
	private int cont;
	
	public void encolar(T dato)
	{
		if(cont == 0)
		{
			inicio = fin = new NodoCola<T>(dato);
		}
		else
		{
			fin.setSig(new NodoCola<T>(dato));
			fin = fin.getSig();
		}
		cont++;
	}
	
	public T desencolar(){
		T ret = inicio.getDato();
		inicio = inicio.getSig();
		cont--;
		if(cont==0)
		{
			fin = null;
		}
		return ret;
	}
	
	public boolean esVacia(){
		return cont == 0;
	}
}

