package com.shop.constant;


public enum ProductCategoryGrade {

    ROOT(0),
    SECOND(1),
    THIRD(2);

    private int grade;

    ProductCategoryGrade() {
    }

    ProductCategoryGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
