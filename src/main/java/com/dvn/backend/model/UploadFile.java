package com.dvn.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="C_IMAGE")
@Component
public class UploadFile {

	@Id
	private String id;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Lob // to store some image files, Large Object
	@Column(name = "FILE_DATA")
	private byte[] data;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
