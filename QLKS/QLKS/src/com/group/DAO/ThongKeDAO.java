/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.DAO;

import com.group.Library.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kien Luu
 */
public class ThongKeDAO {
    public List<Object[]> getDTTheoPhong() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "exec dbo.sp_DTSoPhong";
                rs = JDBCHelper.executeQuery(sql);
                while (rs.next()) {
                    
                    Object[] model = {
                        rs.getString("SoPhong"),
                        rs.getInt("SoNgayThue"),  
                        formatTienVND(rs.getDouble("TongTienphong")),
                        formatTienVND(rs.getDouble("TongTiendv")),    
                        formatTienVND(rs.getDouble("TongThu"))
                    };                            
                    list.add(model);
                }
            }
            finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public List<Object[]> getDTTheoThang(String nam) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "exec dbo.sp_DTThang " + nam;
                rs = JDBCHelper.executeQuery(sql);
                while (rs.next()) {
                    double tiendv;
                    if (rs.getDouble("Tongtiendichvu") != 0) {
                        tiendv = rs.getDouble("Tongtiendichvu");
                    } else {
                        tiendv = 0;
                    }
                    Object[] model = {
                        rs.getString("Thang"),
                        rs.getInt("TongSoNgayThue"),
                        formatTienVND(rs.getDouble("Tongtienphong")),
                        formatTienVND(tiendv),
                        formatTienVND(rs.getDouble("Tongdoanhthu"))
                    };                            
                    list.add(model);
                }
            }
            finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    //Định dạng tiền
    private static String formatTienVND(double giaTien) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0 VND");
        return decimalFormat.format(giaTien);
    }
}
