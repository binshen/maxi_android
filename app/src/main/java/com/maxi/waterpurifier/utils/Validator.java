package com.maxi.waterpurifier.utils;

import android.text.TextUtils;

/**
 * Created by bin.shen on 2017/1/10.
 */

public class Validator {
    public static boolean isMobile(String value) {
        String telRegex = "[1][358]\\d{9}";
        if (TextUtils.isEmpty(value)) return false;
        else return value.matches(telRegex);
    }
}
