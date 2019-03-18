package model;

import java.util.ArrayList;

public final class Paquet extends Producte {
	public ArrayList<Producte> getProd() {
		return prod;
	}
	public void setProd(ArrayList<Producte> prod) {
		this.prod = prod;
	}
	public float getDescompte() {
		return descompte;
	}
	public void setDescompte(float descompte) {
		this.descompte = descompte;
	}
	private ArrayList<Producte> prod = new ArrayList<Producte>();
	private float descompte = 0;
	public Paquet() {
	}
	public Paquet(String nom, int numeroPlaces, double preu, ArrayList<Producte> prod, float descompte) {
		super(numeroPlaces,preu,nom);
		this.prod = prod;
		this.descompte = descompte;
	}
	public Paquet(Paquet p) {
		prod = getProd();
		descompte = getDescompte();
	}
	public void pintarProducte() {
		super.pintarProducte();
		System.out.println("Paquets inclosos: ");
		for (int i = 0; i < prod.size(); i++) {
			this.prod.get(i).pintarProducte();
			System.out.println();
		}
	}
}
