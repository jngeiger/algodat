package abstractQueue;

public class Queue<T> extends SampleQueue<T> 
{
	
private T[] array;
private int first;
private int last;
private int count;

@SuppressWarnings("unchecked")
public Queue()
{
    this.first = 0;
    this.last = 0;
    array = (T[]) new Object[1];
}
   
    protected T get() throws Exception
    {
    	if (isEmpty())
    	{
    		throw new Exception("Queue is empty");
    	}
    	
    	if(first == array.length)
    	{
    		first = 0;
    	}
    	T temp;
    	temp = array[first];
    	array[first++] = null;
    	count--;
    	_shrinkIfNeeded();
        return temp;
    }


    protected void put(T element) throws Exception 
    {
    	if(isFull())
    	{
    		_growIfNeeded();
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
    
    @SuppressWarnings("unchecked")
    protected void _growIfNeeded() throws Exception
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
    
    private void _shrinkIfNeeded() throws Exception
    {
        if (count < (array.length / 4))
        {
        	int temp = count;
            T[] newArr = (T[]) new Object[array.length/2];
            for(int i=0; i<temp; i++)
            {
            	newArr[i] = get();
            	count++;
            }
            array = newArr;
            first = 0;
            last = (count);
        }
    }
    
    protected boolean isFull()
    {
    	return (count == array.length);
    }


    protected boolean isEmpty()
    {
    	return (count == 0);
    }
    
    public int getArraySize()
    {
    return array.length;
    }
    
    public static void main(String [] args) throws Exception
    {
//    	Queue<String> q = new Queue<String>();
//        
//    	
//    	q.put("Hello");
//    	q.put("World");
//    	q.put("Test");
// 
//    	
//    	System.out.println(q.get());
//    	System.out.println(q.get());
//    	System.out.println(q.get());
//    
//    	
//    	q.put("test2");
//    	q.put("asdfasdf");
//    	q.put("blbalaldsfk");
//    	System.out.println(q.get());
//    	
//    	q.put("asdfasdfasdfgysvsdfjasdufjsadfj");
//    	
//    	System.out.println(q.get());
//    	System.out.println(q.get());
//    	
//    	q.put("blablatest");
//    	
//    	
//    	Queue<String> q2 = new Queue<String>();
//    	
//    	q2.put("Hello");
//    	q2.put("World");
//    	q2.put("Servus");
//    	q2.put("Welt");
//    	
//    	
//    	
//    	System.out.println(q2.get());
//    	System.out.println(q2.get());
//    	q2.put("Hello");
//    	q2.put("World");
//    	System.out.println(q2.get());
//    	System.out.println(q2.get());
//    	System.out.println(q2.get());
//    	System.out.println(q2.get());
    	
    	Queue<Integer> q=new Queue<Integer>();

		System.out.println("");
		System.out.println("===TEST0===");
		System.out.println(q.isEmpty());
		System.out.println(q.get());
		System.out.println(q.isEmpty());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.isEmpty());

		System.out.println("");
		System.out.println("===TEST1===");
		System.out.println(q.isEmpty());
		q.put(11);
		System.out.println(q.isEmpty());			
		System.out.println(q.get());
		System.out.println(q.isEmpty());

		System.out.println("");
		System.out.println("===TEST2===");
		System.out.println(q.getArraySize());
		q.put(21);
		System.out.println(q.get());
		System.out.println(q.get());

		System.out.println("");
		System.out.println("===TEST3===");
		q.put(31);
		q.put(32);
		q.put(33);
		q.put(34);
		q.put(35);
		q.put(36);
		q.put(37);
		q.put(38);
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());

		System.out.println("");
		System.out.println("===TEST4===");
		q.put(41);
		q.put(42);
		q.put(43);
		q.put(44);
		q.put(45);
		q.put(46);
		q.put(47);
		q.put(48);


		q.put(49);
		q.put(410);
		q.put(411);
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
    	
    	
  
   
    }

}



