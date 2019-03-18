package model;

//TODO: revisar si falta alguna cosa segons l'enunciat.
public abstract class Producte {

	protected static int maxId = 0;
	protected int idViatge = 0;
	protected int numeroPlaces = 30;
	protected double preu = 100;
	protected String nom;
	
	//Constructors
	public Producte() {
	}
	
	public Producte(int numeroPlaces, double preu, String nom) {
		//TODO controlar que l'identificador sigui autoincremental.
		maxId += 1;
		this.idViatge += maxId;
		this.numeroPlaces = numeroPlaces;
		this.preu = preu;
		this.nom = nom;
	}
	public void restarPlace() {
		this.numeroPlaces -= 1;
	}
	public void pintarProducte() {
		System.out.println(this.idViatge+", "+this.nom+"\nPlaces: "+this.numeroPlaces+"\nPreu: "+this.preu);
	}

	public int getIdViatge() {
		return idViatge;
	}

	public void setIdViatge(int idViatge) {
		this.idViatge = idViatge;
	}

	public int getNumeroPlaces() {
		return numeroPlaces;
	}

	public void setNumeroPlaces(int numeroPlaces) {
		this.numeroPlaces = numeroPlaces;
	}

	public double getPreu() {
		return preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	
	
}
