// Last updated: 7/10/2025, 9:00:07 AM
bool isPalindrome(int x) {
 if (x < 0) {
        return false;
    }
    int a = x;
    long b = 0;
    while (x > 0) {
        int digit = x % 10;
        b = b * 10 + digit;
        x /= 10;
    }
    return a == b;
}