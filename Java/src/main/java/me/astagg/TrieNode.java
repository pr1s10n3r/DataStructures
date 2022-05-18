package me.astagg;

public class TrieNode {
	private TrieNode[] children;
	private int wordCount;

	public TrieNode() {
		this.children = new TrieNode[26];
		this.wordCount = 0;
	}

	public TrieNode[] getChildren() {
		return children;
	}

	public void setChildren(TrieNode[] children) {
		this.children = children;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}
}
