package reservation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberBean;
import reservation.model.TscheduleBean;
import reservation.model.TscheduleDao;

@Controller
public class TscheduleController {
	private final String command = "/tschedule.rv";
	private final String getPage = "tschedule";
	private final String gotoPage = "redirect:/trainerCalendar.rv";

	@Autowired
	TscheduleDao tscheduleDao;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction(HttpSession session,Model model,
			@RequestParam("flag") boolean flag) {
		model.addAttribute("flag",flag);
		System.out.println("스케줄 설정 페이지 직전:"+flag);
		return getPage;
	}
	
	@RequestMapping(value=command,method = RequestMethod.POST)
	public String doAction(@Valid TscheduleBean tscheduleBean, BindingResult result,HttpServletRequest request, Model model,
			HttpSession session) {
		System.out.println("오나 확인 test");
		System.out.println("오나 확인 오류시/tsdate:"+tscheduleBean.getTsdate());
		
		if(result.hasErrors()) {
			System.out.println("오나 확인 오류시");
			return getPage;
		}else {
			System.out.println("오나 확인 오류 없을때");
			String tid = ((MemberBean)session.getAttribute("loginInfo")).getId();
			tscheduleBean.setTid(tid);
			System.out.println("tsdate:"+tscheduleBean.getTsdate());
			
			int cnt = tscheduleDao.insertTschedule(tscheduleBean);
			if(cnt != -1) {
				return gotoPage;
			}else {
				return getPage;
			}
		}
	}
}