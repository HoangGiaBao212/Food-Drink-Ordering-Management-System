import java.util.Arrays;

public abstract class ArrayList {
    private Object[] array;
    private int total;
    {
        total = 0;
        array = new ArrayList[100];
    }
    ArrayList(){
    }
    public abstract Object search(int id);

    public boolean append(Object obj) {
        try {
            array[total] = obj;
        } catch (IndexOutOfBoundsException e) {
            array = Arrays.copyOf(array, total+1);
            array[total] = obj;
        } catch(Exception e) {
            return false;
        }
        return true;
    };

    public abstract boolean change(int id);

    public abstract boolean remove(int id);
}
