import java.util.*;

class MovingAverage {
    private int count;
    private int[] window;
    private int sum;
    private int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        count = 0;
        sum = 0;
        this.size = size;
        window = new int[size];
    }

    public double next(int val) {
        sum -= window[count % size];
        window[count % size] = val;
        count += 1;
        sum += val;
        return count < size? (double)sum / (double)count : (double)(sum) / (double)(size);
    }
}

