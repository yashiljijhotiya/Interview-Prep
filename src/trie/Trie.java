package trie;

public class Trie {

    static class TrieNode {
        TrieNode links[] = new TrieNode[26];// we are considering smaller case alphabet
        boolean isPresent;

        TrieNode() {

        }

        boolean containsKey(char c) {
            return (links[c - 'a'] != null);
        }

        void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }

        TrieNode get(char c) {
            return links[c - 'a'];
        }

        void setEnd() {
            isPresent = true;
        }

        boolean isEnd() {
            return isPresent;
        }
    }

    private static TrieNode root = null;

    public Trie() {
        root = new TrieNode();
    }

    // Insert word into trie
    public static void insert(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (!temp.containsKey(c)) {
                temp.put(c, new TrieNode());
            }
        }
    }

    // @return true if the word present in the trie
    public static boolean search(String word) {
        return true;
    }

    //@return true if any word present in the trie start with the given prefix
    public static boolean startWith(String prefix) {
        return true;
    }


}
