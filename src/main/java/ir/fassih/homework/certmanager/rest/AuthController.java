package ir.fassih.homework.certmanager.rest;

import ir.fassih.homework.certmanager.rest.model.ActionResult;
import ir.fassih.homework.certmanager.rest.model.LoginDto;
import ir.fassih.homework.certmanager.service.auth.ManualSpringSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
@RequiredArgsConstructor
public class AuthController {

    private final ManualSpringSecurityService manualSpringSecurityService;

    @PostMapping("/login")
    public ActionResult<String> login(@RequestBody LoginDto dto ) {
        manualSpringSecurityService.doLogin( dto );
        return new ActionResult<>("login successful");
    }
}
