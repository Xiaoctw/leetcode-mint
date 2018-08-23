package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class majorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int len=nums.length;
        Map<Integer,Integer> map=countNums(nums);
        List<Integer> list=new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry:map.entrySet()
             ) {
            if (entry.getValue()>len/3){
                list.add(entry.getKey());
            }
        }
        return list;
    }
    private Map<Integer,Integer> countNums(int[] nums){
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        return map;
    }
}
