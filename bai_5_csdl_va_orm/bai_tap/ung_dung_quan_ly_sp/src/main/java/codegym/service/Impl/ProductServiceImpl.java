package codegym.service.Impl;


import codegym.model.Product;
import codegym.service.ProductService;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Qua tao", 20000, "Ha Noi"));
        products.put(2, new Product(2, "Qua le", 15000, "Da Nang"));
        products.put(3, new Product(3, "Qua dua", 10000, "Quang Binh"));
        products.put(4, new Product(4, "Qua sung", 2000, "Vinh Phuc"));
        products.put(5, new Product(5, "Keo", 20000, "Ha noi"));
        products.put(6, new Product(6, "Banh mi", 12000, "Ha noi"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
