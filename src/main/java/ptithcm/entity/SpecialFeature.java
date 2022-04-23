package ptithcm.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Entity
@Table(name = "SPECIAL_FEATURE")
public class SpecialFeature {

	@Id
	@GeneratedValue
	@Column(name = "ID_SPECIAL_FEATURE")
	private Integer idSpecialFeature;

	@Column(name = "NAME_SPECIAL_FEATURE")
	private String nameSpecialFeature;

	@OneToMany(mappedBy = "pk.specialFeature", fetch = FetchType.EAGER)
	private Collection<FeaturePhone> specialPhones;

	public SpecialFeature() {

	}

	public SpecialFeature(Integer idSpecialFeature, String nameSpecialFeature, Collection<FeaturePhone> specialPhones) {
		super();
		this.idSpecialFeature = idSpecialFeature;
		this.nameSpecialFeature = nameSpecialFeature;
		this.specialPhones = specialPhones;
	}

	public Integer getIdSpecialFeature() {
		return idSpecialFeature;
	}

	public void setIdSpecialFeature(Integer idSpecialFeature) {
		this.idSpecialFeature = idSpecialFeature;
	}

	public String getNameSpecialFeature() {
		return nameSpecialFeature;
	}

	public void setNameSpecialFeature(String nameSpecialFeature) {
		this.nameSpecialFeature = nameSpecialFeature;
	}

	public Collection<FeaturePhone> getSpecialPhones() {
		return specialPhones;
	}

	public void setSpecialPhones(Collection<FeaturePhone> specialPhones) {
		this.specialPhones = specialPhones;
	}

	public static List<SpecialFeature> getSpecialFeatures(SessionFactory factory) {
		Session session = factory.getCurrentSession();
		String hql = "FROM SpecialFeature";
		Query query = session.createQuery(hql);
		List<SpecialFeature> list = query.list();
		return list;

	}
	
	public static SpecialFeature getSpecialFeature(SessionFactory factory, String name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM SpecialFeature S WHERE S.nameSpecialFeature =:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		List<SpecialFeature> specialFeatures = query.list();
		return specialFeatures.get(0);
	}
	
	public static SpecialFeature getSpecialFeature(SessionFactory factory, int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM SpecialFeature where idSpecialFeature = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		SpecialFeature specialFeature = (SpecialFeature) query.list().get(0);
		return specialFeature;
	}

	public static Integer insertSpecialFeature(SessionFactory factory, SpecialFeature specialFeature) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(specialFeature);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public static Integer updateSpecialFeature(SessionFactory factory, SpecialFeature specialFeature) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(specialFeature);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public static Integer deleteSpecialFeature(SessionFactory factory, SpecialFeature specialFeature) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(specialFeature);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public static Integer checkSpecialFeature(SessionFactory factory, String name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM SpecialFeature S WHERE S.nameSpecialFeature =:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		List<SpecialFeature> specialFeatures = query.list();
		if (specialFeatures.isEmpty()) {
			return 0;
		}
		return 1;
	}
}
