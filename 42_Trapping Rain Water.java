import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class test {
    public int trap(int[] height) {
        List bds = new ArrayList();
        if (height.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < height.length; i++) {
//            System.out.println(i);
            if (i > 0 && i < height.length - 1 && ((height[i] < height[i - 1] && height[i] < height[i + 1]) || (helper(i, height)))) {
                int low = i - 1;
                int high = i + 1;
                int real_low = 0;
                int real_high = height.length - 1;
                while (low >= 0 && high <= height.length - 1) {
//                    System.out.println(i + " " + real_low + " " + real_high);
                    if (height[low] < height[high]) {
                        if (real_low == 0 && real_high == height.length - 1) {
                            real_low = low;
                            real_high = high;
                        } else {
                            if (height[low] > height[real_low]) real_low = low;
                            if (height[high] > height[real_high]) real_high = high;
                        }
                        low--;
                    } else if (height[low] > height[high]) {
                        if (real_low == 0 && real_high == height.length - 1) {
                            real_low = low;
                            real_high = high;
                        } else {
                            if (height[high] > height[real_high]) real_high = high;
                            if (height[low] > height[real_low]) real_low = low;
                        }
                        high++;
                    } else if (height[low] == height[high]) {
                        if (real_low == 0 && real_high == height.length - 1) {
                            real_low = low;
                            real_high = high;
                        } else {
                            if (height[high] > height[real_high]) real_high = high;
                            if (height[low] > height[real_low]) real_low = low;
                        }
                        low--;
                        high++;
                    }
                }
                boolean dup = false;
                String bd = real_low + "," + real_high;
//                System.out.println(bd);
                if (bds.isEmpty()) {
                    bds.add(bd);
                } else {
                    for (int j = 0; j < bds.size(); j++) {
                        String bds_s = bds.get(j).toString();
                        int index = bds_s.indexOf(",");
                        if (bds.get(j).equals(bd) || Integer.parseInt(bds_s.substring(0, index)) <= real_low && (Integer.parseInt(bds_s.substring(index + 1)) >= real_high)) dup = true;
                        else if(Integer.parseInt(bds_s.substring(0, index)) >= real_low && (Integer.parseInt(bds_s.substring(index + 1)) <= real_high)) bds.remove(j);
                    }
                    if (dup != true) {
                        bds.add(bd);
                    }
                }
//                System.out.println(bds);
//                if (dup != true) {
//                    if (height[real_low] <= height[real_high]) {
//                        int low_heigh = height[real_low];
//                        for (int j = real_low; j < real_high - 1; j++) {
//                            result += low_heigh - height[j + 1];
//                        }
//                    } else if (height[real_low] > height[real_high]) {
//                        int low_heigh = height[real_high];
//                        for (int j = real_high; j > real_low + 1; j--) {
//                            result += low_heigh - height[j - 1];
//                        }
//                    }
//                }

            }
        }
        for(int i=0;i<bds.size();i++){
            String bd_s=bds.get(i).toString();
            int real_low = Integer.parseInt(bd_s.substring(0,bd_s.indexOf(",")));
            int real_high = Integer.parseInt(bd_s.substring(bd_s.indexOf(",")+1));
            if (height[real_low] <= height[real_high]) {
                int low_heigh = height[real_low];
                for (int j = real_low; j < real_high - 1; j++) {
                    result += low_heigh - height[j + 1];
                }
            } else if (height[real_low] > height[real_high]) {
                int low_heigh = height[real_high];
                for (int j = real_high; j > real_low + 1; j--) {
                    result += low_heigh - height[j - 1];
                }
            }
        }
        return result;
    }

    private boolean helper(int i, int[] height) {
        if (height[i] == height[i + 1] && height[i] < height[i - 1]) {
            while (i < height.length - 1 && height[i] == height[i + 1]) {
                i++;
            }
            if (i >= height.length - 1) return false;
            else if (height[i + 1] > height[i]) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        test t1 = new test();
        int[] height1 = {5, 2, 1, 2, 1, 2, 1, 5};  //21
        int[] height2 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};  //6
        int[] height3 = {4, 3, 3, 9, 3, 0, 9, 2, 8, 3}; //23
        int[] height4 = {6, 5, 2, 5, 6, 9, 1, 1}; //6
        int[] height5 = {0, 5, 6, 4, 6, 1, 0, 0, 2, 7}; //23
        int[] height6 = {7, 6, 7, 6, 9}; //2
        int[] height7 = {1, 9, 6, 9, 1, 8, 5};//10
        int[] height8 = {2,8,3,9,2,7,5,7,7,2};//12
        System.out.println(t1.trap(height3));
//        System.out.println(t1.helper(1,height3));

    }
}