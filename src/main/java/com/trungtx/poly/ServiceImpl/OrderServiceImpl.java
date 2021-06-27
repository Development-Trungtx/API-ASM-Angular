package com.trungtx.poly.ServiceImpl;

import com.trungtx.poly.Dto.OrderDto;
import com.trungtx.poly.Entity.Order;
import com.trungtx.poly.Entity.UserTable;
import com.trungtx.poly.Repository.OrderRepository;
import com.trungtx.poly.Repository.OrderRepositoryExample;
import com.trungtx.poly.Repository.UserTableReposiitory;
import com.trungtx.poly.Service.OrderTableService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderTableService {

    @Autowired
    private OrderRepositoryExample orderRepositoryExample;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserTableReposiitory userTableReposiitory;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<OrderDto> fildAllOrder() {
        try {
            List<Order> orderList = orderRepository.findAll();
            List<OrderDto> orderDtos = new ArrayList<>();
            for (Order order : orderList) {
                orderDtos.add(new OrderDto(order.getOrderId(), order.getDayOrder(), order.getNameOrder(),
                        order.getTotal_money(), order.getUserTable().getEmail(), order.getAddressOrder(), order.getCusNameOrder(), order.getNumbPhone()));
            }
            Type listType = new TypeToken<List<OrderDto>>() {
            }.getType();
            List<OrderDto> dtos = modelMapper.map(orderDtos, listType);
            return dtos;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public OrderDto insertOrder(OrderDto orderDto) {
        try {
//            UUID uuid = UUID.randomUUID();
//            orderDto.setNameOrder("Order number:" + uuid.toString());
            Timestamp timestamp = new Timestamp(new Date().getTime());
            orderDto.setDayOrder(timestamp);
            UserTable userTable = userTableReposiitory.findIdByName(orderDto.getEmailUser());
            Order order = modelMapper.map(new Order(null, orderDto.getDayOrder(), orderDto.getNameOrder(), orderDto.getTotal_money(),
                    orderDto.getAddressOrder(), orderDto.getCusNameOrder(), orderDto.getNumbPhone(), userTable), Order.class);
            orderRepositoryExample.orderSave(order);
            return findById(order.getOrderId());
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        try {
            UserTable userTable = userTableReposiitory.findIdByName(orderDto.getEmailUser());
            Order order = modelMapper.map(new Order(orderDto.getOrderId(), orderDto.getDayOrder(), orderDto.getNameOrder(), orderDto.getTotal_money(),
                    orderDto.getAddressOrder(), orderDto.getCusNameOrder(), orderDto.getNumbPhone(), userTable), Order.class);
            orderRepository.save(order);
            return findById(order.getOrderId());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public OrderDto findById(int id) {
        try {
            Optional<Order> order = orderRepository.findById(id);
            OrderDto orderDto = modelMapper.map(new OrderDto(order.get().getOrderId(), order.get().getDayOrder(), order.get().getNameOrder()
                    , order.get().getTotal_money(), order.get().getUserTable().getUserName(), order.get().getAddressOrder(),
                    order.get().getCusNameOrder(), order.get().getNumbPhone()), OrderDto.class);
            return orderDto;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public OrderDto deleteOrder(int id) {
        try {
            OrderDto order = findById(id);
            orderRepository.deleteById(id);
            return order;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<OrderDto> findAllOrderByUser(int id) {
        try {
            List<Order> orderList = orderRepository.findAllByOrderId(id);
            List<OrderDto> orderDtos = new ArrayList<>();
            for (Order order : orderList) {
                orderDtos.add(new OrderDto(order.getOrderId(), order.getDayOrder(), order.getNameOrder(),
                        order.getTotal_money(), order.getUserTable().getEmail(), order.getAddressOrder(), order.getCusNameOrder(), order.getNumbPhone()));
            }
            Type listType = new TypeToken<List<OrderDto>>() {
            }.getType();
            List<OrderDto> dtos = modelMapper.map(orderDtos, listType);
            return dtos;
        } catch (Exception e) {
            return null;
        }
    }


}
