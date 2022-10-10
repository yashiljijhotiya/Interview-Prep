package stack;

import java.util.Stack;

/**
 * Rules : we have to maintain 2 stacks 1 for operand and other one for operator.
 * - for operator stack if the elem present in the top of the stack has greater priority than the
 * curr elem we are processing it will pop elem until it's equal or size of stack become zero or closes bracket.
 * But if in case of open bracket present in the top of the stack it will push it into the stack
 */
public class InfixExpressionEvaluation {

    private static int evaluateExpression(String expression) {
        if (expression == null || expression.length() == 0) {
            return 0;
        }
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                operatorStack.push(ch);
            } else if (Character.isDigit(ch)) {
                operandStack.push(ch - '0');//convert char to integer
            } else if (ch == ')') {
                while (operatorStack.peek() != '(') {
                    char operator = operatorStack.pop();
                    int val2 = operandStack.pop();//a+b here in stack a store before b so we reverse order to evaluate val correctly
                    int val1 = operandStack.pop();
                    int val = evaluate(val1, val2, operator);
                    operandStack.push(val);
                }
                operatorStack.pop();// to remove opening bracket
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operatorStack.size() > 0 && operatorStack.peek() != '(' &&
                        precedence(ch) <= precedence(operatorStack.peek())) {
                    char operator = operatorStack.pop();
                    int val2 = operandStack.pop();//a+b here in stack a store before b so we reverse order to evaluate val correctly
                    int val1 = operandStack.pop();
                    int val = evaluate(val1, val2, operator);
                    operandStack.push(val);
                }
                operatorStack.push(ch);
            }
        }

        // for handling this use case 2+3*6
        while (operatorStack.size() != 0) {
            char operator = operatorStack.pop();
            int val2 = operandStack.pop();//a+b here in stack a store before b so we reverse order to evaluate val correctly
            int val1 = operandStack.pop();
            int val = evaluate(val1, val2, operator);
            operandStack.push(val);
        }
        return operandStack.peek();
    }

    private static int precedence(char operator) {
        if (operator == '+') {
            return 1;
        } else if (operator == '-') {
            return 1;
        } else if (operator == '*') {
            return 2;
        } else {
            return 2;
        }
    }

    private static int evaluate(int v1, int v2, char operator) {
        if (operator == '+') {
            return v1 + v2;
        } else if (operator == '-') {
            return v1 - v2;
        } else if (operator == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }

    public static void main(String[] args) {
        String exp = "2*(5+5*2)/3+(6/2+8)";
        System.out.println(evaluateExpression(exp));
    }
}
