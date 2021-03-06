package com.btcc.wsm.web.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.btcc.wsm.model.AccessRights;

public class AccessRightsDataModel extends ListDataModel<AccessRights> implements
		SelectableDataModel<AccessRights> {

	public AccessRightsDataModel() {

	}

	public AccessRightsDataModel(List<AccessRights> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	public AccessRights getRowData(String rowKey) {

		List<AccessRights> accessRightsList = (List<AccessRights>) getWrappedData();
		Integer rowKeyInt = Integer.parseInt(rowKey);
		for (AccessRights accessRights : accessRightsList) {
			if (accessRights.getId() == rowKeyInt) {
				return accessRights;
			}
		}
		return null;
	}

	public Object getRowKey(AccessRights accessRights) {

		return accessRights.getId();
	}
}
