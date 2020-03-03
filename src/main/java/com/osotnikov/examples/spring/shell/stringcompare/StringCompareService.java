package com.osotnikov.examples.spring.shell.stringcompare;

import org.springframework.stereotype.Service;

@Service
public class StringCompareService {

	/**
	 * Compares str1 to str2 and returns the number of different characters between them.
	 * If the arguments are not of equal length, throws an IllegalArgumentException.
	 * 
	 * @param str1 String to compare with str2
	 * @param str2 String to compare with str1
	 * @return The number of different characters between str1 and str2.
	 * @throws NullPointerException in case str1 or str2 are null.
	 * @throws IllegalArgumentException in case str1 and str2 are of different lengths.
	 * */
	public int findNumberOfDifferencesInEqualLengthStrings(String str1, String str2) {
	
		if(str1.length() != str2.length()) {
			throw new IllegalArgumentException("Arguments are of different lengths!");
		}
		
		char[] carr1 = str1.toCharArray();
		char[] carr2 = str2.toCharArray();
		
		int diffs = 0;
		
		for(int i = 0; i < carr1.length; ++i) {
			if(carr1[i] != carr2[i]) {
				++diffs;
			}
		}
		
		return diffs;
	}
	
}
