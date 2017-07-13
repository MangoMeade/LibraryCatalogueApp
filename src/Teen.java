import java.util.Date;

/**
 * Created by jenny on 7/12/2017.
 */
public class Teen extends Book {

    private Boolean comingOfAge;

    public Teen(String title, String author, Date dueDate, Boolean braille, Status status, Genre genre, Boolean comingOfAge) {
        super(title, author, dueDate, braille, status, genre);
        this.comingOfAge = comingOfAge;
    }

    public Boolean getComingOfAge() {
        return comingOfAge;
    }

    public void setComingOfAge(Boolean comingOfAge) {
        this.comingOfAge = comingOfAge;
    }
}
