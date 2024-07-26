package com.rhythmfinders.domain.product.repository;

import com.rhythmfinders.domain.product.aggregate.Product;
import com.rhythmfinders.domain.product.stream.MyObjectOutput;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ProductRepository {
    private ArrayList<Product> productList = new ArrayList<>();

    public int insertProduct(Product newProduct) {

        MyObjectOutput moo = null;

        int result = 0;
        try {
            moo = new MyObjectOutput(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    "src/main/java/com/rhythmfinders/domain/product/db/productDB.dat", true
                            )
                    )
            );
            moo.writeObject(newProduct);
            productList.add(newProduct);
            result = 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            try {
                if (moo != null) moo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public int selectLastpId() {
        Product lastProduct = productList.get(productList.size() - 1);
        return lastProduct.getpId();
    }

    public int deleteProduct(int removeProduct) {
        int result = 0;
        for(int i=0; i< productList.size(); i++) {
            if(productList.get(i).getpId() == removeProduct) {
                productList.remove(i);

                File file = new File("src/main/java/com/rhythmfinders/domain/product/db/productDB.dat");
                saveProducts(file, productList);
                return 1;
            }
        }

        return 0;

    }
}
