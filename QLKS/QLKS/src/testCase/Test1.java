package testCase;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.group.DAO.HoaDonDAO;
import com.group.Model.HoaDon;
import org.junit.runner.JUnitCore;

public class Test1 {
	public void Test1() {
		
	}
	
@Test
public void updateDAOTest(){
	HoaDonDAO dao =new HoaDonDAO();
	HoaDon test = new HoaDon("123",123456789,"DP3303","DV005");
	dao.insert(test);
	test.setSDTKhach(789456123);
	dao.update(test);
	HoaDon out = dao.findByMaDat("DP3303");
	assertEquals(out.getSDTKhach(), test.getSDTKhach());
	
	
}
}
