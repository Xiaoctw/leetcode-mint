package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * 寻找一个数组中的主元素
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int len=nums.length;
        return findMajority(nums,0,len-1);
    }
    private int findMajority(int[] nums,int lo,int hi){
        if (lo==hi){
            return nums[lo];
        }
        int mid=(lo+hi)/2;
        int left=findMajority(nums,lo,mid);
        int right=findMajority(nums,mid+1,hi);
        int leftCount=count(nums,lo,mid,left);
        int rightCount=count(nums,mid+1,hi,right);
        if (leftCount>rightCount){
            return left;
        }else {
            return right;
        }
    }
    private int count(int[] nums,int lo,int hi,int x){
        int res=0;
        for (int i = lo; i <=hi ; i++) {
            if (nums[i]==x){
                res++;
            }
        }
        return res;
    }
    public Map<Integer,Integer> countNums(int[] nums){
        Map<Integer,Integer> counts=new HashMap<>();
        for (int num:nums
             ) {
            if (!counts.containsKey(num)){
                counts.put(num,1);
            }else {
                counts.put(num,counts.get(num)+1);
            }
        }
        return counts;
    }
    public int majorityElement1(int[] nums){
        var counts=countNums(nums);
        Map.Entry<Integer,Integer> majorityEntry=null;
        for (var entry:counts.entrySet()
             ) {
            if (majorityEntry==null||entry.getValue()>majorityEntry.getValue()){
                majorityEntry=entry;
            }
        }
        return majorityEntry.getKey();
    }
}
