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

public class BaseResult extends Ice.ObjectImpl
{
    public BaseResult()
    {
    }

    public BaseResult(boolean success, RecoErrorCodeEnum errorCode, String errorMessage)
    {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private static class __F implements Ice.ObjectFactory
    {
        public Ice.Object
        create(String type)
        {
            assert(type.equals(ice_staticId()));
            return new BaseResult();
        }

        public void
        destroy()
        {
        }
    }
    private static Ice.ObjectFactory _factory = new __F();

    public static Ice.ObjectFactory
    ice_factory()
    {
        return _factory;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::com::renren::recommand::demo::BaseResult"
    };

    public boolean
    ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean
    ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[]
    ice_ids()
    {
        return __ids;
    }

    public String[]
    ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String
    ice_id()
    {
        return __ids[1];
    }

    public String
    ice_id(Ice.Current __current)
    {
        return __ids[1];
    }

    public static String
    ice_staticId()
    {
        return __ids[1];
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeTypeId(ice_staticId());
        __os.startWriteSlice();
        __os.writeBool(success);
        errorCode.__write(__os);
        __os.writeString(errorMessage);
        __os.endWriteSlice();
        super.__write(__os);
    }

    public void
    __read(IceInternal.BasicStream __is, boolean __rid)
    {
        if(__rid)
        {
            __is.readTypeId();
        }
        __is.startReadSlice();
        success = __is.readBool();
        errorCode = RecoErrorCodeEnum.__read(__is);
        errorMessage = __is.readString();
        __is.endReadSlice();
        super.__read(__is, true);
    }

    public void
    __write(Ice.OutputStream __outS)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type com::renren::recommand::demo::BaseResult was not generated with stream support";
        throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type com::renren::recommand::demo::BaseResult was not generated with stream support";
        throw ex;
    }

    public boolean success;

    public boolean
    getSuccess()
    {
        return success;
    }

    public void
    setSuccess(boolean _success)
    {
        success = _success;
    }

    public boolean
    isSuccess()
    {
        return success;
    }

    public RecoErrorCodeEnum errorCode;

    public RecoErrorCodeEnum
    getErrorCode()
    {
        return errorCode;
    }

    public void
    setErrorCode(RecoErrorCodeEnum _errorCode)
    {
        errorCode = _errorCode;
    }

    public String errorMessage;

    public String
    getErrorMessage()
    {
        return errorMessage;
    }

    public void
    setErrorMessage(String _errorMessage)
    {
        errorMessage = _errorMessage;
    }
}
