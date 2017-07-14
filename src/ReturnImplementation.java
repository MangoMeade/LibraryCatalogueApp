import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by jenny on 7/13/2017.
 */
public class ReturnImplementation {

    private Validator Validator = new Validator();

    public void runReturnLoop(ArrayList<Book> catalogue) {

        int returnSelection;

        LibraryImplementation libraryImpl = new LibraryImplementation();
        ArrayList<Book> checkedoutCatalogue = new ArrayList<>();

        for (Book book: catalogue) {
            if (book.getStatus()==Status.CHECKED_OUT){
                checkedoutCatalogue.add(book);
            }
        }

        libraryImpl.printCatalogue(checkedoutCatalogue);

        returnSelection = Validator.getInt("Which book would you like to return? (Please enter the line number): ", "Please enter a valid line number: ", 1, checkedoutCatalogue.size());

        returnToShelf(catalogue.get(returnSelection - 1));

        System.out.println("\nThank you. Your book was successfully returned! Returning to Main Menu.\n");
    }

    public void returnToShelf(Book returnedBook) {

        returnedBook.setStatus(Status.ON_SHELF);
        System.out.println("\n" + returnedBook.toConsoleFormat());

    }

}