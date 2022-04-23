package ptithcm.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.ModelAttribute;

@Entity
@Table(name = "BRAND")
public class Brand {

	@Id
	@GeneratedValue
	@Column(name = "ID_BRAND")
	private Integer idBrand;

	@Column(name = "NAME_BRAND")
	private String nameBrand;

	@OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
	private Collection<Phone> phones;

	public Brand() {

	}

	public Brand(Integer idBrand, String nameBrand, Collection<Phone> phones) {
		super();
		this.idBrand = idBrand;
		this.nameBrand = nameBrand;
		this.phones = phones;
	}

	public Integer getIdBrand() {
		return idBrand;
	}

	public void setIdBrand(Integer idBrand) {
		this.idBrand = idBrand;
	}

	public String getNameBrand() {
		return nameBrand;
	}

	public void setNameBrand(String nameBrand) {
		this.nameBrand = nameBrand;
	}

	public Collection<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Collection<Phone> phones) {
		this.phones = phones;
	}

	public static List<Brand> getBrands(SessionFactory factory) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Brand";
		Query query = session.createQuery(hql);
		List<Brand> list = query.list();
		return list;
	}
	
	public static Integer insertBrand(SessionFactory factory, Brand brand) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(brand);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public static Integer checkBrand(SessionFactory factory, String name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Brand B WHERE B.nameBrand =:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		List<Brand> brands = query.list();
		if (brands.isEmpty()) {
			return 0;
		}
		return 1;
	}
	
	public static Integer getID(SessionFactory factory, String name) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT B.idBrand FROM Brand B WHERE B.nameBrand =:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		List<Integer> s=query.list();
		return s.get(0);
	}
}
