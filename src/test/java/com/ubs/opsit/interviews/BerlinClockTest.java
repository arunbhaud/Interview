package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BerlinClockTest {
	
	TimeConverter test = null;
	
	@Before
	public void setUp() {
		
		test = new BerlinClock();
		
	}
	
	@Test
	public void testConvertTime() {
		
		
		String expected = "Y" + System.lineSeparator() +
				"OOOO" + System.lineSeparator() + 
				"OOOO" + System.lineSeparator() + 
				"OOOOOOOOOOO" + System.lineSeparator() + 
				"OOOO";
		
		assertEquals(expected, test.convertTime("00:00:00"));
	}
	
	@Test
	public void testConvertTime2() {
		
		
		String expected = "O" + System.lineSeparator() + 
				"RROO" + System.lineSeparator() + 
				"RRRO" + System.lineSeparator() + 
				"YYROOOOOOOO" + System.lineSeparator() + 
				"YYOO";
		
		assertEquals(expected, test.convertTime("13:17:01"));
	}
	
	@Test
	public void testConvertTimeInvalidInput() {
		
		String expected = "Invalid time value, please input again.";
		
		assertEquals(expected, test.convertTime("ABCD"));
	}
	
	@Test
	public void testConvertTimeInvalidTime() {
		
		String expected = "Invalid time value, please input again.";
		
		assertEquals(expected, test.convertTime("12:60:55"));
	}
	
	@Test
	public void testConvertTimeInvalidTimeAboveLimit() {
		
		String expected = "Invalid time value, please input again.";
		
		assertEquals(expected, test.convertTime("24:00:01"));
	}

}
