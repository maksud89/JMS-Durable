/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2012
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.ericsson;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;

@MessageDriven(name = "HelloWorldQueueMDB", activationConfig = {
@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
@ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/myTestTopic"),
@ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
@ActivationConfigProperty(propertyName="clientID", propertyValue = "durable-client"),
@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class AnotherConsumer implements MessageListener{
	 private final static Logger LOGGER = Logger.getLogger(AnotherConsumer.class.toString());

	    /**
	     * @see MessageListener#onMessage(Message)
	     */
	    public void onMessage(Message rcvMessage) {
	        TextMessage msg = null;
	        try {
	            if (rcvMessage instanceof TextMessage) {
	                msg = (TextMessage) rcvMessage;
	                LOGGER.info("Another Consumer also Received Message from queue: " + msg.getText());
	            } else {
	                LOGGER.warning("Message of wrong type: " + rcvMessage.getClass().getName());
	            }
	        } catch (JMSException e) {
	            throw new RuntimeException(e);
	        }
	    }

}
