package com.group.company.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class UserProfile {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String qualification;
	private String interest;
	private String linkedInURL;
	
	public UserProfile() {
		super();
	}
	public UserProfile(int id, String name, String qualification, String interest, String linkedInURL) {
		super();
		this.id = id;
		this.name = name;
		this.qualification = qualification;
		this.interest = interest;
		this.linkedInURL = linkedInURL;
	}
	public UserProfile(String name, String qualification, String interest, String linkedInURL) {
		super();
		this.name = name;
		this.qualification = qualification;
		this.interest = interest;
		this.linkedInURL = linkedInURL;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getLinkedInURL() {
		return linkedInURL;
	}
	public void setLinkedInURL(String linkedInURL) {
		this.linkedInURL = linkedInURL;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((interest == null) ? 0 : interest.hashCode());
		result = prime * result + ((linkedInURL == null) ? 0 : linkedInURL.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((qualification == null) ? 0 : qualification.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		if (id != other.id)
			return false;
		if (interest == null) {
			if (other.interest != null)
				return false;
		} else if (!interest.equals(other.interest))
			return false;
		if (linkedInURL == null) {
			if (other.linkedInURL != null)
				return false;
		} else if (!linkedInURL.equals(other.linkedInURL))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (qualification == null) {
			if (other.qualification != null)
				return false;
		} else if (!qualification.equals(other.qualification))
			return false;
		return true;
	}
	
	
}
