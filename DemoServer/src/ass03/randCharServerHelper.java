package ass03;


/**
* ass03/randCharServerHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from demo.idl
* Saturday, October 22, 2016 4:22:10 PM AEDT
*/

abstract public class randCharServerHelper
{
  private static String  _id = "IDL:ass03/randCharServer:1.0";

  public static void insert (org.omg.CORBA.Any a, ass03.randCharServer that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ass03.randCharServer extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (ass03.randCharServerHelper.id (), "randCharServer");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ass03.randCharServer read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_randCharServerStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ass03.randCharServer value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static ass03.randCharServer narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ass03.randCharServer)
      return (ass03.randCharServer)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ass03._randCharServerStub stub = new ass03._randCharServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static ass03.randCharServer unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ass03.randCharServer)
      return (ass03.randCharServer)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ass03._randCharServerStub stub = new ass03._randCharServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}