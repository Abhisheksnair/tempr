package com.whatsapp.memory.dump;

import android.app.ActivityManager;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.whatsapp.aat;
import com.whatsapp.and;
import com.whatsapp.ape;
import com.whatsapp.au;
import com.whatsapp.av;
import com.whatsapp.i.d.b;
import com.whatsapp.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

public class MemoryDumpUploadService
  extends IntentService
{
  private b a;
  private final com.whatsapp.util.a.c b = com.whatsapp.util.a.c.a();
  private final and c = and.a();
  private final aat d = aat.a();
  
  public MemoryDumpUploadService()
  {
    super("MemDumpUploadService");
  }
  
  private String a()
  {
    return String.format("%s/dump.clean", new Object[] { this.a.a() });
  }
  
  public static void a(Context paramContext)
  {
    paramContext.startService(new Intent(paramContext, MemoryDumpUploadService.class));
  }
  
  private String b()
  {
    return String.format("%s/dump.gz", new Object[] { this.a.a() });
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = new b(getApplicationContext());
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    paramIntent = this.a.a(this.a.a());
    if ((paramIntent == null) || (paramIntent.length == 0))
    {
      Log.d("MemoryDumpUpload/no files found; exit");
      return;
    }
    Log.d("MemoryDumpUpload/hprof file found");
    if (this.d.a(true) != 1)
    {
      Log.d("MemoryDumpUpload/no wifi connection; exit");
      int j = paramIntent.length;
      i = 0;
      while (i < j)
      {
        paramIntent[i].delete();
        localFile1 = new File(b());
        if (localFile1.exists()) {
          localFile1.delete();
        }
        localFile1 = new File(a());
        if (localFile1.exists()) {
          localFile1.delete();
        }
        i += 1;
      }
      a.a.a.a.d.e(3);
      return;
    }
    int i = 1;
    while (i < paramIntent.length)
    {
      paramIntent[i].delete();
      a.a.a.a.d.e(4);
      Log.d("MemoryDumpUpload/delete other old file: " + paramIntent[i].getPath());
      i += 1;
    }
    final File localFile1 = paramIntent[0];
    final File localFile2 = new File(a());
    Log.d("MemoryDumpUpload/cleaning PI from file");
    if (!new a(localFile1, localFile2).a())
    {
      Log.d("MemoryDumpUpload/failed to clean PI data from hprof");
      localFile1.delete();
      localFile2.delete();
      a.a.a.a.d.e(5);
      return;
    }
    if (this.d.a(true) != 1)
    {
      Log.d("MemoryDumpUpload/lost connectivity, deleting and exiting");
      localFile1.delete();
      localFile2.delete();
      a.a.a.a.d.e(6);
      return;
    }
    final File localFile3 = new File(b());
    try
    {
      paramIntent = this.b.d();
      if ((av.d()) || (!com.whatsapp.util.a.c.a(paramIntent, "android_hprof")))
      {
        if (av.d()) {
          Log.d("MemoryDumpUpload: Not uploading as we are in a debug build");
        }
        localFile1.delete();
        localFile3.delete();
        localFile2.delete();
        return;
      }
    }
    catch (Exception paramIntent)
    {
      Log.c("MemoryDumpUpload/Error Uploading file", paramIntent);
      localFile1.delete();
      localFile2.delete();
      localFile3.delete();
      a.a.a.a.d.e(7);
      return;
      Log.d("MemoryDumpUpload/Attempting to gzip file: " + localFile2);
      b.a(localFile2, localFile3);
      paramIntent = getApplicationContext();
      Object localObject = this.c.b;
      if (localObject == null) {
        Log.w("memorydumpuploadservice/get-upload-params am=null");
      }
      for (i = 16;; i = ((ActivityManager)localObject).getMemoryClass())
      {
        paramIntent = new c(localFile3, i, ape.a(paramIntent, au.a()), au.d(), "Whatsapp", "Main Process", "1", "java.lang.OutOfMemoryError");
        Log.d("MemoryDumpUpload/Attempting to upload file; compressed=" + localFile3 + "; dumpFile=" + paramIntent.a);
        localObject = new d.b()
        {
          public final void a(long paramAnonymousLong)
          {
            localFile1.delete();
            localFile3.delete();
            localFile2.delete();
          }
          
          public final void a(Map<String, List<String>> paramAnonymousMap, String paramAnonymousString)
          {
            Log.d("MemoryDumpUpload/Response: " + paramAnonymousString);
            a.a.a.a.d.e(1);
          }
        };
        com.whatsapp.i.a.a();
        localObject = com.whatsapp.i.a.a("https://crashlogs.whatsapp.net/wa_clb_data", (d.b)localObject, false);
        ((com.whatsapp.i.d)localObject).a("access_token", "1063127757113399|745146ffa34413f9dbb5469f5370b7af");
        ((com.whatsapp.i.d)localObject).a(new FileInputStream(paramIntent.a), "android_hprof", paramIntent.a.getName(), 0L);
        ((com.whatsapp.i.d)localObject).a("agent", paramIntent.b);
        ((com.whatsapp.i.d)localObject).a("type", "android_hprof");
        ((com.whatsapp.i.d)localObject).a("android_hprof_extras", paramIntent.a());
        ((com.whatsapp.i.d)localObject).a(null);
        return;
      }
    }
    catch (OutOfMemoryError paramIntent)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/memory/dump/MemoryDumpUploadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */