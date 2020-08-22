package order.mng.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import order.mng.entity.OrderEntity;
import order.mng.repository.OrderRepository;
import order.mng.utils.MessageUtils;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public List<OrderEntity> goGetOrderList()
	{
		List<OrderEntity> orderList=new ArrayList<OrderEntity>();
		try
		{
		orderList=orderRepository.goGetOrderList();
		System.out.println("Size :"+orderList.size());
		}catch(Exception e)
		{
			System.out.println("Error :"+e.getMessage());
		}
		return orderList;
	}

	public Optional<OrderEntity> getOrderById(Long orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId);
	}

	public MessageUtils saveOrder(OrderEntity order) {
		// TODO Auto-generated method stub
		MessageUtils msg=new MessageUtils();
		try
		{
			boolean validationFlg=validateOrderDetails(order);
			if(validationFlg)
			{
				orderRepository.save(order);
				msg.setMessage("success");
				msg.setToken(true);
			}else
			{
				msg.setMessage("Please Verify Order Details");
				msg.setToken(false);
			}
		}catch(Exception e)
		{
			msg.setMessage("Error :"+e.getMessage());
			msg.setToken(false);
		}
		
		return msg;
	}

	private boolean validateOrderDetails(OrderEntity order) {
		// TODO Auto-generated method stub
		boolean flg=true;
		  if(null==order.getCustomerName() || order.getCustomerName().isEmpty() 
				  ||null==order.getOrderDate() || order.getOrderDate().isEmpty()
				  ||null==order.getOrderDate() || order.getOrderDate().isEmpty()
				  ||null==order.getOrderItems()||null==order.getShippingAddress()||order.getShippingAddress().isEmpty()
				  ||null==order.getTotal()||order.getTotal().isEmpty())
		  {
			  flg=false; 
		  }
		return flg;
	}

	
}
