import java.util.Arrays;
import java.util.Date;

public class ProductList {
    private Product[] array;
    private int total;

    ProductList() {
        array = new Product[0];
        total = 0;
    }

    public Product[] getArray() {
        return array;
    }

    public void setArray(Product[] array) {
        this.array = array;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean append(Product product) {
        try {
            product.setId(total);
            array[total] = product;
        } catch (ArrayIndexOutOfBoundsException e) {
            array = Arrays.copyOf(array, total+1);
        } finally {
            if(array[total] != null){
                total++;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "ProductList [array=\n" + Arrays.toString(array) + ", total=" + total + "]";
    }

    public static void main(String[] args) {
        ProductList productList = new ProductList();
        productList.append(new Product());
        productList.append(new Product());
        productList.append(new Product());
        productList.append(new Product());
        productList.append(new Product());
        System.out.println(productList);
    }
}