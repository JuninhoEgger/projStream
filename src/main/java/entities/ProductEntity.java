package entities;

import static java.lang.String.format;

public class ProductEntity {

    private String name;
    private Double price;

    public ProductEntity() {
    }

    public ProductEntity(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "NOME: " + name +
                "\nPREÇO: R$" + format("%.2f", price);
    }
}
