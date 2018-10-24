package com.whatsapp;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.v4.app.an.d;
import android.support.v4.app.aw;
import android.support.v4.content.b;
import android.text.TextUtils;
import com.whatsapp.data.ab;
import com.whatsapp.data.ac;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.emoji.c;
import com.whatsapp.j.a.a;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MediaTranscodeService
  extends Service
{
  private static final HashMap<j.b, j> e = new HashMap();
  private boolean a = false;
  private String b;
  private int c = -1;
  private final e d = e.a();
  
  private void a(an.d paramd, int paramInt, String paramString, boolean paramBoolean)
  {
    paramd.a("progress");
    paramd.a(17301640);
    paramd.a(System.currentTimeMillis());
    paramd.a(getString(2131298233));
    if (paramInt >= 0) {
      if (paramInt != 0) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      paramd.a(100, paramInt, bool);
      paramd.b(paramString);
      if (!paramBoolean) {
        paramd.c(paramString);
      }
      return;
    }
  }
  
  public static void a(ac paramac)
  {
    paramac.registerObserver(new ab()
    {
      public final void a(j paramAnonymousj, int paramAnonymousInt)
      {
        for (;;)
        {
          synchronized ()
          {
            if ((paramAnonymousj.s == 3) || (paramAnonymousj.s == 13) || ((paramAnonymousj.s == 2) && (paramAnonymousj.o != 1)))
            {
              if (paramAnonymousj.d == 1)
              {
                MediaTranscodeService.a().put(paramAnonymousj.e, paramAnonymousj);
                if (!MediaTranscodeService.a().isEmpty()) {
                  break label109;
                }
                u.a().stopService(new Intent(u.a(), MediaTranscodeService.class));
              }
            }
            else {
              return;
            }
            MediaTranscodeService.a().remove(paramAnonymousj.e);
          }
          label109:
          paramAnonymousj = new Intent(u.a(), MediaTranscodeService.class);
          u.a().startService(paramAnonymousj);
        }
      }
    });
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onDestroy()
  {
    Log.d("mediamtanscodeservice/ondestroy foreground:" + this.a + " count:" + e.size());
    if (this.a)
    {
      this.a = false;
      stopForeground(true);
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (e.isEmpty())
    {
      stopSelf();
      return 2;
    }
    boolean bool = this.a;
    this.a = true;
    paramInt2 = -1;
    HashSet localHashSet = new HashSet();
    Object localObject2;
    Object localObject1;
    label127:
    label142:
    Object localObject3;
    if (e.size() == 1)
    {
      localObject2 = (j)e.values().iterator().next();
      localObject1 = this.d.d(((j)localObject2).e.a);
      switch (((j)localObject2).s)
      {
      default: 
        paramInt1 = 2131297672;
        if (((j)localObject2).a())
        {
          paramIntent = getString(2131297237);
          paramIntent = getString(paramInt1, new Object[] { c.a(paramIntent) });
          if (Build.VERSION.SDK_INT < 11) {
            break label1008;
          }
          localObject3 = ((j)localObject2).b();
          if (localObject3 == null) {
            break label1008;
          }
          paramInt2 = (int)((MediaData)localObject3).progress;
          paramInt1 = paramInt2;
          if (((MediaData)localObject3).transcoder != null)
          {
            paramInt1 = paramInt2;
            if (((MediaData)localObject3).transcoder.c())
            {
              if (((MediaData)localObject3).uploader != null) {
                break label491;
              }
              paramInt1 = paramInt2 / 2;
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      label223:
      localObject1 = Conversation.a((cs)localObject1);
      localHashSet.add(Byte.valueOf(((j)localObject2).s));
      paramInt2 = paramInt1;
      localObject2 = new an.d(u.a());
      a((an.d)localObject2, paramInt2, paramIntent, bool);
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject3 = new an.d(u.a());
        if (localHashSet.size() != 1) {}
      }
      else
      {
        switch (((Byte)localHashSet.iterator().next()).byteValue())
        {
        default: 
          paramInt1 = 2131230800;
          label351:
          a((an.d)localObject3, paramInt2, String.format(u.a.a(paramInt1, e.size()), new Object[] { Integer.valueOf(e.size()) }), bool);
          ((an.d)localObject2).a(((an.d)localObject3).e());
          ((an.d)localObject2).a(PendingIntent.getActivity(this, 1, (Intent)localObject1, 134217728));
          ((an.d)localObject2).e(b.c(this, 2131624091));
          if (!bool) {
            startForeground(4, ((an.d)localObject2).e());
          }
          break;
        }
      }
      label491:
      label668:
      do
      {
        for (;;)
        {
          this.c = paramInt2;
          this.b = paramIntent;
          break;
          paramInt1 = 2131297673;
          break label127;
          paramInt1 = 2131297681;
          break label127;
          paramInt1 = 2131297671;
          break label127;
          paramIntent = ((cs)localObject1).a(this);
          break label142;
          paramInt1 = paramInt2 / 2 + 50;
          break label223;
          paramIntent = new HashSet();
          localObject1 = e.values().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (j)((Iterator)localObject1).next();
            paramIntent.add(((j)localObject2).e.a);
            localHashSet.add(Byte.valueOf(((j)localObject2).s));
          }
          if (paramIntent.size() == 1)
          {
            localObject1 = this.d.d((String)paramIntent.iterator().next());
            if (localHashSet.size() == 1) {
              switch (((Byte)localHashSet.iterator().next()).byteValue())
              {
              default: 
                paramInt1 = 2131230799;
                localObject2 = u.a.a(paramInt1, e.size());
                paramInt1 = e.size();
                if (!j.c((String)paramIntent.iterator().next())) {
                  break;
                }
              }
            }
            for (paramIntent = getString(2131297237);; paramIntent = ((cs)localObject1).a(this))
            {
              paramIntent = String.format((String)localObject2, new Object[] { Integer.valueOf(paramInt1), c.a(paramIntent) });
              localObject1 = Conversation.a((cs)localObject1);
              break;
              paramInt1 = 2131230801;
              break label668;
              paramInt1 = 2131230804;
              break label668;
              paramInt1 = 2131230797;
              break label668;
              paramInt1 = 2131230799;
              break label668;
            }
          }
          if (localHashSet.size() == 1) {
            switch (((Byte)localHashSet.iterator().next()).byteValue())
            {
            default: 
              paramInt1 = 2131230800;
            }
          }
          for (;;)
          {
            localObject1 = new Intent(this, Main.n());
            paramIntent = String.format(u.a.a(paramInt1, e.size()), new Object[] { Integer.valueOf(e.size()) });
            break;
            paramInt1 = 2131230802;
            continue;
            paramInt1 = 2131230805;
            continue;
            paramInt1 = 2131230798;
            continue;
            paramInt1 = 2131230800;
          }
          paramInt1 = 2131230802;
          break label351;
          paramInt1 = 2131230805;
          break label351;
          paramInt1 = 2131230798;
          break label351;
          paramInt1 = 2131230800;
          break label351;
          if ((this.c != paramInt2) || (!TextUtils.equals(paramIntent, this.b))) {
            try
            {
              aw.a(this).a(4, ((an.d)localObject2).e());
            }
            catch (SecurityException localSecurityException) {}
          }
        }
      } while (localSecurityException.toString().contains("android.permission.UPDATE_APP_OPS_STATS"));
      throw localSecurityException;
      label1008:
      paramInt1 = -1;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/MediaTranscodeService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */