package com.lab.labeli.services;

import com.lab.labeli.dto.OrderTestDTO;
import com.lab.labeli.dto.TestDTO;
import com.lab.labeli.entity.OrderTest;
import com.lab.labeli.form.OrderTestForm;
import com.lab.labeli.repository.OrderTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ValidationsMessages.properties")
public class OrderTestService {
    private final OrderTestRepository orderTestRepository;
    private final TestService testService;

    @Value("${not.found}")
    private String notFound;

    private void validateIfOrderTestExists(final int idOrderTest) throws Exception {
        if (!orderTestRepository.existsById(idOrderTest)) {
            throw new Exception(notFound);
        }
    }

    public List<OrderTestDTO> getAllOrderTest() {
        final List<OrderTest> getAll = orderTestRepository.findAll();
        return getAll.stream().map(OrderTestDTO::build).toList();
    }

    public OrderTestDTO getOrderTestById(final int idOrderTest) throws Exception {
        validateIfOrderTestExists(idOrderTest);
        final OrderTest getOnlyOrderTest = orderTestRepository.findById(idOrderTest).get();
        return OrderTestDTO.build(getOnlyOrderTest);
    }

    public OrderTestDTO getOrderTestByIdOrder(final int idOrder) {
        final OrderTest order = orderTestRepository.findOrderTestByIdOrder(idOrder);
        return OrderTestDTO.build(order);
    }

    public void deleteOrderTest(final int idOrderTest) throws Exception {
        validateIfOrderTestExists(idOrderTest);
        orderTestRepository.deleteById(idOrderTest);
    }

    public OrderTestDTO createNewOrderTest(final OrderTestForm form) {
        final OrderTest newOrderTest = new OrderTest(form);
        orderTestRepository.save(newOrderTest);
        return OrderTestDTO.build(newOrderTest);
    }

    public OrderTestDTO updateOrderTestById(final OrderTestForm form, final int idOrderTest) throws Exception {
        validateIfOrderTestExists(idOrderTest);
        final OrderTest updateOrderTest = orderTestRepository.findById(idOrderTest).get();
        updateOrderTest.updateOrderTestFunction(form);
        orderTestRepository.save(updateOrderTest);
        return OrderTestDTO.build(updateOrderTest);

    }

    public Map<Integer, OrderTestDTO> getOrdersTestsByIds(final List<Integer> ordersTestsIds) {
        final List<OrderTest> orderTests = orderTestRepository.findAllById(ordersTestsIds);
        final Map<Integer, TestDTO> testDTOMap =
                getTestsByIds(orderTests.stream().map(OrderTest::getIdTest).toList());
        return ordersTestsDTOs(orderTests);
    }

    private Map<Integer, TestDTO> getTestsByIds(final List<Integer> testsIds) {
        return testService.getTestsByIds(testsIds);
    }

    private Map<Integer, OrderTestDTO> ordersTestsDTOs(final List<OrderTest> orderTests) {
        final List<OrderTestDTO> orderTestDTOS = orderTests.stream().map(OrderTestDTO::build).toList();
        return orderTestDTOS.stream().collect(Collectors.toMap(OrderTestDTO::getIdOrderTest, Function.identity()));
    }
}
