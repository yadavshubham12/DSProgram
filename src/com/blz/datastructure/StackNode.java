package com.blz.datastructure;


import java.util.*;
    class StackNode {
        int data;
        StackNode next;

        StackNode(int data) {
            this.data = data;
        }
    }

    class Stack {
        StackNode top;

        boolean isEmpty() {
            return top == null;
        }

        void push(int data) {
            StackNode newNode = new StackNode(data);
            if (top == null) {
                top = newNode;
            } else {
                StackNode temp = top;
                top = newNode;
                newNode.next = temp;
            }
        }

        int pop() {
            if (top == null) {
                System.out.println("Stack is empty");
                return -1;
            }
            int data = top.data;
            top = top.next;
            return data;
        }

        int peek() {
            if (top == null) {
                System.out.println("Stack is empty");
                return -1;
            }
            return top.data;
        }
    }

    class PrimeAnagramStack {
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
            Stack stack = new Stack();
            for (int i = 0; i < k; i++) {
                for (int j = i + 1; j < k; j++) {
                    if (isAnagram(prime[i], prime[j])) {
                        stack.push(prime[i]);
                        stack.push(prime[j]);
                    }
                }
            }
            System.out.println("Anagrams in reverse order: ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }
    }
