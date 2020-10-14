package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
	// skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26

	private static int TIME_STARTINDEX = 11; // startindex for tidspunkt i timestr

	public static int toSeconds(String timestr) {

		// Henter ut timene fra strengen
		String strHrs = timestr.substring(11, 13);

		// Gjør time-strengen til int
		int intHrs = Integer.parseInt(strHrs);

		// Gjør timene om til sekunder
		int hrsToSec = intHrs * 60 * 60;

		// Henter ut minuttene fra strengen
		String strMin = timestr.substring(14, 16);

		// Gjør minutt-strengen til int
		int intMin = Integer.parseInt(strMin);

		// Gjør minuttene til sekunder
		int minToSec = intMin * 60;

		// Henter ut sekundene fra strengen
		String strSec = timestr.substring(17, 19);

		// Gjør sekundene til int
		int intSec = Integer.parseInt(strSec);

		// Alt legges sammen
		int totalSec = hrsToSec + minToSec + intSec;

		//System.out.println(totalSec);

		return totalSec;

	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		//Bruker toSeconds-metoden på "time"
		int sec = toSeconds(timeStr);
		
		//Gjør latitude, longitude og elevation om til double
		double dobLat = Double.parseDouble(latitudeStr);
		double dobLong = Double.parseDouble(longitudeStr);
		double dobEle = Double.parseDouble(elevationStr);
		
		
		//Oppretter nytt GPSPoint-objekt som tar de nye verdiene
		GPSPoint gps_point = new GPSPoint(sec, dobLat, dobLong, dobEle);

		return gps_point;

	}

}
