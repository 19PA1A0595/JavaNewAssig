//2. Create a class with two (overloaded) constructors. Using this, call the second constructor inside the first one.

public class Assignment6_2 {
    static int val1;
    static int val2;
    Assignment6_2(){

        this(1,2);
    }
    Assignment6_2(int v1,int v2){
        this.val1=v1;
        this.val2=v2;
    }
    public static void main(String[] args) {
        Assignment6_2 test=new Assignment6_2();
        System.out.println(val1+"   "+val2);
    }
}