package org.example;

public interface IDao <T> {

    T read();

    void write(T object);


}
