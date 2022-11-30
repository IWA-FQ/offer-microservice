package com.polylink.offerMicroservice.controllers;

import com.polylink.offerMicroservice.dto.CreateOfferDTO;
import com.polylink.offerMicroservice.entity.Offer;
import com.polylink.offerMicroservice.security.services.UserDetailsImpl;
import com.polylink.offerMicroservice.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    public Object test( Principal principal) {
        UsernamePasswordAuthenticationToken userDetails = (UsernamePasswordAuthenticationToken) principal;
        UserDetailsImpl user = (UserDetailsImpl) userDetails.getPrincipal();
        return user.getId();

    }
    @GetMapping("/health")
    public ResponseEntity<?> healthCheck() {

        return ResponseEntity.ok("Offer Microservice is up and running");
    }

    @GetMapping("")
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }
    @GetMapping("{id_offer}")
    public Offer getOffer(@PathVariable("id_offer") Integer id_offer) {
        return offerService.getOfferById(id_offer);
    }


    @PreAuthorize("hasRole('RECRUITER')")
    @GetMapping("/employer")
    public List<Offer> getAllOffersByEmployer(Principal principal) {
        UsernamePasswordAuthenticationToken userDetails = (UsernamePasswordAuthenticationToken) principal;
        UserDetailsImpl user = (UserDetailsImpl) userDetails.getPrincipal();

        return offerService.getAllOffersByEmployer(user.getId());
    }
    @PreAuthorize("hasRole('RECRUITER')")
    @PostMapping("")
    public ResponseEntity<?> postOffer(@RequestBody CreateOfferDTO offer, Principal principal) {
        UsernamePasswordAuthenticationToken userDetails = (UsernamePasswordAuthenticationToken) principal;
        UserDetailsImpl user = (UserDetailsImpl) userDetails.getPrincipal();

        offerService.createOffer(offer,user.getId());
        return ResponseEntity.ok().build();
    }
    @PreAuthorize("hasRole('RECRUITER')")
    @PutMapping ("{id_offer}")
    public ResponseEntity<?> updateOffer(@PathVariable("id_offer") Integer id_offer,@RequestBody CreateOfferDTO offer, Principal principal) {
        UsernamePasswordAuthenticationToken userDetails = (UsernamePasswordAuthenticationToken) principal;
        UserDetailsImpl user = (UserDetailsImpl) userDetails.getPrincipal();
        offerService.updateOffer(id_offer,offer,user.getId());
        return ResponseEntity.ok().build();
    }
    @PreAuthorize("hasRole('RECRUITER')")
    @DeleteMapping("{id_offer}")
    public ResponseEntity<?> deleteOffer(@PathVariable("id_offer") Integer id_offer) {
        offerService.deleteOfferById(id_offer);
        return ResponseEntity.ok().build();
    }
}
