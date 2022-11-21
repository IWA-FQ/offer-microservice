package com.example.offerMicroservice.services;

import com.example.offerMicroservice.entity.Offer;
import com.example.offerMicroservice.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    /**
     *
     * @return all the offers
     */
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    /**
     *
     * @param id_employer
     * @return all the offers created by an employer
     */
    public List<Offer> getAllOffersByEmployer(String id_employer) {
        return offerRepository.findOffersByEmployer(id_employer);
    }

    /**
     *
     * @param id_offer
     * @return an offer
     */
    public Offer getOfferById(Integer id_offer){
        return offerRepository.findOfferById(id_offer);
    }

    /**
     *
     * @param offer
     */
    public void updateOffer(Offer offer){
        offerRepository.save(offer);
    }

    /**
     *
     * @param id_offer
     */
    public void deleteOfferById(Integer id_offer){
        offerRepository.deleteById(id_offer);
    }
}
