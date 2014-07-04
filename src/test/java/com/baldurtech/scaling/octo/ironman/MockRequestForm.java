package com.baldurtech.scaling.octo.ironman;

import java.util.Map;
import java.util.HashMap;

public class MockRequestForm extends RequestForm {
    Map data = new HashMap();
    Boolean isGetMethod = false;

    public MockRequestForm() {
        super(null);
    }

    public void useGetMethod() {
        isGetMethod = true;
    }

    public void usePostMethod() {
        isGetMethod = false;
    }

    public void set(String param, String value) {
        data.put(param, value);
    }

    public Boolean isGetMethod() {
        return isGetMethod;
    }

    public Boolean isPostMethod() {
        return !isGetMethod;
    }

    public String getString(String param) {
        return (String) data.get(param);
    }
}
