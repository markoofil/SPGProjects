package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

@SuppressWarnings("serial")
public class Telefonprovider implements Serializable
{
	private LinkedList<Telefonat> telefonate;

	public Telefonprovider()
	{
		telefonate = new LinkedList<Telefonat>();
	}

	public void add(Telefonat telefonat) throws TelefonException
	{
		if(telefonat != null)
			if(!telefonate.contains(telefonat))
				telefonate.add(telefonat);
			else
				throw new TelefonException("Telefonat \n   " + telefonat + "\nist schon in der Collection!!");
		else
			throw new TelefonException("null-Referenz für Telefonprovider.add(telefonat!!");
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder(10000);
		sb.append("Telefonprovider TurboTel\n-------------------------\n");
		for (Telefonat t : telefonate)
			sb.append(t).append('\n');
		return sb.toString();
	}

//	 ------------------------------------ Files -----------------------------

	public boolean remove(int pos) throws TelefonException
	{
		if(!telefonate.isEmpty())
		{
			if(pos >= 0)
			{
				System.out.println(telefonate.get(pos) + " wird entfernt");
				telefonate.remove(pos);

				return true;
			}
			else
				throw new TelefonException("negativer Wert für pos übergeben");
		}
		else
			throw new TelefonException("Liste ist leer");

	}

	public int remove(String telNr) throws TelefonException
	{
		int anz = 0;
		Iterator<Telefonat> iter = telefonate.iterator();

		if(telNr != null)
		{
			if(!telefonate.isEmpty())
			{
				while (iter.hasNext())
				{
					if(iter.next().getEigeneNr().equals(telNr))
					{
						iter.remove();
						anz++;
						return anz;
					}

				}
			}
			else
				throw new TelefonException("Leere Collection");
		}
		else
			throw new TelefonException("Null-Ref. übergeben für telNr");

		return anz;

	}

	public void sortiereTelNr()
	{
		Collections.sort(telefonate);
		Collections.reverse(telefonate);
	}

	public void sortiereZeit()
	{
		Collections.sort(telefonate, new ComparatorZeit());
	}

	public void saveTelefonate(String filename) throws TelefonException
	{
		if(filename != null)
		{
			try
			{
				FileOutputStream fos = new FileOutputStream(filename);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(telefonate);
				oos.close();
			}
			catch (FileNotFoundException e)
			{
				throw new TelefonException(
						"FileNotFoundException bei saveTelefonate(String filename). Grund: " + e.getMessage());
			}
			catch (IOException e)
			{
				throw new TelefonException("IOException bei saveTelefonate(String filename). Grund: " + e.getMessage());
			}
		}
		else
			throw new TelefonException("Null-Ref. für saveTelefonate(String filename) übergeben!!");
	}

	public void loadTelefonate(String filename) throws TelefonException
	{

		if(filename != null)
		{
			ObjectInputStream ois = null;

			try
			{
				ois = new ObjectInputStream(new FileInputStream(filename));

				List<?> tempCollection = (List<?>) ois.readObject();
				for (Object o : tempCollection)
					if(o instanceof Telefonat)
						add((Telefonat) o);
					else
						throw new TelefonException("Falsches Objekt zur serialisierung übergeben");

			}
			catch (FileNotFoundException e)
			{
				throw new TelefonException("FileNotFoundException! Grund: " + e.getMessage());
			}
			catch (IOException e)
			{

				throw new TelefonException("IOException! Grund: " + e.getMessage());
			}
			catch (ClassNotFoundException e)
			{
				throw new TelefonException("ClassNotFoundException! Grund: " + e.getMessage());
			}
			finally
			{
				try
				{
					ois.close();
				}
				catch (IOException e)
				{
					throw new TelefonException("IOException! Grund: " + e.getMessage());
				}
			}

		}
		else
			throw new TelefonException("Null-Ref. für loadTelefonate(filename) übergeben");

	}
}
