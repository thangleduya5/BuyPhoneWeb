package ptithcm.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@Column(name = "ID_CUSTOMER")
	private String idCustomer;

	@Column(name = "NAME_CUSTOMER")
	private String nameCustomer;

	@Column(name = "PHONE_CUSTOMER")
	private String phoneCustomer;

	@Column(name = "EMAIL_CUSTOMER")
	private String emailCustomer;

	@Column(name = "ADDRESS_CUSTOMER")
	private String addressCustomer;

	@Column(name = "PASSWORD_CUSTOMER")
	private String passwordCustomer;
	
	@Column(name = "STATUS_CUSTOMER")
	private Integer statusCustomer;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private Collection<Bill> bills;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String idCustomer, String nameCustomer, String phoneCustomer, String emailCustomer,
			String addressCustomer, String passwordCustomer, Integer statusCustomer, Collection<Bill> bills) {
		super();
		this.idCustomer = idCustomer;
		this.nameCustomer = nameCustomer;
		this.phoneCustomer = phoneCustomer;
		this.emailCustomer = emailCustomer;
		this.addressCustomer = addressCustomer;
		this.passwordCustomer = passwordCustomer;
		this.statusCustomer = statusCustomer;
		this.bills = bills;
	}

	public String getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public String getPhoneCustomer() {
		return phoneCustomer;
	}

	public void setPhoneCustomer(String phoneCustomer) {
		this.phoneCustomer = phoneCustomer;
	}

	public String getEmailCustomer() {
		return emailCustomer;
	}

	public void setEmailCustomer(String emailCustomer) {
		this.emailCustomer = emailCustomer;
	}

	public String getAddressCustomer() {
		return addressCustomer;
	}

	public void setAddressCustomer(String addressCustomer) {
		this.addressCustomer = addressCustomer;
	}

	public String getPasswordCustomer() {
		return passwordCustomer;
	}

	public void setPasswordCustomer(String passwordCustomer) {
		this.passwordCustomer = passwordCustomer;
	}

	public Integer getStatusCustomer() {
		return statusCustomer;
	}

	public void setStatusCustomer(Integer statusCustomer) {
		this.statusCustomer = statusCustomer;
	}

	public Collection<Bill> getBills() {
		return bills;
	}

	public void setBills(Collection<Bill> bills) {
		this.bills = bills;
	}

	public static List<Customer> getCustomers(SessionFactory factory) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Customer";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		return list;

	}

	public static Customer getCustomer(SessionFactory factory, String idCustomer) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Customer where idCustomer = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", idCustomer);
		Customer customer = (Customer) query.list().get(0);
		return customer;
	}

	public static List<Customer> searchCustomers(SessionFactory factory, String nameCustomer) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Customer where nameCustomer LIKE :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", "%" + nameCustomer + "%");
		List<Customer> list = query.list();

		return list;
	}

	public static Integer insertCustomer(SessionFactory factory, Customer customer) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(customer);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public static Integer updateCustomer(SessionFactory factory, Customer customer) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(customer);
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

	public static Integer checkCustomerPass(SessionFactory factory, String passCustomer, String idCustomer) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Customer C WHERE C.idCustomer = :id AND C.passwordCustomer = :pass";
		Query query = session.createQuery(hql);
		query.setParameter("id", idCustomer);
		query.setParameter("pass", passCustomer);
		List<Customer> customers = query.list();
		if (customers.isEmpty()) {
			return 0;
		}
		return 1;
	}
	
	public static Integer updateCustomerPass(SessionFactory factory, String newPass, String idCustomer) {
		Session session = factory.getCurrentSession();
		try {
			String hql = "UPDATE Customer SET passwordCustomer = :pass WHERE idCustomer = :id";
			Query query = session.createQuery(hql);
			query.setParameter("pass", newPass);
			query.setParameter("id", idCustomer);
			query.executeUpdate();
		} catch (Exception e) {
			System.out.print(e);
			return 0;
		} 
		return 1;
	}
	
	public static Integer setActivity(SessionFactory factory, int status, String idCustomer) {
		Session session = factory.getCurrentSession();
		try {
			String hql = "UPDATE Customer SET statusCustomer = :status WHERE idCustomer = :id";
			Query query = session.createQuery(hql);
			query.setParameter("status", status);
			query.setParameter("id", idCustomer);
			query.executeUpdate();
		} catch (Exception e) {
			System.out.print(e);
			return 0;
		}
		return 1;
	}

}
