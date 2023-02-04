package com.blz.datastructure;
    import java.util.*;
    class QueueNode {
        int data;
        QueueNode next;

        QueueNode(int data) {
            this.data = data;
        }
    }
    class Queue {
        QueueNode front, rear;

        boolean isEmpty() {
            return front == null;
        }
        void enqueue(int data) {
            QueueNode newNode = new QueueNode(data);
            if (rear == null) {
                front = rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }
        int dequeue() {
            if (front == null) {
                System.out.println("Queue is empty");
                return -1;
            }
            int data = front.data;
            front = front.next;
            if (front == null)
                rear = null;
            return data;
        }
    }

    class PrimeAnagramQueue {
        static boolean isPrime(int n) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        }
        static boolean isAnagram(int n1, int n2) {
            String s1 = Integer.toString(n1);
            String s2 = Integer.toString(n2);
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            return Arrays.equals(c1, c2);
        }
        public static void main(String[] args) {
            int n = 1000;
            int[] prime = new int[n];
            int k = 0;
            for (int i = 2; i <= n; i++) {
                if (isPrime(i)) {
                    prime[k++] = i;
                }
            }
            Queue queue = new Queue();
            for (int i = 0; i < k; i++) {
                for (int j = i + 1; j < k; j++) {
                    if (isAnagram(prime[i], prime[j])) {
                        queue.enqueue(prime[i]);
                        queue.enqueue(prime[j]);
                    }
                }
            }
            System.out.println("Anagrams from the queue: ");
            while (!queue.isEmpty()) {
                System.out.print(queue.dequeue() + " ");
            }
        }
    }

