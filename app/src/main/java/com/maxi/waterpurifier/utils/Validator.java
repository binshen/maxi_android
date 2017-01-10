package com.maxi.waterpurifier.utils;

import android.text.TextUtils;

/**
 * Created by bin.shen on 2017/1/10.
 */

public class Validator {
    public static boolean isMobile(String value) {
        if (TextUtils.isEmpty(value)) return false;
        return value.matches("[1][358]\\d{9}");
    }
}
