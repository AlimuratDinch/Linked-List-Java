import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

	/**
	 * This is the BookList class
	*/
public class BookList {
	/**
	 * This is the Node private inner class
	 */
	private class Node{
		private Book b;
		private Node next;
		/**
		 * default constructor
		 */
		public Node() {
			b =null;
			next = null;
		}
		/**
		 * Param-Constructor
		 * @param b1 is a Book object
		 * @param nxt is a Node object
		 */
		public Node(Book b1, Node nxt) {
			b = b1;
			next = nxt;
			
		}
	}

	private Node head;
	/**
	 * Default constructor
	 */
	public BookList() {
		head = null;
	}
	/**
	 * This method adds a node to the beginning of the LinkedList
	 * @param b is a Book object
	 */
	public void addToStart(Book b) {
		head = new Node(b,head);
	}
	/**
	 * This method stores all the records with the given year
	 * @param yr is a year
	 * @throws FileNotFoundException
	 */
	public void storeRecordsByYear(int yr) throws FileNotFoundException {
		PrintWriter pw = null;
		String year = yr +".txt";
		pw = new PrintWriter(new FileOutputStream(year));
		Node t = head;
		while(t != null) {
			if(t.b.getYear() == yr) {
				pw.println(t.b);
				
			}
			
			t = t.next;
			
		}
		pw.close();
		
	}
	/**
	 * This method inserts a book object before a given ISBN number
	 * @param isbn is an ISBN number
	 * @param b is a Book object
	 * @return boolean value. True if the ISBN number is found, false otherwise.
	 */
	public boolean insertBefore(long isbn, Book b) {
		Node t = head;
		if(t == null) {
			return false;
		}
		
		while(t.next != null && t.next.b.getIsbn() != isbn) {
			System.out.println(t.next.b.getIsbn());
			t = t.next;
		}
		if(t == null) {
			return false;
		}
		
		Node n = new Node(b,t.next);
		t.next = n;
		
		return true;	
	}
	/**
	 * This method inserts a Book object between two given ISBN numbers
	 * @param isbn1 is an ISBN number
	 * @param isbn2 is an ISBN number
	 * @param b is a Book object
	 * @return boolean value
	 */
	public boolean insertBetween(long isbn1,long isbn2,Book b) {
		Node t = head;
		if(t == null) {
			return false;
		}
		while(t.next != null &&(t.b.getIsbn() != isbn1 && t.next.b.getIsbn() != isbn2)) {
			//System.out.println("isbn1 is " + t.b.getIsbn());
			//System.out.println("isbn2 is " + t.next.b.getIsbn());
			t = t.next;
		}
		Node n = new Node(b,t.next);
		t.next = n;
		return true;
	}
	/**
	 * This method displays the content if there is any
	 */
	public void displayContent() {
		Node t = head;
		
		//System.out.println(head.next.b);
		if (t == null) {
			System.out.println("There is nothing to display; list is empty.");
		}
		while(t != null  ) {
			System.out.println(t.b + " ==> ");
			
			t = t.next;
		}
		
		System.out.println("==> head");		

	}
	public void displayContent1() {
	     Node t = head.next;
		
		//System.out.println(head.next.b);
		if (t == null) {
			System.out.println("There is nothing to display; list is empty.");
		}
		while(t != null  ) {
			System.out.println(t.b + " ==> ");
			
			t = t.next;
		}
		
		System.out.println("==> head");
	}
	
	/*public void displayContent() {
		 Node t = head;
	        if (head == null) {
	            System.out.println("List is empty");
	        } else {
	            while (t != null && t.next != head) {
	                System.out.println(t.b + "==> ");
	                t = t.next;
	            }
	            System.out.print(t.b);
	        }
	        System.out.println();
	    }*/
	/**
	 * this method deletes any consecutive records
	 * @return boolean value. True if the task is done, false otherwise.
	 */
	public boolean delConsecutiveRepeatedRecords() {
		Node t = head;
		if (t == null) {
			return false;
		}
		while(t.next != null){
			
			if(t.b.equals(t.next.b)) {
				
				t.next = t.next.next;
			}
			else {
				t = t.next;
			}	
	}
		/*t.next = head;
		if(t.b.equals(t.next.b)) {
			
			t.next = t.next.next;
		}
		else {
			t = t.next;
		}	
		//System.out.println(head.b);*/
		
		return true;
	}
	/**
	 * This method extracts a list of all records of a given Author
	 * @param aut is an author's name
	 * @return a Booklist Object containing all records of teh given author
	 */
	public  BookList extractAuthList(String aut) {
		BookList bl = new BookList();
		Node t = head;
		if (t == null) {
			System.out.println("It is an empty list");
		}
		while(t != null) {
			if(t.b.getAuthor().equals(aut)) {
				bl.addToEnd(t.b);
			}
			t = t.next;
		}
		bl.displayContent();
		return bl;
		
		
		
	}
	
	
	/**
	 * This method swaps 2
	 * @param isbn1 is the ISBN number of the first record
	 * @param isbn2 is the ISBN number of the second record
	 * @return boolean value. True if the records are swapped, false otherwise.
	 */
	public boolean swap(long isbn1, long isbn2) {
		Node t = head;
		Node t1 = head;
		Node temp1 = null;
		Node temp2 = null;
		Book temp3 = null;
		if (t == null) {
			return false;
		}
		while(t != null) {
			if(t.b.getIsbn() == isbn1) {
				//System.out.println("ISBN1");
				temp1 = t;
				//System.out.println(temp1.b);
			}
			if(t.b.getIsbn() == isbn2) {
				//System.out.println("ISBN2");
				temp2 = t;
				//System.out.println(temp2.b);
			}
			t = t.next;
		}
		if((temp1 == null && temp2 == null) || (temp1 == null) || (temp2 == null)) {
			return false;
		}
		
		while(t1 != null){
			
			if(t1.b.getIsbn() == isbn1) {
				
				temp3 = t1.b;
				t1.b = temp2.b;
				
				
				
			}
			if(t1.b.getIsbn() == isbn2) {
				t1 = t1.next;
				//System.out.println(t1.b);
				//System.out.println(temp3);
				t1.b = temp3;
			}
			t1 = t1.next;
		}
		return true;
	}
	/**
	 * This method commits the records of the BookList in a file called "Updated_Books.txt"
	 */
	public void commit() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream("Updated_Books.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Node t = head;
		if (t == null) {
			pw.println("");
		}
		while(t != null) {
			pw.println(t.b);
			t = t.next;
		}
		
		
		
		pw.close();
	}
	
	/**
	 * This method adds a Book object to the end of a LinkedList
	 * @param b is a Book object
	 */
	public void addToEnd(Book b) {
	
		if (head == null) {
			head = new Node(b,null);
			return;
		}
		Node t = head;
		
		while(t.next != null) {
			t = t.next;
		}
		
		t.next = new Node(b,null);
		
	}
  }
