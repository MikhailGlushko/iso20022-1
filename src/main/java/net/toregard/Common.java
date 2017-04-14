package net.toregard;


import java.util.UUID;

public class Common {

    static public long getRandom(){
        return Long.getLong(UUID.randomUUID().toString());
    }
}
