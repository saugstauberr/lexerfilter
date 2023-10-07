import java.util.Scanner;
import java.util.logging.Filter;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        FilterTime time = new FilterTime();
        FilterIP ip = new FilterIP();

        System.out.println("Do you want to filter IP addresses or time formats? (IP/Time): ");
        String response = reader.next();
        switch(response) {
            case "IP":
                System.out.println(ip.GiveIP("src/main/resources/Text.txt"));
                return;
            case "Time":
                System.out.println(time.GiveTime("src/main/resources/Text.txt"));
        }
        reader.close();
    }
}
