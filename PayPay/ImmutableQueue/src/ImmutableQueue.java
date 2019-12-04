
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ImmutableQueue<T> implements Queue<T> {

	private List<T> list;

	/**
	 * Default constructor
	 */
	public ImmutableQueue() {
		this.list = new ArrayList<T>();
	}
	
	/**
	 * Overload constructor
	 * 
	 * @param List list
	 */
	public ImmutableQueue(List<T> list) {
		this.list = new ArrayList<T>(list);
	}
	
	/**
	 * Add a new element to the end of the queue
	 * 
	 * @param Object t
	 */
	public Queue<T> enQueue(T t) {
		if(t == null) {
			throw new IllegalArgumentException();
        }
		List<T> newList = new ArrayList<T>(this.list);
		newList.add(t);
		return new ImmutableQueue<T>(newList);
	}

	/**
	 * Remove the first element from the front of the queue
	 */
	public Queue<T> deQueue() {
		if(this.isEmpty()) {
			 throw new NoSuchElementException();
		}
           
		return new ImmutableQueue<T>(this.list.subList(1, this.list.size()));
	}

	/**
	 * Return the first element at the front of the queue
	 */
	public T head() {
		if(this.isEmpty()) {
			 throw new NoSuchElementException();
		}
		
		return this.list.get(0);
	}

	/**
	 * Return the last element at the end of the queue
	 */
	public T tail() {
		if(this.isEmpty()) {
			 throw new NoSuchElementException();
		}
		
		return this.list.get(this.list.size() - 1);
	}

	/**
	 * Returns whether or not there are elements in the queue
	 */
	public boolean isEmpty() {
		return this.list.size() == 0;
	}

}
