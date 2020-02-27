package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import model.ComparatorAdresse;
import model.Grundstueck;
import model.Immobilie;

public class Immobilienmakler
{

	private String name;
	private ArrayList<Immobilie> immobilien;

	public Immobilienmakler(String name)
	{
		this.name = name;
		this.immobilien = new ArrayList<Immobilie>();
	}

	public void aufnehmen(Immobilie immo)
	{
		if(immo != null)
		{
			if(immobilien.size() < 1000)
			{
				if(!immobilien.contains(immo))
				{
					immobilien.add(immo);
					System.out.println("Erfolgreich hinzugefügt!");
				}
				else
					System.out.println("Immobilie bereits enthalten");
			}
			else
				System.out.println("Keine Kapazität für weitere Immobilien");
		}
		else
			System.out.println("Null-Referenz übergeben");
	}

	public String toString()
	{
//		StringBuffer sb = new StringBuffer(10000);
//		sb.append("Immobilien-Makler ").append(this.name).append(", derzeit ").append(immobilien.size())
//				.append(" Immobilien");
//		sb.append("\n--------------------------------------------------\n");
//		for (Immobilie immo : immobilien)
//		{
//			sb.append(immo.toString()).append("\n");
//		}
//
//		return sb.toString();
//		
		String head = "";
		head = "Immobilien-Makler " + this.name + ", derzeit " + immobilien.size() + " Immobilien\n";
		if(head != null)
		{
			for (int i = 0; i < head.length(); i++)
			{
				head += "-";
			}
			System.out.println();
		}

		StringBuffer sb = new StringBuffer(10000);
		for (Immobilie immo : immobilien)
			{
				sb.append(immo.toString()).append("\n");
			}
			return head + sb.toString();

	}

	public float berechneGesamtVerkehrswert()
	{
		float ges = 0f;

		if(immobilien.size() > 0)
		{
			for (Immobilie immo : immobilien)
			{
				ges += immo.berechneVerkehrswert();
			}
			return ges;
		}
//		else
//			System.out.println("Keine Immobilien vorhanden");
		return ges;
	}

	public int entfernen(float flaeche)
	{
		int anz = 0;
		Iterator<Immobilie> iter = immobilien.iterator();
		{
			while (iter.hasNext())
			{
				if(iter.next().getFlaeche() < flaeche)
				{
					iter.remove();
					anz++;
				}
			}
		}

		return anz;

	}

	public float berechneAverageFlaecheBauland()
	{
		float ges = 0;
		float anz = 0;
		for (Immobilie immo : immobilien)
		{
			if(immo.toString().contains("Bauland"))
			{
//				System.out.println(immo.toString()); // Zur Fehlerfindung genutzt
				ges += immo.getFlaeche();
				anz++;
			}
		}
//		System.out.println("Ges "+ges+" : "+anz); // Zur Fehlerfindung genutzt
		return (ges / anz);
	}

	public void sortiereVerkehrswert()
	{
		Collections.sort(immobilien);
	}

	public void sortiereAdresse()
	{
		Collections.sort(immobilien, new ComparatorAdresse());
	}
}
