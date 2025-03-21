package org.gwtbootstrap3.client.ui.base;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
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

public interface HasAutoComplete {
    public static final String AUTO_COMPLETE = "autocomplete";

    /**
     * Sets the auto complete property on the widget
     *
     * @param autocomplete auto complete setting for the widget
     */
    void setAutocomplete(String autocomplete);

    /**
     * Get the auto complete attribute from the widget
     *
     * @return auto complete attribute
     */
    String getAutocomplete();
}
