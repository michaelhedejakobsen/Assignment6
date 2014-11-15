/**
 * Day class is a class that holds values for the current day, next day, previous day, and calculates a day in the future or past with a user input number of days.
 * The class has a constructor that holds no parameters, and an overloaded constructor that holds the parameter int day.
 * The class has set and get for day.
 * @author Michael H. Jakobsen
 * Date: 13. November 2014
 *
 */
public class Day {

	/**
	 * Initialize integer day.
	 */
	public int day;
	
	/**
	 * Initialize an array of Strings, holding the days of the week.
	 */
	private final String [] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	
	/**
	 * Constructs a new day that holds day = 0
	 */
	public Day (){
		day = 0;
	}
	
	/**
	 * Constructs a new Day that holds the value of the integer day, based on the parameters.
	 * @param day
	 */
	public Day (int day){	
		this.day = day;
	}
	
	/**
	 * Sets the current day of the week. With a for loop testing which day it is, based on the array daysOfWeek.
	 * @param day
	 */
	public void setDay(String day){
		/**
		 * For loop to check which day of the week it is. Compares the int day to the value of the String value of daysOfWeek.
		 */
		for(int i = 0 ; i < daysOfWeek.length; i++)
		{
			if(day.equals(daysOfWeek[i]))
				this.day = i;
		}
	}
	
	/**
	 * Gets the current day of the week, by user input from the DayGUI class.
	 * @return daysOfWeek[day]
	 */
	public String getDay(){
		return daysOfWeek[day];
	}
	
	/**
	 * String that calculates the next day, based on the current value of daysOfWeek[day] and adding 1.
	 * @return daysOfWeek[day+1]
	 */
	public String nextDay(){
		return daysOfWeek[day+1];
	}
	
	/**
	 * String that calculates the previous day, based on the current value of daysOfWeek[day] and subtracting 1.
	 * @return daysOfWeek[day-1], or if the current day is Sun it will return: daysOfWeek[6]
	 */
	public String prevDay(){
		if(day > 0)
		return daysOfWeek[day-1];
		else
			return daysOfWeek[6];
	}
	
	/**
	 * String that calculates a day, by adding the user input days to the current value of daysOfWeek[day].
	 * @param num
	 * @return daysOfWeek[day2]
	 */
	public String calculateDay(int num){
		/**
		 * Initialize int day2, that holds the value of the calculated day.
		 * IF statement, to be able to use negative numbers also.
		 */
		int day2;
		
		// If input number is greater than or equal to 0, add the current day to the user input, find the remainder after dividing by 7. Store value in day2.
		if(num >= 0)
			day2 = (num + this.day) % 7;
		// Else
		else
			day2 = (this.day + (7 - (num* -1) % 7)) % 7;
		
		return daysOfWeek[day2];
	}
}
