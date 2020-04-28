package abstractQueue;

public abstract class SampleQueue<T> {
abstract protected T get() throws Exception;
abstract protected void put(T element) throws Exception;
abstract protected boolean isEmpty();


}
