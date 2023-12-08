import static java.lang.System.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        out.print("""
                
                Пожалуйста, введите математическое выражение, используя арабиские или римские цифры.
                Для ввода математического выражения, используя римские цифры,
                выберите английскую раскладку и следите, чтобы математические литералы были прописаны с заглавной буквы. 
                При вводе, вы можете использовать пробелы и обязательно не забудьте проставить математические знаки: +,-,*,/    
                                            
                ПОЛЕ ДЛЯ ВВОДА:   """);
        Scanner inString = new Scanner(in);
        String mathStatement = inString.nextLine();

      try {
          out.printf("\n\nОтвет: %s", calc(mathStatement));
      }
      catch (Exception ex) {
          out.println(ex.getMessage());
      }
    }

    public static String calc(String input) throws Exception{
            input = input.replace(" ", "");
            if (checkingFormatSring(input, "([1-9]|10)[+-/*/]([1-9]|10)|" +
                    "(^I[VX]|[VX]|V?I{0,3})[+-/*/](I[VX]|[VX]|V?I{0,3})")) {

                if (checkingFormatSring(input, "^[1-9].+")) {
                    return ArabicCalc.arabicCalculation(input);
                }
                else {
                    RomanCalc.setRomanNumber("I", 1);
                    RomanCalc.setRomanNumber("V", 5);
                    RomanCalc.setRomanNumber("X", 10);
                    RomanCalc.setRomanNumber("L", 50);
                    RomanCalc.setRomanNumber("C", 100);

                    return RomanCalc.romanCalculation(input);
                }
            }
            else {
                throw new Exception("\n\nОШИБКА: Математическое выражение имеет неправильный формат");
            }
    }
    static boolean checkingFormatSring(String input, String regex) {
        return  input.matches(regex);
    }
}