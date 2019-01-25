package sortingAlgorithms;

import java.util.Scanner;

public class InsertionSort {
	
	public void insertionSort(int[] nums) {
		for(int i=1; i<nums.length;i++) {
			printArray(nums);
			int j=i-1;
			int key = nums[i];
			while(j>=0 && nums[j]>key) {
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = key;
		}
	}
	
	public void printArray(int[] nums) {
		for(int i=0; i<nums.length; i++)
			System.out.println(nums[i]);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++) 
			nums[i] = scan.nextInt();
		InsertionSort is = new InsertionSort();
		is.insertionSort(nums);
		is.printArray(nums);
	}
}
