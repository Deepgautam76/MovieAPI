package dev.kamal.movies.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//This is configuring an .env file
    @Configuration
    public class DotenvConfig {

        @Bean
        public Dotenv dotenv() {
            return Dotenv.configure()
                    .directory(".env") // Specify custom directory
                    .load();
        }
    }
