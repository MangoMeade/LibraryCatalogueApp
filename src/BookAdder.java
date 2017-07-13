import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by jenny on 7/12/2017.
 */
public class Book extends CatalogueTextFile{
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        //Date dueDate = new Date(11/1/1970);
        SimpleDateFormat formatter1=new SimpleDateFormat("MM/dd/yyyy");
        Status onShelf = Status.ON_SHELF;
        Genre fiction = Genre.FICTION;
        String title;
        String author;
        String dueDate;
        Date dueDate1 = new Date (7/12/2017);
        Boolean braille;
        String status;
        String genre;

        System.out.println("Book title?");
        title = scnr.nextLine();
        System.out.println("Book author?");
        author = scnr.nextLine();
        System.out.println("Due Date?");
        dueDate = scnr.nextLine();
        try {
            dueDate1 = formatter1.parse(dueDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Is this book braille?");
        braille = scnr.nextBoolean();
        scnr.nextLine();
        System.out.println("Is the book on shelf? (Type Reserved, On Shelf or Checked out");
        status = scnr.nextLine();
        System.out.println("What is the book genre?");
        genre = scnr.nextLine();



        Book book1 = new Book(title, author, dueDate1, braille, Status.getEnumVersion(status), Genre.getEnumVersion(genre));
        writeToCatalogue(book1.getTitle() + " " + book1.getAuthor() + " " + book1.getDueDate() + " " + book1.getBraille() + " " + book1.getStatus() + " " + book1.getGenre());
        readFromCatalogue();
        //System.out.println(book1.getTitle());

    }
}
