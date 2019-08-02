package event.view;

import java.util.ArrayList;

import event.model.dto.CategoryDTO;
import event.model.dto.EventDTO;
import event.model.dto.LocationDTO;
import net.sf.json.JSONArray;

public class EventSuccessView {
	//모든 Event 출력
	public static void eventListView(ArrayList<EventDTO> allEvent){
		
		for(int i = 0; i < allEvent.size(); i++){		
			JSONArray jsonArray = JSONArray.fromObject(allEvent.get(i));  
			System.out.println((i+1) + " " + jsonArray +" ");
		}
	}
	
	//특정 Event 출력 
	public static void eventView(EventDTO event){
		JSONArray jsonArray = JSONArray.fromObject(event);  
		System.out.println(jsonArray);
	}
		
	//예외가 아닌 단순 메세지 출력
	public static void messageView(String message) {
		System.out.println(message);
	}
	
	//모든 location 출력
	public static void locationListView(ArrayList<LocationDTO> allLocation){
		
		for(int i = 0; i < allLocation.size(); i++){		
			JSONArray jsonArray = JSONArray.fromObject(allLocation.get(i));  
			System.out.println("*"+ jsonArray +" ");
		}
	}
	
	//모든 category 출력
		public static void categoryListView(ArrayList<CategoryDTO> allCategory){
			
			for(int i = 0; i < allCategory.size(); i++){		
				JSONArray jsonArray = JSONArray.fromObject(allCategory.get(i));  
				System.out.println("*"+ jsonArray +" ");
			}
		}
}