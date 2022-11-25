import java.text.SimpleDateFormat;

public class BillList extends ArrayList implements IGetable<Bill> {

    public BillList() {
    }

    public BillList(ArrayList arrayList) {
        super(arrayList);
    }

    public int getNewId() {
        int id = 0;

        try {
            id = ((Bill) array[array.length - 1]).getId() + 1;
            while (getById(id) != null) {
                id++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return id;
    }

    public Object find(int idBill, int idCustomer) {
        for (Object object : array) {
            if (((Bill) object).getId() == idBill && ((Bill) object).getIdCustomer() == idCustomer) {
                return object;
            }
        }
        return null;
    }

    public void display(AccountList accountList, ProductList productList, Account account) {
        /**
         * @TODO:
         *        [x] Show list product
         */
        // Bill [id='0', idCustomer='0', idSalesman='0', idProduct='[1, 2, 3]',
        // amount='[3, 4, 5]', point='7']┼┴┌ ┐ ┘ └

        System.out.println("├────┬─────────────────────────┬─────────────────────────┬────────────┬──────────────┤");
        System.out.println(
                String.format("│%-4s│%-25s│%-25s│%-12s│%-14s│", "id", "Ten KH", "Ten NV", "Thoi Gian", "Tong"));
        System.out.println("├────┼─────────────────────────┼─────────────────────────┼────────────┼──────────────┤");

        // Account accountCustumer = (Account) accountList.find(((Bill)
        // object).getIdCustomer());
        for (Object object : array) {
            if (((Bill) object).getIdCustomer() == account.getId()) {
                Account accountSalesman = accountList.getById(((Bill) object).getIdSalesman());
                int total = 0;
                for (int i = 0; i < ((Bill) object).getIdProduct().length; i++) {
                    Product product = (Product) productList.find(((Bill) object).getIdProduct()[i]);
                    total += product.getPrice() * ((Bill) object).getAmount()[i];
                }
                System.out.println(
                        String.format("│%-4s│%-25s│%-25s│%12s│%14s│", ((Bill) object).getId(),
                                account.getPerson().getName(),
                                accountSalesman.getPerson().getName(),
                                new SimpleDateFormat("dd-MM-yyyy").format(((Bill) object).getPaymentTime()),
                                String.format("%,d VND", total)));
            }
        }
    }

    @Override
    public Bill getById(int id) {
        for (Object object : array) {
            if (((Bill) object).getId() == id) {
                return (Bill) object;
            }
        }
        return null;
    }

    @Override
    public Bill[] getByString(String string) {
        return new Bill[0];
    }

}
