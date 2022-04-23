package ptithcm.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class FeaturePhonePK implements Serializable {

	@ManyToOne
	private SpecialFeature specialFeature;

	@ManyToOne
	private Phone phone;

	public FeaturePhonePK() {

	}

	public FeaturePhonePK(SpecialFeature specialFeature, Phone phone) {
		super();
		this.specialFeature = specialFeature;
		this.phone = phone;
	}

	public SpecialFeature getSpecialFeature() {
		return specialFeature;
	}

	public void setSpecialFeature(SpecialFeature specialFeature) {
		this.specialFeature = specialFeature;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

}
