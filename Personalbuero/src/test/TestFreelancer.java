package test;

import java.time.Year;

import model.Freelancer;
import model.MitarbeiterException;

public class TestFreelancer 
{

	public static void main(String[] args)
	{
//		Freelancer f1 = new Freelancer(null, Year.of(1900), Year.of(2019), 'm', -2, -2);
//		Freelancer f1 = new Freelancer("Paul", Year.of(1930), Year.of(2020), 'm', -2, -2);
//		Freelancer f1 = new Freelancer("Paul", Year.of(1930), Year.of(2019), 'm', 1001, 0);
		Freelancer f1;
		try
		{
			f1 = new Freelancer("Paul", Year.of(1930), Year.of(2019), 'm', 50, 200);
			System.out.println(f1.toString());
		}
		catch (MitarbeiterException e)
		{
			System.out.println(e.getMessage());
		}

		
		
	}

}
