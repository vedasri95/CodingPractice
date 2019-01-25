package sortingAlgorithms;

import java.util.Scanner;

public class MergeSort {

	public void merge(int[] nums, int left, int mid, int right) {
		int n1 = mid-left+1;
		int n2 = right-mid;
		int[] l = new int[n1];
		int[] r = new int[n2];
		int index=0;
		for(int i=left; i<=mid;i++)
			l[index++] = nums[i];
		index=0;
		for(int i=mid+1; i<=right;i++)
			r[index++] = nums[i];
		int i=0,j=0;
		index=left;
		
		while(i<l.length && j<r.length) {
			if(l[i] > r[j])
				nums[index++] = r[j++];
			else 
				nums[index++] = l[i++];
		}
		while(i<l.length)
			nums[index++] = l[i++];
		while(j<r.length)
			nums[index++] = r[j++];
		
	}
	public void mergeSort(int[] nums, int left, int right) {
		if(left >= right) return;
		int mid = (left+right)/2;
		mergeSort(nums, left, mid);
		mergeSort(nums, mid+1, right);
		merge(nums,left,mid,right);
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
		MergeSort ms = new MergeSort();
		ms.mergeSort(nums,0,nums.length-1);
		ms.printArray(nums);
	}
}
