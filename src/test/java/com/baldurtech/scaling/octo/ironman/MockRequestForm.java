package com.baldurtech.scaling.octo.ironman;

import java.util.Map;
import java.util.HashMap;

public class MockRequestForm extends RequestForm {
    Map data = new HashMap();

    public MockRequestForm() {
        super(null);
    }

    public void set(String param, String value) {
        data.put(param, value);
    }

    public String getString(String param) {
        return (String) data.get(param);
    }
}
