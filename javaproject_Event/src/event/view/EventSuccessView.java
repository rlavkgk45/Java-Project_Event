package event.view;

import java.util.ArrayList;

import event.model.dto.CategoryDTO;
import event.model.dto.EventDTO;
import event.model.dto.LocationDTO;
import net.sf.json.JSONArray;

public class EventSuccessView {
	//��� Event ���
	public static void eventListView(ArrayList<EventDTO> allEvent){
		
		for(int i = 0; i < allEvent.size(); i++){		
			JSONArray jsonArray = JSONArray.fromObject(allEvent.get(i));  
			System.out.println((i+1) + " " + jsonArray +" ");
		}
	}
	
	//Ư�� Event ��� 
	public static void eventView(EventDTO event){
		JSONArray jsonArray = JSONArray.fromObject(event);  
		System.out.println(jsonArray);
	}
		
	//���ܰ� �ƴ� �ܼ� �޼��� ���
	public static void messageView(String message) {
		System.out.println(message);
	}
	
	//��� location ���
	public static void locationListView(ArrayList<LocationDTO> allLocation){
		
		for(int i = 0; i < allLocation.size(); i++){		
			JSONArray jsonArray = JSONArray.fromObject(allLocation.get(i));  
			System.out.println("*"+ jsonArray +" ");
		}
	}
	
	//��� category ���
		public static void categoryListView(ArrayList<CategoryDTO> allCategory){
			
			for(int i = 0; i < allCategory.size(); i++){		
				JSONArray jsonArray = JSONArray.fromObject(allCategory.get(i));  
				System.out.println("*"+ jsonArray +" ");
			}
		}
}