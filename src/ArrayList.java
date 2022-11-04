public abstract class ArrayList {
    private Object[] array;
    private int length;
    private int maxLength;

    public abstract Object search(int id);

    public abstract boolean append(Object obj);

    public abstract boolean remove(int id);

    public abstract boolean change(int id);

    public abstract Person login(int id);
}
