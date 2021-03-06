package ptithcm.controller;

import java.io.Console;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ptithcm.entity.Bill;
import ptithcm.entity.Brand;
import ptithcm.entity.CPU;
import ptithcm.entity.CameraPhone;
import ptithcm.entity.CameraPhonePK;
import ptithcm.entity.Customer;
import ptithcm.entity.DetailBill;
import ptithcm.entity.FeaturePhone;
import ptithcm.entity.FeaturePhonePK;
import ptithcm.entity.FunctionalCamera;
import ptithcm.entity.Phone;
import ptithcm.entity.Resolution;
import ptithcm.entity.Screen;
import ptithcm.entity.SpecialFeature;
import ptithcm.entity.Staff;
import ptithcm.entity.TechScreen;
import ptithcm.model.BasePath;
import ptithcm.ss.FunctionCommon;

@Transactional
@Controller
@RequestMapping("Admin/")
public class AdminController {

	public String imageExtension = ".jpeg_.jpg_.tiff_.psd_.eps_.png";

	@Autowired
	BasePath basePath;

	@Autowired
	SessionFactory factory;

	@Autowired
	JavaMailSender mailer;

	@RequestMapping("login")
	public String login(HttpSession session) {
		session.removeAttribute("staff");
		return "Admin/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, ModelMap model, HttpSession session) {
		String idAdmin = request.getParameter("name");
		String passAdmin = request.getParameter("password");
		if (Staff.checkStaffPass(factory, passAdmin, idAdmin) == 1) {
			session.setAttribute("staff", Staff.getStaff(factory, idAdmin));
			return "redirect:/Admin/info.htm";
		} else {
			model.addAttribute("message", "????ng nh???p th???t b???i, vui l??ng ??i???n ????ng th??ng tin ????ng nh???p!");
		}
		return "Admin/login";
	}

	@RequestMapping("info")
	public String info(HttpSession session, ModelMap model) {
		return "Admin/info";
	}
	
	@RequestMapping(value = "changePass")
	public String editStaffPass() {
		return "Admin/changePass";
	}


	@RequestMapping(value = "changePass", params = "btnUpdatePass", method = RequestMethod.POST)
	public String editStaffPass(HttpServletRequest request, HttpSession session, ModelMap model) {
		String newPass = request.getParameter("newPass");
		String oldPass = request.getParameter("oldPass");
		String newPassReset = request.getParameter("newPassReset");		
		String idStaff = ((Staff) session.getAttribute("staff")).getIdStaff();
		Boolean flag=true;
		if(Staff.checkStaffPass(factory, oldPass, idStaff)==0) {
			model.addAttribute("oldPassEr", "M???t kh???u c?? kh??ng ch??nh x??c");
			flag=false;
		}
		if(newPass.equals("")) {
			model.addAttribute("newPassEr", "Vui l??ng nh???p m???t kh???u m???i");
			flag=false;
		}
		if(!newPass.equals(newPassReset)) {
			model.addAttribute("newPassResetEr", "M???t kh???u nh???p l???i kh??ng kh???p");
			flag=false;
		}
		if(!flag) {
			model.addAttribute("oldPass", oldPass);
			model.addAttribute("newPass", newPass);
			model.addAttribute("newPassReset", newPassReset);
			return "Admin/changePass";
		}
		Integer temp = Staff.updateStaffPass(factory, newPass, idStaff);
		if (temp == 0) {
			model.addAttribute("message", "Thay ?????i m???t kh???u th???t b???i");
		} 
		return "Admin/info";
	}
	

	@RequestMapping("staff")
	public String staff(HttpServletRequest request, ModelMap model) {

		showStaffs(request, model, Staff.getStaffs(factory));

		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("staff", new Staff());

		return "Admin/staff";
	}

	@RequestMapping(value = "staff", params = "btnSearch")
	public String searchStaff(HttpServletRequest request, ModelMap model) {
		showStaffs(request, model, Staff.searchStaffs(factory, request.getParameter("name").trim()));
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("staff", new Staff());

		return "Admin/staff";
	}

	@RequestMapping(value = "staff", params = "btnAdd", method = RequestMethod.POST)
	public String addStaff(HttpServletRequest request, ModelMap model, @ModelAttribute("staff") Staff staff,
			BindingResult errors) {
		if (validateStaff(request, staff, errors)) {
			Integer temp = Staff.insertStaff(factory, staff, request.getParameter("date"));
			if (temp != 0) {
				model.addAttribute("message", "Th??m th??nh c??ng");
				model.addAttribute("staff", new Staff());

			} else {
				model.addAttribute("message", "Th??m th???t b???i, vui l??ng ki???m tra l???i th??ng tin" + staff);
			}
		}
		model.addAttribute("btnStatus", "btnAdd");
		showStaffs(request, model, Staff.getStaffs(factory));

		return "Admin/staff";
	}

	@RequestMapping(value = "staff", params = "btnEdit", method = RequestMethod.POST)
	public String editStaff(HttpServletRequest request, ModelMap model, @ModelAttribute("staff") Staff staff,
			BindingResult errors) {
		if (!validateStaff(request, staff, errors)) {
			showStaffs(request, model, Staff.getStaffs(factory));
			return "Admin/staff";
		}
		Integer temp = Staff.updateStaff(factory, staff, request.getParameter("date"));
		if (temp != 0) {
			model.addAttribute("message", "S???a th??nh c??ng");
			model.addAttribute("staff", new Staff());
			model.addAttribute("btnStatus", "btnAdd");
		} else {
			model.addAttribute("message", "S???a th???t b???i" + staff);
			model.addAttribute("d", staff.getBirthdayStaff());
			model.addAttribute("btnStatus", "btnEdit");
		}
		showStaffs(request, model, Staff.getStaffs(factory));

		return "Admin/staff";
	}

