import java.util.*;
class RomanCalc {
    private static Map<String, Integer> romanNumber = new HashMap<>();

    static public boolean setRomanNumber(String key, int value) {
        if (key.matches("[a-zA-Z]")&& value > 0){
            RomanCalc.romanNumber.put(key,value);
            return true;
        }
        return  false;
    }

    static private String mapEntry(int key)
    {
        for (Map.Entry<String,Integer> entry : romanNumber.entrySet()) {
            if (entry.getValue() == key)
                return entry.getKey();
        }
        return null;
    }

    static String romanCalculation(String input) throws Exception {

        String[] statement = input.split("[+-/*/]");

        int x = romanConvertTo(statement[0], romanNumber);
        int y = romanConvertTo(statement[1], romanNumber);

        if (ArabicCalc.calculation(x, y, input) > 0) {
            return arabicConvertTo(ArabicCalc.calculation(x, y, input), romanNumber);
        } else {
            throw new Exception("ОШИБКА: Результат вычисления отрицательный.");
        }
    }

    static int romanConvertTo(String romanString, Map<String,Integer> romanNumber) {
        if (romanString.length() == 1) {
            return romanNumber.get(romanString);
        } else {
            int result = 0;
            char[] romanCharArray = romanString.toCharArray();
            if (romanCharArray[0] > romanCharArray[1]) {
                for (char array : romanCharArray) {
                    result += romanNumber.get(String.valueOf(array));
                }
            } else {
                result = romanNumber.get(String.valueOf(romanCharArray[romanCharArray.length - 1]));
                for (int i = romanCharArray.length - 2; i >= 0; i--) {
                    result -= romanNumber.get(String.valueOf(romanCharArray[i]));

                }
            }
            return result;
        }
    }

    static String arabicConvertTo(int answer, Map<String,Integer> romanNumber) {
        StringBuilder answerStringABuilder = new StringBuilder();

        List<Integer> listForSort = new ArrayList<>(romanNumber.values());
        Collections.sort(listForSort);

        for (int i = RomanCalc.romanNumber.size() - 1; i >= 0; i--) {
            while (answer >= listForSort.get(i)){
                answer -= listForSort.get(i);
                answerStringABuilder.append(mapEntry(listForSort.get(i)));
            }
        }
        return answerStringABuilder.toString();
    }
}