package com.shop.manager;

import com.shop.model.Order;
import com.shop.model.Product;

public class ShopManager {

    private Product[] products;  // 상품 배열 (크기 50)
    private int productCount;    // 현재 등록된 상품 수
    private Order[] orders;      // 주문 배열 (크기 50)
    private int orderCount;      // 현재 주문 수

    public ShopManager() {
        products = new Product[50];
        productCount = 0;
        orders = new Order[50];
        orderCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount > 50) {
            throw new IllegalArgumentException("더 이상 추가할 수 없습니다.");
        }

        products[productCount++] = product;

        System.out.println("[상품 등록] " + product.getName() + " - " + product.getPrice() + "원");
    }


    public Product findProductById(String id) {
        Product product = null;

        for (int i = 0; i < productCount; i++) {
            Product p = products[i];
            if (p.getId().equals(id)) {
                product = p;
            }
        }

        return product;
    }

    // 향상된 for문으로 전체 배열 돌리기 - products 순회함 product가 null이면 null 예외 발생함
    public Product[] searchProductsByName(String keyword) {
        Product[] temp = new Product[productCount];
        int index = 0;

        for (Product product : products) {

            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                temp[index] = product;
                index++;
            }
        }
        return temp;
    }


    public Product[] searchProductsByCategory(String category) {
        Product[] temp = new Product[productCount];

        int index = 0;
        int count = 0;

        for (int i = 0; i < productCount; i++) {
            Product product = products[i];
            if (product.getCategory().equalsIgnoreCase(category)) {
                temp[index] = product;
                index++;
                count++;
            }
        }

        Product[] searchProduct = new Product[count];

        for (int i = 0; i < searchProduct.length; i++) {
            searchProduct[i] = temp[i];
        }

        return searchProduct;

    }


    public void printAllProducts() {

        for (int i = 0; i < productCount; i++) {
            Product p = products[i];
            System.out.println((i+1) + ". [" + p.getId() + "] " + p.getName() + " - " + p.getPrice() + "원 (재고: " + p.getStock() + "개)");
        }
    }

    public Order createOrder() {
        System.out.println("주문을 생성했습니다.");
        return new Order();
    }

    public void addOrderItem(Order order, String productId, int quantity) {
        Product product = findProductById(productId);

        if (product == null) {
            throw new IllegalArgumentException("상품이 존재하지 않습니다.");
        }

        if (!product.isAvailable(quantity)) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }

        order.addItem(product.getId(), quantity);

        System.out.println("[주문 항목 추가] " + product.getName() + "x" + quantity);

    }

    //order.calculateTotal(this) 호출
//    주문 내역 출력 (상품명, 수량, 금액)
//    반복문으로 재고 차감 (product.decreaseStock())
//        order.complete() 호출
//    orders 배열에 추가
//    결제 완료 메시지 출력
    public void processOrder(Order order) {

        System.out.println("=== 주문 내역 ===");
        System.out.println("주문번호 : " + order.getOrderId());
        // product id 배열, quantities 배열
        String[] a = order.getProductIds();
        int[] b = order.getQuantities();
        System.out.println("---------------------");
        for (int i = 0; i < order.getItemCount(); i++) {
            Product product = findProductById(a[i]);
            product.decreaseStock(b[i]);

            System.out.println(product.getName() + " x " + b[i] + " = " + (product.getPrice() * b[i]));
        }
        System.out.println("---------------------");
        orders[orderCount++] = order;
        order.calculateTotal(this);
        order.complete();
        System.out.println(order.getOrderId());
    }

//    반복문으로 orders 배열 순회
//    orderId가 일치하면 반환
//    못 찾으면 null 반환

    public Order findOrderById(String orderId) {
        Order order = null;

        for (int i = 0; i < orderCount; i++) {
            Order o = orders[i];
            if (o.getOrderId().equals(orderId)) {
                order = o;
            }
        }

        return order;

    }

    public void printAllOrders() {
        for (int i = 0; i < orderCount; i++) {
            Order o = orders[i];
            System.out.println((i+1) + ". [" + o.getOrderId() + "] " + o.getTotalAmount() + "원 (" + o.getStatus() + ")");
        }
    }



}
