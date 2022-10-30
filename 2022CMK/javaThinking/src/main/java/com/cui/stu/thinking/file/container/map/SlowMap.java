package com.cui.stu.thinking.file.container.map;

import java.util.*;

/**
 * @Auther: csx
 * @Date: 2022/4/8 21:09
 * @Description:
 */
public class SlowMap<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();

    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    public V get(Object key) {
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext()) {
            set.add(new MapEntry<K, V>(ki.next(), vi.next()));
        }
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String, String> map = new SlowMap<String, String>();
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
