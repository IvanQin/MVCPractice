package com.ivanqin.model;

public interface DataListener<T> {

    void onDataChanged(T previousData);
}
