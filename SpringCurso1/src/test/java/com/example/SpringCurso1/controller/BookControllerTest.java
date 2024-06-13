package com.example.SpringCurso1.controller;

import com.example.SpringCurso1.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Esta notation se encarga de poder iniciar el contexto de Spring para poder hacer test de los controladores
//debido a que los controladores necesitan de peticiones HTTP para funcionar
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate restTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        restTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @DisplayName("Test para comprobar el hello controller")
    @Test
    void hello(){
        ResponseEntity<String> result = restTemplate.getForEntity("/hello", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Hello World!", result.getBody());
        assertEquals(200, result.getStatusCodeValue());
    }

    @DisplayName("Test para comprobar la creacion de un libro")
    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "title": "Libro de Spring Test",
                    "author": "Rodrigo Turini",
                    "pages": 240,
                    "price": 29.9,
                    "releaseDate": "2020-01-10",
                    "online": true
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Book> response = restTemplate.exchange("/api/books",HttpMethod.POST, request, Book.class);

        Book result = response.getBody();
        assertEquals(1L, result.getId());
        assertEquals("Libro de Spring Test", result.getTitle());

    }

    @DisplayName("Test para comprobar la busqueda de todos los libros")
    @Test
    void findAll() {
        ResponseEntity<Book[]> result = restTemplate.getForEntity("/api/books", Book[].class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(200, result.getStatusCodeValue());

        List<Book> books = Arrays.asList(result.getBody());
        System.out.println(books.size());
        assertTrue(books.size() > 0);
    }

    @DisplayName("Test para comprobar la busqueda de un libro por id")
    @Test
    void findOne() {
        ResponseEntity<Book> result = restTemplate.getForEntity("/api/books/1", Book.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        //assertEquals(200, result.getStatusCodeValue());
    }
}