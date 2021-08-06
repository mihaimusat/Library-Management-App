package com.endava.proiect.repository;

import com.endava.proiect.model.Order;
import com.endava.proiect.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByReader(Reader reader);
}
