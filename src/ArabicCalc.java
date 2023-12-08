class ArabicCalc {


    static String arabicCalculation(String input){
        String[] statement = input.split("[+-/*/]");
        int x = Integer.parseInt(statement[0]);
        int y = Integer.parseInt(statement[1]);

        return String.valueOf(calculation(x, y,input));
    }

    static int calculation(int x, int y, String input) {
        char operator = 0;
        if (input.contains("+")) {
           operator = '+';
        }
        else if (input.contains("-")) {
            operator = '-';
        }
        else if (input.contains("*")) {
            operator = '*';
        }
        else if (input.contains("/")) {
            operator = '/';
        }

        return switch (operator) {
            case '+' -> x + y;
            case '-' -> x - y;
            case '*' -> x * y;
            case '/' -> x / y;
            default -> 0;
        };
    }
}