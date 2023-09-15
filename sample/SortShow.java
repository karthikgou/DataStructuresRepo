/**
 *
 * @author Ouda
 */

//importing the libraries that will be needed in this program

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Random;

//The class that has all the sorts in it
public class SortShow extends JPanel { 

	
		// An array to hold the lines_lengths to be sorted
		public int[] lines_lengths;
		//The amount of lines needed
		public final int total_number_of_lines = 256;
		 // An array to holds the scrambled lines_lengths
		public int[] scramble_lines;
		//A temp Array that is used later for sorts
		public int[] tempArray;
		
		//the default constructor for the SortShow class
		public SortShow(){
			//assigning the size for the lines_lengths below
			lines_lengths = new int[total_number_of_lines];
			for(int i = 0; i < total_number_of_lines; i++) 
				lines_lengths[i] =  i+5;
			
		}
		

		//A method that scrambles the lines
		public void scramble_the_lines(){
			//A random generator
			Random num = new Random(); 
			//Randomly switching the lines
			for(int i = 0; i < total_number_of_lines; i++){
				//getting a random number using the nextInt method (a number between 0 to i + 1)
				int j = num.nextInt(i + 1); 
				//swapping The element at i and j 
				swap(i, j);
			}
			//assigning the size for the scramble_lines below
			scramble_lines = new int[total_number_of_lines];
			//copying the now scrambled lines_lengths array into the scramble_lines array 
			//to store for reuse for other sort methods
			//so that all sort methods will use the same scrambled lines for fair comparison 
			for (int i = 0; i < total_number_of_lines; i++)
			{
				scramble_lines[i] = lines_lengths[i];
			}
			//Drawing the now scrambled lines_lengths
			paintComponent(this.getGraphics());
		}
		
		//Swapping method that swaps two elements in the lines_lengths array
		public void swap(int i, int j){
			//storing the i element in lines_lengths in temp
			int temp = lines_lengths[i];
			//giving i element in lines_lengths the value of j element in lines_lengths
			lines_lengths[i] = lines_lengths[j];
			//giving j element in lines_lengths the value of temp
			lines_lengths[j] = temp;
		}
		
		//The selectionSort method
		public void SelectionSort(){			//getting the date and time when the selection sort starts
			Calendar start = Calendar.getInstance();

			//move index one by one in array where the current minimum element will be placed
			for (int i = 0; i < total_number_of_lines - 1; i++) {

				// Find the minimum element in the unsorted part of the array
				int index = i;
				for (int j = i + 1; j < total_number_of_lines; j++) {
					if (lines_lengths[j] < lines_lengths[index]) {
						index = j;

					}
				}
				
				// Swap the found minimum element with the current index
				swap(index, i);
				paintComponent(this.getGraphics());


				delay(10);
			}

			//getting the date and time when the selection sort ends
			Calendar end = Calendar.getInstance();
			//getting the time it took for the selection sort to execute 
			//subtracting the end time with the start time
	        SortGUI.selectionTime = end.getTime().getTime() - start.getTime().getTime();
		}
		
		//this method gets the smallest element in the array of lines_lengths
		public int getIndexOfSmallest(int first, int last){

			//You need to complete this part.

			return 1; //modify this line
		}
	/**
	 * Performs a bubble sort algorithm to sort an array of line lengths in ascending order.
	 * The sorting process is visualized using the "paintComponent" method.
	 */
	public void BubbleSort() {
		// Getting the date and time when the bubble sort starts
		Calendar start = Calendar.getInstance();

		// Using the bubble sort algorithm to sort the array
		for (int i = 0; i < total_number_of_lines - 1; i++) {
			for (int j = 0; j < total_number_of_lines - i - 1; j++) {
				// Compare adjacent elements and swap them if they are in the wrong order
				if (lines_lengths[j] > lines_lengths[j+1]) {
					swap(j, j+1);
					paintComponent(this.getGraphics());
				}

			}
			// Visualize the current state of the array after each change

		}

		// Getting the date and time when the bubble sort ends
		Calendar end = Calendar.getInstance();

		// Calculating the time it took for the bubble sort to execute
		// by subtracting the end time from the start time
		SortGUI.bubbleTime = end.getTime().getTime() - start.getTime().getTime();
	}

	/**
	 * Recursive merge sort method for sorting an array of line lengths in ascending order.
	 * Measures the execution time and updates the 'rmergeTime' variable in the SortGUI class.
	 */
	public void R_MergeSort() {
		// Getting the date and time when the recursive merge sort starts
		Calendar start = Calendar.getInstance();

		// Assigning the size for the tempArray below
		tempArray = new int[total_number_of_lines];

		// Initiating the recursive merge sort
		R_MergeSort(0, total_number_of_lines - 1);

		// Getting the date and time when the recursive merge sort ends
		Calendar end = Calendar.getInstance();

		// Calculating the time it took for the recursive merge sort to execute
		// by subtracting the end time from the start time and storing it in 'rmergeTime'
		SortGUI.rmergeTime = end.getTime().getTime() - start.getTime().getTime();
	}

