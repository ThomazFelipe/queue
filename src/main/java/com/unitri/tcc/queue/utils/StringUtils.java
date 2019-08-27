package com.unitri.tcc.queue.utils;

import java.io.Serializable;

public class StringUtils implements Serializable {

    public static Long convertToLong( String value ) {
        return Long.valueOf( value );
    }

    public static Double convertToDouble( String value ) {
        return Double.valueOf( value );
    }
}