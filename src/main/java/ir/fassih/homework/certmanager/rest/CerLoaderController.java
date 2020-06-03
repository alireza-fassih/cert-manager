package ir.fassih.homework.certmanager.rest;

import ir.fassih.homework.certmanager.manager.CertManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cert")
public class CerLoaderController {

    @Autowired
    private CertManager certManager;

    @GetMapping("/loadCert/{code}")
    @ResponseBody
    public byte[] loadImages(@PathVariable("code") String code) {
        return certManager.loadByCode(code).getData();
    }
}
