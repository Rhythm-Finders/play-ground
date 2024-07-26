package com.rhythmfinders.domain.product.service;

import com.rhythmfinders.domain.product.aggregate.Product;
import com.rhythmfinders.domain.product.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductService {

    /* 설명. Repository를 Service 내부에서만 불러서 사용하기 위해서 private final 객체 생성*/
    private final ProductRepository pr = new ProductRepository();

    public ProductService() {
    }

    public void findAllProducts() {
        ArrayList<Product> findProduct = pr.selectAllProduct();

        Iterator<Product> iter = findProduct.iterator();
        while(iter.hasNext()){
            System.out.println("Product: " + iter.next());
        }
    }

    public void findProductBy(int i) {
    }

    public void registProduct(Product newProduct) {
        int lastPID = pr.selectLastpId();
        newProduct.setpId(lastPID + 1);
        int result = pr.insertProduct(newProduct);
        if(result == 1)
            System.out.println("상품번호: " +newProduct.getpId() + "번 " +
                    newProduct.getpName() + "이(가) 등록되었습니다.");
    }

    public void removeProduct(int removeProduct) {
        /* 필기. 상품을 지울 때, 등록했던 사용자인지 확인하는 기능을 추가하면 좋겠다. */
        int result = pr.deleteProduct(removeProduct);

        if(result == 1){
            System.out.println("상품이 삭제되었습니다.");
            return;
        }

        System.out.println("해당 상품 번호가 존재하지 않습니다. . .");
    }

    public void modifyProduct(Product reform) {
        int result = pr.updateProduct(reform);
        if(result == 1){
            System.out.println("수정 성공!");
            return;
        }

        System.out.println("수정 내역 없음");
    }

//    public Product findProductForMod(int pid) {
////        Product selectedProduct = pr.
//        return null;
//    }
}
