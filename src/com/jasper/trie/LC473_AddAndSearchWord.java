package com.jasper.trie;

class TrieNode {

	public boolean isWord;
	public TrieNode[] children;

	public TrieNode(boolean isWord) {
		this.isWord = isWord;
		children = new TrieNode[26];
		for (int i = 0; i < 26; i++) {
			children[i] = null;
		}
	}

	public TrieNode() {
		this(false);
	}

}

class WordDictionary {

	TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.children[c - 'a'] == null) {
				cur.children[c - 'a'] = new TrieNode();
			}
			cur = cur.children[c - 'a'];
		}
		cur.isWord = true;
	}

	public boolean search(String word) {
		return find(word, root, 0);
	}

	public boolean find(String word, TrieNode node, int index) {
		if (index == word.length()) {
			return node.isWord;
		}

		Character c = word.charAt(index);

		if (c == '.') {
			for (int i = 0; i < 26; ++i)
				if (node.children[i] != null) {
					if (find(word, node.children[i], index + 1))
						return true;
				}
			return false;
		} else if (node.children[c - 'a'] != null) {
			return find(word, node.children[c - 'a'], index + 1);
		} else {
			return false;
		}
	}
}

public class LC473_AddAndSearchWord {

}
