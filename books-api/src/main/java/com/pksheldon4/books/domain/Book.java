package com.pksheldon4.books.domain;

import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String shortDescription;



    public Book() {

    }

    /**
     * @param name
     * @param shortDescription
     */
    public Book(String name, String shortDescription ) {

        Assert.notNull(name, "Book Name is required.");
        this.name = name;
        this.shortDescription = shortDescription;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (!name.equals(book.name)) return false;
        return shortDescription != null ? shortDescription.equals(book.shortDescription) : book.shortDescription == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                '}';
    }
}
