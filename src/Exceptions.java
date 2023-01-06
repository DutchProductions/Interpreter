import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Exceptions {
    public static class Errors {
        public void TypeError(List<String> lines, String line, String reqType, String gaveType) {
            System.out.println(lines);
            System.out.println(line);
            int atLine = lines.indexOf(line);
            atLine++;

            System.out.println("ERROR at line <" + atLine + "> TypeError {" + line + "}. Asked for a " + reqType + ", but got a " + gaveType);
        }

        public void VarNotFoundError(@NotNull List<String> lines, String line, String var) {
            int atLine = lines.indexOf(line);
            atLine++;

            System.out.println("ERROR at line <" + atLine + "> VarNotFoundError {" + line + "}. Asked for variable \"" + var + "\"");
    }
    }
}
