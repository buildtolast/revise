package com.practice.concurrency;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {

    public static void main(String[] args) {

//        PriorityQueue()
//        Creates a PriorityQueue with the default initial capacity (11) that orders its elements according to their natural ordering.
//                PriorityQueue(Collection<? extends E> c)
//        Creates a PriorityQueue containing the elements in the specified collection.
//        PriorityQueue(int initialCapacity)
//        Creates a PriorityQueue with the specified initial capacity that orders its elements according to their natural ordering.
//                PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
//        Creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.
//                PriorityQueue(PriorityQueue<? extends E> c)
//        Creates a PriorityQueue containing the elements in the specified priority queue.
//                PriorityQueue(SortedSet<? extends E> c)
//        Creates a PriorityQueue containing the elements in the specified sorted set.

        Queue<Integer> queue = new PriorityQueue<>(2);
        try {
            System.out.println(queue.element()); // throws exception if queue is empty
        }  catch(Exception e) {
            System.out.println("Exception message for element() : " + e.getClass().getSimpleName());
        }

        queue.offer(1); //Adds the element, use when capacity is restricted
        queue.offer(2); //Adds the element, use when capacity is restricted
        try {
            queue.add(3); //Adds the element, when capacity is restricted, this method can throw exception
        }catch(Exception exception) {
            System.out.println("Exception message for add() : " + exception.getClass().getSimpleName());
        }
        System.out.println(queue.peek());// head element, do not remove from queue, queue empty - return null
        System.out.println(queue.poll()); // head element, remove from queue, queue empty - return null
        try {
            queue.remove();
            queue.remove();
            queue.remove();
            System.out.println(queue.element()); // head element, do not remove from queue. queue empty - throw exception
        } catch (Exception e) {
            System.out.println("Exception message for element() : " + e.getClass().getSimpleName());
        }
        try {
            queue.remove();//head element, remove, exception when queue is empty
        } catch (Exception e) {
            System.out.println("Exception message for remove() : " + e.getClass().getSimpleName());
        }

    }

}
