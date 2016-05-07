import java.net.*;
import java.io.*;
import java.util.*;

public class Mortgage {
	private static final String URL_STRING = "http://yadongliu.github.io/java/notes/rates.txt";

	public static void main(String[] args) {
		double principal;

		System.out.print("How much do you want to borrow: ");
		Scanner scanner = new Scanner(System.in);
		principal = scanner.nextDouble();

		HashMap ratesMap;
		try {
			ratesMap = fetchRate(URL_STRING);
			Set years = ratesMap.keySet();
			Iterator it = years.iterator();
			while( it.hasNext() ) {
				String year = (String) it.next(); 
				String rate = (String) ratesMap.get( year );

				calcMonthly(principal, Integer.parseInt(year)*12, 
					Double.parseDouble(rate) );
			}

		} catch (IOException e) {
			e.printStackTrace(); 
		}

	}

	public static HashMap fetchRate(String urlString) throws IOException {
		// open Url connection
		URL url = new URL(urlString);
     	URLConnection connection = url.openConnection();
     	InputStream urlData = connection.getInputStream();

		// Read from InputStream 
     	BufferedReader in;  // For reading from the connection's input stream.
     	in = new BufferedReader( new InputStreamReader(urlData) );

     	HashMap rateMap = new HashMap();
     	String line = in.readLine();
     	while( line != null) {
     		// System.out.println("I just read: " + line);
		// parse the text and convert them into doubles
		// and store them into a HashMap 
     		String[] rateLine = line.split(",");
     		rateMap.put(rateLine[0], rateLine[1]);

     		line = in.readLine();
     	} 

     	return rateMap;
	}

	public static double calcMonthly
	(double principal, int months, double rate) 
	{
		double monthRate = rate / 1200.0;

		double temp = Math.pow(1 + monthRate, months);

		double result = principal*(monthRate*temp)/(temp-1);

		System.out.println("Principal: "+principal+", rate: "
			+rate+", Months: "+months+", monthly payment: "+result);
		return result;
	}
}