package com.ubs.opsit.interviews;

import org.apache.commons.lang.StringUtils;

import com.ubs.opsit.interviews.util.Utils;

public class BerlinClock implements TimeConverter {
	
	public static final String YELLOW = "Y";
	public static final String RED = "R";
	public static final String OFF = "O";
	

	@Override
	public String convertTime(String aTime) {
		
		String output = "Invalid time value, please input again.";
		
		if(Utils.isValidTime(aTime)) {
			
			String[] timeHands = aTime.split(":"); 
			int hours = Integer.parseInt(timeHands[0]);
			int minutes = Integer.parseInt(timeHands[1]);
			int seconds = Integer.parseInt(timeHands[2]);
			
			String[] lineArray= new String[5];
			
			lineArray[0] = ( seconds % 2 == 0) ? YELLOW : OFF;
			
			lineArray[1] = Utils.getLightString(hours/5, 4, RED);
			
			lineArray[2] = Utils.getLightString(hours%5, 4, RED);
			
			lineArray[3] = Utils.getLightString(minutes/5, 11, YELLOW, 3, RED);
			
			lineArray[4] = Utils.getLightString(minutes%5, 4, YELLOW);
			
			return StringUtils.join(lineArray, System.lineSeparator());
			
		}
		
		return output;
	}
	
	public static void main(String[] args) {
		TimeConverter tc = new BerlinClock();
		System.out.println(tc.convertTime("00:00:00"));
		System.out.println(tc.convertTime("13:17:01"));
		System.out.println(tc.convertTime("23:59:59"));
		System.out.println(tc.convertTime("24:00:00"));
	}
	
}
