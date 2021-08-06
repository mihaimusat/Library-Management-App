package com.endava.proiect.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "author")
    private String author;

    @NotNull
    @Column(name = "title")
    private String title;

    @Column(name = "publication_year")
    private int publicationYear;

    @NotNull
    @Column(name = "status")
    private String status;

    @OneToMany(targetEntity = Order.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Order> ordersList = new ArrayList<>();

    public Book(@NotNull Long id, @NotNull String author, @NotNull String title, @NotNull String status) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.status = status;
    }

    public Book(@NotNull Long id, @NotNull String author, @NotNull String title,
                int publicationYear, @NotNull String status) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", status='" + status + '\'' +
                '}';
    }
}
