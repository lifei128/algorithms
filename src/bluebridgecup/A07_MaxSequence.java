package bluebridgecup;

public class A07_MaxSequence {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "xbacd";
        int x = helper(s1,s2);
        System.out.println(x);
    }

    private static int helper(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0)return 0;
        if (s1.charAt(0) == s2.charAt(0)){
            return 1 + helper(s1.substring(1),s2.substring(1));
        } else {
            return Math.max(helper(s1,s2.substring(1)),helper(s1.substring(1),s2));
        }
    }
}
