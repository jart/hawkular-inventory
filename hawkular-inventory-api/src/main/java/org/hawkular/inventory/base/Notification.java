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
package org.hawkular.inventory.base;

import org.hawkular.inventory.api.Action;

/**
 * Represents a notification to be sent out. I.e. this wraps together the data necessary to sending a new inventory
 * event.
 *
 * @param <C> the type of the action context - i.e. the data describing the action
 * @param <V> the type of the value that the action has been performed upon
 */
public final class Notification<C, V> {
    private final C actionContext;
    private final V value;
    private final Action<C, V> action;

    /**
     * Constructs a new instance.
     *
     * @param actionContext the data describing the results of the action
     * @param value         the value that the action has been performed upon
     * @param action        the action itself
     */
    public Notification(C actionContext, V value, Action<C, V> action) {
        this.actionContext = actionContext;
        this.value = value;
        this.action = action;
    }

    /**
     * @return the action to be notified about
     */
    public Action<C, V> getAction() {
        return action;
    }

    /**
     * @return the data describing the action performed
     */
    public C getActionContext() {
        return actionContext;
    }

    /**
     * @return the value the action has been performed upon
     */
    public V getValue() {
        return value;
    }
}
