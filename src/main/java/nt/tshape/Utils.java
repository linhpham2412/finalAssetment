package nt.tshape;

import java.util.Random;

public class Utils {
    public static String generateTestEmail() {
        Random emailRandIndex = new Random();
        return emailRandIndex.nextInt() + "@mail.com";
    }

    public static String generateRandomTestCharacters(int noOfCharsToGenerate) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = noOfCharsToGenerate;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public static String generateRandomNumberInRange(int minValue, int maxValue) {
        Random random = new Random();
        int value = random.nextInt(maxValue - minValue + 1) + minValue;
        return String.valueOf(value);
    }
}
