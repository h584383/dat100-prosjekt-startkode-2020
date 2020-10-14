package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		
		return xstep;
		
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		
		double ystep = MAPYSIZE / (Math.abs(maxlat - minlat));
		
		
		return ystep;
		
	}

	public void showRouteMap(int ybase) {
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		
		for (int i = 0; i < gpspoints.length; i++) {
			
			double a = gpspoints[i].getLongitude();
			double b = gpspoints[i].getLatitude();
			
			fillCircle((int)((a-minlon)*xstep()), ybase-(int)((b-minlat)*ystep()), 2);
			
			
			
		}
		
		for (int i = 0; i < gpspoints.length-1; i++) {
			
			double a = gpspoints[i].getLongitude();
			double b = gpspoints[i].getLatitude();
			double c = gpspoints[i+1].getLongitude();
			double d = gpspoints[i+1].getLatitude();
			
			
			drawLine((int)((a-minlon)*xstep()), ybase-(int)((b-minlat)*ystep()), (int)((c-minlon)*xstep()), ybase-(int)((d-minlat)*ystep()));
			
		}
		
		
		
		
		
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		String str1 = ("Total Time     : "+GPSUtils.formatTime(gpscomputer.totalTime()));
		String str2 = ("Total distance : " + GPSUtils.formatDouble(gpscomputer.totalDistance()/1000) + " km");
		String str3 = ("Total elevation: " + GPSUtils.formatDouble(gpscomputer.totalElevation()) + " m");
		String str4 = ("Max speed      : " + GPSUtils.formatDouble(gpscomputer.maxSpeed()) + " km/t");
		String str5 = ("Average speed  : " + GPSUtils.formatDouble(gpscomputer.averageSpeed()) + " km/t");
		String str6 = ("Energy         : " + GPSUtils.formatDouble(gpscomputer.totalKcal(80)));
		
		drawString(str1, 100, 100);
		drawString(str2, 100, 120);
		drawString(str3, 100, 140);
		drawString(str4, 100, 160);
		drawString(str5, 100, 180);
		drawString(str6, 100, 200);
		
		
	}

}
