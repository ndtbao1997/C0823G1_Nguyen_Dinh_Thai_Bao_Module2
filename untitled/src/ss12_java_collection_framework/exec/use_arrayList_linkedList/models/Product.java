package ss12_java_collection_framework.exec.use_arrayList_linkedList.models;

public class Product implements Comparable<Product> {
    private Integer id;
    private String name;
    private Long price;

    public Product() {
    }

    public Product(Integer id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price;
    }


    @Override
    public int compareTo(Product o) {
        return Long.compare(this.getPrice(), o.getPrice());
    }
}
