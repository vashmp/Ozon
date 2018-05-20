package util;

import java.util.ArrayList;
import java.util.List;

public class Stash {
    public static List<String> stash = new ArrayList<>();

    public static void add(String value){
        stash.add(value);
    }
}
