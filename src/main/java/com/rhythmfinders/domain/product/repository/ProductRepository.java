package com.rhythmfinders.domain.product.repository;

import com.rhythmfinders.domain.product.aggregate.PType;
import com.rhythmfinders.domain.product.aggregate.Product;
import com.rhythmfinders.domain.product.stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ProductRepository {

    private ArrayList<Product> ProductList = new ArrayList<>();

    /* 설명. 처음에 data를 insert하기 전에 4개의 물품을 미리 넣어두기 위한 메소드 */
    public ProductRepository() {

        File file = new File("src/main/java/com/rhythmfinders/domain/product/db/ProductDB.dat");

        if(!(file.exists())){
            ArrayList<Product> defaultProduct = new ArrayList<>();
            defaultProduct.add(new Product(1, "햄버거", 6800, "www.mcdonals.co.kr/jpg1" ,
                    "www.mcdonalds.co.kr/info1", 30, "맥도날드", PType.FOOD, 2, true));
            defaultProduct.add(new Product(2, "스투시 반팔", 89300,"https://kr.stussy.com/jpg1"
                    ,"https://kr.stussy.com/info1", 25, "스투시", PType.FASHION
                    , 1, false));
            defaultProduct.add(new Product(3, "아이폰16pro", 1850000
                    , "www.apple.co.kr/jpg1" ,"www.apple.co.kr/info1",10, "애플",
                    PType.DEVICE, 1, false));
            defaultProduct.add(new Product(4,"L썬크림",48000,"https://www.lancome.co.kr/jpg1"
                    ,"https://www.lancome.co.kr/info1", 100, "랑콤", PType.BEAUTY
                    ,4, true));

            /* 설명. 초기 넣은 4개의 데이터를 출력해보는 메소드*/
            saveProduct(file, ProductList);
        }

        loadProduct(file, ProductList);
    }

    private void loadProduct(File file, ArrayList<Product> Products) {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("src/main/java/com/rhythmfinders/domain/product/db/ProductDB.dat")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void saveProduct(File file, ArrayList<Product> Products) {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("src/main/java/com/rhythmfinders/domain/product/db/ProductDB.dat")));

            Iterator<Product> iterator = ProductList.iterator();
            while (iterator.hasNext()) {

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public int insertProduct(Product newProduct) {

        MyObjectOutput moo = null;

        int result = 0;
        try {
            moo = new MyObjectOutput(
                    new BufferedOutputStream(
                            new FileOutputStream("src/main/java/com/rhythmfinders/domain/product/db/productDB.dat"
                                    , true)));
            moo.writeObject(newProduct);
            ProductList.add(newProduct);
            result = 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (moo != null) moo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return result;
        }
    }

    public int selectLastpId() {
        Product lastProduct = ProductList.get(ProductList.size() - 1);
        return lastProduct.getpId();
    }


    public int deleteProduct(int removeProduct) {
        int result = 0;
        for(int i=0; i< ProductList.size(); i++) {
            if(ProductList.get(i).getpId() == removeProduct) {
                ProductList.remove(i);

                File file = new File("src/main/java/com/rhythmfinders/domain/product/db/productDB.dat");
                saveProduct(file, ProductList);
                return 1;
            }
        }
        return 0;
    }

    public int updateProduct(Product reform) {
        for(int i=0; i< ProductList.size(); i++) {
            Product updateProduct = ProductList.get(i);
            if(updateProduct.getpId() == reform.getpId()) {
                ProductList.set(i, reform);

                File file = new File("src/main/java/com/rhythmfinders/domain/product/db/productDB.dat");
                saveProduct(file, ProductList);

                if(updateProduct.equals(reform)) return 1;
            }
        }
        return 0;
    }
}
