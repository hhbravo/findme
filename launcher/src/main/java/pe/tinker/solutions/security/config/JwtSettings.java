package pe.tinker.solutions.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * Created by hans_h'bravo on 21/12/2017.
 */
@Configuration
@ConfigurationProperties(prefix = "spring.security.jwt")
public class JwtSettings {
    /**
     * {@link pe.tinker.solutions.security.model.token.JwtToken} will expire after this time.
     */
    private Integer tokenExpirationTime;

    /**
     * Token issuer.
     */
    private String tokenIssuer;

    /**
     * Key is used to sign {@link pe.tinker.solutions.security.model.token.JwtToken}.
     */
    private String tokenSigningKey;

    /**
     * {@link pe.tinker.solutions.security.model.token.JwtToken} can be refreshed during this timeframe.
     */
    private Integer refreshTokenExpTime;

    public Integer getRefreshTokenExpTime() {
        return refreshTokenExpTime;
    }

    public void setRefreshTokenExpTime(Integer refreshTokenExpTime) {
        this.refreshTokenExpTime = refreshTokenExpTime;
    }

    public Integer getTokenExpirationTime() {
        return tokenExpirationTime;
    }

    public void setTokenExpirationTime(Integer tokenExpirationTime) {
        this.tokenExpirationTime = tokenExpirationTime;
    }

    public String getTokenIssuer() {
        return tokenIssuer;
    }
    public void setTokenIssuer(String tokenIssuer) {
        this.tokenIssuer = tokenIssuer;
    }

    public String getTokenSigningKey() {
        return tokenSigningKey;
    }

    public void setTokenSigningKey(String tokenSigningKey) {
        this.tokenSigningKey = tokenSigningKey;
    }
}
