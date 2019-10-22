class Solution {
    public int primePalindrome(int N) {
        while (true) {
            if (isPalindrome(N)&&isPrime(N))
                return N;
            N++;

            if(10000000<N&&N<100000000)      //skip 8 digits because all palindromes with even digits are not prime except 11, try to exclude all even digits N but find out it takes more time to determine whether it is even or not
                N = 100000000;               //so we skip 8 digits which is relatively large
        }
    }

    private boolean isPrime(int N) {
        if (N < 2)
            return false;

        int sqrt = (int) Math.sqrt(N);
        for (int i = 2; i <= sqrt; i++) {
            if (N % i == 0)
                return false;
        }
        return true;
    }

    private boolean isPalindrome(int N) {
        int n = N;
        int rev = 0;
        while (n > 0) {
            rev = 10 * rev + n % 10;
            n /= 10;
        }
        if (N == rev)
            return true;
        return false;
    }
}