package control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.*;
import utils.Entrada;

public class Menu {

	private AgenciaViatges av = new AgenciaViatges();
	
	public void start() {
		System.out.println("Programa per Tòfol Martínez Lorenzo.");
		creacioDades();
		int opt=1;
		while(opt!=4) {
			pintarMenu();
			System.out.println("Selecciona una opció:");
			opt=Entrada.entero();
			control(opt);
		}
	}
	
	private void pintarMenu() {
		System.out.println("---------------------------");
		System.out.println("(1) Crear un Paquet.");
		System.out.println("(2) Crear una reserva.");
		System.out.println("(3) Pintar una reserva.");
		System.out.println("(4) Sortir.");
		System.out.println("---------------------------");
	}
	private void crearPaquet() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Producte> prod = new ArrayList<Producte>();
		String ch = "";
		float chi = 0;
		prod.add(seleccioProducte(false));
		do {
			System.out.println("Vols afegir un altre? (s/n)");
			ch = sc.nextLine();
			switch (ch) {
			case "s":
				prod.add(seleccioProducte(false));
				break;
			case "n":
				int vols = 0;
				int hotels = 0;
				for (int i = 0; i < prod.size(); i++) {
					if (prod.get(i) instanceof Vol) {
						vols++;
					}
					else if (prod.get(i) instanceof Hotel) {
						hotels++;
					}
				}
				if (vols >= 2 && hotels >= 1) {
					break;
				}
				else {
					System.out.println("Es necessiten com a mínim dos vols i un hotel.");
					ch = "";
				}
				break;
			default:
				System.out.println("Has de introduir una opció vàlida.");
				break;
			}
		} while (!ch.equals("n"));
		float preu = 0;
		for (int i = 0; i < prod.size(); i++) {
			preu += prod.get(i).getPreu();
		}
		System.out.println("Introdueix el descompte.");
		chi = sc.nextFloat();
		sc = new Scanner(System.in);
		preu *= chi;
		System.out.println("Quin nom li vols donar?");
		String nom = sc.nextLine();
		System.out.println("Quantes places te?");
		int numeroPlaces = sc.nextInt();
		sc = new Scanner(System.in);
		if (numeroPlaces <= 0) {
			numeroPlaces = 30;
		}
		
