/*

Reference: https://leetcode.com/problems/implement-trie-prefix-tree/

*/
class Trie {

    Set<String> data=null;
    /** Initialize your data structure here. */
    public Trie() {
        data = new HashSet<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        data.add(word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return data.contains(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix==null || prefix.length()<1)
            return false;
        for(String str: data) {
            if(str.startsWith(prefix))
                return true;
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
