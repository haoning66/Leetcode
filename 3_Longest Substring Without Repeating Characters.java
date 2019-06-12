class test {
    public int lengthOfLongestSubstring(String s){
        int max_length=0;
        int s_length = s.length();
        if(s.length()>1000){
            for(int i=0;i<s_length;i++){
                if(if_dup(s.substring(0,i))){
                    return i-1;
                }
            }
        }
        else{
            for(int i=0;i<s_length;i++){
                for(int j=s.length();j>i;j--){
                    int ss_length = s.substring(i,j).length();
                    if(ss_length>max_length){
                        if(!if_dup(s.substring(i,j))){
                            max_length=ss_length;
                        }
                    }

                }
            }
        }
        return max_length;
    }
    public boolean if_dup(String s){
        char[] char_list = s.toCharArray();
        for(char c:char_list){
            if(s.indexOf(c)!=s.lastIndexOf(c)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        test t1 = new test();
        System.out.println(t1.lengthOfLongestSubstring("abcabcbb"));
    }
}