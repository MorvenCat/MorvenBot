package indi.morven;

public class test {
    static boolean flag = false;
    public static void main(String[] args) {
        if (!flag){
            System.out.println(666);
            flag=true;
        }else {
            System.out.println(666666);
        }
    }
}
