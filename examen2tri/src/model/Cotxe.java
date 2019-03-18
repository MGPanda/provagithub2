package model;

import java.util.Date;

public class Cotxe extends Producte {
	public Date getDataInici() {
		return dataInici;
	}
	public void setDataInici(Date dataInici) {
		this.dataInici = dataInici;
	}
	public Date getDataFi() {
		return dataFi;
	}
	public void setDataFi(Date dataFi) {
		this.dataFi = dataFi;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getLocalitzacioInicia() {
		return localitzacioInicia;
	}
	public void setLocalitzacioInicia(String localitzacioInicia) {
		this.localitzacioInicia = localitzacioInicia;
	}
	public String getLocalitzacioFinal() {
		return localitzacioFinal;
	}
	public void setLocalitzacioFinal(String localitzacioFinal) {
		this.localitzacioFinal = localitzacioFinal;
	}
	private Date dataInici;
	private Date dataFi;
	private String categoria = "";
	private String localitzacioInicia = "";
	private String localitzacioFinal = "";
	public Cotxe() {
	}
	public Cotxe(String nom, int numeroPlaces, double preu, Date dataInici, Date dataFi, String categoria, String localitzacioInicia, String localitzacioFinal) {
		super(numeroPlaces, preu, nom);
		this.dataInici = dataInici;
		this.dataFi = dataFi;
		this.categoria = categoria;
		this.localitzacioInicia = localitzacioInicia;
		this.localitzacioFinal = localitzacioFinal;
	}
	public Cotxe(Cotxe c) {
		dataInici = getDataInici();
		dataFi = getDataFi();
		categoria = getCategoria();
		localitzacioInicia = getLocalitzacioInicia();
		localitzacioFinal = getLocalitzacioFinal();
	}
	public void pintarProducte() {
		super.pintarProducte();
		System.out.println(this.dataInici+" - "+this.dataFi+"\nCategoria: "+this.categoria+"\nLocalització inicial: "+this.localitzacioInicia+"\nLocalització final: "+this.localitzacioFinal);
	}
}
