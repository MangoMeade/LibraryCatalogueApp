import java.util.Date;

/**
 * Created by jenny on 7/12/2017.
 */
public class Adult extends Book {

    private Boolean censored;
    private Boolean largePrint;

    public Adult(String title, String author, Date dueDate, Boolean braille, Status status, Genre genre, Boolean censored, Boolean largePrint) {
        super(title, author, dueDate, braille, status, genre);
        this.censored = censored;
        this.largePrint = largePrint;
    }

    public Boolean getCensored() {
        return censored;
    }

    public void setCensored(Boolean steamy) {
        this.censored = censored;
    }

    public Boolean getLargePrint() {
        return largePrint;
    }

    public void setLargePrint(Boolean largePrint) {
        this.largePrint = largePrint;
    }
}
