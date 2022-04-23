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

@Entity
@Table(name = "RESOLUTION")
public class Resolution {

	@Id
	@GeneratedValue
	@Column(name = "ID_RESOLUTION")
	private Integer idResolution;

	@Column(name = "NAME_RESOLUTION")
	private String nameResolution;

	@OneToMany(mappedBy = "resolution", fetch = FetchType.EAGER)
	private Collection<Screen> screens;

	public Resolution() {

	}

	public Resolution(Integer idResolution, String nameResolution, Collection<Screen> screens) {
		super();
		this.idResolution = idResolution;
		this.nameResolution = nameResolution;
		this.screens = screens;
	}

	public Integer getIdResolution() {
		return idResolution;
	}

	public void setIdResolution(Integer idResolution) {
		this.idResolution = idResolution;
	}

	public String getNameResolution() {
		return nameResolution;
	}

	public void setNameResolution(String nameResolution) {
		this.nameResolution = nameResolution;
	}

	public Collection<Screen> getScreens() {
		return screens;
	}

	public void setScreens(Collection<Screen> screens) {
		this.screens = screens;
	}

	public static List<Resolution> getResolutions(SessionFactory factory) {

		Session session = factory.getCurrentSession();
		String hql = "FROM Resolution";
		Query query = session.createQuery(hql);
		List<Resolution> list = query.list();
		return list;

	}

	public static Integer insertResolution(SessionFactory factory, Resolution resolution) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(resolution);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public static Integer checkResolution(SessionFactory factory, String name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Resolution R WHERE R.nameResolution =:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		List<Resolution> resolutions = query.list();
		if (resolutions.isEmpty()) {
			return 0;
		}
		return 1;
	}
	
	public static Integer getID(SessionFactory factory, String name) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT R.idResolution FROM Resolution R WHERE R.nameResolution =:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		List<Integer> s=query.list();
		return s.get(0);
	}

}
