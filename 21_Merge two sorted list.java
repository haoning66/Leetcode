import java.util.ArrayList;
import java.util.Collections;

class test{
    int val;
    test next;
    test(int x) { val = x; }
    public test mergeTwoLists(test l1, test l2) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(l1!=null){
            list.add(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            list.add(l2.val);
            l2=l2.next;
        }
        if(list.isEmpty()){
            return l1;
        }
        Collections.sort(list);
        test l3 = new test(list.get(0));
        test temp = l3;
        for(int i=1;i<list.size();i++){
            temp.next=new test(list.get(i));
            temp=temp.next;
        }
        while(l3!=null){
            System.out.println(l3.val);
            l3=l3.next;
        }
        return l3;
    }
    public static void main(String[] args){
        test t1=new test(1);
        test t2=new test(2);
        test t3=new test(3);
        t1.next=t2;
        t2.next=t3;
        t1.mergeTwoLists(t1,t2);
    }
}