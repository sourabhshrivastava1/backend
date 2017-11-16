package com.dvn.backend.dao;

import com.dvn.backend.model.UploadFile;

public interface UploadFileDAO {

	void save(UploadFile uploadFile);

	UploadFile getFile(int Id);
}
