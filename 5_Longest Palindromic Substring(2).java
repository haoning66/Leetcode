class test {
    public int MaxLength = 0;
    public int sub_Begin = 0;
    public String longestPalindrome(String s) {
        int s_Length = s.length();
        if(s==null || s_Length<2){
            return s;
        }
        char[] s_Char_Array = s.toCharArray();
        for(int i=0;i<s_Length;i++){
            FindLongestPalindrome(s_Char_Array,i,i);
            FindLongestPalindrome(s_Char_Array,i,i+1);
        }
        return s.substring(sub_Begin,sub_Begin+MaxLength);
    }
    public void FindLongestPalindrome(char[] Char_Array,int left,int right){
        while(left>=0 && right<Char_Array.length&& Char_Array[left]==Char_Array[right]){
            left--;
            right++;
        }
        if(right-left-1>MaxLength){
            MaxLength = right-left-1;
            sub_Begin = left+1;

        }
    }
    public static void main(String[] args) {
        test t1=new test();
        String s = "abbq";
        System.out.println(t1.longestPalindrome(s));
    }
}