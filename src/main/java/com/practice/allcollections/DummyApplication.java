package com.practice.allcollections;

import com.practice.allcollections.entity.Customer;

import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;

public class DummyApplication {

    public static void main(String[] args) {

        //List --> java.util.Collection
        //ArrayList
        //StringBuffer sb = new StringBuffer();
        Integer[] arry = new Integer[]{1, 2, 7, 3};
        //sort
        Arrays.sort(arry);
        //sort decending
        Arrays.sort(arry, Collections.reverseOrder());

        List<Integer> list = Arrays.asList(1, 2);

        //stream api - sort
        Arrays.stream(arry).sorted(Comparator.reverseOrder());

        ArrayList<Integer> al = new ArrayList<>();
        al.stream().sorted();

        al.stream().sorted(Comparator.reverseOrder());

        al.stream().sorted();

        List<Customer> customers = new ArrayList<>(List.of(null, new Customer()));
        List<Customer> customers2 = new ArrayList<>(Arrays.asList(null, new Customer()));
        //order by customer name desc
        customers.stream().sorted(Comparator.comparing(Customer::getName)
                .reversed()).collect(Collectors.toList());



        //thread safe
        Collections.synchronizedList(customers);

        Stack<String> stack = new Stack<>();
        stack.push("Geeks");
        stack.push("For");
        stack.push("Geeks");
        stack.push("Geeks");


        for (int i = 0; i < stack.size(); i++) {

            System.out.println(stack.get(i));
        }
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);

        //LinkedList implements Deque which extents Queue
        ll.poll();//pop and remove
        ll.pop();
        ll.push(1);
        /*
        LinkedList should be used where modifications to a collection are
         frequent like addition/deletion operations. LinkedList is much
          faster as compare to ArrayList in such cases.
        In case of read-only collections or collections which are
        rarely modified, ArrayList is suitable.
         */

        Iterator iterator = al.iterator();
        //fail-fast ArrayList can't be changed after iterator declaration
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        List<Integer> listI = new ArrayList<>(List.of(null, 1, null));
        listI.removeAll(null);
        //remove null
        listI.stream().filter(Objects::nonNull);

        listI.removeIf(Objects::isNull);
        listI.stream().distinct();

        //remove all occurrence of 1
        listI.removeIf(x->x==1);

        //two list are equal
        listI.equals(al);

        //Intersection of Two Lists of Strings
        List<String> list2 = Arrays.asList("red", "blue", "blue", "green", "red");
        List<String> otherList = Arrays.asList("red", "green", "green", "yellow");

        Set<String> result = list2.stream()
                .distinct()
                .filter(otherList::contains)
                .collect(Collectors.toSet());

        Set<String> commonElements = new HashSet(Arrays.asList("red", "green"));

        System.out.println(result.equals(commonElements));

        List<String> listOne = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();
        List<String> differences = listOne.stream()
                .filter(element -> !listTwo.contains(element))
                .collect(Collectors.toList());


        //String to word
        String str = "ad dsafdsf asdfs as";
       String[] words =  str.split("\\s+");

    }
    //How to Count Duplicate Elements in Arraylist
    public <T> Map<T, Long> countByStreamGroupBy(List<T> inputList) {
        return inputList.stream().collect(Collectors.groupingBy(k -> k, Collectors.counting()));
    }

}
