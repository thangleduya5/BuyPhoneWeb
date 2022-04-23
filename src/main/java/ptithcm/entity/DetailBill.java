package ptithcm.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Entity
@Table(name = "DETAIL_BILL")
@AssociationOverrides({
    @AssociationOverride(name = "pk.bill", 
        joinColumns = @JoinColumn(name = "ID_BILL")),
    @AssociationOverride(name = "pk.phone", 
        joinColumns = @JoinColumn(name = "ID_PHONE")) })
public class DetailBill {
	
	@EmbeddedId DetailBillPK pk;
	
	@Column(name = "AMOUNT")
	private int amount;
	
	@Column(name = "COST_DETAIL_BILL")
	private Long costDetailBill;
	
	@Column(name = "COLOR_DETAIL_BILL")
	private String colorDetailBill;
	
	public DetailBill() {
		
	}
	
	public DetailBill(DetailBillPK pk, int amount, Long costDetailBill, String colorDetailBill) {
		this.pk = pk;
		this.amount = amount;
		this.costDetailBill = costDetailBill;
		this.colorDetailBill = colorDetailBill;
	}

	public DetailBillPK getPk() {
		return pk;
	}

	public void setPk(DetailBillPK pk) {
		this.pk = pk;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Long getCostDetailBill() {
		return costDetailBill;
	}

	public void setCostDetailBill(Long costDetailBill) {
		this.costDetailBill = costDetailBill;
	}

	public String getColorDetailBill() {
		return colorDetailBill;
	}

	public void setColorDetailBill(String colorDetailBill) {
		this.colorDetailBill = colorDetailBill;
	}
	
	public static List<DetailBill> getDetailBills(SessionFactory factory, int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM DetailBill D WHERE D.pk.bill.idBill =:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<DetailBill> list = query.list();
		return list;

	}
	
	public static DetailBill getDetailBill(SessionFactory factory, int idBill, String idPhone) {
		Session session = factory.getCurrentSession();
		String hql = "FROM DetailBill D WHERE D.pk.bill.idBill =:idBill AND D.pk.phone.idPhone =:idPhone";
		Query query = session.createQuery(hql);
		query.setParameter("idBill", idBill);
		query.setParameter("idPhone", idPhone);
		List<DetailBill> list= query.list();
		if(list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public static Long getcostByPhone(SessionFactory factory, String idPhone, int year) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT SUM(D.costDetailBill) FROM DetailBill D WHERE D.pk.bill.statusBill= 2 AND D.pk.phone.idPhone =:idPhone AND YEAR(D.pk.bill.dateBill)=:year";
		Query query = session.createQuery(hql);
		query.setParameter("year", year);
		query.setParameter("idPhone", idPhone);
		return (Long) query.list().get(0);
	}
	
	public static Long getCostByBrand(SessionFactory factory, int idBrand, int year) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT SUM(D.costDetailBill) FROM DetailBill D WHERE D.pk.bill.statusBill = 2 AND D.pk.phone.brand.idBrand=:idBrand AND YEAR(D.pk.bill.dateBill)=:year";
		Query query = session.createQuery(hql);
		query.setParameter("idBrand", idBrand);
		query.setParameter("year", year);
		return (Long) query.list().get(0);
	}
	
	
		
	public static Integer insertDetailBill(SessionFactory factory, DetailBill detailBill) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(detailBill);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	public static Integer updateDetailBill(SessionFactory factory, DetailBill detailBill) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(detailBill);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	public static Integer deleteDetailBill(SessionFactory factory, DetailBill detailBill) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(detailBill);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public static Integer checkPhoneExistDetaiBill(SessionFactory factory, String id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM DetailBill D WHERE D.pk.phone.idPhone =:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<DetailBill> list = query.list();
		if(list.isEmpty()) {
			return 0;
		}
		return 1;
	}

}
