package model;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "ads")
@Component
@Scope("session")
public class Ad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Ad")
	private long idAd;

	private String title;

	@Column(name = "text_Description")
	private String textDescription;

	@Column(name = "date_Adding")
	@Type(type = "date")
	private Date dateAdding;

	@Column(name = "time_Adding")
	@Type(type = "time")
	private Time timeAdding;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_User", nullable = true)
	private User idUser;

	private byte[] image;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Ad() {
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDateAdding() {
		return dateAdding;
	}

	public void setDateAdding(Date dateAdding) {
		this.dateAdding = dateAdding;
	}

	public Time getTimeAdding() {
		return timeAdding;
	}

	public void setTimeAdding(Time timeAdding) {
		this.timeAdding = timeAdding;
	}

	public Ad(long idAd, String title, String textDescription, Date dateAdding, Time timeAdding, User idUser,
			byte[] image) {
		this.idAd = idAd;
		this.title = title;
		this.textDescription = textDescription;
		this.dateAdding = dateAdding;
		this.timeAdding = timeAdding;
		this.idUser = idUser;
		this.image = image;
	}

	public long getIdAd() {
		return idAd;
	}

	public void setIdAd(long idAd) {
		this.idAd = idAd;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateAdding == null) ? 0 : dateAdding.hashCode());
		result = prime * result + (int) (idAd ^ (idAd >>> 32));
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((textDescription == null) ? 0 : textDescription.hashCode());
		result = prime * result + ((timeAdding == null) ? 0 : timeAdding.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Ad other = (Ad) obj;
		if (dateAdding == null) {
			if (other.dateAdding != null)
				return false;
		} else if (!dateAdding.equals(other.dateAdding))
			return false;
		if (idAd != other.idAd)
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (!Arrays.equals(image, other.image))
			return false;
		if (textDescription == null) {
			if (other.textDescription != null)
				return false;
		} else if (!textDescription.equals(other.textDescription))
			return false;
		if (timeAdding == null) {
			if (other.timeAdding != null)
				return false;
		} else if (!timeAdding.equals(other.timeAdding))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ad [idAd=" + idAd + ", title=" + title + ", textDescription=" + textDescription + ", dateAdding="
				+ dateAdding + ", timeAdding=" + timeAdding + ", idUser=" + idUser + ", image=" + Arrays.toString(image)
				+ "]";
	}

}