	/**
	 * Recursive merge sort method that divides and sorts a portion of the array.
	 *
	 * @param first The index of the first element in the portion.
	 * @param last The index of the last element in the portion.
	 */
	public void R_MergeSort(int first, int last) {
		if (first < last) {
			int mid = (first + last) / 2;

			// Recursively sort the left and right subarrays
			R_MergeSort(first, mid);
			R_MergeSort(mid + 1, last);

			// Merge the sorted subarrays
			R_Merge(first, mid, last);

			// Visualize the current state of the array
			paintComponent(this.getGraphics());
		}
	}

	/**
	 * Merges two subarrays of the main array.
	 *
	 * @param first The index of the first element in the first subarray.
	 * @param mid The index of the last element in the first subarray.
	 * @param last The index of the last element in the second subarray.
	 */
	public void R_Merge(int first, int mid, int last) {
		// Calculate the sizes of the left and right subarrays
		int leftArraySize = mid - first + 1;
		int rightArraySize = last - mid;

		// Declare left and right subarrays
		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];

		// Copy elements into left and right subarrays
		for (int i = 0; i < leftArraySize; ++i) {
			leftArray[i] = lines_lengths[first + i];
		}

		for (int j = 0; j < leftArraySize; j++) {
			rightArray[j] = lines_lengths[mid + 1 + j];
		}

		int l = 0;
		int r = 0;
		int k = first;

		// Merge the left and right subarrays into the main array
		while (l < leftArraySize && r < rightArraySize) {
			if (leftArray[l] <= rightArray[r]) {
				lines_lengths[k++] = leftArray[l++];
			} else {
				lines_lengths[k++] = rightArray[r++];
			}
			// Visualize the current state of the array
			paintComponent(this.getGraphics());
		}

		// Copy any remaining elements from leftArray
		while (l < leftArraySize) {
			lines_lengths[k++] = leftArray[l++];
			// Visualize the current state of the array
			paintComponent(this.getGraphics());
		}

		// Copy any remaining elements from rightArray
		while (r < rightArraySize) {
			lines_lengths[k++] = rightArray[r++];
			// Visualize the current state of the array
			paintComponent(this.getGraphics());
		}
	}
		//

	//////////////////////////////////////////////////////////////////////////////////////////
		
		//iterative merge sort method
		public void I_MergeSort()
		{
		//getting the date and time when the iterative merge sort starts
		Calendar start = Calendar.getInstance();
		//assigning the size for the tempArray below
		tempArray = new int[total_number_of_lines]; 
		//saving the value of total_number_of_lines
		int beginLeftovers = total_number_of_lines;

		
		for (int segmentLength = 1; segmentLength <= total_number_of_lines/2; segmentLength = 2*segmentLength)
		{
			beginLeftovers = I_MergeSegmentPairs(total_number_of_lines, segmentLength);
			int endSegment = beginLeftovers + segmentLength - 1;
			if (endSegment < total_number_of_lines - 1) 
			{
			I_Merge(beginLeftovers, endSegment, total_number_of_lines - 1);
			}
		} 

		// merge the sorted leftovers with the rest of the sorted array
		if (beginLeftovers < total_number_of_lines) {
			I_Merge(0, beginLeftovers-1, total_number_of_lines - 1);
		}
		//getting the date and time when the iterative merge sort ends
		Calendar end = Calendar.getInstance();
		//getting the time it took for the iterative merge sort to execute 
		//subtracting the end time with the start time
	    SortGUI.imergeTime = end.getTime().getTime() - start.getTime().getTime();
	} 

	// Merges segments pairs (certain length) within an array 
	public int I_MergeSegmentPairs(int l, int segmentLength)
	{
		//The length of the two merged segments 

		//You suppose  to complete this part (Given).
		int mergedPairLength = 2 * segmentLength;
		int numberOfPairs = l / mergedPairLength;

		int beginSegment1 = 0;
		for (int count = 1; count <= numberOfPairs; count++)
		{
			int endSegment1 = beginSegment1 + segmentLength - 1;

			int beginSegment2 = endSegment1 + 1;
			int endSegment2 = beginSegment2 + segmentLength - 1;
			I_Merge(beginSegment1, endSegment1, endSegment2);

			beginSegment1 = endSegment2 + 1;
			//redrawing the lines_lengths
			paintComponent(this.getGraphics());
			//Causing a delay for 10ms
//			delay(10);
		}
		// Returns index of last merged pair
		return beginSegment1;
		//return 1;//modify this line
	}

	public void I_Merge(int first, int mid, int last)
	{
		//You suppose  to complete this part (Given).
		// Two adjacent sub-arrays
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid + 1;
		int endHalf2 = last;

		// While both sub-arrays are not empty, copy the
		// smaller item into the temporary array
		int index = beginHalf1; // Next available location in tempArray
		for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++)
		{
			// Invariant: tempArray[beginHalf1..index-1] is in order
			if (lines_lengths[beginHalf1] < lines_lengths[beginHalf2])
			{
				tempArray[index] = lines_lengths[beginHalf1];
				beginHalf1++;
			}
			else
			{
				tempArray[index] = lines_lengths[beginHalf2];
				beginHalf2++;
			}
		}
		//redrawing the lines_lengths
