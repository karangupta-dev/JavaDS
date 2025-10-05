package Misc.JavaInBuiltDataStructure;

import java.util.*;
import java.util.concurrent.*;

public class QueueExamples {

    public static void main(String[] args) {
        System.out.println("=== 1. LinkedList (as Queue) ===");
        linkedListExample();

        System.out.println("\n=== 2. ArrayDeque ===");
        arrayDequeExample();

        System.out.println("\n=== 3. PriorityQueue ===");
        priorityQueueExample();

        System.out.println("\n=== 4. ArrayBlockingQueue (Thread-safe) ===");
        arrayBlockingQueueExample();

        System.out.println("\n=== 5. LinkedBlockingQueue (Thread-safe) ===");
        linkedBlockingQueueExample();

        System.out.println("\n=== 6. PriorityBlockingQueue (Thread-safe) ===");
        priorityBlockingQueueExample();

        System.out.println("\n=== Performance Comparison ===");
        performanceComparison();
    }

    // 1. LinkedList - Doubly-linked list implementation
    static void linkedListExample() {
        Queue<String> queue = new LinkedList<>();

        // Add elements
        queue.offer("Apple");
        queue.offer("Banana");
        queue.offer("Cherry");

        System.out.println("Queue: " + queue);
        System.out.println("Peek: " + queue.peek());
        System.out.println("Poll: " + queue.poll());
        System.out.println("After poll: " + queue);

        // Features: Can store null, FIFO order, implements Deque
    }

    // 2. ArrayDeque - Resizable array implementation (FASTEST for queue operations)
    static void arrayDequeExample() {
        Queue<String> queue = new ArrayDeque<>();

        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");

        System.out.println("Queue: " + queue);
        System.out.println("Poll: " + queue.poll());
        System.out.println("After poll: " + queue);

        // Features: Faster than LinkedList, no capacity restrictions,
        // null elements NOT allowed, implements Deque
    }

    // 3. PriorityQueue - Heap-based priority queue
    static void priorityQueueExample() {
        // Natural ordering (min-heap)
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(5);
        minHeap.offer(1);
        minHeap.offer(3);
        minHeap.offer(2);

        System.out.println("Min Heap - polling in order:");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();

        // Custom comparator (max-heap)
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(5);
        maxHeap.offer(1);
        maxHeap.offer(3);
        maxHeap.offer(2);

        System.out.println("Max Heap - polling in order:");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();

        // Features: Elements ordered by priority, NOT FIFO,
        // O(log n) insertion/removal, null NOT allowed
    }

    // 4. ArrayBlockingQueue - Bounded blocking queue (Thread-safe)
    static void arrayBlockingQueueExample() {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        try {
            queue.put("Item1");
            queue.put("Item2");
            queue.put("Item3");

            System.out.println("Queue: " + queue);
            System.out.println("Is full: " + (queue.remainingCapacity() == 0));

            System.out.println("Take: " + queue.take());
            System.out.println("After take: " + queue);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Features: Fixed capacity, thread-safe, blocking operations,
        // put() blocks if full, take() blocks if empty
    }

    // 5. LinkedBlockingQueue - Optionally bounded blocking queue
    static void linkedBlockingQueueExample() {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        try {
            queue.put(10);
            queue.put(20);
            queue.put(30);

            System.out.println("Queue: " + queue);
            System.out.println("Take: " + queue.take());
            System.out.println("After take: " + queue);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Features: Can be bounded or unbounded, thread-safe,
        // higher throughput than ArrayBlockingQueue
    }

    // 6. PriorityBlockingQueue - Unbounded priority blocking queue
    static void priorityBlockingQueueExample() {
        BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        try {
            queue.put(30);
            queue.put(10);
            queue.put(20);

            System.out.println("Priority Blocking Queue (sorted order):");
            while (!queue.isEmpty()) {
                System.out.print(queue.take() + " ");
            }
            System.out.println();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Features: Unbounded, thread-safe, priority ordering,
        // take() blocks if empty
    }

    // Performance comparison
    static void performanceComparison() {
        int iterations = 100000;

        // LinkedList
        long start = System.nanoTime();
        Queue<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < iterations; i++) {
            linkedList.offer(i);
        }
        for (int i = 0; i < iterations; i++) {
            linkedList.poll();
        }
        long linkedListTime = System.nanoTime() - start;

        // ArrayDeque
        start = System.nanoTime();
        Queue<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < iterations; i++) {
            arrayDeque.offer(i);
        }
        for (int i = 0; i < iterations; i++) {
            arrayDeque.poll();
        }
        long arrayDequeTime = System.nanoTime() - start;

        // PriorityQueue
        start = System.nanoTime();
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < iterations; i++) {
            priorityQueue.offer(i);
        }
        for (int i = 0; i < iterations; i++) {
            priorityQueue.poll();
        }
        long priorityQueueTime = System.nanoTime() - start;

        System.out.println("Time for " + iterations + " operations:");
        System.out.println("LinkedList: " + linkedListTime / 1_000_000 + " ms");
        System.out.println("ArrayDeque: " + arrayDequeTime / 1_000_000 + " ms (FASTEST)");
        System.out.println("PriorityQueue: " + priorityQueueTime / 1_000_000 + " ms");
    }
}