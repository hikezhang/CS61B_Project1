package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

       //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        ///*
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();
		//*/
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

      //  System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
     //   /*
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());
      //  */
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

      //  System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
      //  /*
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
      // */
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {

      //  /*
        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
      //  */
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        ///*
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

        //*/
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        ///*
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

        //*/
    }

    @Test
    /* Check if we get the i-th item. */
    public void getTest(){
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        for(int i = 0; i < 50; i += 1){
            lld1.addLast(i);
        }
        for(double i = 0; i < 50; i += 1){
            assertEquals(i, (double)lld1.get((int)i),0.0);
        }

    }

    @Test
    /* Check if we get the i-th item with recursion. */
    public void getRecursiveTest(){
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        for(int i = 0; i < 50; i += 1){
            lld1.addLast(i);
        }
        for(double i = 0; i < 50; i += 1){
            assertEquals(i, (double)lld1.getRecursive((int)i),0.0);
        }

    }

    @Test
    /* ArrayDeque test */
    public void ADResizeUpTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        ///*
        ArrayDeque<String> lld1 = new ArrayDeque<>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        lld1.addLast("4");
        assertEquals(4, lld1.size());

        lld1.addLast("5");
        assertEquals(5, lld1.size());

        lld1.addLast("6");
        assertEquals(6, lld1.size());

        lld1.addLast("7");
        assertEquals(7, lld1.size());

        lld1.addLast("8");
        assertEquals(8, lld1.size());

        lld1.removeFirst();
        assertEquals(7,lld1.size());

        lld1.addLast("9");
        assertEquals(8,lld1.size());

        lld1.addLast("10");
        //assertEquals(16,lld1.capacity());

        System.out.println("Printing out deque: ");
        lld1.printDeque();
        //*/
    }

    @Test
    public void ADResizedownTest(){
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        for(int i = 0; i < 16; i += 1){
            lld1.addLast(i);
        }
        assertEquals(16, lld1.size());

        for(int i = 0; i < 12; i += 1){
            lld1.removeFirst();
        }
        lld1.removeLast();
        //assertEquals(8, lld1.capacity());
        lld1.printDeque();
    }

    @Test
    public void equalsTest0(){
        LinkedListDeque<String> ld = new LinkedListDeque<>();
        ld.addLast("please");
        ld.addLast("be");
        ld.addLast("right");
        assertEquals(3, ld.size());
        ArrayDeque<String> ad = new ArrayDeque<>();
        ad.addLast("please");
        ad.addLast("be");
        ad.addLast("right");

        assertEquals(true, ad.equals(ld));
    }

    @Test
    public void RanomizedTest() {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        LinkedListDeque<Integer> L = new LinkedListDeque<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                A.addLast(randVal);
                L.addLast(randVal);
                assertEquals(true, A.equals(L));
            } else if (operationNumber == 1) {
                // size
                int sizeL = L.size();
                int sizeB = A.size();
                assertEquals(sizeL, sizeB);
            } else if (operationNumber == 2) {
                // removeLast
                if (L.size() != 0 && A.size() != 0) {
                    int lastValL = L.removeLast();
                    int lastValB = A.removeLast();
                    assertEquals(lastValL, lastValB);
                    assertEquals(true, A.equals(L));
                }

            } else if (operationNumber == 3) {
                // remove First
                if (L.size() != 0 && A.size() != 0) {
                    int removeValL = L.removeFirst();
                    int removeValB = A.removeFirst();
                    assertEquals(removeValB, removeValL);
                }
            }
        }
    }

    @Test
    public void d006Test(){
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addLast(0);
        ad.get(0)  ;    //==> 0
        ad.addFirst(2);
        ad.addFirst(3);
        ad.removeFirst()  ;   //==> 3
        ad.get(1)  ;  //  ==> 0
        ad.addFirst(6);
        ad.removeLast() ;   //  ==> 0
        ad.removeFirst();//     ==> 6
        ad.get(0) ;    // ==> 2
        ad.get(0)      ;//==> 2
        ad.removeLast() ;//     ==> 2
        ad.addFirst(12);
        ad.removeFirst()  ;//   ==> 12
        ad.addLast(14);
        ad.printDeque();

    }

    @Test
    public void equalsTest1(){
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        LinkedListDeque<Integer> ad2 = new LinkedListDeque<>();

        ad1.addLast(3);
        ad1.addLast(2);
        ad1.addLast(1);
        ad2.addLast(3);
        ad2.addLast(2);
        ad2.addLast(1);

        assertEquals(true, ad1.equals(ad2));

        for (int i = 0; i < 100; i += 1) {
            ad1.addLast(i);
            ad2.addLast(i);
        }
        assertEquals(true, ad1.equals(ad2));
    }

    @Test
    public void IteratorTest(){
        Deque<Integer> lld = new LinkedListDeque<>();
        Deque<Integer> ad = new ArrayDeque<>();
        lld.addLast(1);
        lld.addLast(2);
        ad.addLast(1);
        ad.addLast(2);

        for (Object item : (LinkedListDeque)lld) {
            System.out.print(item + " "); // 应该是 1 2
        }
        System.out.println();
        for (Object item : (ArrayDeque)ad) {
            System.out.print(item + " "); // 应该是 1 2
        }

    }

    @Test
    public void MADTest0(){
        Comparator<Integer> intComparator = (a, b) -> a - b;
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<>(intComparator);
        mad.addLast(1);
        mad.addLast(2);
        mad.addLast(3);
        System.out.println(mad.max());
    }
}
