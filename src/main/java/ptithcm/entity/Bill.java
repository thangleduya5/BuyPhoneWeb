package ptithcm.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.format.annotation.DateTimeFormat;


@Entity @Table(name = "BILL")
public class Bill {
	
	@Id @GeneratedValue @Column(name = "ID_BILL")
	private Integer idBill;
	
	@Column(name = "DATE_BILL") @Temporal(TemporalType.DATE) @DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dateBill;
	
	@Column(name = "STATUS_BILL")
	private Integer statusBill;
	
	@Column(name = "COST_BILL")
	private Long costBill;
	
	@OneToMany(mappedBy = "pk.bill", fetch = FetchType.EAGER)
	private Collection<DetailBill> detailBills;
	
	
	@ManyToOne @JoinColumn(name = "ID_CUSTOMER")
	private Customer customer;
	
	public Bill() {
		
	}

	public Bill(Integer idBill, Date dateBill, Integer statusBill, Collection<DetailBill> detailBills,
			Customer customer) {
		this.idBill = idBill;
		this.dateBill = dateBill;
		this.statusBill = statusBill;
		this.detailBills = detailBills;
		this.customer = customer;
	}

	public Integer getIdBill() {
		return idBill;
	}

	public void setIdBill(Integer idBill) {
		this.idBill = idBill;
	}

	public Date getDateBill() {
		return dateBill;
	}

	public void setDateBill(Date dateBill) {
		this.dateBill = dateBill;
	}

	public Integer getStatusBill() {
		return statusBill;
	}

	public void setStatusBill(Integer statusBill) {
		this.statusBill = statusBill;
	}
	
	public Long getCostBill() {
		if(costBill==null) {
			return 0L;
		}
		return costBill;
	}

	public void setCostBill(Long costBill) {
		this.costBill = costBill;
	}

	public Collection<DetailBill> getDetailBills() {
		return detailBills;
	}

	public void setDetailBills(Collection<DetailBill> detailBills) {
		this.detailBills = detailBills;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public static List<Bill> getBills(SessionFactory factory, int status) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Bill B WHERE B.statusBill =:status";
		Query query = session.createQuery(hql);
		query.setParameter("status", status);
		List<Bill> list = query.list();
		return list;

	}
	
	public static List<Bill> getBills(SessionFactory factory, String idCustomer) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Bill B WHERE (B.statusBill = 1 OR B.statusBill = 2) AND B.customer.idCustomer =:idCustomer";
		Query query = session.createQuery(hql);
		query.setParameter("idCustomer", idCustomer);
		List<Bill> list = query.list();
		return list;

	}
	
	public static Bill getBill(SessionFactory factory, int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Bill B WHERE B.idBill = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		Bill bill =(Bill) query.list().get(0);
		return bill;

	}
	
	public static Bill getBillUnBuy(SessionFactory factory, String idCustomer) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Bill B WHERE B.customer.idCustomer =:idCustomer AND B.statusBill = 0";
		Query query = session.createQuery(hql);
		query.setParameter("idCustomer", idCustomer);
		List<Bill> list = query.list();
		return list.get(0);
	}
	
	public static Long getCostBillByMonth(SessionFactory factory, int month, int year) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT SUM(B.costBill) FROM Bill B WHERE MONTH(B.dateBill)=:month AND YEAR(B.dateBill)=:year AND B.statusBill = 2";
		Query query = session.createQuery(hql);
		query.setParameter("month", month);
		query.setParameter("year", year);
		return (Long) query.list().get(0);
	}
	
	public static List<Bill> searchBillsUnconfirm(SessionFactory factory, String idCustomer) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Bill where customer.idCustomer LIKE :name AND statusBill = 1";
		Query query = session.createQuery(hql);
		query.setParameter("name", "%" + idCustomer + "%");
		List<Bill> list = query.list();
		return list;
	}
	
	public static List<Bill> searchBillsConfirm(SessionFactory factory, String idCustomer) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Bill where customer.idCustomer LIKE :name AND statusBill = 2";
		Query query = session.createQuery(hql);
		query.setParameter("name", "%" + idCustomer + "%");
		List<Bill> list = query.list();
		return list;
	}
	
	public static Integer insertBill(SessionFactory factory, Customer customer) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Bill b=new Bill();
		b.setDateBill(new Date());
		b.setStatusBill(0);
		b.setCustomer(customer);
		try {
			session.save(b);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public static Integer updateBill(SessionFactory factory, Bill bill) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(bill);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
}
