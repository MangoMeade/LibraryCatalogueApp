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

        final int MAX_ENTRY = menu.size();

        do {
            System.out.printf("----------------------------------------------------------------------------------------------------\n");
            System.out.println("Main Menu: Which action would you like to perform?");
            System.out.printf("----------------------------------------------------------------------------------------------------\n");

            for (HashMap.Entry<Integer, String> option : menu.entrySet()) {
                System.out.printf("%d - %s\n", option.getKey(), option.getValue());
            }

            menuSelection = menuSelection(MAX_ENTRY);

            if (menuSelection == 1) {
                printCatalogue(catalogue);//Display entire list of books
            } else if (menuSelection == 2) {
                SearchImplementation searchImpl = new SearchImplementation();
                searchImpl.runSelectionLoop(catalogue); //Search for a book
            } else if (menuSelection == 3) {
                CheckoutImplementation checkoutImpl = new CheckoutImplementation();
                checkoutImpl.runCheckoutLoop(catalogue);
            } else if (menuSelection == 4) {
                ReturnImplementation returnImpl = new ReturnImplementation();
                returnImpl.runReturnLoop(catalogue);
            } else if (menuSelection == 5) {
                BookAdder adder = new BookAdder();
                adder.addBook();
            }
            if (menuSelection == MAX_ENTRY) {
                TextFileReaderWriter fileWriter = new TextFileReaderWriter();
                fileWriter.fileWriter(catalogue);
            }


            if (menuSelection == MAX_ENTRY) {
                break;
            }

        } while (menuSelection != MAX_ENTRY);
    }

    public int menuSelection(int MAX_ENTRY) {
        int menuSelection;

        System.out.println();
        menuSelection = Validator.getInt("Please enter a number from the Main Menu above: ", "Please enter a valid menu number: ", 1, MAX_ENTRY);

        return menuSelection;
    }

    public void printCatalogue(ArrayList<Book> consoleCatalogue) {
        System.out.println("\nCurrent catalogue...");
        System.out.println();

        int i = 1;

        for (Book book : consoleCatalogue) {
            System.out.print(i + " " + book.getTitle() + " " + book.getAuthor() + " " + book.getGenre() + " " + book.getBraille() + " " + book.getStatus());
            i = i + 1;
            if (book.getStatus()==Status.CHECKED_OUT){
                System.out.print(" " + book.getDueDate());
            }
            System.out.println();
        }
        System.out.println();
    }

}