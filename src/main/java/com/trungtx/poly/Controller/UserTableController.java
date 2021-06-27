package com.trungtx.poly.Controller;

import com.trungtx.poly.Dto.CheckEmail;
import com.trungtx.poly.Dto.LoginAPI;
import com.trungtx.poly.Dto.RoleDto;
import com.trungtx.poly.Dto.UserTableDto;
import com.trungtx.poly.Entity.UserTable;
import com.trungtx.poly.Service.UserTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserTableController {

    @Autowired
    private UserTableService userTableService;

    @GetMapping("/users")
    public List<UserTableDto> getAllUser() {
        return userTableService.fildAllUserTable();
    }

    @GetMapping(value = "/users/{id}")
    public UserTableDto getById(@PathVariable int id) {
        return userTableService.findById(id);
    }

    @PostMapping("/users")
    public UserTableDto save(@RequestBody UserTableDto userTableDto) {
        return userTableService.insertUserTable(userTableDto);
    }

    @PutMapping("/users/{id}")
    public UserTableDto update(@RequestBody UserTableDto userTableDto, @PathVariable int id) {
        userTableDto.setUserId(id);
        return userTableService.updateUserTable(userTableDto);
    }

    @DeleteMapping("/users/{id}")
    public UserTableDto delete(@PathVariable int id) {
        return userTableService.deleteUserTable(id);
    }

    @PostMapping(value = "/checkLogin")
    public RoleDto check(@RequestBody LoginAPI loginAPI) {
        RoleDto roleDto = new RoleDto();
        Optional<UserTable> userTable = userTableService.checkLogin(loginAPI);
        if (userTable.isPresent()) {
            roleDto.setRole(userTable.get().getRoles());
            roleDto.setNameCus(userTable.get().getNameCustomer());
            roleDto.setImgesCus(userTable.get().getImges());
            return roleDto;
        }
        return null;
    }

    @GetMapping("/checkEmail/{email}")
    public CheckEmail checkEmail(@PathVariable String email) {
        CheckEmail checkEmail = new CheckEmail();
        if (userTableService.checkEmail(email)) {
            checkEmail.setCheckMail(true);
            return checkEmail;
        } else {
            checkEmail.setCheckMail(false);
            return checkEmail;
        }
    }

    @GetMapping("/userEmail/{usEmail}")
    public UserTableDto getEmail(@PathVariable String usEmail){
        return userTableService.findUserByEmail(usEmail);
    }
}
