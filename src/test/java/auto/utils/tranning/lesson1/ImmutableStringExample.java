package auto.utils.tranning.lesson1;

public class ImmutableStringExample {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = str1;

        System.out.println("str1: " + str1); // Kết quả: "Hello"
        System.out.println("str2: " + str2); // Kết quả: "Hello"

        str1 = str1 + ", World!";

        System.out.println("After modification:");
        System.out.println("str1: " + str1); // Kết quả: "Hello, World!"
        System.out.println("str2: " + str2); // Kết quả: "Hello"

        stringBuilderTest();
        stringBufferTest();
    }

    public void test() {
        String str = "hello";
        System.out.println("str lan 1 : " + str);

        str = "hello cac ban";
        System.out.println("str lan 2 : " + str);
    }

    public static void stringBuilderTest() {
        StringBuilder beforeString = new StringBuilder("Start ");
        beforeString.append("Hello");
        beforeString.append(", World!");
        String afterString = beforeString.toString();
        System.out.println("beforeString" + beforeString);
        System.out.println("afterString" + afterString);
    }

    public static void stringBufferTest() {
        StringBuffer sbf = new StringBuffer();
        sbf.append("Hello");
        sbf.append(", World!");
        String result = sbf.toString();
        System.out.println(result);
    }
}
