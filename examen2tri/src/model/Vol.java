package model;

import java.util.Date;

public class Vol extends Producte {
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDesde() {
		return desde;
	}
	public void setDesde(String desde) {
		this.desde = desde;
	}
	public String getFins() {
		return fins;
	}
	public void setFins(String fins) {
		this.fins = fins;
	}
	public String getCompanyia() {
		return companyia;
	}
	public void setCompanyia(String companyia) {
		this.companyia = companyia;
	}
	public String getDistancia() {
		return distancia;
	}
	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}
	private Date data;
	private String desde = "";
	private String fins = "";
	private String companyia = "";
	private String distancia = "";
	public Vol() {
	}
	public Vol(String nom, int numeroPlaces, double preu, Date data, String desde, String fins, String companyia, String distancia) {
		super(numeroPlaces,preu,nom);
		this.data = data;
		this.desde = desde;
		this.fins = fins;
		this.companyia = companyia;
		this.distancia = distancia;
	}
	public Vol(Vol v) {
		data = getData();
		desde = getDesde();
		fins = getFins();
		companyia = getCompanyia();
		distancia = getDistancia();
	}
	public void pintarProducte() {
		super.pintarProducte();
		System.out.println("Data: "+this.data+"\nDesde "+this.desde+" fins "+this.fins+"\nCompanyia: "+this.companyia+"\nDistància: "+this.distancia);
	}
}
