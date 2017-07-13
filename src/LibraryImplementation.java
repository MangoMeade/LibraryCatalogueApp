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
        menu.put(4, "Add a book"); //FIXME: Only Library Personnel?
        menu.put(5, "Exit");

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
                searchImpl.runSelectionLoop(catalogue); //Seach for a book
            } else if (menuSelection == 3) {
                //FIXMEcheckoutFromCatalogue(); //Checkout a book
            } else if (menuSelection == 4) {
                BookAdder adder = new BookAdder();
                adder.addBook();
            }
            if (menuSelection == 5) {
                break;
            }

        } while (menuSelection != 5);
    }

    public int menuSelection() {
        int menuSelection;

        System.out.println();
        menuSelection = Validator.getInt("Please enter a number from the Main Menu above: ", "Please enter a valid menu number: ", 1, 5);

        return menuSelection;
    }

    public void printCatalogue(ArrayList<Book> catalogue) {
        System.out.println("\nCurrent catalogue...");
        for (Book book : catalogue) {
            System.out.println(book);
        }
        System.out.println();
    }

}