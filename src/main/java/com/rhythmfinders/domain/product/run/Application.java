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
        /* 설명. 여기서 메뉴는 요구사항 명세이다.
         * */
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
//                case 5: ps.modifyProduct(choosePid(), modifyUp()); break;
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

        /* 설명. 주소값을 입력 */
        System.out.println("상품사진을 입력하세요: ");
        String pPicture = sc.nextLine();

        /* 설명. 주소값을 입력 */
        System.out.println("상품상세를 입력하세요: ");
        String pInfo = sc.nextLine();

        System.out.println("상품재고를 입력하세요: ");
        int pStock = sc.nextInt();

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

        new Product(pName, pPrice, pPicture, pInfo, pStock, pCompany, pT);

        newProduct = new Product(pName, pPrice, pPicture, pInfo,pStock, pCompany, pT);

        return newProduct;
    }
    /* 설명. 매개변수가 많아서, 가공 처리를 하는 것*/
//    private static Product modifyUp() {
//        Product newMember = null;
//
//        Scanner sc = new Scanner(System.in);
//        System.out.print("아이디를 입력하세요: ");
//        String id = sc.nextLine();
//
//        System.out.println("패스워드를 입력하세요. ");
//        String pwd = sc.nextLine();
//
//        System.out.println("나이를 입력하세요. ");
//        int age = sc.nextInt();
//
//        System.out.println("입력할 취미 개수를 입력하세요(숫자로 1이상): ");
//        int length = sc.nextInt();
//        sc.nextLine();  //버퍼의 개행문자 처리용
//
//        String[] hobbies = new String[length];
//
//        for (int i = 0; i < hobbies.length; i++) {
//            System.out.println((1+1) + "번째 취미를 입력하세요: ");
//            String input = sc.nextLine();
//            hobbies[i] = input;
//        }
//
//        System.out.println(("혈액형을 입력하세요(A, AB, B, 0): "));
//        String bloodType = sc.nextLine().toUpperCase();
//        BloodType bt = null;
//
//        switch (bloodType) {
//            case "A": bt = BloodType.A; break;
//            case "AB": bt = BloodType.AB; break;
//            case "B": bt = BloodType.B; break;
//            case "O": bt = BloodType.O; break;
//        }
//
//        /* 필기.
//         *  회원으로부터 회원 가입을 위한 정보를 입력받아 Member 타입객체 하나로 가공 처리할 기반 기술이 두 가지가 있다.
//         *  1. 생성자 방식(장: 한줄 코딩, 단, 따로 생성자 추가 및 생성자의 매개변수가 다소 늘어날 수 있음(리팩토링 참조)
//         *  2. setter 방식(장: 초기화 할 갯수 수정 용이, 가독성이 좋음, 단: 코드의 줄 수가 늘어남)
//         * */
//        new Product(id, pwd, age, hobbies);
//
//        newMember = new Product(id, pwd, age, hobbies);
//
//        newMember.setBloodType(bt);
//
//        return newMember;
//    }

    /* 설명. 회원 ID를 입력받아 반환하는 메소드 */
    private static int choosePid() {
        Scanner sc = new Scanner(System.in);
        System.out.println("회원의 번호를 입력하세요: ");
        return sc.nextInt();
    }

}

