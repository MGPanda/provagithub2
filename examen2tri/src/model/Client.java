package model;

import utils.Entrada;

public class Client {

	private String nom = "";
	private String dni = "";
	private String direccio = "";
	
	//Constructors
	public Client() {
	}
	
	public Client(String nom, String dni,String direccio) {
		this.nom = nom;
		this.dni = dni;
		this.direccio = direccio;
	}

	public Client(Client c) {
		this.nom = c.getNom();
		this.dni = c.getDni();
		this.direccio = c.getDireccio();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccio() {
		return direccio;
	}

	public void setDireccio(String direccio) {
		this.direccio = direccio;
	}
	
	/*Mètodes crear biblioteca */
    public static Client crearClient() {
    	System.out.println("Nom del Client:");
    	String name = Entrada.cadena();
    	System.out.println("Dni del Client:");
    	String dni = Entrada.cadena();
    	System.out.println("Adreça del client:");
    	String adress = Entrada.cadena();
    	Client c = new Client(name,dni,adress);
    	return c;
    }
	
    @Override
    public String toString() {
    	return "Nom: "+this.getNom()+" DNI: "+this.getDni()+" Direccio "+this.getDireccio();
    }
	
}
