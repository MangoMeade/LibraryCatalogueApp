import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Barely Books on 7/13/2017.
 */

public class BookAdder extends CatalogueTextFile{

    //Use Validator to validate user entries throughout:
    private Validator Validator = new Validator();

    //Add books to catalogue:
    public void addBook(ArrayList<Book> catalogue) {

        LocalDate dueDate = LocalDate.now();
        Book book = new Book();

        //Get book attributes from the user:
        book.setTitle(Validator.getString("Please enter the title of the book you would like to add? "));
        book.setAuthor(Validator.getString("Book author? "));
        book.setDueDate(dueDate);
        book.setBraille(Validator.getString("Is this book in Braille? (y/n) ", "Invalid entry. Please enter \"y\" or \"n\". ", "y", "n"));
        book.setStatus(Status.ON_SHELF);
        book.setGenre(Genre.getEnumVersion(Validator.getString("What is the book genre? (Biographical, Drama, Fiction, Nonfiction, Historical, Mystery) ").toLowerCase()));

        System.out.println();
        System.out.println("Thank you. Select option 1 below to confirm this book was properly added to the catalogue.");

        //Append the book to the library catalogue saved in "catalogue":
        TextFileReaderWriter fileWriter = new TextFileReaderWriter();
        fileWriter.fileWriter(book);

        //Add the book to the catalogue array:
        catalogue.add(book);

        TextFileReaderWriter reader = new TextFileReaderWriter();
        reader.readFromCatalogue();
    }
}

