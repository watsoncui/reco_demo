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

public final class UserProfilePrxHelper extends Ice.ObjectPrxHelperBase implements UserProfilePrx
{
    public static UserProfilePrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        UserProfilePrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (UserProfilePrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::com::renren::recommand::demo::UserProfile"))
                {
                    UserProfilePrxHelper __h = new UserProfilePrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static UserProfilePrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        UserProfilePrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (UserProfilePrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::com::renren::recommand::demo::UserProfile", __ctx))
                {
                    UserProfilePrxHelper __h = new UserProfilePrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static UserProfilePrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        UserProfilePrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::com::renren::recommand::demo::UserProfile"))
                {
                    UserProfilePrxHelper __h = new UserProfilePrxHelper();
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

    public static UserProfilePrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        UserProfilePrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::com::renren::recommand::demo::UserProfile", __ctx))
                {
                    UserProfilePrxHelper __h = new UserProfilePrxHelper();
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

    public static UserProfilePrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        UserProfilePrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (UserProfilePrx)__obj;
            }
            catch(ClassCastException ex)
            {
                UserProfilePrxHelper __h = new UserProfilePrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static UserProfilePrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        UserProfilePrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            UserProfilePrxHelper __h = new UserProfilePrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _UserProfileDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _UserProfileDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, UserProfilePrx v)
    {
        __os.writeProxy(v);
    }

    public static UserProfilePrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            UserProfilePrxHelper result = new UserProfilePrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
