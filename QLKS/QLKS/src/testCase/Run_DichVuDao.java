package testCase;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;



public class Run_DichVuDao {

	public static void main(String[] args) {
		JUnitCore runner = new JUnitCore();
		Result rs = runner.run(Test_DichVuDAO.class);
		System.out.println("Run test:"+rs.getRunCount());
		System.out.println("Failed test:"+rs.getFailureCount());
		System.out.println("Ignored test:"+rs.getIgnoreCount());
		System.out.println("Success test:"+rs.wasSuccessful());
		 
		Result rs2 = runner.run(Test_HoaDonDAO.class);
		System.out.println("Run test:"+rs2.getRunCount());
		System.out.println("Failed test:"+rs2.getFailureCount());
		System.out.println("Ignored test:"+rs2.getIgnoreCount());
		System.out.println("Success test:"+rs2.wasSuccessful());

	}

}
