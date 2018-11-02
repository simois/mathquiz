package Console;

public class Message {
    public static final String MSG_ARROW_RIGHT = ">";
    public static final String MSG_CORRECT = Color.GREEN + "Correct" + Color.RESET;
    public static final String MSG_WRONG = Color.RED + "Wrong" + Color.RESET;
    public static final String COMMAND_QUIT = "q";

    public Message() {

    }

    /**
     * Print a specific symbol in console
     *
     * @param symbol
     */
    public static void printSymbol(String symbol) {
        System.out.print(symbol);
    }

    /**
     * Print specific symbol in console
     *
     * @param symbol
     */
    public static void printSymbol(String symbol, int numbers) {
        for (int i = 1; i <= numbers; i++) {
            printSymbol(symbol);
        }
        System.out.printf("%n");
    }

    /**
     * Print 60 specific symbols and insert empty line(s) before the current line or after
     *
     * @param symbol
     * @param emptyLineBefore
     * @param emptyLineAfter
     */
    public static void printSymbol(String symbol, int emptyLineBefore, int emptyLineAfter) {
        if (emptyLineBefore == 0 && emptyLineAfter == 0) {
            printSymbol(symbol, 60);
        }
        if (emptyLineBefore > 0 && emptyLineAfter == 0) {
            for (int i = 0; i < emptyLineBefore; i++) {
                System.out.printf("%n");
            }
            printSymbol(symbol, 60);
        }
        if (emptyLineAfter > 0 && emptyLineBefore == 0) {
            printSymbol(symbol, 60);
            for (int i = 0; i < emptyLineAfter; i++) {
                System.out.printf("%n");
            }
        }
        if (emptyLineBefore > 0 && emptyLineAfter > 0) {
            for (int i = 0; i < emptyLineBefore; i++) {
                System.out.printf("%n");
            }
            printSymbol(symbol, 60);
            for (int i = 0; i < emptyLineAfter; i++) {
                System.out.printf("%n");
            }
        }
    }

    /**
     *
     * @param answer
     * @param result
     * @return
     */
    public static String compare(int answer, int result) {
        return (answer == result) ? Message.MSG_CORRECT : Message.MSG_WRONG;
    }

    /**
     *
     * @param milliseconds
     * @return
     */
    public static String getDuration(long milliseconds) {
        long duration = milliseconds / 1000;
        int h = (int) (duration / (3600));
        int m = (int) ((duration - (h * 3600)) / 60);
        int s = (int) (duration - (h * 3600) - m * 60);


        //return String.format("%02d:%02d:%02d", h, m, s);
        if (h > 0) {
            //return h + " hours " + m + " minutes" + s + " seconds";
            return String.format("%02d%s %02d%s %02d%s", h, " hours", m, " minutes", s, " seconds");
        } else if (h < 0 && m > 0) {
            //return m + " minutes" + s + " seconds";
            return String.format("%02d%s %02d%s", m, " minutes", s, " seconds");
        } else if (h < 0 && m < 0 && s >= 0) {
            //return s + " seconds";
            return String.format("%02d%s", s, " seconds");
        } else {
            return String.format("%02d:%02d:%02d", h, m, s);
        }
    }

    /**
     *
     * @param correct
     * @param wrong
     * @return
     */
    public static int getScore(int correct, int wrong) {
        return wrong == 0 ? 100 : (int)Math.round(correct * 100.0 / (correct + wrong));
    }

    /**
     *
     * @param correct
     * @return
     */
    public static String printCorrectAnswer(int correct) {
        return (correct > 1) ? "Correct Answers: " : "Correct Answer: ";
    }

    /**
     *
     * @param wrong
     * @return
     */
    public static String printWrongAnswer(int wrong) {
        return (wrong > 1) ? "Wrong Answers: " : "Wrong Answer: ";
    }

    /**
     *
     * @param string
     * @return
     */
    public static String capitalize(String string) {
        char firstChar = string.toUpperCase().charAt(0);
        return Character.toString(firstChar) + string.substring(1).toLowerCase();
    }
}
