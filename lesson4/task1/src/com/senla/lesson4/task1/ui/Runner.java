package com.senla.lesson4.task1.ui;

import com.senla.lesson4.task1.facade.Hotel;

import java.text.ParseException;

public class Runner {
    public static void main(String[] args) throws ParseException {
        Hotel hotel = new Hotel(args[0], args[1], args[2]);
        hotel.run();
    }
}