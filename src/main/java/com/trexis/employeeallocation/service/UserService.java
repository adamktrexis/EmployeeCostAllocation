
package com.trexis.employeeallocation.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.json.JSONObject;

@Service
public class UserService {

    @Value("${keycloak.admin-api-url}")
    private String keycloakAdminApiUrl;

    @Value("${keycloak.token-api-url}")
    private String keycloakTokenApiUrl;

    @Value("${keycloak.client-id}")
    private String clientId;

    @Value("${keycloak.admin-username}")
    private String adminUsername;

    @Value("${keycloak.admin-password}")
    private String adminPassword;

    public ResponseEntity<String> createUserInKeycloak(String username, String password) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        String adminAccessToken = getAccessToken();

        JSONObject userJson = new JSONObject();
        userJson.put("username", username);
        userJson.put("enabled", true);
        
        JSONObject credentials = new JSONObject();
        credentials.put("type", "password");
        credentials.put("value", password);
        credentials.put("temporary", false);
        
        userJson.put("credentials", new JSONObject[]{credentials});

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(adminAccessToken);

        HttpEntity<String> request = new HttpEntity<>(userJson.toString(), headers);

        ResponseEntity<String> response = restTemplate.exchange(keycloakAdminApiUrl, HttpMethod.POST, request, String.class);

        if (response.getStatusCode() != HttpStatus.CREATED) {
            throw new RuntimeException("Failed to create user in Keycloak");
        }else{
            return response;
        }
    }

    private String getAccessToken() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<String> request = new HttpEntity<>(
            "client_id=" + clientId +
            "&username=" + adminUsername +
            "&password=" + adminPassword +
            "&grant_type=password",
            headers);

        ResponseEntity<String> response = restTemplate.exchange(keycloakTokenApiUrl, HttpMethod.POST, request, String.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Failed to get admin access token");
        }

        JSONObject responseJson = new JSONObject(response.getBody());
        return responseJson.getString("access_token");
    }
}
