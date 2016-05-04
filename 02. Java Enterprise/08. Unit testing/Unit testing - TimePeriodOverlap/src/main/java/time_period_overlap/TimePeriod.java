package time_period_overlap;

import java.time.LocalTime;

public class TimePeriod {

	final private LocalTime startTime;
	final private LocalTime endTime;
	
	public TimePeriod(final LocalTime startTime, final LocalTime endTime) {

		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public boolean overlapsWith(final TimePeriod timePeriodB) {
		
		return startTime.isBefore(timePeriodB.getEndTime()) && endTime.isAfter(timePeriodB.getStartTime());
	}

	public LocalTime getStartTime() {
		
		return startTime;
	}

	public LocalTime getEndTime() {
		
		return endTime;
	}
}
