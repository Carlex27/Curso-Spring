package com.example.SpringCurso1.controller;

import com.example.SpringCurso1.entities.Book;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.SpringCurso1.repository.BookRepository;
import java.util.List;
import java.util.Optional;

@RestController
@Getter
@Setter

public class BookController {
    //Atributos
    private BookRepository repository;

    //Constructor
    @Autowired //ESTA NOTACION ES NECESARIA PARA QUE SPRING INYECTE EL REPOSITORIO AUTOMATICAMENTE
    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    public BookController() {
    }

    //CRUD sobre la entidad Book
    //Create

    /**
     * http://localhost:8080/api/books
     * POST
     * Metodo que recibe un libro y lo guarda en la base de datos
     * @param book
     * @param headers
     * @return
     */
    @PostMapping("/api/books")
    public Book Create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        //Guardar el libro recibido por parametros en la base de datos
        return repository.save(book);
    }

    //Read
    //Find All

    /**
     * GET
     * http://localhost:8080/api/books
     * Metodo que retorna todos los libros de la base de datos
     * ArrayList<Book>
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> FindAll(){
        return repository.findAll();
    }
    //FindOne by ID

    /**
     * http://localhost:8080/api/books/1
     * Metodo que retorna un libro por su id
     * @param id
     * @return
     */
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> FindOne(@PathVariable Long id){
        Optional<Book> optBook = repository.findById(id);

        if(optBook.isPresent()){
            return ResponseEntity.ok(optBook.get());
        }else{
            return ResponseEntity.notFound().build();
        }

        // return optBook.orElse(null);
    }
    //Update
    

    //Delete
}
