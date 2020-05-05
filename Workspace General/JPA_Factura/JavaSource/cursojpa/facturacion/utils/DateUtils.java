package cursojpa.facturacion.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils
{
	public static String fechaToString(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");		
		return sdf.format(date);	
	}
	
	public static Date toStringFecha(String date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		Date d = null;
		
		try
		{
			d = sdf.parse(date);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return d;
	}
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date d = null;
		try
		{
			d = sdf.parse("07/06/2014");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("date: "+d);
	}
}
