import java.util.ArrayList;
import java.util.Arrays;

public class Utils {
    public static class String {
        public java.util.List<java.lang.String> stripToList(java.lang.String string) {
            return Arrays.asList(string.split("\\s"));
        }
        public ArrayList<java.lang.String> stripToArray(java.lang.String string) {
            return new ArrayList<>(stripToList(string));
        }
    }

}
