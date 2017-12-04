package com.joyadata.tjlog.util;

import java.util.UUID;

public class Generator {

    /**
     * UUID生成器
     * 
     * @return
     */
    public static String uuid() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "").toUpperCase();
        return uuid;
    }
	
}
