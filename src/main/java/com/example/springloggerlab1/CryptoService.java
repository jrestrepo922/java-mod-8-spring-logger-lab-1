package com.example.springloggerlab1;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptoService {
    public String getCoinPrice(String cryptoCurrency){
        String apiURL = "https://api.coincap.io/v2/assets/" +cryptoCurrency.toLowerCase();
        RestTemplate restTemplate = new RestTemplate();
        String coin = restTemplate.getForObject(apiURL, String.class);
        String[] coinArray = coin.split(":|,");
        String pricePerCoin = coinArray[18].replace("\"", "");
        return pricePerCoin;
    }
}
