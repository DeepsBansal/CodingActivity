/**
 * 
 */
package com.ibm.OrderProcessService.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ibm.OrderProcessService.models.OderDTO;
import com.ibm.OrderProcessService.models.Order;
import com.ibm.OrderProcessService.models.OrderMapper;
import com.ibm.OrderProcessService.repository.OrderProcessRepository;

/**
 * @author w2cluster249
 *
 */

@Service
public class MyUserDetailsService implements  UserDetailsService{
	
	
	  @Autowired private OrderProcessRepository orderProcessRepository;
	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return new User("foo","foo", new ArrayList<>());
	}

	
	  public OderDTO saveOrder(OderDTO orderdto) { OrderMapper mapper=new
	  OrderMapper(); Order order= mapper.convertOrderDTOToOrder(orderdto);
	  
	  Order order1= orderProcessRepository.save(order); return
	  mapper.convertCurrencyToCurrencyDTO(order1);
	  
	  }
	 

}
