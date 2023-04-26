package com.example.jsp_project.bean;

import java.util.List;

public class ChartData {
    private int data;
    private String labels;

    public ChartData(int data, String labels) {
        this.data = data;
        this.labels = labels;
    }

    public ChartData() {

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }
}
