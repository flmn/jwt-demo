package tech.jitao.jwtdemo.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.jitao.jwtdemo.Constants;

@RestController(Decode.PATH)
public class Decode {
    static final String PATH = "/decode";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(PATH)
    public Object process(@RequestBody String body) {
        Algorithm algorithm = Algorithm.HMAC256(Constants.SECRET);
        JWTVerifier verifier = JWT.require(algorithm)
                .withClaimPresence("user")
                .withClaimPresence("name")
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(body);

        logger.info("body={}", body);
        logger.info("claims={}", jwt.getClaims());

        return jwt.getClaims();
    }
}
