// https://leetcode.com/problems/implement-trie-prefix-tree/
// Implement Trie (Prefix Tree)
import java.util.*;
public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new ImplementTrie().new Trie();
        trie.insert("car");
                trie.insert("camera");

        
        System.out.println(trie.search("car"));   // returns true
        System.out.println(trie.search("ca"));     // returns false
        System.out.println(trie.startsWith("ca")); // returns true
        System.out.println(trie.getSuggestion("ca")); // returns [car, camera   ]
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;

        public TrieNode(){
            isEnd = false;
        }
    }

    class Trie{
        private final TrieNode root;
        public Trie(){
            root = new TrieNode();
        }


        // time complexity: O(L) where L is the length of the word space complexity: O(L*26) in worst case
        public void insert(String word){  
            TrieNode node = root; // start from the root  
            for(char ch: word.toCharArray()){
                int index = ch - 'a';
                // if child node does not exist, create it
                if(node.children[index] == null){
                    node.children[index] = new TrieNode();
                }
                // move to the child node
                node = node.children[index];
            }
            // mark the end of the word after inserting all characters
            node.isEnd = true;
        }

        // time complexity: O(L) where L is the length of the word space complexity: O(1)
        public boolean search(String word){
            // start from the root
            TrieNode node = root;
            for(char ch: word.toCharArray()){
                // calculate index
                int index = ch - 'a';
                // if child node does not exist, word not found
                if(node.children[index] == null){
                    return false;
                }
                // move to the child node
                node = node.children[index];
            }
            // return true if it's end of a word
            return node.isEnd;
        }

        public boolean startsWith(String prefix){
            // start from the root
            TrieNode node = root;
            for(char ch: prefix.toCharArray()){
                // calculate index
                int index = ch - 'a';
                // if child node does not exist, prefix not found
                if(node.children[index] == null){
                    return false;
                }
                // move to the child node
                node = node.children[index];
            }
            // if we traverse all characters in prefix, return true
            return true;
        }
        
        public  List<String>  getSuggestion(String prefix){
            List<String> result = new ArrayList<>();
            TrieNode node = root;
            // traverse to the end of the prefix
            for(char ch: prefix.toCharArray()){
                int index = ch - 'a';
                if(node.children[index] == null){
                    return result; // prefix not found
                }
                node = node.children[index];
            }
            // perform DFS from the end of the prefix to find all words
            dfs(node, result, prefix);
            return result;
        }

        private void dfs(TrieNode node, List<String> result, String path){
            // if it's end of a word, add to result
            if(node.isEnd){
                result.add(path);
            }
            // explore all children
            for(int i = 0; i < 26; i++){
                // if child exists, continue DFS
                if(node.children[i] != null){
                    dfs(node.children[i], result, path + (char)(i + 'a'));
                }
            }
        }

    }
}
