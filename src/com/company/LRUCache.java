package com.company;

import org.junit.Test;
import org.w3c.dom.Node;

import java.util.*;


public class LRUCache {
    class MapNode{
        int key;
        int value;
        public MapNode(int key,int value) {
            this.key = key;
            this.value=value;
        }
    }
    private Map<Integer,MapNode> map=null;
    private int capcity;
    private int size;
        public LRUCache(int capacity) {
            this.capcity=capacity;
            size=0;
            map=new LinkedHashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)){
                return -1;
            }else {
                int r=map.get(key).value;
                MapNode temMapNode=map.get(key);
                map.remove(key);
                map.put(key,temMapNode);//这一步相当于是更新了位置,把对应健值的元素挪到最后
                return r;
            }
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)){
                if (size<capcity){
                    map.put(key,new MapNode(key,value));
                    size++;
                }else {
                    Iterator<Map.Entry<Integer,MapNode>> iterator=map.entrySet().iterator();
                    int tem=-1;
                    if (iterator.hasNext()){
                        tem=iterator.next().getKey();//获取第一个元素，删除它
                    }
                    if (tem!=-1){
                        map.remove(tem);
                        map.put(key,new MapNode(key,value));
                    }
                }
            }else {
                MapNode temMapNode=map.get(key);
                map.remove(key);
                temMapNode.value=value;
                map.put(key,temMapNode);
            }
        }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */