package testCase;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;


import com.group.DAO.HoaDonDAO;
import com.group.Model.HoaDon;

public class Test_HoaDonDAO {

@Test
public void testSelect() {
	HoaDonDAO dichVuDAO = new HoaDonDAO();
	 List<HoaDon> hdList =dichVuDAO.select() ;
    assertNotNull(hdList);
    assertFalse(hdList.isEmpty());
  }

@Test
public void testFindByMaDat() {
	String maDat ="DP001";
	int SDTKhach =901234567;
	String maHD="1";
	String maDV="DV001";
	
	HoaDonDAO dichVuDAO = new HoaDonDAO();
	HoaDon hdGet =dichVuDAO.findByMaDat(maDat) ;
	assertNotNull(hdGet);
    assertEquals(maDV, hdGet.getMaDV());
    assertEquals(maDat, hdGet.getMaDat());
    assertEquals(maHD, hdGet.getMaHD());
    assertEquals(SDTKhach, hdGet.getSDTKhach());
 }
@Test
public void testFindByMaDatInvalid() {
	String maDat ="DP025";
	HoaDonDAO dichVuDAO = new HoaDonDAO();
	HoaDon hdGet =dichVuDAO.findByMaDat(maDat);
	assertNull(hdGet);
 }


@Test
public void testInsert(){
  HoaDonDAO dao = new HoaDonDAO();
  HoaDon hd = new HoaDon("11", 123,"DP033" , "DV002");
  dao.insert(hd);
	String maDat ="DP033";
	int SDTKhach =123;
	String maDV="DV002";
  HoaDon hdGet = dao.findByMaDat("DP033"); 
  assertEquals(maDV, hdGet.getMaDV());
  assertEquals(maDat, hdGet.getMaDat());
  assertEquals(SDTKhach, hdGet.getSDTKhach());
}

@Test
public void testUpdate() {
	  HoaDonDAO dao = new HoaDonDAO();
	  HoaDon hd = dao.findByMaDat("DP033");
	  hd.setSDTKhach(456);
	  dao.update(hd);
	  HoaDon hdUpdated = dao.findByMaDat("DP033"); 
	  assertEquals(456, hdUpdated.getSDTKhach());

}
@Test
public void testDelete() {
	  HoaDonDAO dao = new HoaDonDAO();  
	  HoaDon Del = dao.findByMaDat("DP033");
	  String id = Del.getMaHD();
	  dao.delete(id);
	  HoaDon hdDeleted = dao.findByMaDat("DP033");
	  assertNull(hdDeleted); 
}

/*@After
public void DeleteInsert() {
	  HoaDonDAO dao = new HoaDonDAO(); 
	  HoaDon Del = dao.findByMaDat("DP033");
	  if(!(Del.getMaHD()=="")) {
	  String id = Del.getMaHD();
	  dao.delete(id);
	  }
	  
}*/

}
