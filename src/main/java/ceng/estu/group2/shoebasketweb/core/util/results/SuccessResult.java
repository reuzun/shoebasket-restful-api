package ceng.estu.group2.shoebasketweb.core.util.results;

public class SuccessResult extends Result{
		public SuccessResult() {
			super(true);
		} 
		
		public SuccessResult(String message) {
			super(true,message);
		} 
}