	@RequestMapping(value = "staff/{id}.htm", params = "linkEdit")
	public String editStaff(HttpServletRequest request, ModelMap model, @PathVariable("id") String id) {
		showStaffs(request, model, Staff.getStaffs(factory));

		model.addAttribute("btnStatus", "btnEdit");
		Staff s = Staff.getStaff(factory, id);
		model.addAttribute("d", s.getBirthdayStaff());
		model.addAttribute("staff", s);

		return "Admin/staff";
	}

	@RequestMapping(value = "staff/{id}.htm", params = "linkDelete")
	public String deleteStaff(HttpServletRequest request, ModelMap model, @ModelAttribute("staff") Staff staff,
			@PathVariable("id") String id) {

		Integer temp = Staff.deleteStaff(factory, Staff.getStaff(factory, id));
		if (temp != 0) {
			model.addAttribute("message", "X??a th??nh c??ng");
		} else {
			model.addAttribute("message", "X??a th???t b???i");
		}
		return "redirect:/Admin/staff.htm";
	}

	@RequestMapping(value = "staff/{id}.htm", params = "linkReset")
	public String resetStaff(HttpServletRequest request, ModelMap model, @PathVariable("id") String id) {
		Integer temp = Staff.updateStaffPass(factory, "1111", id);
		if (temp != 0) {
			model.addAttribute("message", "Reset th??nh c??ng");

		} else {
			model.addAttribute("message", "Reset th???t b???i");
		}

		model.addAttribute("staff", new Staff());
		model.addAttribute("btnStatus", "btnAdd");
		showStaffs(request, model, Staff.getStaffs(factory));

		return "Admin/staff";
	}

	public void showStaffs(HttpServletRequest request, ModelMap model, List<Staff> staffs) {
		PagedListHolder pagedListHolder = new PagedListHolder(staffs);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
	}

	public Boolean validateStaff(HttpServletRequest request, Staff staff, BindingResult errors) {
		String checkname = "([\\p{L}\\s]+){1,50}";
		String checkphone = "[0-9]{10}";
		String checkemail = "^[A-Za-z0-9+_.-]+@(.+)$";
		String checkaddress = "([\\p{L}\\s\\d\\,]+){1,100}";

		if (staff.getNameStaff().trim().matches(checkname) == false) {
			errors.rejectValue("nameStaff", "staff",
					"H??? t??n kh??ng ???????c ????? tr???ng, ch???a k?? t??? ?????c bi???t ho???c qu?? 50 k?? t???!");
		}
		if (staff.getPhoneStaff().trim().matches(checkphone) == false) {
			errors.rejectValue("phoneStaff", "staff", "s??? ??i???n tho???i kh??ng ????ng!");
		}
		if (staff.getEmailStaff().trim().matches(checkemail) == false) {
			errors.rejectValue("emailStaff", "staff", "email kh??ng ????ng ?????nh d???ng!");
		}
		if (staff.getAddressStaff().trim().matches(checkaddress) == false) {
			errors.rejectValue("addressStaff", "staff",
					"?????a ch??? kh??ng ???????c ????? tr???ng, ch???a k?? t??? ?????c bi???t ho???c qu?? 100 k?? t???!");
		}
		if (request.getParameter("date") == "") {
			errors.rejectValue("birthdayStaff", "staff", "Vui l??ng ch???n ho???c nh???p ng??y sinh!");
		}
		if (errors.hasErrors()) {
			return false;
		}
		return true;
	}

	@RequestMapping("productList")
	public String productList(HttpServletRequest request, ModelMap model) {
		showPhones(request, model, Phone.getPhones(factory));
		return "Admin/Product/productList";
	}

	@RequestMapping(value = "productList", params = "btnSearch")
	public String SearchProductList(HttpServletRequest request, ModelMap model) {
		showPhones(request, model, Phone.searchPhones(factory, request.getParameter("name")));
		return "Admin/Product/productList";
	}

	@RequestMapping(value = "productList/{id}.htm", params = "linkDelete")
	public String deleteProduct(HttpServletRequest request, ModelMap model, @PathVariable("id") String id) {
		if (DetailBill.checkPhoneExistDetaiBill(factory, id) == 1) {
			model.addAttribute("message", "S???n ph???m n??y ???? t???n t???i trong ????n h??ng, kh??ng th??? x??a");

		} else {
			CameraPhone.deleteCameraPhone(factory, id);
			FeaturePhone.deleteFeaturePhone(factory, id);
			if (Phone.deletePhone(factory, Phone.getPhone(factory, id)) == 1) {
				model.addAttribute("message", "X??a th??nh c??ng");
			} else {
				model.addAttribute("message", "X??a th???t b???i");
			}
		}
		showPhones(request, model, Phone.getPhones(factory));
		return "Admin/Product/productList";
	}

