import java.util.*;

@SuppressWarnings("ReassignedVariable")
public class Main {

    public static void main(String[] mainArgs) {
        Utils.String stringUtils = new Utils.String();

        Exceptions.Errors errors = new Exceptions.Errors();

        List<String> lines = new ArrayList<>();
        Map<String, Object> inputs = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        lines.add("out hello");
        lines.add("out world");
        lines.add("save int cyka");
        lines.add("get cyka");
        lines.add("save str cyka");

        for (String line : lines) {
            if (line.startsWith("out ")) {
                line = line.replace("out ", "");
                System.out.println(line);
            } else if (line.startsWith("save ")) {
                line = line.replace("save ", "");
                ArrayList<String> args = stringUtils.stripToArray(line);

                switch (args.get(0)) {
                    case "int" -> {
                        try {
                            Integer input = sc.nextInt();
                            inputs.put(args.get(1), input);
                        } catch (InputMismatchException e) {
                            errors.TypeError(lines, "save " + line, "int", "str");
                        }
                    }
                    case "str" -> {
                        try {
                            String input = sc.next();
                            inputs.put(args.get(1), input);
                        } catch (InputMismatchException e) {
                            errors.TypeError(lines, "save " + line, "str", "int");
                        }
                    }
                }
            } else if (line.startsWith("get ")) {
                line = line.replace("get ", "");

                if (inputs.containsKey(line)) {
                    System.out.println(inputs.get(line));
                } else {
                    errors.VarNotFoundError(lines, "get " + line, line);
                }
            }
        }
        System.out.println("Press any key and ENTER to stop.");
        sc.next();
    }
}