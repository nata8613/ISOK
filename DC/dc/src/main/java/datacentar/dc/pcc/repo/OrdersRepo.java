package datacentar.dc.pcc.repo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import datacentar.dc.pcc.model.Orders;

public interface OrdersRepo extends CrudRepository<Orders, Long>{

	List<Orders> findByAmountLessThanEqual(long amount);
	Orders findByOrderTimestamp (Timestamp orderTimestamp);
	Orders findByPaymentID(long paymentID);
}
