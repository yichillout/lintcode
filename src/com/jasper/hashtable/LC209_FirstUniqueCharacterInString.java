package com.jasper.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC209_FirstUniqueCharacterInString {

	// Solution 1 : hash table
	public char firstUniqChar1(String str) {

		Map<Character, Integer> map = new HashMap<>();
		Set<Character> set = new HashSet<>();

		char[] charArray = str.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if (!set.contains(c)) {
				map.put(c, i);
				set.add(c);
			} else {
				map.remove(c);
			}
		}

		int index = Integer.MAX_VALUE;
		char res = '#';
		for (char c : map.keySet()) {
			if (map.get(c) < index) {
				index = map.get(c);
				res = c;
			}
		}

		return res;
	}

	class ListCharNode {
		public char val;
		public ListCharNode next;

		public ListCharNode(char val) {
			this.val = val;
			this.next = null;
		}
	}

	// Solution 2
	public int firstUniqChar2(String s) {
		if (s == null) {
			return -1;
		}
		int[] record = new int[256];
		for (int i = 0; i < s.length(); i++) {
			record[s.charAt(i)]++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (record[s.charAt(i)] == 1) {
				return i;
			}
		}
		return -1;
	}

	// Solution 3
	class DataStream {
		private Map<Character, ListCharNode> charToPrev;
		private Set<Character> dupChars;
		private ListCharNode dummy, tail;

		public DataStream() {
			charToPrev = new HashMap<>();
			dupChars = new HashSet<>();
			dummy = new ListCharNode('.');
			tail = dummy;
		}

		public void add(char c) {
			if (dupChars.contains(c)) {
				return;
			}

			if (!charToPrev.containsKey(c)) {
				ListCharNode node = new ListCharNode(c);
				charToPrev.put(c, tail);
				tail.next = node;
				tail = node;
				return;
			}

			// delete the existing node
			ListCharNode prev = charToPrev.get(c);
			prev.next = prev.next.next;
			if (prev.next == null) {
				// tail node removed
				tail = prev;
			} else {
				charToPrev.put(prev.next.val, prev);
			}

			charToPrev.remove(c);
			dupChars.add(c);
		}

		public char firstUniqueChar() {
			return dummy.next.val;
		}
	}

	public char firstUniqChar3(String str) {
		DataStream ds = new DataStream();
		for (int i = 0; i < str.length(); i++) {
			ds.add(str.charAt(i));
		}
		return ds.firstUniqueChar();
	}

}
