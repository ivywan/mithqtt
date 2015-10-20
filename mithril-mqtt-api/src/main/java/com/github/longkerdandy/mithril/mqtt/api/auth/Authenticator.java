package com.github.longkerdandy.mithril.mqtt.api.auth;

import io.netty.handler.codec.mqtt.MqttSubAckReturnCode;
import io.netty.handler.codec.mqtt.MqttTopicSubscription;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Authenticator
 */
@SuppressWarnings("unused")
public interface Authenticator {

    /**
     * Authorize client CONNECT
     *
     * @param clientId Client Id
     * @param userName User Name
     * @param password Password
     * @return Authorize Result
     */
    CompletableFuture<AuthorizeResult> authConnectAsync(String clientId, String userName, String password);

    /**
     * Authorize client PUBLISH
     *
     * @param clientId  Client Id
     * @param userName  User Name
     * @param topicName Topic Name
     * @param qos       QoS
     * @param retain    Retain
     * @return Authorize Result
     */
    CompletableFuture<AuthorizeResult> authPublishAsync(String clientId, String userName, String topicName, int qos, boolean retain);

    /**
     * Authorize client SUBSCRIBE
     *
     * @param clientId             Client Id
     * @param userName             User Name
     * @param requestSubscriptions List of request Topic Subscription
     * @return List of granted QoS
     */
    CompletableFuture<List<MqttSubAckReturnCode>> authSubscribeAsync(String clientId, String userName, List<MqttTopicSubscription> requestSubscriptions);
}