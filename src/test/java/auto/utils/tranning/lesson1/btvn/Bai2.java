package auto.utils.tranning.lesson1.btvn;

public class Bai2 {
    /*
    Viết chương trình thực hiện thao tác với choỗi sau: Automation Testing Alphaway Tutorial Online :
    Đếm số lượng kí tự
    Kiểm tra choỗi có chứa từ Testing hay không
    Kiểm tra chỗi bắt đầu bằng từ Automation không
    Lấy vị trí của từ Tutorial trong choỗi
    Thay thế Online bằng offline
     */
    public static void main(String[] args) {
        String text = "Automation Testing Alphaway Tutorial Online";
        boolean checkExits = text.contains("Testing");
        boolean startText = text.startsWith("Automation");
        int indexText = text.indexOf("Tutorial");
        String replaceText = text.replace("Online", "offline");

        System.out.println("Kiểm tra chuỗi có chứa từ Testing hay không : " + checkExits);
        System.out.println("Kiểm tra chuỗi bắt đầu bằng từ Automation không : " + startText);
        System.out.println("vị trí của từ Tutorial trong chuỗi : " + indexText);
        System.out.println("Thay thế Online bằng offline : " + replaceText);
    }

}
