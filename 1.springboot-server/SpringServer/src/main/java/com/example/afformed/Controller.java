package com.example.afformed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private ECommereceService eCommerceService;

    @GetMapping("/products")
    public List<Product> getTopProducts(@RequestParam String company, @RequestParam String category,
                                        @RequestParam int top, @RequestParam int minPrice,
                                        @RequestParam int maxPrice) {
        return eCommerceService.getTopProducts(company, category, top, minPrice, maxPrice);
    }
}
