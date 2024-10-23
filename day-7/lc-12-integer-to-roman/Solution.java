public class Solution {
    public String intToRoman(int num) {
        String[] onesPlace = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tensPlace = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundredsPlace = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; 
        String[] thousandsPlace = {"", "M", "MM", "MMM"}; // because of num range 1 <= num <= 3999

        return thousandsPlace[num/1000] + hundredsPlace[(num%1000)/100] + tensPlace[(num%100)/10] + onesPlace[num%10];
        // (num%1000)/100: extracts the digit in the hundreds place after removing thousands
        // (num%100)/10 -> extracts the digit in the tens place after removing thousands and hundreds
        // num%10 -> extracts the digit in the ones place after removing thousands, hundreds, and tens
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        System.out.println(sol.intToRoman(3749));
        System.out.println(sol.intToRoman(58));
        System.out.println(sol.intToRoman(1994));
    }
}