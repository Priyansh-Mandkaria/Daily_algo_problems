// Last updated: 10/14/2025, 11:09:16 PM
/*
 * Direct use of method - Defanging and ip address .
 * it is a very easy question just the use of the one of the string method 
 * address.replaceAll("\\.","[.]");
 * 
 * for regex expression 
 * 
 * we can also use 
 * address.replace(".","[.]") this will works
*/

class Solution {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.","[.]");
    }
}