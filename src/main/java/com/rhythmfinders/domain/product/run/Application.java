package com.rhythmfinders.domain.product.run;

import com.rhythmfinders.domain.product.aggregate.PType;
import com.rhythmfinders.domain.product.aggregate.Product;
import com.rhythmfinders.domain.product.service.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Application {

    private static final ProductService ps = new ProductService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("===== 상품 관리 프로그램 =====");
            System.out.println("1. 모든 상품 정보 보기");
            System.out.println("2. 상품 찾기");
            System.out.println("3. 상품 가입");
            System.out.println("4. 상품 삭제");
            System.out.println("5. 상품 수정");
            System.out.println("9. 프로그램 종료");
            System.out.println("메뉴를 선택해 주세요: ");

            int input = sc.nextInt();

            switch(input){
                case 1: ps.findAllProducts(); break;
                /* 설명. 입력이 필요해서 main에서 입력 메소드를 지정(chooseMemNo()같은)
                 *       서비스 전에 입력을 받아야 하는 것이다.
                 *  */
                case 2: ps.findProductBy(choosePid()); break;
                case 3: ps.registProduct(signUp()); break;
                case 4: ps.removeProduct(choosePid()); break;
                case 5: Product chooseProduct = ps.bringInfo(choosePid());
                        ps.modifyProduct(reformProduct(chooseProduct));
                case 9:
                    System.out.println("상품관리 프로그램을 종료합니다. "); return; //메인 종료
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
    }

    private static Product signUp() {
        Product newProduct = null;

        /* 설명. bufferedreader로 수정 예정*/
        Scanner sc = new Scanner(System.in);

        System.out.println("상품이름을 입력하세요: ");
        String pName = sc.nextLine();

        System.out.println("상품가격을 입력하세요: ");
        int pPrice = sc.nextInt();
        sc.nextLine();

        /* 설명. 주소값을 입력 */
        System.out.println("상품사진을 입력하세요: ");
        String pPicture = sc.nextLine();

        /* 설명. 주소값을 입력 */
        System.out.println("상품상세를 입력하세요: ");
        String pInfo = sc.nextLine();

        System.out.println("상품재고를 입력하세요: ");
        int pStock = sc.nextInt();
        sc.nextLine();

        System.out.println("제조사를 입력하세요: ");
        String pCompany = sc.nextLine();

        System.out.println("상품 카테고리를 입력하세요(FOOD, FASHION, DEVICE, BEAUTY): ");
        String pType = sc.nextLine().toUpperCase();
        PType pT = null;

        switch(pType){
            case "FOOD": pT = PType.FOOD; break;
            case "FASHION": pT = PType.FASHION; break;
            case "DEVICE": pT = PType.DEVICE; break;
            case "BEAUTY": pT = PType.BEAUTY; break;
        }
        
        newProduct = new Product(pName, pPrice, pPicture, pInfo,pStock, pCompany, pT);

        return newProduct;
    }

    private static void checkSale(Product modifiedProduct, String chkSale) {
        boolean chkSaleFlag = modifiedProduct.isSale();
        if(chkSale.equals("네")){
            chkSaleFlag = true;
        }
        else if(chkSale.equals("아니오")){
            chkSaleFlag = false;
        }
        modifiedProduct.setSale(chkSaleFlag);
    }

    /* 설명. 회원 ID를 입력받아 반환하는 메소드 */
    private static int choosePid() {
        Scanner sc = new Scanner(System.in);
        System.out.println("상품의 번호를 입력하세요: ");
        return sc.nextInt();
    }

    private static Product reformProduct(Product chooseProduct) {

        Scanner sc = new Scanner(System.in);
        System.out.println("1.상품이름, 2.상품가격, 3.상품사진, 4.상품상세, 5.상품재고, 6.제조사 7.상품 카테고리");
        System.out.print("수정할 부분을 선택하시오: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice){
            case 1:
                System.out.println("수정할 상품 이름을 입력하시오: ");
                String pName = sc.nextLine();
                chooseProduct.setpName(pName); break;
            case 2:
                System.out.println("수정할 상품 이름을 입력하시오: ");
                String pName = sc.nextLine();
                chooseProduct.setpName(pName); break;
            case 3:
                System.out.println("수정할 상품 이름을 입력하시오: ");
                String pName = sc.nextLine();
                chooseProduct.setpName(pName); break;
            case 4:
                System.out.println("수정할 상품 이름을 입력하시오: ");
                String pName = sc.nextLine();
                chooseProduct.setpName(pName); break;
            case 5:
                System.out.println("수정할 상품 이름을 입력하시오: ");
                String pName = sc.nextLine();
                chooseProduct.setpName(pName); break;
            case 6:
                System.out.println("수정할 상품 이름을 입력하시오: ");
                String pName = sc.nextLine();
                chooseProduct.setpName(pName); break;
            case 7:
                System.out.println("수정할 상품 이름을 입력하시오: ");
                String pName = sc.nextLine();
                chooseProduct.setpName(pName); break;
            default:
                System.out.println("잘못된 번호를 입력하셨습니다.");
        }
        ;
    }


}

