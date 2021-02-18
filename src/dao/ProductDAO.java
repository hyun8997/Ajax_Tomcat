package dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.OracleXEConnection;
import vo.ProductVO;

public class ProductDAO {
	/*
	 * // DBMS �����ϵ��� �ϴ� �̱��� ���� ��ü�� �����Ǿ����Ƿ� ���� �ڵ�� �ʿ���� final String DRIVER =
	 * "oracle.jdbc.driver.OracleDriver"; final String URL =
	 * "jdbc:oracle:thin:@localhost:1521:XE"; final String USER = "scott"; final
	 * String PASSWORD = "tiger";
	 */

	StringBuffer sb = new StringBuffer();
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection conn = null;

	public ProductDAO() {

		/*
		 * try { Class.forName(DRIVER);
		 * 
		 * conn = DriverManager.getConnection(URL, USER, PASSWORD);
		 * 
		 * System.out.println("conn : "+conn);
		 * 
		 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */

		conn = OracleXEConnection.getInstance().getConnection(); // �ν��Ͻ�ȭ �ϰ� Ŀ�ؼ� �ϱ�

	}// ������ end

	// ��ǰ ���� �Է��ϴ� �޼ҵ� - addData()
	public int addData(ProductVO vo) {
		sb.setLength(0);
		sb.append("insert into product ");
		sb.append("values (product_pno_seq.nextval, ?, ?, ?, ?, ?, ?, ? ) ");

		int result = -1;

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setNString(1, vo.getPname());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getDcratio());
			pstmt.setNString(4, vo.getProdesc());
			pstmt.setInt(5, vo.getQty());
			pstmt.setNString(6, vo.getImgFile());
			pstmt.setNString(7, vo.getBigImgFile());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}// addData() end

	// ��ǰ���� ��ü ��ȸ�ϴ� �޼ҵ� - getAllData();
	public ArrayList<ProductVO> getAllData() {

		ArrayList<ProductVO> list = new ArrayList<ProductVO>();

		sb.setLength(0);
		sb.append("select * from product ");

		try {
			pstmt = conn.prepareStatement(sb.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int pno = rs.getInt(1); // getInt("pno") ����
				String pname = rs.getNString(2);
				int price = rs.getInt(3);
				int dcratio = rs.getInt(4);
				String prodesc = rs.getNString(5);
				int qty = rs.getInt(6);
				String imgFile = rs.getNString(7);
				String bigImgFile = rs.getNString(8);

				ProductVO vo = new ProductVO(pno, pname, price, dcratio, prodesc, qty, imgFile, bigImgFile);

				list.add(vo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}// getAllData() end

	
	// ���� ��ǰ ������ ��ȸ - ��ǰ ��ȣ�� ��ȸ(PK�̹Ƿ�) - getData()
	public ProductVO getData(int pno) {
		
		sb.setLength(0);
		sb.append("select * from product ");
		sb.append("where pno = ? ");
		
		ProductVO vo = null;
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, pno);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			String pname = rs.getNString(2);
			int price = rs.getInt(3);
			int dcratio = rs.getInt(4);
			String prodesc = rs.getNString(5);
			int qty = rs.getInt(6);
			String imgFile = rs.getNString(7);
			String bigImgFile = rs.getNString(8);
			
			vo = new ProductVO(pno, pname, price, dcratio, prodesc, qty, imgFile, bigImgFile);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}
	
	
	// 상품 정보를 조회 - 개별 상품 이름 - getDataByName()
	public ProductVO getDataByName(String pname) {
		sb.setLength(0);
		sb.append("select * from product ");
		sb.append("where pname = ? ");
		
		ProductVO vo = null;
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setNString(1, pname);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			int pno = rs.getInt(1);
			int price = rs.getInt(3);
			int dcratio = rs.getInt(4);
			String prodesc = rs.getNString(5);
			int qty = rs.getInt(6);
			String imgFile = rs.getNString(7);
			String bigImgFile = rs.getNString(8);
			
			vo = new ProductVO(pno, pname, price, dcratio, prodesc, qty, imgFile, bigImgFile);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}// getDataByName() end
	
	
	// ���Ӱ� �߰��� ��ǰ�� ������ ���� - ����, ������, ���� - modifyData()
	public int modifyData(int pno, int price, int dcratio, int qty) {
		sb.setLength(0);
		sb.append("update product ");
		sb.append("set price = ?, dcratio = ?, qty = ? ");
		sb.append("where pno = ? ");
		
		int result = -1;
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, price);
			pstmt.setInt(2, dcratio);
			pstmt.setInt(3, qty);
			pstmt.setInt(4, pno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}// modifyData() end
	
	
	// ���Ӱ� �߰��� ��ǰ�� ���� - deleteData()
	public int deleteData(int pno) {
		sb.setLength(0);
		sb.append("delete product ");
		sb.append("where pno = ? ");
		
		int result = -1;
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, pno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}// deleteData() end
	
	
	
	
	
	
	// �ڿ��ݳ�
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// close() end

}
