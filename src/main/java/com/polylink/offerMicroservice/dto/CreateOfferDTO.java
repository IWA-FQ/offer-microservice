package com.polylink.offerMicroservice.dto;

import com.polylink.offerMicroservice.entity.Offer;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class CreateOfferDTO {

    private String title;

    private String description;

    private Date start_date;

    private Date end_date;

    private String keywords;

    private String city;

    private Integer city_code;

    private Integer nb_positions;

    private Double salary;

    private String advantage;
    public Offer offerDTO(Long idEmployer){
        return new Offer( title,  description,  start_date,  end_date,  keywords,  city,  city_code,  nb_positions,  salary,  advantage,  idEmployer);
    }
    public Offer offerDTO(Integer idOffer,Long idEmployer){
        return new Offer(idOffer, title,  description,  start_date,  end_date,  keywords,  city,  city_code,  nb_positions,  salary,  advantage,  idEmployer);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCity_code() {
        return city_code;
    }

    public void setCity_code(Integer city_code) {
        this.city_code = city_code;
    }

    public Integer getNb_positions() {
        return nb_positions;
    }

    public void setNb_positions(Integer nb_positions) {
        this.nb_positions = nb_positions;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage;
    }
}
