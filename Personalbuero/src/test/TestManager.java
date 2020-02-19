package test;

import java.time.Year;

import model.Manager;

public class TestManager
{

	public static void main(String[] args)
	{
//		Manager man1 = new Manager("Marko", Year.of(1955), Year.of(1970), 'M', -1);
//		Manager man1 = new Manager("Marko", Year.of(1955), Year.of(1970), 'M', 0);
		Manager man1 = new Manager("Marko", Year.of(1955), Year.of(1970), 'M', 12500);
		
		System.out.println(man1.toString());
	}

}
