import java.util.Arrays;

/* 발상 : 2-sum을 linear로 구현하면, 3-sum은 자연스럽게 n^2이 된다.
 * 다만, 2-sum은 0을 구하는 거라면, 3-sum에서는 a[i]가 나오는 값을 찾게한다.
 * 구현 방안
 * 1. 배열 정렬
 * 2. 정렬된 원소 중, */
public class QuadraticTripleSum {
	public static void main(String[] args) {
		int[] a = {30, -40, -20, -10, 40, 0, 10, 5};
		int cnt = 0;
		Arrays.sort(a);
		
		int l = -1;
		int r = -1;
		
		for(int i=0; i<a.length; i++) {
			if(a[i]>=0) {
				l = i-1;
				r = i;
				break;
			}
		}
		
		for(int i=0; i<a.length; i++) {
			int first = a[i];
			int ptrLeft = l;
			int ptrRight = r;
			while(ptrLeft >=0 && ptrRight <= a.length) {
				if(a[ptrLeft] + a[ptrRight] == first) {
					cnt++;
					++ptrRight;
					--ptrLeft;
					continue;
				}
				else if(a[ptrRight] > -1*a[ptrLeft])
					--ptrLeft;
				else
					++ptrRight;
			}
		}
		
		System.out.println(cnt);
	}
}
