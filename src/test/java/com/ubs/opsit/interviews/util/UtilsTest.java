package com.ubs.opsit.interviews.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilsTest {
	
	@Test
	public void testIsValidTime() {
		assertEquals(Boolean.TRUE, Utils.isValidTime("23:59:59"));
	}
	
	@Test
	public void testIsValidTimeBoundryLine() {
		assertEquals(Boolean.TRUE, Utils.isValidTime("24:00:00"));
	}
	
	@Test
	public void testIsValidTimeAboveBoundryLineMinute() {
		assertEquals(Boolean.FALSE, Utils.isValidTime("24:01:00"));
	}
	
	@Test
	public void testIsValidTimeAboveBoundryLineSecond() {
		assertEquals(Boolean.FALSE, Utils.isValidTime("24:00:01"));
	}
	
	@Test
	public void testIsValidTimeEmptyTime() {
		assertEquals(Boolean.FALSE, Utils.isValidTime(""));
	}
	
	@Test
	public void testIsValidTimeBlankTime() {
		assertEquals(Boolean.FALSE, Utils.isValidTime("  "));
	}
	
	@Test
	public void testIsValidTimeNullTime() {
		assertEquals(Boolean.FALSE, Utils.isValidTime(null));
	}
	
	@Test
	public void testIsValidTimeInvalidStringTime() {
		assertEquals(Boolean.FALSE, Utils.isValidTime("ABCD"));
	}
	
	@Test
	public void testIsValidTimeIncompleteTime() {
		assertEquals(Boolean.FALSE, Utils.isValidTime("12:30"));
	}
	
	@Test
	public void testIsValidTimeNumberFormatErrorHour() {
		assertEquals(Boolean.FALSE, Utils.isValidTime("AA:30:55"));
	}
	
	@Test
	public void testIsValidTimeNumberFormatErrorMinute() {
		assertEquals(Boolean.FALSE, Utils.isValidTime("11:BB:55"));
	}
	
	@Test
	public void testIsValidTimeNumberFormatErrorSecond() {
		assertEquals(Boolean.FALSE, Utils.isValidTime("23:30:CC"));
	}
	
	@Test
	public void testIsValidTimeNegativeHour() {
		assertEquals(Boolean.FALSE, Utils.isValidTime("-1:00:00"));
	}
	
	@Test
	public void testIsValidTimeNegativeMinute() {
		assertEquals(Boolean.FALSE, Utils.isValidTime("00:-1:00"));
	}
	
	@Test
	public void testIsValidTimeNegativeSecond() {
		assertEquals(Boolean.FALSE, Utils.isValidTime("00:00:-1"));
	}
	
	@Test
	public void testIsValidTimeOutOfRangeHour() {
		assertEquals(Boolean.FALSE, Utils.isValidTime("25:00:00"));
	}
	
	@Test
	public void testIsValidTimeOutOfRangeMinute() {
		assertEquals(Boolean.FALSE, Utils.isValidTime("00:83:00"));
	}
	
	@Test
	public void testIsValidTimeOutOfRangeSecond() {
		assertEquals(Boolean.FALSE, Utils.isValidTime("00:00:60"));
	}	

}
