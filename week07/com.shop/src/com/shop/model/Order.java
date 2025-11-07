package com.shop.model;

import com.shop.manager.ShopManager;
import com.shop.utils.IdGenerator;

public class Order {

    private String orderId;           // 주문 ID (자동 생성)
    private String[] productIds;      // 주문한 상품 ID 배열 (크기 10)
    private int[] quantities;         // 각 상품의 수량 배열 (크기 10)
    private int itemCount;            // 현재 담긴 상품 종류 수
    private int totalAmount;          // 총 금액
    private String status;            // 주문 상태: "결제대기", "결제완료", "취소"

    public Order() {
        this.orderId = IdGenerator.getInstance().generateOrderId();
        this.productIds = new String[10];
        this.quantities = new int[10];
        this.itemCount = 0;
        this.totalAmount = 0;
        this.status = "결제대기";
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String[] getProductIds() {
        return productIds;
    }

    public void setProductIds(String[] productIds) {
        this.productIds = productIds;
    }

    public int[] getQuantities() {
        return quantities;
    }

    public void setQuantities(int[] quantities) {
        this.quantities = quantities;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addItem(String productId, int quantity) {
        if (itemCount >= 10) {
            throw new IllegalArgumentException("더이상 추가할 수 없습니다.");
        }

        if (quantity < 1) {
            throw new IllegalArgumentException("수량을 선택해주세요.");
        }

        productIds[itemCount] = productId;
        quantities[itemCount] = quantity;
        itemCount++;
    }

    public void calculateTotal(ShopManager manager) {
        totalAmount = 0;
        for (int i = 0; i <= itemCount-1; i++) {
            Product product = manager.findProductById(productIds[i]);
            totalAmount += product.getPrice() * quantities[i];
        }
        System.out.println("총 금액 : "+totalAmount);
    }

    public void complete() {
        status = "결제 완료";
        System.out.print("[ "+status+" ] ");
    }

}
