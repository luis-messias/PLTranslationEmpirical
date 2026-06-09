package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HumanEval_95 {

    public static boolean checkDictCase(Map<String, String> dict) {
        List<Map.Entry<String>> keys = new ArrayList<>(dict.entrySet());

        if (keys.isEmpty()) return false;

        boolean lower = true;
        boolean upper = true;

        for (Map.Entry<String> entry : keys) {
            String key = entry.getKey();

            if (!key.matches("[a-zA-Z]+")) {

                lower = false;

                break;

            }

            if (!Character.isUpperCase(key.charAt(0))) {

                upper = false;

                break;

            }
        }

        return lower || upper;
    }
}
