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

import java.util.List;

import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.BlankValidatorMixin;
import org.gwtbootstrap3.client.ui.base.mixin.ErrorHandlerMixin;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.InputSize;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandler;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandlerType;
import org.gwtbootstrap3.client.ui.form.error.HasErrorHandler;
import org.gwtbootstrap3.client.ui.form.validator.HasBlankValidator;
import org.gwtbootstrap3.client.ui.form.validator.HasValidators;
import org.gwtbootstrap3.client.ui.form.validator.ValidationChangedEvent.ValidationChangedHandler;
import org.gwtbootstrap3.client.ui.form.validator.Validator;

import com.google.gwt.dom.client.Element;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.text.shared.Parser;
import com.google.gwt.text.shared.Renderer;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class ValueBoxBase<T> extends com.google.gwt.user.client.ui.ValueBoxBase<T> implements HasId, HasReadOnly,
        HasResponsiveness, HasPlaceholder, HasAutoComplete, HasRequired, HasSize<InputSize>, HasEditorErrors<T>,
        HasErrorHandler, HasValidators<T>, HasBlankValidator<T> {

    private static final String MAX_LENGTH = "maxlength";

    private final IdMixin<ValueBoxBase<T>> idMixin = new IdMixin<ValueBoxBase<T>>(this);

    private final ErrorHandlerMixin<T> errorHandlerMixin = new ErrorHandlerMixin<T>(this);

    private final BlankValidatorMixin<ValueBoxBase<T>, T> validatorMixin = new BlankValidatorMixin<ValueBoxBase<T>, T>(this,
        errorHandlerMixin.getErrorHandler());

    /**
     * Creates a value box that wraps the given browser element handle. This is only used by subclasses.
     *
     * @param elem the browser element to wrap
     */
    protected ValueBoxBase(final Element elem, final Renderer<T> renderer, final Parser<T> parser) {
        super(elem, renderer, parser);
    }

    public void setMaxLength(final int maxLength) {
        getElement().setAttribute(MAX_LENGTH, Integer.toString(maxLength));
    }

    @Override
    public void setPlaceholder(final String placeHolder) {
        getElement().setAttribute(PLACEHOLDER, placeHolder != null ? placeHolder : "");
    }

    @Override
    public String getPlaceholder() {
        return getElement().getAttribute(PLACEHOLDER);
    }

    @Override
    public void setAutocomplete(final String autocomplete) {
        getElement().setAttribute(AUTO_COMPLETE, autocomplete);
    }

    @Override
    public String getAutocomplete() {
        return getElement().getAttribute(AUTO_COMPLETE);
    }

    @Override
    public void setId(final String id) {
        idMixin.setId(id);
    }

    @Override
    public String getId() {
        return idMixin.getId();
    }

    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    @Override
    public void setSize(InputSize size) {
        StyleHelper.addUniqueEnumStyleName(this, InputSize.class, size);
    }

    @Override
    public InputSize getSize() {
        return InputSize.fromStyleName(getStyleName());
    }

    /** {@inheritDoc} */
    @Override
    public void setValue(T value, boolean fireEvents) {
        errorHandlerMixin.clearErrors();
        super.setValue(value, fireEvents);
    }

    /** {@inheritDoc} */
    @Override
    public void showErrors(List<EditorError> errors) {
        errorHandlerMixin.showErrors(errors);
    }

    /** {@inheritDoc} */
    @Override
    public ErrorHandler getErrorHandler() {
        return errorHandlerMixin.getErrorHandler();
    }

    /** {@inheritDoc} */
    @Override
    public void setErrorHandler(ErrorHandler handler) {
        errorHandlerMixin.setErrorHandler(handler);
        validatorMixin.setErrorHandler(handler);
    }

    /** {@inheritDoc} */
    @Override
    public ErrorHandlerType getErrorHandlerType() {
        return errorHandlerMixin.getErrorHandlerType();
    }

    /** {@inheritDoc} */
    @Override
    public void setErrorHandlerType(ErrorHandlerType type) {
        errorHandlerMixin.setErrorHandlerType(type);
    }

    @Override
    public void setAllowBlank(boolean allowBlank) {
        validatorMixin.setAllowBlank(allowBlank);
    }

    @Override
    public boolean getAllowBlank() {
        return validatorMixin.getAllowBlank();
    }

    @Override
    public void addValidator(Validator<T> validator) {
        validatorMixin.addValidator(validator);
    }
    
    /** {@inheritDoc} */
    @Override
    public boolean removeValidator(Validator<T> validator) {
        return validatorMixin.removeValidator(validator);
    }

    @Override
    public boolean getValidateOnBlur() {
        return validatorMixin.getValidateOnBlur();
    }

    @Override
    public void setValidateOnBlur(boolean validateOnBlur) {
        validatorMixin.setValidateOnBlur(validateOnBlur);
    }

    @Override
    public void setValidators(@SuppressWarnings("unchecked") Validator<T>... validators) {
        validatorMixin.setValidators(validators);
    }

    @Override
    public boolean validate() {
        return validatorMixin.validate();
    }

    @Override
    public boolean validate(boolean show) {
        return validatorMixin.validate(show);
    }

    @Override
    public void reset() {
        setValue(null);
        validatorMixin.reset();
    }

    @Override
    public HandlerRegistration addValidationChangedHandler(ValidationChangedHandler handler) {
        return validatorMixin.addValidationChangedHandler(handler);
    }

    @Override
    public void setRequired(boolean required) {
        if (required) {
            getElement().setAttribute(HasRequired.REQUIRED, HasRequired.REQUIRED);
        } else {
            getElement().removeAttribute(HasRequired.REQUIRED);
        }
    }

    @Override
    public boolean getRequired() {
        return getElement().hasAttribute(HasRequired.REQUIRED);
    }
}
