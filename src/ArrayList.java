import java.util.Arrays;

public abstract class ArrayList implements IList {
    private Object[] array;
    private int total;
    {
        total = 0;
        array = new ArrayList[100];
    }

    ArrayList() {
    }

    /**
     * Add new element to the end of array
     * if successfully, return true
     *
     * @param obj
     * @return boolean
     */
    public boolean append(Object obj) {
        try {
            array[total] = obj;
        } catch (IndexOutOfBoundsException e) {
            array = Arrays.copyOf(array, total + 1);
            array[total] = obj;
            if (array[total] != null)
                total++;
        } catch (Exception e) {
            return false;
        }
        return true;
    };
}
