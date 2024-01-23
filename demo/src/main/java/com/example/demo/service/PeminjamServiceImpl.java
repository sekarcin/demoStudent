package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Peminjam;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PeminjamRepository;
import com.example.demo.service.PeminjamService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class PeminjamServiceImpl implements PeminjamService {

    @Autowired
    private PeminjamRepository peminjamRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Peminjam> getAllPeminjams() {
        return peminjamRepository.findAll();
    }

    @Override
    public Peminjam getPeminjamById(Long id) {
        return peminjamRepository.findById(id).orElse(null);
    }

    @Override
    public Peminjam addPeminjam(Peminjam peminjam) throws Exception {
        Book book = bookRepository.findById(peminjam.getBook().getId()).orElse(null);

        if (book != null) {
            peminjam.setBook(book);
            return peminjamRepository.save(peminjam);
        } else {
            throw new EntityNotFoundException("Buku dengan ID " + peminjam.getBook().getId() + " tidak ditemukan.");
        }
    }

    @Override
    public Peminjam updatePeminjam(Long id, Peminjam peminjam) {
        peminjam.setId(id);
        return peminjamRepository.save(peminjam);
    }

    @Override
    public void deletePeminjam(Long id) {
        peminjamRepository.deleteById(id);
    }
}