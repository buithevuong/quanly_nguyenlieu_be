package com.thuctapcdit.qlnguyenlieube.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MethodUtils {

    public static boolean checkIndexInArray(Object i , List<Long> list){
        int temp = (int) list.stream().filter(check -> !i.equals(check)).count();

        if(temp == list.size()){
            return false;
        }
        return true;
    }

}
