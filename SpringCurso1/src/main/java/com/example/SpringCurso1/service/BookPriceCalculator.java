package com.example.SpringCurso1.service;

import com.example.SpringCurso1.entities.Book;

public class BookPriceCalculator {
    public double calculate(Book book){
        double price = book.getPrice();
        if(book.getPages() > 200){
            price +=10;
        }
        price += 2.99;
        return price;
    }

}
