package cn.tianya.util;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	public static final String TIME_FORMAT = "HH:mm:ss:SS";
	public static final String DEFAULT_SHORT_DATE_FORMAT = "yyyy-MM-dd";
	public static final String DEFAULT_SHORT_DATE_FORMAT_ZH = "yyyy年M月d日";
	public static final String DEFAULT_LONG_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss:SS";
	public static final String JAVA_MIN_SHORT_DATE_STR = "1970-01-01";
	public static final String JAVA_MIN_LONG_DATE_STR = "1970-01-01 00:00:00:00";
	public static final Timestamp JAVA_MIN_TIMESTAMP = convertStrToTimestamp("1970-01-01 00:00:00:00");
	public static final String DEFAULT_PERIOD_FORMAT = "{0}天{1}小时{2}分钟";
	public static final String JAVA_MAX_SHORT_DATE_STR = "9999-12-31";

	public static Date addDate(String datepart, int number, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if (datepart.equals("yy")) {
			cal.add(1, number);
		} else if (datepart.equals("MM")) {
			cal.add(2, number);
		} else if (datepart.equals("dd")) {
			cal.add(5, number);
		} else {
			throw new IllegalArgumentException("DateUtil.addDate()方法非法参数值：" + datepart);
		}
		return cal.getTime();
	}

	public static boolean compareTime(String time1) {
		return compareTime(time1, getCurrDateStr(), "yyyy-MM-dd HH:mm:ss");
	}

	public static boolean compareTime(String time1, String time2) {
		return compareTime(time1, time2, "yyyy-MM-dd HH:mm:ss");
	}

	public static boolean compareTime(String time1, String time2, String dateFormat) {
		SimpleDateFormat t1 = new SimpleDateFormat(dateFormat);
		SimpleDateFormat t2 = new SimpleDateFormat(dateFormat);
		try {
			Date d1 = t1.parse(time1);
			Date d2 = t2.parse(time2);
			return d1.before(d2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String convertDateToStr(Date date, String dateFormat) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}

	public static Date convertStrToDate(String dateStr, String dateFormat) {
		if ((dateStr == null) || (dateStr.equals(""))) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			return sdf.parse(dateStr);
		} catch (Exception e) {
			throw new RuntimeException("DateUtil.convertStrToDate():" + e.getMessage());
		}
	}

	public static Date convertStrToDate(String dateStr, String dateFormat, Locale locale) {
		if ((dateStr == null) || (dateStr.equals(""))) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, locale);
		try {
			return sdf.parse(dateStr);
		} catch (Exception e) {
			throw new RuntimeException("DateUtil.convertStrToDate():" + e.getMessage());
		}
	}

	public static Timestamp convertStrToTimestamp(String dateStr) {
		return convertStrToTimestamp(dateStr, false);
	}

	private static Timestamp convertStrToTimestamp(String dateStr, boolean addZeroTime) {
		if (dateStr == null) {
			return null;
		}
		String dStr = dateStr.trim();
		if (dStr.indexOf(" ") == -1) {
			if (addZeroTime) {
				dStr = dStr + " 00:00:00:00";
			} else {
				dStr = dStr + " " + getCurrDateStr("HH:mm:ss:SS");
			}
		}
		Date utilDate = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		try {
			utilDate = simpleDateFormat.parse(dStr);
		} catch (Exception ex) {
			throw new RuntimeException("DateUtil.convertStrToTimestamp(): " + ex.getMessage());
		}
		return new Timestamp(utilDate.getTime());
	}

	public static Timestamp convertStrToTimestampZero(String dateStr) {
		return convertStrToTimestamp(dateStr, true);
	}

	public static String convertToPeriod(long period) {
		long dayUnit = 86400L;
		long hourUnit = 3600L;
		long minUnit = 60L;
		String result = MessageFormat.format(
				"{0}天{1}小时{2}分钟",
				new Object[] { Long.valueOf(period / dayUnit), Long.valueOf(period % dayUnit / hourUnit),
						Long.valueOf(period % hourUnit / minUnit) });
		return result;
	}

	public static double dateDiff(String datepart, Date startdate, Date enddate) {
		if ((datepart == null) || (datepart.equals(""))) {
			throw new IllegalArgumentException("DateUtil.dateDiff()方法非法参数值：" + datepart);
		}
		double days = (enddate.getTime() - startdate.getTime()) / 8.64E7D;
		if (datepart.equals("yy")) {
			days /= 365.0D;
		} else if (datepart.equals("MM")) {
			days /= 30.0D;
		} else {
			if (datepart.equals("dd")) {
				return days;
			}
			throw new IllegalArgumentException("DateUtil.dateDiff()方法非法参数值：" + datepart);
		}
		return days;
	}

	public static String getCurrDateStr() {
		return getCurrDateStr("yyyy-MM-dd HH:mm:ss");
	}

	public static String getCurrDateStr(String dateFormat) {
		return convertDateToStr(new Date(), dateFormat);
	}

	public static Timestamp getCurrTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static String toBeginDate(String fieldValue) {
		if ((fieldValue == null) || ("".equals(fieldValue))) {
			return "";
		}
		String result = "";
		fieldValue = fieldValue + " 00:00:00";
		result = fieldValue;
		return result;
	}

	public static String toEndDate(String fieldValue) {
		if ((fieldValue == null) || ("".equals(fieldValue))) {
			return "";
		}
		String result = "";
		fieldValue = fieldValue + " 23:59:59";
		result = fieldValue;
		return result;
	}

	public static String getStandardDatetimeStr(String timestampStr) {
		if ((timestampStr == null) || ("".equals(timestampStr.trim()))) {
			return "";
		}
		String result = "";
		try {
			Timestamp timestamp = Timestamp.valueOf(timestampStr);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			result = sdf.format(timestamp);
		} catch (Exception e) {
			throw new RuntimeException("DateUtil.getStandardDatetimeStr()失败:" + e.getMessage());
		}
		return result;
	}

	public static long getTimeMillis(String dateStr) {
		return convertStrToDate(dateStr, "yyyy-MM-dd HH:mm:ss").getTime();
	}
}
