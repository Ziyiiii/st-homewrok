import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assert;

public class BubbleSortTest {

	@Before
	public void setUp(){
	}

	@After
	public void tearDown(){
	}

	//3∏ˆ≤‚ ‘”√¿˝
	@Test
	public void testBackPack_Solution1(){
		int arr[] = {1, 6, 2, 2, 5};
		BubbleSort.BubbleSort(arr);
		assertArrayEquals(new int[]{1, 2, 2, 5, 6}, arr);

	}

	@Test
	public void testBackPack_Solution2(){
		int arr[] = {-2, 0, 2, 2, 1};
		BubbleSort.BubbleSort(arr);
		assertArrayEquals(new int[]{-2, 0, 1, 2, 2}, arr);
	}

	//@Test
	//public void testBackPack_Solution3(){
	//	int arr[] = {};
	//	int actual[] = BubbleSort.BubbleSort(arr);
	//	assertArrayEquals(new int[]{}, actual);
	//}


}