	@RequestMapping(value = "productEdit/{id}.htm", params = "linkEdit")
	public String editProduct(HttpServletRequest request, ModelMap model, @PathVariable("id") String id) {
		Phone phone = Phone.getPhone(factory, id);
		model.addAttribute("phone", phone);
		model.addAttribute("namCPU", phone.getCpu().getNameCPU() + "_" + phone.getCpu().getSpeedCPU());
		model.addAttribute("nameBrand", phone.getBrand().getNameBrand());
		model.addAttribute("nameScreen",
				phone.getScreen().getSizeScreen() + "_" + phone.getScreen().getTechScreen().getNameTechScreen() + "_"
						+ phone.getScreen().getResolution().getNameResolution());
		model.addAttribute("rams", Phone.getRams());
		model.addAttribute("roms", Phone.getRoms());
		model.addAttribute("brands", Brand.getBrands(factory));
		model.addAttribute("cpus", CPU.getCPUs(factory));
		model.addAttribute("screens", Screen.getScreens(factory));
		model.addAttribute("specialFeatures", SpecialFeature.getSpecialFeatures(factory));
		model.addAttribute("functionalCameras", FunctionalCamera.getFunctionalCameras(factory));
		return "Admin/Product/productUpdate";
	}

	@RequestMapping(value = "productEdit", params = "btnEdit", method = RequestMethod.POST)
	public String editProduct(HttpServletRequest request, ModelMap model, @ModelAttribute("phone") Phone phone,
			BindingResult errors) {
		System.out.print("???? v??o s???a ??i???n tho???i");

		if (validateProduct(request, model, phone, errors) == false) {
			model.addAttribute("message", "Vui l??ng s???a c??c l???i tr??n");
			setTechInfo(model);
			return "Admin/Product/productUpdate";
		}
		// get tech info
		String[] nameFunctionalCameras = request.getParameterValues("nameFunctionalCamera");
		String[] nameSpecialFeatures = request.getParameterValues("nameSpecialFeature");
		String brand = request.getParameter("nameBrand");
		String[] cpu = request.getParameter("nameCPU").split("_");
		String[] screen = request.getParameter("nameScreen").split("_");

		// insert tech info on DB
		Brand b = new Brand();
		Screen s = new Screen();
		CPU c = new CPU();
		getTechInfoIntoDB(b, c, s, brand, cpu, screen);
		phone.setScreen(s);
		phone.setCpu(c);
		phone.setBrand(b);
		phone.setStatusPhone(0);

		Integer temp = Phone.updatePhone(factory, phone);
		if (temp != 0) {
			model.addAttribute("message", "S???a th??nh c??ng");

		} else {
			model.addAttribute("message", "S???a th???t b???i" + phone);
		}

		return "redirect:/Admin/productList.htm";

	}

	@RequestMapping("productInsert")
	public String productInsert(ModelMap model) {
		model.addAttribute("phone", new Phone());
		setTechInfo(model);
		return "Admin/Product/productInsert";
	}

	@RequestMapping(value = "productInsert", params = "btnAdd", method = RequestMethod.POST)
	public String addProduct(HttpServletRequest request, ModelMap model, @ModelAttribute("phone") Phone phone,
			@RequestParam("image") MultipartFile[] images, BindingResult errors) {
		System.out.print("Insert Phone");
		if (validateProduct(request, model, phone, errors) == false) {
			model.addAttribute("message", "Vui l??ng s???a c??c l???i tr??n");
			setTechInfo(model);
			return "Admin/Product/productInsert";
		}
		// check seri number
		if (Phone.checkPhone(factory, phone.getIdPhone()) == 1) {
			model.addAttribute("message", "S??? seri ???? t???n t???i, vui l??ng ki???m tra l???i");
			setTechInfo(model);
			return "Admin/Product/productInsert";
		}

		// check images
		if (images.length <= 2) {
			model.addAttribute("message", "Vui l??ng ch???n ??t nh???t 3 h??nh ???nh");
			setTechInfo(model);
			return "Admin/Product/productInsert";
		}

		for (MultipartFile x : images) {
			String t = x.getOriginalFilename();
			System.out.println("??u??i file: " + t.substring(t.lastIndexOf(".")));
			if (t.contains("_") || !imageExtension.contains(t.substring(t.lastIndexOf(".")))) {
				model.addAttribute("message",
						"T??n file h??nh ???nh kh??ng ???????c ch???a k?? t??? '_' v?? c?? ??u??i m??? r???ng .jpeg, .jpg, .tiff, .psd, .eps");
				setTechInfo(model);
				return "Admin/Product/productInsert";
			}
		}

		String a = "";
		try {
			for (MultipartFile h : images) {
				h.transferTo(new File(basePath.getPathName() + File.separator + h.getOriginalFilename()));
				a = a + h.getOriginalFilename() + "_";
			}
		} catch (Exception e) {
			model.addAttribute("message", "file c?? th??? ???? t???n t???i, vui l??ng ki???m tra l???i");
			setTechInfo(model);
			return "Admin/Product/productInsert";
		}

		// get tech info
		String[] nameFunctionalCameras = request.getParameterValues("nameFunctionalCamera");
		String[] nameSpecialFeatures = request.getParameterValues("nameSpecialFeature");
		String brand = request.getParameter("nameBrand");
		String[] cpu = request.getParameter("nameCPU").split("_");
		String[] screen = request.getParameter("nameScreen").split("_");

		// insert tech info on DB
		Brand b = new Brand();
		CPU c = new CPU();
		Screen s = new Screen();

		getTechInfoIntoDB(b, c, s, brand, cpu, screen);

		phone.setScreen(s);
		phone.setCpu(c);
		phone.setBrand(b);
		phone.setStatusPhone(0);

		phone.setImagePhone(a);

		Integer temp = Phone.insertPhone(factory, phone);
		if (temp != 0) {
			model.addAttribute("message", "Th??m th??nh c??ng");
			model.addAttribute("phone", new Phone());
			setTechInfo(model);
			if (nameFunctionalCameras != null) {
				for (String name : nameFunctionalCameras) {
					CameraPhonePK m = new CameraPhonePK();
					m.setPhone(phone);
					m.setFunctionalCamera(FunctionalCamera.getFunctionalCamera(factory, name));
					CameraPhone.insertCameraPhone(factory, new CameraPhone(m));
				}
			}
			if (nameSpecialFeatures != null) {
				for (String name : nameSpecialFeatures) {
					FeaturePhonePK m = new FeaturePhonePK();
					m.setPhone(phone);
					m.setSpecialFeature(SpecialFeature.getSpecialFeature(factory, name));
					FeaturePhone.insertSpecialPhone(factory, new FeaturePhone(m));
				}
			}
		} else {
			model.addAttribute("message", "Th??m th???t b???i");
		}

		return "Admin/Product/productInsert";
	}

	public Boolean validateProduct(HttpServletRequest request, ModelMap model, Phone phone, BindingResult errors) {
		String checkid = "[A-Za-z0-9]{1,20}";
		String checkname = "[A-Za-z0-9\\s]{1,50}";
		String checksize = "[0-9]{1,3}[x][0-9]{1,3}[x][0-9]{1,3}[x][0-9]{3}";
		String checkcost = "[0-9]{1,9}";
		String checkdiscount = "[0-9]{1,2}";
		String checkcolor = "([\\p{L}\\s]{1,}[_]){1,}([\\p{L}\\s]{1,})";
		String checkyear = "[0-9]{4}";
		String checkcamera = "[0-9]{1,3}";
		String checkmaterial = "[\\p{L}\\s]{1,30}";
		String checkbattery = "[0-9]{1,4}";
		String checkbrand = "[A-Za-z]{1,30}";
		String checkcpu = "[A-Za-z0-9\\s\\+]{1,50}[_][0-9]{4}";
		String checkscreen = "\\d{1}[.]\\d{1,2}[_][A-Za-z0-9\\+\\s]{1,20}[_]\\d{3,4}[x]\\d{3,4}";

		if (phone.getIdPhone().trim().matches(checkid) == false) {
			errors.rejectValue("idPhone", "phone",
					"s??? seri ch??a ????ng ?????nh d???ng (kh??ng ???????c ch???a k?? t??? ?????c bi???t ho???c kh??ng qu?? 20 k?? t???)");
		}
		if (phone.getNamePhone().trim().matches(checkname) == false) {
			errors.rejectValue("namePhone", "phone",
					"t??n ch??a ????ng ?????nh d???ng (kh??ng ???????c ch???a k?? t??? ?????c bi???t ho???c kh??ng qu?? 50 k?? t???)");
		}
		if (phone.getSizePhone().trim().matches(checksize) == false || phone.getSizePhone().trim().length() > 15) {
			errors.rejectValue("sizePhone", "phone", "k??ch th?????c ch??a ????ng ?????nh d???ng");
		}
		if (phone.getCostPhone().toString().trim().matches(checkcost) == false || phone.getCostPhone() > 200000000
				|| phone.getCostPhone() == 0) {
			errors.rejectValue("costPhone", "phone", "gi?? ti???n ch??a ????ng ?????nh d???ng (kh??ng qu?? 200.000.000??)");
			System.out.println("gi?? ti???n ch??a ????ng ?????nh d???ng");
		}
		if (phone.getDiscountPhone().toString().trim().matches(checkdiscount) == false) {
			errors.rejectValue("discountPhone", "phone", "khuy???n m??i ch??a ????ng ?????nh d???ng (kh??ng qu?? 99)");
			System.out.println("gi???m gi?? ch??a ????ng ?????nh d???ng");
		}
		if (phone.getColorPhone().trim().matches(checkcolor) == false || phone.getColorPhone().trim().length() < 5
				|| phone.getColorPhone().trim().length() > 30) {
			errors.rejectValue("colorPhone", "phone", "m??u s???c ch??a ????ng ?????nh d???ng");
		}
		LocalDateTime year = LocalDateTime.now();
		if (phone.getYearPhone().toString().trim().matches(checkyear) == false
				|| phone.getYearPhone() > year.getYear()) {
			errors.rejectValue("yearPhone", "phone",
					"n??m s???n xu???t ch??a ????ng ?????nh d???ng (kh??ng ???????c l???n h??n n??m hi???n t???i)");
			System.out.println("n??m s???n xu???t ch??a ????ng ?????nh d???ng");
		}
		if (phone.getCameraFrontPhone().toString().trim().matches(checkcamera) == false
				|| phone.getCameraFrontPhone() > 200) {
			errors.rejectValue("cameraFrontPhone", "phone",
					"????? ph??n gi???i camera ch??a ????ng ?????nh d???ng (kh??ng ???????c qu?? 200)");
		}
		if (phone.getCameraRearPhone().toString().trim().matches(checkcamera) == false
				|| phone.getCameraRearPhone() > 200) {
			errors.rejectValue("cameraRearPhone", "phone",
					"????? ph??n gi???i camera ch??a ????ng ?????nh d???ng (kh??ng ???????c qu?? 200)");
		}
		if (phone.getMaterial().trim().matches(checkmaterial) == false) {
			errors.rejectValue("material", "phone",
					"ch???t li???u ch??a ????ng ?????nh d???ng (kh??ng ???????c ch???a k?? t??? ?????c bi???t ho???c kh??ng qu?? 30 k?? t???)");
		}
		if (phone.getBatteryPhone().toString().trim().matches(checkbattery) == false) {
			errors.rejectValue("batteryPhone", "phone", "dung l?????ng pin ch??a ????ng ?????nh d???ng (th???p h??n 10000)");
		}
		if (request.getParameter("nameBrand").matches(checkbrand) == false) {
			model.addAttribute("errorBrand", "nh??n hi???u kh??ng ????ng ?????nh d???ng");
			return false;
		}
		if (request.getParameter("nameCPU").matches(checkcpu) == false) {
			model.addAttribute("errorCPU", "CPU kh??ng ????ng ?????nh d???ng");
			return false;
		}
		if (request.getParameter("nameScreen").matches(checkscreen) == false) {
			model.addAttribute("errorScreen", "m??n h??nh kh??ng ????ng ?????nh d???ng");
			return false;
		}
		if (errors.hasErrors()) {
			return false;
		}
		return true;
	}

	public void setTechInfo(ModelMap model) {
		model.addAttribute("rams", Phone.getRams());
		model.addAttribute("roms", Phone.getRoms());
		model.addAttribute("brands", Brand.getBrands(factory));
		model.addAttribute("cpus", CPU.getCPUs(factory));
		model.addAttribute("screens", Screen.getScreens(factory));
		model.addAttribute("specialFeatures", SpecialFeature.getSpecialFeatures(factory));
		model.addAttribute("functionalCameras", FunctionalCamera.getFunctionalCameras(factory));
	}

	public void getTechInfoIntoDB(Brand b, CPU c, Screen s, String brand, String[] cpu, String[] screen) {
		b.setNameBrand(brand);
		if (Brand.checkBrand(factory, brand) == 0) {
			Brand.insertBrand(factory, b);
		}
		b.setIdBrand(Brand.getID(factory, brand));

		c.setNameCPU(cpu[0]);
		c.setSpeedCPU(Integer.parseInt(cpu[1]));
		if (CPU.checkCPU(factory, c) == 0) {
			CPU.insertCPU(factory, c);
		}
		c.setIdCPU(CPU.getID(factory, cpu[0], c.getSpeedCPU()));

		TechScreen t = new TechScreen();
		t.setNameTechScreen(screen[1]);
		if (TechScreen.checkTechScreen(factory, screen[1]) == 0) {
			TechScreen.insertTechScreen(factory, t);
		}
		t.setIdTechScreen(TechScreen.getID(factory, screen[1]));

		Resolution r = new Resolution();
		r.setNameResolution(screen[2]);
		if (Resolution.checkResolution(factory, screen[2]) == 0) {
			Resolution.insertResolution(factory, r);
		}
		r.setIdResolution(Resolution.getID(factory, screen[2]));

		s.setSizeScreen(Float.parseFloat(screen[0]));
		s.setTechScreen(t);
		s.setResolution(r);
		if (Screen.checkScreen(factory, s.getSizeScreen(), s.getTechScreen(), s.getResolution()) == 0) {
			Screen.insertScreen(factory, s);
		}
		s.setIdScreen(Screen.getID(factory, s));
	}

	public void showPhones(HttpServletRequest request, ModelMap model, List<Phone> phones) {
		PagedListHolder pagedListHolder = new PagedListHolder(phones);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(10);
		model.addAttribute("pagedListHolder", pagedListHolder);
	}

	@RequestMapping("customer")
	public String customer(HttpServletRequest request, ModelMap model) {

		showCustomer(request, model, Customer.getCustomers(factory));
		return "Admin/customer";
	}

	@RequestMapping(value = "customer", params = "btnSearch")
	public String searchCustomer(HttpServletRequest request, ModelMap model) {
		showCustomer(request, model, Customer.searchCustomers(factory, request.getParameter("name")));
		return "Admin/customer";
	}

	@RequestMapping(value = "customer/{id}.htm", params = "linkBlock")
	public String blockCustomer(HttpServletRequest request, ModelMap model, @PathVariable("id") String id) {
		if (Customer.setActivity(factory, 0, id) == 1) {
			model.addAttribute("message", "Block th??nh c??ng");
		}
		showCustomer(request, model, Customer.getCustomers(factory));
		return "redirect:/Admin/customer.htm";
	}

	@RequestMapping(value = "customer/{id}.htm", params = "linkUnBlock")
	public String unBlockCustomer(HttpServletRequest request, ModelMap model, @PathVariable("id") String id) {
		if (Customer.setActivity(factory, 1, id) == 1) {
			model.addAttribute("message", "UnBlock th??nh c??ng");
		}
		showCustomer(request, model, Customer.getCustomers(factory));
		return "redirect:/Admin/customer.htm";
	}

