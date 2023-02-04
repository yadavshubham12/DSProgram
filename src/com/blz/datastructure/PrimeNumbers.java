package com.blz.datastructure;

public class PrimeNumbers {
        public static void main(String[] args) {
            int[][] primeNumbers = new int[10][25];
            int rangeStart = 0;
            int rangeEnd = 100;
            int primeIndex = 0;
            for (int i = 0; i < 10; i++) {
                for (int num = rangeStart; num <= rangeEnd; num++) {
                    if (isPrime(num)) {
                        primeNumbers[i][primeIndex++] = num;
                    }
                }
                rangeStart = rangeEnd + 1;
                rangeEnd += 100;
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("Prime numbers in range " + (i * 100) + " to " + (i * 100 + 100 - 1) + " are:");
                for (int j = 0; j < 25; j++) {
                    if (primeNumbers[i][j] != 0) {
                        System.out.print(primeNumbers[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
        static boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

