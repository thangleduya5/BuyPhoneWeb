package ptithcm.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import ptithcm.ss.FunctionCommon;

@Entity
@Table(name = "STAFF")
public class Staff {

	@Id
	@Column(name = "ID_STAFF")
	private String idStaff;

	@Column(name = "NAME_STAFF")
	private String nameStaff;

	@Column(name = "EMAIL_STAFF")
	private String emailStaff;

	@Column(name = "PHONE_STAFF")
	private String phoneStaff;

	@Column(name = "ADDRESS_STAFF")
	private String addressStaff;

	@Column(name = "SEX_STAFF")
	private String sexStaff;

	@Column(name = "BIRTHDAY_STAFF")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date birthdayStaff;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ROLE")
	private Integer role;

	public Staff() {

	}

	public Staff(String idStaff, String nameStaff, String emailStaff, String phoneStaff, String addressStaff,
			String sexStaff, Date birthdayStaff, String password, Integer role) {
		super();
		this.idStaff = idStaff;
		this.nameStaff = nameStaff;
		this.emailStaff = emailStaff;
		this.phoneStaff = phoneStaff;
		this.addressStaff = addressStaff;
		this.sexStaff = sexStaff;
		this.birthdayStaff = birthdayStaff;
		this.password = password;
		this.role = role;
	}

	public String getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(String idStaff) {
		this.idStaff = idStaff;
	}

	public String getNameStaff() {
		return nameStaff;
	}

	public void setNameStaff(String nameStaff) {
		this.nameStaff = nameStaff;
	}

	public String getEmailStaff() {
		return emailStaff;
	}

	public void setEmailStaff(String emailStaff) {
		this.emailStaff = emailStaff;
	}

	public String getPhoneStaff() {
		return phoneStaff;
	}

	public void setPhoneStaff(String phoneStaff) {
		this.phoneStaff = phoneStaff;
	}

	public String getAddressStaff() {
		return addressStaff;
	}

	public void setAddressStaff(String addressStaff) {
		this.addressStaff = addressStaff;
	}

	public String getSexStaff() {
		return sexStaff;
	}

	public void setSexStaff(String sexStaff) {
		this.sexStaff = sexStaff;
	}

	public Date getBirthdayStaff() {
		return birthdayStaff;
	}

	public void setBirthdayStaff(Date birthdayStaff) {
		this.birthdayStaff = birthdayStaff;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public static List<Staff> getStaffs(SessionFactory factory) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		return list;

	}

	public static Staff getStaff(SessionFactory factory, String idStaff) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff where idStaff = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", idStaff);
		Staff staff = (Staff) query.list().get(0);
		return staff;
	}

	public static List<Staff> searchStaffs(SessionFactory factory, String nameStaff) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff where nameStaff LIKE :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", "%" + nameStaff + "%");
		List<Staff> list = query.list();

		return list;
	}

	public static Integer insertStaff(SessionFactory factory, Staff staff, String date) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		staff.setPassword("1111");
		staff.setRole(0);
		staff.setNameStaff(FunctionCommon.normalizeName(staff.getNameStaff()));
		staff.setIdStaff(Staff.getID(FunctionCommon.covertToEng(staff.getNameStaff()), staff.getPhoneStaff()));
		staff.setBirthdayStaff(FunctionCommon.toDate(date));
		try {
			session.save(staff);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public static Integer updateStaff(SessionFactory factory, Staff staff, String date) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		staff.setNameStaff(FunctionCommon.normalizeName(staff.getNameStaff()));
		staff.setBirthdayStaff(FunctionCommon.toDate(date));
		System.out.print(staff.getNameStaff() + staff.getPassword() + staff.getBirthdayStaff());
		try {
			String hql = "DELETE FROM Staff " + "WHERE idStaff = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", staff.getIdStaff());
			query.executeUpdate();
		    System.out.println("Ten moi: " + FunctionCommon.covertToEng(staff.getNameStaff()));
			staff.setIdStaff(Staff.getID(FunctionCommon.covertToEng(staff.getNameStaff()), staff.getPhoneStaff()));
			session.save(staff);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.print(e);
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public static Integer deleteStaff(SessionFactory factory, Staff staff) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(staff);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public static String getID(String name, String phone) {
		String result = "";
		String arr[] = name.trim().split(" ");
		for (String k : arr) {
			result += k.charAt(0);
		}
		result += phone.trim().substring(7);
		return result;
	}

	public static Integer checkStaffPass(SessionFactory factory, String passStaff, String idStaff) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff S WHERE S.idStaff =:id AND S.password =:pass";
		Query query = session.createQuery(hql);
		query.setParameter("id", idStaff);
		query.setParameter("pass", passStaff);
		List<Staff> staffs = query.list();
		if (staffs.isEmpty()) {
			return 0;
		}
		return 1;
	}
	
	public static Integer updateStaffPass(SessionFactory factory, String newPass, String idStaff) {
		Session session = factory.getCurrentSession();
		System.out.print("thay doi mat khau: "+ newPass + "  " + idStaff);
		try {
			String hql = "UPDATE Staff SET password = :pass WHERE idStaff = :id";
			Query query = session.createQuery(hql);
			query.setParameter("pass", newPass);
			query.setParameter("id", idStaff);
			query.executeUpdate();
		} catch (Exception e) {
			System.out.print(e);
			return 0;
		} 
		return 1;
	}

}
