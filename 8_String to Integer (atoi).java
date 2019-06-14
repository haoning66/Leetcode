class test {
    public int myAtoi(String str) {
        if(str.startsWith(" ")){
            int i=0;
            while(i<str.length()-1 && str.charAt(i)==' '){
                i++;
            }
            str=str.substring(i);
        }
        if(str.equals("")) return 0;
        else{
            char str_head = str.charAt(0);
            if(str.equals("+")||str.equals("-")) return 0;
            if(str_head!='+' && str_head!='-' && !Character.isDigit(str_head)) return 0;
            else{
                try{
                    if(Character.isDigit(str_head)) return Atoi(str,0);
                    else if(str_head=='+'&&Character.isDigit(str.charAt(1))) return Atoi(str,1);
                    else if(str_head=='-'&&Character.isDigit(str.charAt(1))) return -Atoi(str,1);
                }catch(NumberFormatException e){
                    if(str_head=='-') return -2147483648;
                    else return 2147483647;
                }
            }
        }
        return 0;
    }
    public int Atoi(String str,int begin){
        String integer_string="";
        for(int i =begin;i< str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                integer_string+=str.charAt(i);
            }
            else{
                return Integer.parseInt(integer_string);
            }
        }
        return Integer.parseInt(integer_string);
    }

    public static void main(String[] args) {
        String s = "    -42";
        test t1 = new test();
        System.out.println(t1.myAtoi(s));
    }
}