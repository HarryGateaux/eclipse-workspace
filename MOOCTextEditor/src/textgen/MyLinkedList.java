package textgen;

import java.util.AbstractList;

/**
 * A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);
		this.head.next = tail;
		this.tail.prev = head;
		this.size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * 
	 * @param element The element to add
	 */
	public boolean add(E element) {
		// TODO: Implement this method
		this.add(this.size, element);
		return true;
	}

	/**
	 * Get the element at position index
	 * 
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E get(int index) {
		// TODO: Implement this method.

		if (this.size == 0 || index < 0 || index > this.size - 1) {
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> start = this.head.next;

		for (int i = 0; i < index; i++) {

			LLNode<E> activeNode = start.next;
			start = activeNode;
			start.data = activeNode.data;
		}

		return start.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * 
	 * @param The     index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element) {
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();

		} else {

			if (index < 0 || (index > this.size)) {
				throw new IndexOutOfBoundsException();
			}

			LLNode<E> start = this.head.next;

			for (int i = 0; i < index; i++) {

				LLNode<E> activeNode = start.next;
				start = activeNode;
			}

			LLNode<E> n = new LLNode<E>(element, start);
			this.size += 1;
		}

	}

	/** Return the size of the list */
	public int size() {
		// TODO: Implement this method
		return this.size;
	}

	/**
	 * Remove a node at the specified index and return its data element.
	 * 
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) {
		// TODO: Implement this method
		if (this.size == 0 || index < 0 || index > this.size - 1) {
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> start = this.head.next;

		for (int i = 0; i < index; i++) {

			LLNode<E> activeNode = start.next;
			start = activeNode;
		}

		start.prev.next = start.next;
		start.next.prev = start.prev;
		start.next = null;
		start.prev = null;
		this.size -= 1;

		return start.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * 
	 * @param index   The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) {
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();

		} else {

			if (index < 0 || index > this.size - 1) {
				throw new IndexOutOfBoundsException();
			}

			LLNode<E> start = this.head.next;

			for (int i = 0; i < index; i++) {

				LLNode<E> activeNode = start.next;
				start = activeNode;
				start.data = activeNode.data;
			}

			E oldData = start.data;
			start.data = element;
			return oldData;
		}
	}
}


	class LLNode<E> {
		LLNode<E> prev;
		LLNode<E> next;
		E data;

		// TODO: Add any other methods you think are useful here
		// E.g. you might want to add another constructor

		public LLNode(E e) {
			this.data = e;
			this.prev = null;
			this.next = null;
		}

		public LLNode(E data, LLNode<E> nextNode) {

			this(data);
			nextNode.prev.next = this;
			this.next = nextNode;
			this.prev = nextNode.prev;
			nextNode.prev = this;

		}
	}
