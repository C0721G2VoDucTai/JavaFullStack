package com.codegym.service;

import com.codegym.model.SanPham;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import java.util.List;

@Service
public class SanPhamService implements ISanPhamService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List< SanPham > findAll() {
        List<SanPham> sanPhamList = entityManager
                .createQuery("select p from SanPham as p",SanPham.class).getResultList();
        return sanPhamList;
    }

    @Override
    public void save(SanPham sanPham) {

    }

    @Override
    public SanPham findById(int id) {
        return null;
    }

    @Override
    public void update(int id, SanPham sanPham) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<SanPham> searchName(String name) {
        return null;
    }
}
