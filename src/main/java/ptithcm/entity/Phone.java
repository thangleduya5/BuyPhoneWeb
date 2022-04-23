package ptithcm.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.ModelAttribute;

@Entity @Table(name = "PHONE")
public class Phone {

	@Id @Column(name = "ID_PHONE")
	private String idPhone;
	
	@Column(name = "NAME_PHONE")
	private String namePhone;
	
	@Column(name = "SIZE_PHONE")
	private String sizePhone;
	
	@Column(name = "OS_PHONE")
	private String osPhone;
	
	@Column(name = "COST_PHONE")
	private Long costPhone;
	
	@Column(name = "DISCOUNT_PHONE")
	private Integer discountPhone;
	
	@Column(name = "COLOR_PHONE")
	private String colorPhone;
	
	@Column(name = "YEAR_PHONE")
	private Integer yearPhone;
	
	@Column(name = "RAM_PHONE")
	private Integer ramPhone;
	
	@Column(name = "ROM_PHONE")
	private Integer romPhone;
	
	@Column(name = "CAMERA_REAR_PHONE")
	private Integer cameraRearPhone;

	@Column(name = "CAMERA_FRONT_PHONE")
	private Integer cameraFrontPhone;
	
	@Column(name = "BATTERY_PHONE")
	private Integer batteryPhone;
	
	@Column(name = "MATERIAL")
	private String material;

	@Column(name = "STATUS_PHONE")
	private Integer statusPhone;
	
	@Column(name = "IMAGE_PHONE")
	private String imagePhone;
	
	@OneToMany(mappedBy = "pk.phone", fetch = FetchType.EAGER)
	private Collection<FeaturePhone> specialPhones;
	
	@OneToMany(mappedBy = "pk.phone", fetch = FetchType.EAGER)
	private Collection<CameraPhone> cameraPhones;
	
	@OneToMany(mappedBy = "pk.phone", fetch = FetchType.EAGER)
	private Collection<DetailBill> detailBills;
	
	@ManyToOne @JoinColumn(name = "ID_SCREEN")
	private Screen screen;
	
	@ManyToOne @JoinColumn(name = "ID_CPU")
	private CPU cpu;
	
	@ManyToOne @JoinColumn(name = "ID_BRAND")
	private Brand brand;

	public Phone() {
		
	}
		
	public Phone(String idPhone, String namePhone, String sizePhone, String osPhone, Long costPhone,
			Integer discountPhone, String colorPhone, Integer yearPhone, Integer ramPhone, Integer romPhone,
			Integer cameraRearPhone, Integer cameraFrontPhone, Integer batteryPhone, String material,
			Integer statusPhone, String imagePhone, Collection<FeaturePhone> specialPhones, Collection<CameraPhone> cameraPhones,
			Collection<DetailBill> detailBills, Screen screen, CPU cpu, Brand brand) {
		super();
		this.idPhone = idPhone;
		this.namePhone = namePhone;
		this.sizePhone = sizePhone;
		this.osPhone = osPhone;
		this.costPhone = costPhone;
		this.discountPhone = discountPhone;
		this.colorPhone = colorPhone;
		this.yearPhone = yearPhone;
		this.ramPhone = ramPhone;
		this.romPhone = romPhone;
		this.cameraRearPhone = cameraRearPhone;
		this.cameraFrontPhone = cameraFrontPhone;
		this.batteryPhone = batteryPhone;
		this.material = material;
		this.statusPhone = statusPhone;
		this.imagePhone = imagePhone;
		this.specialPhones = specialPhones;
		this.cameraPhones = cameraPhones;
		this.detailBills = detailBills;
		this.screen = screen;
		this.cpu = cpu;
		this.brand = brand;
	}

	public String getIdPhone() {
		return idPhone;
	}

	public void setIdPhone(String idPhone) {
		this.idPhone = idPhone;
	}

	public String getNamePhone() {
		return namePhone;
	}

	public void setNamePhone(String namePhone) {
		this.namePhone = namePhone;
	}

	public String getSizePhone() {
		return sizePhone;
	}

