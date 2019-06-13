class test {
    public String longestPalindrome(String s) {
        int s_length = s.length();
        for(int i=s_length;i>0;i--){
            for(int j=0;j<=s_length-i;j++){
                String s_sub=s.substring(j,i+j);
                if(if_Palindrome(s_sub)){
                    return s_sub;
                }
            }
        }
        return "";
    }
    public boolean if_Palindrome(String s){
        String s_rev = new StringBuffer(s).reverse().toString();
        return (s.equals(s_rev));
    }
    public static void main(String[] args) {
        test t1=new test();
        String s = "cbbd";
        System.out.println(t1.longestPalindrome(s));
    }
}