import java.util.Arrays;

public abstract class ArrayList implements IList {
    /**
     * TODO:
     * [x] Add method add object to array
     * [ ] Add method remove object from array
     */
    private Object[] array;
    private int total;

    ArrayList() {
        total = 0;
        array = new ArrayList[100];
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
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
