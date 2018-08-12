package com.ubs.opsit.interviews.util;

import org.apache.commons.lang.StringUtils;

public final class Utils {
	
	public static final int INT_0 = 0;
	public static final int INT_24 = 24;
	public static final int INT_59 = 59;
	public static final boolean FALSE = Boolean.FALSE;
	public static final String OFF = "O";
	
	public static boolean isValidTime(String time) {
		
		int hours, minutes, seconds = 0;
		
		//Check if time is blank space or empty.
		
		if(StringUtils.isBlank(time)) {
			return FALSE;
		}
		
		String[] timeHands = time.trim().split(":");
		
		//check if the time entry is having hours, minutes and seconds.
		
		if(timeHands.length != 3) {
			return FALSE;
		}
		
		//check if you get valid integer entries for hours, minutes and seconds.
		
		try {
			hours = Integer.parseInt(timeHands[0]);
			minutes = Integer.parseInt(timeHands[1]);
			seconds = Integer.parseInt(timeHands[2]);
		}catch (NumberFormatException e) {
			return FALSE;
		}
		
		//check if hours, minutes and seconds are in their valid range.
		
		if(hours < INT_0 || hours > INT_24) return FALSE;
		if(hours == INT_24 && (minutes != INT_0 || seconds != INT_0)) return FALSE;
		if(minutes < INT_0 || minutes > INT_59) return FALSE;
		if(seconds < INT_0 || seconds > INT_59) return FALSE;
		
		return Boolean.TRUE;
	}
	
	public static String getLightString(int onLamps, int totalLamps, String color) {
		
		String lightString = StringUtils.repeat(color, onLamps);
		String paddedLightString = StringUtils.rightPad(lightString, totalLamps, OFF);		
		return paddedLightString;
	}
	
	public static String getLightString(int onLamps, int totalLamps, String color, int interval, String intervalColor) {
		
		String paddedLightString = getLightString(onLamps, totalLamps, color);
		String intervalSubString = StringUtils.repeat(color, interval);
		String replaceWithSubString = StringUtils.repeat(color, interval-1).concat(intervalColor);		
		return paddedLightString.replaceAll(intervalSubString, replaceWithSubString);
	}

}
