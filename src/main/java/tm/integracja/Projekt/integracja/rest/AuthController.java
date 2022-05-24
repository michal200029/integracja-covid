package tm.integracja.Projekt.integracja.rest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tm.integracja.Projekt.integracja.auth.AuthConstant;
import tm.integracja.Projekt.integracja.settings.UserSettings;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@AllArgsConstructor
public class AuthController implements AuthConstant {

    private final UserSettings userSettings;

    @GetMapping("/test")
    public String test() {
        return "Hej";
    }

    @GetMapping("/auth/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            try {
                String refreshToken = authHeader.substring(7);
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refreshToken);


                String username = decodedJWT.getClaim(USERNAME).asString();
                String password = decodedJWT.getClaim(PASSWORD).asString();
                if (!username.equals(userSettings.getUsername()) || !password.equals(userSettings.getPassword())) {
                    throw new BadCredentialsException("Bad credentials");
                }

                String accessToken = JWT.create()
                        .withClaim(USERNAME, username)
                        .withClaim(PASSWORD, password)
                        .withExpiresAt(new Date(System.currentTimeMillis() + 5 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .sign(algorithm);
                String newRefreshToken = JWT.create()
                        .withClaim(USERNAME, username)
                        .withClaim(PASSWORD, password)
                        .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put(ACCESS_TOKEN, accessToken);
                tokens.put(REFRESH_TOKEN, newRefreshToken);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception e) {
                System.out.println("Error logging in " + e.getMessage());
                response.setHeader("error", e.getMessage());
                response.setStatus(403);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }
}
