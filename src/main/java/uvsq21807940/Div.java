package uvsq21807940;

public class Div implements CommandSpecial {

	public void apply() {
		// TODO Auto-generated method stub

	}

	public double apply(double a, double b) throws Exception {
		// TODO Auto-generated method stub
		 if (b == 0) {
	            throw new Exception();
	        }
	        return a / b;
	}

}
