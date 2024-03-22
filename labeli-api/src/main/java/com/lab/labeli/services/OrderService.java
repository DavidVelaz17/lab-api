package com.lab.labeli.services;

import com.lab.labeli.dto.OrderDTO;
import com.lab.labeli.entity.Order;
import com.lab.labeli.form.OrderForm;
import com.lab.labeli.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ValidationsMessages.properties")
public class OrderService {

    private final OrderRepository orderRepository;

    @Value("${not.found}")
    private String notFound;

    public List<OrderDTO> getAllOrders(){
        final List<Order> getAll = orderRepository.findAll();
        return getAll.stream().map(OrderDTO::build).toList();
    }

    public OrderDTO getOrderById(final int idOrder) throws Exception{
        validateIfOrderExists(idOrder);
        final Order order = orderRepository.findById(idOrder).get();
        return OrderDTO.build(order);
    }

    public OrderDTO creteOrder(final OrderForm form){
        final Order order= new Order(form);
        orderRepository.save(order);
        return OrderDTO.build(order);
    }

    public void deleteOrder(final int idOrder) throws Exception {
        validateIfOrderExists(idOrder);
        orderRepository.deleteById(idOrder);
    }

    public OrderDTO updateOrder(final OrderForm form, final int idOrder) throws Exception {
        validateIfOrderExists(idOrder);
        final Order order = orderRepository.findById(idOrder).get();
        order.updateOrder(form);
        orderRepository.save(order);
        return OrderDTO.build(order);
    }

    private void validateIfOrderExists(final int idOrder) throws Exception{
        if(!orderRepository.existsById(idOrder)){
            throw new Exception(notFound);
        }
    }
}
