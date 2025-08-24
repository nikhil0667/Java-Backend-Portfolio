package Collection;

import java.util.LinkedList;

public class LindklistDemo {
    LinkedList<Integer> list = new LinkedList<>();

    public void
    add(int data) {
        list.add(data);
    }

    public void addFirst(int data) {
        list.addFirst(data);

    }

    public void addLast(int data) {
        list.addLast(data);
    }

    public void remove(int data) {
        list.remove(Integer.valueOf(data));
    }

    public void display() {
        for (int i : list) {
            System.out.println(i);
        }
    }

    public void removeFirst() {
        list.removeFirst();
    }

    public void removeLast() {
        list.removeLast();
    }

    public void getFirst() {
        System.out.println(list.getFirst());
    }

    public void getLast() {
        System.out.println(list.getLast());

    }

    public void removeIf() {
        list.removeIf(i -> i % 2 == 0);
    }

}
