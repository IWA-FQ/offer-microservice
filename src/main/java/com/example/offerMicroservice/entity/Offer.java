package com.example.offerMicroservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "end_date")
    private Date end_date;
    @Column(name = "city")
    private String city;
    @Column(name = "city_code")
    private Integer city_code;
    @Column(name = "nb_positions")
    private Integer nb_positions;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "advantage")
    private String advantage;
    @Column(name = "employer")
    private String employer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", title='" + title +
                ", description='" + description +
                ", start_date='" + start_date +
                ", end_date='" + end_date +
                ", city='" + city +
                ", city_code='" + city_code +
                ", nb_positions='" + nb_positions +
                ", salary='" + salary +
                ", advantage='" + advantage +
                ", employer='" + employer +
                '}';
    }
}
