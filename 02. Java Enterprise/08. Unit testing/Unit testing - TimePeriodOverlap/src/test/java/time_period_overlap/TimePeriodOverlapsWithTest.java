package time_period_overlap;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TimePeriodOverlapsWithTest {

	private TimePeriod timePeriodA;
	
	@Before
	public void setTimePeriod() {
		
		final LocalTime startTime = LocalTime.of(15, 0);
		final LocalTime endTime = LocalTime.of(18, 0);
		
		timePeriodA = new TimePeriod(startTime, endTime);
	}
	
	@Test
	public void sameStartSameEnd() {
		
		final LocalTime startTime = timePeriodA.getStartTime();
		final LocalTime endTime = timePeriodA.getEndTime();
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
	}
	
	@Test		
	public void sameStartEndABeforeEndB() {
		
		final LocalTime startTime = timePeriodA.getStartTime();
		final LocalTime endTime = timePeriodA.getEndTime().plusHours(1);
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
	}
	
	@Test
	public void sameStartEndAAfterEndB() {
		
		final LocalTime startTime = timePeriodA.getStartTime();
		final LocalTime endTime = timePeriodA.getEndTime().minusHours(1);
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
	}
	
	@Test
	public void startABeforeStartBSameEnd() {
		
		final LocalTime startTime = timePeriodA.getStartTime().plusHours(1);
		final LocalTime endTime = timePeriodA.getEndTime();
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
	}
	
	@Test
	public void startAAfterStartBSameEnd() {
		
		final LocalTime startTime = timePeriodA.getStartTime().minusHours(1);
		final LocalTime endTime = timePeriodA.getEndTime();
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
	}
	
	@Test
	public void startABeforeStartBEndABeforeEndB() {
		
		final LocalTime startTime = timePeriodA.getStartTime().plusHours(1);
		final LocalTime endTime = timePeriodA.getEndTime().plusHours(1);
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
	}
	
	@Test
	public void startABeforeStartBEndAAfterEndB() {
		
		final LocalTime startTime = timePeriodA.getStartTime().plusHours(1);
		final LocalTime endTime = timePeriodA.getEndTime().minusHours(1);
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
	}
	
	@Test
	public void startAAfterStartBEndABeforendB() {
		
		final LocalTime startTime = timePeriodA.getStartTime().minusHours(1);
		final LocalTime endTime = timePeriodA.getEndTime().plusHours(1);
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
	}
	
	@Test
	public void startAAfterStartBEndAAfterendB() {
		
		final LocalTime startTime = timePeriodA.getStartTime().minusHours(1);
		final LocalTime endTime = timePeriodA.getEndTime().minusHours(1);
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
	}
	
	@Test
	public void startAEqualEndBEndAAfterStartB() {
		
		final LocalTime startTime = timePeriodA.getEndTime().minusHours(1);
		final LocalTime endTime = timePeriodA.getStartTime();
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertFalse(timePeriodA.overlapsWith(timePeriodB));
	}
	
	@Test
	public void startAEqualEndBEndABeforeStartB() {
		
		final LocalTime startTime = timePeriodA.getEndTime().plusHours(1);
		final LocalTime endTime = timePeriodA.getStartTime();
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertFalse(timePeriodA.overlapsWith(timePeriodB));
	}
	
	@Test
	public void startABeforeEndBEndAEqualStartB() {
		
		final LocalTime startTime = timePeriodA.getEndTime();
		final LocalTime endTime = timePeriodA.getStartTime().plusHours(1);
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertFalse(timePeriodA.overlapsWith(timePeriodB));
	}
	
	@Test
	public void startAAfterEndBEndAEqualStartB() {
		
		final LocalTime startTime = timePeriodA.getEndTime();
		final LocalTime endTime = timePeriodA.getStartTime().minusHours(1);
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertFalse(timePeriodA.overlapsWith(timePeriodB));
	}
	
	@Test
	public void startAAfterEndBEndAAfterStartB() {
		
		final LocalTime startTime = timePeriodA.getEndTime().minusHours(1);
		final LocalTime endTime = timePeriodA.getStartTime().minusHours(1);
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertFalse(timePeriodA.overlapsWith(timePeriodB));
	}
	
	@Test
	public void startAAfterEndBEndABeforeStartB() {
		
		final LocalTime startTime = timePeriodA.getEndTime().plusHours(1);
		final LocalTime endTime = timePeriodA.getStartTime().minusHours(1);
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertFalse(timePeriodA.overlapsWith(timePeriodB));
	}
	
	@Test
	public void startABeforeEndBEndAAfterStartB() {
		
		final LocalTime startTime = timePeriodA.getEndTime().minusHours(1);
		final LocalTime endTime = timePeriodA.getStartTime().plusHours(1);
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
	}
	
	@Test
	public void startABeforeEndBEndABeforeStartB() {
		
		final LocalTime startTime = timePeriodA.getEndTime().plusHours(1);
		final LocalTime endTime = timePeriodA.getStartTime().plusHours(1);
		
		TimePeriod timePeriodB = new TimePeriod(startTime, endTime);
		
		Assert.assertFalse(timePeriodA.overlapsWith(timePeriodB));
	}
}
