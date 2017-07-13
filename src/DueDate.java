import java.time.LocalDate;
/**
 * Created by Grand Circus Student on 7/13/2017.
 */
public class DueDate {
    public static void main(String[] args) {

        LocalDate dueDate = LocalDate.now().plusWeeks(2);
        System.out.println(dueDate);
    }

}