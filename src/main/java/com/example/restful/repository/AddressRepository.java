package com.example.restful.repository;

import com.example.restful.VO.Address;
import org.apache.tomcat.jni.Local;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
//    List<Address> findAll(Sort sort);

    List<Address> findAllByDateTest(Date dateTest);

    List<Address> findByDateTest(Date dateTest);

}