		Paquet p = new Paquet(nom,numeroPlaces,preu,prod,chi);
		av.getLlistaProductes().add(p);
	}
	private Producte seleccioProducte(Boolean restarPlace) {
		Scanner sc = new Scanner(System.in);
		if (restarPlace) {
			System.out.println("Vols reservar un paquet (p), un cotxe (c), un vol (v), o un hotel (h)?: ");
		}
		else {
			System.out.println("Vols reservar un cotxe (c), un vol (v), o un hotel (h)?: ");
		}
		String ch = sc.nextLine();
		int chi = 0;
		int index = 0;
		switch (ch) {
		case "p":
			if (restarPlace) {
				for (int i = 0; i < this.av.getLlistaProductes().size(); i++) {
					if (this.av.getLlistaProductes().get(i) instanceof Paquet) {
						this.av.getLlistaProductes().get(i).pintarProducte();
						System.out.println("");
					}
				}
			}
			else {
				System.out.println("Has de introduir una opció vàlida.");
			}
			break;
		case "c":
			for (int i = 0; i < this.av.getLlistaProductes().size(); i++) {
				if (this.av.getLlistaProductes().get(i) instanceof Cotxe) {
					this.av.getLlistaProductes().get(i).pintarProducte();
					System.out.println("");
				}
			}
			break;
		case "v":
			for (int i = 0; i < this.av.getLlistaProductes().size(); i++) {
				if (this.av.getLlistaProductes().get(i) instanceof Vol) {
					this.av.getLlistaProductes().get(i).pintarProducte();
					System.out.println("");
				}
			}
			break;
		case "h":
			for (int i = 0; i < this.av.getLlistaProductes().size(); i++) {
				if (this.av.getLlistaProductes().get(i) instanceof Hotel) {
					this.av.getLlistaProductes().get(i).pintarProducte();
					System.out.println("");
				}
			}
			break;
		default:
			System.out.println("Has de seleccionar una opció vàlida.");
			break;
		}
		System.out.println("Introdueix la ID del producte de interés: ");
		chi = sc.nextInt();
		sc = new Scanner(System.in);
		for (int i = 0; i < this.av.getLlistaProductes().size(); i++) {
			if (this.av.getLlistaProductes().get(i).getIdViatge() == chi) {
				index = i;
			}
		}
		if (this.av.getLlistaProductes().get(index) == null) {
			System.out.println("No s'ha trobat el producte.");
		}
		else {
			if (restarPlace) {
				this.av.getLlistaProductes().get(index).restarPlace();
			}
			return this.av.getLlistaProductes().get(index);
		}
		return null;
	}
	private void ferReserva() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Producte> prod = new ArrayList<Producte>();
		String ch = "";
		float chi = 0;
		prod.add(seleccioProducte(true));
		do {
			System.out.println("Vols afegir un altre? (s/n)");
			ch = sc.nextLine();
			switch (ch) {
			case "s":
				prod.add(seleccioProducte(true));
				break;
			case "n":
				break;
			default:
				System.out.println("Has de introduir una opció vàlida.");
				break;
			}
		} while (!ch.equals("n"));
		float preu = 0;
		for (int i = 0; i < prod.size(); i++) {
			preu += prod.get(i).getPreu();
		}
		System.out.println("El preu es: "+preu);
		System.out.println("Introdueix el DNI: ");
		String dni = sc.nextLine();
		Client c = av.getLlistaClients().get(dni);
		
	}
	private void pintarReserva() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introdueix el nom de la reserva: ");
		int chi = sc.nextInt();
		sc = new Scanner(System.in);
		av.getLlistaReserves().get(chi).pintarReserva();
	}
	
	private void control(int option) {
		switch(option) {
		case 1:
			crearPaquet();
			break;
		case 2:
			ferReserva();
			System.out.println("Crear una Reserva.");
			break;
		case 3:
			pintarReserva();
			break;
		case 4:
			System.out.println("Adeu.");
			break;
		default:
			System.out.println("Aquest punt de menu no existeix");
			break;
		}
	}
	
	public AgenciaViatges getAv() {
		return av;
	}
	
	public void setAv(AgenciaViatges av) {
		this.av = av;
	}
	
	
	private void creacioDades() {
		Client c1 = new Client("Jaume Pericàs","25698532p","C/ concepcio, Pina");
		Client c2 = new Client("Miquel Oliver","15687688o","C/ balmes, Palma");
		Client c3 = new Client("Maria Moreva","87654356p","C/ muntaner, Llucmajor");
		Client c4= new Client("Hans Stegen","16546546p","C/ carrer del jamon, Arenal");
		Client c5 = new Client("Joni Moll","98789798p","C/ avinguda principal, Alcudia");
		
		this.getAv().getLlistaClients().put(c1.getDni(), c1);
		this.getAv().getLlistaClients().put(c1.getDni(), c2);
		this.getAv().getLlistaClients().put(c1.getDni(), c3);
		this.getAv().getLlistaClients().put(c1.getDni(), c4);
		this.getAv().getLlistaClients().put(c1.getDni(), c5);
		
		
		Cotxe o1 = new Cotxe("Opel Astra", 30, 100,stringToDate("12/04/2019"),stringToDate("12/12/2019"),"baixa","palma","palma");
		Cotxe o2 = new Cotxe("Hyundai kona", 30, 100,stringToDate("01/04/2019"),stringToDate("01/12/2019"),"baixa","manacor","manacor");
		Cotxe o3 = new Cotxe("Seat Ateca", 30, 150,stringToDate("12/04/2019"),stringToDate("12/12/2019"),"mitja","palma","manacor");
		Cotxe o4 = new Cotxe("Toyota verso", 30, 150,stringToDate("01/05/2019"),stringToDate("25/12/2019"),"mitja","manacor","palma");
		Cotxe o5 = new Cotxe("Audi A8", 20, 200,stringToDate("12/04/2019"),stringToDate("12/12/2019"),"alta","palma","palma");
		
		Vol v1 = new Vol("PMI-MAD", 30, 80, stringToDate("12/04/2019"),"Pama","Madrid","Ryaner","800km");
		Vol v2 = new Vol("MAD-PMI", 30, 80, stringToDate("13/04/2019"),"Madrid","Palma","Ryaner","800km");
		Vol v3 = new Vol("PMI-BCN", 30, 90, stringToDate("12/05/2019"),"Pama","Barcelona","Iberia","400km");
		Vol v4 = new Vol("BCN-MAD", 30, 95, stringToDate("17/09/2019"),"Barcelona","Madrid","Iberia","400km");
		Vol v5 = new Vol("BNC-PMI", 30, 120, stringToDate("10/10/2019"),"Barcelona","Palma","Iberia","400km");
		
		Hotel h1 = new Hotel("Playa Cala millor", 50, 25, stringToDate("12/04/2019"),stringToDate("19/04/2019"),"Cala millor",false);
		Hotel h2 = new Hotel("Playa Cocobongo", 50, 30, stringToDate("20/04/2019"),stringToDate("25/04/2019"),"Palma",false);
		Hotel h3 = new Hotel("Hotel Maria Bonita", 40, 50, stringToDate("12/05/2019"),stringToDate("22/05/2019"),"Madrid",true);
		Hotel h4 = new Hotel("Hotel Camp nou", 50, 40, stringToDate("12/04/2019"),stringToDate("19/04/2019"),"Barcelona",true);
		Hotel h5 = new Hotel("Hotel Binigual", 20, 100, stringToDate("12/04/2019"),stringToDate("19/12/2019"),"Manacor",false);
		
		this.getAv().getLlistaProductes().add(o1);
		this.getAv().getLlistaProductes().add(o2);
		this.getAv().getLlistaProductes().add(o3);
		this.getAv().getLlistaProductes().add(o4);
		this.getAv().getLlistaProductes().add(o5);
		
		this.getAv().getLlistaProductes().add(v1);
		this.getAv().getLlistaProductes().add(v2);
		this.getAv().getLlistaProductes().add(v3);
		this.getAv().getLlistaProductes().add(v4);
		this.getAv().getLlistaProductes().add(v5);
		
		this.getAv().getLlistaProductes().add(h1);
		this.getAv().getLlistaProductes().add(h2);
		this.getAv().getLlistaProductes().add(h3);
		this.getAv().getLlistaProductes().add(h4);
		this.getAv().getLlistaProductes().add(h5);
	}
	
	private Date stringToDate(String date) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date d = df.parse(date);
			return d;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
