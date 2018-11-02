import Console.Message;

public class Operation {
    public Operation() {

    }

    /**
     *
     * @param number1
     * @param number2
     * @return
     */
    public static int add(int number1, int number2) {
        return (number1 + number2);
    }

    /**
     *
     * @param number1
     * @param number2
     * @return
     */
    public static int substract(int number1, int number2) {
        return (number1 - number2);
    }

    /**
     *
     * @param number1
     * @param number2
     * @return
     */
    public static int multiply(int number1, int number2) {
        return (number1 * number2);
    }

    /**
     *
     * @param number
     * @param dividor
     * @return
     */
    public static double divide(int number, int dividor) {
        return (dividor != 0) ? (double)(Math.round((number * 1.0 / dividor) * 100.0) / 100.0) : -1;
    }

    /**
     *
     * @param number1
     * @param number2
     * @return
     */
    public static int max(int number1, int number2) {
        return (number1 >= number2) ? number1 : number2;
    }

    /**
     *
     * @param number1
     * @param number2
     * @return
     */
    public static int min(int number1, int number2) {
        return (number1 <= number2) ? number1 : number2;
    }

    /**
     *
     * @param min
     * @param max
     * @return
     */
    public static int randomInt(int min, int max) {
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

}
