public class ProductList extends ArrayList {
    ProductList() {
    }

    ProductList(ArrayList arrayList) {
        super(arrayList);
    }

    public Object find(int id )
    {
        for ( Object object : array )
        {
            if ( ((Product) object ).getId()==id)
            {
                return object;

            }
        }
        return null;

    }
    public Object search(String string)
    {
        for ( Object object : array)
        {
            if (( (Product)object).getName().indexOf(string )!=-1)
            {
                return object ;
            }
        }
        return null;
    }

    public Object remove(  int id   )
    {
        for ( Object object : array )
        {
            if ( ((Product) object).getId()==id)
            {
            }
        }
}
    public void display(){
        /**
         * @TODO:
         * [ ] Show list product
         */
        for (Object object : array)
        {
            System.out.println ( object.toString());
        }
    }
}