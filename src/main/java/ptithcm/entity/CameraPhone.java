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
@Table(name = "CAMERA_PHONE")
@AssociationOverrides({
    @AssociationOverride(name = "pk.functionalCamera", 
        joinColumns = @JoinColumn(name = "ID_FUNCTIONAL_CAMERA")),
    @AssociationOverride(name = "pk.phone", 
        joinColumns = @JoinColumn(name = "ID_PHONE")) })
public class CameraPhone {

	@EmbeddedId CameraPhonePK pk;
	

	public CameraPhone() {
		
	}
	
	public CameraPhone(CameraPhonePK pk) {
		super();
		this.pk = pk;
	}

	public CameraPhonePK getPk() {
		return pk;
	}

	public void setPk(CameraPhonePK pk) {
		this.pk = pk;
	}
	
	public static List<CameraPhone> getCameraPhones(SessionFactory factory,String idPhone) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CameraPhone C WHERE C.pk.phone.idPhone =:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", idPhone);
		List<CameraPhone> list = query.list();
		return list;
	}
	
	public static Integer insertCameraPhone(SessionFactory factory, CameraPhone cameraPhone) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(cameraPhone);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public static Integer deleteCameraPhone(SessionFactory factory, String idPhone) {
		Session session = factory.getCurrentSession();
		try {
			System.out.println("đang xóa");
			String hql = "DELETE FROM CameraPhone C WHERE C.pk.phone.idPhone =:id";
			Query query = session.createQuery(hql);
			query.setParameter("id", idPhone);
			query.executeUpdate();
			System.out.println("xóa xong");
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

//	public static Integer checkCameraPhone(SessionFactory factory, String name) {
//		Session session = factory.getCurrentSession();
//		String hql = "FROM CameraPhone C WHERE C.nameCameraPhone =:name";
//		Query query = session.createQuery(hql);
//		query.setParameter("name", name);
//		List<CameraPhone> cameraPhones = query.list();
//		if (cameraPhones.isEmpty()) {
//			return 0;
//		}
//		return 1;
//	}
	
	public static List<String> getPhoneCameras(SessionFactory factory, int idFunctionalCamera){
		Session session = factory.getCurrentSession();
		String hql = "SELECT C.pk.phone.idPhone FROM CameraPhone C WHERE C.pk.functionalCamera.idFunctionalCamera =:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", idFunctionalCamera);
		List<String> list = query.list();
		return list;
	}
	
}
