package com.teckUP.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // ✅ désactivation correcte du CSRF (nécessaire pour POST non authentifiés en REST)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/loginctrl/** ").permitAll() // ✅ rend toutes les routes du contrôleur LoginController publiques
                        .requestMatchers("/user/all").permitAll() //bch taati l acces lil /user/all sans authentification
                        .requestMatchers("/produit/add").permitAll()
                        .anyRequest().authenticated() // 🔒 tout le reste nécessite une authentification
                )
                .httpBasic(Customizer.withDefaults()); // ou .formLogin(Customizer.withDefaults()) si tu veux une page de login HTML

        return http.build();
    }

}