	public void setSizePhone(String sizePhone) {
		this.sizePhone = sizePhone;
	}

	public String getOsPhone() {
		return osPhone;
	}

	public void setOsPhone(String osPhone) {
		this.osPhone = osPhone;
	}

	public Long getCostPhone() {
		if(costPhone==null) {
			return 0L;
		}
		return costPhone;
	}

	public void setCostPhone(Long costPhone) {
		this.costPhone = costPhone;
	}

	public Integer getDiscountPhone() {
		if(discountPhone==null) {
			return 0;
		}
		return discountPhone;
	}

	public void setDiscountPhone(Integer discountPhone) {
		this.discountPhone = discountPhone;
	}

	public String getColorPhone() {
		return colorPhone;
	}

	public void setColorPhone(String colorPhone) {
		this.colorPhone = colorPhone;
	}

	public Integer getYearPhone() {
		if(yearPhone==null) {
			return 0;
		}
		return yearPhone;
	}

	public void setYearPhone(Integer yearPhone) {
		this.yearPhone = yearPhone;
	}

	public Integer getRamPhone() {
		return ramPhone;
	}

	public void setRamPhone(Integer ramPhone) {
		this.ramPhone = ramPhone;
	}

	public Integer getRomPhone() {
		return romPhone;
	}

	public void setRomPhone(Integer romPhone) {
		this.romPhone = romPhone;
	}

	public Integer getCameraRearPhone() {
		if(cameraRearPhone==null) {
			return 0;
		}
		return cameraRearPhone;
	}

	public void setCameraRearPhone(Integer cameraRearPhone) {
		this.cameraRearPhone = cameraRearPhone;
	}

	public Integer getCameraFrontPhone() {
		if(cameraFrontPhone==null) {
			return 0;
		}
		return cameraFrontPhone;
	}

	public void setCameraFrontPhone(Integer cameraFrontPhone) {
		this.cameraFrontPhone = cameraFrontPhone;
	}

	public Integer getBatteryPhone() {
		if(batteryPhone==null) {
			return 0;
		}
		return batteryPhone;
	}

