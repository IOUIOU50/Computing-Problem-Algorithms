import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BSTSymbolTable<Key extends Comparable<Key>, Value> {
	//강의자료와 동일
    private Node root;             

    private class Node {
        private Key key;           
        private Value val;        
        private Node left, right;  
        private int count;          

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.count = 1;
        }
        
    }
	
    /* ****************************************************************************
     * 1. key가 없다면 새로 삽입
     * 2. key가 이미 존재한다면 value 갱신*/
	public void put(Key key, Value val) {
		Node node = getNode(key);
		if(node != null) {
			node.val = val;
			return;
		}
		root = put(root, key, val);
	}
	
	/* *****************************************************************************/
	private Node put(Node x, Key key, Value val) {
		//강의자료와 동일
		if(x == null) return new Node(key, val);
		int cmp = key.compareTo(x.key);
		if		(cmp < 0) 	x.left = put(x.left, key, val);
		else if	(cmp > 0) 	x.right = put(x.right, key, val);
		else if	(cmp == 0)	x.val = val;
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

	/* *****************************************************************************/
	/* 
	 * 강의자료의 get(key)메소드와 동일하지만
	 * delete(key)메소드를 구현하는데 필요한 알고리즘이 쓰이고있어
	 * 해당 알고리즘을 재사용을 위해 get()알고리즘을 분리
	 * */
	private Node getNode(Key key) {
		
		Node x = root;
		while(x != null) {
			int cmp = key.compareTo(x.key);
			if		(cmp < 0)	x = x.left;
			else if	(cmp > 0)	x = x.right;
			else				return x; //x.val -> x 노드 자체를 반환토록 수정
		}
		return null;
	}
	
	/* ****************************************************************************
	 * 클라이언트 코드에서 value를 요청하는 메소드 
	 * 기존 강의자료의 get()메소드를 각각 
	 * 클라이언트에서 (K, V)를 요청하는 get()메소드와
	 * delete(key)메소드에서 이용할 getNode()메소드로 분리
	 * */
	public Value get(Key key) {
		Node node = getNode(key);
		
		if(node == null)	return null;
		else				return node.val;
	}

	/* *****************************************************************************/

	//강의자료와 동일
	public Key floor(Key key) {
		Node x = floor(root, key);
		if(x == null) return null;
		return x.key;
	}

	/* *****************************************************************************/
	//강의자료와 동일
	private Node floor(Node x, Key key) {
		if(x==null) return null;
		
		int cmp = key.compareTo(x.key);
		if		(cmp == 0)	return x;
		if		(cmp < 0)	return floor(x.left, key);
		
		Node t = floor(x.right, key);
		if(t != null) return t;
		else return x;
	}
	
	/* *****************************************************************************/
	public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        
        if (x == null) return null;
        else return x.key;
    }

	//floor와 반대로 동작
    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
		if		(cmp > 0)	return ceiling(x.right, key);
		
		Node t = ceiling(x.left, key);
		if(t != null) return t;
		else return x;
    } 

	/* ***************************************************************************
	 * BST에서 자식이 있는 노드를 삭제할 경우 두 가지 삭제 방법이 존재
	 * 1. 해당 노드의 왼쪽 서브트리 중, 	-> 가장 큰 값을 삭제하려는 노드의 위치로 가져온다.
	 * 2. 해당 노드의 오른쪽 서브트리 중,	-> 가장 작은 값을 삭제하려는 노드의 위치로 가져온다.
	 * 이 때, 가져오게되는 노드와, 이 노드의 부모노드사이의 링크를 끊어주어야하기 때문에
	 * 메모리 효율을 생각하여 부모노드의 Key만 저장해 두었다가
	 * 1, 2번의 조건에 해당하는 노드를 찾으면
	 * 저장해두었던 부모노드의 key를 찾아 left 또는 right를 null로 치환한다.  
	 * */
	public void delete(Key key) {
        Node oldNode = getNode(key);
        if(oldNode == null)	return;	//key에 해당하는 노드가 있는지 검사
        
        root.count--;
        //key해당하는 Node가 root인 경우
        if(oldNode.key == root.key) { 
        	root = null;
        	return;	
        }
        
        Node alterNode;
        Key cutLink = null; 

        //1번 조건 : 왼쪽 서브트리의 가장 큰 값을 가져오기
        if(oldNode.left != null) {
        	alterNode = oldNode.left;		
        	alterNode.count--;
        	while(alterNode.right != null) {
        		cutLink = alterNode.key;
        		alterNode = alterNode.right;
        		alterNode.count--;
        	}
        	
        	oldNode.key = alterNode.key;
        	oldNode.val = alterNode.val;
        	alterNode = null;
        	if(cutLink != null)
        		getNode(cutLink).right = null;
        
        } else { //2번 조건 : 오른쪽 서브트리의 가장 작은 값을 가져오기
        	alterNode = oldNode.right;
        	alterNode.count--;
        	while(alterNode.left != null) {
        		cutLink = alterNode.key;
        		alterNode = alterNode.left;
        		alterNode.count--;
        	}
        	oldNode.key = alterNode.key;
        	oldNode.val = alterNode.val;
        	alterNode = null;
        	if(cutLink != null)
        		getNode(cutLink).left = null;
        }
	}
	
	public boolean contains(Key key) {
        return get(key) != null;
	}
	
	public boolean isEmpty() {
        return size() == 0;
	}
	
	public int size() {
        return size(root);
	}

	private int size(Node x) {
		if(x == null) return 0;
		return x.count;
	}

	public Key minKey() {
		if(root == null) return null;
		
		Node node = root;
		while(node.left != null) {
			node = node.left;
		}
		
		return node.key;
	}
	
	public Key maxKey() {
		if(root == null) return null;

		Node node = root;
		while(node.right != null) {
			node = node.right;
		}
		
		return node.key;

	}
	
	public int rank(Key key) {
		return rank(key, root);
	}
	
	private int rank(Key key, Node x) {
		if(x == null) return 0;
		int cmp = key.compareTo(x.key);
		if		(cmp < 0)	return rank(key, x.left);
		else if	(cmp > 0) 	return size(x.left) + rank(key, x.right);
		else				return size(x.left);
	}
	
	public Key select(int k) {
		Iterator<Key> iter = keys().iterator();
		
		for(int i=0; i<k-1; i++) {
			iter.next();
		}
		
		return iter.next();
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x) {
		if(x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.count = 1 + size(x.left) + size(x.right);
		return x; 
	}
	
	public void deleteMax() {
		root = deleteMax(root);
	}
	
	private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.count = size(x.left) + size(x.right) + 1;
        return x;
	}
	
	public int size(Key lo, Key hi) {
		return rank(hi) - rank(lo);
	}
	
	public Iterable<Key> keys(){
		Queue<Key> q = new LinkedList<Key>();
		inorder(root, q);
		return q;
	}
	
	private void inorder(Node x, Queue<Key> q) {
		if(x == null) return;
		inorder(x.left, q);
		q.add(x.key);
		inorder(x.right, q);
	}
	
	//lo와 hi사이의 key를 반환하는 iterator는 해결하지 못했습니다..
//	public Iterable<Key> keys(Key lo, Key hi){
//		
//	}
}
