package test;
import model.Immobilie;
public class EinPaarImmobilienZumTesten
{
		// ACHTUNG! Das ist keine sinnvolle Java-Klasse, nur eine Vorlage mit "Immobilien", die das Testen 
		//          vereinfachen sollen (aus diesen müssen natürlich Grundstücke "gemacht" werden !).
	
    	
            Immobilie immo1 = new Immobilie("1050 Wien, Bacherplatz 1",2000f);
            System.out.println(immo1);
            Immobilie immo2 = new Immobilie("9876 Au, Weide 11",1000f);
            System.out.println(immo2);
            Immobilie immo3 = new Immobilie("2233 Schrems, Uferpromenade",10000f);
            System.out.println(immo3);
            Immobilie immo4 = new Immobilie("4600 Wels, Vogelweiderstraße",5000f);
            System.out.println(immo4);
            Immobilie immo5 = new Immobilie("1140 Wien, Pfarrwiese",7500f);
            System.out.println(immo5);



}
