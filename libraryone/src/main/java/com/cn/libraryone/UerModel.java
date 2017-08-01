package com.cn.libraryone;

import java.io.Serializable;

/**
 * Created by ${qsh} on 2017/7/31.
 */

public class UerModel implements Serializable{

    private String name;
    private String six;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }
}
