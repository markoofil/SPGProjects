package test;

import java.time.LocalDateTime;

import model.Gespraech;
import model.SMS;
import model.TelefonException;
import model.Telefonprovider;

public class SaveTest
{

	public static void main(String[] args)
	{
		try
		{
			Gespraech g1 = new Gespraech("069912345678", "069987654321", LocalDateTime.of(2017, 12, 1, 7, 10), true, 60,
					10);
			Gespraech g2 = new Gespraech("069912345678", "06642345678", LocalDateTime.of(20176, 2, 11, 13, 45), true,
					61, 10);
			Gespraech g3 = new Gespraech("06642345678", "069987654321", LocalDateTime.now(), false, 160, 10);
			Gespraech g4 = new Gespraech("06762242228", "06762242228", LocalDateTime.of(2017, 2, 12, 15, 15), true, 181,
					10);
			Gespraech g5 = new Gespraech("069912345678", "069987654321", LocalDateTime.of(2017, 1, 10, 21, 55), true,
					601, 10);
			Gespraech g6 = new Gespraech("06762242228", "069987654321", LocalDateTime.of(2017, 3, 11, 11, 22), false,
					61, 10);

			SMS s1 = new SMS("06762242228", "06762242228", LocalDateTime.now(), true,
					"Heute POS1-Kolloquium - freu' mich schon sooo", 10);
			SMS s2 = new SMS("069912345678", "06642345678", LocalDateTime.of(2017, 2, 11, 4, 31), true,
					"Eine kurze Message", 10);
			SMS s3 = new SMS("069912345678", "069987654321", LocalDateTime.of(2017, 4, 13, 19, 50), false,
					"Wenn SMS-Nachrichten mit mehr als 160 Zeichen gesendet werden, "
							+ "so werden diese dennoch an den Empfänger gesendet, allerdings in mehreren einzelnen SMS-Nachrichten. \n"
							+ "Das Empfänger-Handy fügt diese einzelnen SMS aber wieder zu einer einzigen langen Nachricht zusammen. \n"
							+ "Jede Teil-SMS kann dabei bis zu 153 Zeichen enthalten.",
					10); // 0
			SMS s4 = new SMS("06642345678", "069987654321", LocalDateTime.of(2017, 8, 17, 5, 6), false, "", 10);
			SMS s5 = new SMS("069912345678", "06642345678", LocalDateTime.of(2017, 9, 18, 18, 10), true,
					"Das ist eine ein bisschen längere Nachricht", 10);
			SMS s6 = new SMS("06642345678", "069987654321", LocalDateTime.of(2017, 12, 11, 17, 20), true,
					"keine Ahnung, was ich schreiben soll", 10);

			Telefonprovider p1 = new Telefonprovider();

			p1.add(g1);
			p1.add(g2);
			p1.add(g3);
			p1.add(g4);
			p1.add(g5);
			p1.add(g6);
			
			p1.add(s1);
			p1.add(s2);
			p1.add(s3);
			p1.add(s4);
			p1.add(s5);
			p1.add(s6);

			System.out.println(p1.toString());

			p1.saveTelefonate("/Users/Marko/desktop/saveTelefonate.txt");

		}
		catch (TelefonException e)
		{

			System.out.println(e.getMessage());
		}

	}

}
