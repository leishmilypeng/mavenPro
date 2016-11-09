package com.lp.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TmUserId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TmUserId implements java.io.Serializable {

	// Fields

	private Long userId;

	// Constructors

	/** default constructor */
	public TmUserId() {
	}

	/** full constructor */
	public TmUserId( Long userId) {
		this.userId = userId;
	}

	// Property accessors
	@Column(name = "user_id", nullable = false, precision = 14, scale = 0)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TmUserId))
			return false;
		TmUserId castOther = (TmUserId) other;

		return ( ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId()))));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		return result;
	}

}