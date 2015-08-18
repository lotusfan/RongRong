package com.rongrong.model;

public class ParentModel {
    private Integer skipNum;
    private Integer pageNum;
    private Integer currentPage;
    private String sequence1;
    private String sequence1Type;
    private String sequence2;
    private String sequence2Type;
    private String maxParameter;
    private String maxValue;
    private String minParameter;
    private String minValue;
    private String orParameter1;
    private String orValue1;
    private String orParameter2;
    private String orValue2;


    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getSkipNum() {
        return skipNum;
    }

    public void setSkipNum(Integer skipNum) {
        this.skipNum = skipNum;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }


    public String getSequence1() {
        return sequence1;
    }

    public void setSequence1(String sequence1) {
        this.sequence1 = sequence1;
    }

    public String getSequence2() {
        return sequence2;
    }

    public void setSequence2(String sequence2) {
        this.sequence2 = sequence2;
    }

    public String getMaxParameter() {
        return maxParameter;
    }

    public void setMaxParameter(String maxParameter) {
        this.maxParameter = maxParameter;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public String getMinParameter() {
        return minParameter;
    }

    public void setMinParameter(String minParameter) {
        this.minParameter = minParameter;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getSequence1Type() {
        return sequence1Type;
    }

    public void setSequence1Type(String sequence1Type) {
        this.sequence1Type = sequence1Type;
    }

    public String getSequence2Type() {
        return sequence2Type;
    }

    public void setSequence2Type(String sequence2Type) {
        this.sequence2Type = sequence2Type;
    }

    public String getOrParameter1() {
        return orParameter1;
    }

    public void setOrParameter1(String orParameter1) {
        this.orParameter1 = orParameter1;
    }

    public String getOrValue1() {
        return orValue1;
    }

    public void setOrValue1(String orValue1) {
        this.orValue1 = orValue1;
    }

    public String getOrParameter2() {
        return orParameter2;
    }

    public void setOrParameter2(String orParameter2) {
        this.orParameter2 = orParameter2;
    }

    public String getOrValue2() {
        return orValue2;
    }

    public void setOrValue2(String orValue2) {
        this.orValue2 = orValue2;
    }

    @Override
    public String toString() {
        return "ParentModel{" +
                "skipNum=" + skipNum +
                ", pageNum=" + pageNum +
                ", currentPage=" + currentPage +
                ", sequence1='" + sequence1 + '\'' +
                ", sequence1Type='" + sequence1Type + '\'' +
                ", sequence2='" + sequence2 + '\'' +
                ", sequence2Type='" + sequence2Type + '\'' +
                ", maxParameter='" + maxParameter + '\'' +
                ", maxValue='" + maxValue + '\'' +
                ", minParameter='" + minParameter + '\'' +
                ", minValue='" + minValue + '\'' +
                ", orParameter1='" + orParameter1 + '\'' +
                ", orValue1='" + orValue1 + '\'' +
                ", orParameter2='" + orParameter2 + '\'' +
                ", orValue2='" + orValue2 + '\'' +
                '}';
    }
}
