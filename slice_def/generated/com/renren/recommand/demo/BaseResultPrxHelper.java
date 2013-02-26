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

public final class BaseResultPrxHelper extends Ice.ObjectPrxHelperBase implements BaseResultPrx
{
    public static BaseResultPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        BaseResultPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (BaseResultPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::com::renren::recommand::demo::BaseResult"))
                {
                    BaseResultPrxHelper __h = new BaseResultPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static BaseResultPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        BaseResultPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (BaseResultPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::com::renren::recommand::demo::BaseResult", __ctx))
                {
                    BaseResultPrxHelper __h = new BaseResultPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static BaseResultPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        BaseResultPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::com::renren::recommand::demo::BaseResult"))
                {
                    BaseResultPrxHelper __h = new BaseResultPrxHelper();
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

    public static BaseResultPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        BaseResultPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::com::renren::recommand::demo::BaseResult", __ctx))
                {
                    BaseResultPrxHelper __h = new BaseResultPrxHelper();
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

    public static BaseResultPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        BaseResultPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (BaseResultPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                BaseResultPrxHelper __h = new BaseResultPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static BaseResultPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        BaseResultPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            BaseResultPrxHelper __h = new BaseResultPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _BaseResultDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _BaseResultDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, BaseResultPrx v)
    {
        __os.writeProxy(v);
    }

    public static BaseResultPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            BaseResultPrxHelper result = new BaseResultPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
