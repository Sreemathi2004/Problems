package Problems;
import java.util.*;
public class RomanToBinary {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(toBinary(romanToInt(str)));
    }

    // Convert Roman numeral to integer
    public static int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(s.charAt(i));
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            prevValue = currentValue;
        }

        return total;
    }

    // Convert integer to binary
    public static String toBinary(int number) {
        if (number == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        
        while (number > 0) {
            int remainder = number % 2;
            binary.insert(0, remainder);
            number = number / 2;
        }

        return binary.toString();
    }
}
