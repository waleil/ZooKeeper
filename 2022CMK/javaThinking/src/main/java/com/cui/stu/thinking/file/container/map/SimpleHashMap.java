package com.cui.stu.thinking.file.container.map;

import java.util.*;

/**
 * @Auther: csx
 * @Date: 2022/4/8 21:47
 * @Description:
 */
public class SimpleHashMap<K,V> extends AbstractMap<K,V> {

    static final int SIZE = 3;

    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];
    public V put(K key, V value){
        V oldValue = null;
        int index =  Math.abs(key.hashCode())%SIZE;
        if(buckets[index]==null){
            buckets[index] = new LinkedList<MapEntry<K,V>>();
        }
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<K,V>(key,value);
        boolean found = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        while(it.hasNext()){
            MapEntry<K,V> ipair = it.next();
            if(ipair.getKey().equals(key)){
                oldValue = ipair.getValue();
                it.set(pair);
                found=true;
                break;
            }
        }
        if(!found){
            buckets[index].add(pair);
        }
        return oldValue;
    }

    public V get(Object key){
        int index = Math.abs(key.hashCode())%SIZE;
        if(buckets[index]==null)return null;
        for(MapEntry<K,V> ipair:buckets[index]){
            if(ipair.getKey().equals(key)){
                return ipair.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
        for(LinkedList<MapEntry<K,V>> bucket:buckets){
            if(bucket==null)continue;
            for(MapEntry<K,V> mpair:bucket){
                set.add(mpair);
            }
        }
        return set;
    }

    public static void main(String[] args){
        SimpleHashMap<String, String> map = new SimpleHashMap<String,String>();
        map.put("0","A0");
        map.put("1","B0");
        map.put("2","C0");
        map.put("3","D0");
        map.put("4","E0");
        map.put("5","F0");
        map.put("6","G0");
        map.put("7","H0");
        map.put("8","I0");
        System.out.println(map);
        System.out.println(map.get("3"));
        System.out.println(map.entrySet());
    }

}
