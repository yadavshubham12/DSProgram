package com.blz.datastructure;

import java.util.Stack;

public class ArithmeticExpressions {
    public static void main(String[] args) {
      String expression = "(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)";
        System.out.println(isBalanced(expression));

    }
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
                
            }
        }
        return stack.isEmpty();
    }
}
