package com.example.offerMicroservice.controllers;

import com.example.offerMicroservice.entity.Offer;
import com.example.offerMicroservice.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class OfferController
{
    @Autowired
    private OfferService offerService;

    @GetMapping("/api")
    public String resource(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Resource accessed by: %s (with subjectId: %s)" ,
                jwt.getClaims().get("preferred_username"),
                jwt.getSubject());
    }
    @GetMapping("/api/test")
    public Principal test(@AuthenticationPrincipal Jwt jwt, Principal principal) {
        return principal;
    }

    @GetMapping("/api/offer/all")
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }
    @GetMapping("/api/offer/{id_offer}")
    public Offer getOffer(@PathVariable("id_offer") Integer id_offer) {
        return offerService.getOfferById(id_offer);
    }
    @GetMapping("/api/offer/employer/{id_employer}")
    public List<Offer> getAllOffersByEmployer(@PathVariable("id_employer") Integer id_employer) {
        return offerService.getAllOffersByEmployer(id_employer);
    }
    @PostMapping("/api/offer/{id_offer}")
    public void postOffer(@RequestBody Offer offer) {
        offerService.updateOffer(offer);
    }
    @DeleteMapping("/api/offer/{id_offer}")
    public void deleteOffer(@PathVariable("id_offer") Integer id_offer) {
        offerService.deleteOfferById(id_offer);
    }
}
