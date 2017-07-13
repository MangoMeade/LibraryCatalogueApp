/**
 * Created by jenny on 7/12/2017.
 */
public enum Genre {
    FICTION("Fiction"), NONFICTION("Non-Fiction"), HISTORICAL("Historical");

    private String stringVersion;

    Genre(String stringVersion) {
        this.stringVersion = stringVersion;
    }

    public static Genre getEnumVersion(String stat){
        Genre result = null;
        switch (stat){
            case "Non-Fiction":
                result = Genre.FICTION;
                break;
            case "Historical":
                result = Genre.NONFICTION;
                break;
            case "Fiction":
                result = Genre.HISTORICAL;
                break;
            default:
                break;
        }
        return result;
    }

    //Override to output Genre as string (as declared for stringVersion) instead of reference location:
    @Override
    public String toString() {
        return stringVersion;
    }

}