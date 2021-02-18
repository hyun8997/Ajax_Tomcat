package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sun.security.action.GetIntegerAction;
import vo.DeptVO;
import vo.Goott_MemberVO;

public class Goott_MemberDAO {
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USER = "scott";
	final String PASSWORD = "tiger";
	
	StringBuffer sb = new StringBuffer();
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection conn = null;
	
	public Goott_MemberDAO() {
		try {
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			System.out.println("conn : "+ conn);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB ���� ����");
		}
	}// Goott_MemberDAO() end
	
	// ��� �߰�
	public void addData(Goott_MemberVO mvo) {
		sb.setLength(0);
		sb.append("insert into GOOTT_MEMBER ");
		sb.append("values (GOOTT_MEMBER_MEMNO_SEQ.nextval, ?, ?, ?, ?, ?, ?, sysdate ) ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setNString(1, mvo.getId());
			pstmt.setNString(2, mvo.getPw());
			pstmt.setNString(3, mvo.getName());
			pstmt.setNString(4, mvo.getBirth());
			pstmt.setNString(5, mvo.getMp());
			pstmt.setNString(6, mvo.getEmail());
			
			int result = pstmt.executeUpdate();
			System.out.println("result : "+ result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}// addData() end
	

	// ��ü ��ȸ
		public ArrayList getAllData() {
			
			ArrayList<Goott_MemberVO> list = new ArrayList<Goott_MemberVO>();
			
			sb.setLength(0);
			sb.append("select * from GOOTT_MEMBER ");
			
			try {
				pstmt = conn.prepareStatement(sb.toString());
				
				// ����
				rs = pstmt.executeQuery();
				
				// ���ڵ庰�� ���� ó��
				while(rs.next()) {
					// ���� ���ڵ忡�� ���� ���� ��������
					int memno = rs.getInt(1);
					String id = rs.getNString(2);
					String pw = rs.getNString(3);
					String name = rs.getNString(4);
					String birth = rs.getNString(5);
					String mp = rs.getNString(6);
					String regdate = rs.getNString(7);
					String email = rs.getNString(8);

					Goott_MemberVO vo = new Goott_MemberVO(id, pw, name, birth, mp, regdate, email, memno);
					
					// Collection�� ���
					list.add(vo);				
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;		
			
		}// selectAll() end
		
		
		//�����ϴ� ȸ������ ���θ� Ȯ���ϴ� �޼ҵ� - (id, pw)
		public boolean isExist(String id, String pw) {
			sb.setLength(0);
			sb.append("select * from goott_member ");
			sb.append("where id = ? and pw = ? ");
			
			boolean isOk = false;
			
			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setNString(1, id);
				pstmt.setNString(2, pw);
				
				rs = pstmt.executeQuery();
				
				isOk = rs.next();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return isOk;
		}// isExist() end
		
		
		// id로만 존재하는 회원인지 여부를 파악하는 메소드
		public boolean isExistById(String id) {
			
			sb.setLength(0);
			sb.append("select * from goott_member ");
			sb.append("where id = ? ");
			
			boolean flag = false;
			
			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				flag = rs.next();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return flag;
		}// isExistById() end
		
		
		
		
		
		
	
	
		// �ڿ��ݳ�
		public void close() {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}// close() end
		
		
		
		
	
}





