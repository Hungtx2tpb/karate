package auto.utils.tranning.lesson1.btvn;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bai3 {
    // Tạo và in ngày giờ hiện tại
    //Tạo một ngày giờ cụ thể ( ngày 2024-01-01 lúc 18:30 )
    //Cộng và trừ thời gian từ ngày giờ hiện tại và hiển thị lên màn hình : Cộng thêm 2 tuần, Trừ đi 3 ngày, Cộng thêm 5 giờ
    //Định dạng và phân tích chuỗi ngày giờ hiện tại với format yyyy-MM-dd HH:mm:ss
    //Tính khoảng thời gian (date, time, datetime) giữa hai ngày giờ : 2024-01-01 18:00 -> 2024-01-11 20:00

    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now(); // Ngày và giờ hiện tại
        System.out.println("Tạo và in ngày giờ hiện tại : " + currentDateTime);

        LocalDateTime specificDateTime = LocalDateTime.of(2024, 01, 01, 18, 30);
        System.out.println(" Tạo một ngày giờ cụ thể :" + specificDateTime);

        LocalDateTime plusWeek = currentDateTime.plusWeeks(2);
        LocalDateTime minusDay = currentDateTime.minusDays(3);
        LocalDateTime plusHours = currentDateTime.plusHours(5);

        System.out.println("Cộng thêm 2 tuần : " + plusWeek);
        System.out.println("Trừ đi 3 ngày : " + minusDay);
        System.out.println("Cộng thêm 5 giờ : " + plusHours);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fromTime = LocalDateTime.parse("2024-01-01 18:00", formatter);
        LocalDateTime toTime = LocalDateTime.parse("2024-01-11 20:00", formatter);

        Duration duration = Duration.between(fromTime, toTime);
        System.out.println("Tính khoảng thời gian : " + duration.toString().substring(2));

        System.out.println(String.format("%s d %sh %sm %ss",
                duration.toDaysPart(),
                duration.toHoursPart(),
                duration.toMinutesPart(),
                duration.toSecondsPart()));
    }
}
