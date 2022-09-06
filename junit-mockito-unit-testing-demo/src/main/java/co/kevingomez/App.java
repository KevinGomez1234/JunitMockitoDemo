package co.kevingomez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{

    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    	
    	
    	
//    	App a = new App();
//    	a.retryTemplate.execute(args0 -> {
//    		//some service
//    		return null;
//    	}
//    	);
    }
    
//    @Bean
//    public RetryTemplate retryTemplate() {
//    	RetryTemplate retryTemplate = new RetryTemplate();
////    	SimpleRetryPolicy simplePolicy = new SimpleRetryPolicy();
////    	simplePolicy.setMaxAttempts(10);
////    	FixedBackOffPolicy backoffPolicy = new FixedBackOffPolicy();
////    	backoffPolicy.setBackOffPeriod(1000l);
////    	retryTemplate.setRetryPolicy(simplePolicy);
////    	retryTemplate.setBackOffPolicy(backoffPolicy);
//        final Map<Class<? extends Throwable>, RetryPolicy> policyMap = new HashMap<>();
//        policyMap.put(Exception.class, new SimpleRetryPolicy(10));
//        policyMap.put(Exception.class, new AlwaysRetryPolicy() );
//        final ExceptionClassifierRetryPolicy retryPolicy = new ExceptionClassifierRetryPolicy();
//        retryPolicy.setPolicyMap(policyMap);
//        retryTemplate.setRetryPolicy(retryPolicy);        
//    	return retryTemplate;
//    }
    
    
}
