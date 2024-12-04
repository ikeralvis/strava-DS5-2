package es.deusto.sd.strava.external;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class GoogleServiceGateway implements ILoginServiceGateway {
    private final String GOOGLE_API_URL = "http://localhost:8081/auth/login";
    private final String GOOGLE_API_URL_EMAIL = "http://localhost:8081/auth/verificar-email";

    public boolean login(String email, String password) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> requestBody = Map.of("email", email, "password", password);

        HttpHeaders headers = new HttpHeaders();

        headers.set("Content-Type", "application/json");

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map<String, String>> response = restTemplate.exchange(GOOGLE_API_URL, HttpMethod.POST,
                requestEntity, new ParameterizedTypeReference<Map<String, String>>() {
                });

        if (response.getStatusCode() == HttpStatus.OK) {
            return true;
        } else {
            return false;
        }

    }

    public boolean comprobarEmail(String email) {
        RestTemplate restTemplate = new RestTemplate();
        String requestBody = email;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody;
        try {
            jsonBody = objectMapper.writeValueAsString(requestBody);
        } catch (JsonProcessingException e) {
            System.err.println("Error converting request body to JSON: " + e.getMessage());
            return false;
        }

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);
       
            ResponseEntity<String> response = restTemplate.exchange(GOOGLE_API_URL_EMAIL, HttpMethod.POST,
                    requestEntity, String.class); {
                    };
            


        return (response.getBody().equals("TRUE"));
        
    }
}
