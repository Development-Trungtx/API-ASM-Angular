package com.trungtx.poly.ServiceImpl;

import com.trungtx.poly.Dto.LoginAPI;
import com.trungtx.poly.Dto.UserTableDto;
import com.trungtx.poly.Entity.Order;
import com.trungtx.poly.Entity.UserTable;
import com.trungtx.poly.Repository.OrderRepository;
import com.trungtx.poly.Repository.UserTableReposiitory;
import com.trungtx.poly.Service.UserTableService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserTableServiceImpl implements UserTableService {

    @Autowired
    private UserTableReposiitory userTableReposiitory;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserTableDto> fildAllUserTable() {
        try {
            List<UserTable> userTableList = userTableReposiitory.findAll();
            List<UserTableDto> userTableDtoList = new ArrayList<>();
            for (UserTable userTable : userTableList) {
                userTableDtoList.add(new UserTableDto(userTable.getUserId(), userTable.getUserName(), userTable.getPassWord(), userTable.getRoles(), userTable.getNameCustomer(),
                        userTable.getAge(), userTable.getAddress(), userTable.getBirthday(), userTable.getNumberPhone(), userTable.getEmail(), userTable.getImges()));
            }
            Type listType = new TypeToken<List<UserTableDto>>() {
            }.getType();
            List<UserTableDto> map = modelMapper.map(userTableDtoList, listType);
            return map;
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public UserTableDto insertUserTable(UserTableDto userTableDto) {
        try {
            if (userTableDto.getImges() == null) {
                userTableDto.setImges("https://i.imgur.com/PahrHU9.png");
            }
            UserTable userTable = modelMapper.map(new UserTable(userTableDto.getUserId(), userTableDto.getUserName(), userTableDto.getPassWord(), userTableDto.getRoles(), userTableDto.getNameCustomer(),
                    userTableDto.getAge(), userTableDto.getAddress(), userTableDto.getBirthday(), userTableDto.getNumberPhone(), userTableDto.getEmail(), userTableDto.getImges()), UserTable.class);
            userTableReposiitory.save(userTable);
            return findById(userTable.getUserId());
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public UserTableDto updateUserTable(UserTableDto userTableDto) {
        try {
            List<Order> orderList = orderRepository.findAllByOrderId(userTableDto.getUserId());
            UserTable userTable = modelMapper.map(new UserTable(userTableDto.getUserId(), userTableDto.getUserName(), userTableDto.getPassWord(), userTableDto.getRoles(), userTableDto.getNameCustomer(),
                    userTableDto.getAge(), userTableDto.getAddress(), userTableDto.getBirthday(), userTableDto.getNumberPhone(), userTableDto.getEmail(), userTableDto.getImges(), orderList), UserTable.class);
            userTableReposiitory.save(userTable);
            return findById(userTable.getUserId());
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public UserTableDto findById(int id) {
        try {
            Optional<UserTable> userTable = userTableReposiitory.findById(id);
            UserTableDto userTableDto = modelMapper.map(new UserTableDto(userTable.get().getUserId(), userTable.get().getUserName(), userTable.get().getPassWord(), userTable.get().getRoles(),
                    userTable.get().getNameCustomer(), userTable.get().getAge(), userTable.get().getAddress(), userTable.get().getBirthday(), userTable.get().getNumberPhone(),
                    userTable.get().getEmail(), userTable.get().getImges()), UserTableDto.class);
            return userTableDto;
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public UserTableDto deleteUserTable(int id) {
        try {
            UserTableDto userTableDto = findById(id);
            userTableReposiitory.deleteById(id);
            return userTableDto;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Optional<UserTable> checkLogin(LoginAPI loginAPI) {
        return userTableReposiitory.checkLogin(loginAPI.getUserN(), loginAPI.getPassW());
    }

    @Override
    public boolean checkEmail(String email) {
        Optional<UserTable> userTable = userTableReposiitory.checkEmail(email);
        if (userTable.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserTableDto findUserByEmail(String email) {
        try {
            UserTable userTable = userTableReposiitory.findIdByName(email);
            UserTableDto userTableDto = modelMapper.map(new UserTableDto(userTable.getUserId(), userTable.getUserName(), userTable.getPassWord(), userTable.getRoles(),
                    userTable.getNameCustomer(), userTable.getAge(), userTable.getAddress(), userTable.getBirthday(), userTable.getNumberPhone(),
                    userTable.getEmail(), userTable.getImges()), UserTableDto.class);
            return userTableDto;
        } catch (Exception exception) {
            return null;
        }
    }


}
