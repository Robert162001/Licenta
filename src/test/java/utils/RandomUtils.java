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



    public static void main(String[] args) {
       final String userName=generateRandomString(5, 11);
       final String userEmail=generateEmailAddressByUserName(userName);
        System.out.println(userName);
        System.out.println(userEmail);
    }
}
