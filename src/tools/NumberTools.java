package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberTools {

    public boolean isNumber(String numberStr) {
        Pattern pattern = Pattern.compile("^[1-9]\\d?$"); //строка является числом двузначным, строка начинается и заканчивается числом, первая цифра [1-9], вторая цифра любая
        Matcher matcher = pattern.matcher(numberStr.trim());

        return matcher.find();
   }
}