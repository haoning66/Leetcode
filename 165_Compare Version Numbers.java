import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1.length()==0||version2.length()==0)
            return 0;
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");

        for(int i=0;i<Math.min(version1Arr.length,version2Arr.length);i++){
            int version1Int = Integer.parseInt(version1Arr[i]);
            int version2Int = Integer.parseInt(version2Arr[i]);
            if(version1Int>version2Int)
                return 1;
            else if(version1Int<version2Int)
                return -1;
            else
                continue;
        }

        if(version1Arr.length>version2Arr.length){
            for(int i = version2Arr.length;i<version1Arr.length;i++){
                System.out.println(i);
                if(Integer.parseInt(version1Arr[i])>0)
                    return 1;
            }
        }
        else if(version1Arr.length<version2Arr.length){
            for(int i = version1Arr.length;i<version2Arr.length;i++){
                if(Integer.parseInt(version2Arr[i])>0)
                    return -1;
            }
        }
        return 0;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        String version1 = "1.0";
        String version2 = "1";
        System.out.println(s.compareVersion(version1,version2));

    }
}


