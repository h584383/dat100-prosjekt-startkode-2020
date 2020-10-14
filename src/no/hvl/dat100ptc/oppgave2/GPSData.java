package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {

		// TODO - START
		gpspoints = new GPSPoint[n];
		antall = 0;
		

		// TODO - SLUTT
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {
		
		boolean inserted = false;

		if (antall < gpspoints.length) {
			
			gpspoints[antall] = gpspoint;
			
			antall++;
			
			inserted = true;
			
		}
	
		return inserted;
		
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		//Oppretter tom GPSPoint variabel (den tar int, double, double, double)
		GPSPoint gpspoint;
		
		//Bruker convert metode fra GPSDataConverter og tar inn parametrene fra insert-metoden
		gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
		
		//bruker insertGPS-metoden på gpspoint-variabelen og returnerer den (true eller false)
		return insertGPS(gpspoint);
		

		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");
		
		for (GPSPoint element : gpspoints) {
			
			//bruker toString fra GPSPoint.java
			element.toString();
		}

		
		
		
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");
	}
}
