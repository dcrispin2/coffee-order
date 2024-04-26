package edu.iu.dcrispin.coffeeorder.controllers;

import edu.iu.dcrispin.coffeeorder.model.OrderData;
import edu.iu.dcrispin.coffeeorder.model.Receipt;
import edu.iu.dcrispin.coffeeorder.repository.OrderRepository;
import edu.iu.dcrispin.coffeeorder.repository.ReceiptRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {
    private OrderRepository orderRepository;
    private ReceiptRepository receiptRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.receiptRepository = receiptRepository;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody OrderData order) {
        try {
            Receipt receipt = orderRepository.add(order);
            System.out.println(receipt);
            receiptRepository.save(receipt);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(receipt);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
