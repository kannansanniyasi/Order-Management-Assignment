package order.mng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import order.mng.entity.ItemEntity;
import order.mng.repository.ItemRepository;
import order.mng.utils.MessageUtils;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public MessageUtils doSaveItem(ItemEntity itemEntity) {
		// TODO Auto-generated method stub
		MessageUtils msgUtils=new MessageUtils();
		try
		{
			if(checkVaidation(itemEntity))
			{
			itemRepository.save(itemEntity);
			msgUtils.setMessage("Success");
			msgUtils.setToken(true);
			}else
			{
				msgUtils.setMessage("Please Verify Input");
			}
		}catch(Exception e)
		{
			msgUtils.setMessage("Error "+e.getMessage());
		}
		return null;
	}

	private boolean checkVaidation(ItemEntity itemEntity) {
		// TODO Auto-generated method stub
		boolean flg=true;
		if(null==itemEntity.getProductCode() || itemEntity.getProductCode().isEmpty()
				|| itemEntity.getProductName().isEmpty()||null==itemEntity.getProductName()
				||itemEntity.getQuantity().isEmpty()||null==itemEntity.getQuantity()
||itemEntity.getPrice().isEmpty()||null==itemEntity.getPrice())
		{
			flg=false;
		}
		return flg;
	}

	public List<ItemEntity> goGetItemList() {
		// TODO Auto-generated method stub
		return itemRepository.goGetItemList();
	}

	public ItemEntity doGetItem(Long itemId) {
		// TODO Auto-generated method stub
		return itemRepository.doGetItem(itemId);
	}
	
}
