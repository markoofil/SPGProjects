package test;

import java.time.Year;

import model.Angestellte;
import model.MitarbeiterException;

public class TestAngestellte
{

	public static void main(String[] args)
	{
//		Angestellte a1 = new Angestellte("Paul", Year.of(1980), Year.of(2020), 'm');
		Angestellte a1;
		try
		{
			a1 = new Angestellte("Alexandra", Year.of(1980), Year.of(2020), 'w');
			System.out.println(a1.toString());
		}
		catch (MitarbeiterException e)
		{
			System.out.println(e.getMessage());
		}
//		Angestellte a1 = new Angestellte("Paul", Year.of(1980), Year.of(2020), 'm');
//		Angestellte a1 = new Angestellte("Paul", Year.of(1980), Year.of(2020), 'm');
//		Angestellte a1 = new Angestellte("Paul", Year.of(1980), Year.of(2020), 'm');
		
	}

}
