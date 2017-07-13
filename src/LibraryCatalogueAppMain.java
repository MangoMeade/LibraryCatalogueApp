import java.util.ArrayList;

/**
 * Created by jenny on 7/12/2017.
 */

//FIXME: Merge classes into one project (all classes need addressed)
//FIXME: After 7 (Return to Main Menu), 5 does not exit on the first attempt
//FIXME: Checkout? If so, call Checkout method
//FIXME:      ...Validate status - update status - change due date (date default for on-shelf)
//FIXME: Print back to file
//FIXME: Utilize enums and dates (convert from imported strings?)
//FIXME: Utilize additional Classes - Adult, Teen, Kid
//FIXME: Option to add book - merge
//FIXME: Add GUI

//Console program to search library catalog and reserve books
public class LibraryCatalogueAppMain {

    private Validator Validator = new Validator();

    public static void main(String[] args) {

        intro();

    }

    public static void intro() {

        System.out.println("Welcome to the Barely Books Library Terminal:\nThere are 12 books in the library.\n");

        TextFileReaderWriter reader = new TextFileReaderWriter();
        ArrayList<Book> catalogue = reader.readFromCatalogue();

        LibraryImplementation implementation = new LibraryImplementation();
        implementation.runMainLoop(catalogue);

        System.out.println("\nGoodbye. Thank you for visiting Barely Books!");
    }
}