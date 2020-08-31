package Helpers;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Getter
public class Product {
    private String name;
    private String price;
    private WebElement linkToProduct;


    public Product(WebElement element) {
        this.name = element.findElement(By.xpath(".//div[@class = 'name']")).getText();
        this.price = element.findElement(By.xpath(".//div[@class = 'price-wrapper']")).getText();
        this.linkToProduct = element.findElement(By.xpath(".//a"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product products = (Product) o;
        return Objects.equals(name, products.name) &&
                Objects.equals(price, products.price) &&
                Objects.equals(linkToProduct, products.linkToProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, linkToProduct);
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", linkToProduct=" + linkToProduct +
                '}';
    }
}