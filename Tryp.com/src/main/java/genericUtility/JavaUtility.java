package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int randomNum() {
		Random r = new Random();
		int num = r.nextInt(1, 1000);
		return num;
	}

	public String currectDate() {
		Date d = new Date();// returns current date and time
		SimpleDateFormat simdate = new SimpleDateFormat("YYYY-MM-DD");// to get date only
		return simdate.format(d);
	}

	public String EndDate() {

		Date d = new Date();// returns current date and time
		SimpleDateFormat simdate = new SimpleDateFormat("YYYY-MM-DD");// to get date only
		simdate.format(d);
		Calendar cal = simdate.getCalendar();
		// calender.getInstance
		cal.add(Calendar.DAY_OF_MONTH, 30);// getting too old date
		return simdate.format(cal.getTime());

	}
	
	public String time()
	{
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		return time;
	}

}
