package com.blz.datastructure;

import java.util.Arrays;

public class ExtendPrimeNum {
    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0);
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
        int[][] anagrams = new int[k][k];
        int[][] nonAnagrams = new int[k][k];
        int a = 0, b = 0;
        for (int i = 0; i < k; i++){
            for (int j = 0; j < k; j++){
                if (isAnagram(prime[i], prime[j] )) {
                    anagrams[a][0] = prime[i];
                    anagrams[a++][1] = prime[j];
                }
                else {
                    nonAnagrams[b][0] = prime[i];
                    nonAnagrams[b++][1] = prime[j];
                }
            }
        }
        System.out.println("Anagrams: ");
        for (int i = 0; i < a; i++){
            System.out.println(anagrams[i][0]+ " " + anagrams[i][1]);
        }
        System.out.println("Non anagrams: ");
        for (int i = 0; i < b; i++){
            System.out.println(nonAnagrams[i][0] + " " + nonAnagrams[i][1]);
        }
    }
}
