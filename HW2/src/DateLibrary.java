
public class DateLibrary {

	public static void main(String[] args) {
		String date1 = "2001-02-30";
		String date2 = "2001-08-08";
		String date3 = "200-10-808";
		String date4 = "2004-12-25";
		String date5 = "2001-08-08";
		System.out.println(isValidDateFormat(date1));//should print true, tests if invalid date in correct format
		System.out.println(isValidDateFormat(date2));//should print true, tests an actual date
		System.out.println(isValidDateFormat(date3));//should print false, tests not a date
		System.out.println(isValidDateFormat(date4));//should print true, test leap year
		
//		System.out.println(getYear(date1));//should print out 1234, tests year
//		System.out.println(getYear(date2));//should print out 2001
//		System.out.println(getYear(date3));//should print out -1,tests incorrect date format
//		System.out.println(getYear(date4));//should print 2004
//		
//		System.out.println(getMonth(date1));//should print -1,test month if month is not valid
//		System.out.println(getMonth(date2));//should print 8, test actual month
//		System.out.println(getMonth(date3));//should print -1,tests invalid format
//		System.out.println(getMonth(date4));//should print 12
//		
//		System.out.println(getDay(date1));//should print -1,tests if day is an actual possible day
//		System.out.println(getDay(date2));//should print 8, tests a real day
//		System.out.println(getDay(date3));//should print -1, tests
//		System.out.println(getDay(date4));//should print 25
//		
//		System.out.println(isLeapYear(getYear(date4)));//should print true
//		System.out.println(isLeapYear(getYear(date3)));//should print false
		
		System.out.println(isValidDate(date1));//should print false
		System.out.println(isValidDate(date2));//should print true
		System.out.println(isValidDate(date3));//should print false
		System.out.println(isValidDate(date4));//should print true
//		
//		System.out.println(compare(date2,date4));//should print negative
//		System.out.println(compare(date4,date2));//should print positive
//		System.out.println(compare(date2,date5));//should print 0
//		System.out.println(compare(date2,date1));//should print 0
	}
	public static boolean isValidDateFormat(String date) {
		if(date.length() != 10) {
			return false;
		}
		String year = "";
		String month = "";
		String day = "";
		if(date.charAt(4) == '-' && date.charAt(7) == '-') {
			year = date.substring(0, 4);
			month = date.substring(5,7);
			day = date.substring(8);
		}
		else {
			return false;
		}
		try {
			if(year.charAt(0) == '-' || month.charAt(0) == '-' || day.charAt(0) == '-') {
				return false;
			}
			int yearToInt = Integer.parseInt(year);
			int monthToInt = Integer.parseInt(month);
			int dayToInt = Integer.parseInt(day);
			return true;
		}
		catch (NumberFormatException e){
			return false;
		}
	}
	
	public static int getYear(String date) {
		if(isValidDateFormat(date)) {
			return Integer.parseInt(date.substring(0,4));
		}
		return -1;
	}
	
	public static int getMonth(String date) {
		if(isValidDateFormat(date)) {//checks if date is correct format
			if(Integer.parseInt(date.substring(5,7)) > 0 && Integer.parseInt(date.substring(5,7)) <= 12) {//checks if month is valid
				return Integer.parseInt(date.substring(5,7));
			}
			else {
				return -1;
			}
		}
		return -1;
	}
	
	public static int getDay(String date) {
		if(isValidDateFormat(date)) {
			if(Integer.parseInt(date.substring(8)) > 0 && Integer.parseInt(date.substring(8)) <= 31) {
				return Integer.parseInt(date.substring(8));
			}
			else {
				return -1;
			}
		}
		return -1;
	}
	
	public static boolean isLeapYear(int year) {
		if(year%400==0) {
			return true;
		}
		if(year%100==0) {
			return false;
		}
		if(year%4==0) {
		return true;
		}
		return false;
	}
	
	public static boolean isValidDate(String date) {
		if(isValidDateFormat(date)) { //checks if in valid format. No need to check for year as already checked in methods above.
									//also there is no year that is invalid that is four digits 
			if(isLeapYear(getYear(date))) {//checks if it is a leap year
				if(getMonth(date) == 2) {//checks if February
					if(getDay(date) > 0 && getDay(date) <= 29) {//checks if the day is between 0 and 29
						return true;//returns true if the day and month during leap year if valid
					}
					else {//if its not a valid day
						return false;
					}
				}
				if(getMonth(date) == 4 || getMonth(date) == 6 || getMonth(date) == 9 || getMonth(date) == 11) {//checks if month is valid for months with 30 days
					if(getDay(date) > 0 && getDay(date) <= 30) {//checks if day is between 0 and 30
						return true;
					}
					else {//if invalid day for months with 30 days
						return false;
					}
				}
				else {//months with 31 days
					if(getMonth(date) != -1) {
						if(getDay(date) > 0 && getDay(date) <= 31) {//checks for 31 instead of 30
							return true;
						}
						else {
							return false;
						}
					}
				}
			}
			else {//if its not a leap year
				if(getMonth(date) == 2) {//checks if the days in February are valid not during leap year
					if(getDay(date) > 0 && getDay(date) <=28) {
						return true;
					}
					else {
						return false;
					}
				}
				if(getMonth(date) == 4 || getMonth(date) == 6 || getMonth(date) == 9 || getMonth(date) == 11) {//checks if month is valid for months with 30 days
					if(getDay(date) > 0 && getDay(date) <= 30) {//checks if day is between 0 and 30
						return true;
					}
					else {//if invalid day for months with 30 days
						return false;
					}
				}
				else {//months with 31 days
					if(getMonth(date) != -1) {
						if(getDay(date) > 0 && getDay(date) <= 31) {//checks for 31 instead of 30
							return true;
						}
						else {
							return false;
						}
					}
				}
			}
		}
		return false;
	}
	
	public static int compare(String date1, String date2) {
		if(isValidDate(date1) && isValidDate(date2)) {
			return date1.compareTo(date2);
		}
			return 0;
		}
	}
