package itjockebark.ptapp.security;

import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import javax.crypto.SecretKey;

@Configuration
public class JwtConfig {

    private String key = "N0KKuokAGWb5XjMP+V22XLfyLkaSArwxNm17VeAvv7+y4+Y/DmXoxBLenvwOPO404lfl6UfyyEGgQ02))11TDEPRMwV/+Q==";
    private String tokenPrefix = "Bearer ";
    private int tokenExpirationAfterDays = 2;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    public int getTokenExpirationAfterDays() {
        return tokenExpirationAfterDays;
    }

    public void setTokenExpirationAfterDays(int tokenExpirationAfterDays) {
        this.tokenExpirationAfterDays = tokenExpirationAfterDays;
    }

    @Bean
    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(key.getBytes());
    }

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }
}