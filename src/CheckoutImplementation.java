import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by jenny on 7/13/2017.
 */
public class CheckoutImplementation {

    private Validator Validator = new Validator();

    public void runCheckoutLoop(ArrayList<Book> catalogue) {

        int checkoutSelection;

        LibraryImplementation libraryImpl = new LibraryImplementation();
        libraryImpl.printCatalogue(catalogue);

        checkoutSelection = Validator.getInt("Which book would you like to checkout? (Please enter the line number): ", "Please enter a valid line number: ", 1, 12);

        if(catalogue.get(checkoutSelection - 1).getStatus() == Status.ON_SHELF){
            dueDateCreation(catalogue.get(checkoutSelection - 1));
            System.out.println();
        } else if (catalogue.get(checkoutSelection - 1).getStatus() == Status.CHECKED_OUT) {
            System.out.println("Sorry that book is no longer available.");
        }

    }

    public void dueDateCreation(Book checkoutBook) {

        checkoutBook.setDueDate(LocalDate.now().plusWeeks(2));
        checkoutBook.setStatus(Status.CHECKED_OUT);

        System.out.println(checkoutBook);

    }

}
