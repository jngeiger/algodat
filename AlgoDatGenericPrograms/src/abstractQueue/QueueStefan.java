package abstractQueue;

public class QueueStefan<T> extends SampleQueue<T> 
{
	
private T[] array;
private int first;
private int last;
private int count;

@SuppressWarnings("unchecked")
public QueueStefan()
{
    this.first = 0;
    this.last = 0;
    array = (T[]) new Object[1];
}
   
    protected T get() throws Exception
    {
    	T temp;
    	if (isEmpty())
    	{
    		throw new Exception("isch leer");
    	}
    	count--;
    	
    	if(first == array.length)
    	{
    		first = 0;
    	}
    	temp = array[first];
    	array[first++] = null;
        return temp;
    }


    protected void put(T element) throws Exception 
    {
    	if(isFull())
    	{
    		resize();
    		array[last++] = element;
    		count++;
    		return;
    		
    	}
    	else if((last == array.length) && (array[0] == null))
    	{
    		last = 0;
    		array[last++] = element;
    		count++;
    		return;
    	}
    	else
    	{
    		array[last++] = element;
    		count++;
    		return;
    	}
    

    }
    
    protected void resize() throws Exception
    {
    	T[] newArr = (T[])new Object[array.length*2];
    	for(int i=0; i<array.length; i++)
    	{
    		newArr[i] = get();
    		count++;
    	}
    	array = newArr;
    	first = 0;
    	last = (array.length/2);
    }
    
    protected boolean isFull()
    {
    	return (count == array.length);
    }


    protected boolean isEmpty()
    {
    	return (count == 0);
    }
    
    
    public static void main(String [] args) throws Exception
    {
    	QueueStefan<String> q = new QueueStefan<String>();
        QueueStefan<String> q1 = new QueueStefan<String>();
    	
    	q.put("Hello");
    	q.put("World");
    	q.put("Test");
 
    	
    	System.out.println(q.get());
    	System.out.println(q.get());
    	System.out.println(q.get());
    
    	
    	q.put("test2");
    	q.put("asdfasdf");
    	q.put("blbalaldsfk");
    	System.out.println(q.get());
    	
    	q.put("asdfasdfasdfgysvsdfjasdufjsadfj");
    	
    	System.out.println(q.get());
    	System.out.println(q.get());
    	
    	q.put("blablatest");
  
   
    }

}

