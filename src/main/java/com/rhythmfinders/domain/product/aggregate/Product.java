package com.rhythmfinders.domain.product.aggregate;

import java.io.Serializable;

public class Product implements Serializable {
    private int pId;            // 상품번호  auto increment
    private String pName;       // 상품이름
    private int pPrice;         // 상품가격
    private String pPicture;    // 상품사진
    private String pInfo;       // 상품상세
    private int pStock;         // 상품재고
    private String pCompany;    // 제조사
    private PType pType;        // 상품 타입
    private int pNum;           // 상품구매개수
    private boolean isSale;     // 할인여부

    public Product() {
    }

    public Product(int pId, String pName, int pPrice, String pPicture, String pInfo, int pStock, String pCompany
            , PType pType, int pNum, boolean isSale) {
        this.pId = pId;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pPicture = pPicture;
        this.pInfo = pInfo;
        this.pStock = pStock;
        this.pCompany = pCompany;
        this.pType = pType;
        this.pNum = pNum;
        this.isSale = isSale;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public String getpPicture() {
        return pPicture;
    }

    public void setpPicture(String pPicture) {
        this.pPicture = pPicture;
    }

    public String getpInfo() {
        return pInfo;
    }

    public void setpInfo(String pInfo) {
        this.pInfo = pInfo;
    }

    public int getpStock() {
        return pStock;
    }

    public void setpStock(int pStock) {
        this.pStock = pStock;
    }

    public String getpCompany() {
        return pCompany;
    }

    public void setpCompany(String pCompany) {
        this.pCompany = pCompany;
    }

    public PType getpType() {
        return pType;
    }

    public void setpType(PType pType) {
        this.pType = pType;
    }

    public int getpNum() {
        return pNum;
    }

    public void setpNum(int pNum) {
        this.pNum = pNum;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pPrice=" + pPrice +
                ", pPicture='" + pPicture + '\'' +
                ", pInfo='" + pInfo + '\'' +
                ", pStock=" + pStock +
                ", pCompany='" + pCompany + '\'' +
                ", pType=" + pType +
                ", pNum=" + pNum +
                ", isSale=" + isSale +
                '}';
    }
}
