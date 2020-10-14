package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		min = da[0];
		
		for (double element : da) {
			if (element < min) {
				min = element;
			}
		}
		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latArray = new double[gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i++) {
			
			latArray[i] = gpspoints[i].getLatitude();
			
		}
		
		return latArray;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] longArray = new double[gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i++) {
			
			longArray[i] = gpspoints[i].getLongitude();
			
		}
		
		return longArray;

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		
		double latitude1, longitude1, latitude2, longitude2;

		latitude1 = gpspoint1.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		
		latitude2 = gpspoint2.getLatitude();
		longitude2 = gpspoint2.getLongitude();
		
		double Phi1 = toRadians(latitude1);
		double Phi2 = toRadians(latitude2);
		
		double deltaPhi = toRadians(latitude2 - latitude1);
		double deltaLambda = toRadians(longitude2-longitude1);
		
		double a = pow(sin(deltaPhi/2), 2) + cos(Phi1) * cos(Phi2) * pow(sin(deltaLambda/2), 2);
		double c = 2 * atan2(sqrt(a),sqrt((1-a)));
		double d = R * c;
		
		return d;
		
		
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double secs = gpspoint2.getTime() - gpspoint1.getTime();
		
		double timer = secs / 3600;
		
		//deler på 1000 pga returnert distance er i meter
		double km = (distance(gpspoint1, gpspoint2))/1000;
		
		double speed = km/timer;
		
		return speed;
		

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		
		int timer = secs / (60*60);
		
		int min = secs % (60*60) / 60;
		
		int sek = secs % 60;
		
		
		String hh = "" + timer;
		
		String mm = "" + min;
		
		String ss = "" + sek;
		
		if (timer < 10) {
			hh = "0" + timer;
		}
		
		if (min < 10) {
			mm = "0" + min;
		}
		
		if (sek < 10) {
			ss = "0" + sek;
		}
		
		timestr = "  " + hh + ":" + mm + ":" + ss;
        
        return timestr;

		

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str = "";
		
		String space = "";

		//Må gange med 100 også runde av, deretter dele med 100
		double rounded = round(d*100.0)/100.0;
		
		str += rounded;
		
		int leng = str.length();
		
		if (leng < 10 ) {
			
			int diff = 10 - leng;
			
			for (int i = 0; i < diff; i++) {
				
				space += " ";
				
			}
		}
		
		str = space + str;
		
		return str;
		
		
		
	}
}
