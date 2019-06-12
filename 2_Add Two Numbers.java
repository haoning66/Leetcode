import java.math.BigInteger;

class test {
    int val;
    test next;
    test(int x) {
        val = x;
    }

    public test addTwoNumbers(test l1, test l2) {
        BigInteger sum= Sum_LinkdedList(l1).add(Sum_LinkdedList(l2));
        String sum_s = String.valueOf(sum);
        test l3 = new test(Integer.parseInt(String.valueOf(sum_s.charAt(sum_s.length()-1))));
        test temp = l3;
        for(int i=sum_s.length()-2;i>-1;i--){
            temp.next = new test(Integer.parseInt(String.valueOf(sum_s.charAt(i))));
            temp=temp.next;
        }
//        while(l3!=null){
//            System.out.println(l3.val);
//            l3=l3.next;
//        }
        return l3;
    }

    public BigInteger Sum_LinkdedList(test l){
        String sum_s = new String();
        while(l !=null){
            sum_s+=l.val;
            l=l.next;
        }
        String sum_s_rev = new StringBuffer(sum_s).reverse().toString();
        BigInteger sum = new BigInteger(sum_s_rev);
        return sum;
    }

    public static void main(String[] args) {
        test t1 = new test(2);
        test t2 = new test(4);
        test t3 = new test(3);
        t1.next = t2;
        t2.next = t3;
        test t4 = new test(5);
        test t5 = new test(6);
        test t6 = new test(4);
        t4.next=t5;
        t5.next=t6;
        System.out.println(t1.addTwoNumbers(t1, t4));

    }
}