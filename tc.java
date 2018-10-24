package com.whatsapp;

import android.annotation.TargetApi;
import android.content.ClipDescription;
import android.net.Uri;
import android.support.v13.view.inputmethod.InputConnectionCompat;
import android.support.v13.view.inputmethod.InputContentInfoCompat;
import com.whatsapp.util.Log;

@TargetApi(13)
public final class tc
{
  private InputContentInfoCompat a;
  
  public final Uri a(InputContentInfoCompat paramInputContentInfoCompat, int paramInt, String[] paramArrayOfString)
  {
    try
    {
      if (this.a != null) {
        this.a.releasePermission();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int j;
        String str;
        Log.d("conversation/InputContentInfoCompat#releasePermission() failed.", localException);
        this.a = null;
      }
    }
    finally
    {
      this.a = null;
    }
    j = paramArrayOfString.length;
    int i = 0;
    if (i < j)
    {
      str = paramArrayOfString[i];
      if (!paramInputContentInfoCompat.getDescription().hasMimeType(str)) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        return null;
        i += 1;
        break;
      }
      if ((InputConnectionCompat.INPUT_CONTENT_GRANT_READ_URI_PERMISSION & paramInt) != 0) {}
      try
      {
        paramInputContentInfoCompat.requestPermission();
        Log.i("conversation/onCommitContent: " + paramInputContentInfoCompat.getContentUri().toString());
        this.a = paramInputContentInfoCompat;
        return paramInputContentInfoCompat.getContentUri();
      }
      catch (Exception paramInputContentInfoCompat)
      {
        Log.d("conversation/InputContentInfoCompat#requestPermission() failed.", paramInputContentInfoCompat);
        return null;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/tc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */