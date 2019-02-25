package bluebridgecup;

public class A08_Reverse {
    public static void main(String[] args) {
        System.out.println(helper_str("12345"));;
    }

    private static String helper_str(String s) {
        if (s.length() == 0)return "";
        return helper_str(s.substring(1))+s.charAt(0);
    }
}
