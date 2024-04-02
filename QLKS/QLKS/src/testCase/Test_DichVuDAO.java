package testCase;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;


import com.group.DAO.DichVuDAO;
import com.group.Model.DichVu;

public class Test_DichVuDAO {

@Test
public void testSelect() {
	 DichVuDAO dichVuDAO = new DichVuDAO();
	 List<DichVu> dvList =dichVuDAO.select() ;
    assertNotNull(dvList);
    assertFalse(dvList.isEmpty());
  }
@Test
public void testFindByMaDV() {
	String maDV ="DV001";
	String tenDV ="Dịch vụ phòng ăn";
	double giaDV=150000;
	
    DichVuDAO dichVuDAO = new DichVuDAO();
	DichVu dvGet =dichVuDAO.findByMaDV(maDV) ;
	assertNotNull(dvGet);
    assertEquals(maDV, dvGet.getMaDV());
    assertEquals(tenDV, dvGet.getTenDV());
    assertEquals(giaDV, dvGet.getGia(),0);
 }
@Test
public void testFindByMaDVInvalid() {
	String maDV ="DV020";
    DichVuDAO dichVuDAO = new DichVuDAO();
	DichVu dvGet =dichVuDAO.findByMaDV(maDV) ;
	assertNull(dvGet);
 }

}
