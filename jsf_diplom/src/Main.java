import com.diplom.kozlov.db.dao.SheduleDao;

public class Main {
	public static void main(String[] args) {
		
	
		SheduleDao sheduleDao = new SheduleDao();
		System.out.println(sheduleDao.getShedule());
		
	}
}
