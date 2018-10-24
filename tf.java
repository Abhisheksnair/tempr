package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.whatsapp.util.Log;
import org.b.a.a.b;
import org.b.a.a.c;

public class tf
{
  private static volatile tf a;
  private final Context b;
  private volatile org.b.a.a.a c;
  private volatile c d;
  private boolean e;
  
  private tf(Context paramContext)
  {
    this.b = ((Context)a.d.a(paramContext));
  }
  
  public static tf a(Context paramContext)
  {
    Object localObject = a;
    if (localObject == null) {
      try
      {
        tf localtf = a;
        localObject = localtf;
        if (localtf == null)
        {
          localObject = paramContext.getApplicationContext();
          if (localObject != null) {
            paramContext = (Context)localObject;
          }
          localObject = new tf(paramContext);
          a = (tf)localObject;
        }
        return (tf)localObject;
      }
      finally {}
    }
    return (tf)localObject;
  }
  
  public final org.b.a.a.a a()
  {
    Object localObject4 = null;
    Object localObject1 = this.c;
    label119:
    Object localObject3;
    if (localObject1 == null)
    {
      for (;;)
      {
        SharedPreferences localSharedPreferences;
        boolean bool;
        try
        {
          localObject1 = this.c;
          if (localObject1 != null) {
            break label205;
          }
          localSharedPreferences = this.b.getSharedPreferences("keystore", 0);
          localObject1 = localSharedPreferences.getString("client_static_keypair", "");
        }
        finally {}
        try
        {
          bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (!bool) {
            break label119;
          }
          localObject1 = localObject4;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          byte[] arrayOfByte;
          Object localObject2;
          Log.c("failed to deserialize client static keypair", localIllegalArgumentException);
          localObject3 = localObject4;
          continue;
          this.c = ((org.b.a.a.a)localObject4);
        }
        localObject4 = localObject1;
        if (localObject1 != null) {
          break;
        }
        Log.i("generating new client static keypair");
        localObject1 = org.b.a.a.a.a();
        localObject4 = localObject1;
        if (localSharedPreferences.edit().putString("client_static_keypair", Base64.encodeToString(((org.b.a.a.a)localObject1).b(), 3)).commit()) {
          break;
        }
        throw new AssertionError("unable to write client static keypair");
        arrayOfByte = Base64.decode(str, 3);
        localObject2 = localObject4;
        if (arrayOfByte != null)
        {
          localObject2 = localObject4;
          if (arrayOfByte.length == 64)
          {
            localObject2 = d.c(arrayOfByte, 32, 32);
            localObject2 = new org.b.a.a.a(new c(localObject2[1]), new b(localObject2[0]));
          }
        }
      }
      for (;;)
      {
        return (org.b.a.a.a)localObject4;
        label205:
        localObject4 = localObject3;
      }
    }
    return (org.b.a.a.a)localObject3;
  }
  
  public final void a(org.b.a.a.a parama)
  {
    try
    {
      Log.i("saving new client static keypair; public=" + org.whispersystems.a.i.a.b(parama.a.a));
      if (!this.b.getSharedPreferences("keystore", 0).edit().putString("client_static_keypair", Base64.encodeToString(parama.b(), 3)).commit()) {
        throw new AssertionError("unable to write client static keypair");
      }
    }
    finally {}
    this.c = parama;
  }
  
  public final void a(c paramc)
  {
    try
    {
      Log.i("saving server static public key");
      if (!this.b.getSharedPreferences("keystore", 0).edit().putString("server_static_public", Base64.encodeToString(paramc.a, 3)).commit()) {
        throw new AssertionError("unable to write server static keypair");
      }
    }
    finally {}
    this.d = paramc;
    this.e = true;
  }
  
  public final c b()
  {
    c localc = this.d;
    Object localObject1 = localc;
    if (localc == null) {}
    for (;;)
    {
      try
      {
        localc = this.d;
        localObject1 = localc;
        if (localc == null)
        {
          localObject1 = localc;
          if (!this.e) {
            localObject1 = this.b.getSharedPreferences("keystore", 0).getString("server_static_public", "");
          }
        }
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            continue;
          }
          localObject1 = null;
          if (localObject1 == null) {
            continue;
          }
          localObject1 = new c((byte[])localObject1);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Log.c("failed to deserialize server public key", localIllegalArgumentException);
          Object localObject2 = null;
          continue;
        }
        this.d = ((c)localObject1);
        this.e = true;
        return (c)localObject1;
      }
      finally {}
      localObject1 = Base64.decode((String)localObject1, 3);
      continue;
      localObject1 = null;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/tf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */