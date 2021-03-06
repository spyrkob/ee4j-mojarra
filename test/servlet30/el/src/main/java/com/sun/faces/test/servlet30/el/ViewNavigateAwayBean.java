/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
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

package com.sun.faces.test.servlet30.el;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * A ViewScoped bean testing navigate away functionality.
 */
@ManagedBean(name = "viewNavigateAwayBean")
@ViewScoped
public class ViewNavigateAwayBean {

    /**
     * Stores the text.
     */
    private String text;

    /**
     * Constructor.
     */
    public ViewNavigateAwayBean() {
        this.text = "This is from the constructor";
    }

    /**
     * Post-construct.
     *
     */
    @PostConstruct
    public void init() {
        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().remove("navigatedAway");
        this.text = "This is from the @PostConstruct";
    }

    /**
     * Pre-destroy
     */
    @PreDestroy
    public void destroy() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("navigatedAway", true);
        }
    }

    /**
     * Get the text.
     */
    public String getText() {
        return this.text;
    }
}
