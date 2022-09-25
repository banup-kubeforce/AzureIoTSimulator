package com.kubeforce.azureiotsimulator;
import com.microsoft.azure.sdk.iot.device.DeviceClient;

import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageSentCallback;
import com.microsoft.azure.sdk.iot.device.exceptions.IotHubClientException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import java.lang.invoke.MethodHandles;

import java.util.function.Function;

public class SendtoIoTFunction implements Function<PayloadEntity, String> {
    public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Autowired
    private DeviceClient deviceClient;
    Message message=null;
    @Override
    public String apply(PayloadEntity payloadEntity) {
        try {
            deviceClient.open(false);
            deviceClient.sendEventAsync(message, new MessageSentCallback() {
                @Override
                public void onMessageSent(Message message, IotHubClientException e, Object o) {
                    LOGGER.info("IOT Response || STATUS CODE || {}",message.toString());
                }
            }, null);
            deviceClient.close();

        } catch (IotHubClientException e) {
            throw new RuntimeException(e);
        }





        return null;
    }
}
