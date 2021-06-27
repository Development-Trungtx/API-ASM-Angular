package com.trungtx.poly.Controller;

import com.trungtx.poly.Dto.OrderDto;
import com.trungtx.poly.Service.OrderTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderTableService orderTableService;

    @GetMapping(value = "/orderPro", produces = "application/json")
    public List<OrderDto> getAll() {
        return orderTableService.fildAllOrder();
    }

    @GetMapping(value = "/orderPro/{id}", produces = "application/json")
    public OrderDto getById(@PathVariable int id) {
        return orderTableService.findById(id);
    }

    @PostMapping("/orderPro")
    public OrderDto save(@RequestBody OrderDto orderDto) {
        return orderTableService.insertOrder(orderDto);
    }

    @PutMapping("/orderPro/{id}")
    public OrderDto update(@RequestBody OrderDto orderDto, @PathVariable int id) {
        orderDto.setOrderId(id);
        return orderTableService.updateOrder(orderDto);
    }

    @DeleteMapping("/orderPro/{id}")
    public OrderDto delete(@PathVariable int id) {
        return orderTableService.deleteOrder(id);
    }

    @GetMapping(value = "/orderByUser/{id}", produces = "application/json")
    public List<OrderDto> getAllOrderByUser(@PathVariable int id) {
        return orderTableService.findAllOrderByUser(id);
    }

}
