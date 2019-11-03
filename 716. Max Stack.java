import java.util.*;

class Solution{
    public static void main(String[] args){
        MaxStack s = new MaxStack();
        s.push(5);
        s.push(1);
        s.push(5);
        System.out.println(s.top());
        System.out.println(s.popMax());

    }
}

class MaxStack {
    private int max;
    private Stack<Integer> stack;


    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        max = Integer.MIN_VALUE;
    }

    public void push(int x) {
        if(x >= max){
            stack.push(max);
            max = x;
        }
        stack.push(x);
    }

    public int pop() {
        int top = stack.peek();
        if(stack.pop() == max) {
            max = stack.pop();
        }
        return top;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return max;
    }

    public int popMax() {
        List<Integer> list = new ArrayList<>();
        while(stack.peek() != max){
            list.add(stack.pop());
        }
        int premax = stack.pop();
        max = stack.pop();
        for(int i = list.size() - 1; i >= 0; i--) {
            this.push(list.get(i));
        }
        return premax;
    }
}
