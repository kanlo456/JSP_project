package com.example.jsp_project.bean;

import java.util.List;

public class ChartData {
    private int data, income;
    private String labels;


    public ChartData(int data, String labels, int income) {
        this.data = data;
        this.labels = labels;
        this.income = income;
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

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
