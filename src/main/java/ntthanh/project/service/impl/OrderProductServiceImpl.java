package ntthanh.project.service.impl;

import ntthanh.project.repository.OrderProductRepository;
import ntthanh.project.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ntthanh.project.entity.OrderProduct;

import java.util.List;

@Service
public class OrderProductServiceImpl implements OrderProductService {
    @Autowired
    private OrderProductRepository orderProductRepository;
    @Override
    public void save(OrderProduct orderProduct) {
        this.orderProductRepository.save(orderProduct);
    }

    @Override
    public List<OrderProduct> findAll(String account) {
        return this.orderProductRepository.findAllByOrders_Account_Account(account);
    }

    @Override
    public Page<OrderProduct> findAllOrder(Pageable pageable) {
        return this.orderProductRepository.findAll(pageable);
    }

    @Override
    public Page<OrderProduct> search(String key, Pageable pageable) {
        return this.orderProductRepository.findAllByOrders_AccountAccountContaining(key, pageable);

    }

    @Override
    public OrderProduct findById(int id) {
        return this.orderProductRepository.findAllByOrdersOrdersId(id);
    }

    @Override
    public void delete(Integer id) {
        this.orderProductRepository.deleteAllByOrdersOrdersId(id);
    }

}
