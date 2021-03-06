/*
 * Copyright 2005 JBoss Inc
 *
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
 */

package org.drools.eclipse.flow.ruleflow.view.property.exceptionHandler;

import java.util.Map;

import org.drools.eclipse.flow.common.view.property.BeanDialogCellEditor;
import org.drools.eclipse.flow.common.view.property.EditBeanDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.jbpm.process.core.context.exception.ActionExceptionHandler;
import org.kie.definition.process.Process;

/**
 * Cell edtior for exception handlers.
 */
public class ExceptionHandlersCellEditor extends BeanDialogCellEditor<Map<String, ActionExceptionHandler>> {

    private Process process;

    public ExceptionHandlersCellEditor(Composite parent, Process process) {
        super(parent);
        this.process = process;
    }

    protected EditBeanDialog<Map<String, ActionExceptionHandler>> createDialog(Shell shell) {
        return new ExceptionHandlersDialog(shell, process);
    }

    @SuppressWarnings("unchecked")
    protected String getLabelText(Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Map) {
            return ((Map<String, ActionExceptionHandler>) value).keySet().toString();
        }
        return value.toString();
    }

}
