package ptithcm.entity;

import java.util.Collection;
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

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Entity @Table(name = "SCREEN")
public class Screen {
	
	@Id @GeneratedValue @Column(name = "ID_SCREEN")
	private Integer idScreen;
	
	@Column(name = "SIZE_SCREEN")
	private Float sizeScreen;
	
	@OneToMany(mappedBy = "screen", fetch = FetchType.EAGER)
	private Collection<Phone> phones;
	
	@ManyToOne @JoinColumn(name = "ID_TECH_SCREEN")
	private TechScreen techScreen;
	
	@ManyToOne @JoinColumn(name = "ID_RESOLUTION")
	private Resolution resolution;

	public Screen() {
		
	}
	
	public Screen(Integer idScreen, Float sizeScreen, Collection<Phone> phones, TechScreen techScreen,
			Resolution resolution) {
		super();
		this.idScreen = idScreen;
		this.sizeScreen = sizeScreen;
		this.phones = phones;
		this.techScreen = techScreen;
		this.resolution = resolution;
	}

	public Integer getIdScreen() {
		return idScreen;
	}

	public void setIdScreen(Integer idScreen) {
		this.idScreen = idScreen;
	}

	public Float getSizeScreen() {
		return sizeScreen;
	}

	public void setSizeScreen(Float sizeScreen) {
		this.sizeScreen = sizeScreen;
	}

	public Collection<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Collection<Phone> phones) {
		this.phones = phones;
	}

	public TechScreen getTechScreen() {
		return techScreen;
	}

	public void setTechScreen(TechScreen techScreen) {
		this.techScreen = techScreen;
	}

	public Resolution getResolution() {
		return resolution;
	}

	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}
	
	public static List<Screen> getScreens(SessionFactory factory) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Screen";
		Query query = session.createQuery(hql);
		List<Screen> list = query.list();
		System.out.println(list.get(1).getSizeScreen());
		return list;

	}
	
	public static Integer insertScreen(SessionFactory factory, Screen screen) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(screen);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public static Integer checkScreen(SessionFactory factory, Float size, TechScreen techScreen, Resolution resolution) {
		Session session = factory.getCurrentSession();
		System.out.println(size);
		System.out.println(techScreen.getIdTechScreen());
		System.out.println(resolution.getIdResolution());
		String hql = "FROM Screen S WHERE S.sizeScreen = :size AND S.techScreen = :tech AND S.resolution = :resolution";
		Query query = session.createQuery(hql);
		query.setParameter("size", size);
		query.setParameter("tech", techScreen);
		query.setParameter("resolution", resolution);
		List<Screen> screens = query.list();
		if (screens.isEmpty()) {
			System.out.print("Thêm vào nha");
			return 0;
		}
		return 1;
	}
	
	public static Integer getID(SessionFactory factory, Screen s) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT S.idScreen FROM Screen S WHERE S.sizeScreen = :size AND S.techScreen = :tech AND S.resolution = :resolution";
		Query query = session.createQuery(hql);
		query.setParameter("size", Float.valueOf(s.getSizeScreen()));
		query.setParameter("tech", s.getTechScreen());
		query.setParameter("resolution", s.getResolution());
		List<Integer> ss = query.list();
		return ss.get(0);
	}
}