//		paintComponent(this.getGraphics());

		// Finish off the nonempty sub-array

		// Finish off the first sub-array, if necessary
		for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
			// Invariant: tempArray[beginHalf1..index-1] is in order
			tempArray[index] = lines_lengths[beginHalf1];

		// Finish off the second sub-array, if necessary
		for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
			// Invariant: tempa[beginHalf1..index-1] is in order
			tempArray[index] = lines_lengths[beginHalf2];

		// Copy the result back into the original array
		for (index = first; index <= last; index++) {
			lines_lengths[index] = tempArray[index];
			paintComponent(this.getGraphics());
		}

	}

	//////////////////////////////////////////////////////////////////////	
		
		//This method resets the window to the scrambled lines display
		public void reset(){
			if(scramble_lines != null)
			{
				//copying the old scrambled lines into lines_lengths
				for (int i = 0; i < total_number_of_lines; i++)
				{
					lines_lengths[i] = scramble_lines[i] ;
				}
			//Drawing the now scrambled lines_lengths
			paintComponent(this.getGraphics());
		}
			}
		
	
		//This method colours the lines and prints the lines
		public void paintComponent(Graphics g){
 			super.paintComponent(g);
			//A loop to assign a colour to each line
			for(int i = 0; i < total_number_of_lines; i++){
				//using eight colours for the lines
				if(i % 8 == 0){
					g.setColor(Color.green);
				} else if(i % 8 == 1){
					g.setColor(Color.blue);
				} else if(i % 8 == 2){
					g.setColor(Color.yellow);
				} else if(i%8 == 3){
					g.setColor(Color.red);
				} else if(i%8 == 4){
					g.setColor(Color.black);
				} else if(i%8 == 5){
					g.setColor(Color.orange);
				} else if(i%8 == 6){
					g.setColor(Color.magenta);
				} else
					g.setColor(Color.gray);
				
				//Drawing the lines using the x and y-components 
				g.drawLine(4*i + 25, 300, 4*i + 25, 300 - lines_lengths[i]);
			}
			
		}

	public int get_pivot(int low,int high)
	{
		int i=low-1;

		for(int j=low;j<=high-1;j++)
		{
			if(lines_lengths[j]<lines_lengths[high])
			{
				i=i+1;
				swap(i,j);
				paintComponent(this.getGraphics());
			}

		}
		swap(i+1,high);
		paintComponent(this.getGraphics());


		return i+1;

	}

	public void rquicksort(int low,int high)
	{
		if(low<high)
		{
			int pivot=get_pivot(low,high);
			rquicksort(low,pivot-1);
			rquicksort(pivot+1,high);
			paintComponent(this.getGraphics());
		}

	}

		public void quick_sort()
		{
			System.out.println("quick sort called");
			Calendar start = Calendar.getInstance();
			int low=0;
			int high=total_number_of_lines-1;

			rquicksort(low,high);

			Calendar end = Calendar.getInstance();

			SortGUI.rquickTime = end.getTime().getTime() - start.getTime().getTime();
		}


		public void insertion()
		{
			System.out.println("insertion called");
			Calendar start = Calendar.getInstance();
			int n=total_number_of_lines;
			for(int i=1;i<n;i++)
			{

				int key=lines_lengths[i];
				int j=i-1;

				while(j>=0 && lines_lengths[j]>key)
				{
					lines_lengths[j+1]=lines_lengths[j];
					j=j-1;
					paintComponent(this.getGraphics());
				}
				lines_lengths[j+1]=key;
			}
			Calendar end = Calendar.getInstance();

			SortGUI.insertionTime = end.getTime().getTime() - start.getTime().getTime();
		}
		
		//A delay method that pauses the execution for the milliseconds time given as a parameter
		public void delay(int time){
			try{
	        	Thread.sleep(time);
	        }catch(InterruptedException ie){
	        	Thread.currentThread().interrupt();
	        }
		}

		//The ShellSort method
		public void shell_sort(){
			//getting the date and time when the selection sort starts
			Calendar start = Calendar.getInstance();

			// Start with a large gap and reduce it until it becomes 1
			for (int currentgap = total_number_of_lines / 2; currentgap > 0; currentgap /= 2) {
				// Perform insertion sort on elements with the given gap
				for (int i = currentgap; i < total_number_of_lines; i++) {
					int temp = lines_lengths[i];
					int j;
					for (j = i; j >= currentgap && lines_lengths[j - currentgap] > temp; j -= currentgap) {
						lines_lengths[j] = lines_lengths[j - currentgap];
						paintComponent(this.getGraphics());
					}
					lines_lengths[j] = temp;
				}

				delay(10);
			}

			//getting the date and time when the selection sort ends
			Calendar end = Calendar.getInstance();
			//getting the time it took for the selection sort to execute 
			//subtracting the end time with the start time
	        SortGUI.shellTime = end.getTime().getTime() - start.getTime().getTime();
		}
		
	}

