public class Date {
	int year;
    int month;
    int day;
    static final String[] DAY_OF_WEEK={"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    // Figure out what kind of properties of the Date object you need to keep track of
    // Those would be your Date class's member variables


    // default constructor takes no argument
    public Date()
    {
        // what's a good default date?
        // fill in your implementation below

    }

    // another constructor takes three arguments
    public Date(int d, int m, int y)
    {
        // fill in your implementation below
        day = d;
        month = m;
        year = y;
    }

    /** Returns the number of days in a given month.
     *  @param month is a month, numbered in the range 1...12.
     *  @param year is the year in question, with no digits omitted.
     *  @return the number of days in the given month.
     */
    public static int daysInMonth(int month, int year) {
        // fill in your implementation below
    	final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31,
            30, 31, 30, 31};

        // Feb in a leap year has 29 days.
        if( Date.isLeapYear(year) && month == 2) {
        	return 29;
        }
    	return DAYS_IN_MONTH[month-1];
    }

    /** Returns the number of days in a given year */
    public static int daysInYear(int year) {
        // fill in your implementation below
        // a leap year has 366 days; all others have 365

    	return Date.isLeapYear(year) ? 366 : 365;
    }

    /** Returns day of the week for Jan 1st of the given year */
    public static int dayOfWeekForFirstDayOfYear(int year) {
        // assuming you somehow know Jan 1, 1000 is a Monday.
        // now you should be able to calculate how many days there is between
        // Jan 1, 1000 and Jan 1 of the year you are interested in

        // fill in your implementation below
        final int MONDAY = 1;

        int REFERENCE_DAY=1;
        int REFERENCE_MONTH=1;
        int REFERENCE_YEAR=1000;

        int daysSinceReference = 0;
        int result = 0;
        if( year == REFERENCE_YEAR) {
        	result = MONDAY;
        } else if (year > REFERENCE_YEAR) {
        	for(int i=REFERENCE_YEAR; i<year; i++) {
        		daysSinceReference += Date.daysInYear(i);
        	}
			System.out.println("Year 1000 is: " + daysSinceReference + " days away from " + year);
	        // next day after daysSinceReference
    	    result = ( daysSinceReference%7 + MONDAY + 1)%7;
        } else {
        	for(int i=year; i<REFERENCE_YEAR; i++) {
        		daysSinceReference += Date.daysInYear(i);
        	}
			System.out.println("Year 1000 is: " + daysSinceReference + " days away from " + year);
	        // next day after daysSinceReference
    	    result = ( daysSinceReference%7 + MONDAY + 1)%7;
        }

        System.out.println("dayOfWeekForFirstDayOfYear: "+year+" is: "+ DAY_OF_WEEK[result]);

    	return result;
    }

    /** Checks whether the given year is a leap year.
     *  @return true if and only if the input year is a leap year.
     */
    public static boolean isLeapYear(int year) {
        // fill in your implementation below
        // special year: 1582;

       	if( year <= 1582 ) {
       		return year % 4 ==0 ? true : false;
       	}

        boolean bLeapYear = false;
        // divisible by 4
        bLeapYear = (year % 4 == 0);

        // divisible by 4 and not 100
        bLeapYear = bLeapYear && (year % 100 != 0);

        // divisible by 4 and not 100 unless divisible by 400
        bLeapYear = bLeapYear || (year % 400 == 0);

        return bLeapYear;
    }

    public static boolean isLeapYearAlt(int year) {
        boolean isLeapYear;

        // divisible by 4
        isLeapYear = (year % 4 == 0);

        // divisible by 4 and not 100
        isLeapYear = isLeapYear && (year % 100 != 0);

        // divisible by 4 and not 100 unless divisible by 400
        isLeapYear = isLeapYear || (year % 400 == 0);

        return isLeapYear;
    }

    public void printMonth()
    {
        // fill in your implementation below
    	System.out.println("Year: "+year+", Month: "+month);
    	System.out.println("Sun Mon Tue Wed Thu Fri Sat");
    	int n = Date.daysInMonth(month, year);
    	for(int i=1; i<=n; i++) {

    	}
    }

    // place your tests inside main
    public static void main(String[] args)
    {
        Date testDate = new Date(1, 1, 2015);

        int year = Integer.parseInt(args[0]);
        Date.dayOfWeekForFirstDayOfYear( year );

		System.out.println("Year: "+year+" is leap: " + Date.isLeapYear(year) );
        // testDate.printMonth();

    }

}