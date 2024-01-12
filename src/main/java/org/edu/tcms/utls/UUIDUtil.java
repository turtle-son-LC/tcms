package org.edu.tcms.utls;

import java.util.UUID;

public class UUIDUtil {
    public static String getShortUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }
}
