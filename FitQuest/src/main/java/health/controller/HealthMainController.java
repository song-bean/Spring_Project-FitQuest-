package health.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HealthMainController {
	private final String command = "health.ht";
	// �Ϲ�ȸ��
	private final String getPage = "myHealthMain";
	// Ʈ���̳�
	private final String getPageT = "trainerHealthMain";
	
	// �� � ���� �������� �̵�
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction() {
		
		return getPage;
	}
}