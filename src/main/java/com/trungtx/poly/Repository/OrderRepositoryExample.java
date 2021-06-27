package com.trungtx.poly.Repository;

import com.trungtx.poly.Entity.Order;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class OrderRepositoryExample {

    @PersistenceContext
    private EntityManager entityManager;

    public void orderSave(Order order) {
        Session session = entityManager.unwrap(Session.class);
        session.save(order);
    }
}
