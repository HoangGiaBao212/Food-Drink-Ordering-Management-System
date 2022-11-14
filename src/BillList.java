import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

public class BillList extends ArrayList {

    public BillList() {
    }

    public BillList(ArrayList arrayList) {
        super(arrayList);
    }

    public void display(AccountList accountList, ProductList productList) {
        /**
         * @TODO:
         *        [x] Show list product
         */
        // Bill [id='0', idCustomer='0', idSalesman='0', idProduct='[1, 2, 3]',
        // amount='[3, 4, 5]', point='7']┼┴

        System.out.println("├────┬─────────────────────────┬─────────────────────────┬────────────┬───────────────┤");
        System.out.println(
                String.format("│%-4s│%-25s│%-25s│%-12s│%-15s│", "id", "Ten KH", "Ten NV", "Thoi Gian", "Tong"));
        System.out.println("├────┼─────────────────────────┼─────────────────────────┼────────────┼───────────────┤");

        for (Object object : array) {
            Account accountCustumer = (Account) accountList.find(((Bill) object).getIdCustomer());
            Account accountSalesman = (Account) accountList.find(((Bill) object).getIdSalesman());
            int total = 0;
            for (int i = 0; i < ((Bill) object).getIdProduct().length; i++) {
                Product product = (Product) productList.find(((Bill) object).getIdProduct()[i]);
                total += product.getPrice() * ((Bill) object).getAmount()[i];
            }
            System.out.println(
                    String.format("│%-4s│%-25s│%-25s│%12s│%15s│", ((Bill) object).getId(),
                            accountCustumer.getPerson().getName(),
                            accountSalesman.getPerson().getName(),
                            new SimpleDateFormat("dd-MM-yyyy").format(((Bill) object).getPaymentTime()),
                            String.format("%,d VND", total)));

        }
        System.out.println("├────┴─────────────────────────┴─────────────────────────┴────────────┴───────────────┤");
    }

    public static void main(String[] args) {
        App.init();
        BillList bl = new BillList();
        bl.append(new Bill(0, 0, 0, new int[] { 0, 1, 2 }, new int[] { 3, 4, 5 }, 7, new Date()));
        bl.append(new Bill(1, 1, 1, new int[] { 1, 2 }, new int[] { 3, 4 }, 7, new Date()));
        bl.append(new Bill(2, 2, 2, new int[] { 0 }, new int[] { 100 }, 0, new Date()));
        bl.display(Menu.getCurrentAccountList(), Menu.getCurrentProductList());

    }
}
