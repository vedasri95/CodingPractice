package sortingAlgorithms;

import java.util.Scanner;

public class QuickSort {
	
	public int partition(int[] nums, int left, int right) {
		int pindex = right;
		int pivot = nums[pindex];
		int i=left-1;
		int j=left;
		while(j<right) {
			if(nums[j] < pivot) {
				i++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
			j++;
		}
		i++;
		int temp = nums[i];
		nums[i] = pivot;
		nums[pindex] = temp;
		return i;
	}
	
	public void quickSort(int[] nums, int left, int right) {
		if(left >= right) return;
		int mid = partition(nums, left, right);
		System.out.println(mid);
		quickSort(nums, left, mid-1);
		quickSort(nums, mid+1, right);
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
		QuickSort qs = new QuickSort();
		qs.quickSort(nums,0,nums.length-1);
		qs.printArray(nums);
	}
}
