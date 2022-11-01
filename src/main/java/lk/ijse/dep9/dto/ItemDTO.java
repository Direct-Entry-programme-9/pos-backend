package lk.ijse.dep9.dto;

import java.io.Serializable;
import java.text.DecimalFormat;

public class ItemDTO implements Serializable {
    private int stock;
    private String description;
    private String code ;
    private int unitPrice ;

    public ItemDTO(int stock, String description, String code, int unitPrice) {
        this.stock = stock;
        this.description = description;
        this.code = code;
        this.unitPrice = unitPrice;
    }

    public ItemDTO() {
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "stock=" + stock +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
