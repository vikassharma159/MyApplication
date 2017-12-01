package com.example.admin.myapplication.util;

import java.util.List;

/**
 * Created by admin on 05/11/17.
 */

public class UtilityMethods {
    public static boolean listNotNull(List list) {
        return list != null && !list.isEmpty();
    }
}
