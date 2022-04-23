package ptithcm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ptithcm.entity.Bill;
import ptithcm.entity.DetailBill;
import ptithcm.entity.Phone;
import ptithcm.entity.Staff;
import ptithcm.pdf.BillConfirmPDFView;
import ptithcm.pdf.BillDetailPDFView;
import ptithcm.pdf.BillUnconfirmPDFView;
import ptithcm.pdf.PhonePDFView;
import ptithcm.pdf.StaffPDFView;

@Controller
@Transactional
@RequestMapping("pdf/")
public class PDFController {
	@Autowired SessionFactory factory;

	@RequestMapping("staff")
	public ModelAndView staffListReport(HttpServletRequest req) {


		List<Staff> staffs= Staff.getStaffs(factory);


		return new ModelAndView(new StaffPDFView(), "staffs", staffs);
	}
	
	@RequestMapping("phone")
	public ModelAndView phoneListReport(HttpServletRequest req) {


		List<Phone> phones= Phone.getPhones(factory);


		return new ModelAndView(new PhonePDFView(), "phones", phones);
	}
	
	@RequestMapping("billUnconfirm")
	public ModelAndView billUnconfirmListReport(HttpServletRequest req) {


		List<Bill> bills= Bill.getBills(factory, 1);


		return new ModelAndView(new BillUnconfirmPDFView(), "bills", bills);
	}
	
	@RequestMapping("billConfirm")
	public ModelAndView billConfirmListReport(HttpServletRequest req) {


		List<Bill> bills= Bill.getBills(factory, 2);


		return new ModelAndView(new BillConfirmPDFView(), "bills", bills);
	}
	
	@RequestMapping("detailBill/{id}")
	public ModelAndView detailBillListReport(HttpServletRequest req, @PathVariable("id") int id ) {


		List<DetailBill> detailBills= DetailBill.getDetailBills(factory, id);


		return new ModelAndView(new BillDetailPDFView(), "detailBills", detailBills);
	}

}
