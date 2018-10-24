package com.whatsapp;

import a.a.a.a.a.a.d;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import com.whatsapp.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Licenses
  extends nh
{
  private String l()
  {
    InputStream localInputStream = getResources().openRawResource(2131165189);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      for (int i = localInputStream.read(); i != -1; i = localInputStream.read()) {
        localByteArrayOutputStream.write(i);
      }
      return localByteArrayOutputStream.toString();
    }
    catch (IOException localIOException)
    {
      Log.e("licenses/cannot-load " + localIOException.toString());
      return null;
    }
    finally
    {
      a.d.a(localInputStream);
      a.d.a(localByteArrayOutputStream);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903262);
    TextView localTextView = (TextView)findViewById(2131755855);
    String str = l();
    paramBundle = str;
    if (str == null) {
      paramBundle = getString(2131298050);
    }
    localTextView.setText(paramBundle);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/Licenses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */