package model;

import java.util.Date;

public class Hotel extends Producte{
	public Date getDataInici() {
		return dataInici;
	}
	public void setDataInici(Date dataInici) {
		this.dataInici = dataInici;
	}
	public Date getDataFin() {
		return dataFin;
	}
	public void setDataFin(Date dataFin) {
		this.dataFin = dataFin;
	}
	public String getLocalitzacio() {
		return localitzacio;
	}
	public void setLocalitzacio(String localitzacio) {
		this.localitzacio = localitzacio;
	}
	public Boolean getCamaDoble() {
		return camaDoble;
	}
	public void setCamaDoble(Boolean camaDoble) {
		this.camaDoble = camaDoble;
	}
	private Date dataInici;
	private Date dataFin;
	private String localitzacio = "";
	private Boolean camaDoble;
	public Hotel() {
	}
	public Hotel(String nom, int numeroPlaces, double preu, Date dataInici, Date dataFin, String localitzacio, Boolean camaDoble) {
		super(numeroPlaces,preu,nom);
		this.dataInici = dataInici;
		this.dataFin = dataFin;
		this.localitzacio = localitzacio;
		this.camaDoble = camaDoble;
	}
	public Hotel(Hotel h) {
		dataInici = getDataInici();
		dataFin = getDataFin();
		localitzacio = getLocalitzacio();
		camaDoble = getCamaDoble();
	}
	public void pintarProducte() {
		super.pintarProducte();
		System.out.println(this.dataInici+" - "+this.dataFin+"\nLocalització: "+this.localitzacio);
		if(camaDoble) {
			System.out.println("Cama doble: Sí");
		}
		else {
			System.out.println("Cama doble: No");
		}
	}
}
