package com.zmoyi.dataStructure.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * @author zhaofeng
 * @date 2023/10/22 22:36
 * @desc
 */
public class Calculator {


    private final Map<Character, Integer> map = new HashMap<Character, Integer>() {
        {
            put('+', 1);
            put('-', 1);
            put('*', 2);
            put('/', 2);
        }
    };

    public Integer calculator(String equation) {
        Stack<Character> numStack = new Stack<>();
        Stack<Character> symbolStack = new Stack<>();

        if (equation == null || equation.equals("")) {
            return 0;
        }
        char[] array = equation.toCharArray();
        for (char c : array) {
            Integer pri = map.get(c);
            if (Objects.nonNull(pri)) {
                numStack.push(c);
            } else {
                if (!symbolStack.isEmpty()) {
//                    return
                } else {
                    symbolStack.push(c);
                }
            }
        }
        return 0;
    }

    private void cal2(Stack<Character> numStack,
                         Stack<Character> symbolStack, char c) {
        Integer pri = map.get(c);
        Character preSymbol = symbolStack.peek();
        Integer preSymbolPri = map.get(preSymbol);
        if (pri > preSymbolPri) {
            symbolStack.push(c);
        } else {
            Character num1 = numStack.pop();
            Character num2 = numStack.pop();
            Integer result = cal(num1, num2, preSymbol);
            cal2(numStack, symbolStack, c);
        }
    }

    private Integer cal(Character num1, Character num2, Character symbol) {
        int n1 = Character.getNumericValue(num1);
        int n2 = Character.getNumericValue(num2);
        switch (symbol) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;
            default:
                return null;
        }
    }
}
