import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BackPackTest{

	@Before
	public void setUp(){
	}

	@After
	public void tearDown(){
	}

	@Test
	public void testBackPack_Solution1(){
		int m = 10;
		int n = 3;
		int w[] = {3, 4, 5};
		int p[] = {4, 5, 6};
 		int c[][] = BackPack.BackPack_Solution(m, n, w, p);
		assertEquals(11, c[n][m]);

	}

	@Test
	public void testBackPack_Solution2(){
		int m = 34;
		int n = 10;
		int w[] = {2, 8, 4, 4, 8, 7, 8, 5, 16, 16};
		int p[] = {15, 25, 9, 9, 15, 12, 12, 6, 14, 9};
		int c[][] = BackPack.BackPack_Solution(m, n, w, p);
		assertEquals(85, c[n][m]);
	}

}
