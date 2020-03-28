package com.example.restful.utils;

public class Class<T> {
    T obj;
    public Class(T obj){
        this.obj = obj;
    }

    public T getObj(){
        return this.obj;
    }
}