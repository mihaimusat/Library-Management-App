package com.endava.proiect.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reader")
@NoArgsConstructor
@AllArgsConstructor
public class Reader extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @OneToMany(targetEntity = Order.class,
            mappedBy = "reader",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Order> ordersList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                ", ordersList=" + ordersList +
                '}';
    }
}
