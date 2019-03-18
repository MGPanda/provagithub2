package model;

import java.util.ArrayList;

public class Reserva {
	private String localitzador = "";
	private Boolean estat;
	private Client c = new Client();
	private ArrayList<Producte> prod = new ArrayList<Producte>();
	public Reserva() {
	}
	public Reserva(String localitzador, Boolean estat, Client c, ArrayList<Producte> prod) {
		this.localitzador = localitzador;
		this.estat = estat;
		this.c = c;
		this.prod = prod;
	}
	public ArrayList<Producte> getProd() {
		return prod;
	}
	public void setProd(ArrayList<Producte> prod) {
		this.prod = prod;
	}
	public Reserva(Reserva r) {
		localitzador = getLocalitzador();
		estat = getEstat();
		c = getC();
		prod = getProd();
	}
	public String getLocalitzador() {
		return localitzador;
	}
	public void setLocalitzador(String localitzador) {
		this.localitzador = localitzador;
	}
	public Boolean getEstat() {
		return estat;
	}
	public void setEstat(Boolean estat) {
		this.estat = estat;
	}
	public Client getC() {
		return c;
	}
	public void setC(Client c) {
		this.c = c;
	}
	public void pintarReserva() {
		System.out.println("Localitzador: "+this.localitzador);
		if (estat) {
			System.out.println("Estat: confirmada");
		}
		else {
			System.out.println("Estat: sense confirmar");
		}
		System.out.println("Productes: ");
		for (int i = 0; i < prod.size(); i++) {
			prod.get(i).pintarProducte();
			System.out.println("");
		}
	}
}
