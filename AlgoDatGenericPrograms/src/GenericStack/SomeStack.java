package GenericStack;

public interface SomeStack<T> {
public void push(T obj);
public T pop() throws Exception;
public boolean isEmpty();
public int _getArraySize();
}
