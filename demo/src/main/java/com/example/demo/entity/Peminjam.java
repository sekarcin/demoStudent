package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Peminjam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namaPeminjam;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private Date tanggalMasuk;

    private Date tanggalKeluar;
}