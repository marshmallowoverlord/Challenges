import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImmutableQueueTest {

	private final ArrayList<String> testdata = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e"));

	@Test
	void testEnqueue() {
		Queue<String> q = new ImmutableQueue<String>();
		
		q = q.enQueue(testdata.get(0));
		Queue<String> origQueue = q;
		
        for (int i = 1; i < testdata.size(); i++){
            q = q.enQueue(testdata.get(i));
        };
        
        assertTrue(q.tail() == testdata.get(testdata.size() - 1));
        assertTrue(origQueue.tail() != q.tail());
        assertTrue(origQueue != q);
	}

	@Test
	void testDequeue() {
		Queue<String> q = new ImmutableQueue<String>(testdata);
		
		Queue<String> origQueue = q;
        q = q.deQueue();
        
        assertTrue(origQueue != q);
        assertTrue(origQueue.head() != q.head());
        assertTrue(q.head() == testdata.get(1));
	}
	
	@Test
    public void testHead(){
		Queue<String> q = new ImmutableQueue<String>(testdata);
        
        assertTrue(q.head() == testdata.get(0));
    }
	
	@Test
    public void testTail(){
		Queue<String> q = new ImmutableQueue<String>(testdata);
        
        assertTrue(q.tail() == testdata.get(testdata.size() - 1));
    }
	
	@Test
    public void testIsEmpty(){
		Queue<String> q = new ImmutableQueue<String>();
        
        assertTrue(q.isEmpty());
    }
}
