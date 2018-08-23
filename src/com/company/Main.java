package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LRUCache cache = new LRUCache(2 /* capacity */ );
        cache.get(2);
        cache.put(2,6);
        cache.get(1);
        cache.put(1,5);
        cache.put(1,2);
        cache.get(1);
        cache.get(2);
    }

    /**
     *找到没有相同字母的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        Set<Character> set=new HashSet<>();
        int ans=0,i=0,j=0;
        while (i<len&&j<len){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans=Math.max(ans,j-i);
            }else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
