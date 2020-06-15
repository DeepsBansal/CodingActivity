/**
 * 
 */
package com.ibm.OrderProcessService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ibm.OrderProcessService.models.Order;

/**
 * @author Deepika Bansal
 *
 */


  @Repository 
  public interface OrderProcessRepository extends
  JpaRepository<Order, Long>{
  
  }
 
