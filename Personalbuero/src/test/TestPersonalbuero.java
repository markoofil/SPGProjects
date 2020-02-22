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
		
//										-------------- Mitarbeiter ----------------
		Personalbuero p1 = new Personalbuero();

		Angestellte a1 = new Angestellte("Paul", Year.of(1990), Year.of(2005), 'w'); // darf hinein
		Angestellte a2 = new Angestellte("Paul", Year.of(1989), Year.of(2005), 'w'); // darf hinein
		Angestellte a3 = new Angestellte("Paul", Year.of(1980), Year.of(1995), 'w'); // darf hinein, dann ist quote
																						// false
		Angestellte a4 = new Angestellte("Paul", Year.of(1980), Year.of(2020), 'm'); // jetzt muss wieder eine Frau rein

		Freelancer f1 = new Freelancer("Paul", Year.of(1980), Year.of(2019), 'w', 50, 200);
		Manager man1 = new Manager("Marko", Year.of(1980), Year.of(2000), 'w', 10000);
		Manager man2 = new Manager("Polo", Year.of(1980), Year.of(2000), 'w', 20000);
		Manager man3 = new Manager("Ivan", Year.of(1980), Year.of(2000), 'w', 30000);
		Manager man4 = new Manager("Matija", Year.of(1980), Year.of(2000), 'w', 40000);
		Manager man5 = new Manager("Jeff", Year.of(1980), Year.of(2000), 'm', 50000);
		Manager man6 = new Manager("Bill", Year.of(1980), Year.of(2000), 'm', 60000);
		Vertreter v1 = new Vertreter("Marko", Year.of(1980), Year.of(2000), 'm', 1400, 160000);
		
		
		
		
// 										--------- Mitarbeiter aufnehmen -----------
		
		
		
		
//		System.out.println(p1.aufnehmen(a1));
//		System.out.println(p1.aufnehmen(a2));
//		System.out.println(p1.aufnehmen(a3));
//		System.out.println(p1.aufnehmen(a4));
//		
//		System.out.println(p1.aufnehmen(f1));
//		System.out.println(p1.aufnehmen(a3));
//		System.out.println(p1.aufnehmen(v1));
		System.out.println(p1.aufnehmen(man1));
		System.out.println(p1.aufnehmen(man2));
		System.out.println(p1.aufnehmen(man3));
		System.out.println(p1.aufnehmen(man4));
		System.out.println(p1.aufnehmen(man5));
		System.out.println(p1.aufnehmen(man6));
		
		
//								------------ viele mittels Schleife Aufnehmen -----------
		
		
		
//		for(int i = 0; i <= 100; i++)
//		{
//			System.out.println(p1.aufnehmen(a1));
//		}

		
//									---------------------- Ausgaben --------------------
//		System.out.println(p1.frauenQuote());
		System.out.println(p1);
//		System.out.println(p1.berechneGehaltsSumme());
//		System.out.println(p1.zaehleAlter(30));
//		System.out.println(p1.zaehleAngestellte());
//		System.out.println(p1.kuendigen(1));
//		System.out.println(p1.berechneAvgGehaltAngestellte());

//		System.out.println(p1.kuendigen("Paul"));
//		System.out.println(p1.zaehleAngestellte());
//		System.out.println(p1.berechneAvgGehaltAngestellte());
//		System.out.println(p1.kuendigen(a2));
//		System.out.println(p1.zaehleAngestellte());
//		System.out.println(p1.topVerdiener(1999));
//		System.out.println(p1.gehaltsListe());
//		System.out.println(p1.praemienListe(null));
		p1.erhoeheManagerFixum(25);
		
		System.out.println(p1);
		

	}

}
