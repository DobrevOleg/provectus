package com.dobrev.bookshop.repo;
import com.dobrev.bookshop.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<OrderEntity, Integer> {
}
