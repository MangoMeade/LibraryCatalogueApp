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
        ArrayList<Book> printCatalogue = new ArrayList<>();


        for (Book book: catalogue) {
            if (book.getStatus()==Status.CHECKED_OUT){
              printCatalogue.add(book);
            }

        }
        libraryImpl.printCatalogue(printCatalogue);

        returnSelection = Validator.getInt("Which book would you like to return? (Please enter the line number): ", "Please enter a valid line number: ", 1, 12);

        if(catalogue.get(returnSelection - 1).getStatus() == Status.CHECKED_OUT){
            dueDateCreation(catalogue.get(returnSelection - 1));
            System.out.println();
        } else if (catalogue.get(returnSelection - 1).getStatus() == Status.CHECKED_OUT) {
            System.out.println("Sorry that book is no longer available.");
        }

    }

    public void dueDateCreation(Book returnedBook) {

        returnedBook.setDueDate(LocalDate.now().plusWeeks(2));
        returnedBook.setStatus(Status.ON_SHELF);

        System.out.println(returnedBook);

    }

}