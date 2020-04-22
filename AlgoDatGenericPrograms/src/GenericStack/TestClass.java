package GenericStack;

public class TestClass {
public static void main(String[] args)
{
	var s0 = new GenericStack0<String>();
	var s1 = new GenericStack1<String>();
	TestClass t0 = new TestClass();
	t0.doSomething(s0);
	t0.doSomething(s1);
}

public void doSomething(SomeStack<? super String> s0)
{
	
	s0.push("Hello");
	s0.push("World");
	//Check grow method
	System.out.println(s0._getArraySize());
	s0.push("Test");
	s0.push("Test");
	s0.push("Test");
	s0.push("Test");
	s0.push("Test");
	s0.push("Test");
	s0.push("Test");
	s0.push("Test");
	s0.push("Test");
	// Object Count: 11 / 16 -> Shrink to 8 when Object count == 4
	//Check shrink method
	s0.pop();
	s0.pop();
	s0.pop();
	s0.pop();
	s0.pop();
	s0.pop();
	s0.pop();
	System.out.println(s0._getArraySize());
}
}
