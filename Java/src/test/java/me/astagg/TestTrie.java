package me.astagg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTrie {
	@Test
	public void testAddSingleWord() {
		final Trie trie = new Trie();
		trie.insert("ant");
		Assertions.assertTrue(trie.isPrefixExist("ant"));
	}
	
	@Test
	public void testEmptyTriePrefixSearch() {
		final Trie trie = new Trie();
		Assertions.assertFalse(trie.isPrefixExist("foo"));
	}
	
	@Test
	public void testSearchWordThatExists() {
		final Trie trie = new Trie();
		trie.insert("barco");
		trie.insert("bar");
		trie.insert("dad");
		
		Assertions.assertTrue(trie.search("dad"));
		Assertions.assertTrue(trie.search("barco"));
	}
	
	@Test
	public void testSearchWordThatDoesNotExists() {
		final Trie trie = new Trie();
		trie.insert("barco");
		trie.insert("bar");
		trie.insert("dad");
		
		Assertions.assertFalse(trie.search("ant"));
	}
	
	@Test
	public void testSearchWordThatExistsAndDoesNotExists() {
		final Trie trie = new Trie();
		trie.insert("barco");
		trie.insert("bar");
		trie.insert("dad");
		
		Assertions.assertFalse(trie.search("ant"));
		Assertions.assertTrue(trie.search("dad"));
	}
	
	@Test
	public void testDeletedWordIsPrefixOfOtherWord() {
		final Trie trie = new Trie();
		trie.insert("barco");
		trie.insert("bar");
		Assertions.assertTrue(trie.remove("bar"));
		Assertions.assertFalse(trie.search("bar"));
		Assertions.assertTrue(trie.search("barco"));
	}
	
	@Test
	public void testDeleteWordWithCommonPrefix() {
		final Trie trie = new Trie();
		trie.insert("ant");
		trie.insert("and");
		Assertions.assertTrue(trie.remove("ant"));
		Assertions.assertFalse(trie.search("ant"));
		Assertions.assertTrue(trie.search("and"));
	}
	
	@Test
	public void testDeleteWordWithoutShareCommonPrefix() {
		final Trie trie = new Trie();
		trie.insert("carrot");
		trie.insert("greek");
		
		Assertions.assertTrue(trie.remove("greek"));
		Assertions.assertTrue(trie.search("carrot"));
	}
}
