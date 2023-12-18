package com.orderInventory.entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Stores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeId;
	private String storeName;
	private String webAddress;
	private String physicalAddress;
	
	@Column(name="latitude", precision = 9, scale = 6)
	private BigDecimal latitude;
	
	@Column(name="longitude", precision = 9, scale = 6)
	private BigDecimal longitude;
	
	private String logoMimeType;
	private String logoFileName;
	private String logoCharset;
	private Date logoLastUpdated;

}
