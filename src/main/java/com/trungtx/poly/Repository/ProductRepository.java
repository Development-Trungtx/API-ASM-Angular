package com.trungtx.poly.Repository;

import com.trungtx.poly.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select c from Product c order by c.productId desc ")
    public List<Product> findAll();

    @Query("select c from Product c where c.name = :nameProduct")
    public Product findIdByNamePro(@Param("nameProduct") String name);

    @Query("select c from Product c where c.typeId.typeId = :id")
    public List<Product> findAllByTypeId(@Param("id") int id);

}