	public void showCustomer(HttpServletRequest request, ModelMap model, List<Customer> customers) {
		PagedListHolder pagedListHolder = new PagedListHolder(customers);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(10);
		model.addAttribute("pagedListHolder", pagedListHolder);
	}

	@RequestMapping("billUnConfirm")
	public String billUnConfirm(HttpServletRequest request, ModelMap model) {
		showBill(request, model, Bill.getBills(factory, 1));
		return "Admin/Bill/billUnConfirm";
	}

	@RequestMapping(value = "billUnConfirm", params = "btnSearch")
	public String searchBillUnConfirm(HttpServletRequest request, ModelMap model) {
		showBill(request, model, Bill.searchBillsUnconfirm(factory, request.getParameter("name")));
		return "Admin/Bill/billUnConfirm";
	}

	@RequestMapping(value = "email/{id}.htm")
	public String confirmBill(HttpServletRequest request, ModelMap model, @PathVariable("id") int id) {
		String to;
		String subject = "X??c nh???n ????n h??ng";
		String body;
		Bill bill = Bill.getBill(factory, id);
		send(bill);
		bill.setStatusBill(2);
		Bill.updateBill(factory, bill);
		showBill(request, model, Bill.getBills(factory, 1));
		return "Admin/Bill/billUnConfirm";
	}

