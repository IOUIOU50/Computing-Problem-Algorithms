package Interface;

/* �����ڷ��� �䱸�� ���� Stack �ڷ�����
 * �߻� ������ Ÿ�Կ� �ʿ��� ������ ��*/
public interface Stack<Item> {
	void push(Item item);
	Item pop();
	boolean isEmpty();
	int Size();
}
