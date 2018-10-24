package com.whatsapp.l;

import a.a.a.a.a.a.d;
import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Base64;
import com.whatsapp.util.Log;
import com.whatsapp.util.be;
import com.whatsapp.va;
import com.whatsapp.va.a;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c
{
  public String a;
  public boolean b;
  private va c;
  private String d;
  private String e;
  private String f;
  private String g;
  
  public c(va paramva, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.c = paramva;
    this.e = be.d(paramString1);
    if (!paramBoolean) {
      this.a = this.e;
    }
    this.g = paramString2;
    this.b = paramBoolean;
    this.d = paramString1;
  }
  
  private Uri.Builder d(h paramh)
  {
    if (this.e != null) {}
    for (boolean bool = true;; bool = false)
    {
      a.d.a(bool, "Cannot compute url without hash");
      Uri.Builder localBuilder = new Uri.Builder();
      localBuilder.scheme("https").encodedAuthority(paramh.c).appendPath("mms").appendPath(this.g).appendPath(be.d(this.e));
      return localBuilder;
    }
  }
  
  public final String a(h paramh)
  {
    return d(paramh).build().toString();
  }
  
  public final Uri.Builder b(h paramh)
  {
    paramh = c(paramh);
    if (this.b) {
      paramh.appendQueryParameter("stream", "1");
    }
    return paramh;
  }
  
  public final Uri.Builder c(h paramh)
  {
    if (this.f == null) {}
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update((this.d + this.c.c().t).getBytes("UTF-8"));
      this.f = be.d(Base64.encodeToString(localMessageDigest.digest(), 2));
      if (this.f != null)
      {
        bool = true;
        a.d.a(bool, "Upload token has not been set");
        paramh = d(paramh);
        paramh.appendQueryParameter("token", this.f);
        return paramh;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        Log.d("NoSuchAlgorithmException while computing unique upload token", localNoSuchAlgorithmException);
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Log.d("Client appears to not support UTF8", localUnsupportedEncodingException);
        continue;
        boolean bool = false;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/l/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */