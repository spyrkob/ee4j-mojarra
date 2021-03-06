/*
 * Copyright (c) 2011, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.faces.test.javaee6web.injectartifacts;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ActionListener;
import javax.faces.event.ActionListenerWrapper;

public class FacesConfigActionListener extends ActionListenerWrapper implements ActionListener {

    private ActionListener wrapped;

    public FacesConfigActionListener(ActionListener wrapped) {
        this.wrapped = wrapped;
    }

    private String postConstructCalled;

    @PostConstruct
    private void doPostConstruct() {
        postConstructCalled = "@PostConstruct called";

    }

    @Override
    public ActionListener getWrapped() {
        return this.wrapped;
    }

    @Resource(name = "injectedMessage")
    private String injectedMessage;

    public String getInjectedMessage() {
        return injectedMessage + " " + postConstructCalled;
    }
}
