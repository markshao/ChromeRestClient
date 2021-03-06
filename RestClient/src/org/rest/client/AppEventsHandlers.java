package org.rest.client;

import org.rest.client.analytics.GoogleAnalytics;
import org.rest.client.analytics.GoogleAnalyticsApp;
import org.rest.client.event.SaveRequestEvent;
import org.rest.client.log.Log;
import org.rest.client.ui.SaveRequestDialogView;

import com.google.web.bindery.event.shared.EventBus;

public class AppEventsHandlers {
	
	public static void initialize(final EventBus eventBus){
		
		SaveRequestEvent.register(eventBus, new SaveRequestEvent.Handler() {
			@Override
			public void onSave() {
				if(RestClient.isSaveDialogEnabled) {
					Log.info("Save dialog is currently displayed.");
					return;
				}
				SaveRequestDialogView dialog = RestClient.getClientFactory().getSaveRequestDialogView();
				dialog.show();
				GoogleAnalytics.sendEvent("Engagement", "Click", "Save action initialization");
				GoogleAnalyticsApp.sendEvent("Engagement", "Click", "Save action initialization");
			}
		});
		
	}
	
}
