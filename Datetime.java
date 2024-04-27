//Question no: 1
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Datetime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first date (YYYY-MM-DD): ");
        String firstDateString = scanner.nextLine();
        LocalDate firstDate = LocalDate.parse(firstDateString);

        System.out.println("Enter the second date (YYYY-MM-DD): ");
        String secondDateString = scanner.nextLine();
        LocalDate secondDate = LocalDate.parse(secondDateString);

        long difference = Math.abs(ChronoUnit.DAYS.between(firstDate, secondDate));
        System.out.println("The difference between the two dates is: " + difference + " days");

        scanner.close();
    }
}
//Question no:2
import java.util.Scanner;

public class Datetime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter time in 24-hour format (e.g., 14:23): ");
        String time24 = scanner.nextLine();
        
        String time12 = convertTo12HourFormat(time24);
        
        System.out.println("Time in 12-hour format: " + time12);
        
        scanner.close();
    }
    
    public static String convertTo12HourFormat(String time24) {
        int hour = Integer.parseInt(time24.split(":")[0]);
        int minute = Integer.parseInt(time24.split(":")[1]);
        
        String period = (hour < 12) ? "AM" : "PM";
        
        if (hour == 0) {
            hour = 12;
        } else if (hour > 12) {
            hour -= 12;
        }
        
        return String.format("%d:%02d%s", hour, minute, period);
    }
}
//Question no:3
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Datetime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your birth date (YYYY-MM-DD): ");
        String birthDateStr = scanner.next();

        LocalDate birthDate = LocalDate.parse(birthDateStr);

        LocalDate currentDate = LocalDate.now();

        Period age = Period.between(birthDate, currentDate);

        System.out.println("You are " + age.getYears() + " years old.");
    }
}
//Question no:4
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Datetime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a date string in the format 'yyyy-MM-dd': ");
        String dateString = scanner.nextLine();

        try {
            LocalDate date = LocalDate.parse(dateString);
            System.out.println("Parsed date: " + date);
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format. Please enter a date in the format 'yyyy-MM-dd'.");
        }
    }
}
//Question no: 5
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Datetime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the event start time (yyyy-MM-dd HH:mm): ");
        String startTimeStr = scanner.nextLine();
        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        System.out.print("Enter the event end time (yyyy-MM-dd HH:mm): ");
        String endTimeStr = scanner.nextLine();
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        Duration duration = Duration.between(startTime, endTime);

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        System.out.println("Duration of the event: " + hours + " hours and " + minutes + " minutes.");
    }
}
//Question no:7
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Datetime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the reminder date and time (yyyy-MM-dd HH:mm): ");
        String dateTimeStr = scanner.nextLine();
        LocalDateTime reminderDateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        System.out.print("Enter the reminder message: ");
        String reminderMessage = scanner.nextLine();

        long delay = java.time.Duration.between(LocalDateTime.now(), reminderDateTime).toMillis();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Reminder: " + reminderMessage);
                timer.cancel(); 
            }
        }, delay);
    }
}
//Question no: 8
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Datetime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime currentDateTime = LocalDateTime.now();

        LocalDateTime userDateTime = null;
        boolean isValidDateTime = false;
        while (!isValidDateTime) {
            System.out.print("Enter the date and time (yyyy-MM-dd HH:mm): ");
            String dateTimeStr = scanner.nextLine();

            try {
                userDateTime = LocalDateTime.parse(dateTimeStr, dateTimeFormatter);
                if (userDateTime.isAfter(currentDateTime)) {
                    isValidDateTime = true;
                } else {
                    System.out.println("Error: Please enter a future date and time.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid date and time format. Please enter in the format 'yyyy-MM-dd HH:mm'.");
            }
        }

        System.out.println("Validated date and time: " + userDateTime.format(dateTimeFormatter));
    }
}