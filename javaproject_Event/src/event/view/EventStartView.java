package event.view;

import event.model.dto.EventDTO;
import event.service.EventController;

public class EventStartView {
	
	public static void main(String[] args) throws Exception {
		
		EventController controller = EventController.getInstance();
		
		EventDTO newEvent = new EventDTO("새로생성된 이벤트", "20200802", "20200805", "충북 제천시 장락동", "010-5172-9638", "100", "A02081100", "33");
		
		//System.out.println("행사 정보 insert");
		//controller.insertDB();
		
		//모든 행사 검색
		//System.out.println("***** 모든 Event 검색 *****");
		//controller.EventListView();
		
		//새로운 Event 저장		
		//System.out.println("***** 새로운 Event 저장 후  모든 Event 검색 *****");
		//controller.insertEvent(newEvent);
		//controller.EventListView();
		
		
		//존재하는 Event 검색
		//System.out.println("***** 존재하는 Event 검색 *****");
		//controller.EventView("새로생성된 이벤트");
		
		
		//존재하지 않는 Event 검색
		//System.out.println("***** 미존재하는 Event 검색 - 예외처리 확인용 *****");
		//controller.EventView("새로만들어 지지 않은 이벤트");
		
		
		//존재하는 Event 업데이트
		//System.out.println("***** 존재하는 Event 수정 후 수정한 Event 검색 *****");
		//controller.updateEvent("01055555555", "새로생성된 이벤트");
		//controller.EventView("새로생성된 이벤트");
		
		
		//존재하지 않는 Event 업데이트 : 예외 발생
		//System.out.println("***** 미존재하는 Event 수정 - 예외처리 확인용 *****");
		//controller.updateEvent("01055555555", "존재하지 않는 이벤트");
		
		//모든 location 출력
		//System.out.println("**** 모든 location 검색  ****");
		//controller.locationListView();
		
		//System.out.println("**** 지역별 Event 검색  ****");
		//controller.getLocationEvent("충청북도");
		
		//모든 category 출력
		//System.out.println("**** 모든 category 검색  ****");
		//controller.categoryListView();
		
		//System.out.println("**** 카테고리별 Event 검색  ****");
		//controller.getCategoryEvent("일반축제");
	}
}
