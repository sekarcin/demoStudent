package com.example.demo.controller;

import com.example.demo.entity.Peminjam;
import com.example.demo.service.PeminjamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/peminjams")
public class PeminjamController {

    @Autowired
    private PeminjamService peminjamService;

    @PostMapping
    public Peminjam addPeminjam(@RequestBody Peminjam peminjam) throws Exception {
        return peminjamService.addPeminjam(peminjam);
    }

    @GetMapping
    public List<Peminjam> getAllPeminjams() {
        return peminjamService.getAllPeminjams();
    }

    @GetMapping("/{id}")
    public Peminjam getPeminjamById(@PathVariable Long id) {
        return peminjamService.getPeminjamById(id);
    }

    @PutMapping("/{id}")
    public Peminjam updatePeminjam(@PathVariable Long id, @RequestBody Peminjam peminjam) {
        return peminjamService.updatePeminjam(id, peminjam);
    }

    @DeleteMapping("/{id}")
    public void deletePeminjam(@PathVariable Long id) {
        peminjamService.deletePeminjam(id);
    }
}