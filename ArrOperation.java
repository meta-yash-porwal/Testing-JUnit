
/**
 * this class is to do operation in the array
 * Assume that each method will receive an array of positive integers
 * this class has maxMirror, number of clumps, 
 * fixXY, getYIndex, splitArray. 
 * @author yash.porwal_metacube
 *
 */
public class ArrOperation {
	
	/**
	 * this method return the size of the largest mirror section
	 * E.g., maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) -> 3
	 *		 maxMirror([7, 1, 4, 9, 7, 4, 1]) -> 2
	 *		 maxMirror([1, 2, 1, 4]) -> 3
	 *		 maxMirror*([1, 4, 5, 3, 5, 4, 1]) -> 7
	 * @param arr an integer array which has number
	 * @return the integer value of the size of largest mirror section  
	 */
	public int maxMirror(int[] arr) {
	    int max = 0;
	    // for assertion error 
	    assert arr.length > 0 : "Array is empty" ;
		
	    for(int i = 0; i < arr.length; i++) {
	        int count = 0;
	        for(int j = arr.length - 1; j >= 0 && i + count < arr.length; j--) {
	            if(arr[i + count] == arr[j]) {
	                count++;
	            } else {
	                max = Math.max(max, count);
	                count = 0;
	            }
	        }
	        max = Math.max(max, count);
	    }
	    if(max == 1) {
	    	return 0;
	    }
	    else {
	    	return max;
	    }
	}
	
	/**
	 * this method is to find Clump in an array 
	 * Clump is a series of 2 or more adjacent elements of the same value.
	 * E.g., numberOfClumps([1, 2, 2, 3, 4, 4]) -> 2
	 *		 numberOfClumps([1, 1, 2, 1, 1]) -> 2
	 *		 numberOfClumps([1, 1, 1, 1, 1]) -> 1
	 * @param arr an integer array which has number
	 * @return the integer value of the size of the clump
	 */
	public int numberOfClumps(int[] arr){
		int count = 0, numberOfClumps = 0;
		// for assertion error 
		assert arr.length > 0 : "Array is empty" ;

		for(int i = 1; i < arr.length; i++){
			if(arr[i] == arr[i-1]){
				count++;
				if(count == 1) {
					numberOfClumps++;
				}
			}
			else{
				count=0;
			}
		}
		return numberOfClumps;
	}
	
	/**
	 * this method used to rearrange an integer array (input array), 
	 * so that every X is immediately followed by a Y.
	 * Value of X = 4.
	 * Value of Y = 5.
	 * E.g., fixXY([5, 4, 9, 4, 9, 5]) -> [9, 4, 5, 4, 5, 9]
	 * 		 fixXY([1, 4, 1, 5]) -> [1, 4, 5, 1]
	 * 		 fixXY([1, 4, 1, 5, 5, 4, 1]) -> [1, 4, 5, 1, 1, 4, 5]
	 * @param arr an integer array which has number
	 * @param x integer which has to be fixed while rearranging
	 * @param y integer which has to be come after X while rearranging.
	 * @return the rearranging integer array.
	 */
	public int[] fixXY(int[] arr,int x,int y) {
		int countX = 0;
		int countY = 0;
		int indexOfY = -1;
		boolean isXAfterX = false;
		
		
		// for assertion error 
		assert arr.length > 0 : "Array is empty";
		

		// for assertion error 
		assert arr[arr.length - 1] != x : "X can't be at last index";
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				countX++;
			}
			if (arr[i] == y) {
				countY++;
			}
			if (i < arr.length - 1) {
				if (arr[i] == x && arr[i + 1] == x) {
					isXAfterX = true;
				}
			}
		}
	

		// for assertion error 
		assert countX == countY : "X and Y are unequal";
		

		// for assertion error 
		assert isXAfterX == false :  "Two Adjacents X Values are there.";
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				indexOfY = getYIndex(arr, x, y);
				int tempVar = arr[indexOfY];
				arr[indexOfY] = arr[i + 1];
				arr[i + 1] = tempVar;
			}
		}
		return arr;
	}
	
	/**
	 * this method is used to get the index of Y
	 * which is used in the fixXY() in the rearranging array.
	 * @param arr integer array which has integer values.
	 * @param x value of integer X which is used in the fixXY()
	 * @param y value of integer Y which ins used in the fixXY() 
	 * @return the index value of Y integer value which can be rearranged
	 */
	public int getYIndex (int arr[], int x, int y) {
		if (arr[0] == y) {
			return 0;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == y && arr[i - 1] != x) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * it is used to split the input array,
	 * so that the sum of the numbers on one side is equal to the sum of the numbers on the other side 
	 * else return -1.  
	 * @param arr input integer array which contains numbers 
	 * @return the integer value of index or else return -1.
	 */
	public int splitArray(int arr[]) {
		// for assertion error 
		assert arr.length > 0 : "Array is empty";
		int left = 0;
		for(int i = 0; i<arr.length; i++) {
			left += arr[i];
			int right = 0;
			for(int j = i+1; j<arr.length; j++) {
				right += arr[j];
			}
			if(left == right) {
				return i+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
//		int [] arr1 = {7, 1, 4, 9, 7, 4, 1};
		int [] arr1 = {1, 2, 3, 8, 9, 3, 2, 1};
		int [] arr2 = {1, 1, 2, 1, 1};
		int [] arr3 = {5, 4, 9, 4, 9, 5};
		int [] arr4 = {10,1,1,1, 13};
		
		ArrOperation arrOp = new ArrOperation();
		
		System.out.println("The Largest mirror number-: "+ arrOp.maxMirror(arr1));
		System.out.println("The Number of clumps-: "+ arrOp.numberOfClumps(arr2));
		int[] arr5=arrOp.fixXY(arr3, 4, 5);  // X = 4, Y = 5
		System.out.println("The fixed array is : ");
		for(int value : arr5) {
			System.out.print(value+" ");
		}
		System.out.println("\nThe Array should split at : "+arrOp.splitArray(arr4));
	}
	
}
