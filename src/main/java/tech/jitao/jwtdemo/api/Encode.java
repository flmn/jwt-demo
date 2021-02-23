package tech.jitao.jwtdemo.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jitao.jwtdemo.Constants;

@RestController(Encode.PATH)
public class Encode {
    static final String PATH = "/encode";

    @GetMapping(PATH)
    public Object process() {
        Algorithm algorithm = Algorithm.HMAC256(Constants.SECRET);

        return JWT.create()
                .withClaim("user", "9527")
                .withClaim("name", "唐伯虎")
                .sign(algorithm);
    }
}
