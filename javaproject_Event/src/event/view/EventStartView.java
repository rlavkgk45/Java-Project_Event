package event.view;

import event.model.dto.EventDTO;
import event.service.EventController;

public class EventStartView {
	
	public static void main(String[] args) throws Exception {
		
		EventController controller = EventController.getInstance();
		
		EventDTO newEvent = new EventDTO("���λ����� �̺�Ʈ", "20200802", "20200805", "��� ��õ�� �����", "010-5172-9638", "100", "A02081100", "33");
		
		//System.out.println("��� ���� insert");
		//controller.insertDB();
		
		//��� ��� �˻�
		//System.out.println("***** ��� Event �˻� *****");
		//controller.EventListView();
		
		//���ο� Event ����		
		//System.out.println("***** ���ο� Event ���� ��  ��� Event �˻� *****");
		//controller.insertEvent(newEvent);
		//controller.EventListView();
		
		
		//�����ϴ� Event �˻�
		//System.out.println("***** �����ϴ� Event �˻� *****");
		//controller.EventView("���λ����� �̺�Ʈ");
		
		
		//�������� �ʴ� Event �˻�
		//System.out.println("***** �������ϴ� Event �˻� - ����ó�� Ȯ�ο� *****");
		//controller.EventView("���θ���� ���� ���� �̺�Ʈ");
		
		
		//�����ϴ� Event ������Ʈ
		//System.out.println("***** �����ϴ� Event ���� �� ������ Event �˻� *****");
		//controller.updateEvent("01055555555", "���λ����� �̺�Ʈ");
		//controller.EventView("���λ����� �̺�Ʈ");
		
		
		//�������� �ʴ� Event ������Ʈ : ���� �߻�
		//System.out.println("***** �������ϴ� Event ���� - ����ó�� Ȯ�ο� *****");
		//controller.updateEvent("01055555555", "�������� �ʴ� �̺�Ʈ");
		
		//��� location ���
		//System.out.println("**** ��� location �˻�  ****");
		//controller.locationListView();
		
		//System.out.println("**** ������ Event �˻�  ****");
		//controller.getLocationEvent("��û�ϵ�");
		
		//��� category ���
		//System.out.println("**** ��� category �˻�  ****");
		//controller.categoryListView();
		
		//System.out.println("**** ī�װ��� Event �˻�  ****");
		//controller.getCategoryEvent("�Ϲ�����");
	}
}
