package org.gwtbootstrap3.extras.typeahead.client.events;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;
import org.gwtbootstrap3.extras.typeahead.client.ui.Typeahead;

/**
 * Triggered when the dropdown menu of the typeahead is closed.
 *
 * @author Florian Kremser <florian.kremser@sage.com>
 */
public class TypeaheadClosedEvent<T> extends GwtEvent<TypeaheadClosedHandler<T>> {

    public static <T> void fire(final Typeahead<T> source, final Event nativeEvent) {
        TypeaheadClosedEvent<T> event = new TypeaheadClosedEvent<T>(source, nativeEvent);
        source.fireEvent(event);
    }

    private static final Type<TypeaheadClosedHandler<?>> TYPE = new Type<TypeaheadClosedHandler<?>>();

    private final Typeahead<T> typeahead;
    private final Event nativeEvent;

    public static Type<TypeaheadClosedHandler<?>> getType() {
        return TYPE;
    }

    private TypeaheadClosedEvent(final Typeahead<T> typeahead, final Event nativeEvent) {
        this.typeahead = typeahead;
        this.nativeEvent = nativeEvent;
    }

    public Typeahead<T> getTypeahead() {
        return typeahead;
    }

    public Event getNativeEvent() {
        return nativeEvent;
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Type<TypeaheadClosedHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    @Override
    protected void dispatch(final TypeaheadClosedHandler<T> handler) {
        handler.onClosed(this);
    }
}
