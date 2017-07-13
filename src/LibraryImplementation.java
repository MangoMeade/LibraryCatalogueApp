import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jenny on 7/13/2017.
 */
public class LibraryImplementation {

    private Validator Validator = new Validator();

    public void runMainLoop(ArrayList<Book> catalogue) {

        int menuSelection;

        HashMap<Integer, String> menu = new HashMap<>();
        menu.put(1, "See the complete Barely Books Library catalogue");
        menu.put(2, "Search for a book");
        menu.put(3, "Checkout a book");
        menu.put(4, "Return a book");
        menu.put(5, "Add a book"); //FIXME: Only Library Personnel?
        menu.put(6, "Exit");

        do {
            System.out.println("Main Menu:");
            for (HashMap.Entry<Integer, String> option : menu.entrySet()) {
                System.out.printf("%d - %s\n", option.getKey(), option.getValue());
            }

            menuSelection = menuSelection();

            if (menuSelection == 1) {
                printCatalogue(catalogue);//Display entire list of books
            } else if (menuSelection == 2) {
                SearchImplementation searchImpl = new SearchImplementation();
                searchImpl.runSelectionLoop(catalogue); //Search for a book
            } else if (menuSelection == 3) {
                printCatalogue(catalogue);//Display entire list of books
                CheckoutImplementation checkoutImpl = new CheckoutImplementation();
                checkoutImpl.runCheckoutLoop(catalogue);
            } else if (menuSelection == 4) {
                ReturnImplementation returnImpl = new ReturnImplementation();
                returnImpl.runReturnLoop(catalogue);
            } else if (menuSelection == 5) {
                /*BookAdder adder = new BookAdder();
                adder.addBook();*/
            }
            if (menuSelection == 6) {
                TextFileReaderWriter fileWriter = new TextFileReaderWriter();
                fileWriter.fileWriter(catalogue);
            }


            if (menuSelection == 6) {
                break;
            }

        } while (menuSelection != 6);
    }

    public int menuSelection() {
        int menuSelection;

        System.out.println();
        menuSelection = Validator.getInt("Please enter a number from the Main Menu above: ", "Please enter a valid menu number: ", 1, 6);

        return menuSelection;
    }

    public void printCatalogue(ArrayList<Book> catalogue) {
        System.out.println("\nCurrent catalogue...");

        int i = 1;

        for (Book book : catalogue) {
            System.out.println(i + " " + book);
            i = i + 1;
        }
        System.out.println();
    }

}