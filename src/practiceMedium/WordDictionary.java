package practiceMedium;

public class WordDictionary {
	class TrieNode {
		TrieNode[] ch;
		boolean isWord;

		TrieNode() {
			ch = new TrieNode[26];
			this.isWord = false;
		}
	}

	TrieNode root;

	/** Initialize your data structure here. */
	public WordDictionary() {
		root = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		if (word == null || word.length() == 0 || search(word)) {
			return;
		}
		insert(root, word, 0);
	}

	private void insert(TrieNode root, String word, int pos) {
		if (pos == word.length()) {
			root.isWord = true;
			return;
		}
		if (root.ch[word.charAt(pos) - 'a'] == null) {
			root.ch[word.charAt(pos) - 'a'] = new TrieNode();
		}
		insert(root.ch[word.charAt(pos) - 'a'], word, pos + 1);

	}

	/**
	 * Returns if the word is in the data structure. A word could contain the
	 * dot character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		if (word == null || word.length() == 0) {
			return false;
		}
		return findMatch(root, word, 0, false);
	}

	private boolean findMatch(TrieNode root, String word, int pos, boolean found) {
		if (pos >= word.length()) {
			if (root.isWord) {
				return true;
			} else {
				return false;
			}
		}
		if (word.charAt(pos) == '.') {
			for (int i = 0; i < 26; i++) {
				if (root.ch[i] != null) {
					found = found | findMatch(root.ch[i], word, pos + 1, found);
				}
			}
		} else if (root.ch[word.charAt(pos) - 'a'] != null) {
			found = found | findMatch(root.ch[word.charAt(pos) - 'a'], word, pos + 1, found);
		}
		return found;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary dict = new WordDictionary();
		dict.addWord("bad");
		dict.addWord("bab");
		dict.addWord("dad");
		dict.addWord("mad");
		System.out.print(dict.search("d.p"));

	}

}
