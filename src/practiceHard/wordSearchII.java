package practiceHard;

import java.util.ArrayList;
import java.util.List;

import practiceMedium.Trie;



public class wordSearchII {
	/*
	 * if words or boards are null or empty, return null steps: Build a
	 * dictionary using words, and use dfs to explore the board + the trie that
	 * we just build.
	 * 
	 * Time: (kl + mn * 4^l)
	 */
	static class TrieNode {
		TrieNode[] ch;
		boolean isWord;

		public TrieNode() {
			ch = new TrieNode[26];
			this.isWord = false;
		}
	}

	public static List<String> findWords(char[][] board, String[] words) {
		List<String> sol = new ArrayList<>();
		if (words == null || board == null || words.length == 0 || board.length == 0) {
			return sol;
		}
		TrieNode di = buildDict(words);
		StringBuilder st = new StringBuilder();
		int row = board.length;
		int col = board[0].length;
		// boolean [][]visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				findWords(board, di, i, j, st, sol);
			}
		}
		return sol;
	}

	private static void findWords(char[][] board, TrieNode root, int r, int c, StringBuilder st, List<String> sol) {
		if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
			return;
		}
		char ch = board[r][c];
		if (board[r][c] == '#' || root.ch[ch - 'a'] == null) {
			return;
		}
		root = root.ch[ch - 'a'];
		st.append(ch);
		if (root.isWord) {
			sol.add(st.toString());
			root.isWord = false;
		}
		board[r][c] = '#';
		findWords(board, root, r - 1, c, st, sol);
		findWords(board, root, r + 1, c, st, sol);
		findWords(board, root, r, c - 1, st, sol);
		findWords(board, root, r, c + 1, st, sol);
		board[r][c] = ch;
		st.deleteCharAt(st.length() - 1);

	}

	private static TrieNode buildDict(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			addWord(word, root);
		}
		return root;
	}

	private static void addWord(String word, TrieNode root) {
		if (word == null || word.length() == 0 || search(word, root)) {
			return;
		}
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			if (curr.ch[word.charAt(i) - 'a'] == null) {
				curr.ch[word.charAt(i) - 'a'] = new TrieNode();
			}
			curr = curr.ch[word.charAt(i) - 'a'];
		}
		curr.isWord = true;
	}

	private static boolean search(String word, TrieNode root) {
		if (word == null || word.length() == 0 || root == null) {
			return false;
		}
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode next = curr.ch[word.charAt(i) - 'a'];
			if (next == null) {
				return false;
			}
			curr = next;
		}

		return curr.isWord;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain" };
		List<String> sol = findWords(board, words);
		for (String word : sol) {
			System.out.print(word + " ");
		}

	}

}
