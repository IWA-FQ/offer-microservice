package com.example.offerMicroservice.repositories;

import com.example.offerMicroservice.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> , CrudRepository<Offer, Integer> {

     List<Offer> findAll();

     List<Offer> findOffersByIdEmployer(Integer id_employer);

     Offer findOfferById(Integer id_offer);

     Offer save(Offer offer);

     void deleteOfferById(Integer id_offer);
}
