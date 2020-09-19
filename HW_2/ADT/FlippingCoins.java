public class FlippingCoins {
	public static void main(String[] args) {
		int T = Integer.parseInt(args[0]);
		Counter heads = new Counter("heads");
		Counter tails = new Counter("tails");
		
		for(int t=0; t<T; t++) {
			 if(StdRandom.bernoulli(0.5)) {
				 heads.increment();
			 } else {
				 tails.increment();
			 }
		}
		
		System.out.println(heads);
		System.out.println(tails);
		int d = heads.tally() - tails.tally();
		
		System.out.println("delta:" + Math.abs(d));
	}
}
