package com.example.demo.repository;

import com.example.demo.entity.Peminjam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeminjamRepository extends JpaRepository<Peminjam, Long> {
}