	public void setBatteryPhone(Integer batteryPhone) {
		this.batteryPhone = batteryPhone;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Integer getStatusPhone() {
		return statusPhone;
	}

	public void setStatusPhone(Integer statusPhone) {
		this.statusPhone = statusPhone;
	}

	public String getImagePhone() {
		return imagePhone;
	}

	public void setImagePhone(String imagePhone) {
		this.imagePhone = imagePhone;
	}

	public Collection<FeaturePhone> getSpecialPhones() {
		return specialPhones;
	}

	public void setSpecialPhones(Collection<FeaturePhone> specialPhones) {
		this.specialPhones = specialPhones;
	}

	public Collection<CameraPhone> getCameraPhones() {
		return cameraPhones;
	}

	public void setCameraPhones(Collection<CameraPhone> cameraPhones) {
		this.cameraPhones = cameraPhones;
	}

	public Collection<DetailBill> getDetailBills() {
		return detailBills;
	}

	public void setDetailBills(Collection<DetailBill> detailBills) {
		this.detailBills = detailBills;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public CPU getCpu() {
		return cpu;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public static int[] getRams() {
		int[] rams = { 2, 3, 4, 6, 8, 12, 16, 32 };
		return rams;
	}

	public static int[] getRoms() {
		int[] rams = { 16, 32, 64, 128, 256, 512 };
		return rams;
	}

	public static List<Phone> getPhones(SessionFactory factory) {

		Session session = factory.getCurrentSession();
		String hql = "FROM Phone";
		Query query = session.createQuery(hql);
		List<Phone> list = query.list();
		return list;

	}
		
	
	public static List<Phone> getPhoneBrand(SessionFactory factory, String nameBrand) {

		Session session = factory.getCurrentSession();
		String hql = "FROM Phone P WHERE P.brand.nameBrand =:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", nameBrand);
		List<Phone> list = query.list();
		return list;

	}
	
	public static List<String> getPhoneBrands(SessionFactory factory, String nameBrand) {

		Session session = factory.getCurrentSession();
		String hql = "SELECT P.idPhone FROM Phone P WHERE P.brand.nameBrand =:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", nameBrand);
		List<String> list = query.list();
		return list;

	}
	
	public static List<String> getPhonePrices(SessionFactory factory, String price) {

		Session session = factory.getCurrentSession();
		String hql;
		switch(price) {
			case "<2":
				hql = "SELECT P.idPhone FROM Phone P WHERE P.costPhone < 2000000";
				break;
			case "2->4":
				hql = "SELECT P.idPhone FROM Phone P WHERE P.costPhone BETWEEN 2000000 AND 4000000";
				break;
			case "4->7":
				hql = "SELECT P.idPhone FROM Phone P WHERE P.costPhone BETWEEN 4000000 AND 7000000";
				break;
			case "7->13":
				hql = "SELECT P.idPhone FROM Phone P WHERE P.costPhone BETWEEN 7000000 AND 13000000";
				break;
			default:
				hql = "SELECT P.idPhone FROM Phone P WHERE P.costPhone > 13000000";				
		}
		Query query = session.createQuery(hql);
		List<String> list = query.list();
		return list;

	}
	
	
	public static List<String> getPhoneBatterys(SessionFactory factory, String battery) {

		Session session = factory.getCurrentSession();
		String hql;
		switch(battery) {
			case "<3":
				hql = "SELECT P.idPhone FROM Phone P WHERE P.batteryPhone < 3000";
				break;
			case "3->4":
				hql = "SELECT P.idPhone FROM Phone P WHERE P.batteryPhone BETWEEN 3000 AND 4000";
				break;
			default:
				hql = "SELECT P.idPhone FROM Phone P WHERE P.batteryPhone > 4000";				
		}
		Query query = session.createQuery(hql);
		List<String> list = query.list();
		return list;

	}
	
	public static List<String> getPhoneScreens(SessionFactory factory, String screen) {

		Session session = factory.getCurrentSession();
		String hql;
		switch(screen) {
			case "<5":
				hql = "SELECT P.idPhone FROM Phone P WHERE P.screen.sizeScreen < 5";
				break;
			case "5->6":
				hql = "SELECT P.idPhone FROM Phone P WHERE P.screen.sizeScreen BETWEEN 5 AND 6";
				break;
			default:
				hql = "SELECT P.idPhone FROM Phone P WHERE P.screen.sizeScreen > 6";				
		}
		Query query = session.createQuery(hql);
		List<String> list = query.list();
		return list;

	}

	public static Phone getPhone(SessionFactory factory, String idPhone) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Phone where idPhone = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", idPhone);
		Phone phone= (Phone) query.list().get(0);
		return phone;
	}
	
	public static Long getCountByBrand(SessionFactory factory, int idBrand) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT count(idPhone) FROM Phone where brand.idBrand = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", idBrand);
		return (Long) query.list().get(0);
	}

	public static List<Phone> searchPhones(SessionFactory factory, String namePhone) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Phone where namePhone LIKE :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", "%" + namePhone + "%");
		List<Phone> list = query.list();

		return list;
	}

	public static Integer insertPhone(SessionFactory factory, Phone phone) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(phone);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.print("loi: " +e);
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public static Integer updatePhone(SessionFactory factory, Phone phone) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(phone);
			t.commit();
		} catch (Exception e) {
			System.out.print("loi  "+e);
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public static Integer deletePhone(SessionFactory factory, Phone phone) {
		Session session = factory.getCurrentSession();
		try {
			session.delete(phone);
		} catch (Exception e) {
			System.out.print("loi  "+e);
			return 0;
		}
		return 1;
	}
	
	public static Integer checkPhone(SessionFactory factory, String idPhone) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Phone P WHERE P.idPhone = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", idPhone);
		List<Screen> screens = query.list();
		if (screens.isEmpty()) {
			System.out.print("Thêm vào nha");
			return 0;
		}
		return 1;
	}
	
}
