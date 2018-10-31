package com.testinfra.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * This class contains few utilities created for date time format
 * @author ayush
 */
public class DateUtils {

	/**
	 * Convert local given time to UTC/GMT time stamp
	 * @param date
	 * @return
	 */
	public static Date convertDateLocalToUTC(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date gmt = new Date(sdf.format(date));
		return gmt;
	}

	/**
	 * This method returns time stamp from given string
	 * based on format and locale
	 *
	 * @param time stamp e.g. 2018-10-30 13:46:12
	 * @param time format e.g. yyyy-MM-dd HH:mm:ss this should be consistent with time stamp
	 * @param locale e.g. Australia/Sydney
	 * @return Date object
	 */
	public static Date convertStringToDate(String timestamp,
			String format, String locale){
		TimeZone tz = TimeZone.getTimeZone(locale);
		TimeZone.setDefault(tz);
		Calendar cal = Calendar.getInstance(tz);
		DateFormat df = new SimpleDateFormat(format);
		try{
			Date date = df.parse(timestamp);
			cal.setTime(date);
		}catch(Exception e){
			e.printStackTrace();
		}
		return cal.getTime();
	}

	/**
	 * This method returns a UTC date object from an string
	 * based on give format and locale
	 *
	 * @param time stamp e.g. 2018-10-30 13:46:12
	 * @param time format e.g. yyyy-MM-dd HH:mm:ss this should be consistent with time stamp
	 * @param locale e.g. Australia/Sydney
	 * @return Date object
	 */
	public static Date convertDateStringToUTC(String timestamp,
			String format, String locale){
		Date utcTimeStamp =convertDateLocalToUTC(
				convertStringToDate(timestamp, format, locale));
		return utcTimeStamp;
	}

	/**
	 * Returns current time stamp
	 */
	public static Date getCurrentTimeStamp(){
		Instant nowUTC = Instant.now();
		ZoneId zoneId = ZoneId.of("Australia/Sydney");
		ZonedDateTime now = ZonedDateTime.ofInstant(nowUTC, zoneId);
		return Date.from(now.toInstant());
	}
}
