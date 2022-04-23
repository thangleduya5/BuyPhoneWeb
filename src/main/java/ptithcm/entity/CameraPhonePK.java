package ptithcm.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CameraPhonePK implements Serializable{
	
	@ManyToOne 
	private FunctionalCamera functionalCamera;
	
	@ManyToOne 
	private Phone phone;

	public CameraPhonePK() {
		
	}
	
	public CameraPhonePK(FunctionalCamera functionalCamera, Phone phone) {
		super();
		this.functionalCamera = functionalCamera;
		this.phone = phone;
	}

	public FunctionalCamera getFunctionalCamera() {
		return functionalCamera;
	}

	public void setFunctionalCamera(FunctionalCamera functionalCamera) {
		this.functionalCamera = functionalCamera;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	
	
}
