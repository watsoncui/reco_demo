// **********************************************************************
//
// Copyright (c) 2003-2009 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.3.1

package com.renren.recommand.demo;

public interface RecoServicePrx extends Ice.ObjectPrx
{
    public RecommandResult getRecommandation(long userPhoneNumber);
    public RecommandResult getRecommandation(long userPhoneNumber, java.util.Map<String, String> __ctx);
}
