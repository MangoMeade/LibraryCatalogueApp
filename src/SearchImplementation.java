import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jenny on 7/13/2017.
 */
public class SearchImplementation {

    private Validator Validator = new Validator();

    public void runSelectionLoop(ArrayList<Book> catalogue) {

        int attributeSelection;

        HashMap<Integer, String> attributeMenu = new HashMap<>();

        attributeMenu.put(1, "Title");
        attributeMenu.put(2, "Author");
        attributeMenu.put(3, "Genre");
        attributeMenu.put(4, "Return to Main Menu");

        do {
            System.out.println();
            System.out.println("Search Menu (Select Attribute to Search by):");

            for (HashMap.Entry<Integer, String> option : attributeMenu.entrySet()) {
                System.out.printf("%d - %s\n", option.getKey(), option.getValue());
            }

            attributeSelection = attributeSelection();

            if (attributeSelection != 7) {

                System.out.println();
                String searchString = (Validator.getString("Please enter a word to search by: "));

                attributeSearch(catalogue, attributeSelection, searchString);
            }

        } while (attributeSelection != 4);

        LibraryImplementation implementation = new LibraryImplementation();
        implementation.runMainLoop(catalogue);
    }

    public int attributeSelection() {
        int attributeSelection;

        System.out.println();
        attributeSelection = Validator.getInt("Please enter a number from the Search Menu above: ", "Please enter a valid menu number: ", 1, 4);

        return attributeSelection;
    }

    public void attributeSearch(ArrayList<Book> catalogue, int attributeSelection, String searchString) {
        String attribute = null;

//If Contains:
        //Find titles containing the entered search word and print list to console:
        for (Book book : catalogue) {
            if (attributeSelection == 1) {
                attribute = book.getTitle();
            } else if (attributeSelection == 2) {
                attribute = book.getAuthor();
            } else if (attributeSelection == 3) {
                System.out.println(book.getGenre());
                attribute = book.getGenre().toString();

            } else {
                attribute = book.getTitle(); //FIXME - default to what?
            }
            if (containsIgnoreCase(attribute, searchString)) {
                System.out.println(book);
            }
        }
    }

    public boolean containsIgnoreCase(String str, String searchStr) {
        if (str == null || searchStr == null) return false;

        final int length = searchStr.length();
        if (length == 0)
            return true;

        for (int i = str.length() - length; i >= 0; i--) {
            if (str.regionMatches(true, i, searchStr, 0, length))
                return true;
        }
        return false;
    }

}