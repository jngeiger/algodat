package queue;

public abstract class Queue<T> 
{
	public abstract void put(T value);
	public abstract T get();
	public abstract boolean isEmpty();
	protected abstract void _growIfNeeded();
	protected abstract void _shrinkIfNeeded();
}