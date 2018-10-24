package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.media.CamcorderProfile;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Display;
import android.view.WindowManager;
import com.whatsapp.d.b;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.y;
import com.whatsapp.fieldstats.events.ar;
import com.whatsapp.l.h;
import com.whatsapp.m.a.a;
import com.whatsapp.m.a.b;
import com.whatsapp.m.a.c;
import com.whatsapp.messaging.w;
import com.whatsapp.protocol.ah;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.k;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.MediaFileUtils.OsRename;
import com.whatsapp.util.a.c;
import com.whatsapp.util.av.c;
import com.whatsapp.util.be;
import com.whatsapp.util.bu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class vk
  extends AsyncTask<Void, Long, c>
{
  private static final HashMap<j.b, j> C = new HashMap();
  private static final HashMap<String, List<j>> D = new HashMap();
  private final ah A = ah.a();
  private final com.whatsapp.protocol.ag B = com.whatsapp.protocol.ag.a();
  private final vv.a E = new vv.a()
  {
    public final void a()
    {
      ng localng = (ng)vk.b(vk.this);
      vk.a(vk.this);
      if (vv.i()) {}
      for (int i = 2131296558;; i = 2131296559)
      {
        localng.a(2131296692, i, new Object[0]);
        return;
      }
    }
    
    public final void b()
    {
      ng localng = (ng)vk.b(vk.this);
      vk.a(vk.this);
      if (vv.i()) {}
      for (int i = 2131296556;; i = 2131296557)
      {
        localng.a(2131296692, i, new Object[0]);
        return;
      }
    }
    
    public final void c()
    {
      RequestPermissionActivity.b(vk.b(vk.this), 2131297431, 2131297430);
    }
    
    public final void d()
    {
      RequestPermissionActivity.b(vk.b(vk.this), 2131297431, 2131297430);
    }
  };
  final j a;
  final MediaData b;
  URL c;
  final boolean d;
  public final vo e;
  public a f;
  public com.whatsapp.m.a g;
  final ad h = ad.a();
  private final File i;
  private boolean j = false;
  private final com.whatsapp.i.a k = com.whatsapp.i.a.a();
  private h l;
  private Activity m;
  private final pv n = pv.a();
  private final c o = c.a();
  private final va p = va.a();
  private final oz q = oz.a();
  private final w r = w.a();
  private final com.whatsapp.l.e s = com.whatsapp.l.e.a();
  private final com.whatsapp.data.e t = com.whatsapp.data.e.a();
  private final and u = and.a();
  private final y v = y.a();
  private final vv w = vv.a();
  private final com.whatsapp.util.ag x = com.whatsapp.util.ag.a();
  private final ai y = ai.a();
  private final atv z = atv.a();
  
  private vk(j paramj, a parama, Activity paramActivity)
  {
    this.i = a(this.q, paramj, false);
    this.a = paramj;
    this.f = parama;
    if (parama != a.a)
    {
      bool1 = true;
      this.d = bool1;
      this.b = paramj.b();
      this.m = paramActivity;
      this.e = new vo(paramj.s, parama);
      parama = new StringBuilder("MMS media download initialized; message.key=").append(paramj.e).append(" autoDownload=").append(parama).append(" activity.nil?=");
      if (paramActivity != null) {
        break label285;
      }
    }
    label285:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Log.i(bool1 + " streamable=" + a(paramj));
      return;
      bool1 = false;
      break;
    }
  }
  
  private int a(j paramj, URL paramURL, InputStream paramInputStream, FileOutputStream paramFileOutputStream, MediaData paramMediaData)
  {
    localObject3 = paramFileOutputStream;
    localObject4 = paramFileOutputStream;
    localObject2 = paramFileOutputStream;
    try
    {
      localObject1 = MessageDigest.getInstance("SHA-256");
      if (localObject1 == null)
      {
        localObject3 = paramFileOutputStream;
        localObject4 = paramFileOutputStream;
        localObject2 = paramFileOutputStream;
        Log.w("MMS download failed during media decryption due to null SHA-256 digest; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL));
        if (paramFileOutputStream != null) {}
        try
        {
          paramFileOutputStream.close();
        }
        catch (IOException paramFileOutputStream)
        {
          for (;;)
          {
            try
            {
              paramInputStream.close();
              return 1;
            }
            catch (IOException paramInputStream)
            {
              Log.c("MMS download failed to close image cipher input stream during media decryption; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL), paramInputStream);
              return 1;
            }
            paramFileOutputStream = paramFileOutputStream;
            Log.c("MMS download failed to close file output stream during media decryption; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL), paramFileOutputStream);
          }
        }
      }
      localObject3 = paramFileOutputStream;
      localObject4 = paramFileOutputStream;
      localObject2 = paramFileOutputStream;
      arrayOfByte = new byte[' '];
      l1 = 0L;
    }
    catch (NoSuchAlgorithmException paramFileOutputStream)
    {
      Object localObject1;
      byte[] arrayOfByte;
      localObject2 = localObject3;
      Log.c("MMS download failed during media decryption due to missing security algorithm; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL), paramFileOutputStream);
      if (localObject3 == null) {
        break label725;
      }
      try
      {
        ((FileOutputStream)localObject3).close();
        try
        {
          paramInputStream.close();
          return 1;
        }
        catch (IOException paramInputStream)
        {
          Log.c("MMS download failed to close image cipher input stream during media decryption; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL), paramInputStream);
          return 1;
        }
      }
      catch (IOException paramFileOutputStream)
      {
        for (;;)
        {
          Log.c("MMS download failed to close file output stream during media decryption; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL), paramFileOutputStream);
        }
      }
    }
    catch (IOException paramFileOutputStream)
    {
      localObject2 = localObject4;
      Log.c("MMS download failed during media decryption; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL), paramFileOutputStream);
      if (localObject4 == null) {
        break label868;
      }
      try
      {
        ((FileOutputStream)localObject4).close();
        try
        {
          paramInputStream.close();
          return 1;
        }
        catch (IOException paramInputStream)
        {
          Log.c("MMS download failed to close image cipher input stream during media decryption; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL), paramInputStream);
          return 1;
        }
      }
      catch (IOException paramFileOutputStream)
      {
        for (;;)
        {
          Log.c("MMS download failed to close file output stream during media decryption; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL), paramFileOutputStream);
        }
      }
    }
    finally
    {
      for (;;)
      {
        long l1;
        int i1;
        if (localObject2 != null) {}
        try
        {
          ((FileOutputStream)localObject2).close();
        }
        catch (IOException paramMediaData)
        {
          try
          {
            for (;;)
            {
              paramInputStream.close();
              throw paramFileOutputStream;
              paramMediaData = paramMediaData;
              Log.c("MMS download failed to close file output stream during media decryption; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL), paramMediaData);
            }
          }
          catch (IOException paramInputStream)
          {
            for (;;)
            {
              Log.c("MMS download failed to close image cipher input stream during media decryption; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL), paramInputStream);
            }
          }
        }
        l1 += i1;
      }
    }
    localObject3 = paramFileOutputStream;
    localObject4 = paramFileOutputStream;
    localObject2 = paramFileOutputStream;
    i1 = paramInputStream.read(arrayOfByte);
    if (i1 != -1)
    {
      localObject3 = paramFileOutputStream;
      localObject4 = paramFileOutputStream;
      localObject2 = paramFileOutputStream;
      ((MessageDigest)localObject1).update(arrayOfByte, 0, i1);
      if (paramFileOutputStream != null)
      {
        localObject3 = paramFileOutputStream;
        localObject4 = paramFileOutputStream;
        localObject2 = paramFileOutputStream;
        paramFileOutputStream.write(arrayOfByte, 0, i1);
      }
    }
    else
    {
      localObject3 = paramFileOutputStream;
      localObject4 = paramFileOutputStream;
      localObject2 = paramFileOutputStream;
      localObject1 = ((MessageDigest)localObject1).digest();
      localObject3 = paramFileOutputStream;
      localObject4 = paramFileOutputStream;
      localObject2 = paramFileOutputStream;
      if (!Arrays.equals((byte[])localObject1, Base64.decode(paramj.u, 0)))
      {
        localObject3 = paramFileOutputStream;
        localObject4 = paramFileOutputStream;
        localObject2 = paramFileOutputStream;
        Log.w("MMS download failed during media decryption due to plaintext hash mismatch; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL) + "; mediaHash=" + paramj.u + "; calculatedHash=" + Base64.encodeToString((byte[])localObject1, 2) + "; totalBytesRead=" + l1 + "; mediaSize=" + paramj.t);
        if (paramFileOutputStream != null) {}
        try
        {
          paramFileOutputStream.close();
        }
        catch (IOException paramFileOutputStream)
        {
          try
          {
            for (;;)
            {
              paramInputStream.close();
              return 2;
              paramFileOutputStream = paramFileOutputStream;
              Log.c("MMS download failed to close file output stream during media decryption; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL), paramFileOutputStream);
            }
          }
          catch (IOException paramInputStream)
          {
            for (;;)
            {
              Log.c("MMS download failed to close image cipher input stream during media decryption; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL), paramInputStream);
            }
          }
        }
      }
      localObject1 = paramFileOutputStream;
      if (paramFileOutputStream != null)
      {
        localObject3 = paramFileOutputStream;
        localObject4 = paramFileOutputStream;
        localObject2 = paramFileOutputStream;
        paramFileOutputStream.close();
        localObject1 = null;
      }
      localObject3 = localObject1;
      localObject4 = localObject1;
      localObject2 = localObject1;
      bu.a(vn.a(this, paramj, paramURL, paramMediaData));
      if (localObject1 != null) {}
      try
      {
        ((FileOutputStream)localObject1).close();
      }
      catch (IOException paramFileOutputStream)
      {
        try
        {
          for (;;)
          {
            paramInputStream.close();
            return 0;
            paramFileOutputStream = paramFileOutputStream;
            Log.c("MMS download failed to close file output stream during media decryption; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL), paramFileOutputStream);
          }
        }
        catch (IOException paramInputStream)
        {
          for (;;)
          {
            Log.c("MMS download failed to close image cipher input stream during media decryption; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL), paramInputStream);
          }
        }
      }
    }
  }
  
  public static j a(j.b paramb)
  {
    synchronized (C)
    {
      paramb = (j)C.get(paramb);
      return paramb;
    }
  }
  
  private c a(j paramj, File paramFile1, File paramFile2, URL paramURL, b paramb)
  {
    MediaData localMediaData = paramj.b();
    d locald = b(paramj, paramFile1, paramFile2, paramURL, paramb);
    if (isCancelled()) {
      return new c(d.l, null, false);
    }
    if (locald != d.d) {
      return new c(locald, null, true);
    }
    if (paramFile1.equals(paramFile2)) {
      return new c(d.d, paramb.a, true);
    }
    int i1;
    try
    {
      paramFile2 = new FileOutputStream(paramFile2);
      paramb = new b(new FileInputStream(paramFile1), new com.whatsapp.d.d(localMediaData.cipherKey, localMediaData.hmacKey, localMediaData.iv, localMediaData.refKey), paramFile1.length());
      i1 = a(paramj, paramURL, paramb, paramFile2, localMediaData);
      if (isCancelled()) {
        return new c(d.l, null, false);
      }
    }
    catch (FileNotFoundException paramFile1)
    {
      Log.c("MMS download failed during media decryption; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL), paramFile1);
      return new c(d.a, null, true);
    }
    switch (i1)
    {
    default: 
      throw new AssertionError("unknown result encountered in switch");
    case 0: 
      paramFile1.delete();
      return new c(d.d, a(paramj.r), true);
    case 1: 
      return new c(d.a, null, true);
    }
    return new c(d.h, null, true);
  }
  
  private c a(vk paramvk, j paramj, File paramFile, URL paramURL)
  {
    if (a(paramj))
    {
      this.B.a(paramj.g());
      return a(paramvk, paramj, paramURL);
    }
    return b(paramvk, paramj, paramFile, paramURL);
  }
  
  private c a(final vk paramvk, j paramj, URL paramURL)
  {
    Object localObject = ((k)a.d.a(paramj.g())).a();
    if (localObject == null)
    {
      Log.w("MMS download failed because sidecar not found; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL));
      paramj.g().a(null);
      return new c(d.a, null, true);
    }
    File localFile2 = a(this.q, paramj, true);
    File localFile1 = paramvk.g.g();
    File localFile3 = c(paramj);
    final MediaData localMediaData = paramj.b();
    if ((localFile2 == null) || (localFile1 == null) || (localFile3 == null)) {
      throw new IllegalStateException("MMS download failed due to message allowed into download encrypted without sufficient information to compute a download file; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL));
    }
    localObject = new com.whatsapp.m.e(this.o, this.w, this.y, paramvk.g, (byte[])localObject, paramj, paramURL, localFile2, localFile1, localFile3, paramvk, this.k, this.l);
    paramvk.g.a(new a.c()
    {
      public final void a(a.a paramAnonymousa)
      {
        switch (vk.3.a[paramAnonymousa.ordinal()])
        {
        default: 
          return;
        case 1: 
          vk.c(vk.this).a();
          return;
        case 2: 
          vk.c(vk.this).b();
          return;
        }
        vk.c(vk.this).d();
        vk.c(vk.this).c();
      }
      
      public final void a(com.whatsapp.m.a paramAnonymousa)
      {
        if (paramAnonymousa.d() == a.b.d)
        {
          if (!vk.c(vk.this).m()) {
            vk.c(vk.this).a();
          }
          if (!vk.c(vk.this).l()) {
            vk.c(vk.this).c();
          }
        }
      }
      
      public final void b(com.whatsapp.m.a paramAnonymousa)
      {
        paramvk.g.a(a.b.a);
        vk.a(paramvk, new Long[] { Long.valueOf(paramAnonymousa.j()) });
        localMediaData.cachedDownloadedBytes = paramAnonymousa.k();
        vk.c(vk.this).k = paramAnonymousa.k();
        if ((!localMediaData.showDownloadedBytes) && (paramvk.f != vk.a.c)) {
          localMediaData.showDownloadedBytes = true;
        }
      }
      
      public final void x_() {}
    });
    ((com.whatsapp.m.e)localObject).c.f = Long.valueOf(0L);
    paramvk = ((com.whatsapp.m.e)localObject).a();
    ((com.whatsapp.m.e)localObject).c.a = paramvk.o;
    ((com.whatsapp.m.e)localObject).c.c = Long.valueOf(((com.whatsapp.m.e)localObject).a.j());
    com.whatsapp.fieldstats.l.b(u.a(), ((com.whatsapp.m.e)localObject).c);
    this.e.a(((com.whatsapp.m.e)localObject).d);
    this.e.a(this.g.h());
    if (paramvk != d.d)
    {
      this.e.m = com.whatsapp.i.d.a(paramURL);
      if (paramvk == d.h) {
        paramj.g().a(null);
      }
      return new c(paramvk, null, true);
    }
    paramvk = b(paramj, localFile2, localFile1, paramURL, ((com.whatsapp.m.e)localObject).b);
    if (paramvk != d.d)
    {
      paramvk = new c(paramvk, null, true);
      this.e.e();
      return paramvk;
    }
    for (;;)
    {
      try
      {
        switch (a(paramj, paramURL, new FileInputStream(localFile1), null, localMediaData))
        {
        case 0: 
          throw new AssertionError("unknown result encountered in switch");
        }
      }
      catch (FileNotFoundException paramvk)
      {
        Log.c("MMS download failed during media decryption; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL), paramvk);
        paramvk = new c(d.a, null, true);
      }
      break;
      paramvk = new c(d.d, a(paramj.r), true);
      break;
      paramvk = new c(d.a, null, true);
      break;
      paramvk = new c(d.h, null, true);
      break;
    }
  }
  
  public static vk a(oz paramoz, ad paramad, com.whatsapp.l.e parame, j paramj, a parama, Activity paramActivity)
  {
    parame.c();
    synchronized (C)
    {
      parame = paramj.b();
      if (parame == null)
      {
        Log.e("MMS unable to download due to missing media data; message.key=" + paramj.e);
        return null;
      }
      if (parame.transferred)
      {
        Log.e("MMS download already completed; message.key=" + paramj.e);
        return null;
      }
    }
    if (parame.transferring)
    {
      if (parama.ordinal() < parame.downloader.f.ordinal())
      {
        parame.prefetching = false;
        parame.downloader.f = parama;
        Log.i("MMS existing download upgraded to " + parama + "; message.key=" + paramj.e);
        paramad.f(paramj, -1);
      }
      for (;;)
      {
        return null;
        Log.e("MMS download already in progress (according to media data); message.key=" + paramj.e);
      }
    }
    if (parame.suspiciousContent == MediaData.SUSPICIOUS_CONTENT_YES)
    {
      Log.e("MMS media has been marked suspicious; message.key=" + paramj.e);
      return null;
    }
    if (!C.containsKey(paramj.e))
    {
      C.put(paramj.e, paramj);
      paramActivity = new vk(paramj, parama, paramActivity);
      if (a(paramj)) {
        paramoz = (File)a.d.a(a(paramoz, paramj, false));
      }
    }
    for (;;)
    {
      try
      {
        if (!paramoz.exists())
        {
          if (!paramoz.createNewFile()) {
            Log.w("MMS unable to create decryption file; message.key=" + paramj.e);
          }
          paramActivity.e.j = Long.valueOf(0L);
          paramActivity.g = new com.whatsapp.m.a();
          paramActivity.g.c(paramj.t);
          paramActivity.g.a(paramoz);
          parame.streamViewable = true;
          parame.downloader = paramActivity;
          parame.transferring = true;
          if (a.c != parama) {
            break label605;
          }
          bool = true;
          parame.prefetching = bool;
          parame.progress = 0L;
          parame.autodownloadRetryEnabled = true;
          parame = (List)D.get(paramj.u);
          if (parame != null)
          {
            Log.i("MMS download already in progress (new message received); message.key=" + paramj.e + " queue.size=" + parame.size());
            paramoz = null;
            parame.add(paramj);
            paramad.f(paramj, -1);
            return paramoz;
          }
        }
        else
        {
          paramActivity.e.j = Long.valueOf(System.currentTimeMillis() - paramoz.lastModified());
          continue;
        }
        parame = new ArrayList();
      }
      catch (IOException paramoz)
      {
        Log.d("MMS unable to create decryption file; message.key=" + paramj.e, paramoz);
        return null;
      }
      D.put(paramj.u, parame);
      paramoz = paramActivity;
      continue;
      paramoz = null;
      Log.w("MMS download already in progress (according to current downloads) " + paramj.e);
      continue;
      label605:
      boolean bool = false;
    }
  }
  
  private static File a(oz paramoz, j paramj, boolean paramBoolean)
  {
    if (paramj.u != null) {
      if (paramBoolean) {
        paramj = paramj.u.replace('/', '-') + ".enc.tmp";
      }
    }
    for (;;)
    {
      return paramoz.a(paramj);
      paramj = paramj.u.replace('/', '-') + ".tmp";
      continue;
      if (paramj.p == null) {
        break;
      }
      paramj = new File(paramj.p).getName();
    }
    Log.e("app/downloadmedia/no_url");
    return null;
  }
  
  private File a(j paramj, String paramString)
  {
    if (paramj.a())
    {
      paramj = this.q;
      paramString = MediaFileUtils.a(this.p) + "." + paramString;
      return oz.a(paramj.h(), paramString);
    }
    String str2;
    String str1;
    if (paramj.s == 9)
    {
      str2 = MediaFileUtils.b(paramj.r);
      str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!TextUtils.isEmpty(paramj.y)) {
          str1 = a.a.a.a.d.l(paramj.y);
        }
      }
      if (!TextUtils.isEmpty(str1)) {
        break label339;
      }
    }
    for (;;)
    {
      str2 = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        str2 = paramString.replaceAll("[?:\\/*\"<>|]", "");
      }
      paramString = paramj.z;
      int i3;
      int i1;
      int i2;
      if (!TextUtils.isEmpty(paramj.y))
      {
        paramString = paramj.y;
        i3 = paramString.lastIndexOf('.');
        int i4 = paramString.lastIndexOf(File.separator);
        if (i4 > i3)
        {
          i1 = -1;
          i2 = i4;
          if (i4 < 0) {
            i2 = 0;
          }
          if (i1 < 0) {
            break label286;
          }
          paramString = paramString.substring(i2, i3);
        }
      }
      else
      {
        label206:
        str1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str1 = paramj.z;
        }
        if (TextUtils.isEmpty(str1)) {
          break label333;
        }
      }
      label286:
      label333:
      for (paramString = str1.replaceAll("[?:\\/*\"<>|]", "");; paramString = str1)
      {
        return MediaFileUtils.a(u.a(), this.q, "." + str2, paramString, paramj.s, paramj.o);
        i1 = i3;
        break;
        paramString = paramString.substring(i2);
        break label206;
        return MediaFileUtils.a(u.a(), this.q, "." + paramString, null, paramj.s, paramj.o);
      }
      label339:
      paramString = str1;
    }
  }
  
  private static String a(String paramString)
  {
    if (paramString == null) {
      paramString = "enc";
    }
    String str;
    do
    {
      return paramString;
      str = MediaFileUtils.b(paramString);
      paramString = str;
    } while (!TextUtils.isEmpty(str));
    return "enc";
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA256");
      return null;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      try
      {
        localMac.init(new SecretKeySpec(paramArrayOfByte, "HmacSHA256"));
        return Base64.encodeToString(localMac.doFinal(this.p.c().t.getBytes()), 0, 20, 10);
      }
      catch (InvalidKeyException paramArrayOfByte)
      {
        Log.w(paramArrayOfByte);
      }
      paramArrayOfByte = paramArrayOfByte;
      Log.w(paramArrayOfByte);
      return null;
    }
  }
  
  public static Collection<j> a()
  {
    synchronized (C)
    {
      ArrayList localArrayList = new ArrayList(C.values());
      return localArrayList;
    }
  }
  
  public static boolean a(j paramj)
  {
    return (VideoDownloadStreamActivity.n) && (paramj.g() != null) && (paramj.g().b());
  }
  
  private Uri b(j paramj)
  {
    i3 = 640;
    i6 = 480;
    i7 = 0;
    Uri localUri = Uri.parse(paramj.p);
    Uri.Builder localBuilder = localUri.buildUpon();
    localBuilder.appendQueryParameter("x", "2");
    if ((paramj.s == 3) || (paramj.s == 13)) {
      i1 = i3;
    }
    try
    {
      paramj = CamcorderProfile.get(1);
      i5 = i7;
      i4 = i6;
      i2 = i3;
      if (paramj != null)
      {
        i1 = i3;
        i2 = Math.max(640, paramj.videoFrameWidth);
        i1 = i2;
        i4 = Math.max(480, paramj.videoFrameHeight);
        i5 = 1;
      }
    }
    catch (RuntimeException paramj)
    {
      for (;;)
      {
        Log.i(paramj);
        int i5 = i7;
        int i4 = i6;
        int i2 = i1;
      }
    }
    paramj = ((WindowManager)u.a().getSystemService("window")).getDefaultDisplay();
    i6 = paramj.getWidth();
    i7 = paramj.getHeight();
    i1 = i6;
    i3 = i7;
    if (Build.VERSION.SDK_INT >= 14) {
      i1 = i6;
    }
    try
    {
      Point localPoint = new Point();
      i1 = i6;
      paramj.getRealSize(localPoint);
      i1 = i6;
      i6 = localPoint.x;
      i1 = i6;
      i3 = localPoint.y;
      i1 = i6;
    }
    catch (NoSuchMethodError paramj)
    {
      for (;;)
      {
        i3 = i7;
        continue;
        i6 = i1;
        i1 = i3;
        i3 = i6;
      }
    }
    if (i1 < i3)
    {
      if (i5 != 0)
      {
        i6 = i4;
        i5 = i2;
        if (i2 > i3)
        {
          i6 = i4;
          i5 = i2;
          if (i4 <= i1) {}
        }
      }
      else
      {
        i5 = i3;
        i6 = i1;
      }
      localBuilder.appendQueryParameter("width", String.valueOf(i5));
      localBuilder.appendQueryParameter("height", String.valueOf(i6));
      Log.i("appending width and height to media transcode url; width=" + i5 + " height=" + i6);
      paramj = this.z.m();
      if (paramj != null) {
        localBuilder.authority(paramj).path(localUri.getHost()).appendEncodedPath(localUri.getEncodedPath());
      }
      return localBuilder.build();
    }
  }
  
  /* Error */
  private c b(vk paramvk, j paramj, File paramFile, URL paramURL)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 239	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   4: astore 15
    //   6: aload 15
    //   8: ifnull +82 -> 90
    //   11: aload 15
    //   13: getfield 447	com/whatsapp/MediaData:refKey	[B
    //   16: ifnull +74 -> 90
    //   19: iconst_1
    //   20: istore 5
    //   22: iload 5
    //   24: ifeq +72 -> 96
    //   27: aload_0
    //   28: getfield 132	com/whatsapp/vk:q	Lcom/whatsapp/oz;
    //   31: aload_2
    //   32: iconst_1
    //   33: invokestatic 224	com/whatsapp/vk:a	(Lcom/whatsapp/oz;Lcom/whatsapp/protocol/j;Z)Ljava/io/File;
    //   36: astore 16
    //   38: iload 5
    //   40: ifeq +62 -> 102
    //   43: aload 16
    //   45: ifnonnull +57 -> 102
    //   48: new 515	java/lang/IllegalStateException
    //   51: dup
    //   52: new 254	java/lang/StringBuilder
    //   55: dup
    //   56: ldc_w 517
    //   59: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload_2
    //   63: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   66: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   69: ldc_w 306
    //   72: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 4
    //   77: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   80: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokespecial 518	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   89: athrow
    //   90: iconst_0
    //   91: istore 5
    //   93: goto -71 -> 22
    //   96: aload_3
    //   97: astore 16
    //   99: goto -61 -> 38
    //   102: aload 16
    //   104: invokevirtual 454	java/io/File:length	()J
    //   107: lstore 6
    //   109: lload 6
    //   111: lconst_0
    //   112: lcmp
    //   113: ifle +226 -> 339
    //   116: lload 6
    //   118: lstore 8
    //   120: aload 15
    //   122: aload 4
    //   124: lload 8
    //   126: ldc2_w 959
    //   129: aload_0
    //   130: getfield 522	com/whatsapp/vk:l	Lcom/whatsapp/l/h;
    //   133: invokestatic 963	com/whatsapp/i/a:a	(Lcom/whatsapp/MediaData;Ljava/net/URL;JJLcom/whatsapp/l/h;)Lcom/whatsapp/i/a$a;
    //   136: astore 15
    //   138: aload 15
    //   140: astore 17
    //   142: aload_0
    //   143: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   146: invokevirtual 965	com/whatsapp/vo:a	()V
    //   149: aload 15
    //   151: astore 17
    //   153: new 16	com/whatsapp/vk$b
    //   156: dup
    //   157: aload 15
    //   159: ldc_w 967
    //   162: invokevirtual 970	com/whatsapp/i/a$a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   165: invokespecial 971	com/whatsapp/vk$b:<init>	(Ljava/lang/String;)V
    //   168: astore 19
    //   170: aload 15
    //   172: astore 17
    //   174: aload 15
    //   176: getfield 974	com/whatsapp/i/a$a:a	Ljavax/net/ssl/HttpsURLConnection;
    //   179: invokevirtual 979	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   182: sipush 416
    //   185: if_icmpne +216 -> 401
    //   188: aload 15
    //   190: astore 17
    //   192: aload 15
    //   194: ldc_w 981
    //   197: invokevirtual 970	com/whatsapp/i/a$a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   200: astore 20
    //   202: aload 15
    //   204: astore 17
    //   206: aload 20
    //   208: invokestatic 741	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   211: ifne +190 -> 401
    //   214: aload 15
    //   216: astore 17
    //   218: aload 20
    //   220: ldc_w 983
    //   223: invokevirtual 987	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   226: istore 14
    //   228: iload 14
    //   230: ifeq +171 -> 401
    //   233: aload 15
    //   235: astore 17
    //   237: aload 20
    //   239: iconst_2
    //   240: invokevirtual 779	java/lang/String:substring	(I)Ljava/lang/String;
    //   243: invokestatic 991	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   246: lload 6
    //   248: lcmp
    //   249: ifne +152 -> 401
    //   252: aload 15
    //   254: astore 17
    //   256: aload_0
    //   257: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   260: invokevirtual 993	com/whatsapp/vo:d	()V
    //   263: aload 15
    //   265: astore 17
    //   267: aload_0
    //   268: aload_2
    //   269: aload 16
    //   271: aload_3
    //   272: aload 4
    //   274: aload 19
    //   276: invokespecial 995	com/whatsapp/vk:a	(Lcom/whatsapp/protocol/j;Ljava/io/File;Ljava/io/File;Ljava/net/URL;Lcom/whatsapp/vk$b;)Lcom/whatsapp/vk$c;
    //   279: astore 18
    //   281: aload 15
    //   283: astore 17
    //   285: aload_0
    //   286: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   289: invokevirtual 588	com/whatsapp/vo:e	()V
    //   292: aload 15
    //   294: invokestatic 998	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   297: aload_0
    //   298: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   301: invokevirtual 1000	com/whatsapp/vo:m	()Z
    //   304: ifne +10 -> 314
    //   307: aload_0
    //   308: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   311: invokevirtual 965	com/whatsapp/vo:a	()V
    //   314: aload 18
    //   316: astore_1
    //   317: aload_0
    //   318: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   321: invokevirtual 1002	com/whatsapp/vo:l	()Z
    //   324: ifne +13 -> 337
    //   327: aload_0
    //   328: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   331: invokevirtual 1003	com/whatsapp/vo:c	()V
    //   334: aload 18
    //   336: astore_1
    //   337: aload_1
    //   338: areturn
    //   339: lconst_0
    //   340: lstore 8
    //   342: goto -222 -> 120
    //   345: astore 18
    //   347: aload 15
    //   349: astore 17
    //   351: new 254	java/lang/StringBuilder
    //   354: dup
    //   355: ldc_w 1005
    //   358: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   361: aload_2
    //   362: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   365: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   368: ldc_w 306
    //   371: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: aload 4
    //   376: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   379: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: ldc_w 1007
    //   385: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload 20
    //   390: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: aload 18
    //   398: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   401: aload 15
    //   403: astore 17
    //   405: lload 6
    //   407: aload 15
    //   409: invokevirtual 1009	com/whatsapp/i/a$a:a	()J
    //   412: ladd
    //   413: lstore 12
    //   415: aload 15
    //   417: astore 17
    //   419: invokestatic 1011	com/whatsapp/vv:f	()J
    //   422: lload 12
    //   424: lcmp
    //   425: ifge +384 -> 809
    //   428: aload 15
    //   430: astore 17
    //   432: new 254	java/lang/StringBuilder
    //   435: dup
    //   436: ldc_w 1013
    //   439: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   442: aload_2
    //   443: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   446: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   449: ldc_w 306
    //   452: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload 4
    //   457: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   460: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 313	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   469: aload 15
    //   471: astore 17
    //   473: new 19	com/whatsapp/vk$c
    //   476: dup
    //   477: getstatic 1015	com/whatsapp/vk$d:e	Lcom/whatsapp/vk$d;
    //   480: aconst_null
    //   481: iconst_0
    //   482: invokespecial 413	com/whatsapp/vk$c:<init>	(Lcom/whatsapp/vk$d;Ljava/lang/String;Z)V
    //   485: astore_3
    //   486: aload 15
    //   488: invokestatic 998	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   491: aload_0
    //   492: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   495: invokevirtual 1000	com/whatsapp/vo:m	()Z
    //   498: ifne +10 -> 508
    //   501: aload_0
    //   502: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   505: invokevirtual 965	com/whatsapp/vo:a	()V
    //   508: aload_3
    //   509: astore_1
    //   510: aload_0
    //   511: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   514: invokevirtual 1002	com/whatsapp/vo:l	()Z
    //   517: ifne -180 -> 337
    //   520: aload_0
    //   521: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   524: invokevirtual 1003	com/whatsapp/vo:c	()V
    //   527: aload_3
    //   528: areturn
    //   529: astore_3
    //   530: aconst_null
    //   531: astore_1
    //   532: aload_0
    //   533: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   536: aload_3
    //   537: invokevirtual 573	com/whatsapp/vo:a	(Ljava/lang/Exception;)V
    //   540: aload_0
    //   541: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   544: aload 4
    //   546: invokestatic 581	com/whatsapp/i/d:a	(Ljava/net/URL;)Ljava/lang/String;
    //   549: putfield 583	com/whatsapp/vo:m	Ljava/lang/String;
    //   552: new 19	com/whatsapp/vk$c
    //   555: dup
    //   556: aload_3
    //   557: getfield 1018	com/whatsapp/MediaDownloadConnection$ConnectionFailureException:code	Lcom/whatsapp/vk$d;
    //   560: aconst_null
    //   561: iconst_0
    //   562: invokespecial 413	com/whatsapp/vk$c:<init>	(Lcom/whatsapp/vk$d;Ljava/lang/String;Z)V
    //   565: astore_3
    //   566: aload_1
    //   567: ifnull +7 -> 574
    //   570: aload_1
    //   571: invokestatic 998	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   574: aload_0
    //   575: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   578: invokevirtual 1000	com/whatsapp/vo:m	()Z
    //   581: ifne +10 -> 591
    //   584: aload_0
    //   585: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   588: invokevirtual 965	com/whatsapp/vo:a	()V
    //   591: aload_3
    //   592: astore_1
    //   593: aload_0
    //   594: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   597: invokevirtual 1002	com/whatsapp/vo:l	()Z
    //   600: ifne -263 -> 337
    //   603: aload_0
    //   604: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   607: invokevirtual 1003	com/whatsapp/vo:c	()V
    //   610: aload_3
    //   611: areturn
    //   612: astore_3
    //   613: aconst_null
    //   614: astore 15
    //   616: aload 15
    //   618: astore 17
    //   620: new 254	java/lang/StringBuilder
    //   623: dup
    //   624: ldc_w 1020
    //   627: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   630: aload_2
    //   631: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   634: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   637: ldc_w 306
    //   640: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: aload 4
    //   645: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   648: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   654: aload_3
    //   655: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   658: aload 15
    //   660: astore 17
    //   662: getstatic 461	com/whatsapp/vk$d:a	Lcom/whatsapp/vk$d;
    //   665: astore_1
    //   666: aload 15
    //   668: astore 17
    //   670: aload_3
    //   671: instanceof 1022
    //   674: ifeq +102 -> 776
    //   677: aload 15
    //   679: astore 17
    //   681: getstatic 1024	com/whatsapp/vk$d:b	Lcom/whatsapp/vk$d;
    //   684: astore_1
    //   685: aload 15
    //   687: astore 17
    //   689: aload_0
    //   690: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   693: aload_3
    //   694: invokevirtual 573	com/whatsapp/vo:a	(Ljava/lang/Exception;)V
    //   697: aload 15
    //   699: astore 17
    //   701: aload_0
    //   702: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   705: aload 4
    //   707: invokestatic 581	com/whatsapp/i/d:a	(Ljava/net/URL;)Ljava/lang/String;
    //   710: putfield 583	com/whatsapp/vo:m	Ljava/lang/String;
    //   713: aload 15
    //   715: astore 17
    //   717: new 19	com/whatsapp/vk$c
    //   720: dup
    //   721: aload_1
    //   722: aconst_null
    //   723: iconst_0
    //   724: invokespecial 413	com/whatsapp/vk$c:<init>	(Lcom/whatsapp/vk$d;Ljava/lang/String;Z)V
    //   727: astore_3
    //   728: aload 15
    //   730: ifnull +8 -> 738
    //   733: aload 15
    //   735: invokestatic 998	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   738: aload_0
    //   739: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   742: invokevirtual 1000	com/whatsapp/vo:m	()Z
    //   745: ifne +10 -> 755
    //   748: aload_0
    //   749: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   752: invokevirtual 965	com/whatsapp/vo:a	()V
    //   755: aload_3
    //   756: astore_1
    //   757: aload_0
    //   758: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   761: invokevirtual 1002	com/whatsapp/vo:l	()Z
    //   764: ifne -427 -> 337
    //   767: aload_0
    //   768: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   771: invokevirtual 1003	com/whatsapp/vo:c	()V
    //   774: aload_3
    //   775: areturn
    //   776: aload 15
    //   778: astore 17
    //   780: aload_3
    //   781: instanceof 1026
    //   784: ifne +14 -> 798
    //   787: aload 15
    //   789: astore 17
    //   791: aload_3
    //   792: instanceof 1028
    //   795: ifeq -110 -> 685
    //   798: aload 15
    //   800: astore 17
    //   802: getstatic 1030	com/whatsapp/vk$d:c	Lcom/whatsapp/vk$d;
    //   805: astore_1
    //   806: goto -121 -> 685
    //   809: aload 15
    //   811: astore 17
    //   813: getstatic 1032	com/whatsapp/vk$a:b	Lcom/whatsapp/vk$a;
    //   816: aload_0
    //   817: getfield 230	com/whatsapp/vk:f	Lcom/whatsapp/vk$a;
    //   820: if_acmpne +18 -> 838
    //   823: aload 15
    //   825: astore 17
    //   827: aload_0
    //   828: getfield 195	com/whatsapp/vk:y	Lcom/whatsapp/ai;
    //   831: aload_2
    //   832: invokevirtual 1034	com/whatsapp/ai:c	(Lcom/whatsapp/protocol/j;)Z
    //   835: ifeq +14 -> 849
    //   838: aload 15
    //   840: astore 17
    //   842: aload_1
    //   843: invokevirtual 407	com/whatsapp/vk:isCancelled	()Z
    //   846: ifeq +63 -> 909
    //   849: aload 15
    //   851: astore 17
    //   853: new 19	com/whatsapp/vk$c
    //   856: dup
    //   857: getstatic 410	com/whatsapp/vk$d:l	Lcom/whatsapp/vk$d;
    //   860: aconst_null
    //   861: iconst_0
    //   862: invokespecial 413	com/whatsapp/vk$c:<init>	(Lcom/whatsapp/vk$d;Ljava/lang/String;Z)V
    //   865: astore_3
    //   866: aload 15
    //   868: invokestatic 998	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   871: aload_0
    //   872: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   875: invokevirtual 1000	com/whatsapp/vo:m	()Z
    //   878: ifne +10 -> 888
    //   881: aload_0
    //   882: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   885: invokevirtual 965	com/whatsapp/vo:a	()V
    //   888: aload_3
    //   889: astore_1
    //   890: aload_0
    //   891: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   894: invokevirtual 1002	com/whatsapp/vo:l	()Z
    //   897: ifne -560 -> 337
    //   900: aload_0
    //   901: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   904: invokevirtual 1003	com/whatsapp/vo:c	()V
    //   907: aload_3
    //   908: areturn
    //   909: aload 15
    //   911: astore 17
    //   913: new 315	java/io/FileOutputStream
    //   916: dup
    //   917: aload 16
    //   919: iconst_1
    //   920: invokespecial 1037	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   923: astore 18
    //   925: lload 6
    //   927: lconst_0
    //   928: lcmp
    //   929: ifle +26 -> 955
    //   932: aload_1
    //   933: iconst_1
    //   934: anewarray 536	java/lang/Long
    //   937: dup
    //   938: iconst_0
    //   939: ldc2_w 1038
    //   942: lload 6
    //   944: lmul
    //   945: lload 12
    //   947: ldiv
    //   948: invokestatic 540	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   951: aastore
    //   952: invokevirtual 834	com/whatsapp/vk:publishProgress	([Ljava/lang/Object;)V
    //   955: aload 15
    //   957: getfield 974	com/whatsapp/i/a$a:a	Ljavax/net/ssl/HttpsURLConnection;
    //   960: invokevirtual 1043	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   963: astore 17
    //   965: aload_2
    //   966: invokevirtual 723	com/whatsapp/protocol/j:a	()Z
    //   969: ifeq +504 -> 1473
    //   972: iconst_4
    //   973: istore 5
    //   975: new 1045	com/whatsapp/Statistics$a
    //   978: dup
    //   979: aload 17
    //   981: iload 5
    //   983: invokespecial 1048	com/whatsapp/Statistics$a:<init>	(Ljava/io/InputStream;I)V
    //   986: astore 17
    //   988: sipush 8192
    //   991: newarray <illegal type>
    //   993: astore 20
    //   995: aload 17
    //   997: aload 20
    //   999: iconst_0
    //   1000: sipush 8192
    //   1003: invokevirtual 1051	java/io/InputStream:read	([BII)I
    //   1006: istore 5
    //   1008: lload 6
    //   1010: lstore 8
    //   1012: iload 5
    //   1014: iflt +752 -> 1766
    //   1017: lload 8
    //   1019: lstore 6
    //   1021: lload 8
    //   1023: lstore 10
    //   1025: aload 18
    //   1027: aload 20
    //   1029: iconst_0
    //   1030: iload 5
    //   1032: invokevirtual 1054	java/io/OutputStream:write	([BII)V
    //   1035: lload 8
    //   1037: iload 5
    //   1039: i2l
    //   1040: ladd
    //   1041: lstore 8
    //   1043: lload 8
    //   1045: lstore 6
    //   1047: lload 8
    //   1049: lstore 10
    //   1051: aload_0
    //   1052: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1055: getfield 1056	com/whatsapp/vo:i	Ljava/lang/Long;
    //   1058: ifnull +563 -> 1621
    //   1061: iconst_1
    //   1062: istore 5
    //   1064: iload 5
    //   1066: ifne +18 -> 1084
    //   1069: lload 8
    //   1071: lstore 6
    //   1073: lload 8
    //   1075: lstore 10
    //   1077: aload_0
    //   1078: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1081: invokevirtual 1058	com/whatsapp/vo:b	()V
    //   1084: lload 8
    //   1086: lstore 6
    //   1088: lload 8
    //   1090: lstore 10
    //   1092: aload_0
    //   1093: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1096: lload 8
    //   1098: putfield 1060	com/whatsapp/vo:k	J
    //   1101: lload 8
    //   1103: lstore 6
    //   1105: lload 8
    //   1107: lstore 10
    //   1109: aload_1
    //   1110: invokevirtual 407	com/whatsapp/vk:isCancelled	()Z
    //   1113: ifeq +598 -> 1711
    //   1116: lload 8
    //   1118: lstore 6
    //   1120: lload 8
    //   1122: lstore 10
    //   1124: new 19	com/whatsapp/vk$c
    //   1127: dup
    //   1128: getstatic 410	com/whatsapp/vk$d:l	Lcom/whatsapp/vk$d;
    //   1131: aconst_null
    //   1132: iconst_1
    //   1133: invokespecial 413	com/whatsapp/vk$c:<init>	(Lcom/whatsapp/vk$d;Ljava/lang/String;Z)V
    //   1136: astore_3
    //   1137: aload_0
    //   1138: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1141: lload 8
    //   1143: putfield 1060	com/whatsapp/vo:k	J
    //   1146: aload 15
    //   1148: invokestatic 998	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1151: aload 17
    //   1153: invokevirtual 321	java/io/InputStream:close	()V
    //   1156: aload 18
    //   1158: invokevirtual 1061	java/io/OutputStream:close	()V
    //   1161: aload_0
    //   1162: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1165: invokevirtual 1000	com/whatsapp/vo:m	()Z
    //   1168: ifne +10 -> 1178
    //   1171: aload_0
    //   1172: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1175: invokevirtual 965	com/whatsapp/vo:a	()V
    //   1178: aload_3
    //   1179: astore_1
    //   1180: aload_0
    //   1181: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1184: invokevirtual 1002	com/whatsapp/vo:l	()Z
    //   1187: ifne -850 -> 337
    //   1190: aload_0
    //   1191: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1194: invokevirtual 1003	com/whatsapp/vo:c	()V
    //   1197: aload_3
    //   1198: areturn
    //   1199: astore 18
    //   1201: aload 15
    //   1203: astore 17
    //   1205: aload 16
    //   1207: invokevirtual 1064	java/io/File:getParentFile	()Ljava/io/File;
    //   1210: astore 19
    //   1212: aload 15
    //   1214: astore 17
    //   1216: new 254	java/lang/StringBuilder
    //   1219: dup
    //   1220: invokespecial 699	java/lang/StringBuilder:<init>	()V
    //   1223: astore 20
    //   1225: aload 15
    //   1227: astore 17
    //   1229: aload 19
    //   1231: invokevirtual 1067	java/io/File:isDirectory	()Z
    //   1234: ifeq +225 -> 1459
    //   1237: ldc_w 1069
    //   1240: astore_1
    //   1241: aload 15
    //   1243: astore 17
    //   1245: aload 20
    //   1247: aload_1
    //   1248: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1251: astore 20
    //   1253: aload 15
    //   1255: astore 17
    //   1257: aload 19
    //   1259: invokevirtual 1072	java/io/File:canRead	()Z
    //   1262: ifeq +1170 -> 2432
    //   1265: ldc_w 1069
    //   1268: astore_1
    //   1269: aload 15
    //   1271: astore 17
    //   1273: aload 20
    //   1275: aload_1
    //   1276: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1279: astore 20
    //   1281: aload 15
    //   1283: astore 17
    //   1285: aload 19
    //   1287: invokevirtual 1075	java/io/File:canWrite	()Z
    //   1290: ifeq +176 -> 1466
    //   1293: ldc_w 1069
    //   1296: astore_1
    //   1297: aload 15
    //   1299: astore 17
    //   1301: aload 20
    //   1303: aload_1
    //   1304: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1310: astore_1
    //   1311: aload 15
    //   1313: astore 17
    //   1315: new 254	java/lang/StringBuilder
    //   1318: dup
    //   1319: ldc_w 1077
    //   1322: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1325: aload_2
    //   1326: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   1329: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1332: ldc_w 306
    //   1335: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: aload 4
    //   1340: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   1343: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1346: ldc_w 1079
    //   1349: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: aload 16
    //   1354: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1357: ldc_w 1081
    //   1360: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: aload_3
    //   1364: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1367: ldc_w 1083
    //   1370: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1373: aload 19
    //   1375: invokevirtual 1086	java/io/File:getPath	()Ljava/lang/String;
    //   1378: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: ldc_w 1088
    //   1384: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: aload_1
    //   1388: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1394: aload 18
    //   1396: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1399: aload 15
    //   1401: astore 17
    //   1403: new 19	com/whatsapp/vk$c
    //   1406: dup
    //   1407: getstatic 1090	com/whatsapp/vk$d:j	Lcom/whatsapp/vk$d;
    //   1410: aconst_null
    //   1411: iconst_0
    //   1412: invokespecial 413	com/whatsapp/vk$c:<init>	(Lcom/whatsapp/vk$d;Ljava/lang/String;Z)V
    //   1415: astore_3
    //   1416: aload 15
    //   1418: invokestatic 998	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1421: aload_0
    //   1422: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1425: invokevirtual 1000	com/whatsapp/vo:m	()Z
    //   1428: ifne +10 -> 1438
    //   1431: aload_0
    //   1432: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1435: invokevirtual 965	com/whatsapp/vo:a	()V
    //   1438: aload_3
    //   1439: astore_1
    //   1440: aload_0
    //   1441: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1444: invokevirtual 1002	com/whatsapp/vo:l	()Z
    //   1447: ifne -1110 -> 337
    //   1450: aload_0
    //   1451: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1454: invokevirtual 1003	com/whatsapp/vo:c	()V
    //   1457: aload_3
    //   1458: areturn
    //   1459: ldc_w 1092
    //   1462: astore_1
    //   1463: goto -222 -> 1241
    //   1466: ldc_w 1092
    //   1469: astore_1
    //   1470: goto -173 -> 1297
    //   1473: iconst_0
    //   1474: istore 5
    //   1476: goto -501 -> 975
    //   1479: astore_1
    //   1480: new 254	java/lang/StringBuilder
    //   1483: dup
    //   1484: ldc_w 1094
    //   1487: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1490: aload_2
    //   1491: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   1494: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1497: ldc_w 306
    //   1500: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: aload 4
    //   1505: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   1508: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1511: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1514: aload_1
    //   1515: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1518: new 19	com/whatsapp/vk$c
    //   1521: dup
    //   1522: getstatic 461	com/whatsapp/vk$d:a	Lcom/whatsapp/vk$d;
    //   1525: aconst_null
    //   1526: iconst_0
    //   1527: invokespecial 413	com/whatsapp/vk$c:<init>	(Lcom/whatsapp/vk$d;Ljava/lang/String;Z)V
    //   1530: astore_3
    //   1531: aload 15
    //   1533: invokestatic 998	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1536: aload 18
    //   1538: invokevirtual 1061	java/io/OutputStream:close	()V
    //   1541: aload_0
    //   1542: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1545: invokevirtual 1000	com/whatsapp/vo:m	()Z
    //   1548: ifne +10 -> 1558
    //   1551: aload_0
    //   1552: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1555: invokevirtual 965	com/whatsapp/vo:a	()V
    //   1558: aload_3
    //   1559: astore_1
    //   1560: aload_0
    //   1561: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1564: invokevirtual 1002	com/whatsapp/vo:l	()Z
    //   1567: ifne -1230 -> 337
    //   1570: aload_0
    //   1571: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1574: invokevirtual 1003	com/whatsapp/vo:c	()V
    //   1577: aload_3
    //   1578: areturn
    //   1579: astore_1
    //   1580: new 254	java/lang/StringBuilder
    //   1583: dup
    //   1584: ldc_w 1096
    //   1587: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1590: aload_2
    //   1591: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   1594: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1597: ldc_w 306
    //   1600: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1603: aload 4
    //   1605: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   1608: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1614: aload_1
    //   1615: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1618: goto -77 -> 1541
    //   1621: iconst_0
    //   1622: istore 5
    //   1624: goto -560 -> 1064
    //   1627: astore_1
    //   1628: new 254	java/lang/StringBuilder
    //   1631: dup
    //   1632: ldc_w 1098
    //   1635: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1638: aload_2
    //   1639: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   1642: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1645: ldc_w 306
    //   1648: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: aload 4
    //   1653: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   1656: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1659: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1662: aload_1
    //   1663: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1666: goto -510 -> 1156
    //   1669: astore_1
    //   1670: new 254	java/lang/StringBuilder
    //   1673: dup
    //   1674: ldc_w 1096
    //   1677: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1680: aload_2
    //   1681: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   1684: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1687: ldc_w 306
    //   1690: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1693: aload 4
    //   1695: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   1698: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1701: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1704: aload_1
    //   1705: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1708: goto -547 -> 1161
    //   1711: lload 8
    //   1713: lstore 6
    //   1715: lload 8
    //   1717: lstore 10
    //   1719: aload_1
    //   1720: iconst_1
    //   1721: anewarray 536	java/lang/Long
    //   1724: dup
    //   1725: iconst_0
    //   1726: ldc2_w 1038
    //   1729: lload 8
    //   1731: lmul
    //   1732: lload 12
    //   1734: ldiv
    //   1735: invokestatic 540	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1738: aastore
    //   1739: invokevirtual 834	com/whatsapp/vk:publishProgress	([Ljava/lang/Object;)V
    //   1742: lload 8
    //   1744: lstore 6
    //   1746: lload 8
    //   1748: lstore 10
    //   1750: aload 17
    //   1752: aload 20
    //   1754: iconst_0
    //   1755: sipush 8192
    //   1758: invokevirtual 1051	java/io/InputStream:read	([BII)I
    //   1761: istore 5
    //   1763: goto -751 -> 1012
    //   1766: lload 8
    //   1768: lstore 6
    //   1770: lload 8
    //   1772: lstore 10
    //   1774: aload_0
    //   1775: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1778: invokevirtual 1003	com/whatsapp/vo:c	()V
    //   1781: aload_0
    //   1782: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1785: lload 8
    //   1787: putfield 1060	com/whatsapp/vo:k	J
    //   1790: aload_0
    //   1791: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1794: invokevirtual 993	com/whatsapp/vo:d	()V
    //   1797: aload_0
    //   1798: aload_2
    //   1799: aload 16
    //   1801: aload_3
    //   1802: aload 4
    //   1804: aload 19
    //   1806: invokespecial 995	com/whatsapp/vk:a	(Lcom/whatsapp/protocol/j;Ljava/io/File;Ljava/io/File;Ljava/net/URL;Lcom/whatsapp/vk$b;)Lcom/whatsapp/vk$c;
    //   1809: astore_3
    //   1810: aload_0
    //   1811: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1814: invokevirtual 588	com/whatsapp/vo:e	()V
    //   1817: aload 15
    //   1819: invokestatic 998	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1822: aload 17
    //   1824: invokevirtual 321	java/io/InputStream:close	()V
    //   1827: aload 18
    //   1829: invokevirtual 1061	java/io/OutputStream:close	()V
    //   1832: aload_0
    //   1833: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1836: invokevirtual 1000	com/whatsapp/vo:m	()Z
    //   1839: ifne +10 -> 1849
    //   1842: aload_0
    //   1843: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1846: invokevirtual 965	com/whatsapp/vo:a	()V
    //   1849: aload_3
    //   1850: astore_1
    //   1851: aload_0
    //   1852: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1855: invokevirtual 1002	com/whatsapp/vo:l	()Z
    //   1858: ifne -1521 -> 337
    //   1861: aload_0
    //   1862: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1865: invokevirtual 1003	com/whatsapp/vo:c	()V
    //   1868: aload_3
    //   1869: areturn
    //   1870: astore_1
    //   1871: lload 6
    //   1873: lstore 10
    //   1875: lload 10
    //   1877: lstore 6
    //   1879: aload_0
    //   1880: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1883: aload_1
    //   1884: invokevirtual 573	com/whatsapp/vo:a	(Ljava/lang/Exception;)V
    //   1887: lload 10
    //   1889: lstore 6
    //   1891: aload_0
    //   1892: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1895: aload 4
    //   1897: invokestatic 581	com/whatsapp/i/d:a	(Ljava/net/URL;)Ljava/lang/String;
    //   1900: putfield 583	com/whatsapp/vo:m	Ljava/lang/String;
    //   1903: lload 10
    //   1905: lstore 6
    //   1907: new 254	java/lang/StringBuilder
    //   1910: dup
    //   1911: ldc_w 1100
    //   1914: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1917: aload_2
    //   1918: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   1921: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1924: ldc_w 306
    //   1927: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1930: aload 4
    //   1932: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   1935: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1938: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1941: aload_1
    //   1942: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1945: lload 10
    //   1947: lstore 6
    //   1949: new 19	com/whatsapp/vk$c
    //   1952: dup
    //   1953: getstatic 461	com/whatsapp/vk$d:a	Lcom/whatsapp/vk$d;
    //   1956: aconst_null
    //   1957: iconst_1
    //   1958: invokespecial 413	com/whatsapp/vk$c:<init>	(Lcom/whatsapp/vk$d;Ljava/lang/String;Z)V
    //   1961: astore_3
    //   1962: aload_0
    //   1963: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1966: lload 10
    //   1968: putfield 1060	com/whatsapp/vo:k	J
    //   1971: aload 15
    //   1973: invokestatic 998	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1976: aload 17
    //   1978: invokevirtual 321	java/io/InputStream:close	()V
    //   1981: aload 18
    //   1983: invokevirtual 1061	java/io/OutputStream:close	()V
    //   1986: aload_0
    //   1987: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   1990: invokevirtual 1000	com/whatsapp/vo:m	()Z
    //   1993: ifne +10 -> 2003
    //   1996: aload_0
    //   1997: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   2000: invokevirtual 965	com/whatsapp/vo:a	()V
    //   2003: aload_3
    //   2004: astore_1
    //   2005: aload_0
    //   2006: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   2009: invokevirtual 1002	com/whatsapp/vo:l	()Z
    //   2012: ifne -1675 -> 337
    //   2015: aload_0
    //   2016: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   2019: invokevirtual 1003	com/whatsapp/vo:c	()V
    //   2022: aload_3
    //   2023: areturn
    //   2024: astore_1
    //   2025: new 254	java/lang/StringBuilder
    //   2028: dup
    //   2029: ldc_w 1098
    //   2032: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2035: aload_2
    //   2036: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   2039: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2042: ldc_w 306
    //   2045: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2048: aload 4
    //   2050: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   2053: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2056: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2059: aload_1
    //   2060: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2063: goto -82 -> 1981
    //   2066: astore_1
    //   2067: new 254	java/lang/StringBuilder
    //   2070: dup
    //   2071: ldc_w 1096
    //   2074: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2077: aload_2
    //   2078: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   2081: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2084: ldc_w 306
    //   2087: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2090: aload 4
    //   2092: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   2095: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2098: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2101: aload_1
    //   2102: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2105: goto -119 -> 1986
    //   2108: astore_1
    //   2109: aload_0
    //   2110: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   2113: lload 6
    //   2115: putfield 1060	com/whatsapp/vo:k	J
    //   2118: aload_1
    //   2119: athrow
    //   2120: astore_1
    //   2121: aload 17
    //   2123: astore_3
    //   2124: aload 18
    //   2126: astore 16
    //   2128: aload 15
    //   2130: ifnull +8 -> 2138
    //   2133: aload 15
    //   2135: invokestatic 998	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   2138: aload_3
    //   2139: ifnull +7 -> 2146
    //   2142: aload_3
    //   2143: invokevirtual 321	java/io/InputStream:close	()V
    //   2146: aload 16
    //   2148: ifnull +8 -> 2156
    //   2151: aload 16
    //   2153: invokevirtual 1061	java/io/OutputStream:close	()V
    //   2156: aload_0
    //   2157: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   2160: invokevirtual 1000	com/whatsapp/vo:m	()Z
    //   2163: ifne +10 -> 2173
    //   2166: aload_0
    //   2167: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   2170: invokevirtual 965	com/whatsapp/vo:a	()V
    //   2173: aload_0
    //   2174: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   2177: invokevirtual 1002	com/whatsapp/vo:l	()Z
    //   2180: ifne +10 -> 2190
    //   2183: aload_0
    //   2184: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   2187: invokevirtual 1003	com/whatsapp/vo:c	()V
    //   2190: aload_1
    //   2191: athrow
    //   2192: astore_1
    //   2193: new 254	java/lang/StringBuilder
    //   2196: dup
    //   2197: ldc_w 1098
    //   2200: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2203: aload_2
    //   2204: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   2207: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2210: ldc_w 306
    //   2213: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2216: aload 4
    //   2218: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   2221: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2224: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2227: aload_1
    //   2228: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2231: goto -404 -> 1827
    //   2234: astore_1
    //   2235: new 254	java/lang/StringBuilder
    //   2238: dup
    //   2239: ldc_w 1096
    //   2242: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2245: aload_2
    //   2246: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   2249: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2252: ldc_w 306
    //   2255: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2258: aload 4
    //   2260: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   2263: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2266: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2269: aload_1
    //   2270: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2273: goto -441 -> 1832
    //   2276: astore_3
    //   2277: new 254	java/lang/StringBuilder
    //   2280: dup
    //   2281: ldc_w 1098
    //   2284: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2287: aload_2
    //   2288: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   2291: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2294: ldc_w 306
    //   2297: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2300: aload 4
    //   2302: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   2305: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2308: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2311: aload_3
    //   2312: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2315: goto -169 -> 2146
    //   2318: astore_3
    //   2319: new 254	java/lang/StringBuilder
    //   2322: dup
    //   2323: ldc_w 1096
    //   2326: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2329: aload_2
    //   2330: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   2333: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2336: ldc_w 306
    //   2339: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2342: aload 4
    //   2344: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   2347: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2350: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2353: aload_3
    //   2354: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2357: goto -201 -> 2156
    //   2360: astore_1
    //   2361: aconst_null
    //   2362: astore 15
    //   2364: aconst_null
    //   2365: astore_3
    //   2366: aconst_null
    //   2367: astore 16
    //   2369: goto -241 -> 2128
    //   2372: astore_1
    //   2373: aconst_null
    //   2374: astore_3
    //   2375: aconst_null
    //   2376: astore 16
    //   2378: aload 17
    //   2380: astore 15
    //   2382: goto -254 -> 2128
    //   2385: astore_3
    //   2386: aload_1
    //   2387: astore 15
    //   2389: aconst_null
    //   2390: astore 17
    //   2392: aconst_null
    //   2393: astore 16
    //   2395: aload_3
    //   2396: astore_1
    //   2397: aload 17
    //   2399: astore_3
    //   2400: goto -272 -> 2128
    //   2403: astore_1
    //   2404: aconst_null
    //   2405: astore_3
    //   2406: aload 18
    //   2408: astore 16
    //   2410: goto -282 -> 2128
    //   2413: astore_1
    //   2414: goto -305 -> 2109
    //   2417: astore_1
    //   2418: goto -543 -> 1875
    //   2421: astore_3
    //   2422: goto -1806 -> 616
    //   2425: astore_3
    //   2426: aload 15
    //   2428: astore_1
    //   2429: goto -1897 -> 532
    //   2432: ldc_w 1092
    //   2435: astore_1
    //   2436: goto -1167 -> 1269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2439	0	this	vk
    //   0	2439	1	paramvk	vk
    //   0	2439	2	paramj	j
    //   0	2439	3	paramFile	File
    //   0	2439	4	paramURL	URL
    //   20	1742	5	i1	int
    //   107	2007	6	l1	long
    //   118	1668	8	l2	long
    //   1023	944	10	l3	long
    //   413	1320	12	l4	long
    //   226	3	14	bool	boolean
    //   4	2423	15	localObject1	Object
    //   36	2373	16	localObject2	Object
    //   140	2258	17	localObject3	Object
    //   279	56	18	localc	c
    //   345	52	18	localNumberFormatException	NumberFormatException
    //   923	234	18	localFileOutputStream	FileOutputStream
    //   1199	1208	18	localFileNotFoundException	FileNotFoundException
    //   168	1637	19	localObject4	Object
    //   200	1553	20	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   237	252	345	java/lang/NumberFormatException
    //   256	263	345	java/lang/NumberFormatException
    //   267	281	345	java/lang/NumberFormatException
    //   285	292	345	java/lang/NumberFormatException
    //   120	138	529	com/whatsapp/MediaDownloadConnection$ConnectionFailureException
    //   120	138	612	java/io/IOException
    //   913	925	1199	java/io/FileNotFoundException
    //   955	972	1479	java/io/IOException
    //   975	988	1479	java/io/IOException
    //   1536	1541	1579	java/io/IOException
    //   1151	1156	1627	java/io/IOException
    //   1156	1161	1669	java/io/IOException
    //   988	1008	1870	java/io/IOException
    //   1976	1981	2024	java/io/IOException
    //   1981	1986	2066	java/io/IOException
    //   988	1008	2108	finally
    //   1137	1146	2120	finally
    //   1781	1817	2120	finally
    //   1962	1971	2120	finally
    //   2109	2120	2120	finally
    //   1822	1827	2192	java/io/IOException
    //   1827	1832	2234	java/io/IOException
    //   2142	2146	2276	java/io/IOException
    //   2151	2156	2318	java/io/IOException
    //   120	138	2360	finally
    //   142	149	2372	finally
    //   153	170	2372	finally
    //   174	188	2372	finally
    //   192	202	2372	finally
    //   206	214	2372	finally
    //   218	228	2372	finally
    //   237	252	2372	finally
    //   256	263	2372	finally
    //   267	281	2372	finally
    //   285	292	2372	finally
    //   351	401	2372	finally
    //   405	415	2372	finally
    //   419	428	2372	finally
    //   432	469	2372	finally
    //   473	486	2372	finally
    //   620	658	2372	finally
    //   662	666	2372	finally
    //   670	677	2372	finally
    //   681	685	2372	finally
    //   689	697	2372	finally
    //   701	713	2372	finally
    //   717	728	2372	finally
    //   780	787	2372	finally
    //   791	798	2372	finally
    //   802	806	2372	finally
    //   813	823	2372	finally
    //   827	838	2372	finally
    //   842	849	2372	finally
    //   853	866	2372	finally
    //   913	925	2372	finally
    //   1205	1212	2372	finally
    //   1216	1225	2372	finally
    //   1229	1237	2372	finally
    //   1245	1253	2372	finally
    //   1257	1265	2372	finally
    //   1273	1281	2372	finally
    //   1285	1293	2372	finally
    //   1301	1311	2372	finally
    //   1315	1399	2372	finally
    //   1403	1416	2372	finally
    //   532	566	2385	finally
    //   932	955	2403	finally
    //   955	972	2403	finally
    //   975	988	2403	finally
    //   1480	1531	2403	finally
    //   1025	1035	2413	finally
    //   1051	1061	2413	finally
    //   1077	1084	2413	finally
    //   1092	1101	2413	finally
    //   1109	1116	2413	finally
    //   1124	1137	2413	finally
    //   1719	1742	2413	finally
    //   1750	1763	2413	finally
    //   1774	1781	2413	finally
    //   1879	1887	2413	finally
    //   1891	1903	2413	finally
    //   1907	1945	2413	finally
    //   1949	1962	2413	finally
    //   1025	1035	2417	java/io/IOException
    //   1051	1061	2417	java/io/IOException
    //   1077	1084	2417	java/io/IOException
    //   1092	1101	2417	java/io/IOException
    //   1109	1116	2417	java/io/IOException
    //   1124	1137	2417	java/io/IOException
    //   1719	1742	2417	java/io/IOException
    //   1750	1763	2417	java/io/IOException
    //   1774	1781	2417	java/io/IOException
    //   142	149	2421	java/io/IOException
    //   153	170	2421	java/io/IOException
    //   174	188	2421	java/io/IOException
    //   192	202	2421	java/io/IOException
    //   206	214	2421	java/io/IOException
    //   218	228	2421	java/io/IOException
    //   237	252	2421	java/io/IOException
    //   256	263	2421	java/io/IOException
    //   267	281	2421	java/io/IOException
    //   285	292	2421	java/io/IOException
    //   351	401	2421	java/io/IOException
    //   142	149	2425	com/whatsapp/MediaDownloadConnection$ConnectionFailureException
    //   153	170	2425	com/whatsapp/MediaDownloadConnection$ConnectionFailureException
    //   174	188	2425	com/whatsapp/MediaDownloadConnection$ConnectionFailureException
    //   192	202	2425	com/whatsapp/MediaDownloadConnection$ConnectionFailureException
    //   206	214	2425	com/whatsapp/MediaDownloadConnection$ConnectionFailureException
    //   218	228	2425	com/whatsapp/MediaDownloadConnection$ConnectionFailureException
    //   237	252	2425	com/whatsapp/MediaDownloadConnection$ConnectionFailureException
    //   256	263	2425	com/whatsapp/MediaDownloadConnection$ConnectionFailureException
    //   267	281	2425	com/whatsapp/MediaDownloadConnection$ConnectionFailureException
    //   285	292	2425	com/whatsapp/MediaDownloadConnection$ConnectionFailureException
    //   351	401	2425	com/whatsapp/MediaDownloadConnection$ConnectionFailureException
  }
  
  private static d b(j paramj, File paramFile1, File paramFile2, URL paramURL, b paramb)
  {
    String str = MediaFileUtils.c(paramFile1);
    if (str == null)
    {
      Log.w("MMS download failed to calculate hash; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL) + "; downloadFile=" + paramFile2.getAbsolutePath() + "; downloadFile.exists?=" + paramFile2.exists());
      paramFile1.delete();
      paramFile2.delete();
      return d.a;
    }
    if (!str.equals(paramb.b))
    {
      Log.w("MMS download failed due to hash mismatch; message.key=" + paramj.e + "; url=" + MediaFileUtils.a(paramURL) + "; receivedHash=" + paramb.b + "; localHash=" + str);
      return d.h;
    }
    return d.d;
  }
  
  private File c(j paramj)
  {
    if (paramj.u != null)
    {
      paramj = paramj.u.replace('/', '-') + ".chk.tmp";
      return this.q.a(paramj);
    }
    Log.e("app/downloadmedia/no_url");
    return null;
  }
  
  private URL d(j paramj)
  {
    Object localObject = j.a(paramj.s);
    this.j = aic.c((String)localObject);
    this.e.e = this.j;
    Log.i("mediadownload/geturl/mms4EnabledForThisDownload=" + this.j + " filetype=" + (String)localObject + " key=" + paramj.e);
    if (((this.j) && (paramj.v != null)) || (paramj.p == null))
    {
      Uri.Builder localBuilder = new Uri.Builder();
      long l1 = SystemClock.elapsedRealtime();
      this.l = this.s.b();
      long l2 = SystemClock.elapsedRealtime();
      if (this.l == null) {
        return null;
      }
      this.e.l = Long.valueOf(l2 - l1);
      Log.d("mediadownload/getselectedroute/took " + (l2 - l1) + "ms to get route");
      localBuilder.scheme("https").authority(this.l.c).appendPath("mms").appendPath((String)localObject).appendPath(be.d(paramj.v));
      localObject = localBuilder.build();
      if (!TextUtils.isEmpty(((Uri)localObject).getHost())) {
        break label328;
      }
      Log.w("MMS url attached to message has no host; message.key=" + paramj.e + " url=" + paramj.p);
      paramj = null;
    }
    for (;;)
    {
      return paramj;
      localObject = paramj.b();
      if ((localObject != null) && (((MediaData)localObject).refKey != null)) {}
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label318;
        }
        localObject = Uri.parse(paramj.p);
        break;
      }
      label318:
      localObject = b(paramj);
      break;
      try
      {
        label328:
        localObject = new URL(((Uri)localObject).toString());
        paramj = (j)localObject;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Log.c("MMS url attached to message is malformed; message.key=" + paramj.e + " url=" + paramj.p, localMalformedURLException);
        paramj = null;
      }
    }
  }
  
  private void d()
  {
    if ((this.a.s == 9) && ("application/pdf".equals(this.a.r)))
    {
      com.whatsapp.util.av localav = new com.whatsapp.util.av(this.i);
      try
      {
        localav.a();
        MediaData localMediaData = this.b;
        if (localav.b) {}
        for (int i1 = MediaData.SUSPICIOUS_CONTENT_YES_KEEP;; i1 = MediaData.SUSPICIOUS_CONTENT_NO)
        {
          localMediaData.suspiciousContent = i1;
          return;
        }
        if (this.a.s == 3) {}
      }
      catch (av.c localc)
      {
        this.b.suspiciousContent = MediaData.SUSPICIOUS_CONTENT_YES_KEEP;
        Log.d("Failed to parse document", localc);
        return;
      }
      catch (IOException localIOException)
      {
        Log.d("Failed to parse document", localIOException);
        return;
      }
    }
    if (((this.a.s == 13) || (this.a.s == 2)) && (MediaFileUtils.a(this.a.s, this.i))) {
      try
      {
        Mp4Ops.a(this.i, false);
        Mp4Ops.a("checkAndRepair", "check on download");
        return;
      }
      catch (Mp4Ops.a locala)
      {
        if (!isCancelled())
        {
          Mp4Ops.a(this.o, this.i, locala, "check on download");
          Mp4Ops.a("checkAndRepair", "check on download", locala);
          if (locala.a < 300)
          {
            Log.w("MediaDownload/suspicious video/audio found, file deleted");
            this.b.suspiciousContent = MediaData.SUSPICIOUS_CONTENT_YES;
            this.i.delete();
          }
        }
      }
    }
  }
  
  /* Error */
  final void a(j paramj, URL paramURL, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 97	com/whatsapp/vk:j	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_2
    //   9: invokevirtual 1236	java/net/URL:toString	()Ljava/lang/String;
    //   12: invokestatic 852	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   15: invokevirtual 856	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   18: astore 5
    //   20: aload_0
    //   21: aload_3
    //   22: invokespecial 1238	com/whatsapp/vk:a	([B)Ljava/lang/String;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnonnull +37 -> 64
    //   30: new 254	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 1240
    //   37: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_1
    //   41: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   44: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: ldc_w 306
    //   50: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_2
    //   54: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 313	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   63: return
    //   64: aload 5
    //   66: ldc_w 1242
    //   69: aload_3
    //   70: invokevirtual 865	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   73: pop
    //   74: new 1185	java/net/URL
    //   77: dup
    //   78: aload 5
    //   80: invokevirtual 1243	android/net/Uri$Builder:toString	()Ljava/lang/String;
    //   83: invokespecial 1187	java/net/URL:<init>	(Ljava/lang/String;)V
    //   86: astore 5
    //   88: new 254	java/lang/StringBuilder
    //   91: dup
    //   92: ldc_w 1245
    //   95: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: aload_1
    //   99: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   102: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: ldc_w 306
    //   108: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_2
    //   112: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: ldc_w 1247
    //   118: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_3
    //   122: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 289	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   131: aload 5
    //   133: invokevirtual 1251	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   136: astore 5
    //   138: aload 5
    //   140: instanceof 976
    //   143: ifeq +235 -> 378
    //   146: aload 5
    //   148: checkcast 976	javax/net/ssl/HttpsURLConnection
    //   151: astore 5
    //   153: aload 5
    //   155: ldc_w 1253
    //   158: invokevirtual 1256	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   161: aload 5
    //   163: invokestatic 1261	com/whatsapp/messaging/ar:a	()Lcom/whatsapp/messaging/ar;
    //   166: invokevirtual 1265	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   169: aload 5
    //   171: sipush 15000
    //   174: invokevirtual 1269	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   177: aload 5
    //   179: sipush 30000
    //   182: invokevirtual 1272	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   185: aload 5
    //   187: ldc_w 1274
    //   190: invokestatic 1278	com/whatsapp/ape:a	()Ljava/lang/String;
    //   193: invokevirtual 1281	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload 5
    //   198: ldc_w 1283
    //   201: ldc_w 1285
    //   204: invokevirtual 1281	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload 5
    //   209: invokevirtual 979	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   212: istore 4
    //   214: iload 4
    //   216: sipush 200
    //   219: if_icmpeq +57 -> 276
    //   222: new 254	java/lang/StringBuilder
    //   225: dup
    //   226: ldc_w 1287
    //   229: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   232: aload_1
    //   233: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   236: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   239: ldc_w 306
    //   242: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_2
    //   246: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   249: ldc_w 1247
    //   252: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_3
    //   256: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc_w 1289
    //   262: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: iload 4
    //   267: invokevirtual 679	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 313	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   276: aload 5
    //   278: invokevirtual 1292	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   281: return
    //   282: astore 5
    //   284: new 254	java/lang/StringBuilder
    //   287: dup
    //   288: ldc_w 1294
    //   291: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   294: aload_1
    //   295: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   298: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   301: ldc_w 306
    //   304: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_2
    //   308: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   311: ldc_w 1247
    //   314: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_3
    //   318: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: aload 5
    //   326: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   329: return
    //   330: astore 5
    //   332: new 254	java/lang/StringBuilder
    //   335: dup
    //   336: ldc_w 1296
    //   339: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   342: aload_1
    //   343: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   346: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   349: ldc_w 306
    //   352: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_2
    //   356: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   359: ldc_w 1247
    //   362: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_3
    //   366: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: aload 5
    //   374: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   377: return
    //   378: new 254	java/lang/StringBuilder
    //   381: dup
    //   382: ldc_w 1298
    //   385: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   388: aload_1
    //   389: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   392: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   395: ldc_w 306
    //   398: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_2
    //   402: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: ldc_w 1247
    //   408: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_3
    //   412: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 313	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   421: return
    //   422: astore 5
    //   424: new 254	java/lang/StringBuilder
    //   427: dup
    //   428: ldc_w 1300
    //   431: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   434: aload_1
    //   435: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   438: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   441: ldc_w 306
    //   444: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload_2
    //   448: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   451: ldc_w 1247
    //   454: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload_3
    //   458: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: aload 5
    //   466: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   469: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	vk
    //   0	470	1	paramj	j
    //   0	470	2	paramURL	URL
    //   0	470	3	paramArrayOfByte	byte[]
    //   212	54	4	i1	int
    //   18	259	5	localObject	Object
    //   282	43	5	localIOException1	IOException
    //   330	43	5	localMalformedURLException	MalformedURLException
    //   422	43	5	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   207	214	282	java/io/IOException
    //   222	276	282	java/io/IOException
    //   276	281	282	java/io/IOException
    //   74	88	330	java/net/MalformedURLException
    //   131	207	422	java/io/IOException
    //   378	421	422	java/io/IOException
  }
  
  protected final void a(c paramc)
  {
    boolean bool2 = false;
    Log.i("MMS post execute; message.key=" + this.a.e + " url=" + MediaFileUtils.a(this.c) + " status=" + paramc);
    this.b.transferring = false;
    this.b.prefetching = false;
    this.b.streamViewable = false;
    this.b.transferred = paramc.a();
    label266:
    Object localObject2;
    if (paramc.a())
    {
      this.b.fileSize = this.i.length();
      this.b.showDownloadedBytes = true;
      if (paramc.b != null)
      {
        ??? = paramc.b;
        this.b.file = a(this.a, (String)???);
        if (this.g != null) {
          this.g.a(a.b.b);
        }
        if (this.b.suspiciousContent != MediaData.SUSPICIOUS_CONTENT_YES)
        {
          if (this.b.suspiciousContent == MediaData.SUSPICIOUS_CONTENT_YES_KEEP) {
            Log.i("MMS keeping suspicious download file");
          }
          if (Build.VERSION.SDK_INT < 21) {
            break label1200;
          }
          if (MediaFileUtils.OsRename.attempt(this.i, this.b.file) > 0)
          {
            if (MediaFileUtils.OsRename.attempt(this.i, this.b.file) <= 0) {
              break label1171;
            }
            Log.i("MMS download second try rename failed message.key=" + this.a.e);
          }
        }
        localObject2 = ???;
        if (this.g != null)
        {
          this.g.a(this.b.file);
          this.g.a(a.b.c);
          this.g.n();
          this.g.c();
          ((File)a.d.a(a(this.q, this.a, true))).delete();
          localObject2 = ???;
        }
      }
    }
    for (;;)
    {
      synchronized (C)
      {
        C.remove(this.a.e);
        this.x.b(this.a);
        if (this.a.f() != null)
        {
          this.A.a(this.a.f(), vm.a(this, paramc, (String)localObject2));
          ??? = this.e;
          ((vo)???).h = paramc;
          ((vo)???).g = Long.valueOf(SystemClock.elapsedRealtime());
          ((vo)???).o = vo.a.e;
          ??? = this.a;
          vo localvo = this.e;
          localObject2 = new ar();
          Object localObject3 = ((j)???).b();
          int i1 = a.a.a.a.d.a(localvo.h.a, (MediaData)localObject3);
          l1 = localvo.k().longValue();
          localObject3 = localvo.l;
          ((ar)localObject2).a = Integer.valueOf(a.a.a.a.d.a((j)???));
          ((ar)localObject2).b = Integer.valueOf(i1);
          ((ar)localObject2).m = Double.valueOf(((j)???).t);
          if (l1 > 0L) {
            ((ar)localObject2).l = Double.valueOf(l1);
          }
          ((ar)localObject2).t = Integer.valueOf(a.a.a.a.d.a(localvo.a));
          boolean bool1 = bool2;
          if (((j)???).g() != null)
          {
            bool1 = bool2;
            if (((j)???).g().b()) {
              bool1 = true;
            }
          }
          ((ar)localObject2).f = Boolean.valueOf(bool1);
          ((ar)localObject2).d = Boolean.valueOf(localvo.n());
          ((ar)localObject2).j = Long.valueOf(localvo.f());
          ((ar)localObject2).q = Double.valueOf(localvo.g());
          ((ar)localObject2).o = Double.valueOf(localvo.h());
          ((ar)localObject2).s = Double.valueOf(localvo.i());
          ((ar)localObject2).r = Double.valueOf(localvo.j());
          ((ar)localObject2).e = Double.valueOf(localvo.k);
          ((ar)localObject2).g = localvo.o();
          if (!localvo.e) {
            break label2044;
          }
          l1 = 4L;
          ((ar)localObject2).k = Long.valueOf(l1);
          ((ar)localObject2).u = Integer.valueOf(localvo.c);
          if (!a.a.a.a.d.a(localvo.h.a)) {
            break label2052;
          }
          ??? = localvo.m;
          ((ar)localObject2).v = ((String)???);
          if (!a.a.a.a.d.a(localvo.h.a)) {
            break label2058;
          }
          ??? = localvo.n;
          ((ar)localObject2).w = ((String)???);
          if (localObject3 != null) {
            ((ar)localObject2).p = Double.valueOf(((Long)localObject3).longValue());
          }
          if ((i1 != 1) && (i1 != 12)) {
            break label2064;
          }
          com.whatsapp.fieldstats.l.a(u.a(), (com.whatsapp.fieldstats.e)localObject2);
          com.whatsapp.fieldstats.l.a(u.a(), (com.whatsapp.fieldstats.e)localObject2);
          w.a().c();
          if (av.k())
          {
            ??? = new StringBuilder("mediadownload/event/mode=").append(this.e.a).append(", type=").append(this.e.b).append(", download_result=").append(paramc).append(", totalDownloadTime=").append(this.e.k()).append(", networkDownloadTime=").append(this.e.g()).append(", connectTime=").append(this.e.h()).append(", isStreamingUpload=").append(a(this.a)).append(", size=").append(this.a.t).append(", downloadResumePoint=").append(this.e.f()).append(", bytesTransferred=").append(this.e.k).append(", timeToFirstByteTime=").append(this.e.i()).append(", fileValidationTime=").append(this.e.j()).append(", url=");
            if (this.c != null) {
              break label2075;
            }
            paramc = null;
            Log.d(MediaFileUtils.a(paramc) + ", ip=" + this.e.m + ", exception=" + this.e.n + " " + this.a.e);
          }
          this.m = null;
          return;
          if (this.a.p != null)
          {
            ??? = a.a.a.a.d.l(this.a.p);
            break;
          }
          ??? = null;
          break;
          label1171:
          Log.i("MMS download second try rename succeeded message.key=" + this.a.e);
          break label266;
          label1200:
          if (this.i.renameTo(this.b.file)) {
            break label266;
          }
          Log.i("MMS download file rename failed message.key=" + this.a.e);
          break label266;
          if ((this.m != null) && (!a.a.a.a.d.a(this.m)))
          {
            i1 = 1;
            i2 = i1;
            if (this.g != null)
            {
              localObject2 = this.g;
              bool1 = paramc.a.a();
              if ((paramc.a.a()) || (paramc.a == d.j)) {
                continue;
              }
              if (paramc.a != d.e) {
                continue;
              }
              ??? = u.a();
              if (vv.i())
              {
                i2 = 2131297061;
                ??? = ((Context)???).getString(i2);
                ((com.whatsapp.m.a)localObject2).a(bool1, (String)???);
                this.g.a(a.b.d);
                this.g.n();
                if ((i1 == 0) || (!this.g.a())) {
                  continue;
                }
                i2 = 1;
              }
            }
            else
            {
              if (i2 != 0)
              {
                localObject2 = (ng)this.m;
                if (localObject2 == this.n.e) {
                  continue;
                }
                Log.i("mediadownload/notifyuser/notvisible/skip");
              }
              if (this.i.length() == 0L)
              {
                this.i.delete();
                this.b.failErrorCode = paramc.a.n;
              }
              if ((paramc.a == d.k) || (paramc.a == d.f)) {
                this.b.autodownloadRetryEnabled = false;
              }
              localObject2 = null;
            }
          }
          else
          {
            i1 = 0;
            continue;
          }
          int i2 = 2131297062;
          continue;
          if (paramc.a == d.f)
          {
            if (qz.e(this.a.e.a))
            {
              ??? = this.a.f;
              if (??? != null)
              {
                ??? = this.t.a((String)???);
                ??? = u.a().getString(2131297989, new Object[] { ((cs)???).a(u.a()) });
              }
            }
            else
            {
              ??? = this.a.e.a;
              continue;
            }
            ??? = u.a().getString(2131297065);
            continue;
          }
          if (paramc.a == d.k)
          {
            ??? = u.a().getString(2131297842);
            continue;
          }
          if (paramc.a == d.i)
          {
            ??? = u.a().getString(2131297065);
            continue;
          }
          ??? = u.a().getString(2131298049);
          continue;
          i2 = 0;
          continue;
          if (paramc.a.a())
          {
            ((ng)localObject2).a(2131296692, 2131298049, new Object[0]);
            continue;
          }
          if (paramc.a == d.j)
          {
            if (!this.w.a(this.E)) {
              continue;
            }
            Log.w("MMS download failed due to output stream failure other than SD card state; message.key=" + this.a.e + " url=" + MediaFileUtils.a(this.c));
            ((ng)localObject2).a(2131296692, 2131298049, new Object[0]);
            continue;
          }
          if (paramc.a == d.e)
          {
            if (vv.i())
            {
              i1 = 2131297061;
              ((ng)localObject2).a(2131296692, i1, new Object[0]);
              continue;
            }
            i1 = 2131297062;
            continue;
          }
          if (paramc.a == d.f)
          {
            if ((qz.e(this.a.e.a)) || (this.a.a()))
            {
              ??? = this.a.f;
              if (??? != null) {
                ((ng)localObject2).a(2131296692, 2131297989, new Object[] { this.t.a((String)???).a(this.m) });
              }
            }
            else
            {
              ??? = this.a.e.a;
              continue;
            }
            ((ng)localObject2).a(2131296692, 2131297065, new Object[0]);
            continue;
          }
          if (paramc.a == d.k)
          {
            ((ng)localObject2).a(2131296692, 2131297842, new Object[0]);
            continue;
          }
          if (paramc.a != d.i) {
            continue;
          }
          ((ng)localObject2).a(2131296692, 2131297065, new Object[0]);
        }
      }
      a(paramc, (String)localObject2);
      this.h.e(this.a, 3);
      continue;
      label2044:
      long l1 = 3L;
      continue;
      label2052:
      ??? = null;
      continue;
      label2058:
      ??? = null;
      continue;
      label2064:
      com.whatsapp.fieldstats.l.c(u.a(), (com.whatsapp.fieldstats.e)localObject2);
      continue;
      label2075:
      paramc = this.c.toString();
    }
  }
  
  final void a(c paramc, String paramString)
  {
    for (;;)
    {
      j localj;
      MediaData localMediaData;
      synchronized (C)
      {
        Object localObject = (List)D.remove(this.a.u);
        if (localObject == null) {
          break label325;
        }
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label331;
        }
        localj = (j)((Iterator)localObject).next();
        if (localj == this.a) {
          continue;
        }
        localMediaData = localj.b();
        localMediaData.transferring = false;
        localMediaData.prefetching = false;
        localMediaData.transferred = this.b.transferred;
        localMediaData.dedupeDownload = this.b.dedupeDownload;
        if (paramc.a())
        {
          localMediaData.width = this.b.width;
          localMediaData.height = this.b.height;
          localMediaData.fileSize = this.b.fileSize;
          if (((localj.s == 3) || (localj.s == 13)) && (!((com.whatsapp.protocol.l)a.d.a(localj.f())).d())) {
            localj.f().a(((com.whatsapp.protocol.l)a.d.a(this.a.f())).b());
          }
          localMediaData.file = a(localj, paramString);
        }
      }
      try
      {
        MediaFileUtils.a(this.b.file, localMediaData.file);
        C.remove(localj.e);
        this.h.e(localj, 3);
        continue;
        paramc = finally;
        throw paramc;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localMediaData.transferred = false;
          Log.d("MMS download failed to copy file to duplicate download; originalMessage.key=" + this.a.e + " duplicateMessage.key=" + localj.e, localIOException);
        }
      }
    }
    label325:
    Log.e("MMS download missing duplicate downloads list");
    label331:
  }
  
  public final void b()
  {
    Object localObject1 = null;
    for (;;)
    {
      synchronized (C)
      {
        Log.i("MMS media download canceled; message.key=" + this.a.e + " url=" + MediaFileUtils.a(this.c));
        Object localObject3 = (List)D.get(this.a.u);
        if (localObject3 != null) {
          localObject1 = ((j)((List)localObject3).get(0)).b().downloader;
        }
        if ((localObject1 != null) && (localObject1 != this))
        {
          ((vk)localObject1).b();
          return;
        }
        cancel(true);
        vc.a().b(this.a);
        C.remove(this.a.e);
        if (!this.b.transferred)
        {
          this.b.transferring = false;
          this.b.transferred = false;
          this.b.streamViewable = false;
          this.b.autodownloadRetryEnabled = false;
          this.h.e(this.a, -1);
        }
        D.remove(this.a.u);
        if (localObject3 != null)
        {
          localObject1 = ((List)localObject3).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (j)((Iterator)localObject1).next();
            if (localObject3 == this.a) {
              continue;
            }
            vc.a().b((j)localObject3);
            MediaData localMediaData = ((j)localObject3).b();
            localMediaData.transferring = false;
            localMediaData.transferred = this.b.transferred;
            localMediaData.streamViewable = false;
            localMediaData.autodownloadRetryEnabled = false;
            if (localMediaData.downloader != null) {
              localMediaData.downloader.m = null;
            }
            this.h.e((j)localObject3, -1);
            C.remove(((j)localObject3).e);
          }
        }
      }
      this.m = null;
    }
  }
  
  /* Error */
  protected final c c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   4: astore 6
    //   6: aload 6
    //   8: invokestatic 1148	android/os/SystemClock:elapsedRealtime	()J
    //   11: invokestatic 540	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   14: putfield 1657	com/whatsapp/vo:f	Ljava/lang/Long;
    //   17: aload 6
    //   19: getstatic 1659	com/whatsapp/vo$a:a	Lcom/whatsapp/vo$a;
    //   22: putfield 1372	com/whatsapp/vo:o	Lcom/whatsapp/vo$a;
    //   25: aload_0
    //   26: aload_0
    //   27: aload_0
    //   28: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   31: invokespecial 1661	com/whatsapp/vk:d	(Lcom/whatsapp/protocol/j;)Ljava/net/URL;
    //   34: putfield 1305	com/whatsapp/vk:c	Ljava/net/URL;
    //   37: aload_0
    //   38: getfield 1305	com/whatsapp/vk:c	Ljava/net/URL;
    //   41: ifnonnull +18 -> 59
    //   44: new 19	com/whatsapp/vk$c
    //   47: dup
    //   48: getstatic 1576	com/whatsapp/vk$d:i	Lcom/whatsapp/vk$d;
    //   51: invokespecial 1664	com/whatsapp/vk$c:<init>	(Lcom/whatsapp/vk$d;)V
    //   54: astore 6
    //   56: aload 6
    //   58: areturn
    //   59: aload_0
    //   60: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   63: aload_0
    //   64: getfield 1305	com/whatsapp/vk:c	Ljava/net/URL;
    //   67: putfield 1666	com/whatsapp/vo:d	Ljava/net/URL;
    //   70: invokestatic 562	com/whatsapp/u:a	()Landroid/content/Context;
    //   73: aload_0
    //   74: getfield 132	com/whatsapp/vk:q	Lcom/whatsapp/oz;
    //   77: invokestatic 1669	com/whatsapp/util/MediaFileUtils:a	(Landroid/content/Context;Lcom/whatsapp/oz;)V
    //   80: aload_0
    //   81: getfield 174	com/whatsapp/vk:v	Lcom/whatsapp/data/y;
    //   84: aload_0
    //   85: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   88: getfield 346	com/whatsapp/protocol/j:u	Ljava/lang/String;
    //   91: iconst_1
    //   92: invokevirtual 1672	com/whatsapp/data/y:a	(Ljava/lang/String;Z)Lcom/whatsapp/MediaData;
    //   95: astore 6
    //   97: aload 6
    //   99: ifnull +529 -> 628
    //   102: aload 6
    //   104: getfield 1320	com/whatsapp/MediaData:file	Ljava/io/File;
    //   107: astore 6
    //   109: aload 6
    //   111: ifnull +238 -> 349
    //   114: new 254	java/lang/StringBuilder
    //   117: dup
    //   118: ldc_w 1674
    //   121: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   124: aload_0
    //   125: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   128: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   131: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: ldc_w 1676
    //   137: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   144: getfield 346	com/whatsapp/protocol/j:u	Ljava/lang/String;
    //   147: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc_w 1678
    //   153: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload 6
    //   158: invokevirtual 1108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   161: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 289	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   170: aload 6
    //   172: invokestatic 1103	com/whatsapp/util/MediaFileUtils:c	(Ljava/io/File;)Ljava/lang/String;
    //   175: astore 7
    //   177: aload_0
    //   178: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   181: getfield 346	com/whatsapp/protocol/j:u	Ljava/lang/String;
    //   184: aload 7
    //   186: invokevirtual 1113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   189: ifeq +445 -> 634
    //   192: aload 6
    //   194: aload_0
    //   195: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   198: invokestatic 1625	com/whatsapp/util/MediaFileUtils:a	(Ljava/io/File;Ljava/io/File;)V
    //   201: aload_0
    //   202: invokespecial 1679	com/whatsapp/vk:d	()V
    //   205: aload_0
    //   206: getfield 505	com/whatsapp/vk:g	Lcom/whatsapp/m/a;
    //   209: ifnull +41 -> 250
    //   212: aload_0
    //   213: aload_0
    //   214: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   217: invokespecial 513	com/whatsapp/vk:c	(Lcom/whatsapp/protocol/j;)Ljava/io/File;
    //   220: invokestatic 494	a/a/a/a/a/a$d:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   223: checkcast 417	java/io/File
    //   226: astore 7
    //   228: aload 7
    //   230: invokevirtual 644	java/io/File:exists	()Z
    //   233: ifeq +17 -> 250
    //   236: aload 7
    //   238: invokevirtual 471	java/io/File:delete	()Z
    //   241: ifne +9 -> 250
    //   244: ldc_w 1681
    //   247: invokestatic 313	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   250: aload_0
    //   251: getfield 241	com/whatsapp/vk:b	Lcom/whatsapp/MediaData;
    //   254: getfield 447	com/whatsapp/MediaData:refKey	[B
    //   257: ifnull +10 -> 267
    //   260: aload_0
    //   261: invokestatic 1686	com/whatsapp/vl:a	(Lcom/whatsapp/vk;)Ljava/lang/Runnable;
    //   264: invokestatic 388	com/whatsapp/util/bu:a	(Ljava/lang/Runnable;)V
    //   267: new 19	com/whatsapp/vk$c
    //   270: dup
    //   271: getstatic 415	com/whatsapp/vk$d:d	Lcom/whatsapp/vk$d;
    //   274: aload 6
    //   276: invokevirtual 1108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   279: invokestatic 747	a/a/a/a/d:l	(Ljava/lang/String;)Ljava/lang/String;
    //   282: iconst_0
    //   283: invokespecial 413	com/whatsapp/vk$c:<init>	(Lcom/whatsapp/vk$d;Ljava/lang/String;Z)V
    //   286: astore 7
    //   288: aload 7
    //   290: areturn
    //   291: astore 7
    //   293: new 254	java/lang/StringBuilder
    //   296: dup
    //   297: ldc_w 1688
    //   300: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   303: aload_0
    //   304: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   307: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   310: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   313: ldc_w 1676
    //   316: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_0
    //   320: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   323: getfield 346	com/whatsapp/protocol/j:u	Ljava/lang/String;
    //   326: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: ldc_w 1678
    //   332: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 6
    //   337: invokevirtual 1108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   340: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 313	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   349: aload_0
    //   350: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   353: invokevirtual 454	java/io/File:length	()J
    //   356: lconst_0
    //   357: lcmp
    //   358: ifle +322 -> 680
    //   361: iconst_1
    //   362: istore_1
    //   363: aload_0
    //   364: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   367: aload_0
    //   368: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   371: invokevirtual 454	java/io/File:length	()J
    //   374: invokevirtual 578	com/whatsapp/vo:a	(J)V
    //   377: aload_0
    //   378: aload_0
    //   379: aload_0
    //   380: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   383: aload_0
    //   384: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   387: aload_0
    //   388: getfield 1305	com/whatsapp/vk:c	Ljava/net/URL;
    //   391: invokespecial 1690	com/whatsapp/vk:a	(Lcom/whatsapp/vk;Lcom/whatsapp/protocol/j;Ljava/io/File;Ljava/net/URL;)Lcom/whatsapp/vk$c;
    //   394: astore 6
    //   396: aload 6
    //   398: getfield 1376	com/whatsapp/vk$c:a	Lcom/whatsapp/vk$d;
    //   401: getstatic 1692	com/whatsapp/vk$d:g	Lcom/whatsapp/vk$d;
    //   404: if_acmpeq +14 -> 418
    //   407: aload 6
    //   409: getfield 1376	com/whatsapp/vk$c:a	Lcom/whatsapp/vk$d;
    //   412: getstatic 478	com/whatsapp/vk$d:h	Lcom/whatsapp/vk$d;
    //   415: if_acmpne +270 -> 685
    //   418: aload_0
    //   419: getfield 252	com/whatsapp/vk:e	Lcom/whatsapp/vo;
    //   422: lconst_0
    //   423: invokevirtual 578	com/whatsapp/vo:a	(J)V
    //   426: aload_0
    //   427: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   430: invokevirtual 471	java/io/File:delete	()Z
    //   433: ifne +45 -> 478
    //   436: new 254	java/lang/StringBuilder
    //   439: dup
    //   440: ldc_w 1694
    //   443: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   446: aload_0
    //   447: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   450: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   453: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   456: ldc_w 1678
    //   459: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload_0
    //   463: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   466: invokevirtual 1108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   469: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 313	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   478: aload_0
    //   479: getfield 241	com/whatsapp/vk:b	Lcom/whatsapp/MediaData;
    //   482: ifnull +91 -> 573
    //   485: aload_0
    //   486: getfield 241	com/whatsapp/vk:b	Lcom/whatsapp/MediaData;
    //   489: getfield 447	com/whatsapp/MediaData:refKey	[B
    //   492: ifnull +81 -> 573
    //   495: aload_0
    //   496: getfield 132	com/whatsapp/vk:q	Lcom/whatsapp/oz;
    //   499: aload_0
    //   500: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   503: iconst_1
    //   504: invokestatic 224	com/whatsapp/vk:a	(Lcom/whatsapp/oz;Lcom/whatsapp/protocol/j;Z)Ljava/io/File;
    //   507: astore 7
    //   509: aload 7
    //   511: ifnull +62 -> 573
    //   514: aload 7
    //   516: invokevirtual 471	java/io/File:delete	()Z
    //   519: ifne +54 -> 573
    //   522: new 254	java/lang/StringBuilder
    //   525: dup
    //   526: ldc_w 1696
    //   529: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   532: aload_0
    //   533: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   536: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   539: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   542: ldc_w 1079
    //   545: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload 7
    //   550: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 313	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   559: aload_0
    //   560: getfield 505	com/whatsapp/vk:g	Lcom/whatsapp/m/a;
    //   563: ifnull +10 -> 573
    //   566: aload_0
    //   567: getfield 505	com/whatsapp/vk:g	Lcom/whatsapp/m/a;
    //   570: invokevirtual 1343	com/whatsapp/m/a:c	()V
    //   573: iload_1
    //   574: ifeq +431 -> 1005
    //   577: aload_0
    //   578: aload_0
    //   579: aload_0
    //   580: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   583: aload_0
    //   584: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   587: aload_0
    //   588: getfield 1305	com/whatsapp/vk:c	Ljava/net/URL;
    //   591: invokespecial 1690	com/whatsapp/vk:a	(Lcom/whatsapp/vk;Lcom/whatsapp/protocol/j;Ljava/io/File;Ljava/net/URL;)Lcom/whatsapp/vk$c;
    //   594: astore 6
    //   596: aload 6
    //   598: invokevirtual 1308	com/whatsapp/vk$c:a	()Z
    //   601: ifeq +561 -> 1162
    //   604: aload_0
    //   605: invokespecial 1679	com/whatsapp/vk:d	()V
    //   608: aload_0
    //   609: invokevirtual 407	com/whatsapp/vk:isCancelled	()Z
    //   612: ifeq +396 -> 1008
    //   615: new 19	com/whatsapp/vk$c
    //   618: dup
    //   619: getstatic 410	com/whatsapp/vk$d:l	Lcom/whatsapp/vk$d;
    //   622: aconst_null
    //   623: iconst_0
    //   624: invokespecial 413	com/whatsapp/vk$c:<init>	(Lcom/whatsapp/vk$d;Ljava/lang/String;Z)V
    //   627: areturn
    //   628: aconst_null
    //   629: astore 6
    //   631: goto -522 -> 109
    //   634: new 254	java/lang/StringBuilder
    //   637: dup
    //   638: ldc_w 1698
    //   641: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   644: aload 7
    //   646: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: ldc_w 1700
    //   652: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aload_0
    //   656: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   659: getfield 346	com/whatsapp/protocol/j:u	Ljava/lang/String;
    //   662: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: ldc_w 1702
    //   668: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 289	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   677: goto -328 -> 349
    //   680: iconst_0
    //   681: istore_1
    //   682: goto -319 -> 363
    //   685: aload 6
    //   687: getfield 1376	com/whatsapp/vk$c:a	Lcom/whatsapp/vk$d;
    //   690: getstatic 1548	com/whatsapp/vk$d:f	Lcom/whatsapp/vk$d;
    //   693: if_acmpne +203 -> 896
    //   696: aload_0
    //   697: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   700: getfield 1704	com/whatsapp/protocol/j:d	I
    //   703: bipush 12
    //   705: if_icmpeq +191 -> 896
    //   708: new 254	java/lang/StringBuilder
    //   711: dup
    //   712: ldc_w 1706
    //   715: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   718: aload_0
    //   719: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   722: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   725: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   728: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   731: invokestatic 289	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   734: aload_0
    //   735: getfield 146	com/whatsapp/vk:h	Lcom/whatsapp/data/ad;
    //   738: aload_0
    //   739: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   742: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   745: bipush 11
    //   747: aconst_null
    //   748: invokevirtual 1709	com/whatsapp/data/ad:a	(Lcom/whatsapp/protocol/j$b;ILcom/whatsapp/util/au;)V
    //   751: aload_0
    //   752: getfield 139	com/whatsapp/vk:r	Lcom/whatsapp/messaging/w;
    //   755: aload_0
    //   756: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   759: invokevirtual 1710	com/whatsapp/messaging/w:b	(Lcom/whatsapp/protocol/j;)V
    //   762: aload_0
    //   763: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   766: getfield 714	com/whatsapp/protocol/j:p	Ljava/lang/String;
    //   769: astore 7
    //   771: iconst_0
    //   772: istore_1
    //   773: iload_1
    //   774: bipush 12
    //   776: if_icmpgt +117 -> 893
    //   779: ldc2_w 1711
    //   782: invokestatic 1717	java/lang/Thread:sleep	(J)V
    //   785: aload 7
    //   787: aload_0
    //   788: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   791: getfield 714	com/whatsapp/protocol/j:p	Ljava/lang/String;
    //   794: invokevirtual 1113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   797: ifne +89 -> 886
    //   800: aload_0
    //   801: aload_0
    //   802: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   805: invokespecial 1661	com/whatsapp/vk:d	(Lcom/whatsapp/protocol/j;)Ljava/net/URL;
    //   808: astore 7
    //   810: aload 7
    //   812: ifnull +81 -> 893
    //   815: new 254	java/lang/StringBuilder
    //   818: dup
    //   819: ldc_w 1719
    //   822: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   825: aload_0
    //   826: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   829: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   832: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   835: ldc_w 1181
    //   838: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: aload 7
    //   843: invokestatic 311	com/whatsapp/util/MediaFileUtils:a	(Ljava/net/URL;)Ljava/lang/String;
    //   846: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   852: invokestatic 289	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   855: aload_0
    //   856: aload_0
    //   857: aload_0
    //   858: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   861: aload_0
    //   862: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   865: aload 7
    //   867: invokespecial 1690	com/whatsapp/vk:a	(Lcom/whatsapp/vk;Lcom/whatsapp/protocol/j;Ljava/io/File;Ljava/net/URL;)Lcom/whatsapp/vk$c;
    //   870: astore 6
    //   872: goto -276 -> 596
    //   875: astore 7
    //   877: invokestatic 1723	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   880: invokevirtual 1726	java/lang/Thread:interrupt	()V
    //   883: goto -287 -> 596
    //   886: iload_1
    //   887: iconst_1
    //   888: iadd
    //   889: istore_1
    //   890: goto -117 -> 773
    //   893: goto -297 -> 596
    //   896: aload 6
    //   898: getfield 1376	com/whatsapp/vk$c:a	Lcom/whatsapp/vk$d;
    //   901: invokevirtual 1520	com/whatsapp/vk$d:a	()Z
    //   904: ifeq +101 -> 1005
    //   907: aload 6
    //   909: getfield 1728	com/whatsapp/vk$c:c	Z
    //   912: ifne +93 -> 1005
    //   915: aload_0
    //   916: getfield 1305	com/whatsapp/vk:c	Ljava/net/URL;
    //   919: invokevirtual 1236	java/net/URL:toString	()Ljava/lang/String;
    //   922: invokestatic 852	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   925: invokevirtual 856	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   928: astore 7
    //   930: aload 7
    //   932: ldc_w 1730
    //   935: invokevirtual 936	android/net/Uri$Builder:authority	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   938: pop
    //   939: new 1185	java/net/URL
    //   942: dup
    //   943: aload 7
    //   945: invokevirtual 1243	android/net/Uri$Builder:toString	()Ljava/lang/String;
    //   948: invokespecial 1187	java/net/URL:<init>	(Ljava/lang/String;)V
    //   951: astore 7
    //   953: aload_0
    //   954: aload_0
    //   955: aload_0
    //   956: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   959: aload_0
    //   960: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   963: aload 7
    //   965: invokespecial 1690	com/whatsapp/vk:a	(Lcom/whatsapp/vk;Lcom/whatsapp/protocol/j;Ljava/io/File;Ljava/net/URL;)Lcom/whatsapp/vk$c;
    //   968: astore 7
    //   970: aload 7
    //   972: astore 6
    //   974: goto -378 -> 596
    //   977: astore 7
    //   979: new 254	java/lang/StringBuilder
    //   982: dup
    //   983: ldc_w 1732
    //   986: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   989: aload_0
    //   990: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   993: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   996: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   999: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1002: invokestatic 595	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1005: goto -409 -> 596
    //   1008: aload_0
    //   1009: getfield 241	com/whatsapp/vk:b	Lcom/whatsapp/MediaData;
    //   1012: invokestatic 494	a/a/a/a/a/a$d:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1015: pop
    //   1016: aload_0
    //   1017: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   1020: getfield 247	com/whatsapp/protocol/j:s	B
    //   1023: iconst_1
    //   1024: if_icmpne +158 -> 1182
    //   1027: aload_0
    //   1028: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   1031: invokevirtual 1352	com/whatsapp/protocol/j:f	()Lcom/whatsapp/protocol/l;
    //   1034: invokestatic 494	a/a/a/a/a/a$d:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1037: checkcast 1617	com/whatsapp/protocol/l
    //   1040: invokevirtual 1619	com/whatsapp/protocol/l:d	()Z
    //   1043: ifne +70 -> 1113
    //   1046: aload_0
    //   1047: getfield 167	com/whatsapp/vk:u	Lcom/whatsapp/and;
    //   1050: aload_0
    //   1051: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   1054: invokestatic 1736	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   1057: bipush 100
    //   1059: bipush 100
    //   1061: invokestatic 1739	com/whatsapp/util/MediaFileUtils:a	(Lcom/whatsapp/and;Landroid/net/Uri;II)Landroid/graphics/Bitmap;
    //   1064: astore 7
    //   1066: aload 7
    //   1068: ifnull +45 -> 1113
    //   1071: new 1741	java/io/ByteArrayOutputStream
    //   1074: dup
    //   1075: invokespecial 1742	java/io/ByteArrayOutputStream:<init>	()V
    //   1078: astore 8
    //   1080: aload 7
    //   1082: getstatic 1748	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1085: bipush 80
    //   1087: aload 8
    //   1089: invokevirtual 1754	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   1092: pop
    //   1093: aload_0
    //   1094: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   1097: invokevirtual 1352	com/whatsapp/protocol/j:f	()Lcom/whatsapp/protocol/l;
    //   1100: aload 8
    //   1102: invokevirtual 1757	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1105: invokevirtual 1622	com/whatsapp/protocol/l:a	([B)V
    //   1108: aload 7
    //   1110: invokevirtual 1760	android/graphics/Bitmap:recycle	()V
    //   1113: aload_0
    //   1114: getfield 188	com/whatsapp/vk:x	Lcom/whatsapp/util/ag;
    //   1117: aload_0
    //   1118: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   1121: invokevirtual 1763	com/whatsapp/util/ag:a	(Lcom/whatsapp/protocol/j;)Landroid/graphics/Bitmap;
    //   1124: astore 7
    //   1126: aload 7
    //   1128: invokevirtual 1764	android/graphics/Bitmap:getHeight	()I
    //   1131: aload 7
    //   1133: invokevirtual 1765	android/graphics/Bitmap:getWidth	()I
    //   1136: if_icmple +15 -> 1151
    //   1139: aload_0
    //   1140: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   1143: aload_0
    //   1144: getfield 241	com/whatsapp/vk:b	Lcom/whatsapp/MediaData;
    //   1147: invokestatic 1768	com/whatsapp/util/MediaFileUtils:a	(Ljava/io/File;Lcom/whatsapp/MediaData;)Z
    //   1150: pop
    //   1151: aload_0
    //   1152: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   1155: aload_0
    //   1156: getfield 241	com/whatsapp/vk:b	Lcom/whatsapp/MediaData;
    //   1159: invokestatic 1771	com/whatsapp/util/MediaFileUtils:b	(Ljava/io/File;Lcom/whatsapp/MediaData;)V
    //   1162: aload_0
    //   1163: invokevirtual 407	com/whatsapp/vk:isCancelled	()Z
    //   1166: ifeq -1110 -> 56
    //   1169: new 19	com/whatsapp/vk$c
    //   1172: dup
    //   1173: getstatic 410	com/whatsapp/vk$d:l	Lcom/whatsapp/vk$d;
    //   1176: aconst_null
    //   1177: iconst_0
    //   1178: invokespecial 413	com/whatsapp/vk$c:<init>	(Lcom/whatsapp/vk$d;Ljava/lang/String;Z)V
    //   1181: areturn
    //   1182: aload_0
    //   1183: getfield 241	com/whatsapp/vk:b	Lcom/whatsapp/MediaData;
    //   1186: getfield 627	com/whatsapp/MediaData:suspiciousContent	I
    //   1189: getstatic 630	com/whatsapp/MediaData:SUSPICIOUS_CONTENT_YES	I
    //   1192: if_icmpeq +164 -> 1356
    //   1195: aload_0
    //   1196: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   1199: getfield 247	com/whatsapp/protocol/j:s	B
    //   1202: bipush 13
    //   1204: if_icmpeq +14 -> 1218
    //   1207: aload_0
    //   1208: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   1211: getfield 247	com/whatsapp/protocol/j:s	B
    //   1214: iconst_3
    //   1215: if_icmpne +141 -> 1356
    //   1218: new 1773	com/whatsapp/util/MediaFileUtils$f
    //   1221: dup
    //   1222: aload_0
    //   1223: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   1226: invokespecial 1774	com/whatsapp/util/MediaFileUtils$f:<init>	(Ljava/io/File;)V
    //   1229: astore 7
    //   1231: aload_0
    //   1232: getfield 241	com/whatsapp/vk:b	Lcom/whatsapp/MediaData;
    //   1235: astore 8
    //   1237: aload 7
    //   1239: invokevirtual 1775	com/whatsapp/util/MediaFileUtils$f:b	()Z
    //   1242: ifeq +83 -> 1325
    //   1245: aload 7
    //   1247: getfield 1776	com/whatsapp/util/MediaFileUtils$f:b	I
    //   1250: istore_1
    //   1251: aload 8
    //   1253: iload_1
    //   1254: putfield 1613	com/whatsapp/MediaData:width	I
    //   1257: aload_0
    //   1258: getfield 241	com/whatsapp/vk:b	Lcom/whatsapp/MediaData;
    //   1261: astore 8
    //   1263: aload 7
    //   1265: invokevirtual 1775	com/whatsapp/util/MediaFileUtils$f:b	()Z
    //   1268: ifeq +66 -> 1334
    //   1271: aload 7
    //   1273: getfield 1777	com/whatsapp/util/MediaFileUtils$f:a	I
    //   1276: istore_1
    //   1277: aload 8
    //   1279: iload_1
    //   1280: putfield 1615	com/whatsapp/MediaData:height	I
    //   1283: aload_0
    //   1284: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   1287: invokevirtual 1352	com/whatsapp/protocol/j:f	()Lcom/whatsapp/protocol/l;
    //   1290: invokestatic 494	a/a/a/a/a/a$d:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1293: checkcast 1617	com/whatsapp/protocol/l
    //   1296: invokevirtual 1619	com/whatsapp/protocol/l:d	()Z
    //   1299: ifne -137 -> 1162
    //   1302: aload_0
    //   1303: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   1306: invokevirtual 1352	com/whatsapp/protocol/j:f	()Lcom/whatsapp/protocol/l;
    //   1309: aload_0
    //   1310: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   1313: invokevirtual 1108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1316: invokestatic 1780	com/whatsapp/util/MediaFileUtils:d	(Ljava/lang/String;)[B
    //   1319: invokevirtual 1622	com/whatsapp/protocol/l:a	([B)V
    //   1322: goto -160 -> 1162
    //   1325: aload 7
    //   1327: getfield 1777	com/whatsapp/util/MediaFileUtils$f:a	I
    //   1330: istore_1
    //   1331: goto -80 -> 1251
    //   1334: aload 7
    //   1336: getfield 1776	com/whatsapp/util/MediaFileUtils$f:b	I
    //   1339: istore_1
    //   1340: goto -63 -> 1277
    //   1343: astore 7
    //   1345: ldc_w 1782
    //   1348: aload 7
    //   1350: invokestatic 326	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1353: goto -70 -> 1283
    //   1356: aload_0
    //   1357: getfield 241	com/whatsapp/vk:b	Lcom/whatsapp/MediaData;
    //   1360: getfield 627	com/whatsapp/MediaData:suspiciousContent	I
    //   1363: getstatic 630	com/whatsapp/MediaData:SUSPICIOUS_CONTENT_YES	I
    //   1366: if_icmpeq -204 -> 1162
    //   1369: getstatic 909	android/os/Build$VERSION:SDK_INT	I
    //   1372: bipush 12
    //   1374: if_icmpge -212 -> 1162
    //   1377: aload_0
    //   1378: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   1381: getfield 247	com/whatsapp/protocol/j:s	B
    //   1384: iconst_2
    //   1385: if_icmpne -223 -> 1162
    //   1388: aload_0
    //   1389: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   1392: invokestatic 1787	com/whatsapp/util/af:f	(Ljava/io/File;)Lcom/whatsapp/util/ae$a;
    //   1395: astore 7
    //   1397: aload 7
    //   1399: getfield 1790	com/whatsapp/util/ae$a:a	I
    //   1402: ifne -240 -> 1162
    //   1405: aload 7
    //   1407: getfield 1791	com/whatsapp/util/ae$a:c	I
    //   1410: iconst_1
    //   1411: if_icmpne -249 -> 1162
    //   1414: new 417	java/io/File
    //   1417: dup
    //   1418: new 254	java/lang/StringBuilder
    //   1421: dup
    //   1422: invokespecial 699	java/lang/StringBuilder:<init>	()V
    //   1425: aload_0
    //   1426: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   1429: invokevirtual 1108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1432: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1435: ldc_w 1793
    //   1438: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1444: invokespecial 715	java/io/File:<init>	(Ljava/lang/String;)V
    //   1447: astore 9
    //   1449: new 1795	com/whatsapp/ah$a
    //   1452: dup
    //   1453: aload_0
    //   1454: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   1457: aload 9
    //   1459: invokespecial 1797	com/whatsapp/ah$a:<init>	(Ljava/io/File;Ljava/io/File;)V
    //   1462: invokevirtual 1800	com/whatsapp/ah$a:a	()Lcom/whatsapp/ah;
    //   1465: astore 7
    //   1467: aload_0
    //   1468: getfield 118	com/whatsapp/vk:o	Lcom/whatsapp/util/a/c;
    //   1471: astore 8
    //   1473: new 254	java/lang/StringBuilder
    //   1476: dup
    //   1477: ldc_w 1802
    //   1480: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1483: aload 7
    //   1485: getfield 1806	com/whatsapp/ah:a	Ljava/io/File;
    //   1488: invokevirtual 454	java/io/File:length	()J
    //   1491: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1494: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1497: invokestatic 289	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1500: ldc_w 1808
    //   1503: invokestatic 1813	com/whatsapp/k/c:b	(Ljava/lang/String;)Lcom/whatsapp/k/d;
    //   1506: astore 10
    //   1508: aload 10
    //   1510: invokeinterface 1816 1 0
    //   1515: aload 7
    //   1517: getfield 1818	com/whatsapp/ah:d	Ljava/io/File;
    //   1520: astore 11
    //   1522: aload 7
    //   1524: getfield 1806	com/whatsapp/ah:a	Ljava/io/File;
    //   1527: astore 12
    //   1529: aload 7
    //   1531: getfield 1820	com/whatsapp/ah:b	J
    //   1534: lstore 4
    //   1536: aload 7
    //   1538: getfield 1822	com/whatsapp/ah:c	J
    //   1541: lconst_0
    //   1542: lcmp
    //   1543: ifle +143 -> 1686
    //   1546: aload 7
    //   1548: getfield 1822	com/whatsapp/ah:c	J
    //   1551: aload 7
    //   1553: getfield 1820	com/whatsapp/ah:b	J
    //   1556: lsub
    //   1557: lstore_2
    //   1558: aload 11
    //   1560: aload 12
    //   1562: aconst_null
    //   1563: iconst_0
    //   1564: lload 4
    //   1566: lconst_0
    //   1567: lload_2
    //   1568: invokestatic 1825	com/whatsapp/Mp4Ops:a	(Ljava/io/File;Ljava/io/File;Ljava/io/File;IJJJ)V
    //   1571: aload 10
    //   1573: invokeinterface 1826 1 0
    //   1578: new 254	java/lang/StringBuilder
    //   1581: dup
    //   1582: ldc_w 1828
    //   1585: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1588: aload 10
    //   1590: invokeinterface 1830 1 0
    //   1595: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1598: ldc_w 1832
    //   1601: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1604: aload 7
    //   1606: getfield 1818	com/whatsapp/ah:d	Ljava/io/File;
    //   1609: invokevirtual 454	java/io/File:length	()J
    //   1612: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1615: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1618: invokestatic 289	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1621: aload_0
    //   1622: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   1625: invokevirtual 471	java/io/File:delete	()Z
    //   1628: ifne +9 -> 1637
    //   1631: ldc_w 1834
    //   1634: invokestatic 313	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1637: aload 9
    //   1639: aload_0
    //   1640: getfield 226	com/whatsapp/vk:i	Ljava/io/File;
    //   1643: invokevirtual 1514	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1646: ifne +9 -> 1655
    //   1649: ldc_w 1836
    //   1652: invokestatic 313	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1655: aload_0
    //   1656: getfield 228	com/whatsapp/vk:a	Lcom/whatsapp/protocol/j;
    //   1659: ldc_w 1838
    //   1662: putfield 473	com/whatsapp/protocol/j:r	Ljava/lang/String;
    //   1665: goto -503 -> 1162
    //   1668: astore 7
    //   1670: ldc_w 1840
    //   1673: aload 7
    //   1675: invokestatic 692	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1678: aload 7
    //   1680: invokestatic 1843	com/whatsapp/vx:a	(Ljava/lang/Exception;)V
    //   1683: goto -521 -> 1162
    //   1686: ldc2_w 1844
    //   1689: lstore_2
    //   1690: goto -132 -> 1558
    //   1693: astore 9
    //   1695: ldc_w 1847
    //   1698: aload 9
    //   1700: invokestatic 692	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1703: aload 8
    //   1705: aload 7
    //   1707: getfield 1806	com/whatsapp/ah:a	Ljava/io/File;
    //   1710: aload 9
    //   1712: ldc_w 1849
    //   1715: invokestatic 1227	com/whatsapp/Mp4Ops:a	(Lcom/whatsapp/util/a/c;Ljava/io/File;Ljava/lang/Exception;Ljava/lang/String;)V
    //   1718: aload 9
    //   1720: athrow
    //   1721: astore 7
    //   1723: ldc_w 1840
    //   1726: aload 7
    //   1728: invokestatic 692	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1731: goto -569 -> 1162
    //   1734: astore 7
    //   1736: goto -585 -> 1151
    //   1739: astore 7
    //   1741: goto -590 -> 1151
    //   1744: astore 7
    //   1746: goto -633 -> 1113
    //   1749: astore 7
    //   1751: goto -638 -> 1113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1754	0	this	vk
    //   362	978	1	i1	int
    //   1557	133	2	l1	long
    //   1534	31	4	l2	long
    //   4	969	6	localObject1	Object
    //   175	114	7	localObject2	Object
    //   291	1	7	localIOException1	IOException
    //   507	359	7	localObject3	Object
    //   875	1	7	localInterruptedException	InterruptedException
    //   928	43	7	localObject4	Object
    //   977	1	7	localMalformedURLException	MalformedURLException
    //   1064	271	7	localObject5	Object
    //   1343	6	7	localc	com.whatsapp.util.MediaFileUtils.c
    //   1395	210	7	localObject6	Object
    //   1668	38	7	locala1	Mp4Ops.a
    //   1721	6	7	localIOException2	IOException
    //   1734	1	7	localException1	Exception
    //   1739	1	7	localOutOfMemoryError1	OutOfMemoryError
    //   1744	1	7	localException2	Exception
    //   1749	1	7	localOutOfMemoryError2	OutOfMemoryError
    //   1078	626	8	localObject7	Object
    //   1447	191	9	localFile1	File
    //   1693	26	9	locala2	Mp4Ops.a
    //   1506	83	10	locald	com.whatsapp.k.d
    //   1520	39	11	localFile2	File
    //   1527	34	12	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   192	250	291	java/io/IOException
    //   250	267	291	java/io/IOException
    //   267	288	291	java/io/IOException
    //   779	785	875	java/lang/InterruptedException
    //   939	970	977	java/net/MalformedURLException
    //   1218	1251	1343	com/whatsapp/util/MediaFileUtils$c
    //   1251	1277	1343	com/whatsapp/util/MediaFileUtils$c
    //   1277	1283	1343	com/whatsapp/util/MediaFileUtils$c
    //   1325	1331	1343	com/whatsapp/util/MediaFileUtils$c
    //   1334	1340	1343	com/whatsapp/util/MediaFileUtils$c
    //   1467	1515	1668	com/whatsapp/Mp4Ops$a
    //   1571	1637	1668	com/whatsapp/Mp4Ops$a
    //   1637	1655	1668	com/whatsapp/Mp4Ops$a
    //   1655	1665	1668	com/whatsapp/Mp4Ops$a
    //   1695	1721	1668	com/whatsapp/Mp4Ops$a
    //   1515	1558	1693	com/whatsapp/Mp4Ops$a
    //   1558	1571	1693	com/whatsapp/Mp4Ops$a
    //   1467	1515	1721	java/io/IOException
    //   1515	1558	1721	java/io/IOException
    //   1558	1571	1721	java/io/IOException
    //   1571	1637	1721	java/io/IOException
    //   1637	1655	1721	java/io/IOException
    //   1655	1665	1721	java/io/IOException
    //   1695	1721	1721	java/io/IOException
    //   1113	1151	1734	java/lang/Exception
    //   1113	1151	1739	java/lang/OutOfMemoryError
    //   1046	1066	1744	java/lang/Exception
    //   1071	1113	1744	java/lang/Exception
    //   1046	1066	1749	java/lang/OutOfMemoryError
    //   1071	1113	1749	java/lang/OutOfMemoryError
  }
  
  protected final void onCancelled()
  {
    Log.i("MMS canceled; message.key=" + this.a.e + " url=" + MediaFileUtils.a(this.c));
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static final class b
  {
    final String a;
    final String b;
    
    public b(String paramString)
    {
      int i;
      int j;
      if (paramString != null)
      {
        i = paramString.indexOf("filetype=");
        if (i >= 0)
        {
          i += 9;
          j = paramString.indexOf(';', i);
          if (j >= 0)
          {
            localObject1 = paramString.substring(i, j);
            this.a = ((String)localObject1);
            localObject1 = localObject2;
            if (paramString != null)
            {
              i = paramString.indexOf("filehash=");
              localObject1 = localObject2;
              if (i >= 0)
              {
                i += 9;
                j = paramString.indexOf(';', i);
                if (j < 0) {
                  break label124;
                }
              }
            }
          }
        }
      }
      label124:
      for (Object localObject1 = paramString.substring(i, j);; localObject1 = paramString.substring(i))
      {
        this.b = ((String)localObject1);
        return;
        localObject1 = paramString.substring(i);
        break;
        localObject1 = null;
        break;
      }
    }
  }
  
  public static final class c
  {
    public final vk.d a;
    public final String b;
    public final boolean c;
    
    public c(vk.d paramd)
    {
      this(paramd, null, false);
    }
    
    public c(vk.d paramd, String paramString, boolean paramBoolean)
    {
      this.a = paramd;
      this.b = paramString;
      this.c = paramBoolean;
    }
    
    public final boolean a()
    {
      return this.a == vk.d.d;
    }
    
    public final String toString()
    {
      return this.a.toString();
    }
  }
  
  public static enum d
  {
    public final int n;
    public final String o;
    
    private d(int paramInt, String paramString)
    {
      this.n = paramInt;
      this.o = paramString;
    }
    
    public static d a(int paramInt)
    {
      d[] arrayOfd = values();
      int i2 = arrayOfd.length;
      int i1 = 0;
      while (i1 < i2)
      {
        d locald = arrayOfd[i1];
        if (paramInt == locald.n) {
          return locald;
        }
        i1 += 1;
      }
      return null;
    }
    
    public final boolean a()
    {
      return (this == a) || (this == b) || (this == c);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/vk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */