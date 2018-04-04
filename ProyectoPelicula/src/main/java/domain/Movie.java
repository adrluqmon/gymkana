
package domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
//@Access(AccessType.PROPERTY)
public class Movie extends DomainEntity {

	// Constructors
	// ---------------------------------------------------------------------------

	public Movie() {
		super();
	}

	public Movie(final String title, final boolean isAdult, final Date date, final List<String> genres) {
		this.title = title;
		this.isAdult = isAdult;
		this.date = date;
		this.genres = genres;
	}


	// Attributes
	// ---------------------------------------------------------------------------

	private String			title;
	private boolean			isAdult;
	private Date			date;
	private List<String>	genres;


	// Getters and Setters
	// ---------------------------------------------------------------------------

	@NotBlank
	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public boolean getIsAdult() {
		return this.isAdult;
	}

	public void setIsAdult(final boolean isAdult) {
		this.isAdult = isAdult;
	}

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy")
	public Date getDate() {
		return this.date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	@Column
	@ElementCollection(targetClass = String.class)
	public List<String> getGenres() {
		return this.genres;
	}

	public void setGenres(final List<String> genres) {
		this.genres = genres;
	}

}
