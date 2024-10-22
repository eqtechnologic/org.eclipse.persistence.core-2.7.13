/*
 * Copyright (c) 1998, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.internal.sessions.coordination.corba.sun;

import java.util.Hashtable;

import org.omg.CORBA.BAD_OPERATION;
import org.omg.CORBA.CompletionStatus;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

/**
* org/eclipse/persistence/internal/remotecommand/corba/sun/_SunCORBAConnectionImplBase.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from rcm.idl
* Tuesday, March 30, 2004 2:00:14 PM EST
*/
public abstract class _SunCORBAConnectionImplBase extends ObjectImpl implements SunCORBAConnection, InvokeHandler {
    // Constructors
    public _SunCORBAConnectionImplBase() {
    }

    private static Hashtable _methods = new Hashtable();

    static {
        _methods.put("executeCommand", Integer.valueOf(0));
    }

    public org.omg.CORBA.portable.OutputStream _invoke(String $method, InputStream in, ResponseHandler $rh) {
        OutputStream out = null;
        Integer __method = (Integer) _methods.get($method);
        if (__method == null) {
            throw new BAD_OPERATION(0, CompletionStatus.COMPLETED_MAYBE);
        }

        switch (__method.intValue()) {
        case 0:// org/eclipse/persistence/internal/remotecommand/corba/sun/SunCORBAConnection/executeCommand
         {
            byte[] commandData = org.eclipse.persistence.internal.sessions.coordination.corba.sun.CommandDataHelper.read(in);
            byte[] $result = null;
            $result = this.executeCommand(commandData);
            out = $rh.createReply();
            org.eclipse.persistence.internal.sessions.coordination.corba.sun.CommandDataHelper.write(out, $result);
            break;
        }
        default:
            throw new BAD_OPERATION(0, CompletionStatus.COMPLETED_MAYBE);
        }

        return out;
    }
    // _invoke

    // Type-specific CORBA::Object operations
    private static String[] __ids = { "IDL:org/eclipse/persistence/internal/remotecommand/corba/sun/SunCORBAConnection:1.0" };

    public String[] _ids() {
        return __ids.clone();
    }
}// class _SunCORBAConnectionImplBase
