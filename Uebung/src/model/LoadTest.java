package model;


public class LoadTest
{

	public static void main(String[] args)
	{
		try
		{
			Telefonprovider p1 = new Telefonprovider();

			p1.loadTelefonate("/Users/Marko/desktop/saveTelefonate.txt");
//			p1.loadTelefonate(null);
			System.out.println(p1.toString());
		}
		catch (TelefonException e)
		{
			System.out.println(e.getMessage());
		}

	}

}
