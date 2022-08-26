package ntthanh.project.service;

import ntthanh.project.entity.Orders;
import ntthanh.project.dto.DtoOrder;

import java.util.Date;
import java.util.List;

public interface OrderService {
    void order(DtoOrder dtoOrder);
    List<Orders> getOrderByAccount(String account);
    List<Orders> getListOrder(Date startDate, Date endDate);
    Orders findById(int id);
    void save(Orders orders);
    void delete(int id);
}
