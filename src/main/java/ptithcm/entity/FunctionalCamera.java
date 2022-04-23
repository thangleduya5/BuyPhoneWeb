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

@Entity @Table(name = "FUNCTIONAL_CAMERA")
public class FunctionalCamera {

	@Id @GeneratedValue @Column(name = "ID_FUNCTIONAL_CAMERA")
	private Integer idFunctionalCamera;
	
	@Column(name = "NAME_FUNCTIONAL_CAMERA")
	private String nameFunctionalCamera;
	
	@OneToMany(mappedBy = "pk.functionalCamera", fetch = FetchType.EAGER)
	private Collection<CameraPhone> cameraPhones;

	public FunctionalCamera() {
		
	}
	
	public FunctionalCamera(Integer idFunctionalCamera, String nameFunctionalCamera,
			Collection<CameraPhone> cameraPhones) {
		super();
		this.idFunctionalCamera = idFunctionalCamera;
		this.nameFunctionalCamera = nameFunctionalCamera;
		this.cameraPhones = cameraPhones;
	}

	public Integer getIdFunctionalCamera() {
		return idFunctionalCamera;
	}

	public void setIdFunctionalCamera(Integer idFunctionalCamera) {
		this.idFunctionalCamera = idFunctionalCamera;
	}

	public String getNameFunctionalCamera() {
		return nameFunctionalCamera;
	}

	public void setNameFunctionalCamera(String nameFunctionalCamera) {
		this.nameFunctionalCamera = nameFunctionalCamera;
	}

	public Collection<CameraPhone> getCameraPhones() {
		return cameraPhones;
	}

	public void setCameraPhones(Collection<CameraPhone> cameraPhones) {
		this.cameraPhones = cameraPhones;
	}

	public static List<FunctionalCamera> getFunctionalCameras(SessionFactory factory) {
		Session session = factory.getCurrentSession();
		String hql = "FROM FunctionalCamera";
		Query query = session.createQuery(hql);
		List<FunctionalCamera> list = query.list();
		return list;
	}
	
	public static FunctionalCamera getFunctionalCamera(SessionFactory factory, String name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM FunctionalCamera F WHERE F.nameFunctionalCamera =:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		List<FunctionalCamera> functionalCameras = query.list();
		return functionalCameras.get(0);
	}
	
	public static FunctionalCamera getFunctionalCamera(SessionFactory factory, int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM FunctionalCamera where idFunctionalCamera = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		FunctionalCamera functionalCamera = (FunctionalCamera) query.list().get(0);
		return functionalCamera;
	}
	
	public static Integer insertFunctionalCamera(SessionFactory factory, FunctionalCamera functionalCamera) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(functionalCamera);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public static Integer updateFunctionalCamera(SessionFactory factory, FunctionalCamera functionalCamera) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(functionalCamera);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
//	public static Integer deleteFunctionalcamera(SessionFactory factory, FunctionalCamera functionalCamera) {
//		Session session = factory.openSession();
//		Transaction t = session.beginTransaction();
//		try {
//			session.delete(functionalCamera);
//			t.commit();
//		} catch (Exception e) {
//			System.out.println(e);
//			t.rollback();
//			return 0;
//		} finally {
//			session.close();
//		}
//		return 1;
//	}
	
	public static Integer deleteFunctionalcamera(SessionFactory factory, FunctionalCamera functionalCamera) {
		Session session = factory.getCurrentSession();
		try {
			session.delete(functionalCamera);
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		} 
		return 1;
	}

	public static Integer checkFunctionalCamera(SessionFactory factory, String name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM FunctionalCamera F WHERE F.nameFunctionalCamera =:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		List<FunctionalCamera> functionalCameras = query.list();
		if (functionalCameras.isEmpty()) {
			return 0;
		}
		return 1;
	}

}
