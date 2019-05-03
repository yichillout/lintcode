package com.jasper.hashtable;

import java.util.ArrayList;
import java.util.List;

public class LC647_FindAllAnagramsInString {

	// Solution 1
	public List<Integer> findAnagrams1(String s, String p) {

		List<Integer> results = new ArrayList<>();

		if (s.length() < p.length()) {
			return results;
		}

		char[] sc = s.toCharArray();
		char[] pc = p.toCharArray();

		// int[] sCount = new int[256];
		// int[] pCount = new int[256];
		int[] det = new int[256];

		// det = sCount - pCount
		for (int i = 0; i < pc.length; i++) {
			// sCount[sc[i]]++;
			// pCount[pc[i]]++;

			det[sc[i]]++;
			det[pc[i]]--;
		}

		int absSum = 0;
		for (int item : det) {
			absSum += Math.abs(item);
		}

		if (absSum == 0) {
			results.add(0);
		}

		for (int i = p.length(); i < sc.length; i++) {
			char right = sc[i];
			char left = sc[i - p.length()];

			// sCount[right]++;
			// sCount[left]--;

			absSum = absSum - Math.abs(det[right]) - Math.abs(det[left]);

			det[right]++;
			det[left]--;

			absSum = absSum + Math.abs(det[right]) + Math.abs(det[left]);

			if (absSum == 0) {
				results.add(i - p.length() + 1);
			}
		}
		return results;
	}

	// Solution 2
	public List<Integer> findAnagrams2(String s, String p) {
		List<Integer> ans = new ArrayList<Integer>();
		int[] sum = new int[30];

		int plength = p.length();
		int slength = s.length();

		for (char c : p.toCharArray()) {
			sum[c - 'a']++;
		}

		int start = 0, end = 0, matched = 0;
		while (end < slength) {
			if (sum[s.charAt(end) - 'a'] >= 1) {
				matched++;
			}
			sum[s.charAt(end) - 'a']--;
			end++;
			if (matched == plength) {
				ans.add(start);
			}
			if (end - start == plength) {
				if (sum[s.charAt(start) - 'a'] >= 0) {
					matched--;
				}
				sum[s.charAt(start) - 'a']++;
				start++;
			}
		}
		return ans;
	}
}
