package ptithcm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.entity.Bill;
import ptithcm.entity.Brand;
import ptithcm.entity.CameraPhone;
import ptithcm.entity.Customer;
import ptithcm.entity.DetailBill;
import ptithcm.entity.DetailBillPK;
import ptithcm.entity.FeaturePhone;
import ptithcm.entity.FunctionalCamera;
import ptithcm.entity.Phone;
import ptithcm.entity.SpecialFeature;

@Controller
@Transactional
@RequestMapping("User/")
public class UserController {

	@Autowired
	SessionFactory factory;

	@RequestMapping("operatingRegulation")
	public String operatingRegulation() {
		return "User/operatingRegulation";
	}

	@RequestMapping("privacyPolicy")
	public String privacyPolicy() {
		return "User/privacyPolicy";
	}

	@RequestMapping("introductCompany")
	public String introductCompany() {
		return "User/introductCompany";
	}

	@RequestMapping("home")
	public String index(HttpServletRequest request, HttpSession session, ModelMap model) {
		session.setAttribute("brands", Brand.getBrands(factory));
		session.setAttribute("specialFeatures", SpecialFeature.getSpecialFeatures(factory));
		session.setAttribute("functionalCameras", FunctionalCamera.getFunctionalCameras(factory));
		showPhones(request, model, Phone.getPhones(factory));
		return "User/home";
	}

	@RequestMapping("home/{nameBrand}")
	public String fillBrand(HttpServletRequest request, ModelMap model, @PathVariable("nameBrand") String nameBrand) {
		showPhones(request, model, Phone.getPhoneBrand(factory, nameBrand));
		model.addAttribute("brandsss", nameBrand);
		return "User/home";
	}

	@RequestMapping(value = "home", params = "btnSearchByName", method = RequestMethod.POST)
	public String fillPhone(HttpServletRequest request, ModelMap model) {
		model.addAttribute("products", Phone.searchPhones(factory, request.getParameter("namePhone")));
		model.addAttribute("searchAll", "1");
		return "User/home";
	}

	@RequestMapping(value = "home", params = "btnSearch", method = RequestMethod.POST)
	public String fillAll(HttpServletRequest request, HttpSession session, ModelMap model) {
		String[] nameBrands = request.getParameterValues("nameBrand");
		String[] prices = request.getParameterValues("price");
		String[] idSpecialFeatures = request.getParameterValues("idSpecialFeature");
		String[] batterys = request.getParameterValues("battery");
		String[] screens = request.getParameterValues("screen");
		String[] idFunctionalCameras = request.getParameterValues("idFunctionalCamera");
		List<String> temp1 = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();
		for (Phone k : Phone.getPhones(factory)) {
			temp.add(k.getIdPhone());
		}
		if (!nameBrands[0].equals("all")) {
			temp.clear();
			for (String k : searchByBrand(nameBrands)) {
				temp.add(k);
			}
		}
		if (!prices[0].equals("all")) {
			temp1 = new ArrayList<String>(temp);
			temp.clear();
			for (String k : searchByPrice(prices)) {
				if (temp1.contains(k)) {
					temp.add(k);
				}
			}
		}
		if (!screens[0].equals("all")) {
			temp1 = new ArrayList<String>(temp);
			temp.clear();
			for (String k : searchByScreen(screens)) {
				if (temp1.contains(k)) {
					temp.add(k);
				}
			}
		}
		if (!idSpecialFeatures[0].equals("all")) {
			temp1 = new ArrayList<String>(temp);
			temp.clear();
			for (String k : searchByFeature(idSpecialFeatures)) {
				if (temp1.contains(k)) {
					temp.add(k);
				}
			}
		}
		if (!idFunctionalCameras[0].equals("all")) {
			temp1 = new ArrayList<String>(temp);
			temp.clear();
			for (String k : searchByCamera(idFunctionalCameras)) {
				if (temp1.contains(k)) {
					temp.add(k);
				}
			}
		}
		if (!batterys[0].equals("all")) {
			temp1 = new ArrayList<String>(temp);
			temp.clear();
			for (String k : searchByBattery(batterys)) {
				if (temp1.contains(k)) {
					temp.add(k);
				}
			}
		}

		List<Phone> list = new ArrayList<Phone>();
		for (String k : new ArrayList<String>(temp)) {
			list.add(Phone.getPhone(factory, k));
		}
		model.addAttribute("products", list);
		model.addAttribute("searchAll", "1");
		return "User/home";
	}

