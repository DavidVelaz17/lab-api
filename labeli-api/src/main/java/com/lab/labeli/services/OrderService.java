package com.lab.labeli.services;

import com.lab.labeli.dto.*;
import com.lab.labeli.entity.Order;
import com.lab.labeli.entity.User;
import com.lab.labeli.form.OrderForm;
import com.lab.labeli.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ValidationsMessages.properties")
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final UserService userService;
    private final OrderTestService orderTestService;

    @Value("${not.found}")
    private String notFound;

    public List<OrderDTO> getAllOrders(){
        final List<Order> orders = orderRepository.findAll();
        final Map<Integer, CustomerDTO> customerDTOMap =
                getCustomersMap(orders.stream().map(Order::getIdCustomers).toList());
        final Map<Integer, UserDTO> userDTOMap =
                getUsersMap(orders.stream().map(Order::getIdUsers).toList());
        final Map<Integer, OrderTestDTO> orderTestDTOMap =
                getOrderTestsByIds(orders.stream().map(Order::getIdOrders).toList());
        return orders
                .stream()
                .map(order -> OrderDTO
                    .build(order,
                            userDTOMap
                                .get(order.getIdUsers()),
                            customerDTOMap
                                .get(order.getIdCustomers()),
                            orderTestDTOMap
                                .get(order.getIdOrders())
                    ))
                .sorted(Comparator.comparing(OrderDTO::getIdOrders).reversed())
                .toList();
    }

    public OrderDTO getOrderById(final int idOrder) throws Exception{
        validateIfOrderExists(idOrder);
        final Order order = orderRepository.findById(idOrder).get();
        final UserDTO userDTO = userService.getUserById(order.getIdUsers());
        final CustomerDTO customerDTO = customerService.getCustomerById(order.getIdCustomers());
        final OrderTestDTO orderTestDTO = orderTestService.getOrderTestByIdOrder(order.getIdOrders());
        return OrderDTO.build(order,userDTO,customerDTO,orderTestDTO);
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

    private Map<Integer, CustomerDTO> getCustomersMap(final List<Integer> customersIds){
        return customerService.getCustomersByIds(customersIds);
    }

    private Map<Integer, UserDTO> getUsersMap(final List<Integer> usersIds){
        return userService.getUsersByIds(usersIds);
    }

    private Map<Integer, OrderTestDTO> getOrderTestsByIds(final List<Integer> ordersTestsIds) {
        return orderTestService.getOrdersTestsByIds(ordersTestsIds);
    }
}
