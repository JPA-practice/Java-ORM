package org.example.entity.item;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class Book {

    private String author;
    private String isbn;

}
