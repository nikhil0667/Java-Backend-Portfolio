package Collection;

import java.awt.*;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(60);
        stack.push(70);
        stack.push(80);

        stack.push(40);
        stack.push(50);
        stack.push(90);
        System.out.println(stack);

        stack.add(111);
        stack.sort((x,y)->y-x);
        System.out.println(stack);
    }
}
