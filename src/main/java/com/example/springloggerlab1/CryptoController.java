package com.example.springloggerlab1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptoController {
    private CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService){
        this.cryptoService = cryptoService;
    }

    public Logger logger = LoggerFactory.getLogger(CryptoController.class);

    @GetMapping("/crypto")
    public String getCrypto(@RequestParam( name = "coin", defaultValue = "bitcoin") String name){
        logger.trace("Trace at the beginning");
        String cryptoPrice = cryptoService.getCoinPrice(name);
        logger.info("The price of one " + name + " is " + cryptoPrice + " was return by the external API" );
        logger.trace("Trace at the end");
        return "The price of one " + name + " is " + cryptoPrice;
    }

}
//    For each method in your Spring application, add a logger.trace() at the beginning of the method and a logger.trace() call at the end of the method.
//        For each result that you get from an external API, add a logger.info() to indicate that you got a result and include one data item from the response you received.