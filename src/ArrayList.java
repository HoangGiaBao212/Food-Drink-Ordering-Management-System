import java.util.Arrays;

public abstract class ArrayList {
    private Object[] array;
    private int total;
    private int maxLength;
    {
        total = 0;
        maxLength = 100;
    }
    ArrayList(){
        array = new ArrayList[maxLength];
    }
    public abstract Object search(int id);

    public boolean append(Object obj) {
        try {
            array[total] = obj;
        } catch (IndexOutOfBoundsException e) {
            array = Arrays.copyOf(array, total+1);
        }
        return false;
    };

    public abstract boolean change(int id);

    public abstract boolean remove(int id);
}
