package com.codegym.service;

import com.codegym.model.SanPham;

import java.util.List;

public interface ISanPhamService {
    List<SanPham> findAll();

    void save(SanPham sanPham);

    SanPham findById(int id);

    void update(int id, SanPham sanPham);

    void remove(int id);

    List<SanPham> searchName(String name);
}
