package yearly_calendar;

import day_counter.DayCounter;

public class YearlyCalendarApplication {

	public static void main(String[] args) {

		final int year = 2016;
		int totalNumberOfDaysInYear = 0;
		
		for(int month = 1; month <= 12; ++month) {
			
			totalNumberOfDaysInYear += DayCounter.countDays(month, year);
		}
		
		final String []dates = new String[totalNumberOfDaysInYear];
		int datesIndex = 0;
		
		for(int month = 1; month <= 12; ++month) {
			
			final int daysInMonth = DayCounter.countDays(month, year);
			
			for(int day = 1; day <= daysInMonth; ++day) {
				
				dates[datesIndex] = String.format("%02d/%02d/%d", day, month, year);
				
				datesIndex += 1;
			}
		}
		
		for(int i = 0; i < totalNumberOfDaysInYear; ++i) {
			
			System.out.println(dates[i]);
		}
		
		System.out.println(String.format("Total number of days in %d: %d", year, totalNumberOfDaysInYear));
	}
}
