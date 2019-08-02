package event.model;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import event.exception.NotExistException;
import event.model.dto.CategoryDTO;
import event.model.dto.EventDTO;
import event.model.dto.LocationDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventService {
	
	private static EventService instance = new EventService();
	
	public static EventService getInstance(){
		return instance;
	}
		 
	//Event - CRUD
	public static void notExistEvent(String title) throws NotExistException, SQLException{
		EventDTO event = EventDAO.getEvent(title);
		if(event == null){
			throw new NotExistException("�˻����� Event ������ �����ϴ�.");
		}
	}

	//��� Event ����Ʈ ��ȯ
	public static ArrayList<EventDTO> getAllEvents() throws SQLException{
		return EventDAO.getAllEvents();
	}
	
	//Event title�� �˻�
	public static EventDTO getEvent(String title) throws SQLException, NotExistException{
		EventDTO event = EventDAO.getEvent(title);
		if(event == null){
			throw new NotExistException("�˻��Ͻ� Event ������ �����ϴ�.");
		}
		return event;
	}
	
	//Event location ��� �˻�
	public static ArrayList<EventDTO> getLocationEvent(String title) throws SQLException, NotExistException{
		ArrayList<EventDTO> event = EventDAO.getLocationEvent(title);
		notExistEvent(title);
		if(event == null){
			throw new NotExistException("�˻��Ͻ� Event ������ �����ϴ�.");
		}
		return event;
	}
	
	//���ο� Event ����
	public void addEvent(JSONArray event) throws Exception{
		EventDAO.addEvent(event);
	}
	
	public void addnewEvent(EventDTO newEvent) throws SQLException {
		EventDAO.insertEvent(newEvent);
	}
	
	//���� Event ����
	public static void updateEvent(String tel, String title) throws SQLException, NotExistException{
		notExistEvent(title);
		EventDAO.updateEvent(tel, title);
	}
	
	
	
	//Event ����
	public boolean deleteEvent(String title) throws SQLException, NotExistException{
		notExistEvent(title);
		return EventDAO.deleteEvent(title);
	}

	//Category - CRUD
	public static void notExistCategory(String categoryname) throws NotExistException, SQLException{
		CategoryDTO category = CategoryDAO.getCategoryname(categoryname);
		if(category == null){
			throw new NotExistException("�˻��ϴ� Event�� �� �����մϴ�.");
		}
	}
	
	//Category ����
	public static boolean addCategory(CategoryDTO category) throws SQLException{
		return CategoryDAO.addActivist(category);	
	}
	
	//Category ����
	public static boolean updateCategory(String catNumber, String category) throws SQLException, NotExistException{
		notExistCategory(catNumber);
		return CategoryDAO.updateCategory(catNumber, category);
	}
	
	//Category ����
	public boolean deleteCategory(String catNumber) throws SQLException, NotExistException{
		notExistCategory(catNumber);
		return CategoryDAO.deleteCategory(catNumber);
	}
	
	//Category �˻�
	public static CategoryDTO getCategory(String catNumber) throws SQLException, NotExistException{
		CategoryDTO category = CategoryDAO.getCategory(catNumber);
		if(category == null){
			throw new NotExistException("�˻��ϴ� ī�װ��� �������� �ʽ��ϴ�.");
		}
		return category;
	}
	
	//��� Category ����Ʈ ��ȯ
	public static ArrayList<CategoryDTO> getAllCategorys() throws SQLException{
		return CategoryDAO.getAllCategorys();
	}
	
	//Event category ��� �˻�
	public static ArrayList<EventDTO> getCategoryEvent(String category) throws SQLException, NotExistException{
		ArrayList<EventDTO> event = EventDAO.getCategoryEvent(category);
		notExistCategory(category);
		if(event == null){
			throw new NotExistException("�˻��Ͻ� Event ������ �����ϴ�.");
		}
		return event;
	}

	//location - CRUD
	public static void notExistLocation(int areaCode) throws NotExistException, SQLException{
		LocationDTO location = LocationDAO.getLocation(areaCode);
		if(location == null){
			throw new NotExistException("�˻��ϴ� ������ �������� �ʽ��ϴ�");
		}
	}
	
	//location ����
	public static boolean addLocation(LocationDTO location) throws SQLException{
		return LocationDAO.addLocation(location);
	}
	
	//location ����
	public static boolean updateLocation(int areaCode, String location) throws SQLException, NotExistException{
		notExistLocation(areaCode);
		return LocationDAO.updateLocation(areaCode, location);
	}
	
	//location ����
	public boolean deleteLocation(int areaCode) throws SQLException, NotExistException{
		notExistLocation(areaCode);
		return LocationDAO.deleteLocation(areaCode);
	}
	
	//areaCode�� location �˻�
	public static LocationDTO getLocation(int areaCode) throws SQLException{
		return LocationDAO.getLocation(areaCode);
	}
	
	//location ��� ���� ��ȯ
	public static ArrayList<LocationDTO> getAllLocations() throws SQLException{
		return LocationDAO.getAllLocations();
	}

}