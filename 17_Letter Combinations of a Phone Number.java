import java.util.*;

class test {
    public List<String> letterCombinations(String digits) {
        ArrayList<ArrayList> Result = new ArrayList<>();
        String[] letter2 = {"a","b","c"};
        String[] letter3 = {"d","e","f"};
        String[] letter4 = {"g","h","i"};
        String[] letter5 = {"j","k","l"};
        String[] letter6 = {"m","n","o"};
        String[] letter7 = {"p","q","r","s"};
        String[] letter8 = {"t","u","v"};
        String[] letter9 = {"w","x","y","z"};

        char[] digits_list = digits.toCharArray();
        ArrayList<String[]> Letter_List = new ArrayList<>();
        for(char c:digits_list){
            switch(c){
                case '2':
                    Letter_List.add(letter2);
                    break;
                case '3':
                    Letter_List.add(letter3);
                    break;
                case '4':
                    Letter_List.add(letter4);
                    break;
                case '5':
                    Letter_List.add(letter5);
                    break;
                case '6':
                    Letter_List.add(letter6);
                    break;
                case '7':
                    Letter_List.add(letter7);
                    break;
                case '8':
                    Letter_List.add(letter8);
                    break;
                case '9':
                    Letter_List.add(letter9);
                    break;
            }
        }
        for (int i=0;i<Letter_List.size();i++){
            if(i==0){
                ArrayList<String> temp= new ArrayList<>(Arrays.asList(Letter_List.get(i)));
                Result.add(i,temp);
            }else{
                ArrayList<String> temp = new ArrayList<>();
                for(int j=0;j<Result.get(i-1).size();j++){
                    for(String s:Letter_List.get(i)){
                        temp.add(Result.get(i-1).get(j)+s);
                    }
                }
                Result.add(i,temp);
            }

        }

        if(Result.isEmpty()){
            List list = new ArrayList();
            return list;
        }else return Result.get(Letter_List.size()-1);

     }

    public static void main(String[] args) {
        test t1 = new test();
        System.out.println(t1.letterCombinations("23"));
    }
}