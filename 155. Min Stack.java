import java.util.*;

class MinStack {
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {  //use min to store the current min value use the element below stack.top to
        if(x <= min) {         //store the second min value
            stack.push(min);
            min = x;
        }
        stack.push(x);

    }

    public void pop() {
        if(stack.pop() == min)   //no matter this condition is true or not, one element will be poped
            min = stack.pop();   //make min be the second min value. The reason why use premin to store
    }                            //the second min value will not work is when min becomes the second min value
                                 //stored in premin, premin cannot become the second second min value again
    public int top() {           //we need the element in the stack to store the previous min value dynamically
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */