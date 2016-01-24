package org.springframework.social.microsoft.api.onedrive;

import java.util.List;
import java.util.Map;

import com.onedrive.api.resource.Drive;
import com.onedrive.api.resource.Item;

public interface OneDriveOperations {

	Drive getDrive();
	Drive getDrive(Map<String,String> queryParameters);
	Drive getDrive(String driveId);
	Drive getDrive(String driveId, Map<String,String> queryParameters);
	List<Drive> getDrives();
	List<Drive> getDrives(Map<String,String> queryParameters);
	Item getItem(String itemId);
}
