package com.intelliworx.inf;

import com.intelliworx.inf.exception.PersistenceException;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class PersistenceDates {
	  /**
	   * Log for use by this class.
	   */
	  private static Logger log = Logger.getLogger(PersistenceDates.class);

	  /**
	   * Default locale for use below (it should never changes).
	   */
	  protected static Locale defaultLocale = Locale.getDefault();

	  /**
	   * Default time zone for use below (it should never changes).
	   */
	  protected static TimeZone defaultTimeZone = TimeZone.getDefault();

	  /**
	   * Returns the database date/time string for the given date in the default locale.
	   * @param date the date to convert to database format.
	   * @return ccyy-mm-dd hh:mm:ss which is the local date/time.
	   */
	  public static String databaseDate(Date date)
	  {
	    return databaseDate(date, defaultTimeZone, defaultLocale);
	  }

	  /**
	   * Returns the database date/time string for the given date.
	   * @param date the date to convert to database format.
	   * @param locale the locale.
	   * @return date string  yyyy-MM-dd hh:mm:ss which is the local date/time
	   */
	  public static String databaseDate(Date date, TimeZone timeZone, Locale locale)
	  {
	    if (date == null)
	    {
	      return null;
	    }
	    if (log.isDebugEnabled())
	    {
	      log.debug("date = "+date);
	    }
	    Calendar calendar = Calendar.getInstance(timeZone, locale);
	    calendar.setTime(date);
	    SimpleDateFormat format = new SimpleDateFormat();
	    format.applyPattern("yyyy-MM-dd HH:mm:ss");
	    String dateTime = format.format(date);
	    return dateTime;
	  }

//	  public static String databaseDateOnly(Date date)
//	  {
//	    return databaseDateOnly(new DateOnly(date.getTime()));
//	  }

	  /**
	   * Returns the database date string for the given date in the default locale.
	   * @param dateOnly the date (no time) to convert to database format.
	   * @return the ccyymmdd date to store in the database.
	   */
//	  public static String databaseDateOnly(DateOnly dateOnly)
//	  {
//	    if (dateOnly == null)
//	    {
//	      return null;
//	    }
//	    SimpleDateFormat format = new SimpleDateFormat();
//	    format.applyPattern("yyyyMMdd");
//	    String date = format.format(dateOnly);
//	    return date;
//	  }

	  /**
	   * Returns the database date/time string for the given date.
	   * @param date the date to convert to database format.
	   * @return the ccyymmddhhmmss00+hhmm which is the local date/time plus the offset from GMT.
	   */
//	  public static String databaseTimeOnly(TimeOnly date)
//	  {
//	    if (date == null)
//	    {
//	      return null;
//	    }
//	    if (log.isDebugEnabled())
//	    {
//	      log.debug("date = "+date);
//	    }
//	    SimpleDateFormat format = new SimpleDateFormat();
//	    format.applyPattern("HHmmss");
//	    String dateTime = format.format(date) + "00";
//	    return dateTime;
//	  }

	  /**
	   * Returns the database date string for the given date
	   * @param date the date to convert to database format.
	   * @return the ccyymmdd date to store in the database.
	   */
//	  public static String databaseTimeOnly(Date date)
//	  {
//	    return databaseTimeOnly(new TimeOnly(date.getTime()));
//	  }

	  /**
	   * Returns the database date/time string for the given date.
	   * @param date the date to convert to database format.
	   * @return the ccyymmddhhmmss00+hhmm which is the local date/time plus the offset from GMT.
	   */
//	  public static String databaseTimeHHMMOnly(TimeHHMMOnly date)
//	  {
//	    if (date == null)
//	    {
//	      return null;
//	    }
//	    if (log.isDebugEnabled())
//	    {
//	      log.debug("date = "+date);
//	    }
//	    SimpleDateFormat format = new SimpleDateFormat();
//	    format.applyPattern("HHmm");
//	    String dateTime = format.format(date);
//	    return dateTime;
//	  }

	  /**
	   * Returns the date in the same format as returned by calling the <code>toString()</code> method
	   * on a <code>java.sql.Timestamp</code>.
	   * @param date The date to convert
	   * @return The date in the same format as <code>java.sql.Timestamp.toString()</code>
	   * @see java.sql.Timestamp#toString()
	   */
	  public static String javaSqlTimestampString(Date date)
	  {
	    if (date == null)
	    {
	      return null;
	    }
	    return new java.sql.Timestamp(date.getTime()).toString();
	  }

	    /**
	   * Returns the date in UK (UTC) format as returned by calling the <code>toString()</code> method
	   * on a <code>java.sql.Timestamp</code>.
	   *
	   * @param date The date to convert
	   * @return The date in the same format as <code>java.sql.Timestamp.toString()</code>
	   * @see java.sql.Timestamp#toString()
	   */
	  public static String javaUTCSqlTimestampString(Date date)
	  {
	    if (date == null)
	    {
	      return null;
	    }

	    Date utcDate;
	    try
	    {
	      utcDate = date(databaseDate(date), TimeZone.getTimeZone("GMT"), Locale.UK, false);
	    }
	    catch (PersistenceException e)
	    {
	      utcDate = date;
	    }
	    return new java.sql.Timestamp(utcDate.getTime()).toString();
	  }

	  /**
	   * Returns the date in the same format as returned by calling the <code>toString()</code> method
	   * on a <code>java.sql.Date</code>.
	   * @param date The date to convert
	   * @return The date in the same format as <code>java.sql.Date.toString()</code>
	   * @see java.sql.Date#toString()
	   */
	  public static String javaSqlDateString(Date date)
	  {
	    if (date == null)
	    {
	      return null;
	    }
	    return new java.sql.Date(date.getTime()).toString();
	  }

	  /**
	   * Returns the date in the same format as returned by calling the <code>toString()</code> method
	   * on a <code>java.sql.Time</code>.
	   * @param date The date to convert
	   * @return The date in the same format as <code>java.sql.Time.toString()</code>
	   * @see java.sql.Time#toString()
	   */
	  public static String javaSqlTimeString(Date date)
	  {
	    if (date == null)
	    {
	      return null;
	    }
	    return new java.sql.Time(date.getTime()).toString();
	  }

	  /**
	   * Returns the date for the given database date string using the default locale.
	   * @param databaseDate yyyy-MM-dd hh:mm:ss which is the local date/time plus the offset from GMT.
	   * @return the date with the time adjusted to local time.
	   * @throws PersistenceException on error.
	   */
	  public static Date date(String databaseDate) throws PersistenceException
	  {
	    return date(databaseDate, defaultTimeZone, defaultLocale, false);
	  }

	  /**
	   * Returns the date for the given database date string ignoring the offset
	   *
	   * @param databaseDate yyyy-MM-dd hh:mm:ss which is the local date/time plus the offset from GMT.
	   * @return the date with the time adjusted to local time.
	   * @throws PersistenceException on error.
	   */
	  public static Date localDate(String databaseDate) throws PersistenceException
	  {
	    return date(databaseDate, defaultTimeZone, defaultLocale, true);
	  }


	  /**
	   * Returns the date for the given database date string.
	   * @param databaseDate yyyy-MM-dd hh:mm:ss which is the local date/time plus the offset from GMT.
	   * @param timeZone the time zone
	   * @param locale the locale.
	   * @param ignoreOffset indicates if the GMT offset should be ignored or not
	   * @return the date with the time adjusted to local time.
	   * @throws PersistenceException on error.
	   */
	  public static Date date(String databaseDate,
	                          TimeZone timeZone,
	                          Locale locale,
	                          boolean ignoreOffset) throws PersistenceException
	  {

	    if (databaseDate == null ||
	        databaseDate.trim().equals(""))
	    {
	      return null;
	    }

	    databaseDate = databaseDate.trim();
	    SimpleDateFormat format = new SimpleDateFormat();

	    /*
	     * If a 20060807 type dates passed in
	     */
	    if (databaseDate.length() == 8)
	    {
	      format.applyPattern("yyyyMMdd");
	    }
	    else
	    {
	      format.applyPattern("yyyy-MM-dd HH:mm:ss");
	    }

	    try
	    {
	      Date dbDate = format.parse(databaseDate);

	      return dbDate;
	    }
	    catch (ParseException pe)
	    {
	      throw new PersistenceException("Error parsing date: "+ databaseDate, pe);
	    }
	  }

	  /**
	   * Convert a string in JDBC timestamp escape format to a timestamp value as used by XML3
	   * @param s timestamp in format "yyyy-mm-dd hh:mm:ss.ffffffff"
	   * @return corresponding timestamp
	  **/
//	  public static Date xml3Date(String s)
//	  {
//	    if (s == null)
//	    {
//	      throw new PersistenceException("Error parsing date: "+s);
//	    }
//
//	    s = s.trim();
//	    int divide = s.indexOf(' ');
//	    if (divide < 0)
//	    {
//	      throw new PersistenceException("Error parsing date: "+s);
//	    }
//
//	    String dateString = s.substring(0,divide);
//
//	    int firstDash = dateString.indexOf('-');
//	    int secondDash = dateString.indexOf('-',firstDash+1);
//	    if ((firstDash <= 0) || (secondDash <= 0) || (secondDash >= dateString.length()-1))
//	    {
//	      throw new PersistenceException("Error parsing date: "+s);
//	    }
//
//	    int year = Integer.parseInt(dateString.substring(0,firstDash));
//	    int month = Integer.parseInt(dateString.substring(firstDash+1,secondDash))-1;
//	    int day = Integer.parseInt(dateString.substring(secondDash+1,secondDash+3));
//
//	    String timeString = s.substring(divide+1);
//	    divide = timeString.indexOf('.');
//	    if (divide >= 0)
//	    {
//	      // check that nanoseconds value is a number, but don't use it
//	      Integer.parseInt(timeString.substring(divide+1));
//	      timeString = timeString.substring(0,divide);
//	    }
//
//	    int firstColon = timeString.indexOf(':');
//	    int secondColon = timeString.indexOf(':',firstColon+1);
//	    if ((firstColon <= 0) || (secondColon <= 0) || (secondColon >= timeString.length()-1))
//	    {
//	      throw new PersistenceException("Error parsing date: "+s);
//	    }
//
//	    int hour = Integer.parseInt(timeString.substring(0,firstColon));
//	    int minute = Integer.parseInt(timeString.substring(firstColon+1,secondColon));
//	    int second = Integer.parseInt(timeString.substring(secondColon+1));
//
//	    Calendar local = Calendar.getInstance(defaultTimeZone, defaultLocale);
//	    local.set(year, month, day, hour, minute, second);
//
//	    return local.getTime();
//	  }

	  /**
	   * Returns the date (no time) for the given database date string.
	   * @param databaseDateOnly ccyymmdd from the database.
	   * @return the DateOnly ie a Date with no time.
	   * @throws PersistenceException on a parse error.
	   * @see com.pcmsgroup.v21.star.framework.common.util.DateOnly
	   */
//	  public static DateOnly dateOnly(String databaseDateOnly) throws PersistenceException
//	  {
//	    if (databaseDateOnly == null)
//	    {
//	      return null;
//	    }
//	    try
//	    {
//	      SimpleDateFormat format = new SimpleDateFormat();
//	      format.applyPattern("yyyyMMdd");
//	      DateOnly date = new DateOnly(format.parse(databaseDateOnly).getTime());
//	      return date;
//	    }
//	    catch (ParseException pe)
//	    {
//	      throw new PersistenceException("Error parsing date: "+databaseDateOnly, pe);
//	    }
//	  }

	  /**
	   * Turn a java.util.Date into a DateOnly
	   *
	   * @param date Date
	   * @return DateOnly
	   */
//	  public static DateOnly dateOnly(Date date)
//	  {
//	    if (date==null)
//	    {
//	      return null;
//	    }
//	    return new DateOnly(date.getTime());
//	  }

	  /**
	   * Returns the time (no date) for the given database date string.
	   * @param databaseTime HHmmssSS from the database.
	   * @return the DateOnly ie a Date with no time.
	   * @throws PersistenceException on a parse error.
	   * @see com.pcmsgroup.v21.star.framework.common.util.DateOnly
	   */
//	  public static TimeOnly timeOnly(String databaseTime) throws PersistenceException
//	  {
//	    if (databaseTime == null)
//	    {
//	      return null;
//	    }
//	    try
//	    {
//	      SimpleDateFormat format = new SimpleDateFormat();
//	      format.applyPattern("HHmmssSS");
//	      TimeOnly time = new TimeOnly(format.parse(databaseTime).getTime());
//	      return time;
//	    }
//	    catch (ParseException pe)
//	    {
//	      throw new PersistenceException("Error parsing time: "+databaseTime, pe);
//	    }
//	  }

	  /**
	   * Returns the time (no date) for the given database date string.
	   * @param databaseTime HHmmssSS from the database.
	   * @return the DateOnly ie a Date with no time.
	   * @throws PersistenceException on parse error.
	   * @see com.pcmsgroup.v21.star.framework.common.util.DateOnly
	   */
//	  public static TimeHHMMOnly timeHHMMOnly(String databaseTime) throws PersistenceException
//	  {
//	    if (databaseTime == null)
//	    {
//	      return null;
//	    }
//	    SimpleDateFormat format = new SimpleDateFormat();
//	    format.applyPattern("HHmm");
//	    TimeHHMMOnly time = null;
//	    try
//	    {
//	      time = new TimeHHMMOnly(format.parse(databaseTime.substring(0,4)).getTime());
//	    }
//	    catch (ParseException pe)
//	    {
//	      format.applyPattern("HH:mm");
//	      try
//	      {
//	        time = new TimeHHMMOnly(format.parse(databaseTime).getTime());
//	      }
//	      catch (ParseException pe2)
//	      {
//	        throw new PersistenceException("Error parsing time: "+databaseTime, pe2);
//	      }
//	    }
//	    return time;
//	  }

//	  public static java.sql.Date getCombinedDate(java.sql.Date date, java.sql.Date time) throws PersistenceException
//	  {
//	    if (time!=null)
//	    {
//	      String dateString = PersistenceDates.databaseDateOnly(date);
//	      String timeString = PersistenceDates.databaseTimeOnly(time);
//	      return new java.sql.Date(PersistenceDates.date(dateString + timeString).getTime());
//	    }
//	    else
//	    {
//	      return date;
//	    }
//	  }
//	}
}
