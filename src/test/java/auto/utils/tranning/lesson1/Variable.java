package auto.utils.tranning.lesson1;

public class Variable {
    static int NUMBER = 1;
    static String STRING = "ALPHAWAY";
    private int age; // 1
    protected String firstName; // 1
    // int class; // Sai 2
    public int myClass; // Đúng 2
    int numberOfStudents; // 4
    String customerName; // 4
    int count; // Tốt  - 5
    int c; // Không rõ ràng  - 5
    //    int i; // Quá ngắn  - 6
    int numberOfActiveUsersOnTheWebsite; // Quá dài - 6
    int userCount; // Vừa đủ - 6
    boolean isAvailable; // 7
    boolean hasFinished; // 7
    boolean canExecute; // 7
    String result = (10 > 0) ? "Số là số dương." : (10 < 0) ? "Số là số âm." : "Số bằng 0.";

    public static void main(String[] args) {
        String fruit = "Apple";
        String color;
        switch (fruit) {
            case "Apple":
                String localVariable = "Hello";
                color = "Red";
                break;
            case "Banana":
                color = "Yellow";
                break;
            case "Grapes":
                color = "Purple";
                break;
            default:
                color = "Unknown";
                break;
        }
        System.out.println("The color of " + fruit + " is " + color);
//        System.out.println(localVariable);

//      Đọc giá trị từ biến static
        System.out.println(Variable.NUMBER);
        System.out.println(Variable.STRING);

//      Gán giá trị mới cho biến static
        Variable.NUMBER = 5;
        System.out.println(Variable.NUMBER);


        for (int i = 0; i < 6; i++) {
            System.out.println(i);
        }

    }

    private static void localVariable(){
        String variable = "Hello";
        System.out.println(variable);
        //3.14
        double pi = 3.14;
    }


}
