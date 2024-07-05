package com.example.Cifrado2.security.config;

import com.example.Cifrado2.security.jwt.JwtAuthenticationFilter;
import com.example.Cifrado2.service.CarServiceImpl;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig  {


    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    //Metodo que permite ignorar la seguridad en una URL
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                // Spring Security should completely ignore URLs starting with /public/ and /resources/
                .requestMatchers("/api/v1/auth/**");
    }

    //Metodo que permite configurar la seguridad de la aplicacion
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //Todas las URL CON /public/** no requieren autenticacion

        http
                //.csrf(AbstractHttpConfigurer::disable)
                .csrf((csrf) -> csrf.disable())
                // Autoriza todas las peticiones sin autenticacion a la URL
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .sessionManagement((sessionManagment) -> sessionManagment
                        .sessionConcurrency((sessionConcurrency) -> sessionConcurrency
                                .maximumSessions(1).expiredUrl("/login")
                        ).sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ).authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)



                //Se habilita el formulario de login de Spring Security
                //.formLogin(Customizer.withDefaults())
                /*
                .formLogin((formLogin) ->
                        //Formulario de login personalizado
                        formLogin
                                .loginPage("/login")
                                .permitAll())

                 */
               // .rememberMe(Customizer.withDefaults())
                ;

        return http.build();
    }



    //Metodo que permite encriptar las contraseñas




    //Bean que crea dos usuarios en memoria y encripta las contrasenias
    /*
    @Bean
    public UserDetailsService userDetailsService() {
        //Se crea un objeto de tipo PasswordEncoder
        PasswordEncoder encoder = passwordEncoder();
        //Se crear el usuario user
        UserDetails user = User.builder()
                .username("user")
                .password(encoder.encode("password"))//Se encripta la contrasenia
                .roles("USER")
                .build();
        //Se crear el usuario admin
        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("password"))
                .roles("ADMIN", "USER")
                .build();
        //Se retorna un objeto de tipo InMemoryUserDetailsManager con los usuarios user y admin
        return new InMemoryUserDetailsManager(user, admin);
    }
     */
}
