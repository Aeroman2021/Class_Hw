package com.company.ex;

import java.util.ArrayList;
import java.util.List;

public class FileCreater {

    ArrayList<String> stringList;

    public static ArrayList<String> stringMaker() {
        ArrayList<String> stringList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            stringList.add("String" + i);
        }
        return stringList;
    }


}
