package model;

import java.util.Objects;

public class Position<K1,K2> {
    private final K1 x;
    private final K2 y;

    public Position(K1 x, K2 y) {
        this.x = x;
        this.y = y;
    }

    public K1 getX() {
        return x;
    }

    public K2 getY() {
        return y;
    }

    @Override
    public String toString() {
        return "{x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position key = (Position) o;
        return Objects.equals(x, key.x) && Objects.equals(y, key.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
