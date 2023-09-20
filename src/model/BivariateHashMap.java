package model;

import java.util.HashMap;

public class BivariateHashMap<K1, K2, V>{
    private HashMap<Position, V> bivariateHashMap;

    public BivariateHashMap(){
        bivariateHashMap = new HashMap<>();
    }

    public void put(Position<K1, K2> k, V value){
        bivariateHashMap.put(k, value);
    }

    public V get(Position<K1, K2>k){
        return  bivariateHashMap.get(k);
    }

    public int size(){
        return bivariateHashMap.size();
    }

    @Override
    public String toString() {
        return bivariateHashMap.toString();
    }
}
