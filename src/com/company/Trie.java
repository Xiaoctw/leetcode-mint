package com.company;

import java.util.HashMap;
import java.util.Map;

class TrieNode{
    boolean isWord;
    Map<Character,TrieNode> nexts;

    public TrieNode() {
        isWord=false;
        nexts=new HashMap<>();
    }
}


public class Trie {
    private TrieNode root=null;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int i=0,len=word.length();
        TrieNode node=root;
        while (i<len){
            if (node.nexts.containsKey(word.charAt(i))){
                node=node.nexts.get(word.charAt(i));
            }else {
                TrieNode temNode=new TrieNode();
                node.nexts.put(word.charAt(i),temNode);
                node=temNode;
            }
            i++;
        }
        node.isWord=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int i=0,len=word.length();
        TrieNode temNode=root;
        while (i<len){
            if (temNode.nexts.containsKey(word.charAt(i))){
                temNode=temNode.nexts.get(word.charAt(i));
                i++;
            }else {
                return false;
            }
        }
        return temNode.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int i=0,len=prefix.length();
        TrieNode temNode=root;
        while (i<len){
            if (temNode.nexts.containsKey(prefix.charAt(i))){
                temNode=temNode.nexts.get(prefix.charAt(i));
                i++;
            }else {
                return false;
            }
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
