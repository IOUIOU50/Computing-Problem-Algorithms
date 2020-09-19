package Interface;

/* 강의자료의 요구에 따라 Stack 자료형의
 * 추상 데이터 타입에 필요한 연산을 명세*/
public interface Stack<Item> {
	void push(Item item);
	Item pop();
	boolean isEmpty();
	int Size();
}
