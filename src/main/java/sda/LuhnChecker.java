package sda;

import java.util.Arrays;

public class LuhnChecker {
    public boolean checkLuhn (String number) {
        int sum = 0;
        char[] chars = number.toCharArray();
        int[] numbers = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            numbers[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
            for (int i = numbers.length - 2; i >= 0; i-=2) {
                numbers[i] *= 2;
                if (numbers[i] > 9) {
                    int a = numbers[i] % 10;
                    numbers[i] /= 10;
                    numbers[i] += a;
                }
            }
            sum = Arrays.stream(numbers).sum();
        return sum % 10 == 0;
    }
}
