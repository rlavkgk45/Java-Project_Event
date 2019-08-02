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
			EventSuccessView.messageView("��� ���� insert �Ϸ�");
		}catch(SQLException s) {
			s.printStackTrace();
			EventFailView.failMessageView("��� ���� insert ����");
		}
	}
	
	//��� event �˻�
	public void EventListView() {
		try{
			ArrayList<EventDTO> allEvent = service.getAllEvents();
			EventSuccessView.messageView("====================== ��� Event �˻� ���� ======================");
			EventSuccessView.eventListView(allEvent);
		}catch(SQLException s){
			s.printStackTrace();
			EventFailView.failMessageView("��� Event �˻��� ���� �߻�");
		}
	}
	
	//���ο� Event ����		
	public void insertEvent(EventDTO newEvent) throws Exception {
		try{
	         service.addnewEvent(newEvent);
	         EventSuccessView.messageView("====================== ���ο� Event ���� ���� ======================");
	      }catch(SQLException s){
	         s.printStackTrace();
	         EventFailView.failMessageView("���ο� Event ����� ���� �߻�");
	      }		
	}
	
	//Ư�� Event �˻�
	public void EventView(String title) {
		try{
			EventDTO event = service.getEvent(title);
			EventSuccessView.messageView("====================== Ư�� Event ��� ���� ======================");
			EventSuccessView.eventView(event);
	      }catch(SQLException | NotExistException s){
	    	  s.printStackTrace();
	    	  EventFailView.failMessageView("�����ϴ� Event�� �����ϴ�.");
		}		
	}
	
	//location �� Event �˻�
	public void getLocationEvent(String location) {
		try{
			ArrayList<EventDTO> event = service.getLocationEvent(location);
			EventSuccessView.messageView("====================== Location Event ��� ���� ======================");
			EventSuccessView.eventListView(event);
	      }catch(SQLException | NotExistException s){
	    	  s.printStackTrace();
	    	  EventFailView.failMessageView("�����ϴ� Event�� �����ϴ�.");
		}		
	}
	
	//category �� Event �˻�
	public void getCategoryEvent(String category) {
		try{
			ArrayList<EventDTO> event = service.getCategoryEvent(category);
			EventSuccessView.messageView("====================== Category Event ��� ���� ======================");
			EventSuccessView.eventListView(event);
	      }catch(SQLException | NotExistException s){
	    	  s.printStackTrace();
	    	  EventFailView.failMessageView("�����ϴ� Event�� �����ϴ�.");
		}		
	}
	
	//�����ϴ� Event ����
	public void updateEvent(String tel, String title) {
		try {
			service.updateEvent(tel, title);
			EventSuccessView.messageView("====================== �����ϴ� Event ���� ���� ======================");
		} catch (NotExistException | SQLException e) {
			e.printStackTrace();
			EventFailView.failMessageView("�����ϴ� Event�� �����ϴ�.");
		}
	}
	
	//��� Event ����
	public void deleteEvent(String title) throws NotExistException, SQLException {
		try {
			service.deleteEvent(title);
			EventSuccessView.messageView("====================== �����ϴ� Event ���� ���� ======================");
		} catch (NotExistException e) {
			EventFailView.failMessageView("�����ϴ� Event�� �����ϴ�.");
		}	
	}
	
	//��� location �˻�
	public void locationListView() {
		try{
			ArrayList<LocationDTO> allEvent = service.getAllLocations();
			EventSuccessView.messageView("====================== ��� location �˻� ���� ======================");
			EventSuccessView.locationListView(allEvent);
		}catch(SQLException s){
			s.printStackTrace();
			EventFailView.failMessageView("��� location �˻��� ���� �߻�");
		}
	}
	
	//��� category �˻�
	public void categoryListView() {
		try{
			ArrayList<CategoryDTO> allEvent = service.getAllCategorys();
			EventSuccessView.messageView("====================== ��� category �˻� ���� ======================");
			EventSuccessView.categoryListView(allEvent);
		}catch(SQLException s){
			s.printStackTrace();
			EventFailView.failMessageView("��� category �˻��� ���� �߻�");
		}
	}
}