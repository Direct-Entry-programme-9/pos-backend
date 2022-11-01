package lk.ijse.dep9.dto;

import jakarta.json.bind.annotation.JsonbPropertyOrder;

import java.io.Serializable;

@JsonbPropertyOrder({"id, name, address"})
public class CustomerDTO implements Serializable {
    private String id;
    private String name;
    private String address;

    public CustomerDTO() {
    }

    public CustomerDTO(String id, String name, String address) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
