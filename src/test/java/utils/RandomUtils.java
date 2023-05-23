package utils;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class RandomUtils {

    public static String generateRandomString(int minInclusive, int maxExclusive) {
        return RandomStringUtils.randomAlphabetic(minInclusive, maxExclusive);
    }

    public static String generateEmailAddressByUserName(String userName) {
        return StringUtils.join(userName, "@email.com");
    }

}
