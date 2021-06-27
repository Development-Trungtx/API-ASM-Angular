package com.trungtx.poly.Repository;

import com.trungtx.poly.Entity.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeProductRepository extends JpaRepository<TypeProduct, Integer> {
    //    @Query("select c from TypeProduct c where c.name =:nameCategory")
    @Query("select c from TypeProduct c where c.name like %:nameCategory%")
    public TypeProduct findByName(@Param("nameCategory") String name);
}

