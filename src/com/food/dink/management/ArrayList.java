package com.food.dink.management;

import java.util.Arrays;

public class ArrayList {
    protected Object[] array;

    public ArrayList() {
        array = new Object[0];
    }

    public ArrayList(ArrayList arrayList) {
        array = arrayList.array;
    }

    public ArrayList(Object[] array) {
        this.array = array;
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public void append(Object obj) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = obj;
    }

    @Override
    public String toString() {
        String str = "";
        for (Object object : array) {
            str += (object.toString() + '\n');
        }
        return str;
    }
}