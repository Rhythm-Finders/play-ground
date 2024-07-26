package com.rhythmfinders.domain.product.service;

import com.rhythmfinders.domain.product.aggregate.Product;
import com.rhythmfinders.domain.product.repository.ProductRepository;

public class ProductService {

    /* 설명. Repository를 Service 내부에서만 불러서 사용하기 위해서 private final 객체 생성*/
    private final ProductRepository pr = new ProductRepository();

    public ProductService() {
    }

    public void findAllProducts() {

    }

    public void findProductBy(int i) {
    }

    public void registProduct(Product product) {
    }

    public void removeProduct(int i) {
    }

    public void modifyProduct(int i, Product product) {
    }
}
