package util;

import java.util.Collection;

public class CollectionUtil {
    public static boolean isNullOrEmpty(Collection collection) {
        return collection==null || collection.isEmpty();
    }
}
