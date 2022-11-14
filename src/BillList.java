import java.text.SimpleDateFormat;

public class BillList extends ArrayList {

    public BillList() {
    }

    public BillList(ArrayList arrayList) {
        super(arrayList);
    }

    public void display() {
        /**
         * @TODO:
         *        [x] Show list product
         */
        // Bill [id='0', idCustomer='0', idSalesman='0', idProduct='[1, 2, 3]',
        // amount='[3, 4, 5]', point='7']
        System.out.println("├────┬────┬────┬────┬─────┬─────┤");
        System.out.println(
                String.format("│%-4s│%-4s│%-4s│%-4s│%-5s│%-5s│", "id", "id KH", "id NV", "id SP", "SL", "Điểm"));
        System.out.println("├────┼────┼────┼────┼─────┼─────┤");

        for (Object object : array) {
            System.out.println(
                    String.format("│%-4d│%-4d│%-4d│%-4d│%-5d│%-5d│", ((Bill) object).getId(),
                            ((Bill) object).getIdCustomer(),
                            ((Bill) object).getIdSalesman(),
                            ((Bill) object).getIdProduct()[0],
                            ((Bill) object).getAmount()[0],
                            ((Bill) object).getPoint()));
            for (int i = 1; i < ((Bill) object).getIdProduct().length; i++) {
                System.out.println(
                        String.format("│%-4s│%-4s│%-4s│%-4d│%-5d│%-5s│", "", "", "", ((Bill) object).getIdProduct()[0],
                                ((Bill) object).getAmount()[0], ""));

            }
        }
        System.out.println("├────┴────┴────┴────┴─────┴─────┤");

    }
}
