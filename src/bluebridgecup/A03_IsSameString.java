package bluebridgecup;

public class A03_IsSameString {


    private static boolean isSameString2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;//******边界********
        if (s1.length() == 0) return true;//******边界********

//        if (s1.charAt(0) != s2.charAt(0)) return false;
        if (s1.charAt(0) == s2.charAt(0)) return true;
        return isSameString2(s1.substring(1),s2.substring(1));
    }

    public static boolean isSameString1(String s1,String s2){
        return s1.equals(s2);
    }


    public static void main(String[] args) {
//        String s1 = "abc";
//        String s2 = "abcd";
//        System.out.println(isSameString1(s1,s2));
//        System.out.println(isSameString2(s1,s2));
    }
}
