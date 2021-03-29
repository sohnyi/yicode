public class Solution859 {
    public boolean buddyStrings(String a, String b) {
        if (a.length() == b.length()) {
            char[] charsA = a.toCharArray();
            char[] charsB = a.toCharArray();
            int diff1 = 0;
            int diff2 = 0;
            int diffNum = 0;
            for (int i = 0; i < a.length(); i++) {
                if (charsA[i] != charsB[i]) {
                    diffNum += 1;
                    if (diffNum == 1) {
                        diff1 = i;
                    } else if (diffNum == 2) {
                        diff2 = i;
                    } else {
                        return false;
                    }
                }
            }

            if (diffNum == 2) {
                char temp = charsA[diff1];
                charsA[diff1] = charsA[diff2];
                charsA[diff2] = temp;
                String swapA = new String(charsA);
                return swapA.equals(b);
            } else if (diffNum == 0) {
                int[] counter = new int[26];
                for (int i = 0; i < a.length(); i++) {
                    counter[charsA[i] - 'a'] += 1;
                }
                for (int i = 0; i < counter.length; i++) {
                    if (counter[i] >= 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution859 s = new Solution859();
        System.out.println(s.buddyStrings("aa", "bb"));
        System.out.println(s.buddyStrings("ab", "ab"));
        System.out.println(s.buddyStrings("ab", "ba"));
        System.out.println(s.buddyStrings("abab", "abab"));
    }
}
