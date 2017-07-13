import java.util.Date;

/**
 * Created by jenny on 7/12/2017.
 */
public class Kid extends Book {

    private Boolean boardBook;

    public Kid(String title, String author, Date dueDate, Boolean braille, Status status, Genre genre, Boolean boardBook) {
        super(title, author, dueDate, braille, status, genre);
        this.boardBook = boardBook;
    }

    public Boolean getBoardBook() {
        return boardBook;
    }

    public void setBoardBook(Boolean boardBook) {
        this.boardBook = boardBook;
    }
}