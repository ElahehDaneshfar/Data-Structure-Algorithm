package algo.mergesort;

public class MergeSort {
	
	public static void sort(int inputArray[]){
		sort(inputArray, 0, inputArray.length-1);
	}
	
	public static void sort(int inputArray[], int start, int end){
		if(end <= start){
			return; // we're done traversing the array
		}
		
		int mid = (start + end)/2;
		sort(inputArray, start, mid); // sort left half
		sort(inputArray, mid+1, end); // sort right half
		merge(inputArray, start, mid, end); // merge sorted results into the inputArray
	}
	
	public static void merge(int inputArray[], int start, int mid, int end){
		int tempArray[] = new int [end - start +1 ];
		
		// index counter for the left side of the array
		int leftSlot = start;
		// index counter for the right side of the array
		int rightSlot = mid+1;
		int k = 0;
		
		while(leftSlot <= mid && rightSlot <= end){
			if(inputArray[leftSlot] < inputArray[rightSlot]){
				tempArray[k] = inputArray[leftSlot];
				leftSlot = leftSlot + 1;
			} else{
				tempArray[k] = inputArray[rightSlot];
				rightSlot = rightSlot + 1;
			}
			k = k+1;
		}
		
		/**
		 * When it get's to here, that means the above loop has completed.
		 * So both the right and the left side of the sub-array can be considered sorted
		 */
		
		if(leftSlot <= mid){ // consider the right side done being sorted. Left must be sorted already
			while(leftSlot <= mid){
				tempArray[k] = inputArray[leftSlot];
				leftSlot = leftSlot + 1;
				k = k+1;
			}
		} else if ( rightSlot <= end){
			while(rightSlot <= end){
				tempArray[k] = inputArray[rightSlot];
				rightSlot = rightSlot+1;
				k = k+1;
			}
		}
		
		// copy over the tmep array into the appropriate slots of the inputArray
		for(int i = 0; i < tempArray.length; i++){
			inputArray[start+i] = tempArray[i];
		}
		
	}






		// >>>>>>>---------BELOW IS The other way to coding Merge Sort------------<<<<<<
	

	private static int tempArray[]; // an array used for merging
	// To use the mergeInPlace() method, you'll need to initialize tempArray as 
	// shown on the next line inside of the wrapper sort() method.
	// tempArray = new int [inputArray.length]; 
	
	public static void mergeInPlace(int inputArray[], int start, int mid, int end){
		int i = start; // save starting index into temporary variable
		int j = mid+1;
		
		for(int k = 0; k <= end; k++) {
			tempArray[k] = inputArray[k];
		}
		
		for(int k = start; k <= end; k++){
			if(i > mid){
				inputArray[k] = tempArray[j];
				j = j+1;
			} else if(j > end) {
				inputArray[k] = tempArray[i];
				i = i+1;
			} else if(tempArray[j] < tempArray[i]){
				inputArray[k] = tempArray[j];
				j = j+1;
			} else{
				inputArray[k] = tempArray[i];
				i = i+1;
			}
		}
	}
	
	
}
