package com.example.myapplication;

class RandomCoordiates {

    private int left;
    private int right;
    private int top;
    private int bottom;

    RandomCoordiates(int left, int right, int top, int bottom) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    int getLeft() {
        return left;
    }

    int getRight() {
        return right;
    }

    int getTop() {
        return top;
    }

    int getBottom() {
        return bottom;
    }
}
