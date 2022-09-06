package functionalinterfacesdemo;

import org.springframework.retry.support.RetryTemplate;

public class Runner {
	public static void main(String[] args) {
		Add d = (int a, int b) -> {
			return a + b;
		};
		
		Add doubs = (int a, int b) ->{
			return (a + b)*2;
		};
		int aa = d.add(1, 2);
		System.out.println(aa);
		RetryTemplate retryTemplate = new RetryTemplate();
		retryTemplate.setRetryPolicy(null);
		
		
	}
}
