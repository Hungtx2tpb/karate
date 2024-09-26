package auto.utils.tranning.lesson1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateAndTime {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now(); // Ngày hiện tại
        LocalDate specificDate = LocalDate.of(2023, 5, 19); // Ngày cụ thể
        System.out.println(currentDate);
        System.out.println(specificDate);

        LocalTime currentTime = LocalTime.now(); // Giờ hiện tại
        LocalTime specificTime = LocalTime.of(14, 30, 0); // Giờ cụ thể

        LocalDateTime currentDateTime = LocalDateTime.now(); // Ngày và giờ hiện tại
        LocalDateTime specificDateTime = LocalDateTime.of(2023, 5, 19, 14, 30);

        System.out.println(currentDateTime);
        System.out.println(specificDateTime);
        LocalDate date = currentDateTime.toLocalDate();
        LocalTime time = currentDateTime.toLocalTime();

        Duration duration = Duration.between(currentDateTime, specificDateTime);
        long days = duration.toDays();
        long hours = duration.toHours();

        int year = currentDateTime.getYear();
        int month = currentDateTime.getMonthValue();
        int day = currentDateTime.getDayOfMonth();

        LocalDateTime previousDay = currentDateTime.minusDays(1);
        LocalDateTime previousHour = currentDateTime.minusHours(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        String dateTimeString = "2023-05-19 14:30:00";
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeString, formatter);

        Date currentDateJavaUtil = new Date(); // import java.util.Date
        Calendar calendar = Calendar.getInstance(); // import java.util.Calendar


    }
}
