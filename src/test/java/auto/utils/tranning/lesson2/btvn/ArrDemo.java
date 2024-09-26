package auto.utils.tranning.lesson2.btvn;

public class ArrDemo {
    public static void main(String[] args) {
        int[] arrInt = {2,6,5,9,7};
        for (int i = 0; i < arrInt.length; i++) {
            int item = arrInt[i];
            System.out.println("Gia tri " + item);
            if(item%2 == 0) {
                System.out.println(item + " là số chẵn\n");
            } else {
                System.out.println(item + " là số lẻ\n");
            }
        }
    }
}
