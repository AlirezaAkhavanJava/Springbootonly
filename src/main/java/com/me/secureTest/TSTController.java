package com.me.secureTest;


import com.me.accountowner.domain.dto.CreateAccountOwnerRequest;
import com.me.accountowner.domain.entity.AccountOwner;
import jakarta.servlet.http.HttpServletRequest;
import net.datafaker.Faker;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test/api")
public class TSTController {

    @GetMapping(path = "/csrf")
    public String csrfToken(HttpServletRequest request) {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        return csrfToken.getToken();
    }

    @GetMapping(path = "/faker")
    public AccountOwner owner(){
        Faker  faker = new Faker();
        AccountOwner accountOwner = AccountOwner.builder()
                .username(faker.name().name())
                .email(faker.internet().emailAddress())
                .passwordHash("454545545432")
                .build();
        return accountOwner;
    }
}
