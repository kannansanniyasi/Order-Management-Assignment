package order.mng.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import order.mng.entity.OrderEntity;

@Transactional
@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

	@Query("from OrderEntity")
	List<OrderEntity> goGetOrderList();

	@Query("from OrderEntity o where o.id=:orderId")
	OrderEntity getOrderId(@Param("orderId") Long orderId);

}
