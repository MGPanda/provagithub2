package model;

import java.util.*;

public class AgenciaViatges {

	HashMap<String ,Client> llistaClients = new HashMap<String ,Client>();
	ArrayList<Producte> llistaProductes = new ArrayList<Producte>();
	HashMap<String,Reserva> llistaReserves = new HashMap<String,Reserva>();
	//TODO: introduir els llistats que falten.
	
	public HashMap<String, Reserva> getLlistaReserves() {
		return llistaReserves;
	}

	public void setLlistaReserves(HashMap<String, Reserva> llistaReserves) {
		this.llistaReserves = llistaReserves;
	}

	// CONSTRUCTORS
	public AgenciaViatges() {
	}

	public HashMap<String, Client> getLlistaClients() {
		return llistaClients;
	}

	public void setLlistaClients(HashMap<String, Client> llistaClients) {
		this.llistaClients = llistaClients;
	}

	public ArrayList<Producte> getLlistaProductes() {
		return llistaProductes;
	}

	public void setLlistaProductes(ArrayList<Producte> llistaProductes) {
		this.llistaProductes = llistaProductes;
	}
	
	
	
		
}
