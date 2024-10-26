import java.util.*; 
public class Solution {
    private static final int PRIME = 97; 

    // polynomial hash - prime multiplier
    public static long generateHash(String s, int length) {
        long store = 0; 

        for (int i = 0; i < length; i++)
            store += (s.charAt(i) * Math.pow(PRIME, i));
        return store; 
    }

    public static long recalculateHash(String str, int oldIndex, int newIndex, long oldHash, int patternLength) {
        long newHash = oldHash - str.charAt(oldIndex);
        newHash /= PRIME;
        newHash += str.charAt(newIndex) * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }
    public static List<Integer> search(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();
        List<Integer> result = new ArrayList<>();

        long patternHash = generateHash(pattern, m);
        long textHash = generateHash(text, m);


        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash && text.substring(i, i + m).equals(pattern)) {
                result.add(i); 
            }

            if (i < n - m) {
                textHash = recalculateHash(text, i, i + m, textHash, m);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "abracadabra";
        String pattern = "abra";
        List<Integer> indices = search(text, pattern);

        if (!indices.isEmpty()) {
            System.out.println("Pattern found at: " + indices);
        } else {
            System.out.println("Pattern not found.");
        }
    }
}