package bluebridgecup;

public class A14_Hanoi {
    public static void main(String[] args) {
        hanoi(2,"1","2","3");
    }

    public static void hanoi(int n,String start,String middle,String end){
        if (n <= 1){
            System.out.println(start+"-->"+end);
        } else {
            hanoi(n -1,start,end,middle);
            System.out.println(start+"-->"+end);
            hanoi(n - 1,middle,start,end);
        }
    }
}
