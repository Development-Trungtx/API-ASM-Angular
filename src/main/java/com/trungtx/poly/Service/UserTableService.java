package com.trungtx.poly.Service;

import com.trungtx.poly.Dto.LoginAPI;
import com.trungtx.poly.Dto.UserTableDto;
import com.trungtx.poly.Entity.UserTable;

import java.util.List;
import java.util.Optional;

public interface UserTableService {

    public List<UserTableDto> fildAllUserTable();

    public UserTableDto insertUserTable(UserTableDto userTableDto);

    public UserTableDto updateUserTable(UserTableDto userTableDto);

    public UserTableDto findById(int id);

    public UserTableDto deleteUserTable(int id);

    public Optional<UserTable> checkLogin(LoginAPI loginAPI);

    public boolean checkEmail(String email);

    public UserTableDto findUserByEmail(String email);
}
