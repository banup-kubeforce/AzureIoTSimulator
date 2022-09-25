package com.kubeforce.azureiotsimulator;

import com.microsoft.azure.sdk.iot.device.DeviceClient;
import com.microsoft.azure.sdk.iot.device.IotHubClientProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URISyntaxException;

@Configuration
public class IOTConfiguration {
	
	
	@Bean
	public DeviceClient deviceClient(@Value("${iot.connection.string}") String connString) throws URISyntaxException {
		return new DeviceClient(connString, IotHubClientProtocol.HTTPS);
	}

}
