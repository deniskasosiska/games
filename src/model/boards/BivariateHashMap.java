package model.boards;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BivariateHashMap<K1, K2, V>{
    private HashMap<Key, V> bivariateHashMap;

    public BivariateHashMap(){
        bivariateHashMap = new HashMap<>();
    }

    public void put(K1 x, K2 y, V value){
        bivariateHashMap.put(new Key(x,y),value);
    }

    public V get(K1 x, K2 y){
        return bivariateHashMap.get(new Key(x, y));
    }

    public int size(){
        return bivariateHashMap.size();
    }

    @Override
    public String toString() {
        return bivariateHashMap.toString();
    }

    private class Key{
        private K1 x;
        private K2 y;

        public Key(K1 x, K2 y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return  "{x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(x, key.x) && Objects.equals(y, key.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
