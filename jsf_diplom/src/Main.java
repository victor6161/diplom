




import com.diplom.kozlov.db.dao.VesselDao;
import com.diplom.kozlov.entity.VesselEntity;


public class Main {
	public static void main(String[] args) {
		VesselEntity vessel = new VesselEntity();
		vessel.setName("testEJB22222");
		vessel.setType("testEJB22222");
		vessel.setLoadCapacity(7);
		vessel.setAverageSpeed(7);
		vessel.setFuelConsumption(7);

		VesselDao vesselDao = new VesselDao();
		vesselDao.save(vessel);
		vesselDao.getVessels();
	}
}
