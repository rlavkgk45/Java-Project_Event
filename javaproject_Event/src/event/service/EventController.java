package event.service;

import java.sql.SQLException;
import java.util.ArrayList;

import event.exception.NotExistException;
import event.model.EventService;
import event.model.EventVirtualDB;
import event.model.dto.CategoryDTO;
import event.model.dto.EventDTO;
import event.model.dto.LocationDTO;
import event.view.EventFailView;
import event.view.EventSuccessView;

public class EventController {
	private static EventController instance = new EventController();
	private EventService service = EventService.getInstance();
	
	public static EventController getInstance() {
		return instance;
	}
	
	public void insertDB () throws Exception {
		try {
			service.addEvent(EventVirtualDB.getitems());
			EventSuccessView.messageView("행사 정보 insert 완료");
		}catch(SQLException s) {
			s.printStackTrace();
			EventFailView.failMessageView("행사 정보 insert 오류");
		}
	}
	
	//모든 event 검색
	public void EventListView() {
		try{
			ArrayList<EventDTO> allEvent = service.getAllEvents();
			EventSuccessView.messageView("====================== 모든 Event 검색 성공 ======================");
			EventSuccessView.eventListView(allEvent);
		}catch(SQLException s){
			s.printStackTrace();
			EventFailView.failMessageView("모든 Event 검색시 에러 발생");
		}
	}
	
	//새로운 Event 저장		
	public void insertEvent(EventDTO newEvent) throws Exception {
		try{
	         service.addnewEvent(newEvent);
	         EventSuccessView.messageView("====================== 새로운 Event 저장 성공 ======================");
	      }catch(SQLException s){
	         s.printStackTrace();
	         EventFailView.failMessageView("새로운 Event 저장시 에러 발생");
	      }		
	}
	
	//특정 Event 검색
	public void EventView(String title) {
		try{
			EventDTO event = service.getEvent(title);
			EventSuccessView.messageView("====================== 특정 Event 출력 성공 ======================");
			EventSuccessView.eventView(event);
	      }catch(SQLException | NotExistException s){
	    	  s.printStackTrace();
	    	  EventFailView.failMessageView("존재하는 Event가 없습니다.");
		}		
	}
	
	//location 별 Event 검색
	public void getLocationEvent(String location) {
		try{
			ArrayList<EventDTO> event = service.getLocationEvent(location);
			EventSuccessView.messageView("====================== Location Event 출력 성공 ======================");
			EventSuccessView.eventListView(event);
	      }catch(SQLException | NotExistException s){
	    	  s.printStackTrace();
	    	  EventFailView.failMessageView("존재하는 Event가 없습니다.");
		}		
	}
	
	//category 별 Event 검색
	public void getCategoryEvent(String category) {
		try{
			ArrayList<EventDTO> event = service.getCategoryEvent(category);
			EventSuccessView.messageView("====================== Category Event 출력 성공 ======================");
			EventSuccessView.eventListView(event);
	      }catch(SQLException | NotExistException s){
	    	  s.printStackTrace();
	    	  EventFailView.failMessageView("존재하는 Event가 없습니다.");
		}		
	}
	
	//존재하는 Event 수정
	public void updateEvent(String tel, String title) {
		try {
			service.updateEvent(tel, title);
			EventSuccessView.messageView("====================== 존재하는 Event 수정 성공 ======================");
		} catch (NotExistException | SQLException e) {
			e.printStackTrace();
			EventFailView.failMessageView("존재하는 Event가 없습니다.");
		}
	}
	
	//모든 Event 삭제
	public void deleteEvent(String title) throws NotExistException, SQLException {
		try {
			service.deleteEvent(title);
			EventSuccessView.messageView("====================== 존재하는 Event 삭제 성공 ======================");
		} catch (NotExistException e) {
			EventFailView.failMessageView("존재하는 Event가 없습니다.");
		}	
	}
	
	//모든 location 검색
	public void locationListView() {
		try{
			ArrayList<LocationDTO> allEvent = service.getAllLocations();
			EventSuccessView.messageView("====================== 모든 location 검색 성공 ======================");
			EventSuccessView.locationListView(allEvent);
		}catch(SQLException s){
			s.printStackTrace();
			EventFailView.failMessageView("모든 location 검색시 에러 발생");
		}
	}
	
	//모든 category 검색
	public void categoryListView() {
		try{
			ArrayList<CategoryDTO> allEvent = service.getAllCategorys();
			EventSuccessView.messageView("====================== 모든 category 검색 성공 ======================");
			EventSuccessView.categoryListView(allEvent);
		}catch(SQLException s){
			s.printStackTrace();
			EventFailView.failMessageView("모든 category 검색시 에러 발생");
		}
	}
}