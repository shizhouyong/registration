package com.wl.entity;

import java.util.List;

/**
 * 报名表实体类
 * Created by shizhouyong on 2016/12/7.
 */
public class Registration {

    private int id;

    private List<String> paramList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getParamList() {
        return paramList;
    }

    public void setParamList(List<String> paramList) {
        this.paramList = paramList;
    }
}