	public List<String> searchByBrand(String[] nameBrands) {
		List<String> list = new ArrayList<String>();
		for (String k : nameBrands) {
			for (String p : Phone.getPhoneBrands(factory, k)) {
				list.add(p);
			}
		}
		Set<String> temp = new HashSet<>(list);
		return new ArrayList<String>(temp);
	}

	public List<String> searchByPrice(String[] prices) {
		List<String> list = new ArrayList<String>();
		for (String k : prices) {
			for (String p : Phone.getPhonePrices(factory, k)) {
				list.add(p);
			}
		}
		Set<String> temp = new HashSet<>(list);
		return new ArrayList<String>(temp);
	}

	public List<String> searchByBattery(String[] batterys) {
		List<String> list = new ArrayList<String>();
		for (String k : batterys) {
			for (String p : Phone.getPhoneBatterys(factory, k)) {
				list.add(p);
			}
		}
		Set<String> temp = new HashSet<>(list);
		return new ArrayList<String>(temp);
	}

	public List<String> searchByScreen(String[] screens) {
		List<String> list = new ArrayList<String>();
		for (String k : screens) {
			for (String p : Phone.getPhoneScreens(factory, k)) {
				list.add(p);
			}
		}
		Set<String> temp = new HashSet<>(list);
		return new ArrayList<String>(temp);
	}

	public List<String> searchByCamera(String[] idFunctionalCameras) {
		List<String> list = new ArrayList<String>();
		for (String k : idFunctionalCameras) {
			for (String p : CameraPhone.getPhoneCameras(factory, Integer.parseInt(k))) {
				list.add(p);
			}
		}
		Set<String> temp = new HashSet<>(list);
		return new ArrayList<String>(temp);
	}

	public List<String> searchByFeature(String[] idSpecialFeatures) {
		List<String> list = new ArrayList<String>();
		for (String k : idSpecialFeatures) {
			for (String p : FeaturePhone.getPhoneFeatures(factory, Integer.parseInt(k))) {
				list.add(p);
			}
		}
		Set<String> temp = new HashSet<>(list);
		return new ArrayList<String>(temp);
	}

	public void showPhones(HttpServletRequest request, ModelMap model, List<Phone> phones) {
		PagedListHolder pagedListHolder = new PagedListHolder(phones);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(9);
		model.addAttribute("pagedListHolder", pagedListHolder);
	}

	@RequestMapping("cart")
	public String cart(HttpServletRequest request, ModelMap model, HttpSession session) {
		showDetailBills(request, model, session);
		return "User/cart";
	}

	@RequestMapping(value = "cart/idBill={idBill}+idPhone={idPhone}.htm", params = "linkDelete")
	public String deleteCart(HttpServletRequest request, ModelMap model, HttpSession session,
			@PathVariable("idPhone") String idPhone, @PathVariable("idBill") int idBill) {
		DetailBill.deleteDetailBill(factory, DetailBill.getDetailBill(factory, idBill, idPhone));
		session.setAttribute("detailBills", DetailBill.getDetailBills(factory,
				Bill.getBillUnBuy(factory, session.getAttribute("idCustomer").toString()).getIdBill()));
		return "redirect:/User/cart.htm";
	}

