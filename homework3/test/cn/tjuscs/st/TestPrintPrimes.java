package cn.tjuscs.st;

import org.junit.Before;
import org.junit.Test;

public class TestPrintPrimes {
	private PrintPrimes printprimes;
	@Before
	public void setup(){
		printprimes=new PrintPrimes();
	}
	
	@Test
	public void tests(){
		printprimes.printPrimes(15);
	}
	
}
