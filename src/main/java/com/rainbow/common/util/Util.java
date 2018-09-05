package com.rainbow.common.util;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Ray
 *
 */
public class Util {

	public static String getShortDateString(Date date) {

		return new SimpleDateFormat("MM/dd/yyyy").format(date);
	}

	public static String getFullDateString(Date date) {

		return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(date);
	}

	public static Integer parseInt(String val) {

		try {
			return Integer.valueOf(val);
		} catch (Exception e) {
			return null;
		}

	}

	public static String checkNullStr(String val) {
		if (val != null) {
			String afterDecode = val.replaceAll("'", "''");
			return "'" + afterDecode + "'";
		} else {
			return null;
		}
	}

	/**
	 * @param String
	 *            val
	 * @return if val is not null and not blank return true.
	 */
	public static Boolean checkBlankStr(String val) {
		if (val != null && !val.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public static Timestamp addBusinessDay(int days) {
		Calendar c = Calendar.getInstance();
		int addDays = 0;
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == Calendar.WEDNESDAY || dayOfWeek == Calendar.THURSDAY || dayOfWeek == Calendar.FRIDAY) {
			addDays = 2;
		} else if (dayOfWeek == Calendar.SATURDAY) {
			addDays = 1;
		}

		addDays += days;
		c.add(Calendar.DAY_OF_MONTH, addDays);

		return new Timestamp(c.getTime().getTime());
	}

	public static String checkNullShortDate(Date date) {
		return date != null ? ("TO_DATE('" + Util.getShortDateString(date) + "', 'MM/DD/YYYY')") : null;
	}

	public static String checkNullShortDate(String dateStr) {
		return dateStr != null ? ("TO_DATE('" + dateStr + "', 'MM/DD/YYYY')") : null;
	}

	public static String checkNullFullDate(Date date) {
		return date != null ? ("TO_DATE('" + Util.getFullDateString(date) + "', 'MM/DD/YYYY HH24:MI:SS')") : null;
	}

	public static final String REMOVE_STR = "'1, ,!,@,#,$,^,&,*,(,),_,-,+,=,{,[,},],\\,/,<,>,.,:,;','1'";

	public static String displayTotalNum(Object o) {

		DecimalFormat normNumNew = new DecimalFormat("###,###,###,##0.0");

		if (o == null) {
			return "";
		} else if ((o instanceof Float)) {
			float f = Float.parseFloat(o.toString());
			f = f / 1000;
			return (normNumNew.format(f) + 'k');
		} else if (o instanceof Double) {
			double d = Double.parseDouble(o.toString());
			d = d / 1000;
			return (normNumNew.format(d) + 'k');
		}
		return "";
	}

	public static String strJoin(String... tokens) {
		StringBuilder sb = new StringBuilder();
		for (String token : tokens) {
			sb.append(token);
		}
		return sb.toString();
	}

	public static String getJsonStr(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = "";
		try {
			if (object != null) {
				jsonStr = mapper.writeValueAsString(object);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonStr;
	}

	public static void main(String[] args) {

	}

}
