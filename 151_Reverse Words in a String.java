import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution{
    public String reverseWords(String s) {
        s = s.trim();
        if(s.length()==0 || !s.contains(" "))
            return s;
        String[] ss = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = ss.length-1; i >=0; i--){
            if(!ss[i].equals(""))
                sb.append(ss[i]+" ");
        }
        return sb.toString().trim();
    }


    public static void main(String[] args){
        Solution s = new Solution();
        String str = "  hello world!  ";
        System.out.println(s.reverseWords(str));

    }
}