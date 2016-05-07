import java.net.*;
import java.io.*;
import java.util.*;

public class MortgageCalc {
	public static final String RATE_FILE_URL="http://yadongliu.github.io/java/notes/rates.txt";
	// read rate data from web
	// term, rate
	public static HashMap readRatesFromWeb(String urlString) throws IOException {
		URL url = new URL(urlString);
     	URLConnection connection = url.openConnection();
     	InputStream urlData = connection.getInputStream();

     	String contentType = connection.getContentType();
     	System.out.println("Stream opened with content type: " + contentType);
     	System.out.println();
     	if (contentType == null || contentType.startsWith("text") == false)
        	throw new IOException("URL does not seem to refer to a text file.");
     	System.out.println("Fetching mortgage rates from " + urlString + " ...");
     	System.out.println();

     /* Copy lines of text from the input stream to the screen, until
       end-of-file is encountered  (or an error occurs). */

     	BufferedReader in;  // For reading from the connection's input stream.
     	in = new BufferedReader( new InputStreamReader(urlData) );

     	HashMap<Integer, Double> rateMap = new HashMap<Integer, Double>();
     	String line;
    	while ( (line = in.readLine()) != null) {
          	System.out.println(line);
            String[] rateArray = line.split(",");
            rateMap.put(Integer.parseInt(rateArray[0]), Double.parseDouble(rateArray[1]));
     	}
     	in.close();

     	return rateMap;
	}

	public static double calculateMortgage(double principal, int months, double rate) {
		// M = P[i(1+i)^n]/[(1+i)^n -1]
		double monthlyInterest = rate*0.01 / 12.0f;

		double temp = Math.pow(1.0+monthlyInterest, months);

		double result = principal*monthlyInterest*temp/(temp-1.0);

		System.out.println("Total months: "+months+", Rate: "+rate+", Monthly payment is: "+result);
		return result;
	}

	public static void main(String[] args) {
		HashMap rateMap=null;
		try {
			rateMap = readRatesFromWeb(RATE_FILE_URL);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println( "Enter your principal amount: ");
		Scanner scanner = new Scanner(System.in);
		double principal = scanner.nextDouble();

		Iterator iterator = rateMap.entrySet().iterator();

		while(iterator.hasNext()) {
			Map.Entry pair = (Map.Entry)iterator.next();
        	System.out.println(pair.getKey() + " = " + pair.getValue());
        	int months = ((Integer)pair.getKey()) * 12;
			double monthly = calculateMortgage(principal, months, (Double)pair.getValue());
    	}
		
	}
}

