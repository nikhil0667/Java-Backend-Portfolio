package Genric_Collection_Framework;

public class Box<T> {
    private T t;

    public Box(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}


class BoxDemo<K, V> {
    private K key;
    private V value;

    public BoxDemo(K key, V value) {
        this.key = key;
        this.value = value;

    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}