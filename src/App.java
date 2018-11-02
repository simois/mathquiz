import Console.Color;
import Console.Message;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static String testerName;

    public App() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        testerName = reader.nextLine();
        Message.printSymbol("\n" + Color.BLUE + "Have a fun!" + Color.RESET);
    }

    /**
     * Definition of mathematical operations list
     */
    public static final String[] operations = {
            Color.GREEN + "Addition" + Color.RESET,             // Addition
            Color.GREEN + "Subtraction" + Color.RESET,          // Subtraction
            Color.GREEN + "Multiplication" + Color.RESET,       // Multiplication
            Color.GREEN + "Mixture" + Color.RESET               // Mixture of operations
    };

    public static void run() {
        index();
    }

    /**
     * Math operation for addition
     *
     */
    public static void addition() {
        App.printHeader(1);

        Scanner input = new Scanner(System.in);

        System.out.print("How many ADDITION quiz do you want to try? ");

        int numberOfQuiz = getIntNumber(input);

        ArrayList<String> list = new ArrayList<>();

        int countCorrect = 0;
        int countWrong = 0;
        String question = "";

        long startTime = System.currentTimeMillis();

        while (numberOfQuiz > 0) {

            int number1 = Operation.randomInt(1, 100);
            int number2 = Operation.randomInt(1, 100);

            question = number1 + " + " + number2 + " = ? ";

            System.out.print(question);

            int answer = getIntNumber(input);

            question += answer;

            if (answer == Operation.add(number1, number2)) {
                countCorrect++;
                System.out.println(Message.MSG_CORRECT + "\n");
                question += " --> " + Message.MSG_CORRECT + " ";
                list.add(question);
            } else {
                countWrong++;
                System.out.println(Message.MSG_WRONG + "\n");
                question += " --> " + Message.MSG_WRONG + " --> "
                        + number1 + " + " + number2 + " = " + Operation.add(number1, number2) + " ";
                list.add(question);
            }

            numberOfQuiz--;
        }

        long endTime = System.currentTimeMillis();

        System.out.print("Would you like to see your scores? (Y / N) ");
        char optionYOrN = input.next().toLowerCase().charAt(0);

        if ((int)optionYOrN == 121) {
            printResult(countCorrect, countWrong, endTime, startTime, list);
        }

        App.printFooter();
    }

    /**
     * Math operation for subtraction
     *
     */
    public static void subtraction() {
        App.printHeader(2);

        Scanner input = new Scanner(System.in);

        System.out.print("How many SUBTRACTION quiz do you want to try? ");

        int numberOfQuiz = getIntNumber(input);

        ArrayList<String> list = new ArrayList<>();

        int countCorrect = 0;
        int countWrong = 0;
        String question = "";

        long startTime = System.currentTimeMillis();

        while (numberOfQuiz > 0) {

            int number1 = Operation.randomInt(1, 100);
            int number2 = Operation.randomInt(1, 100);

            int max = Operation.max(number1, number2);
            int min = Operation.min(number1, number2);

            question = max + " - " + min + " = ? ";

            System.out.print(question);

            int answer = getIntNumber(input);

            question += answer;

            if (answer == Operation.substract(max, min)) {
                countCorrect++;
                System.out.println(Message.MSG_CORRECT + "\n");
                question += " --> " + Message.MSG_CORRECT + " ";
                list.add(question);
            } else {
                countWrong++;
                System.out.println(Message.MSG_WRONG + "\n");
                question += " --> " + Message.MSG_WRONG + " --> "
                        + max + " - " + min + " = " + Operation.substract(max, min) + " ";
                list.add(question);
            }

            numberOfQuiz--;
        }

        long endTime = System.currentTimeMillis();

        System.out.print("Would you like to see your scores? (Y / N) ");
        char optionYOrN = input.next().toLowerCase().charAt(0);

        if ((int)optionYOrN == 121) {
            printResult(countCorrect, countWrong, endTime, startTime, list);
        }

        App.printFooter();
    }

    /**
     * Math operation for multiplication
     *
     */
    public static void multiplication() {
        App.printHeader(3);

        Scanner input = new Scanner(System.in);

        System.out.print("How many MULTIPLICATION quiz do you want to try? ");

        int numberOfQuiz = getIntNumber(input);

        ArrayList<String> list = new ArrayList<>();

        int countCorrect = 0;
        int countWrong = 0;
        String question = "";

        long startTime = System.currentTimeMillis();

        while (numberOfQuiz > 0) {

            int number1 = Operation.randomInt(1, 9);
            int number2 = Operation.randomInt(1, 9);

            question = number1 + " x " + number2 + " = ? ";

            System.out.print(question);

            int answer = getIntNumber(input);

            question += answer;

            if (answer == Operation.multiply(number1, number2)) {
                countCorrect++;
                System.out.println(Message.MSG_CORRECT + "\n");
                question += " --> " + Message.MSG_CORRECT + " ";
                list.add(question);
            } else {
                countWrong++;
                System.out.println(Message.MSG_WRONG + "\n");
                question += " --> " + Message.MSG_WRONG + " --> "
                        + number1 + " x " + number2 + " = " + Operation.multiply(number1, number2) + " ";
                list.add(question);
            }

            numberOfQuiz--;
        }

        long endTime = System.currentTimeMillis();

        System.out.print("Would you like to see your scores? (Y / N) ");
        char optionYOrN = input.next().toLowerCase().charAt(0);

        if ((int)optionYOrN == 121) {
            printResult(countCorrect, countWrong, endTime, startTime, list);
        }

        App.printFooter();
    }


    /**
     * Math operation for addition, subtraction and multiplication
     *
     */
    public static void mixture() {
        App.printHeader(4);

        Scanner input = new Scanner(System.in);

        System.out.print("How many MIXED quiz do you want to try? ");

        int numberOfQuiz = getIntNumber(input);

        ArrayList<String> list = new ArrayList<>();

        int countCorrect = 0;
        int countWrong = 0;
        String question = "";

        long startTime = System.currentTimeMillis();

        while (numberOfQuiz > 0) {

            int number1 = Operation.randomInt(1, 100);
            int number2 = Operation.randomInt(1, 100);

            int number3 = Operation.randomInt(1, 9);
            int number4 = Operation.randomInt(1, 9);

            int randomOperation = Operation.randomInt(1, 3);
            int answer;

            switch (randomOperation) {
                case 1:
                    question = number1 + " + " + number2 + " = ? ";

                    System.out.print(question);

                    answer = getIntNumber(input);

                    question += answer;

                    //Message.compare(answer, Operation.add(number1, number2));

                    if (answer == Operation.add(number1, number2)) {
                        countCorrect++;
                        System.out.println(Message.MSG_CORRECT + "\n");
                        question += " --> " + Message.MSG_CORRECT + " ";
                        list.add(question);
                    } else {
                        countWrong++;
                        System.out.println(Message.MSG_WRONG + "\n");
                        question += " --> " + Message.MSG_WRONG + " --> "
                                + number1 + " x " + number2 + " = " + Operation.add(number1, number2) + " ";
                        list.add(question);
                    }
                    break;
                case 2:
                    int max = Operation.max(number1, number2);
                    int min = Operation.min(number1, number2);

                    question = max + " - " + min + " = ? ";

                    System.out.print(question);

                    answer = getIntNumber(input);

                    question += answer;

                    if (answer == Operation.substract(max, min)) {
                        countCorrect++;
                        System.out.println(Message.MSG_CORRECT + "\n");
                        question += " --> " + Message.MSG_CORRECT + " ";
                        list.add(question);
                    } else {
                        countWrong++;
                        System.out.println(Message.MSG_WRONG + "\n");
                        question += " --> " + Message.MSG_WRONG + " --> "
                                + max + " - " + min + " = " + Operation.substract(max, min) + " ";
                        list.add(question);
                    }
                    break;
                case 3:
                    question = number3 + " x " + number4 + " = ? ";

                    System.out.print(question);

                    answer = getIntNumber(input);

                    question += answer;

                    if (answer == Operation.multiply(number3, number4)) {
                        countCorrect++;
                        System.out.println(Message.MSG_CORRECT + "\n");
                        question += " --> " + Message.MSG_CORRECT + " ";
                        list.add(question);
                    } else {
                        countWrong++;
                        System.out.println(Message.MSG_WRONG + "\n");
                        question += " --> " + Message.MSG_WRONG + " --> "
                                + number3 + " x " + number4 + " = " + Operation.multiply(number3, number4) + " ";
                        list.add(question);
                    }
                    break;
            }

            numberOfQuiz--;
        }

        long endTime = System.currentTimeMillis();

        System.out.print("Would you like to see your scores? (Y / N) ");
        char optionYOrN = input.next().toLowerCase().charAt(0);

        if ((int)optionYOrN == 121) {
            printResult(countCorrect, countWrong, endTime, startTime, list);
        }

        App.printFooter();
    }

    /**
     *
     * @param correct
     * @param wrong
     * @param endTime
     * @param startTime
     * @param list
     */
    public static void printResult(int correct, int wrong, long endTime, long startTime, ArrayList<String> list) {
        String format = "| %1$-28s| %2$-39s|\n";
        String score = Message.getScore(correct, wrong) + "";
        String correctNumber = correct + "";
        String wrongNumber = wrong + "";

        System.out.println("+-----------------------------------------------------------+");
        System.out.println("|                       Testing Result                      |");
        System.out.println("+-----------------------------+-----------------------------+");
        System.out.format(format, "Tester", Color.BLUE + Message.capitalize(App.getTesterName()) + Color.RESET);
        System.out.format(format, "Score", Color.BLUE + score + Color.RESET);
        System.out.format(format, "Duration", Color.BLUE + Message.getDuration(endTime - startTime) + Color.RESET);
        System.out.format(format, Message.printCorrectAnswer(correct), Color.GREEN + correctNumber + Color.RESET);
        System.out.format(format, Message.printWrongAnswer(wrong), Color.RED + wrongNumber + Color.RESET);
        System.out.println("+-----------------------------+-----------------------------+");


        for (String element: list) {
            System.out.format("| %1$-69s|\n", element);
            System.out.format("| %1$-58s|\n", " ");
        }
        System.out.println("+-----------------------------------------------------------+");
    }

    /**
     * Display a question list for options
     *
     * @return
     */
    public static void index() {

        Message.printSymbol("=", 1, 0);
        System.out.printf("%45s%n", Color.BLUE_BOLD + "MATH QUIZ" + Color.RESET);
        Message.printSymbol("-", 60);
        System.out.printf(" %s  %s          %n", Color.YELLOW + "NO.", "OPERATIONS" + Color.RESET);
        Message.printSymbol("=", 60);

        for (int i = 1; i <= 4; i++) { // 4 Operations
            System.out.printf(" %2d   %s%n", i, operations[i - 1]);
        }

        Message.printSymbol("-",60);
        App.takeMathOperation();
    }

    /**
     * Display the question name by question number
     *
     * @param index
     * @return
     */
    public static String getOperationName(int index) {
        return operations[index - 1];
    }

    /**
     *
     * @param index
     * @return
     */
    public static String selectOperation(int index) {
        String operationName = "";
        switch (index) {
            case 1:
                operationName = "addition";
                break;
            case 2:
                operationName = "subtraction";
                break;
            case 3:
                operationName = "multiplication";
                break;
            case 4:
                operationName = "mixture";
                break;
        }
        return operationName;
    }

    /**
     * Get the method name of Class App upon question number entered
     *
     */
    public static void takeMathOperation() {
        System.out.printf("  %s   %s%n", Color.RED + "5   -->", "EXIT" + Color.RESET);
        Message.printSymbol("-", 60);
        System.out.println(Color.BLUE + "Please select one quiz by number" + Color.RESET);
        Message.printSymbol("=", 60);
        System.out.print("[QUIZ NO.] > ");

        Scanner input = new Scanner(System.in);

        // Repeat until next item is an integer
        while (!input.hasNextInt()) {
            input.next(); // Read and discard offending non-integer input
            System.out.print("Please enter a number: "); // Re-prompt
        }


        // Get the integer
        int index = input.nextInt();

        while (true) {
            if (index < 1 || index > 5) {
                String warning = "No such operation found!";
                System.out.printf("%n%s%n", Color.RED + warning.toUpperCase() + Color.RESET);
                App.printFooter();
            } else if (index == 5) {
                System.out.printf(Color.GREEN + "\nThank you for your play!\nSee you soon!\n" + Color.RESET);
                break;
            } else {
                try {
                    App MathQuiz = new App();

                    Method method = App.class.getMethod(selectOperation(index)); // Call each operation
                    method.invoke(MathQuiz);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }

    /**
     * Display an output header in specific format
     *
     * @param index
     */
    public static void printHeader(int index) {
        Message.printSymbol("-", 1, 0);
        System.out.format("%-24s %s %n", " ", Color.YELLOW + getOperationName(index) + Color.RESET);
        Message.printSymbol("-", 0, 1);
    }

    /**
     * Display an output footer in specific format for each question
     *
     */
    public static void printFooter() {
        App.index();
    }

    /**
     * Get the tester's name
     * @return
     */
    public static String getTesterName() {
        return testerName;
    }

    /**
     * Validate the user input until return an integer
     * @param input
     * @return
     */
    public static int getIntNumber(Scanner input) {
        while (!input.hasNextInt()) {
            input.next(); // Read and discard offending non-integer input
            System.out.print("Please enter a number: "); // Re-prompt
        }
        return input.nextInt();
    }
}
