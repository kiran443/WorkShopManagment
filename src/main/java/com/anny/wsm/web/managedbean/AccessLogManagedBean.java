package com.anny.wsm.web.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.RequestScoped;

import com.anny.wsm.service.AccessLogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anny.wsm.model.AccessLog;
import com.anny.wsm.web.datamodel.AccessLogDataModel;

@Component
@RequestScoped
public class AccessLogManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	final static Logger logger = Logger.getLogger(AccessLogManagedBean.class);

	@Autowired
	AccessLogService accessLogService;

	private List<AccessLog> accessLogList;
	private AccessLogDataModel accessLogDataModel;

	private boolean insertDelete = false;

	public AccessLogService getAccessLogService() {
		return accessLogService;
	}

	public void setAccessLogService(AccessLogService accessLogService) {
		this.accessLogService = accessLogService;
	}

	public List<AccessLog> getAccessLogList() {
		if (accessLogList == null || insertDelete == true) {
			accessLogList = accessLogService.findAll();
		}
		return accessLogList;
	}

	public void setAccessLogList(List<AccessLog> accessLogList) {
		this.accessLogList = accessLogList;
	}

	public AccessLogDataModel getAccessLogDataModel() {

		return new AccessLogDataModel(getAccessLogList());
	}

	public void setAccessLogDataModel(AccessLogDataModel accessLogDataModel) {
		this.accessLogDataModel = accessLogDataModel;
	}

	public boolean isInsertDelete() {
		return insertDelete;
	}

	public void setInsertDelete(boolean insertDelete) {
		this.insertDelete = insertDelete;
	}

}
