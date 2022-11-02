package lk.ijse.dep9.dto;

import java.sql.Date;

public class OrderDetailDTO {
private String orderId;
private String itemCode;
private int quantity;
private double unitPrice;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String orderId, String itemCode, int quantity, double unitPrice) {
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "orderId='" + orderId + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
