package collection;

import java.util.Iterator;

/**
 * 链表快慢指针代码示例
 * @author 陆十三
 *
 * @param <E>
 */
public class Linked<E> implements Iterable<E> {

	Node<E> head = null;
	Node<E> tail = null;

	public E addTail(E e) {
		Node<E> t = tail;
		Node<E> newNode = new Node<>(e, null);
		tail = newNode;
		if (t == null) {
			head = newNode;
		} else {
			t.next = newNode;
		}
		return e;
	}

	public String toString() {
		Iterator<E> it = iterator();
		if (!it.hasNext()) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (;;) {
			E e = it.next();
			sb.append(e);
			if (!it.hasNext()) {
				return sb.append(']').toString();
			}
			sb.append(',').append(' ');
		}
	}

	private static class Node<E> {
		private E item;
		private Node<E> next;

		Node(E data, Node<E> next) {
			this.item = data;
			this.next = next;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private Node<E> currentNode = head;

			@Override
			public boolean hasNext() {
				return currentNode != null;
			}

			@Override
			public E next() {
				if (currentNode == null) {
					throw new RuntimeException("无下一节点");
				}
				E e = currentNode.item;
				currentNode = currentNode.next;
				return e;
			}
		};
	}

	/**
	 * 查找倒数第N个值
	 * @param n
	 * @return
	 */
	public E getLastN(int n) {
		Node<E> h = head;
		if (h == null || n < 1) {
			return null;
		}
		Node<E> fast = h; // 快
		Node<E> slow = h; // 慢

		int count = 1;
		while ((fast = fast.next) != null) {
			// 倒数第k个节点与倒数第1个节点相隔 n-1 个位置,因此fast先走 n-1 个位置
			if (count++ > n - 1) {
				slow = slow.next;
			}
		}

		// 链表中的元素个数小于 n
		if (count < n) {
			return null;
		}
		return slow.item;
	}

	/**
	 * 查找中间值
	 * @return
	 */
	public E getMiddle() {
		Node<E> h = head;
		if (h == null) {
			return null;
		}

		Node<E> fast = h; // 快
		Node<E> slow = h; // 慢

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			// 链表长度为偶数会有两个中间节点，返回第一个节点
			if (fast != null) {
				slow = slow.next;
			}
		}

		return slow.item;
	}

	public static void main(String[] args) {

		Linked<Integer> link = new Linked<Integer>();

		for (int i = 1; i <= 16; i++) {
			link.addTail(i);
		}

		System.out.println(link);
		System.out.println(link.getLastN(6));
		System.out.println(link.getMiddle());
	}

}