	@RequestMapping("cart/buy")
	public String buyCart(HttpServletRequest request, ModelMap model, HttpSession session) {
		String idCustomer = session.getAttribute("idCustomer").toString();
		Bill bill = Bill.getBillUnBuy(factory, idCustomer);
		Long sum = 0L;
		List<DetailBill> detailBills=DetailBill.getDetailBills(factory, bill.getIdBill());
		if(detailBills.isEmpty()) {
			return "redirect:/User/cart.htm";
		}
		for (DetailBill d : detailBills) {
			d.setCostDetailBill(
					d.getPk().getPhone().getCostPhone() * (1 - d.getPk().getPhone().getDiscountPhone() / 100));
			sum += d.getCostDetailBill() * d.getAmount();
			DetailBill.updateDetailBill(factory, d);
		}
		bill.setCostBill(sum);
		bill.setStatusBill(1);
		bill.setDateBill(new Date());
		Bill.updateBill(factory, bill);
		Bill.insertBill(factory, Customer.getCustomer(factory, idCustomer));
		session.setAttribute("detailBills",
				DetailBill.getDetailBills(factory, Bill.getBillUnBuy(factory, idCustomer).getIdBill()));
		return "User/success";
	}
	
	public void showDetailBills(HttpServletRequest request, ModelMap model, HttpSession session) {
		List<DetailBill> list = (List<DetailBill>) session.getAttribute("detailBills");
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(5);
		Long sum = 0L;
		for (DetailBill k : list) {
			sum = sum + k.getPk().getPhone().getCostPhone() * (1 - k.getPk().getPhone().getDiscountPhone() / 100)
					* k.getAmount();
		}
		model.addAttribute("sum", sum);
		model.addAttribute("pagedListHolder", pagedListHolder);

	}
	
	@RequestMapping("history")
	public String history(HttpServletRequest request, ModelMap model, HttpSession session) {
		showBills(request, model, session);
		return "User/history";
	}
	
	@RequestMapping(value = "history/idBill={idBill}.htm", params = "linkDetail")
	public String historyBill(HttpServletRequest request, ModelMap model, @PathVariable("idBill") int idBill) {
		showDetailBills(request, model, idBill);
		model.addAttribute("idBill", idBill);
		return "User/historyDetail";
	}
	
