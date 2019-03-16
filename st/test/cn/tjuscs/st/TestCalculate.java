package cn.tjuscs.st;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCalculate {
	
	Calculate cal = new Calculate();

	@Test
	public void testGiven1() {
		assertEquals(true,cal.given(23));
	}
	@Test
	public void testGiven2() {
		assertEquals(true,cal.given(70));
	}
	@Test
	public void testGiven3() {
		assertEquals(true,cal.given(60));
	}
	@Test
	public void testGiven4() {
		assertEquals(true,cal.given(53));
	}
	@Test
	public void testGiven5() {
		assertEquals(true,cal.given(52));
	}
}
