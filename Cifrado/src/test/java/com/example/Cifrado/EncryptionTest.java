package com.example.Cifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class EncryptionTest {

    /**
     * Bycrypt genera su propio salt de 16 bytes
     *
     * El resultado de cifrar con Bycrypt es un string de 60 caracteres
     * $a Version
     * $10 Cost (Valor que va entre 4 y 31 que indica el costo de la función de cifrado)
     * los 22 caracteres siguientes son el salt generado
     */
    @Test
    void bycryptTest(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String encodedPassword = encoder.encode("admin");
        System.out.println(encodedPassword);

        boolean ban = encoder.matches("admin", encodedPassword);
        System.out.println(ban);
    }

    @Test
    void bycryptTest2(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        for (int i =0; i < 10; i++)
            System.out.println(encoder.encode("admin"));

    }

    @Test
    void Pbkdf2(){
        //Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
        //for (int i =0; i < 10; i++)
            //System.out.println(encoder.encode("admin"));

    }
}
