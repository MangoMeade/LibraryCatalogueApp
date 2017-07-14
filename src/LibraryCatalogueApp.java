import java.util.ArrayList;

/**
 * Created by jenny on 7/12/2017.
 */

//FIXME: After 7 (Return to Main Menu), 5 does not exit on the first attempt

//Console program to search library catalog and reserve books
public class LibraryCatalogueApp {

    private Validator Validator = new Validator();

    public static void main(String[] args) {

        intro();

    }

    public static void intro() {

        System.out.println("Welcome to the Barely Books Library Terminal:");

        TextFileReaderWriter reader = new TextFileReaderWriter();
        ArrayList<Book> catalogue = reader.readFromCatalogue();

        System.out.printf("There are " + catalogue.size() + " books in the library.\n\n");

        LibraryImplementation implementation = new LibraryImplementation();
        implementation.runMainLoop(catalogue);

        System.out.println("\nGoodbye. Thank you for visiting Barely Books!");
    }
}