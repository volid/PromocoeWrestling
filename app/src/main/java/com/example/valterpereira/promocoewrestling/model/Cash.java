package com.example.valterpereira.promocoewrestling.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valter Pereira on 14/02/2018.
 */

public class Cash {
    private static List<Promocao> list;

    public static List<Promocao> getList() {
        if (null == list) list = new ArrayList<>();
        return list;
    }
    public static void setList(List<Promocao> list) {
        list = list;
    }
}
