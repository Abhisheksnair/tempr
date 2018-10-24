package com.whatsapp;

import android.os.Handler;
import android.os.Looper;
import com.whatsapp.data.ad;
import com.whatsapp.messaging.bn;
import com.whatsapp.messaging.w;
import com.whatsapp.protocol.aj;
import com.whatsapp.protocol.al;
import com.whatsapp.util.Log;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.whispersystems.a.e;
import org.whispersystems.a.n;

final class afa
  implements bn
{
  final Handler a = new Handler(Looper.getMainLooper());
  final w b;
  final ad c;
  final att d;
  final abp e;
  final aob f;
  final com.whatsapp.a.c g;
  final atv h;
  
  afa(w paramw, ad paramad, att paramatt, abp paramabp, aob paramaob, com.whatsapp.a.c paramc, atv paramatv)
  {
    this.b = paramw;
    this.c = paramad;
    this.d = paramatt;
    this.e = paramabp;
    this.f = paramaob;
    this.g = paramc;
    this.h = paramatv;
  }
  
  public final void a()
  {
    abp localabp = this.e;
    aj[] arrayOfaj = localabp.b;
    localabp.b = null;
    Log.i("prekey set successful");
    com.whatsapp.a.c.a.execute(abr.a(localabp, arrayOfaj));
  }
  
  public final void a(int paramInt)
  {
    abp localabp = this.e;
    localabp.b = null;
    if (paramInt == 406)
    {
      Log.e("failed to set prekeys; regenerating keys; errorCode=406");
      com.whatsapp.a.c.a.execute(abs.a(localabp));
      return;
    }
    Log.e("failed to set prekeys; will try again on next xmpp connect; errorCode=" + paramInt);
    localabp.c.remove(localabp.e.b() + "@s.whatsapp.net");
  }
  
  public final void a(al paramal)
  {
    Log.i("identity changed notification received; stanzaKey=" + paramal);
    com.whatsapp.a.c.a.submit(afd.a(this, paramal));
  }
  
  public final void a(al paramal, int paramInt)
  {
    Log.i("prekey count running low; remainingPreKeys=" + paramInt);
    com.whatsapp.a.c.a.execute(afc.a(this, paramal));
  }
  
  public final void a(String paramString)
  {
    Log.i("prekey request returned none; jid=" + paramString);
    com.whatsapp.a.c.a.execute(afb.a(this, paramString));
  }
  
  public final void a(String paramString, int paramInt)
  {
    Log.i("prekey request failed; jid=" + paramString + "; errorCode=" + paramInt);
    this.e.a(paramString);
  }
  
  public final void a(final String paramString, final byte[] paramArrayOfByte1, final byte[] paramArrayOfByte2, final byte paramByte, final aj paramaj1, final aj paramaj2)
  {
    Log.i("prekey request successful; initiating signal protocol session; jid=" + paramString);
    com.whatsapp.a.c.a.execute(new Runnable()
    {
      public final void run()
      {
        try
        {
          afa.this.g.a(paramString, paramArrayOfByte1, paramByte, paramaj1, paramaj2, paramArrayOfByte2);
          afa.this.a.post(new a(afa.this.c.b(paramString)));
          return;
        }
        catch (n localn)
        {
          Log.e(localn);
          afa.this.a.post(new a(false));
          return;
        }
        catch (e locale)
        {
          for (;;) {}
        }
      }
      
      final class a
        implements Runnable
      {
        private final boolean b;
        
        a(boolean paramBoolean)
        {
          this.b = paramBoolean;
        }
        
        public final void run()
        {
          Log.i("completion callback for onGetPreKeySuccess; sendUnsentMessages=" + this.b);
          afa.this.e.a(afa.1.this.a);
          b.a.a.c.a().b(new com.whatsapp.g.c(afa.1.this.a));
          if (this.b) {
            afa.this.f.b();
          }
        }
      }
    });
  }
  
  public final void a(byte[] paramArrayOfByte1, byte paramByte, byte[] paramArrayOfByte2, byte[][] paramArrayOfByte, byte[] paramArrayOfByte3)
  {
    Log.i("checking prekey digest");
    com.whatsapp.a.c.a.execute(afe.a(this, paramByte, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte, paramArrayOfByte3));
  }
  
  public final void b()
  {
    Log.i("prekey digest none");
    com.whatsapp.a.c.a.execute(aff.a(this));
  }
  
  public final void b(al paramal)
  {
    Log.i("server asked us to run an e2e key digest check; stanzaKey=" + paramal);
    this.h.e(true);
    this.b.e();
    this.b.a(paramal);
  }
  
  public final void c()
  {
    Log.i("prekey digest server error");
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/afa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */