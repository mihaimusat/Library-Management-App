package com.endava.proiect.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reader_order")
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    @NotNull
    @Column(name = "rental_date")
    private LocalDate rentalDate;

    @NotNull
    @Column(name = "return_date")
    private LocalDate returnDate;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + getId() +
                ", book=" + book +
                ", reader=" + reader +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
