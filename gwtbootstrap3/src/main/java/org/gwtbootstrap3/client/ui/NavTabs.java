package org.gwtbootstrap3.client.ui;

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

import com.google.gwt.aria.client.OrientationValue;
import com.google.gwt.aria.client.Roles;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 * @see AnchorListItem
 */
public class NavTabs extends Nav {

    public NavTabs() {
        addStyleName(Styles.NAV_TABS);
        // Nav tab should not receive focus, only the individual active tab should
        getElement().setAttribute("tabindex", "-1");
        Roles.getTablistRole().set(getElement());
    }

    public void setAriaOrientation(OrientationValue orientation) {
        Roles.getScrollbarRole().setAriaOrientationProperty(getElement(), orientation);
    }
}
