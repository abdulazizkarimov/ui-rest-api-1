package util;

import java.util.Random;

public class RandomUtil {
    private static Random rand = new Random();

    public static int getInt(int n) {
        return rand.nextInt(n);
    }
}
