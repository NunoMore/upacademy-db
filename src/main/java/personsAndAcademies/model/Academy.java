package personsAndAcademies.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@Entity
public class Academy implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long ID;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}

	private String name;
	private String description;
	private Date date;
	
	
	public Academy(){
		
	}
	
	//@Lob
	//@Column(name="ACADEMY_PDF", nullable=false, columnDefinition="mediumblob")
	//private byte[] pdf;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	/*public byte[] getPdf() {
		return pdf;
	}
	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}*/
	public static Long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/*public static Connection conn=null;
	public static PreparedStatement pstmt=null;
	public static ResultSet rs=null;
	private String str="";
	
	public static Connection getConnection(){
	
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// alt + enter
			conn=DriverManager.getConnection("jdbc:sqlserver://localhost:3306;database=up_academy_db");
		
		} catch (ClassNotFoundException e) {
			Logger.getLogger(Academy.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			
		} catch (SQLException e) {
			Logger.getLogger(Academy.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closseAll(Connection conn, PreparedStatement pstmt, ResultSet rs){
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				Logger.getLogger(Academy.class.getName()).log(Level.SEVERE, null, e);
				e.printStackTrace();
			}
			
		}
		
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				Logger.getLogger(Academy.class.getName()).log(Level.SEVERE, null, e);
				e.printStackTrace();
			}
			
		}
		
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				Logger.getLogger(Academy.class.getName()).log(Level.SEVERE, null, e);
				e.printStackTrace();
			}
			
		}
	}*/
	
	//public static void main(String[] args){
		//System.out.println(getConnection());
	//}
	
	
	
	
	
	
}
