package com.trungtx.poly.Service;

import com.trungtx.poly.Dto.OrderDto;

import java.util.List;

public interface OrderTableService {

    public List<OrderDto> fildAllOrder();

    public OrderDto insertOrder(OrderDto orderDto);

    public OrderDto updateOrder(OrderDto orderDto);

    public OrderDto findById(int id);

    public OrderDto deleteOrder(int id);

    public List<OrderDto> findAllOrderByUser(int id);
}
