package order.mng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import order.mng.entity.ItemEntity;
import order.mng.service.ItemService;
import order.mng.utils.MessageUtils;

@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired 
	ItemService itemService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public MessageUtils  doSaveItem(@RequestBody ItemEntity itemEntity)
	{
		return itemService.doSaveItem(itemEntity);
	}
	@GetMapping("/itemList")
	public List<ItemEntity> goGetItemList()
	{
		return itemService.goGetItemList();
	}
	
	@GetMapping("/itemList/{id}")
	public ItemEntity doGetItem(@PathVariable(value="id") Long itemId)
	{
		return itemService.doGetItem(itemId);
	}
	
}
