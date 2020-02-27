package test;

import model.Grundstueck;


public class EinPaarImmobilienZumTesten
{
	public static void main(String[] args)
	{
	// ACHTUNG! Das ist keine sinnvolle Java-Klasse, nur eine Vorlage mit
	// "Immobilien", die das Testen
	// vereinfachen sollen (aus diesen m�ssen nat�rlich Grundst�cke "gemacht" werden
	// !).

//            Immobilie immo1 = new Immobilie("1050 Wien, Bacherplatz 1",2000f);
//            System.out.println(immo1);
//            Immobilie immo2 = new Immobilie("9876 Au, Weide 11",1000f);
//            System.out.println(immo2);
//            Immobilie immo3 = new Immobilie("2233 Schrems, Uferpromenade",10000f);
//            System.out.println(immo3);
//            Immobilie immo4 = new Immobilie("4600 Wels, Vogelweiderstra�e",5000f);
//            System.out.println(immo4);
//            Immobilie immo5 = new Immobilie("1140 Wien, Pfarrwiese",7500f);
//            System.out.println(immo5);

	Grundstueck g1 = new Grundstueck("1050 Wien, Bacherplatz 1",2000f, 'b', 100f);
	Grundstueck g2 = new Grundstueck("9876 Au, Weide 11",1000f, 'g', 100f);
	Grundstueck g3 = new Grundstueck("2233 Schrems, Uferpromenade",10000f, 'n', 100f);
	Grundstueck g4 = new Grundstueck("4600 Wels, Vogelweiderstraße",5000f, 'z', 100f);
	Grundstueck g5 = new Grundstueck("1140 Wien, Pfarrwiese",7500f, 'b', 100f);
	
//	System.out.println(g1);
//	System.out.println(g2);
//	System.out.println(g3);
//	System.out.println(g4);
//	System.out.println(g5);
	
	Immobilienmakler makler = new Immobilienmakler("Paul");
	
//	makler.aufnehmen(null);	// Test: Null-Ref. übergeben
//	makler.aufnehmen(g1);	
//	makler.aufnehmen(g1);	// Test: ob bereits vorhanden
//	makler.aufnehmen(g2);
//	makler.aufnehmen(g3);	// Test: Kapazität (Parametercheck auf <2 gesetzt)
	
	makler.aufnehmen(g1);
	makler.aufnehmen(g2);
	makler.aufnehmen(g3);
	makler.aufnehmen(g4);
	makler.aufnehmen(g5);
	
	System.out.println(makler.toString());
//	System.out.println(makler.berechneGesamtVerkehrswert());
	
//	System.out.println(makler.entfernen(5000));
//	System.out.println("Nach entfernen");
//	System.out.println(makler.toString());
	
//	System.out.println(makler.berechneAverageFlaecheBauland());
	
//	System.out.println("Nach dem sort");
//	makler.sortiereVerkehrswert();
//	System.out.println(makler.toString());
	
//	System.out.println("Nach dem sort");
	makler.sortiereAdresse();
//	System.out.println(makler.toString());
	
	}
}
