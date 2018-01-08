package practiceMedium;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	Trie root = null;
	Map<Character, Trie> map = null;
	boolean isWord;
	/** Initialize your data structure here. */
    public Trie() {
        map = new HashMap<>();
        isWord = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.length() == 0 || search(word) ){
        	return;
        }
     
        if(root == null){
        	root = new Trie();
        	root.map.put(word.charAt(0), null);
        }
        Trie curr = root;
        for(int i = 0; i < word.length(); i++){
        	Trie next = curr.map.get(word.charAt(i));
        	if(next == null){
        		next = new Trie();
        		curr.map.put(word.charAt(i), next);
        	}
        	curr = next;
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || root == null){
        	return false;
        }
        Trie curr = root;
        for(int i = 0; i < word.length(); i++){
        	Trie next = curr.map.get(word.charAt(i));
        	if(next == null){
        		return false;
        	}
        	curr = next;
        }
        
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	if(prefix == null || prefix.length() == 0 || root == null){
        	return false;
        }
        Trie curr = root;
        for(int i = 0; i < prefix.length(); i++){
        	Trie next = curr.map.get(prefix.charAt(i));
        	if(next == null){
        		return false;
        	}
        	curr = next;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie test = new Trie();
		test.insert("");
		System.out.print(test.search(""));

	}

}
