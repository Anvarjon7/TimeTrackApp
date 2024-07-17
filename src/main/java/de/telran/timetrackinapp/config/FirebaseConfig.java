package de.telran.timetrackinapp.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(getClass().getResourceAsStream("/firebase-service-account.json"));

        FirebaseOptions options =
                new FirebaseOptions.Builder()
                        .setCredentials(credentials)
                        .build();

        return FirebaseApp.initializeApp(options);
    }
}
