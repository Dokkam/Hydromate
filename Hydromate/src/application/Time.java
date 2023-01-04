package application;
// Time class for use in the timer. Only accounts for changes in min and sec; hr there for aesthetics. The timer counts down.
public class Time {
	private int minute;
	private int second;
	private int hour;
	
	public Time(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public Time(String currentTime) {
		String[] time = currentTime.split(":");
		hour = Integer.parseInt(time[0]);
		minute = Integer.parseInt(time[1]);
		second = Integer.parseInt(time[2]);
	}

	public String getCurrentTime() {
		return hour + ":" + minute + ":" + second;
	}
	
	public void resetTime() {
		this.minute = 30;
	}
	
	public void oneSecondPassed() {
		second--;
		if(second == -1) {
			minute--;
			second = 59;
			if(minute == -1) {
				minute = 0;
			}
		}
	}
}
