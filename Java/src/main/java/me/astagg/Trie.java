package me.astagg;

public class Trie {
	TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public void insert(final String word) {
		TrieNode current = this.root;

		for (int i = 0; i < word.length(); ++i) {
			final int index = word.charAt(i) - 'a';
			final TrieNode[] children = current.getChildren();

			if (children[index] == null) {
				children[index] = new TrieNode();
				current.setChildren(children);
			}

			current = children[index];
		}

		current.setWordCount(current.getWordCount() + 1);
	}

	public boolean isPrefixExist(final String prefix) {
		TrieNode current = this.root;

		for (char ch : prefix.toCharArray()) {
			final TrieNode[] children = current.getChildren();
			if (children[ch - 'a'] == null) {
				return false;
			}
			current = children[ch - 'a'];
		}

		return true;
	}

	public boolean search(final String word) {
		TrieNode current = this.root;

		for (char ch : word.toCharArray()) {
			final TrieNode[] children = current.getChildren();
			if (children[ch - 'a'] == null) {
				return false;
			}
			current = children[ch - 'a'];
		}

		return current.getWordCount() > 0;
	}

	public boolean remove(final String word) {
		TrieNode current = this.root;
		TrieNode lastBranchNode = null;
		char lastBranchChar = 'a';

		for (char ch : word.toCharArray()) {
			final TrieNode[] children = current.getChildren();
			if (children[ch - 'a'] == null) {
				// The word does not exists
				return false;
			}

			int count = 0;
			for (int i = 0; i < 26; ++i) {
				if (children[i] != null) {
					++count;
				}
			}

			if (count > 1) {
				lastBranchNode = current;
				lastBranchChar = ch;
			}

			current = children[ch - 'a'];
		}

		int count = 0;
		final TrieNode[] children = current.getChildren();

		for (int i = 0; i < 26; ++i) {
			if (children[i] != null) {
				++count;
			}
		}

		// NOTE: The deleted word is a prefix of other words.
		if (count > 0) {
			current.setWordCount(current.getWordCount() - 1);
			return true;
		}

		// NOTE: The deleted word shares a common prefix with other words.
		if (lastBranchNode != null) {
			lastBranchNode.getChildren()[lastBranchChar - 'a'] = null;
			return true;
		}

		// NOTE: The deleted word does not share any common prefix with other words.
		this.root.getChildren()[word.charAt(0) - 'a'] = null;
		return true;
	}
}
