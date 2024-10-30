package com.cab.Controller;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	    // Finds decimal value of a given roman numeral
	 static int findMaximum(int[] arr, int n) {
	        int start=0;
	        int end=n-1;
	        while(start<=end)
	        {
	            int mid=start+(end-start)/2;
	            
	            if(mid>=0 && mid<n && arr[mid]>arr[mid-1]&& arr[mid]<arr[mid+1])
	            {
	                return arr[mid];
	            }else if(mid>=0 && mid<n && arr[mid]>arr[mid-1] )
	            {
	               start=mid+1;
	            } else if(mid>=0 && mid<n && arr[mid]<arr[mid-1])
	            {
	                 end=mid-1;
	            }
	        }
	        return 0;
	    }
	

    public static void main(String[] args) {
    	int[] arr= {1,15,25,45,42,21,17,12,11};
    	System.out.println(findMaximum(arr,9));
    }
}

