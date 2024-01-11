package org.edu.tcms.utls;

import java.util.UUID;
import java.util.regex.Pattern;

public class UUIDUtil {
    public static String getShortUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }

    public static void main(String[] args) {
        String regex = "\\w";
        String s1 = "123";
        String s2 = "#$%";
        System.out.println(s1.matches("[a-zA-Z0-9]+"));
        System.out.println(Pattern.matches(regex, s2));
    }
}
