package test;

import java.time.Year;

import model.Angestellte;
import model.Freelancer;
import model.Manager;
import model.Personalbuero;
import model.Vertreter;

public class TestPersonalbuero
{

	public static void main(String[] args)
	{
		Personalbuero p1 = new Personalbuero();
		
		Angestellte a1 = new Angestellte("Paul", Year.of(1980), Year.of(2020), 'w');
		Angestellte a2 = new Angestellte("Paul", Year.of(1980), Year.of(2020), 'w');
		Angestellte a3 = new Angestellte("Paul", Year.of(1980), Year.of(2020), 'w');
		Angestellte a4 = new Angestellte("Paul", Year.of(1980), Year.of(2020), 'w');
		
		
		
//		
//		Freelancer f1 = new Freelancer("Paul", Year.of(1930), Year.of(2019), 'w', 50, 200);
//		Manager man1 = new Manager("Marko", Year.of(1955), Year.of(1970), 'w', 12500);
//		Vertreter v1 = new Vertreter("Marko", Year.of(1955), Year.of(1970), 'w', 1400, 160000);

		p1.aufnehmen(a1);
		p1.aufnehmen(a2);
		p1.aufnehmen(a3);
		p1.aufnehmen(a4);
		
		System.out.println(p1);

	}

}
