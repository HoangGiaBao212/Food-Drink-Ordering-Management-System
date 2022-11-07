import java.util.Arrays;

public abstract class ArrayList {
    protected Object[] array;

    public ArrayList() {
        array = new Object[0];
    }

    public ArrayList(Object[] array) {
        this.array = array;

    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public void append(Object obj) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = obj;
    }

    public abstract Object search(String string);

    public abstract Object find(int id);

    @Override
    public String toString() {
        String str = "[" + this.getClass().getName() + "[\n";
        for (Object object : array) {
            str += (object.toString() + '\n');
        }
        str += "], size = " + array.length;
        return str;
    }

}