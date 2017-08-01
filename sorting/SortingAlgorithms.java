import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

class SortingAlgorithms {
	
	
	//worst case complexity O(n^2)
	public static void bubbleSort(int[] ar) {

		for (int i=ar.length;i>=0;i--) {

			for (int j=1; j<i; j++) {

				if(ar[j-1] > ar[j]) {
				int temp = ar[j-1];
				ar[j-1] = ar[j];
				ar[j] = temp;
				}
			}
			System.out.println(Arrays.toString(ar));
		}
	}


	//worst case complexity O(m^2)
	public static void selectionSort(int[] ar){

		for (int i=0;i<ar.length-1;i++){

			int min = i;

			for (int j=i+1;j <ar.length;j++){

				if(ar[j] < ar[min]) min = j;

				int temp = ar[i];
				ar[i] = ar[min];
				ar[min] = ar[temp];
			}
			System.out.println(Arrays.toString(ar));
		}
	}


	//worst case complexity O(n^2) but less swap than previous ones
	public static void insertionSort(int[] ar){

		for (int i=1;i<ar.length;i++){

			int index = i;
			for (int j=i-1;j>=0;j--){

				if(ar[j]>ar[index]){
					int temp = ar[j];
					ar[j] = ar[index];
					ar[index] = ar[temp];
					break;
				}
			}
		}

	}

	// worst case complexity is O(nlogn) dive and conquer
	public static void mergeSort(int[] ar) {
		System.out.println(Arrays.toString(ar));
		int[] tmp = new int[ar.length];
		mergeSort(ar, tmp, 0, ar.length-1);
	}

	private static void mergeSort(int[] ar, int[] tmp, int left, int right){
		if( left < right ){
			int center = (left + right) / 2;
			mergeSort(ar, tmp, left, center);
			mergeSort(ar, tmp, center + 1, right);
			merge(ar, tmp, left, center + 1, right);
		}
	}

	  private static void merge(int[] ar, int[] tmp, int left, int right, int rightEnd ){
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd) {
            if(ar[left] <= ar[right])
                tmp[k++] = ar[left++];
            else
                tmp[k++] = ar[right++];
        }

        while(left <= leftEnd)   
            tmp[k++] = ar[left++];

        while(right <= rightEnd)  
            tmp[k++] = ar[right++];

     
        for(int i = 0; i < num; i++, rightEnd--)
            ar[rightEnd] = tmp[rightEnd];

        System.out.println(Arrays.toString(tmp));
    }
 

 	public static int[] generateArray(){
		int[] ar = new int[10]; 
		Random randomNumber = new Random();
		for(int i=0;i<ar.length;i++){
			ar[i]= randomNumber.nextInt(10);
		}
		return ar;
	}

	public static void main(String[] args){
		
		JOptionPane.showMessageDialog(null, "Welcome to the sorting algorithm tutorial \n This program shows how following algorithms manipulate int array", "Sorting Algorithm tutorial", JOptionPane.INFORMATION_MESSAGE);
		String[] algorithms = {"Bubblesort", "SelectionSort", "InsertionSort", "MergeSort"};
		String result = "";
		while(result != null) {
			result = (String) JOptionPane.showInputDialog(null, "Select a sorting algorithm that you want to see", "Sorting Algorithm Tutorial", JOptionPane.QUESTION_MESSAGE, null, algorithms, algorithms[0]);
			int[] arr = generateArray();

			if (result != null){ JOptionPane.showMessageDialog(null, "Sorting array " + Arrays.toString(arr) + " using " + result, "Sorting Algorithm tutorial", JOptionPane.INFORMATION_MESSAGE);
				
				System.out.println(result);
	
				
				switch(result) {
					case "Bubblesort": bubbleSort(arr); break;
					case "SelectionSort": selectionSort(arr); break;
					case "InsertionSort": insertionSort(arr); break;
					case "MergeSort": mergeSort(arr); break;
				}	
			} 
		}
	}

}