/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: U:\\Fontes\\IMSupra206\\IMSupra\\src\\com\\imsupra\\androidclient\\IXMPPRosterCallback.aidl
 */
package com.imsupra.androidclient;
/*
	IPC interface for XMPPService to send broadcasts to UI
*/
public interface IXMPPRosterCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.imsupra.androidclient.IXMPPRosterCallback
{
private static final java.lang.String DESCRIPTOR = "com.imsupra.androidclient.IXMPPRosterCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.imsupra.androidclient.IXMPPRosterCallback interface,
 * generating a proxy if needed.
 */
public static com.imsupra.androidclient.IXMPPRosterCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.imsupra.androidclient.IXMPPRosterCallback))) {
return ((com.imsupra.androidclient.IXMPPRosterCallback)iin);
}
return new com.imsupra.androidclient.IXMPPRosterCallback.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_connectionStatusChanged:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _arg1;
_arg1 = (0!=data.readInt());
this.connectionStatusChanged(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.imsupra.androidclient.IXMPPRosterCallback
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void connectionStatusChanged(boolean isConnected, boolean willReconnect) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((isConnected)?(1):(0)));
_data.writeInt(((willReconnect)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_connectionStatusChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_connectionStatusChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void connectionStatusChanged(boolean isConnected, boolean willReconnect) throws android.os.RemoteException;
}
