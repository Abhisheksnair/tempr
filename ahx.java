package com.whatsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Pair;
import com.whatsapp.data.ad;
import com.whatsapp.doodle.a.b;
import com.whatsapp.gallerypicker.MediaPreviewActivity;
import com.whatsapp.messaging.w;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.MediaFileUtils.e;
import com.whatsapp.util.bu;
import com.whatsapp.util.p;
import com.whatsapp.util.p.a;
import com.whatsapp.util.p.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ahx
{
  private static volatile ahx c;
  final pv a;
  final oz b;
  private final Context d;
  private final va e;
  private final w f;
  private final aic g;
  private final aoj h;
  private final vp i;
  private final ad j;
  private final and k;
  private final vx l;
  
  private ahx(Context paramContext, pv parampv, va paramva, oz paramoz, w paramw, aic paramaic, aoj paramaoj, vp paramvp, ad paramad, and paramand, vx paramvx)
  {
    this.d = paramContext;
    this.a = parampv;
    this.e = paramva;
    this.b = paramoz;
    this.f = paramw;
    this.g = paramaic;
    this.h = paramaoj;
    this.i = paramvp;
    this.j = paramad;
    this.k = paramand;
    this.l = paramvx;
  }
  
  public static ahx a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new ahx(u.a(), pv.a(), va.a(), oz.a(), w.a(), aic.a(), aoj.a(), vp.a(), ad.a(), and.a(), vx.a());
      }
      return c;
    }
    finally {}
  }
  
  private void a(final List<String> paramList, final Uri paramUri, final String paramString, final j paramj, final ng paramng, final boolean paramBoolean)
  {
    Log.i("sendmedia/send-document uri:" + paramUri + " mime:" + paramString + " jids:" + Arrays.deepToString(paramList.toArray()));
    paramng.a(0, 2131297138);
    bu.a(new AsyncTask()
    {
      private Object a()
      {
        try
        {
          Pair localPair = p.a(ahx.a(ahx.this), ahx.b(ahx.this), ahx.c(ahx.this), ahx.d(ahx.this), paramList, paramUri, paramString, paramj, paramBoolean);
          return localPair;
        }
        catch (Exception localException)
        {
          return localException;
        }
      }
      
      protected final void onPostExecute(Object paramAnonymousObject)
      {
        paramng.d();
        if ((paramAnonymousObject instanceof p.a)) {
          ahx.e(ahx.this).a(paramng, u.a().getString(2131296733));
        }
        do
        {
          return;
          if ((paramAnonymousObject instanceof p.b))
          {
            ahx.e(ahx.this).a(paramng, u.a().getString(2131296795, new Object[] { Integer.valueOf(aic.C) }));
            return;
          }
          if ((paramAnonymousObject instanceof IOException))
          {
            paramAnonymousObject = (IOException)paramAnonymousObject;
            Log.e("sendmedia/senddocumentasync/ioerror " + paramAnonymousObject);
            if ((((IOException)paramAnonymousObject).getMessage() != null) && (((IOException)paramAnonymousObject).getMessage().contains("No space")))
            {
              ahx.e(ahx.this).a(paramng, u.a().getString(2131296742));
              return;
            }
            pv.a(u.a(), 2131297841, 0);
            return;
          }
        } while (!(paramAnonymousObject instanceof Pair));
        paramAnonymousObject = (Pair)paramAnonymousObject;
        ahx.f(ahx.this).a((aoi)((Pair)paramAnonymousObject).first, (byte[])((Pair)paramAnonymousObject).second, null);
      }
    }, new Void[0]);
  }
  
  public final void a(aoi paramaoi, boolean paramBoolean)
  {
    Object localObject = new ArrayList();
    paramaoi.a(new aib((ArrayList)localObject));
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      j localj = (j)((Iterator)localObject).next();
      Log.i("sendmedia/retrymediaupload/already-uploading " + localj.e);
      paramaoi.a(localj.e);
    }
    if (paramaoi.g()) {
      Log.i("sendmedia/retrymediaupload/nothing-to-upload");
    }
    boolean bool;
    do
    {
      do
      {
        return;
        bool = MediaFileUtils.a(this.b, paramaoi.n());
        if ((!bool) || (MediaFileUtils.a(paramaoi.n()))) {
          break;
        }
      } while (!paramBoolean);
      pv.a(this.d, 2131297842, 0);
      return;
      if ((paramaoi.n().s != 9) || (MediaFileUtils.f(paramaoi.n().r) != -1)) {
        break;
      }
    } while (!paramBoolean);
    pv.a(this.d, 2131297842, 0);
    return;
    localObject = paramaoi.n().b();
    if (((bool) || (paramaoi.n().s == 3) || (paramaoi.n().s == 13) || (MediaFileUtils.a(paramaoi.n().s, ((MediaData)localObject).file))) && (!paramaoi.n().b().transcoded))
    {
      this.l.a(paramaoi);
      return;
    }
    this.i.a(paramaoi, paramBoolean).j();
  }
  
  public final void a(j paramj)
  {
    MediaData localMediaData = paramj.b();
    if ((paramj.p != null) && ((localMediaData == null) || (localMediaData.file == null))) {
      this.f.a(paramj, false, 0L);
    }
    for (;;)
    {
      this.j.f(paramj, -1);
      return;
      a(paramj, true);
    }
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    MediaData localMediaData = paramj.b();
    if (!localMediaData.autodownloadRetryEnabled)
    {
      localMediaData.autodownloadRetryEnabled = true;
      this.j.e(paramj, -1);
    }
    a(new aoi(Collections.singletonList(paramj)), paramBoolean);
  }
  
  public final void a(String paramString1, Uri paramUri, String paramString2, j paramj, ng paramng, boolean paramBoolean)
  {
    a(Collections.singletonList(paramString1), paramUri, paramString2, paramj, paramng, paramBoolean);
  }
  
  public final void a(List<String> paramList1, Uri paramUri, int paramInt, j paramj, List<String> paramList2, String paramString, boolean paramBoolean)
  {
    Bitmap localBitmap = MediaFileUtils.a(this.k, paramUri, 100, 100);
    Object localObject;
    if (localBitmap != null)
    {
      localObject = new ByteArrayOutputStream();
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      localBitmap.recycle();
    }
    for (;;)
    {
      this.h.a(this.i.a(paramList1, new MediaData(), (byte)1, paramInt, paramString, paramUri, paramj, paramList2, paramBoolean), (byte[])localObject, null);
      return;
      localObject = null;
    }
  }
  
  public final void a(boolean paramBoolean1, ArrayList<String> paramArrayList, List<Uri> paramList, String paramString, int paramInt, boolean paramBoolean2, Activity paramActivity, ng paramng, a parama)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Uri localUri = (Uri)paramList.next();
      String str = MediaFileUtils.d(this.k, localUri);
      switch (MediaFileUtils.e(this.k, localUri))
      {
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      default: 
        break;
      case 0: 
      case 9: 
        a(paramArrayList, localUri, str, null, paramng, false);
        parama.a(localUri);
        break;
      case 2: 
        MediaFileUtils.a(this.a, this.e, this.b, this.k, localUri, paramng, new ahy(this, paramBoolean1, paramArrayList, paramString, parama, localUri, paramng, paramActivity));
        break;
      case 3: 
        if (paramBoolean2) {
          MediaFileUtils.a(this.a, this.e, this.b, this.k, localUri, paramng, new ahz(this, localUri, paramActivity, paramArrayList, paramInt, paramString, parama, paramng));
        } else {
          localArrayList.add(localUri);
        }
        break;
      case 13: 
        if (paramBoolean2) {
          MediaFileUtils.a(this.a, this.e, this.b, this.k, localUri, paramng, new aia(this, paramBoolean1, paramArrayList, paramString, parama, localUri, paramng, paramActivity));
        } else {
          localArrayList.add(localUri);
        }
        break;
      case 1: 
        if (paramBoolean2) {
          try
          {
            a(paramArrayList, localUri, paramInt, null, yr.a(localUri.getQueryParameter("mentions")), paramString, false);
            parama.a(localUri);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              Log.e("sendmedia/sendimages/share-failed/ " + localIOException.toString());
              if ((localIOException.getMessage() != null) && (localIOException.getMessage().contains("No space"))) {
                this.a.b(u.a(), 2131296742, 0);
              } else {
                pv.a(u.a(), 2131297841, 0);
              }
            }
          }
          catch (MediaFileUtils.e locale)
          {
            for (;;)
            {
              Log.e("sendmedia/sendimages/share-failed/ " + locale.toString());
              this.a.b(u.a(), 2131296734, 0);
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              Log.e("sendmedia/sendimages/share-failed/ " + localOutOfMemoryError.toString());
              this.a.b(u.a(), 2131296746, 0);
            }
          }
          catch (SecurityException localSecurityException)
          {
            for (;;)
            {
              Log.e("sendmedia/sendimages/share-failed/ " + localSecurityException.toString());
              this.a.b(u.a(), 2131297282, 0);
            }
          }
        } else {
          localArrayList.add(localUri);
        }
        break;
      }
    }
    if (!localArrayList.isEmpty())
    {
      paramList = new Intent(paramActivity, MediaPreviewActivity.class);
      paramList.putExtra("jids", paramArrayList);
      paramList.putExtra("send", true);
      paramList.putExtra("max_items", 0);
      paramList.putExtra("origin", 5);
      paramList.putExtra("android.intent.extra.STREAM", localArrayList);
      paramList.putExtra("android.intent.extra.TEXT", paramString);
      paramActivity.startActivity(paramList);
      paramArrayList = localArrayList.iterator();
      while (paramArrayList.hasNext()) {
        parama.b((Uri)paramArrayList.next());
      }
    }
  }
  
  public final boolean a(String paramString, File paramFile, boolean paramBoolean1, j paramj, boolean paramBoolean2)
  {
    return a(false, Collections.singletonList(paramString), paramFile, (byte)2, paramBoolean1, null, paramj, paramBoolean2);
  }
  
  public final boolean a(List<String> paramList1, File paramFile, String paramString, j paramj, List<String> paramList2, b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    Log.i("sendmedia/sendmediafile src:" + paramFile.getAbsolutePath() + " " + paramFile.length());
    MediaData localMediaData = new MediaData();
    localMediaData.file = paramFile;
    label110:
    Object localObject;
    if (paramb == null)
    {
      paramFile = MediaFileUtils.d(localMediaData.file.getAbsolutePath());
      if (paramb != null)
      {
        if (paramb.e != null) {
          break label225;
        }
        localMediaData.doodleId = MediaFileUtils.a(this.e);
        paramb.a(MediaFileUtils.a(this.b, localMediaData.doodleId));
      }
      paramb = this.h;
      localObject = this.i;
      if (!paramBoolean1) {
        break label238;
      }
    }
    label225:
    label238:
    for (byte b1 = 13;; b1 = 3)
    {
      paramb.a(((vp)localObject).a(paramList1, localMediaData, b1, 0, paramString, null, paramj, paramList2, paramBoolean2), paramFile, null);
      return true;
      localObject = MediaFileUtils.g(localMediaData.file.getAbsolutePath());
      paramFile = (File)localObject;
      if (localObject != null)
      {
        paramFile = (File)localObject;
        if (!((Bitmap)localObject).isMutable()) {
          paramFile = ((Bitmap)localObject).copy(Bitmap.Config.ARGB_8888, true);
        }
      }
      if (paramFile != null)
      {
        paramb.a(paramFile, 0);
        paramFile = MediaFileUtils.a(paramFile);
        break;
      }
      paramFile = null;
      break;
      localMediaData.doodleId = paramb.e;
      break label110;
    }
  }
  
  public final boolean a(boolean paramBoolean1, List<String> paramList, File paramFile, byte paramByte, boolean paramBoolean2, String paramString, j paramj, boolean paramBoolean3)
  {
    if (!MediaFileUtils.a(this.d, this.a, paramBoolean1, paramFile, paramByte)) {
      return false;
    }
    Log.i("sendmedia/sendmediafile src:" + paramFile.getAbsolutePath() + " " + paramFile.length());
    Object localObject;
    if (!paramBoolean2)
    {
      localObject = new MediaData();
      ((MediaData)localObject).file = paramFile;
      if ((paramByte != 3) && (paramByte != 13)) {
        break label186;
      }
    }
    label186:
    for (paramFile = MediaFileUtils.d(((MediaData)localObject).file.getAbsolutePath());; paramFile = null)
    {
      this.h.a(this.i.a(paramList, (MediaData)localObject, paramByte, 0, paramString, null, paramj, null, paramBoolean3), paramFile, null);
      return true;
      localObject = MediaFileUtils.a(this.d, this.b, paramFile, paramByte, 0);
      Log.i("sendmedia/sendmediafile send:" + ((File)localObject).getAbsolutePath());
      MediaFileUtils.a(paramFile, (File)localObject);
      paramFile = (File)localObject;
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(Uri paramUri);
    
    public abstract void b(Uri paramUri);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ahx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */