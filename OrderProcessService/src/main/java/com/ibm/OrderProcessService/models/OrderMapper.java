/**
 * 
 */
package com.ibm.OrderProcessService.models;

/**
 * @author w2cluster249
 *
 */
public class OrderMapper {

	public Order convertOrderDTOToOrder(OderDTO orderdto) {
	Order order = new Order();
	order.setId(orderdto.getId());
	order.setCustomerName(orderdto.getCustomerName());
	order.setItemDetails(orderdto.getItemDetails());
		return order;
	}

	public OderDTO convertCurrencyToCurrencyDTO(Order order1) {
		OderDTO dto = new OderDTO();
		dto.setId(order1.getId());
		dto.setCustomerName(order1.getCustomerName());
		dto.setItemDetails(order1.getItemDetails());
		return dto;
	}

}
