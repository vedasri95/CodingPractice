package sortingAlgorithms;

import java.util.Scanner;

public class BubbleSort {
	public void bubbleSort(int[] nums) {
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
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
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort(nums);
		bs.printArray(nums);
	}
}
