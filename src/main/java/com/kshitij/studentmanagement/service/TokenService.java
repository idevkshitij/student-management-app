package com.kshitij.studentmanagement.service;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TokenService {

    // Store tokens with their creation time
    private final Map<String, TokenData> tokenStore = new HashMap<>();

    // Token expiration time in seconds (e.g., 1 hour)
    private static final long TOKEN_EXPIRATION_TIME = 3600;

    public String generateToken(String username) {
        // Generate a random token (for simplicity, use UUID)
        String token = UUID.randomUUID().toString();

        // Store the token with its creation time
        tokenStore.put(token, new TokenData(username, Instant.now()));

        return token;
    }

    public boolean validateToken(String token) {
        TokenData tokenData = tokenStore.get(token);
        if (tokenData == null) {
            return false; // Token does not exist
        }

        // Check if the token has expired
        Instant now = Instant.now();
        Instant expirationTime = tokenData.getCreationTime().plusSeconds(TOKEN_EXPIRATION_TIME);

        if (now.isAfter(expirationTime)) {
            tokenStore.remove(token); // Remove expired token
            return false;
        }

        return true; // Token is valid
    }

    public String getUsernameFromToken(String token) {
        TokenData tokenData = tokenStore.get(token);
        if (tokenData == null) {
            return null; // Token does not exist
        }

        // Check if the token has expired
        Instant now = Instant.now();
        Instant expirationTime = tokenData.getCreationTime().plusSeconds(TOKEN_EXPIRATION_TIME);

        if (now.isAfter(expirationTime)) {
            tokenStore.remove(token); // Remove expired token
            return null;
        }

        return tokenData.getUsername(); // Return the username
    }

    public void invalidateToken(String token) {
        tokenStore.remove(token);
    }

    // Inner class to store token data (username and creation time)
    private static class TokenData {
        private final String username;
        private final Instant creationTime;

        public TokenData(String username, Instant creationTime) {
            this.username = username;
            this.creationTime = creationTime;
        }

        public String getUsername() {
            return username;
        }

        public Instant getCreationTime() {
            return creationTime;
        }
    }
}