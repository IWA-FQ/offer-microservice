package com.polylink.offerMicroservice.repositories;

import com.polylink.offerMicroservice.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> , CrudRepository<Offer, Integer> {

     List<Offer> findAll();

     List<Offer> findOffersByIdEmployer(Long id_employer);

     Offer findOfferById(Integer id_offer);

     Offer save(Offer offer);
     @Transactional
     void deleteOfferById(Integer id_offer);
}
