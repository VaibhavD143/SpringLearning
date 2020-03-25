package com.example.restful.VO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    private String number;
//testing one to one mapping
    @OneToOne(mappedBy = "address")
    @JsonIgnoreProperties(value = {"address", "hibernateLazyInitializer"}, allowSetters = true)
    private Employee employee;


//    to test date field, creation date example
    @Column(nullable = false)
    private Date dateTest;

    @PrePersist
    protected void onCreate(){
        dateTest = new Date();
    }

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateTest() {
        return dateTest;
    }

    public void setDateTest(Date dateTest) {
        this.dateTest = dateTest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", employee=" + employee +
                ", dateTest=" + dateTest +
                ", gender=" + gender +
                '}';
    }
}
