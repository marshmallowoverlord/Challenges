

public interface Queue<T> {
	
    public Queue<T> enQueue(T t);
    
    public Queue<T> deQueue();
    
    public T head();
    
    public T tail();

    public boolean isEmpty();
    
}