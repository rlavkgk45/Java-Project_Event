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
			throw new NotExistException("검색하진 Event 정보가 없습니다.");
		}
	}

	//모든 Event 리스트 반환
	public static ArrayList<EventDTO> getAllEvents() throws SQLException{
		return EventDAO.getAllEvents();
	}
	
	//Event title로 검색
	public static EventDTO getEvent(String title) throws SQLException, NotExistException{
		EventDTO event = EventDAO.getEvent(title);
		if(event == null){
			throw new NotExistException("검색하신 Event 정보가 없습니다.");
		}
		return event;
	}
	
	//Event location 모두 검색
	public static ArrayList<EventDTO> getLocationEvent(String title) throws SQLException, NotExistException{
		ArrayList<EventDTO> event = EventDAO.getLocationEvent(title);
		notExistEvent(title);
		if(event == null){
			throw new NotExistException("검색하신 Event 정보가 없습니다.");
		}
		return event;
	}
	
	//새로운 Event 저장
	public void addEvent(JSONArray event) throws Exception{
		EventDAO.addEvent(event);
	}
	
	public void addnewEvent(EventDTO newEvent) throws SQLException {
		EventDAO.insertEvent(newEvent);
	}
	
	//기존 Event 수정
	public static void updateEvent(String tel, String title) throws SQLException, NotExistException{
		notExistEvent(title);
		EventDAO.updateEvent(tel, title);
	}
	
	
	
	//Event 삭제
	public boolean deleteEvent(String title) throws SQLException, NotExistException{
		notExistEvent(title);
		return EventDAO.deleteEvent(title);
	}

	//Category - CRUD
	public static void notExistCategory(String categoryname) throws NotExistException, SQLException{
		CategoryDTO category = CategoryDAO.getCategoryname(categoryname);
		if(category == null){
			throw new NotExistException("검색하는 Event가 미 존재합니다.");
		}
	}
	
	//Category 삽입
	public static boolean addCategory(CategoryDTO category) throws SQLException{
		return CategoryDAO.addActivist(category);	
	}
	
	//Category 수정
	public static boolean updateCategory(String catNumber, String category) throws SQLException, NotExistException{
		notExistCategory(catNumber);
		return CategoryDAO.updateCategory(catNumber, category);
	}
	
	//Category 삭제
	public boolean deleteCategory(String catNumber) throws SQLException, NotExistException{
		notExistCategory(catNumber);
		return CategoryDAO.deleteCategory(catNumber);
	}
	
	//Category 검색
	public static CategoryDTO getCategory(String catNumber) throws SQLException, NotExistException{
		CategoryDTO category = CategoryDAO.getCategory(catNumber);
		if(category == null){
			throw new NotExistException("검색하는 카테고리가 존재하지 않습니다.");
		}
		return category;
	}
	
	//모든 Category 리스트 반환
	public static ArrayList<CategoryDTO> getAllCategorys() throws SQLException{
		return CategoryDAO.getAllCategorys();
	}
	
	//Event category 모두 검색
	public static ArrayList<EventDTO> getCategoryEvent(String category) throws SQLException, NotExistException{
		ArrayList<EventDTO> event = EventDAO.getCategoryEvent(category);
		notExistCategory(category);
		if(event == null){
			throw new NotExistException("검색하신 Event 정보가 없습니다.");
		}
		return event;
	}

	//location - CRUD
	public static void notExistLocation(int areaCode) throws NotExistException, SQLException{
		LocationDTO location = LocationDAO.getLocation(areaCode);
		if(location == null){
			throw new NotExistException("검색하는 지역이 존재하지 않습니다");
		}
	}
	
	//location 삽입
	public static boolean addLocation(LocationDTO location) throws SQLException{
		return LocationDAO.addLocation(location);
	}
	
	//location 수정
	public static boolean updateLocation(int areaCode, String location) throws SQLException, NotExistException{
		notExistLocation(areaCode);
		return LocationDAO.updateLocation(areaCode, location);
	}
	
	//location 삭제
	public boolean deleteLocation(int areaCode) throws SQLException, NotExistException{
		notExistLocation(areaCode);
		return LocationDAO.deleteLocation(areaCode);
	}
	
	//areaCode로 location 검색
	public static LocationDTO getLocation(int areaCode) throws SQLException{
		return LocationDAO.getLocation(areaCode);
	}
	
	//location 모든 정보 반환
	public static ArrayList<LocationDTO> getAllLocations() throws SQLException{
		return LocationDAO.getAllLocations();
	}

}