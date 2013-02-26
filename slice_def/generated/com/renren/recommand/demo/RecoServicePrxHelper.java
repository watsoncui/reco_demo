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

public final class RecoServicePrxHelper extends Ice.ObjectPrxHelperBase implements RecoServicePrx
{
    public RecommandResult
    getRecommandation(long userPhoneNumber)
    {
        return getRecommandation(userPhoneNumber, null, false);
    }

    public RecommandResult
    getRecommandation(long userPhoneNumber, java.util.Map<String, String> __ctx)
    {
        return getRecommandation(userPhoneNumber, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private RecommandResult
    getRecommandation(long userPhoneNumber, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("getRecommandation");
                __delBase = __getDelegate(false);
                _RecoServiceDel __del = (_RecoServiceDel)__delBase;
                return __del.getRecommandation(userPhoneNumber, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex, null);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    public static RecoServicePrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        RecoServicePrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (RecoServicePrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::com::renren::recommand::demo::RecoService"))
                {
                    RecoServicePrxHelper __h = new RecoServicePrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RecoServicePrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        RecoServicePrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (RecoServicePrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::com::renren::recommand::demo::RecoService", __ctx))
                {
                    RecoServicePrxHelper __h = new RecoServicePrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RecoServicePrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        RecoServicePrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::com::renren::recommand::demo::RecoService"))
                {
                    RecoServicePrxHelper __h = new RecoServicePrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static RecoServicePrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        RecoServicePrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::com::renren::recommand::demo::RecoService", __ctx))
                {
                    RecoServicePrxHelper __h = new RecoServicePrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static RecoServicePrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        RecoServicePrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (RecoServicePrx)__obj;
            }
            catch(ClassCastException ex)
            {
                RecoServicePrxHelper __h = new RecoServicePrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static RecoServicePrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        RecoServicePrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            RecoServicePrxHelper __h = new RecoServicePrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _RecoServiceDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _RecoServiceDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RecoServicePrx v)
    {
        __os.writeProxy(v);
    }

    public static RecoServicePrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            RecoServicePrxHelper result = new RecoServicePrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
