import java.text.SimpleDateFormat;

public class ProductList extends ArrayList {
    ProductList() {
    }

    ProductList(ArrayList arrayList) {
        super(arrayList);
    }

    public Object find(int id) {
        for (Object object : array) {
            if (((Product) object).getId() == id) {
                return object;
            }
        }
        return null;

    }

    public Object search(String string) {
        for (Object object : array) {
            if (((Product) object).getName().indexOf(string) != -1) {
                return object;
            }
        }
        return null;
    }

    public void remove(int id) {
        /**
         * @TODO: Add method to remove object and desc array
         */
    }

    // Product [id='0', name='Kem', price='1234', count='3', category='null',
    // brand='docto', MFG='01-12-2003', EXP='01-12-2003']
    // ─ │ ┌ ┐ ┘ └ ┬ ┴ ┤ ├ ┼
    public void display() {
        /**
         * @TODO:
         *        [x] Show list product
         */
        System.out.println("├────┬───────────────┬───────┬──────────┬────────────┬────────────┬─────┬────────────┤");
        System.out.println(String.format("│%-4s│%-15s│%-7s│%-10s│%-12s│%-12s│%-5s│%-12s│", "id", "Tên", "Loại", "Hiệu",
                "NSX", "HSD", "SL", "Giá"));
        System.out.println("├────┼───────────────┼───────┼──────────┼────────────┼────────────┼─────┼────────────┤");

        for (Object object : array) {
            System.out.println(
                    String.format("│%-4s│%-15s│%-7s│%-10s│%-12s│%-12s│%-5s│%-12s│", ((Product) object).getId(),
                            ((Product) object).getName(),
                            ((Product) object).getCategory(),
                            ((Product) object).getBrand(),
                            new SimpleDateFormat("dd-MM-yyyy").format(((Product) object).getMFG()),
                            new SimpleDateFormat("dd-MM-yyyy").format(((Product) object).getEXP()),
                            ((Product) object).getCount(),
                            ((Product) object).getPrice()));
        }
        // System.out.println("├────┴───────────────┴───────┴──────────┴────────────┴────────────┴─────┴────────────┤");
        System.out.println("├────┼───────────────┼───────┼──────────┼────────────┼────────────┼─────┼────────────┤");

    }

    public static void main(String[] args) {
        ProductList pd = new ProductList();
        pd.display();
    }
}