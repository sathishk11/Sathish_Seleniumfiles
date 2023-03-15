package Simple_programs;

import java.util.ArrayList;

public class common_arraylist {

	public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);

        ArrayList<Integer> commonElements = new ArrayList<>();
        for (Integer element : list1) {
            if (list2.contains(element)) {
                commonElements.add(element);
            }
        }

        System.out.println("Common elements: " + commonElements);
    }
}
