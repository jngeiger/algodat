package abstractQueue;

public class Queue2<T> extends SampleQueue<T> {
private T[] array;
private int first;
private int last;

@SuppressWarnings("unchecked")
public Queue2()
{
	this.first = 0;
	this.last = 0;
	array = (T[]) new Object[1];
}
	@Override
	protected T get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void put(T element) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
