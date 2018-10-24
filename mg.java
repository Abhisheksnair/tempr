package com.whatsapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.ConditionVariable;
import android.os.Environment;
import android.os.IBinder;
import com.whatsapp.a.c;
import com.whatsapp.data.ad;
import com.whatsapp.data.cb;
import com.whatsapp.data.e;
import com.whatsapp.gdrive.GoogleDriveService;
import com.whatsapp.gdrive.GoogleDriveService.a;
import com.whatsapp.gdrive.GoogleDriveService.e;
import com.whatsapp.gdrive.GoogleDriveService.f;
import com.whatsapp.messaging.m;
import com.whatsapp.messaging.w;
import com.whatsapp.notification.f;
import com.whatsapp.registration.aw;
import com.whatsapp.registration.bb;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class mg
{
  private static volatile mg c;
  final Context a;
  final CopyOnWriteArrayList<a> b = new CopyOnWriteArrayList();
  private final pv d;
  private final aaq e;
  private final va f;
  private final anv g;
  private final w h;
  private final ad i;
  private final e j;
  private final m k;
  private final aq l;
  private final f m;
  private final aw n;
  private final c o;
  private final atu p;
  private final atv q;
  private final bb r;
  private GoogleDriveService s;
  
  private mg(Context paramContext, pv parampv, aaq paramaaq, va paramva, anv paramanv, w paramw, ad paramad, e parame, m paramm, aq paramaq, f paramf, aw paramaw, c paramc, atu paramatu, atv paramatv, bb parambb)
  {
    this.a = paramContext;
    this.d = parampv;
    this.e = paramaaq;
    this.f = paramva;
    this.g = paramanv;
    this.h = paramw;
    this.i = paramad;
    this.j = parame;
    this.k = paramm;
    this.l = paramaq;
    this.m = paramf;
    this.n = paramaw;
    this.o = paramc;
    this.p = paramatu;
    this.q = paramatv;
    this.r = parambb;
  }
  
  public static mg a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new mg(u.a(), pv.a(), aaq.a(), va.a(), anv.a(), w.a(), ad.a(), e.a(), m.a(), aq.a(), f.a(), aw.a(), c.a(), atu.a(), atv.a(), bb.a());
      }
      return c;
    }
    finally {}
  }
  
  public final void b()
  {
    this.r.a(6);
    final Object localObject1 = this.b.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((a)((Iterator)localObject1).next()).a();
    }
    this.m.c();
    localObject1 = new ConditionVariable(false);
    final GoogleDriveService.a local1 = new GoogleDriveService.a()
    {
      public final void a(boolean paramAnonymousBoolean)
      {
        StringBuilder localStringBuilder = new StringBuilder("deleteacctconfirm/gdrive-observer/deletion-finished/");
        if (paramAnonymousBoolean) {}
        for (String str = "success";; str = "failed")
        {
          Log.i(str);
          localObject1.open();
          return;
        }
      }
    };
    final ConditionVariable localConditionVariable = new ConditionVariable(false);
    Object localObject2 = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        mg.a(mg.this, ((GoogleDriveService.f)paramAnonymousIBinder).a);
        localConditionVariable.open();
        mg.a(mg.this).a(local1);
        mg.a(mg.this).b();
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        localConditionVariable.close();
        mg.a(mg.this, null);
      }
    };
    Intent localIntent = new Intent(this.a, GoogleDriveService.class);
    this.a.bindService(new Intent(this.a, GoogleDriveService.class), (ServiceConnection)localObject2, 1);
    if (this.f.b != null)
    {
      localIntent.putExtra("account_name", this.q.ac());
      localIntent.putExtra("jid", this.f.b());
      localIntent.setAction("action_delete");
      bu.a(mh.a(this, localConditionVariable, localIntent));
    }
    for (;;)
    {
      localObject2 = this.a.getFilesDir();
      this.a.fileList();
      ad.a((File)localObject2);
      bu.a(mi.a());
      localObject2 = Environment.getExternalStorageState();
      Log.i("deleteacctconfirm/externalmedia-state " + (String)localObject2);
      if (this.p.b((String)localObject2)) {
        this.i.c.f();
      }
      this.h.j();
      this.k.e();
      bu.a(new AsyncTask()
      {
        private Void a()
        {
          if (GoogleDriveService.c())
          {
            Log.i("deleteacctconfirm/delete-account-cleanup waiting for googleDriveService object to be received.");
            long l = System.currentTimeMillis();
            if (!localConditionVariable.block(60000L)) {
              break label99;
            }
            l = 60000L - (System.currentTimeMillis() - l);
            Log.i("deleteacctconfirm/delete-account-cleanup waiting for Google Drive cleanup to finish.");
            if ((l <= 0L) || (!localObject1.block(l))) {
              break label91;
            }
            Log.i("deleteacctconfirm/delete-account-cleanup Google Drive deletion is finished.");
          }
          try
          {
            for (;;)
            {
              if (mg.a(mg.this) != null) {
                mg.a(mg.this).b(local1);
              }
              return null;
              label91:
              Log.e("deleteacctconfirm/delete-account-cleanup Google Drive account deletion timed out.");
              continue;
              label99:
              Log.e("deleteacctconfirm/delete-account-cleanup unable to get Google Drive service object.");
            }
          }
          catch (IllegalStateException localIllegalStateException)
          {
            for (;;)
            {
              Log.d("deleteacctconfirm/delete-account-cleanup", localIllegalStateException);
            }
          }
        }
      }, new Void[0]);
      return;
      Log.i("deleteacctconfirm/app.me is null/no google drive backup deletion");
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/mg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */