package com.trungtx.poly.Repository;

import com.trungtx.poly.Entity.Cart_Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProRepository extends JpaRepository<Cart_Product, Integer> {

    @Query("select c from Cart_Product c where c.order.orderId =:orderN")
    public List<Cart_Product> findCartByOder(@Param("orderN") int name);
}
