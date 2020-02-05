package com.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class GetNameData2
 */
@WebServlet("/GetNameData2")
public class GetNameData2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource dataSource = null;
	private String result = "";

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		// initialize method
		Context context = null;
		try {
			// 使用 DataSource 資料庫連線池 來進行連線。
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Exam1_1");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 事先在初始化函式就先把資料庫的資料取出來塞進字串儲存。
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		StringBuilder stringBuilder = new StringBuilder();
		try {
			connection = dataSource.getConnection();
			String queryStatement = "SELECT cname FROM Employee";// 查詢資料指令，把名單查出來。
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queryStatement);
			boolean isSecond = false;
			// isSecond第一次為false，第二次才被設定為true
			// 因為 eclipse IDE 不支援 '\b'字元，因此改以其他方式處理。
			while (true == resultSet.next()) {
				// 邊查資料，邊動態產生名字陣列，並用逗號隔開。
				if (true == isSecond) {
					stringBuilder.append(",");
				} else {
					isSecond = true;
				}
				stringBuilder.append(resultSet.getString("cname"));
			}

			// 一定要加這行程式碼印出來。才可以讓AJAX把動態產生的下拉式選單製作出來。
			result = stringBuilder.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
					statement = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end of finally

	}// end of init() method

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetNameData2() {
		super();
		// TODO Auto-generated constructor stub
		// 建構子
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("GetNameData2 Servlet doGet() method");
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println("GetNameData2 Servlet doPost() method");
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		/* Setting the Encoding of Input Data */
		request.setCharacterEncoding("UTF-8");

		/* Setting the encoding of the output data to the web page */
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		response.getWriter().print(result);
	}// end of processRequest method

}
