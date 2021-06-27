package com.trungtx.poly.Repository;

import com.trungtx.poly.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("select c from Order c where c.nameOrder = :nameOd")
    public Order findIdByNameOder(@Param("nameOd") String name);

    @Query("select c from Order c where c.userTable.userId = :id")
    public List<Order> findAllByOrderId(@Param("id") int id);

}
