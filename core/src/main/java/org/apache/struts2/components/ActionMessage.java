/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.struts2.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.commons.lang.xwork.StringUtils;

import com.opensymphony.xwork2.util.ValueStack;

import java.util.List;
import java.util.Collection;

/**
 * <!-- START SNIPPET: javadoc -->
 *
 * Render action messages if they exists, specific rendering layout depends on the
 * theme itself. Empty (null or blank string) messages will not be printed.
 *
 * <!-- END SNIPPET: javadoc -->
 *
 * <p/> <b>Examples</b>
 *
 * <pre>
 * <!-- START SNIPPET: example -->
 *    &lt;s:actionmessage /&gt;
 *    &lt;s:form .... &gt;
 *       ....
 *    &lt;/s:form&gt;
 * <!-- END SNIPPET: example -->
 * </pre>
 *
 */
@StrutsTag(name="actionmessage", tldBodyContent="empty", tldTagClass="org.apache.struts2.views.jsp.ui.ActionMessageTag", description="Render action messages if they exists")
public class ActionMessage extends UIBean {

    private static final String TEMPLATE = "actionmessage";

    public ActionMessage(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    protected void evaluateExtraParams() {
        boolean isEmptyList = true;
        Collection<String> actionMessages = (List) findValue("actionMessages");
        if (actionMessages != null) {
            for (String message : actionMessages) {
                if (StringUtils.isNotBlank(message)) {
                    isEmptyList = false;
                    break;
                }
            }
        }

        addParameter("isEmptyList", isEmptyList);
    }
}
