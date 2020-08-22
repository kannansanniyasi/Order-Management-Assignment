package order.mng.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import order.mng.entity.ItemEntity;
@Transactional
@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, Long> {

	@Query("from ItemEntity")
	List<ItemEntity> goGetItemList();

	@Query("from ItemEntity i where i.id=:itemId ")
	ItemEntity doGetItem(Long itemId);

}
