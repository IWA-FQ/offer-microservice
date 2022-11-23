package com.polylink.offerMicroservice.controllers;

import com.polylink.offerMicroservice.entity.Offer;
import com.polylink.offerMicroservice.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/offer")
public class OfferController
{
    @Autowired
    private OfferService offerService;


    @GetMapping("test")
    public Principal test( Principal principal) {
        return principal;
    }

    @GetMapping("all")
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }
    @GetMapping("{id_offer}")
    public Offer getOffer(@PathVariable("id_offer") Integer id_offer) {
        return offerService.getOfferById(id_offer);
    }
    @GetMapping("/employer/{id_employer}")
    public List<Offer> getAllOffersByEmployer(@PathVariable("id_employer") Integer id_employer) {
        return offerService.getAllOffersByEmployer(id_employer);
    }
    @PostMapping("{id_offer}")
    public void postOffer(@RequestBody Offer offer) {
        offerService.updateOffer(offer);
    }
    @DeleteMapping("{id_offer}")
    public void deleteOffer(@PathVariable("id_offer") Integer id_offer) {
        offerService.deleteOfferById(id_offer);
    }
}
