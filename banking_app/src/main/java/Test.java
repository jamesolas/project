import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.dbutil.PostresqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Transactions;
import com.app.service.impl.CustomerCrudServiceImpl;

public class Test {
	
	public static void main(String[] args) {
		
	}
	private static Logger log = Logger.getLogger(CustomerCrudServiceImpl.class); 
	
	public int updateTransactions(Transactions transactions) throws BusinessException {
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
		String sql = "insert into project.transactions (date, amount, accountnumber) values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
		preparedStatement.setLong(2, 100);
		preparedStatement.setLong(3, 9);
		
		log.info("date: "+java.sql.Date.valueOf(java.time.LocalDate.now()));
//		log.info("getAmount: "+transactions.getAmount());
//		log.info("getAccountNumber: "+transactions.getAccountNumber());
		
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);;
			throw new BusinessException("Inernal error occured. Please contact admin.");
		}
		return c;
	}

}