	public void showDetailBills(HttpServletRequest request, ModelMap model, int idBill) {
		List<DetailBill> list = DetailBill.getDetailBills(factory, idBill);
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);

	}	
	
	public void showBills(HttpServletRequest request, ModelMap model, HttpSession session) {
		List<Bill> list = Bill.getBills(factory, session.getAttribute("idCustomer").toString());
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);

	}	
	
	@RequestMapping("info")
	public String info(HttpSession session, ModelMap model) {
		model.addAttribute("customer", Customer.getCustomer(factory, (String) session.getAttribute("idCustomer")));
		return "User/info";
	}

	@RequestMapping(value = "info", params = "btnUpdate", method = RequestMethod.POST)
	public String editCustomer(HttpServletRequest request, ModelMap model,
			@ModelAttribute("customer") Customer customer, BindingResult errors) {
		if (validateCustomer(customer, errors)) {
			Integer temp = Customer.updateCustomer(factory, customer);
			if (temp != 0) {
				model.addAttribute("message", "Sửa thành công");
			} else {
				model.addAttribute("message", "Sửa thất bại" + customer);
			}
		}
		return "User/info";
	}
	
	@RequestMapping(value = "changePass")
	public String editCustomerPass() {
		return "User/changePass";
	}

	@RequestMapping(value = "changePass", params = "btnUpdatePass", method = RequestMethod.POST)
	public String editCustomerPass(HttpServletRequest request, ModelMap model, HttpSession session) {
		String newPass = request.getParameter("newPass");
		String oldPass = request.getParameter("oldPass");
		String newPassReset = request.getParameter("newPassReset");		
		String idCustomer = session.getAttribute("idCustomer").toString();
		Boolean flag=true;
		if(Customer.checkCustomerPass(factory, oldPass, idCustomer)==0) {
			model.addAttribute("oldPassEr", "Mật khẩu cũ không chính xác");
			flag=false;
		}
		if(newPass.equals("")) {
			model.addAttribute("newPassEr", "Vui lòng nhập mật khẩu mới");
			flag=false;
		}
		if(!newPass.equals(newPassReset)) {
			model.addAttribute("newPassResetEr", "Mật khẩu nhập lại không khớp");
			flag=false;
		}
		if(!flag) {
			model.addAttribute("oldPass", oldPass);
			model.addAttribute("newPass", newPass);
			model.addAttribute("newPassReset", newPassReset);
			return "User/changePass";
		}
		Integer temp = Customer.updateCustomerPass(factory, newPass, idCustomer);
		if (temp == 0) {
			model.addAttribute("message", "Thay đổi mật khẩu thất bại");
		} 
		model.addAttribute("customer", Customer.getCustomer(factory, (String) session.getAttribute("idCustomer")));
		return "User/info";
	}

	@RequestMapping("register")
	public String register(ModelMap model) {
		model.addAttribute("customer", new Customer());
		return "User/register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String addCustomer(HttpServletRequest request, ModelMap model, @ModelAttribute("customer") Customer customer,
			HttpSession session, BindingResult errors) {
		if (validateCustomer(customer, errors)) {
			Integer temp = Customer.insertCustomer(factory, customer);
			if (temp != 0) {
				session.setAttribute("idCustomer", customer.getIdCustomer());
				Bill.insertBill(factory, customer);
				return "redirect:/User/home.htm";
			} else {
				model.addAttribute("message", "Thêm thất bại" + customer);
			}
		}
		return "User/register";
	}

	public Boolean validateCustomer(@ModelAttribute("customer") Customer customer, BindingResult errors) {
		String checkname = "([\\p{L}\\s]+){1,50}";
		String checkphone = "[0-9]{10}";
		String checkemail = "^[A-Za-z0-9+_.-]+@(.+)$";
		String checkaddress = "([\\p{L}\\s\\d\\,]+){1,100}";
		String checkid = "[A-Za-z0-9]{1,10}";
		String checkpass = "[A-Za-z0-9]{1,16}";
		if (customer.getNameCustomer().trim().matches(checkname) == false) {
			errors.rejectValue("nameCustomer", "customer",
					"Họ tên không được để trống, chứa ký tự đặc biệt hoặc quá 50 ký tự!");
		}
		if (customer.getPhoneCustomer().trim().matches(checkphone) == false) {
			errors.rejectValue("phoneCustomer", "customer", "số điện thoại không đúng!");
		}
		if (customer.getEmailCustomer().trim().matches(checkemail) == false) {
			errors.rejectValue("emailCustomer", "customer", "email không đúng định dạng!");
		}
		if (customer.getAddressCustomer().trim().matches(checkaddress) == false) {
			errors.rejectValue("addressCustomer", "customer",
					"Địa chỉ không được để trống, chứa ký tự đặc biệt hoặc quá 100 ký tự!");
		}
		if (customer.getIdCustomer().trim().matches(checkid) == false) {
			errors.rejectValue("idCustomer", "customer",
					"Tên đăng nhập không được để trống, chứa ký tự đặc biệt hoặc quá 10 ký tự!");
		}
		if (customer.getPasswordCustomer().trim().matches(checkpass) == false) {
			errors.rejectValue("passwordCustomer", "customer",
					"Mật khẩu không được để trống, chứa kí tự đặc biệt hoặc quá 16 ký tự!");
		}
		if (errors.hasErrors()) {
			return false;
		}
		return true;
	}

	@RequestMapping("login")
	public String login() {
		return "User/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, ModelMap model, HttpSession session) {
		String idCustomer = request.getParameter("name");
		String passCustomer = request.getParameter("pass");
		if (Customer.checkCustomerPass(factory, passCustomer, idCustomer) == 1) {
			if (Customer.getCustomer(factory, idCustomer).getStatusCustomer() == 0) {
				model.addAttribute("message", "Tài khoản của bạn đã bị khóa, vui lòng liên hệ để được mở khóa!!");
			} else {
				session.setAttribute("idCustomer", idCustomer);
				session.setAttribute("detailBills",
						DetailBill.getDetailBills(factory, Bill.getBillUnBuy(factory, idCustomer).getIdBill()));
				return "redirect:/User/home.htm";
			}
		} else {
			model.addAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng");
		}
		return "User/login";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("idCustomer");
		return "redirect:/User/home.htm";
	}

	@RequestMapping("phone/{id}")
	public String phone(ModelMap model, @PathVariable("id") String id) {
		model.addAttribute("p", Phone.getPhone(factory, id));
		model.addAttribute("cameraPhones", CameraPhone.getCameraPhones(factory, id));
		model.addAttribute("featurePhones", FeaturePhone.getFeaturePhones(factory, id));
		model.addAttribute("detailBill", new DetailBill());
		return "User/phone";
	}

	@RequestMapping(value = "phone/{id}", params = "linkAdd")
	public String addPhone(ModelMap model, @PathVariable("id") String id, HttpSession session) {
		if (session.getAttribute("idCustomer") == null) {
			return "redirect:/User/login.htm";
		}
		Bill b = Bill.getBillUnBuy(factory, session.getAttribute("idCustomer").toString());
		DetailBill db = DetailBill.getDetailBill(factory, b.getIdBill(), id);
		if (db == null) {
			DetailBill detailBill = new DetailBill();
			Phone p = Phone.getPhone(factory, id);
			detailBill.setColorDetailBill(p.getColorPhone().split("_")[0]);
			detailBill.setCostDetailBill(0L);
			detailBill.setAmount(1);

			detailBill.setPk(new DetailBillPK(b, p));
			Integer temp = DetailBill.insertDetailBill(factory, detailBill);
		} else {
			db.setAmount(db.getAmount() + 1);
			DetailBill.updateDetailBill(factory, db);
		}

		session.setAttribute("detailBills", DetailBill.getDetailBills(factory, b.getIdBill()));
		return "redirect:/User/home.htm";
	}

	@RequestMapping(value = "phone", params = "btnBuy")
	public String addDetailBill(HttpServletRequest request, ModelMap model, HttpSession session,
			@ModelAttribute("detailBill") DetailBill detailBill, BindingResult errors) {
		if (session.getAttribute("idCustomer") == null) {
			return "redirect:/User/login.htm";
		}

		if (detailBill.getAmount() > 10 || detailBill.getAmount() < 1) {
			errors.rejectValue("amount", "detailBill", "số lượng phải từ 1-10!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("message", "vui lòng sửa các lỗi");
			model.addAttribute("p", Phone.getPhone(factory, detailBill.getPk().getPhone().getIdPhone()));
			model.addAttribute("cameraPhones",
					CameraPhone.getCameraPhones(factory, detailBill.getPk().getPhone().getIdPhone()));
			model.addAttribute("featurePhones",
					FeaturePhone.getFeaturePhones(factory, detailBill.getPk().getPhone().getIdPhone()));
			return "User/phone";
		}
		Bill b = Bill.getBillUnBuy(factory, session.getAttribute("idCustomer").toString());
		detailBill.setColorDetailBill(request.getParameter("color").toString());
		detailBill.setCostDetailBill(0L);
		detailBill.getPk().setBill(b);
		Integer temp = DetailBill.insertDetailBill(factory, detailBill);
		if (temp == 0) {
			model.addAttribute("message", "Thêm vào giỏ hàng lỗi, sản phẩm đã được thêm trước đó rồi");
			model.addAttribute("p", Phone.getPhone(factory, detailBill.getPk().getPhone().getIdPhone()));
			model.addAttribute("cameraPhones",
					CameraPhone.getCameraPhones(factory, detailBill.getPk().getPhone().getIdPhone()));
			model.addAttribute("featurePhones",
					FeaturePhone.getFeaturePhones(factory, detailBill.getPk().getPhone().getIdPhone()));
			return "User/phone";
		}
		session.setAttribute("detailBills", DetailBill.getDetailBills(factory, b.getIdBill()));
		return "redirect:/User/cart.htm";
	}

}
