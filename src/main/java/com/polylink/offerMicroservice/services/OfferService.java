package com.polylink.offerMicroservice.services;

import com.polylink.offerMicroservice.dto.CreateOfferDTO;
import com.polylink.offerMicroservice.entity.Offer;
import com.polylink.offerMicroservice.repositories.OfferRepository;
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
    public List<Offer> getAllOffersByEmployer(Long id_employer) {
        return offerRepository.findOffersByIdEmployer(id_employer);
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
    public void createOffer(CreateOfferDTO offerDTO,Long idEmployee){
        Offer offer = offerDTO.offerDTO(idEmployee);
        System.out.println(offer);

        offerRepository.save(offer);
    }
    public void updateOffer(Integer idOffer,CreateOfferDTO offerDTO,Long idEmployee){
        Offer offer = offerDTO.offerDTO(idOffer,idEmployee);
        offerRepository.save(offer);
    }

    /**
     *
     * @param id_offer
     */
    public void deleteOfferById(Integer id_offer){
        offerRepository.deleteOfferById(id_offer);
    }
}
