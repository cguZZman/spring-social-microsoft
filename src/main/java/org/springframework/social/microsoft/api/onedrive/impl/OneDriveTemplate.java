package org.springframework.social.microsoft.api.onedrive.impl;

import java.util.List;
import java.util.Map;

import org.springframework.social.microsoft.api.impl.AbstractMicrosoftOperations;
import org.springframework.social.microsoft.api.impl.MicrosoftTemplate;
import org.springframework.social.microsoft.api.onedrive.OneDriveOperations;
import org.springframework.web.client.RestTemplate;

import com.onedrive.api.OneDrive;
import com.onedrive.api.resource.Drive;
import com.onedrive.api.resource.Item;

public class OneDriveTemplate extends AbstractMicrosoftOperations implements OneDriveOperations {

	private OneDrive oneDrive;
	
	public OneDriveTemplate(MicrosoftTemplate microsoftTemplate, RestTemplate restTemplate, boolean authorized) {
		super(restTemplate, authorized);
		oneDrive = new OneDrive(restTemplate);
	}
	
	@Override
	public Drive getDrive() {
		return oneDrive.drive();
	}

	@Override
	public Drive getDrive(Map<String, String> queryParameters) {
		return oneDrive.drive(queryParameters);
	}

	@Override
	public Drive getDrive(String driveId) {
		return oneDrive.drive(driveId);
	}

	@Override
	public Drive getDrive(String driveId, Map<String, String> queryParameters) {
		return oneDrive.drive(driveId, queryParameters);
	}

	@Override
	public List<Drive> getDrives() {
		return oneDrive.drives();
	}

	@Override
	public List<Drive> getDrives(Map<String, String> queryParameters) {
		return oneDrive.drives(queryParameters);
	}

	@Override
	public Item getItem(String itemId) {
		Item item = new Item(oneDrive);
		item.setId(itemId);
		return item;
	}

}
