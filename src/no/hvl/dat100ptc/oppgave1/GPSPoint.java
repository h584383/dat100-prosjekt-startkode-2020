package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {

	// TODO - objektvariable
	
	int time; //angir tiden i SEKUNDER
	
	double latitude;
	
	double longitude;
	
	double elevation; //høyde i meter
	
		
	public GPSPoint(int time, double latitude, double longitude, double elevation) {

		//Gir verdi til alle objektvariablene.
		
		this.time = time;
		
		this.latitude = latitude;
		
		this.longitude = longitude;
		
		this.elevation = elevation;
		
	}

	// TODO - get/set metoder
	public int getTime() {
		
		return time;
		
	}

	public void setTime(int time) {
				
		this.time = time;
	}

	public double getLatitude() {
		
		return latitude;
	}

	public void setLatitude(double latitude) {
		
		this.latitude = latitude;
	}

	public double getLongitude() {
		
		return longitude;
	}

	public void setLongitude(double longitude) {
		
		this.longitude = longitude;
	}

	public double getElevation() {
		
		return elevation;
	}

	public void setElevation(double elevation) {
		
		this.elevation = elevation;
	}
	
	public String toString() {
		
		String str = time + " " + "(" + latitude + "," + longitude +") " + elevation + "\n";
		
		return str;
		
	}
}
