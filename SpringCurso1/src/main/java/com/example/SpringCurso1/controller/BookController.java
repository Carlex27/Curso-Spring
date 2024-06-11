package com.example.SpringCurso1.controller;

import com.example.SpringCurso1.entities.Book;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final Logger log = LoggerFactory.getLogger(BookController.class);
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
     * @return
     */
    @PostMapping("/api/books")
    public ResponseEntity<Book>  Create(@RequestBody Book book){
        if(book.getId() != null){
            //Si el id del libro es diferente de null, significa que el libro ya existe en la base de datos
            log.warn("Trying to create a new book with existent id");
            return ResponseEntity.badRequest().build();
        }
        //Guardar el libro recibido por parametros en la base de datos
        Book result = repository.save(book);
        return ResponseEntity.ok(result);
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
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if(book.getId() == null){
            //Si no tiene id quiere decir que es para crear un libro
            log.warn("Trying to update a book without id");
            return ResponseEntity.badRequest().build();
        }
        if(!repository.existsById(book.getId())){
            log.warn("Trying to update a book that does not exist");
            return ResponseEntity.notFound().build();
        }

        Book result = repository.save(book);
        return ResponseEntity.ok(result);
    }

    //Delete
    @DeleteMapping("api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        if(!repository.existsById(id)){
            log.warn("Trying to delete a book that does not exist");
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("api/books")
    public ResponseEntity<Book> deleteAll(){
        repository.deleteAll();
        return ResponseEntity.ok().build();
    }

}
