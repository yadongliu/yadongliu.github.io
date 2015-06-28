class SortingArrays {
	public static void main(String[] args) {
		int[] testDataOrig = {4, 8, 1, 9, 10, 5, 6, 7, 20};
		int[] testData = testDataOrig.clone();

		System.out.println(SortingArrays.toString(testData));

		long startTime = System.nanoTime();
		SortingArrays.insertionSort( testData );
		long estimatedTime = System.nanoTime() - startTime;
		
		System.out.println("Sorting took: " + estimatedTime/1000 + "ms");
		System.out.println(SortingArrays.toString(testData));
	}

	// The algorithm works by selecting the smallest unsorted item 
	// and then swapping it with the item in the next position to be filled. 
	public static void selectionSort(int[] data) {
		int n = data.length;

		// loop through array and place the smallest at the front
		for(int i=0; i<n; i++) {
			int currentMinIndex = i;
			for(int j=i; j<n; j++) {
				if(data[j] < data[currentMinIndex]) {
					currentMinIndex = j;
				}
			}
			int temp = data[i];
			data[i] = data[currentMinIndex];
			data[currentMinIndex] = temp;
		}
	}

	// Take unsort entries one at a time and then 
	// insert each of them into a sorted part (initially empty): 
	public static void insertionSort(int[] data) {
		if( data.length <= 1) 
			return;

		for (int i=1; i < data.length; i++)
		{
		    int currentPick = data[i]; 
		    int j = i;
		    while (j > 0 && data[j-1] > currentPick)
		    {
		        data[j] = data[j-1];
		        j--;
		    }
		    data[j] = currentPick;
		}
	}


    /** Divide the array into two (or more) subarrays
    Sort each subarray (Conquer)
    Merge them into one (in a smart way!) 
    */
	public static void mergeSort(int[] data) {

	}

	// Helper method
	public static String toString(int[] data) {
		String result = "";
		int n = data.length;
		for(int i=0; i<n; i++) {
			result = result + data[i] + ", ";
		}
		return result;
	}

	public static String toString(Integer[] data) {
		String result = "";
		int n = data.length;
		for(int i=0; i<n; i++) {
			result = result + data[i] + ", ";
		}
		return result;
	}



}