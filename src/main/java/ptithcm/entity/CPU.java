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

@Entity @Table(name = "CPU")
public class CPU {

	@Id @GeneratedValue @Column(name = "ID_CPU")
	private Integer idCPU;
	
	@Column(name = "NAME_CPU")
	private String nameCPU;
	
	@Column(name = "SPEED_CPU")
	private Integer speedCPU;
	
	@OneToMany(mappedBy = "cpu", fetch = FetchType.EAGER)
	private Collection<Phone> phones;
	
	public CPU() {
		
	}

	public CPU(Integer idCPU, String nameCPU, Integer speedCPU, Collection<Phone> phones) {
		super();
		this.idCPU = idCPU;
		this.nameCPU = nameCPU;
		this.speedCPU = speedCPU;
		this.phones = phones;
	}

	public Integer getIdCPU() {
		return idCPU;
	}

	public void setIdCPU(Integer idCPU) {
		this.idCPU = idCPU;
	}

	public String getNameCPU() {
		return nameCPU;
	}

	public void setNameCPU(String nameCPU) {
		this.nameCPU = nameCPU;
	}

	public Integer getSpeedCPU() {
		return speedCPU;
	}

	public void setSpeedCPU(Integer speedCPU) {
		this.speedCPU = speedCPU;
	}

	public Collection<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Collection<Phone> phones) {
		this.phones = phones;
	}
	
	public static List<CPU> getCPUs(SessionFactory factory) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CPU";
		Query query = session.createQuery(hql);
		List<CPU> list = query.list();
		return list;

	}
	
	public static Integer insertCPU(SessionFactory factory, CPU cpu) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(cpu);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public static Integer checkCPU(SessionFactory factory, CPU cpu) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CPU C WHERE C.nameCPU =:name AND C.speedCPU =:speed";
		Query query = session.createQuery(hql);
		query.setParameter("name", cpu.getNameCPU());
		query.setParameter("speed", cpu.getSpeedCPU());
		List<CPU> cpus = query.list();
		if (cpus.isEmpty()) {
			return 0;
		}
		return 1;
	}
	
	public static Integer getID(SessionFactory factory, String name, Integer speed) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT C.idCPU FROM CPU C WHERE C.nameCPU =:name AND C.speedCPU =:speed";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		query.setParameter("speed", speed);
		List<Integer> s=query.list();
		return s.get(0);
	}
}
