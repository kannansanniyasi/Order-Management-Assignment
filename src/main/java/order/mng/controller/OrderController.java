package order.mng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import order.mng.entity.OrderEntity;
import order.mng.exception.OrderNotFoundException;
import order.mng.service.OrderService;
import order.mng.utils.MessageUtils;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/message")
	public String displayMsg()
	{
		return "Welcome To Rest API";
	}
	
	@RequestMapping(value="/orderList",method=RequestMethod.GET)
	public List<OrderEntity> goGetOrderList()
	{
		List<OrderEntity> orderList=orderService.goGetOrderList();
		System.out.println("Order List :"+orderList.size());
		return orderList;
	}
	
	@GetMapping("/orderId/{id}")
	public ResponseEntity<OrderEntity> getOrderById(@PathVariable(value="id") Long orderId) throws OrderNotFoundException
	{
		OrderEntity orderEntity=orderService.getOrderById(orderId).orElseThrow(()->new OrderNotFoundException("Order ID Not Found for this order Id"+orderId));
		return ResponseEntity.ok().body(orderEntity);
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public MessageUtils saveOrder(@RequestBody OrderEntity order)
	{
		MessageUtils msgUtils=orderService.saveOrder(order);
		
		return msgUtils;
	}
	
	
	
}
