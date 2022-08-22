import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class jdbcconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dell\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String host = "localhost";
		String port="3306";
		Connection con =DriverManager.getConnection("jdbc:mysql://"+ host +":"+ port +"/qadbt", "root", "MySQL@9030");
		Statement s=con.createStatement();
		ResultSet rs =s.executeQuery("select * from Employeeinfo where name='lam'");
		while(rs.next())
		{
		driver.get("https://login.salesforce.com/?locale=in");
		driver.findElement(By.cssSelector("#username")).sendKeys(rs.getString("name"));
		driver.findElement(By.cssSelector("#password")).sendKeys((rs.getString("location")));
		//System.out.println(rs.getInt("age"));
		}
	}

}
