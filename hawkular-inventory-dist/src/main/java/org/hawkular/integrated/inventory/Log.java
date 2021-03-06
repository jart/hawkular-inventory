/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.integrated.inventory;

import org.jboss.logging.Logger;
import org.jboss.logging.annotations.Cause;
import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageLogger;
import org.jboss.logging.annotations.ValidIdRange;

/**
 * @author Lukas Krejci
 * @since 0.0.2
 */
@MessageLogger(projectCode = "HAWKINV")
@ValidIdRange(min = 3000, max = 3499)
public interface Log {

    Log LOGGER = Logger.getMessageLogger(Log.class, "org.hawkular.integration.inventory");

    @LogMessage(level = Logger.Level.INFO)
    @Message(id = 3000, value = "Bus Integration initialization failed. Inventory will not notify about changes on " +
            "the Hawkular message bus.")
    void busInitializationFailed(@Cause Throwable cause);

    @LogMessage(level = Logger.Level.INFO)
    @Message(id = 3001, value = "HACK ALERT: Auto-created the %s '%s' for newly created tenant '%s'.")
    void autoCreatedEntity(String entityType, String entityId, String tenantId);

    @LogMessage(level = Logger.Level.INFO)
    @Message(id = 3002, value = "HACK ALERT: Failed to auto-create tenant metadata. This is most probably due to it" +
            " being already created in parallel.")
    void failedToAutoCreateEntities(@Cause Throwable cause);

    @LogMessage(level = Logger.Level.INFO)
    @Message(id = 3003, value = "Bus integration succeeded.") void busInitializationSuccess();

    @LogMessage(level = Logger.Level.INFO)
    @Message(id = 3004, value = "HACK ALERT: Automatically associated feed '%s' with the test environment.")
    void autoAssociatedFeed(String feedId);
}
