package test;
import java.time.*;
import java.time.format.*;
public class LocalDateTimeFormatierungsTest
{

    public static void main(String[] args)
    {
		LocalDateTime dateTime = LocalDateTime.now();
		
		String zeitString = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm"));
		
		System.out.println(zeitString);
    }

}
