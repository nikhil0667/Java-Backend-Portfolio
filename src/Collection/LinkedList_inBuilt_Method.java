/**
 * The class LinkedList_inBuilt_Method creates a LinkedList and initializes it with a list of strings.
 */
package Collection;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class LinkedList_inBuilt_Method {
    public static void main(String args[]) {

        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("Apple", "dog", "lion", "cow"));
        System.out.print(linkedList);

        LinkedList<String> linkedList2 = new LinkedList<>(Arrays.asList("dog"));

        linkedList.removeFirst();

        System.out.println(linkedList);
    }

}