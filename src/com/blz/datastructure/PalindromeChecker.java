package com.blz.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

   public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String : ");
        String str = scanner.nextLine();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i <= str.length(); i++){
            queue.add(str.charAt(i));
        }
        boolean isPalindrome = true;
        int length = queue.size();
        for (int i = 0; i < length / 2; i++){
            if (queue.poll() != queue.remove()) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("The string is palindrome");
        }
        else {
            System.out.println("The string is not a palindrome");
        }
    }
}
