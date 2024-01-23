package com.example.demo.service;

import com.example.demo.entity.Peminjam;

import java.util.List;

public interface PeminjamService {
    List<Peminjam> getAllPeminjams();
    Peminjam getPeminjamById(Long id);
    Peminjam addPeminjam(Peminjam peminjam) throws Exception;
    Peminjam updatePeminjam(Long id, Peminjam peminjam);
    void deletePeminjam(Long id);
}