package com.example.SpringCurso1.service;

import com.example.SpringCurso1.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    //Test de la clase BookPriceCalculator
    //Con la annotation @Test indicamos que este metodo es un test
    @Test
    void calculate() {
        //Preparar el escenario de testing
        Book book = new Book(4L, "The Lord of the Rings", "J.R.R. Tolkien", 1000, 50.0, LocalDate.of(1990,10,10), true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        //Se ejecuta el comportamiento a testear
        double price = calculator.calculate(book);
        System.out.println(price);
        //Comprobaciones de que todo esta bien
        assertTrue(price > 0); //Si el precio no es negativo
        assertEquals(62.99, price); //Si el precio es el esperado
    }
}