	public Boolean send(Bill bill) {
		try {
			String body = "Xin ch??o " + bill.getCustomer().getNameCustomer();
			String body1 = "????n h??ng: " + bill.getIdBill();
			String body2 = "Ch??n th??nh c???m ??n b???n v?? ???? s???a d???ng d???ch v??? c???a ch??ng t??i, ????n h??ng s??? ???????c g???i ?????n b???n trong v??ng 24 ti???ng.";
			String body3 = "B???n vui l??ng x??c nh???n l???i ????n h??ng c???a m??nh ????? tr??nh nh???ng r???i ro kh??ng ????ng c??:";
			String body4 = "";
			String body5 = "T??n s???n ph???m" + alignment("T??n s???n ph???m") + "s??? l?????ng" + alignment("s??? l?????ng") + "Gi?? ti???n"
					+ alignment("Gi?? ti???n") + "M??u s???c";
			String detailBills = "";
			for (DetailBill k : DetailBill.getDetailBills(factory, bill.getIdBill())) {
				detailBills += k.getPk().getPhone().getNamePhone() + alignment(k.getPk().getPhone().getNamePhone())
						+ k.getAmount() + alignment(String.valueOf(k.getAmount())) + k.getCostDetailBill()
						+ alignment(String.valueOf(k.getCostDetailBill())) + k.getColorDetailBill() + "\n";
			}
			String body6 = "Xin ch??n th??nh c???m ??n!";
			String body7 = "FPT Shop tr??n tr???ng!";
			String temp = body + "\n" + body2 + "\n" + body3 + "\n" + body5 + "\n" + detailBills + body6 + "\n" + body7;
			System.out.println(temp);

			MimeMessage mail = mailer.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setTo(bill.getCustomer().getEmailCustomer());
			helper.setSubject(body1);
			helper.setText(temp);

			mailer.send(mail);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public String alignment(String s) {
		String t = " ";
		String temp = "";
		int n = 20 - s.trim().length();
		for (int i = 0; i < n; i++) {
			temp = temp + t;
		}
		return temp;
	}

	@RequestMapping("billConfirm")
	public String billConfirm(HttpServletRequest request, ModelMap model) {
		showBill(request, model, Bill.getBills(factory, 2));
		return "Admin/Bill/billConfirm";
	}

	@RequestMapping(value = "billConfirm", params = "btnSearch")
	public String searchBillConfirm(HttpServletRequest request, ModelMap model) {
		showBill(request, model, Bill.searchBillsConfirm(factory, request.getParameter("name")));
		return "Admin/Bill/billConfirm";
	}

	public void showBill(HttpServletRequest request, ModelMap model, List<Bill> bills) {
		PagedListHolder pagedListHolder = new PagedListHolder(bills);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(10);
		model.addAttribute("pagedListHolder", pagedListHolder);
	}

	@RequestMapping(value = "billDetail/{id}.htm")
	public String billDetail(HttpServletRequest request, ModelMap model, @PathVariable("id") int id) {
		showDetailBill(request, model, id);
		return "Admin/Bill/billDetail";
	}

	public void showDetailBill(HttpServletRequest request, ModelMap model, int id) {
		PagedListHolder pagedListHolder = new PagedListHolder(DetailBill.getDetailBills(factory, id));
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(20);
		model.addAttribute("pagedListHolder", pagedListHolder);
	}

	@RequestMapping("statistic")
	public String statistic(ModelMap model) {

		return "Admin/Statistic/statistic";
	}

	@RequestMapping(value = "statistic", params = "btnSearch", method = RequestMethod.POST)
	public String statistic(ModelMap model, HttpServletRequest request) {
		int year = Integer.parseInt(request.getParameter("year"));
		HashMap<Integer, Long> list = new HashMap<Integer, Long>();
		for (int i = 1; i <= 12; i++) {
			Long t = Bill.getCostBillByMonth(factory, i, year);
			if (t == null) {
				t = 0L;
			}
			list.put(i, t);
		}
		model.addAttribute("year", year);
		model.addAttribute("list", list);
		return "Admin/Statistic/statistic";
	}

	@RequestMapping("statisticByBrand")
	public String statisticByBrand(ModelMap model) {

		return "Admin/Statistic/statisticByBrand";
	}

	@RequestMapping(value = "statisticByBrand", params = "btnSearch", method = RequestMethod.POST)
	public String statisticByBrand(ModelMap model, HttpServletRequest request) {
		int year = Integer.parseInt(request.getParameter("year"));
		HashMap<String, Long> list = new HashMap<String, Long>();
		for (Brand k : Brand.getBrands(factory)) {
			Long t = DetailBill.getCostByBrand(factory, k.getIdBrand(), year);
			if (t == null) {
				t = 0L;
			}
			list.put(k.getNameBrand(), t);
		}
		model.addAttribute("year", year);
		model.addAttribute("list", list);
		return "Admin/Statistic/statisticByBrand";
	}

	@RequestMapping("statisticTopProducts")
	public String statisticTopProducts(ModelMap model) {

		return "Admin/Statistic/statisticTopProducts";
	}

	@RequestMapping(value = "statisticTopProducts", params = "btnSearch", method = RequestMethod.POST)
	public String statisticTopProducts(ModelMap model, HttpServletRequest request) {
		int year = Integer.parseInt(request.getParameter("year"));
		HashMap<Phone, Long> list = new HashMap<Phone, Long>();
		for (Phone p : Phone.getPhones(factory)) {
			Long t = DetailBill.getcostByPhone(factory, p.getIdPhone(), year);
			if (t == null) {
				t = 0L;
			} else {
				list.put(p, t);
			}
		}
		LinkedHashMap<Phone, Long> lMap = new LinkedHashMap<Phone, Long>();
		ArrayList<Long> lists = new ArrayList<>();
		for (Map.Entry<Phone, Long> item : list.entrySet()) {
			if (!lists.contains(item.getValue())) {
				lists.add(item.getValue());
			}
		}
		Collections.sort(lists, (d1, d2) -> {
			if((d1-d2)>0L) {
				return -1;
			}
			if((d1-d2)<0L) {
				return 1;
			}
			return 0;
		});
		for (Long t : lists) {
			for (Map.Entry<Phone, Long> entry : list.entrySet()) {
				if (entry.getValue() == t) {
					lMap.put(entry.getKey(), t);
				}
			}
		}
		model.addAttribute("year", year);
		model.addAttribute("list", lMap);
		return "Admin/Statistic/statisticTopProducts";
	}

	@RequestMapping("specialfeature")
	public String specialfeature(HttpServletRequest request, ModelMap model) {

		showSpecialFeature(request, model);

		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("specialfeature", new SpecialFeature());

		return "Admin/Product/specialfeature";
	}

	@RequestMapping(value = "specialfeature", method = RequestMethod.POST)
	public String addSpecialFeature(HttpServletRequest request, ModelMap model,
			@ModelAttribute("specialfeature") SpecialFeature specialfeature, BindingResult errors) {

		String checkname = "([\\p{L}\\s\\d\\,]+){1,50}";

		if (specialfeature.getNameSpecialFeature().trim().matches(checkname) == false) {
			errors.rejectValue("nameSpecialFeature", "specialfeature",
					"T??nh n??ng ?????c bi???t kh??ng ???????c ????? tr???ng, ch???a k?? t??? ?????c bi???t ho???c qu?? 50 k?? t???!");
		} else {
			Integer temp = SpecialFeature.insertSpecialFeature(factory, specialfeature);
			if (temp != 0) {
				model.addAttribute("message", "Th??m th??nh c??ng");
			} else {
				model.addAttribute("message", "Th??m th???t b???i" + specialfeature);
			}
		}
		showSpecialFeature(request, model);
		return "Admin/Product/specialfeature";
	}

	@RequestMapping(value = "specialfeature", params = "btnEdit", method = RequestMethod.POST)
	public String editSpecialFeature(HttpSession session, HttpServletRequest request, ModelMap model,
			@ModelAttribute("specialfeature") SpecialFeature specialfeature, BindingResult errors) {

		String checkname = "([\\p{L}\\s\\d\\,]+){1,50}";

		if (specialfeature.getNameSpecialFeature().trim().matches(checkname) == false) {
			errors.rejectValue("nameSpecialFeature", "specialfeature",
					"T??nh n??ng ?????c bi???t kh??ng ???????c ????? tr???ng, ch???a k?? t??? ?????c bi???t ho???c qu?? 50 k?? t???!");
		} else {
			Integer temp = SpecialFeature.updateSpecialFeature(factory, specialfeature);
			if (temp != 0) {
				model.addAttribute("message", "S???a th??nh c??ng");
				model.addAttribute("btnStatus", "btnAdd");
			} else {
				model.addAttribute("message", "S???a th???t b???i" + specialfeature);
				model.addAttribute("btnStatus", "btnEdit");
			}

		}

		showSpecialFeature(request, model);

		return "Admin/Product/specialfeature";
	}

	@RequestMapping(value = "specialfeature/{id}.htm", params = "linkEdit")
	public String editSpecialFeature(HttpServletRequest request, ModelMap model, @PathVariable("id") int id) {

		showSpecialFeature(request, model);

		model.addAttribute("btnStatus", "btnEdit");
		SpecialFeature s = SpecialFeature.getSpecialFeature(factory, id);
		model.addAttribute("specialfeature", s);

		return "Admin/Product/specialfeature";
	}

	@RequestMapping(value = "specialfeature/{id}.htm", params = "linkDelete")
	public String deleteSpecialFeature(HttpServletRequest request, ModelMap model,
			@ModelAttribute("specialfeature") SpecialFeature specialfeature, @PathVariable("id") int id) {

		Integer temp = SpecialFeature.deleteSpecialFeature(factory, SpecialFeature.getSpecialFeature(factory, id));
		if (temp != 0) {
			model.addAttribute("message", "X??a th??nh c??ng");
		} else {
			model.addAttribute("message", "X??a th???t b???i");
		}

		showSpecialFeature(request, model);

		return "Admin/Product/specialfeature";
	}

	public void showSpecialFeature(HttpServletRequest request, ModelMap model) {
		PagedListHolder pagedListHolder = new PagedListHolder(SpecialFeature.getSpecialFeatures(factory));
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(10);
		model.addAttribute("pagedListHolder", pagedListHolder);
	}

	@RequestMapping("functionalcamera")
	public String functionalcamera(HttpServletRequest request, ModelMap model) {

		showFunctionalcamera(request, model);

		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("functionalcamera", new FunctionalCamera());

		return "Admin/Product/functionalcamera";
	}

	@RequestMapping(value = "functionalcamera", method = RequestMethod.POST)
	public String addFunctionalcamera(HttpServletRequest request, ModelMap model,
			@ModelAttribute("functionalcamera") FunctionalCamera functionalcamera, BindingResult errors) {

		String checkname = "([\\p{L}\\s\\d\\,]+){1,50}";

		if (functionalcamera.getNameFunctionalCamera().trim().matches(checkname) == false) {
			errors.rejectValue("nameFunctionalCamera", "functionalcamera",
					"Ch???c n??ng camera kh??ng ???????c ????? tr???ng, ch???a k?? t??? ?????c bi???t ho???c qu?? 50 k?? t???!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui l??ng s???a c??c l???i sau!");
		} else {
			Integer temp = FunctionalCamera.insertFunctionalCamera(factory, functionalcamera);
			if (temp != 0) {
				model.addAttribute("message", "Th??m th??nh c??ng");
			} else {
				model.addAttribute("message", "Th??m th???t b???i" + functionalcamera);
			}
		}
		showFunctionalcamera(request, model);
		return "Admin/Product/functionalcamera";
	}

	@RequestMapping(value = "functionalcamera", params = "btnEdit", method = RequestMethod.POST)
	public String editFunctionalcamera(HttpSession session, HttpServletRequest request, ModelMap model,
			@ModelAttribute("functionalcamera") FunctionalCamera functionalcamera, BindingResult errors) {

		String checkname = "([\\p{L}\\s\\d\\,]){1,50}";

		if (functionalcamera.getNameFunctionalCamera().trim().matches(checkname) == false) {
			errors.rejectValue("nameFunctionalcamera", "functionalcamera",
					"Ch???c n??ng camera kh??ng ???????c ????? tr???ng, ch???a k?? t??? ?????c bi???t ho???c qu?? 50 k?? t???!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui l??ng s???a c??c l???i sau!");
			model.addAttribute("btnStatus", "btnEdit");
		} else {
			Integer temp = FunctionalCamera.updateFunctionalCamera(factory, functionalcamera);
			if (temp != 0) {
				model.addAttribute("message", "S???a th??nh c??ng");
				model.addAttribute("btnStatus", "btnAdd");
			} else {
				model.addAttribute("message", "S???a th???t b???i" + functionalcamera);
				model.addAttribute("btnStatus", "btnEdit");
			}

		}

		showFunctionalcamera(request, model);

		return "Admin/Product/functionalcamera";
	}

	@RequestMapping(value = "functionalcamera/{id}.htm", params = "linkEdit")
	public String editFunctionalcamera(HttpServletRequest request, ModelMap model, @PathVariable("id") int id) {

		showFunctionalcamera(request, model);

		model.addAttribute("btnStatus", "btnEdit");
		FunctionalCamera f = FunctionalCamera.getFunctionalCamera(factory, id);
		model.addAttribute("functionalcamera", f);

		return "Admin/Product/functionalcamera";
	}

	@RequestMapping(value = "functionalcamera/{id}.htm", params = "linkDelete")
	public String deleteFunctionalcamera(HttpServletRequest request, ModelMap model,
			@ModelAttribute("functionalcamera") FunctionalCamera functionalCamera, @PathVariable("id") int id) {

		Integer temp = FunctionalCamera.deleteFunctionalcamera(factory,
				FunctionalCamera.getFunctionalCamera(factory, id));
		if (temp != 0) {
			model.addAttribute("message", "X??a th??nh c??ng");
		} else {
			model.addAttribute("message", "X??a th???t b???i");
		}

		showFunctionalcamera(request, model);

		return "Admin/Product/functionalcamera";
	}

	public void showFunctionalcamera(HttpServletRequest request, ModelMap model) {
		PagedListHolder pagedListHolder = new PagedListHolder(FunctionalCamera.getFunctionalCameras(factory));
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(10);
		model.addAttribute("pagedListHolder", pagedListHolder);
	}

}
