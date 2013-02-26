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

public final class RecommandResultPrxHelper extends Ice.ObjectPrxHelperBase implements RecommandResultPrx
{
    public static RecommandResultPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        RecommandResultPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (RecommandResultPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::com::renren::recommand::demo::RecommandResult"))
                {
                    RecommandResultPrxHelper __h = new RecommandResultPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RecommandResultPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        RecommandResultPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (RecommandResultPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::com::renren::recommand::demo::RecommandResult", __ctx))
                {
                    RecommandResultPrxHelper __h = new RecommandResultPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RecommandResultPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        RecommandResultPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::com::renren::recommand::demo::RecommandResult"))
                {
                    RecommandResultPrxHelper __h = new RecommandResultPrxHelper();
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

    public static RecommandResultPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        RecommandResultPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::com::renren::recommand::demo::RecommandResult", __ctx))
                {
                    RecommandResultPrxHelper __h = new RecommandResultPrxHelper();
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

    public static RecommandResultPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        RecommandResultPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (RecommandResultPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                RecommandResultPrxHelper __h = new RecommandResultPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static RecommandResultPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        RecommandResultPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            RecommandResultPrxHelper __h = new RecommandResultPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _RecommandResultDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _RecommandResultDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RecommandResultPrx v)
    {
        __os.writeProxy(v);
    }

    public static RecommandResultPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            RecommandResultPrxHelper result = new RecommandResultPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
