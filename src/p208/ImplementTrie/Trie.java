package p208.ImplementTrie;

import java.util.HashMap;

public class Trie {

    HashMap<Character, Trie> node;
    boolean isWord;

    public Trie() {
        node = new HashMap<Character, Trie>();
        isWord = false;
    }

    public void insert(String s) {
        Trie t = this;
        for (Character c : s.toCharArray()) {
            if (!t.node.containsKey(c)) {
                t.node.put(c, new Trie());
            }
            t = t.node.get(c);
        }
        t.isWord = true;
    }

    public boolean search(String s) {
        Trie t = this;
        for (Character c: s.toCharArray()) {
            if (!t.node.containsKey(c)) return false;
            t = t.node.get(c);
        }
        return t.isWord;
    }

    public boolean startsWith(String s) {
        Trie t = this;
        for (Character c: s.toCharArray()) {
            if (!t.node.containsKey(c)) return false;
            t = t.node.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */