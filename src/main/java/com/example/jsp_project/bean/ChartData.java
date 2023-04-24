package com.example.jsp_project.bean;

import java.util.List;

public class ChartData {
    private List<Integer> data;
    private List<String> labels;
    public ChartData(List<Integer> data, List<String> labels) {
        this.data = data;
        this.labels = labels;
    }

    public ChartData() {

    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

}
