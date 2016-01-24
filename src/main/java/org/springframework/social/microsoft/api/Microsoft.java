package org.springframework.social.microsoft.api;

import org.springframework.social.microsoft.api.onedrive.OneDriveOperations;

public interface Microsoft {
	
	UserOperations userOperations();
	
	OneDriveOperations oneDriveOperations();
	
}
