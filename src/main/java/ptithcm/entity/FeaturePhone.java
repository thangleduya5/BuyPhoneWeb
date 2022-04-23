package ptithcm.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
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
@Table(name = "FEATURE_PHONE")
@AssociationOverrides({
		@AssociationOverride(name = "pk.specialFeature", joinColumns = @JoinColumn(name = "ID_SPECIAL_FEATURE")),
		@AssociationOverride(name = "pk.phone", joinColumns = @JoinColumn(name = "ID_PHONE")) })
public class FeaturePhone {

	@EmbeddedId
	FeaturePhonePK pk;

	public FeaturePhone() {

	}

	public FeaturePhone(FeaturePhonePK pk) {
		super();
		this.pk = pk;
	}

	public FeaturePhonePK getPk() {
		return pk;
	}

	public void setPk(FeaturePhonePK pk) {
		this.pk = pk;
	}
	
	public static List<FeaturePhone> getFeaturePhones(SessionFactory factory,String idPhone) {
		Session session = factory.getCurrentSession();
		String hql = "FROM FeaturePhone F WHERE F.pk.phone.idPhone =:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", idPhone);
		List<FeaturePhone> list = query.list();
		return list;
	}

	public static Integer insertSpecialPhone(SessionFactory factory, FeaturePhone specialPhone) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(specialPhone);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public static Integer deleteFeaturePhone(SessionFactory factory, String idPhone) {
		Session session = factory.getCurrentSession();
		try {
			String hql = "DELETE FROM FeaturePhone F WHERE F.pk.phone.idPhone =:id";
			Query query = session.createQuery(hql);
			query.setParameter("id", idPhone);
			query.executeUpdate();
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

//	public static Integer checkSpecialPhone(SessionFactory factory, String name) {
//		Session session = factory.getCurrentSession();
//		String hql = "FROM SpecialPhone S WHERE S.nameSpecialPhone =:name";
//		Query query = session.createQuery(hql);
//		query.setParameter("name", name);
//		List<SpecialFeature> specialFeatures = query.list();
//		if (specialFeatures.isEmpty()) {
//			return 0;
//		}
//		return 1;
//	}
	
	public static List<String> getPhoneFeatures(SessionFactory factory, int idSpecialFeature){
		Session session = factory.getCurrentSession();
		String hql = "SELECT F.pk.phone.idPhone FROM FeaturePhone F WHERE F.pk.specialFeature.idSpecialFeature =:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", idSpecialFeature);
		List<String> list = query.list();
		return list;
	}
}