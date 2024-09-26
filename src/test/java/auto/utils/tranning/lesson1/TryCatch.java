package auto.utils.tranning.lesson1;

public class TryCatch {

    public static void test() {
        int data = 50 / 0;  // ném ra ngoại lê ở đây
        System.out.println("rest of the code...");
    }

    public static void main(String[] args) {
//        test();
        try {
            int data = 50 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("Khối finally luôn được thực thi.");
        }
        System.out.println("rest of the code...");
    }
    //java.lang.ArithmeticException: / by zero
    //Khối finally luôn được thực thi.
    //rest of the code...

}
