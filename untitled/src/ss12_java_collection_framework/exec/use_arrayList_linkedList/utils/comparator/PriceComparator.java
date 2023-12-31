package ss12_java_collection_framework.exec.use_arrayList_linkedList.utils.comparator;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.models.Product;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o2.getPrice() > o1.getPrice()) {
            return 1;
        } else if (o2.getPrice() == o1.getPrice()) {
            return 0;
        } else {
            return -1;
        }
    }
}
