package com.stackroute;

import java.util.Scanner;

public class LongestSpan {

	/*
	 * findLongestSpan(int[]):String
	 * 
	 * - Method should take integer array as input and return a String with the number and longest span of a number separated by colon(:). 
	 * - If two numbers have the same longest span, the larger number and its span should be returned
	 * - A single value has a span of 1.
	 * 
	 * 	Note: If the input array is null or empty, method should return "-1"*
	 */

	/*
	 * Do the following in the main method of LongestSpan class
	 * 
	 * Accept inputs from the console The first input is integer(n) denoting the
	 * count of integers, followed by 'n' integers The integers should be stored in
	 * an array and passed to the method The output should be displayed as per the
	 * format given in example section Main method should display Empty Array, if
	 * the input array to the method is empty
	 */


	/*
	 * Sample Input: 5 1 2 1 2 1 // The max elements between 1's is 5 inclusive of
	 * 1. Longest span is 5
	 * 
	 * Expected Output: 1:5 
	 * 
	 * Sample Input: 7 3 4 5 3 1 3 4 // The max elements
	 * between 3 is 6 and 4 is 6. Longest span is 6 and larger number is 4
	 * 
	 * Expected Output: 4:6
	 */

	//Do not print anything other than what's expected/asked in problem
	public static void main(String[] args) {
		//Use Scanner to get input from console
		Scanner sc = new Scanner(System.in);
		int noOfInputs = sc.nextInt();
		int [] inputArray = new int [noOfInputs];
		for (int i = 0; i < noOfInputs; i++) {
			inputArray[i] = sc.nextInt();
		}
		String result = findLongestSpan(inputArray);
		if(result.equals("-1")) {
			System.out.println("Empty Array");
		}else {
			System.out.println(result);
		}
		

	}

	public static String findLongestSpan(int[] numbers) {
		int spanVal = 0;
		int digits =0;
		int outputNumber =0;
		int maxNumber = 0;
		if(numbers == null || numbers.length == 0) {
			return "-1";

		}
		for (int i = 0; i < numbers.length; i++) {
			if(maxNumber<numbers[i]) {
				maxNumber = numbers[i];
			}
			for (int j = numbers.length-1; j >i; j--) {
				if(digits!= numbers[j] && numbers[i] == numbers[j]) {
					spanVal = j-i;
					if(digits<Math.abs(numbers[i])) {
						digits = numbers[i];
						break;
					}
					
				}
				if(spanVal>outputNumber) {
					outputNumber = spanVal;
				}

			}

		}
		if(digits != 0) {
			return digits + ":" + (outputNumber+1);

		}else {
			return maxNumber + ":" + (outputNumber+1);
		}
	}

}
