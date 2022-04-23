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

@Entity @Table(name = "TECH_SCREEN")
public class TechScreen {

	@Id @GeneratedValue @Column(name = "ID_TECH_SCREEN")
	private Integer idTechScreen;
	
	@Column(name = "NAME_TECH_SCREEN")
	private String nameTechScreen;
	
	@OneToMany(mappedBy = "techScreen", fetch = FetchType.EAGER)
	private Collection<Screen> screens;

	public TechScreen() {
		
	}
	
	public TechScreen(Integer idTechScreen, String nameTechScreen, Collection<Screen> screens) {
		super();
		this.idTechScreen = idTechScreen;
		this.nameTechScreen = nameTechScreen;
		this.screens = screens;
	}

	public Integer getIdTechScreen() {
		return idTechScreen;
	}

	public void setIdTechScreen(Integer idTechScreen) {
		this.idTechScreen = idTechScreen;
	}

	public String getNameTechScreen() {
		return nameTechScreen;
	}

	public void setNameTechScreen(String nameTechScreen) {
		this.nameTechScreen = nameTechScreen;
	}

	public Collection<Screen> getScreens() {
		return screens;
	}

	public void setScreens(Collection<Screen> screens) {
		this.screens = screens;
	}
	
	public static List<TechScreen> getTechScreens(SessionFactory factory) {

		Session session = factory.getCurrentSession();
		String hql = "FROM TechScreen";
		Query query = session.createQuery(hql);
		List<TechScreen> list = query.list();
		return list;

	}
	
	public static Integer insertTechScreen(SessionFactory factory, TechScreen techScreen) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(techScreen);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public static Integer checkTechScreen(SessionFactory factory, String name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM TechScreen T WHERE T.nameTechScreen =:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		List<TechScreen> techScreens = query.list();
		if (techScreens.isEmpty()) {
			return 0;
		}
		return 1;
	}

	public static Integer getID(SessionFactory factory, String name) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT T.idTechScreen FROM TechScreen T WHERE T.nameTechScreen =:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		List<Integer> s=query.list();
		return s.get(0);
	}

}

