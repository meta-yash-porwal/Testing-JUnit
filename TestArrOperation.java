

import static org.junit.Assert.*;
import org.junit.*;

public class TestArrOperation {
	
	ArrOperation arrOp = new ArrOperation();
	
	int[] arr1 = {1, 2, 3, 4};
	int[] arr2 = {1, 2, 3, 8, 9, 3, 2, 1};
	int[] arr3 = {7, 1, 4, 9, 7, 4, 1};
	int[] arr4 = {1, 2, 1, 4};
	int[] arr5 = {1, 4, 5, 3, 5, 4, 1};
	int[] arr6 = {1, 2, 2, 3, 4, 4};
	int[] arr7 = {1, 1, 2, 1, 1};
	int[] arr8 = {1, 1, 1, 1, 1};
	int[] arr9 = {5, 4, 9, 4, 9, 5};
	int[] arr10 = {1, 4, 1, 5};
	int[] arr11 = {1, 4, 1, 5, 5, 4, 1};
	int[] arr12 = {1, 4, 1, 5};
	int[] arr13 = {1, 1, 1, 2, 1};
	int[] arr14 = {2, 1, 1, 2, 1};
	int[] arr15 = {10,10};
		
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
		
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMaxMirror() {
			
		assertEquals(0,arrOp.maxMirror(arr1));
		assertEquals(3,arrOp.maxMirror(arr2));
		assertEquals(2,arrOp.maxMirror(arr3));
		assertEquals(3,arrOp.maxMirror(arr4));
		assertEquals(7,arrOp.maxMirror(arr5));
	}

	@Test
	public void testNumberOfClumps() {
			
		assertEquals(2,arrOp.numberOfClumps(arr6));
		assertEquals(2,arrOp.numberOfClumps(arr7));
		assertEquals(1,arrOp.numberOfClumps(arr8));
		assertEquals(0,arrOp.numberOfClumps(arr4));
		assertEquals(0,arrOp.numberOfClumps(arr5));
	}

	@Test
	public void testFixXY() {
		int [] arr9r = {9, 4, 5, 4, 5, 9};
		int [] arr10r = {1, 4, 5, 1};
		int [] arr11r = {1, 4, 5, 1, 1, 4, 5};
		int [] arr12r = {1, 4, 5, 1};
		assertArrayEquals(arr9r,arrOp.fixXY(arr9,4,5));
		assertArrayEquals(arr10r,arrOp.fixXY(arr10,4,5));
		assertArrayEquals(arr11r,arrOp.fixXY(arr11,4,5));
		assertArrayEquals(arr12r,arrOp.fixXY(arr12,4,5));
	}

	@Test
	public void testSplitArray() {
		
		assertEquals(3,arrOp.splitArray(arr13));
		assertEquals(-1,arrOp.splitArray(arr14));
		assertEquals(1,arrOp.splitArray(arr15));
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}

