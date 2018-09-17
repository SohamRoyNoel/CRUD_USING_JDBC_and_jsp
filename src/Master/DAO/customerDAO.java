package Master.DAO;

import java.sql.*;
import java.util.ArrayList;

import org.apache.tomcat.dbcp.dbcp.ConnectionFactory;

import Master.DTO.customerDTO;
import Master.DTO.feedbackDTO;
import Master.DTO.payDTO;
import Master.connection.connectionfactory;

public class customerDAO {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	String insert = "insert into customer values(?,?,?)";
	String update = "update customer set NAME=?, CITY=? where ID=?";
	String delete = "delete from customer where ID=?";
	String fetchall = "select * from CUSTOMER";
	String join = "select customer.NAME, customer.CITY, pay.PRICE from customer customer inner join pay pay on customer.ID=pay.CUSTOMER_ID";
	String join_three_tables = "select customer.NAME, customer.CITY, pay.PRICE, feedback.FEEDBACK from customer customer inner join pay pay on customer.ID=pay.CUSTOMER_ID inner join feedback feedback on pay.PAY_ID=feedback.PAY_IDS";
	
	public void insertEn(customerDTO dto) {
		try {
			connectionfactory cf = new connectionfactory();  
			con = cf.getcon();
			ps = con.prepareStatement(insert);
			ps.setInt(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getCity());
			ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateEn(customerDTO dto) {
		try {
			connectionfactory cf = new connectionfactory();
			con = cf.getcon();
			ps=con.prepareStatement(update);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getCity());
			ps.setInt(3, dto.getId());
			ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEn(customerDTO dto) {
		try {
			connectionfactory cf = new connectionfactory();
			con = cf.getcon();
			ps=con.prepareStatement(delete);
			ps.setInt(1, dto.getId());
			ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList fetchEn() {
		ArrayList ar = new ArrayList();
		try {
			connectionfactory cf = new connectionfactory();
			con = cf.getcon();
			st = con.createStatement();
			rs = st.executeQuery(fetchall);
			
			while(rs.next()) {
				customerDTO cdto = new customerDTO();
				cdto.setId(rs.getInt(1));
				cdto.setName(rs.getString(2));
				cdto.setCity(rs.getString(3));
				ar.add(cdto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ar;
	}

	public ArrayList fetchEn2() {
		ArrayList ar = new ArrayList();
		try {
			connectionfactory cf = new connectionfactory();
			con = cf.getcon();
			st = con.createStatement();
			rs = st.executeQuery(fetchall);
						
			rs.updateString("city", "yyy");
			rs.updateRow();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ar;
	}
	
	public ArrayList fetchEn1(String x) {
		ArrayList ar = new ArrayList();
		String fetchall1 = "select * from customer where CITY like '"+x+"%'";
		try {
			connectionfactory cf = new connectionfactory();
			con = cf.getcon();
			st = con.createStatement();
			rs = st.executeQuery(fetchall1);
			
			while(rs.next()) {
				customerDTO cdto = new customerDTO();
				cdto.setId(rs.getInt(1));
				cdto.setName(rs.getString(1));
				cdto.setCity(rs.getString(3));
				ar.add(cdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	public ArrayList join() {
		ArrayList ar = new ArrayList();
		try {
			connectionfactory cf = new connectionfactory();
			con = cf.getcon();
			st = con.createStatement();
			rs = st.executeQuery(join);
			
			while(rs.next()) {
				customerDTO cdto = new customerDTO();
				payDTO pdto = new payDTO();
				cdto.setName(rs.getString(1));
				cdto.setCity(rs.getString(2));
				pdto.setPRICE(rs.getInt(3));
				ar.add(cdto);
				ar.add(pdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	public ArrayList join_3_tabels() {
		ArrayList ar = new ArrayList();
		try {
			connectionfactory cf = new connectionfactory();
			con = cf.getcon();
			st = con.createStatement();
			rs = st.executeQuery(join_three_tables);
			
			while(rs.next()) {
				customerDTO cdto = new customerDTO();
				payDTO pdto = new payDTO();
				feedbackDTO fdto = new feedbackDTO();
				cdto.setName(rs.getString(1));
				cdto.setCity(rs.getString(2));
				pdto.setPRICE(rs.getInt(3));
				fdto.setFEEDBACK(rs.getString(4));
				ar.add(cdto);
				ar.add(pdto);
				ar.add(fdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	
	
	
	
	
	
	
}
