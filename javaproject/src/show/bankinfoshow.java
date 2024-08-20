package show;
import java.sql.*;

import ConnectionManager.ConnectionManager;
import register.bankinfo;
public class bankinfoshow 
{
	public void add(bankinfo p) throws ClassNotFoundException, SQLException
	{
		int AccountID=p.getAccountID();
		String AccountName=p.AccountName();
		String Address=p.Address();
		int PhoneNumber=p.PhoneNumber();
		int Balance=p.getBalance();
		
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		String query = "insert into bankinfo values (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,AccountID);
		ps.setString(2, AccountName);
		ps.setString(3,Address);
		ps.setInt(4,PhoneNumber);
		ps.setInt(5,Balance);
		
		ps.executeUpdate();
		
		conm.closeConnection();
	}
	
	public void display() throws ClassNotFoundException, SQLException
	{
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from product");
		while(rs.next())
		{
			System.out.println(rs.getInt("AccountID")+" | "+rs.getString("AccountName")+" | "+rs.getString("Address")+" | "+rs.getInt("PhoneNumber")+" | "+rs.getInt("Balance"));
		}
	}
	
	public boolean updatebankinfo(bankinfo p) throws ClassNotFoundException, SQLException
	{
		int AccountID = p.getAccountID();
		int Withdraw = p.getWithdraw();
		
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		PreparedStatement st = con.prepareStatement("select Balance from bankinfo where AccountID = ?");
		st.setInt(1,AccountID);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		int i = rs.getInt(1);
		if(i>=Withdraw)
		{
			st = con.prepareStatement("update bankinfo set Balance=? where AccountID=?");
			st.setInt(1,(i-Withdraw));
			st.setInt(2, AccountID);
			st.executeUpdate();
			conm.closeConnection();
			return true;
		}
		else
			conm.closeConnection();
			return false;
	}
}
