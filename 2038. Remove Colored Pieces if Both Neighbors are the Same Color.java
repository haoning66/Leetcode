class Solution {
    public boolean winnerOfGame(String colors) {
        if (colors.length() < 3)
            return false;
        
        char[] arr = colors.toCharArray();
        
        int A = 0;
        int B = 0;
        int a = 0;
        int b = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'A') {
                if (b >= 3)
                    B += b - 2;   
                b = 0;
                a += 1;
            } else {
                if (a >= 3)
                    A += a - 2;
                a = 0;
                b += 1;
            }
        }
        if (b >= 3)
            B += b - 2;
        
        if (a >= 3)
            A += a - 2;
        
        return A > B ? true : false;
    }
}
