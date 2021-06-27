package com.trungtx.poly.Repository;

import com.trungtx.poly.Entity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserTableReposiitory extends JpaRepository<UserTable, Integer> {

    @Query("select c from UserTable c where c.email like %:nameCust%")
    public UserTable findIdByName(@Param("nameCust") String name);

    @Query("select c from UserTable c where c.email = :nameCust")
    public Optional<UserTable> checkEmail(@Param("nameCust") String name);

    @Transactional
    @Query("select c from UserTable c where c.email = :username and c.passWord = :password")
    public Optional<UserTable> checkLogin(@Param("username") String username, @Param("password") String password);
}
