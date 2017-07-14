import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by jenny on 7/13/2017.
 */
public class CheckoutImplementation {

    private Validator Validator = new Validator();

    public void runCheckoutLoop(ArrayList<Book> catalogue) {

        int checkoutSelection;

        System.out.println();
        checkoutSelection = Validator.getInt("Which book would you like to checkout? (Please enter the line number): ", "Please enter a valid line number: ", 1, catalogue.size());

        if(catalogue.get(checkoutSelection - 1).getStatus() == Status.ON_SHELF){
            System.out.println("\nCheckout successful...\n");
            dueDateCreation(catalogue.get(checkoutSelection - 1));
            System.out.println();
            System.out.println("Please stop by the circulation desk to pick up your book.\n");
        } else {
            System.out.println("\nSorry that book is no longer available. Returning to Main Menu.\n");
        }

    }

    public void dueDateCreation(Book checkoutBook) {

        checkoutBook.setDueDate(LocalDate.now().plusWeeks(2));
        checkoutBook.setStatus(Status.CHECKED_OUT);

        System.out.println(checkoutBook.toCheckoutFormat());

    }

}
