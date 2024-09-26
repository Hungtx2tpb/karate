package auto.utils.tranning.lesson2;

public class SwitchCaseDemo {
    public static void main(String[] args) {
        String fruit = "Apple";
        String color;
        switch (fruit) {
            case "Apple":
                color = "red";
                break;
            case "Banana":
                color = "Yellow";
                break;
            case "Grapes":
                color = "Purple";
                break;
            default:
                color = "UnKnow";
                break;
        }
        System.out.println("The color of " + fruit + " is " + color);
    }

}
