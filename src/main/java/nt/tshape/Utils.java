package nt.tshape;

import java.util.Random;

public class Utils {
    public static String generateTestEmail() {
        Random emailRandIndex = new Random();
        return emailRandIndex.nextInt() + "@mail.com";
    }
}
