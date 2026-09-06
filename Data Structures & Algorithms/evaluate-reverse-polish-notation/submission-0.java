
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            // If token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();  // second operand
                int a = stack.pop();  // first operand

                int result = 0;
                if (token.equals("+")) result = a + b;
                if (token.equals("-")) result = a - b;
                if (token.equals("*")) result = a * b;
                if (token.equals("/")) result = a / b; // integer division

                stack.push(result);
            } else {
                // Otherwise, it's a number
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop(); // Final result
    }
}
