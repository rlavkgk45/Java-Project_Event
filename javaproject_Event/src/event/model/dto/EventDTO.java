package event.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
	private String title;
	private String eventStartDate;
	private String eventEndDate;
	private String address;
	private String tel;
	private String readCount;
	private String catNumber;
	private String areaCode;
}