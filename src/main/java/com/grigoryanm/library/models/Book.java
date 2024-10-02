package com.grigoryanm.library.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Long isbn;
    private String status;
}
