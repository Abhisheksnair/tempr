package com.whatsapp;

import a.a.a.a.a.a.d;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.whatsapp.d.a.a;
import com.whatsapp.d.f;
import com.whatsapp.data.y;
import com.whatsapp.fieldstats.l;
import com.whatsapp.i.d.b;
import com.whatsapp.l.h;
import com.whatsapp.messaging.w;
import com.whatsapp.protocol.ae;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.k;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.MediaFileUtils.c;
import com.whatsapp.util.MediaFileUtils.f;
import com.whatsapp.util.af;
import com.whatsapp.util.be;
import com.whatsapp.util.bu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class xg
  extends AsyncTask<b, Long, c>
{
  private static Timer G = new Timer();
  protected static final ArrayList<xg> p = new ArrayList();
  protected static final ArrayList<xg> q = new ArrayList();
  private static final Random r = new Random();
  private static final SecureRandom s = new SecureRandom();
  private h A;
  private com.whatsapp.l.c B;
  private String C;
  private boolean D;
  private long E;
  private xw F;
  private TimerTask H;
  private boolean I;
  protected final pv a;
  protected final va b;
  protected final oz c;
  protected final aic d;
  protected final com.whatsapp.data.ad e;
  protected final com.whatsapp.l.e f;
  protected final y g;
  protected final vv h;
  protected final atv i;
  protected final rh j;
  protected boolean k;
  protected long l;
  protected boolean m;
  protected boolean n;
  protected com.whatsapp.protocol.ad o;
  private final aoi t;
  private final vs u;
  private final com.whatsapp.i.a v = com.whatsapp.i.a.a();
  private com.whatsapp.i.d w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  public xg(pv parampv, va paramva, oz paramoz, aic paramaic, com.whatsapp.data.ad paramad, com.whatsapp.l.e parame, y paramy, vv paramvv, atv paramatv, rh paramrh, vs paramvs, aoi paramaoi, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = parampv;
    this.b = paramva;
    this.c = paramoz;
    this.d = paramaic;
    this.e = paramad;
    this.f = parame;
    this.g = paramy;
    this.h = paramvv;
    this.i = paramatv;
    this.j = paramrh;
    this.x = paramBoolean1;
    this.F = new xw(paramBoolean2);
    this.u = paramvs;
    this.t = paramaoi;
    this.t.a(this);
    if (!paramBoolean1)
    {
      this.t.a(new xh(this));
      return;
    }
    if (this.t.p() == 1) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      a.d.a(paramBoolean1, "Same media messages in reupload mode");
      return;
    }
  }
  
  private Pair<com.whatsapp.i.d, a.a> a(b paramb)
  {
    Object localObject2 = q();
    if (localObject2 == null) {
      return null;
    }
    Object localObject1 = new d.b()
    {
      public final void a(long paramAnonymousLong)
      {
        xg.a(xg.this, new Long[] { Long.valueOf(paramAnonymousLong) });
      }
      
      public final void a(Map<String, List<String>> paramAnonymousMap, String paramAnonymousString)
      {
        xg.this.o = new com.whatsapp.protocol.ad();
        if (xg.d(xg.this))
        {
          String str = xg.this.b();
          paramAnonymousMap = null;
          try
          {
            paramAnonymousString = new JSONObject(paramAnonymousString).optString("url");
            paramAnonymousMap = paramAnonymousString;
          }
          catch (JSONException paramAnonymousString)
          {
            for (;;)
            {
              Log.d("mediaupload/jsonexception", paramAnonymousString);
            }
          }
          paramAnonymousString = paramAnonymousMap;
          if (TextUtils.isEmpty(paramAnonymousMap)) {
            paramAnonymousString = xg.i(xg.this).a(xg.e(xg.this));
          }
          xg.this.o.c = paramAnonymousString;
          xg.this.o.f = str;
          xg.this.n = true;
          return;
        }
        try
        {
          paramAnonymousMap = new JSONObject(paramAnonymousString);
          xg.this.o.b = paramAnonymousMap.optString("mimetype");
          xg.this.o.c = paramAnonymousMap.optString("url");
          xg.this.o.d = paramAnonymousMap.optLong("size");
          xg.this.o.e = paramAnonymousMap.optInt("duration");
          xg.this.o.f = paramAnonymousMap.optString("filehash");
          xg.this.n = true;
          return;
        }
        catch (JSONException paramAnonymousMap)
        {
          Log.d("mediaupload/jsonexception", paramAnonymousMap);
        }
      }
    };
    Object localObject3 = new com.whatsapp.d.a((InputStream)localObject2, new com.whatsapp.d.d(this.t.a(), this.t.b(), this.t.c(), this.t.d()));
    localObject2 = ((com.whatsapp.d.a)localObject3).a;
    localObject3 = new f((InputStream)localObject3);
    localObject1 = com.whatsapp.i.a.a(paramb.a, (d.b)localObject1, f());
    ((com.whatsapp.i.d)localObject1).a((InputStream)localObject3, "file", null, paramb.b);
    ((com.whatsapp.i.d)localObject1).a("hash", xk.a((f)localObject3));
    ((com.whatsapp.i.d)localObject1).b("refs", s());
    this.k = true;
    return new Pair(localObject1, localObject2);
  }
  
  private c a(com.whatsapp.i.d paramd)
  {
    Log.d("mediaupload/attemptUpload key=" + this.t.j());
    int i1;
    try
    {
      this.F.c = Long.valueOf(SystemClock.uptimeMillis());
      i1 = paramd.a(this.A);
      this.F.c();
      this.F.a(paramd.a());
      this.F.b(paramd.b());
      this.F.i = Long.valueOf(i1);
      if (this.D) {
        this.f.a(i1);
      }
      if (i1 >= 0) {
        break label228;
      }
      if (isCancelled())
      {
        Log.e("mediaupload/upload-error/cancelled " + this.t.j());
        return c.m;
      }
    }
    catch (IOException localIOException)
    {
      this.F.c();
      this.F.a(paramd.a());
      this.F.b(paramd.b());
      this.F.k = paramd.d();
      throw localIOException;
    }
    Log.e("mediaupload/upload-error/response-code=" + i1 + " " + this.t.j());
    return c.b;
    label228:
    if ((i1 >= 500) || (i1 == 408))
    {
      Log.e("mediaupload/upload-error/response-code=" + i1 + " " + this.t.j());
      return c.i;
    }
    if (i1 >= 400)
    {
      Log.e("mediaupload/upload-error/response-code=" + i1 + " " + this.t.j());
      return c.f;
    }
    return c.a;
  }
  
  private c a(b... paramVarArgs)
  {
    Log.d("mediaupload/doInBackground key=" + this.t.j());
    paramVarArgs = paramVarArgs[0];
    MediaFileUtils.a(u.a(), this.c);
    if ((this.t.n().s == 3) || (this.t.n().s == 13)) {}
    for (;;)
    {
      try
      {
        localf = new MediaFileUtils.f(this.t.h());
        if (!localf.b()) {
          continue;
        }
        i1 = localf.b;
        if (!localf.b()) {
          continue;
        }
        i2 = localf.a;
        this.t.a(new xm(i1, i2));
      }
      catch (MediaFileUtils.c localc)
      {
        MediaFileUtils.f localf;
        int i1;
        int i2;
        Log.c("MMS upload unable to get video meta", localc);
        continue;
        if (paramVarArgs != null) {
          continue;
        }
        throw new IllegalArgumentException("UploadParams is null");
        if (this.t.h().length() <= 75497472L) {
          continue;
        }
        Log.i("mediaupload/file size exceeds max limit, size=" + this.t.h().length() + ", limit=" + aic.s + "MB, key=" + this.t.j());
        return c.f;
        Object localObject1 = a(paramVarArgs);
        if (localObject1 != null) {
          continue;
        }
        return c.d;
        this.w = ((com.whatsapp.i.d)a.d.a(((Pair)localObject1).first));
        Object localObject3 = (a.a)a.d.a(((Pair)localObject1).second);
        try
        {
          localObject1 = a(this.w);
          if ((localObject1 != c.a) || (!f())) {
            continue;
          }
          this.t.a(MediaFileUtils.c(this.t.h()));
          if (t()) {
            continue;
          }
          return c.l;
          if ((localObject1 != c.a) || (!a(this.t))) {
            continue;
          }
          localObject3 = ((a.a)localObject3).a();
          a(this.t, (byte[])localObject3);
          return (c)localObject1;
        }
        catch (IOException localIOException)
        {
          Log.d("mediaupload/io-error " + this.t.j(), localIOException);
          this.F.l = localIOException.getClass().getSimpleName();
          if ((this.n) || (this.l != 0L) || (paramVarArgs.b != 0) || (isCancelled())) {
            continue;
          }
          localObject3 = new com.whatsapp.fieldstats.events.e();
          ((com.whatsapp.fieldstats.events.e)localObject3).o = Double.valueOf(this.t.n().t);
          ((com.whatsapp.fieldstats.events.e)localObject3).a = Integer.valueOf(a.a.a.a.d.a(this.t.n()));
          ((com.whatsapp.fieldstats.events.e)localObject3).n = Double.valueOf(this.w.c());
          ((com.whatsapp.fieldstats.events.e)localObject3).e = Double.valueOf(this.w.a());
          ((com.whatsapp.fieldstats.events.e)localObject3).g = Double.valueOf(this.w.b());
          ((com.whatsapp.fieldstats.events.e)localObject3).f = this.F.d();
          ((com.whatsapp.fieldstats.events.e)localObject3).c = localIOException.getClass().getSimpleName();
          ((com.whatsapp.fieldstats.events.e)localObject3).d = localIOException.getMessage();
          Log.i("mediaupload/attempting to connect to fallback mms server, " + this.t.j());
          Object localObject2 = Uri.parse(paramVarArgs.a).buildUpon();
          ((Uri.Builder)localObject2).authority("mms.whatsapp.net");
          paramVarArgs = a(new b(((Uri.Builder)localObject2).toString(), paramVarArgs.b));
          if (paramVarArgs != null) {
            continue;
          }
          return c.d;
          this.w = ((com.whatsapp.i.d)paramVarArgs.first);
          localObject2 = (a.a)paramVarArgs.second;
          try
          {
            paramVarArgs = a(this.w);
            if ((paramVarArgs != c.a) || (!f())) {
              continue;
            }
            this.t.a(MediaFileUtils.c(this.t.h()));
            if (t()) {
              continue;
            }
            localObject2 = c.l;
            ((com.whatsapp.fieldstats.events.e)localObject3).n = Double.valueOf(this.w.c());
            ((com.whatsapp.fieldstats.events.e)localObject3).k = Double.valueOf(this.w.a());
            ((com.whatsapp.fieldstats.events.e)localObject3).m = Double.valueOf(this.w.b());
            ((com.whatsapp.fieldstats.events.e)localObject3).l = this.F.d();
            paramVarArgs = (b[])localObject2;
            if (!av.k()) {
              continue;
            }
            paramVarArgs = this.t.n().b();
            Log.d("mediaupload/fallback/event/success=" + ((com.whatsapp.fieldstats.events.e)localObject3).b + ", type=" + this.t.n().s + ", retryCount=" + paramVarArgs.uploadRetry + ", size=" + this.t.n().t + ", exception_class=" + ((com.whatsapp.fieldstats.events.e)localObject3).c + ", exception_message=" + ((com.whatsapp.fieldstats.events.e)localObject3).d + ", connect_t=" + ((com.whatsapp.fieldstats.events.e)localObject3).e + ", network_t=" + ((com.whatsapp.fieldstats.events.e)localObject3).f + ", response_wait_t=" + ((com.whatsapp.fieldstats.events.e)localObject3).g + ", bytes_sent=" + ((com.whatsapp.fieldstats.events.e)localObject3).n + ", exception_class_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).i + ", exception_message_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).j + ", connect_t_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).k + ", network_t_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).l + ", response_wait_t_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).m + ", bytes_sent_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).n + " " + this.t.j());
            l.a(u.a(), (com.whatsapp.fieldstats.e)localObject3);
            return (c)localObject2;
            if ((paramVarArgs != c.a) || (!a(this.t))) {
              continue;
            }
            localObject2 = ((a.a)localObject2).a();
            a(this.t, (byte[])localObject2);
            ((com.whatsapp.fieldstats.events.e)localObject3).b = Boolean.valueOf(true);
            Log.i("mediaupload/backup-mms/success " + this.t.j());
            return paramVarArgs;
          }
          catch (IOException paramVarArgs)
          {
            this.F.l = paramVarArgs.getClass().getSimpleName();
            ((com.whatsapp.fieldstats.events.e)localObject3).b = Boolean.valueOf(false);
            ((com.whatsapp.fieldstats.events.e)localObject3).i = paramVarArgs.getClass().getSimpleName();
            ((com.whatsapp.fieldstats.events.e)localObject3).j = paramVarArgs.getMessage();
            Log.d("mediaupload/backup-mms/io-error " + this.t.j(), paramVarArgs);
            ((com.whatsapp.fieldstats.events.e)localObject3).n = Double.valueOf(this.w.c());
            ((com.whatsapp.fieldstats.events.e)localObject3).k = Double.valueOf(this.w.a());
            ((com.whatsapp.fieldstats.events.e)localObject3).m = Double.valueOf(this.w.b());
            ((com.whatsapp.fieldstats.events.e)localObject3).l = this.F.d();
            if (!av.k()) {
              continue;
            }
            paramVarArgs = this.t.n().b();
            Log.d("mediaupload/fallback/event/success=" + ((com.whatsapp.fieldstats.events.e)localObject3).b + ", type=" + this.t.n().s + ", retryCount=" + paramVarArgs.uploadRetry + ", size=" + this.t.n().t + ", exception_class=" + ((com.whatsapp.fieldstats.events.e)localObject3).c + ", exception_message=" + ((com.whatsapp.fieldstats.events.e)localObject3).d + ", connect_t=" + ((com.whatsapp.fieldstats.events.e)localObject3).e + ", network_t=" + ((com.whatsapp.fieldstats.events.e)localObject3).f + ", response_wait_t=" + ((com.whatsapp.fieldstats.events.e)localObject3).g + ", bytes_sent=" + ((com.whatsapp.fieldstats.events.e)localObject3).n + ", exception_class_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).i + ", exception_message_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).j + ", connect_t_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).k + ", network_t_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).l + ", response_wait_t_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).m + ", bytes_sent_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).n + " " + this.t.j());
            l.a(u.a(), (com.whatsapp.fieldstats.e)localObject3);
            return c.b;
          }
          catch (Exception paramVarArgs)
          {
            this.F.l = paramVarArgs.getClass().getSimpleName();
            ((com.whatsapp.fieldstats.events.e)localObject3).b = Boolean.valueOf(false);
            Log.d("mediaupload/backup-mms/error " + this.t.j(), paramVarArgs);
            ((com.whatsapp.fieldstats.events.e)localObject3).n = Double.valueOf(this.w.c());
            ((com.whatsapp.fieldstats.events.e)localObject3).k = Double.valueOf(this.w.a());
            ((com.whatsapp.fieldstats.events.e)localObject3).m = Double.valueOf(this.w.b());
            ((com.whatsapp.fieldstats.events.e)localObject3).l = this.F.d();
            if (!av.k()) {
              continue;
            }
            paramVarArgs = this.t.n().b();
            Log.d("mediaupload/fallback/event/success=" + ((com.whatsapp.fieldstats.events.e)localObject3).b + ", type=" + this.t.n().s + ", retryCount=" + paramVarArgs.uploadRetry + ", size=" + this.t.n().t + ", exception_class=" + ((com.whatsapp.fieldstats.events.e)localObject3).c + ", exception_message=" + ((com.whatsapp.fieldstats.events.e)localObject3).d + ", connect_t=" + ((com.whatsapp.fieldstats.events.e)localObject3).e + ", network_t=" + ((com.whatsapp.fieldstats.events.e)localObject3).f + ", response_wait_t=" + ((com.whatsapp.fieldstats.events.e)localObject3).g + ", bytes_sent=" + ((com.whatsapp.fieldstats.events.e)localObject3).n + ", exception_class_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).i + ", exception_message_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).j + ", connect_t_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).k + ", network_t_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).l + ", response_wait_t_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).m + ", bytes_sent_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).n + " " + this.t.j());
            l.a(u.a(), (com.whatsapp.fieldstats.e)localObject3);
            continue;
          }
          finally
          {
            ((com.whatsapp.fieldstats.events.e)localObject3).n = Double.valueOf(this.w.c());
            ((com.whatsapp.fieldstats.events.e)localObject3).k = Double.valueOf(this.w.a());
            ((com.whatsapp.fieldstats.events.e)localObject3).m = Double.valueOf(this.w.b());
            ((com.whatsapp.fieldstats.events.e)localObject3).l = this.F.d();
            if (!av.k()) {
              continue;
            }
            localObject2 = this.t.n().b();
            Log.d("mediaupload/fallback/event/success=" + ((com.whatsapp.fieldstats.events.e)localObject3).b + ", type=" + this.t.n().s + ", retryCount=" + ((MediaData)localObject2).uploadRetry + ", size=" + this.t.n().t + ", exception_class=" + ((com.whatsapp.fieldstats.events.e)localObject3).c + ", exception_message=" + ((com.whatsapp.fieldstats.events.e)localObject3).d + ", connect_t=" + ((com.whatsapp.fieldstats.events.e)localObject3).e + ", network_t=" + ((com.whatsapp.fieldstats.events.e)localObject3).f + ", response_wait_t=" + ((com.whatsapp.fieldstats.events.e)localObject3).g + ", bytes_sent=" + ((com.whatsapp.fieldstats.events.e)localObject3).n + ", exception_class_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).i + ", exception_message_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).j + ", connect_t_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).k + ", network_t_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).l + ", response_wait_t_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).m + ", bytes_sent_fallback=" + ((com.whatsapp.fieldstats.events.e)localObject3).n + " " + this.t.j());
            l.a(u.a(), (com.whatsapp.fieldstats.e)localObject3);
          }
        }
      }
      if (!this.n) {
        continue;
      }
      if (a(this.t))
      {
        paramVarArgs = r();
        a(this.t, paramVarArgs);
      }
      paramVarArgs = c.a;
      return paramVarArgs;
      i1 = localf.a;
      continue;
      i2 = localf.b;
    }
  }
  
  private static void a(aoi paramaoi, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    paramaoi.a(new xq(paramArrayOfByte));
  }
  
  private static boolean a(aoi paramaoi)
  {
    MediaData localMediaData = paramaoi.n().b();
    return (k.a(paramaoi.n().s)) && (localMediaData != null) && (localMediaData.refKey != null);
  }
  
  public static boolean a(j paramj)
  {
    Iterator localIterator = q.iterator();
    while (localIterator.hasNext()) {
      if (((xg)localIterator.next()).t.a(paramj)) {
        return true;
      }
    }
    localIterator = p.iterator();
    while (localIterator.hasNext()) {
      if (((xg)localIterator.next()).t.a(paramj)) {
        return true;
      }
    }
    return false;
  }
  
  public static void i()
  {
    Log.i("mediaupload/cancelall current:" + p.size() + " pending:" + q.size());
    int i1 = p.size() - 1;
    while (i1 >= 0)
    {
      ((xg)p.get(i1)).t.f();
      i1 -= 1;
    }
    p.clear();
    i1 = q.size() - 1;
    while (i1 >= 0)
    {
      ((xg)q.get(i1)).t.f();
      i1 -= 1;
    }
    q.clear();
  }
  
  private com.whatsapp.l.c l()
  {
    if (this.B == null) {
      this.B = new com.whatsapp.l.c(this.b, m(), p(), f());
    }
    return this.B;
  }
  
  private String m()
  {
    if (this.C == null) {
      this.C = a();
    }
    return this.C;
  }
  
  private byte n()
  {
    return this.t.n().s;
  }
  
  private int o()
  {
    return this.t.n().o;
  }
  
  private String p()
  {
    byte b1 = n();
    if ((b1 == 2) && (o() == 1)) {
      return "ptt";
    }
    return j.a(b1);
  }
  
  private InputStream q()
  {
    try
    {
      com.whatsapp.d.c localc = new com.whatsapp.d.c(c(), new com.whatsapp.d.d(this.t.a(), this.t.b(), this.t.c(), this.t.d()));
      return localc;
    }
    catch (IOException localIOException)
    {
      Log.d("MMS upload failed to prepare input stream", localIOException);
    }
    return null;
  }
  
  private byte[] r()
  {
    Object localObject = q();
    if (localObject == null)
    {
      Log.w("mediaupload/calculate-sidecar/null input stream");
      return null;
    }
    localObject = new com.whatsapp.d.a((InputStream)localObject, new com.whatsapp.d.d(this.t.a(), this.t.b(), this.t.c(), this.t.d()));
    byte[] arrayOfByte = new byte[' '];
    try
    {
      while (((com.whatsapp.d.a)localObject).read(arrayOfByte) > 0) {}
      ((com.whatsapp.d.a)localObject).close();
      arrayOfByte = ((com.whatsapp.d.a)localObject).a.a();
      return arrayOfByte;
    }
    catch (IOException localIOException2)
    {
      Log.e("mediaupload/calculate-sidecar/ioexception");
      try
      {
        ((com.whatsapp.d.a)localObject).close();
        return null;
      }
      catch (IOException localIOException1) {}
    }
    return null;
  }
  
  private String s()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    this.t.a(new xl(this, localStringBuilder));
    return localStringBuilder.toString();
  }
  
  private boolean t()
  {
    if (!this.D) {
      return true;
    }
    a.d.a(f(), "Finalization only happens for streaming uploads");
    String str;
    Object localObject1;
    Object localObject2;
    if (this.A != null)
    {
      bool = true;
      a.d.a(bool, "A selected route is needed to finalize an upload");
      str = b();
      localObject1 = l();
      a.d.a(((com.whatsapp.l.c)localObject1).b, "Should only set final hash for streaming uploads");
      ((com.whatsapp.l.c)localObject1).a = be.d(str);
      localObject1 = l();
      localObject2 = this.A;
      a.d.a(((com.whatsapp.l.c)localObject1).b, "Should only finalize for streaming uploads");
      if (((com.whatsapp.l.c)localObject1).a == null) {
        break label221;
      }
    }
    label221:
    for (boolean bool = true;; bool = false)
    {
      a.d.a(bool, "Must set final hash before finalizing streaming upload");
      localObject2 = ((com.whatsapp.l.c)localObject1).b((h)localObject2);
      ((Uri.Builder)localObject2).appendQueryParameter("final_hash", ((com.whatsapp.l.c)localObject1).a);
      localObject1 = com.whatsapp.i.a.a(((Uri.Builder)localObject2).build().toString(), new d.b()
      {
        public final void a(long paramAnonymousLong) {}
        
        public final void a(Map<String, List<String>> paramAnonymousMap, String paramAnonymousString)
        {
          paramAnonymousMap = null;
          try
          {
            paramAnonymousString = new JSONObject(paramAnonymousString).optString("url");
            paramAnonymousMap = paramAnonymousString;
          }
          catch (JSONException paramAnonymousString)
          {
            for (;;)
            {
              Log.d("mediaupload/jsonexception", paramAnonymousString);
            }
          }
          paramAnonymousString = paramAnonymousMap;
          if (TextUtils.isEmpty(paramAnonymousMap)) {
            paramAnonymousString = xg.i(xg.this).a(xg.e(xg.this));
          }
          xg.this.o.c = paramAnonymousString;
        }
      }, false);
      try
      {
        int i1 = ((com.whatsapp.i.d)localObject1).a(this.A);
        Log.d("mediaupload/finalizeupload/got responseCode=" + i1);
        if (i1 == 200)
        {
          this.t.b(str);
          this.o.f = str;
          return true;
        }
      }
      catch (IOException localIOException)
      {
        Log.d("Error while finalizing upload", localIOException);
      }
      return false;
      bool = false;
      break;
    }
  }
  
  /* Error */
  private boolean u()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 311	com/whatsapp/xg:D	Z
    //   6: ifne +5 -> 11
    //   9: iconst_1
    //   10: ireturn
    //   11: aload_0
    //   12: invokespecial 769	com/whatsapp/xg:l	()Lcom/whatsapp/l/c;
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 255	com/whatsapp/xg:A	Lcom/whatsapp/l/h;
    //   20: astore 4
    //   22: aload_3
    //   23: aload 4
    //   25: invokevirtual 963	com/whatsapp/l/c:c	(Lcom/whatsapp/l/h;)Landroid/net/Uri$Builder;
    //   28: ldc_w 965
    //   31: aload 4
    //   33: getfield 968	com/whatsapp/l/h:f	Ljava/lang/String;
    //   36: invokevirtual 946	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   39: invokevirtual 778	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   42: invokevirtual 779	android/net/Uri:toString	()Ljava/lang/String;
    //   45: astore_3
    //   46: new 970	java/net/URL
    //   49: dup
    //   50: aload_3
    //   51: invokespecial 971	java/net/URL:<init>	(Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 255	com/whatsapp/xg:A	Lcom/whatsapp/l/h;
    //   58: getfield 972	com/whatsapp/l/h:a	Ljava/lang/String;
    //   61: ldc_w 974
    //   64: invokestatic 977	com/whatsapp/i/a:a	(Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/i/a$a;
    //   67: astore 6
    //   69: aconst_null
    //   70: astore 5
    //   72: aload 6
    //   74: getfield 982	com/whatsapp/i/a$a:a	Ljavax/net/ssl/HttpsURLConnection;
    //   77: invokevirtual 987	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   80: istore_1
    //   81: new 260	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 989
    //   88: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: iload_1
    //   92: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 278	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   101: iload_1
    //   102: sipush 200
    //   105: if_icmpne +20 -> 125
    //   108: aload 6
    //   110: invokevirtual 990	com/whatsapp/i/a$a:close	()V
    //   113: iload_2
    //   114: ireturn
    //   115: astore_3
    //   116: ldc_w 992
    //   119: aload_3
    //   120: invokestatic 463	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: iconst_0
    //   124: ireturn
    //   125: iconst_0
    //   126: istore_2
    //   127: goto -19 -> 108
    //   130: astore_3
    //   131: aload_3
    //   132: athrow
    //   133: astore 4
    //   135: aload_3
    //   136: astore 5
    //   138: aload 4
    //   140: astore_3
    //   141: aload 5
    //   143: ifnull +10 -> 153
    //   146: aload 6
    //   148: invokevirtual 990	com/whatsapp/i/a$a:close	()V
    //   151: aload_3
    //   152: athrow
    //   153: aload 6
    //   155: invokevirtual 990	com/whatsapp/i/a$a:close	()V
    //   158: goto -7 -> 151
    //   161: astore 4
    //   163: goto -12 -> 151
    //   166: astore_3
    //   167: goto -26 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	xg
    //   80	26	1	i1	int
    //   1	126	2	bool	boolean
    //   15	36	3	localObject1	Object
    //   115	5	3	localIOException	IOException
    //   130	6	3	localThrowable1	Throwable
    //   140	12	3	localObject2	Object
    //   166	1	3	localObject3	Object
    //   20	12	4	localh	h
    //   133	6	4	localObject4	Object
    //   161	1	4	localThrowable2	Throwable
    //   70	72	5	localThrowable3	Throwable
    //   67	87	6	locala	com.whatsapp.i.a.a
    // Exception table:
    //   from	to	target	type
    //   46	69	115	java/io/IOException
    //   108	113	115	java/io/IOException
    //   146	151	115	java/io/IOException
    //   151	153	115	java/io/IOException
    //   153	158	115	java/io/IOException
    //   72	101	130	java/lang/Throwable
    //   131	133	133	finally
    //   146	151	161	java/lang/Throwable
    //   72	101	166	finally
  }
  
  protected String a()
  {
    String str2 = null;
    String str1 = null;
    InputStream localInputStream = q();
    f localf;
    byte[] arrayOfByte;
    if (localInputStream != null)
    {
      localf = new f(localInputStream);
      arrayOfByte = new byte['䀀'];
    }
    for (;;)
    {
      str1 = str2;
      try
      {
        if (localf.read(arrayOfByte) < 0)
        {
          str1 = str2;
          str2 = Base64.encodeToString(localf.a(), 2);
          str1 = str2;
          this.E = localf.a;
          str1 = str2;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.c("IOException while computing ciphertext sha-256; skipping duplicate detection; message.key=" + this.t.j(), localIOException);
        }
      }
    }
    a.d.a(localInputStream);
    return str1;
  }
  
  protected final void a(j paramj, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramj.d != 1)
    {
      Log.i("mediaupload/cancel " + paramj.e + " status:" + paramj.d);
      return;
    }
    if (this.u != null) {
      this.u.a(paramj);
    }
    if (this.x) {}
    for (paramBoolean = true;; paramBoolean = this.t.g())
    {
      Log.i("mediaupload/cancel " + paramj.e + " will-cancel:" + paramBoolean);
      if (!paramBoolean) {
        break;
      }
      if ((this.w != null) && (f()))
      {
        this.w.f.set(true);
        if (this.D) {
          bu.a(xj.a(this));
        }
      }
      cancel(true);
      p.remove(this);
      q.remove(this);
      return;
      MediaData localMediaData = paramj.b();
      if ((localMediaData.uploader == this) || (localMediaData.uploader == null))
      {
        paramj.d = 0;
        localMediaData.transferring = false;
        localMediaData.transferred = false;
        if (!paramBoolean) {
          bool = true;
        }
        localMediaData.autodownloadRetryEnabled = bool;
        localMediaData.uploader = null;
        this.e.e(paramj, -1);
      }
      this.t.a(paramj.e);
    }
  }
  
  public void a(c paramc)
  {
    this.t.i();
    Log.i("mediaupload/end " + this.t.j() + "current:" + p.size() + " pending:" + q.size() + " result:" + paramc);
    if (this.H != null) {
      this.H.cancel();
    }
    p.remove(this);
    if (!q.isEmpty()) {
      ((xg)q.remove(0)).j();
    }
    if (this.x) {
      return;
    }
    int i2;
    if ((paramc == c.a) && (this.n) && (k())) {
      i2 = 2;
    }
    for (;;)
    {
      this.t.a(this.b, i2);
      if ((!isCancelled()) && (paramc != c.a)) {
        this.a.a(xn.a(this, paramc));
      }
      int i1;
      label210:
      j localj;
      MediaData localMediaData1;
      long l1;
      label237:
      boolean bool2;
      long l2;
      xw localxw;
      MediaData localMediaData2;
      boolean bool3;
      boolean bool4;
      if ((paramc == c.a) && (this.n)) {
        if (this.w != null)
        {
          i1 = 1;
          localj = this.t.n();
          localMediaData1 = localj.b();
          if (!localMediaData1.uploadRetry) {
            break label1348;
          }
          l1 = 1L;
          bool2 = f();
          l2 = this.l;
          localxw = this.F;
          localMediaData2 = localj.b();
          bool3 = localMediaData2.forward;
          bool4 = localMediaData2.transcoded;
        }
      }
      try
      {
        if (localMediaData2.uploadUrl != null) {}
        for (Object localObject1 = new URL(localMediaData2.uploadUrl);; localObject1 = null)
        {
          if ((localObject1 == null) || ((!((URL)localObject1).getHost().endsWith("mme.whatsapp.net")) && (!((URL)localObject1).getHost().endsWith(".cdn.whatsapp.net")))) {
            break label1408;
          }
          bool1 = true;
          if (localObject1 == null) {
            break label1414;
          }
          localObject1 = localObject1.getHost().split("\\.")[0];
          localav = new com.whatsapp.fieldstats.events.av();
          localav.y = Boolean.valueOf(localxw.m);
          localav.a = Integer.valueOf(a.a.a.a.d.a(localj));
          localav.c = Boolean.valueOf(bool3);
          localav.b = Integer.valueOf(i1);
          localav.d = Long.valueOf(l1);
          localav.n = Double.valueOf(localj.t);
          if (localxw.g() > 0L) {
            localav.m = Double.valueOf(localxw.g());
          }
          localav.s = Double.valueOf(localxw.h());
          if (localxw.i() > 0L)
          {
            localav.t = Double.valueOf(localxw.i());
            localav.j = Long.valueOf(localxw.f);
          }
          localav.v = localxw.b();
          localav.w = localxw.f();
          localav.u = localxw.d();
          localav.q = localxw.e();
          localav.f = Boolean.valueOf(bool4);
          localav.e = Boolean.valueOf(bool1);
          localav.x = Boolean.valueOf(bool2);
          localav.z = Double.valueOf(l2);
          localav.g = ((String)localObject1);
          if (!localxw.j) {
            break label1420;
          }
          l1 = 4L;
          localav.k = Long.valueOf(l1);
          localav.l = localxw.i;
          localav.B = Integer.valueOf(localxw.n);
          if ((localxw.h == null) || (localxw.h.longValue() < 0L)) {
            break label1428;
          }
          localObject1 = Double.valueOf(localxw.h.longValue());
          localav.r = ((Double)localObject1);
          if (!a.a.a.a.d.c(i1)) {
            break label1434;
          }
          localObject1 = localxw.k;
          localav.C = ((String)localObject1);
          if (!a.a.a.a.d.c(i1)) {
            break label1440;
          }
          localObject1 = localxw.l;
          localav.D = ((String)localObject1);
          if ((i1 != 3) && (i1 != 1)) {
            break label1446;
          }
          l.a(u.a(), localav);
          w.a().c();
          if (av.k())
          {
            localObject1 = new StringBuilder("mediaupload/event/isManual=").append(this.F.m).append(", type=").append(localj.s).append(", isForward=").append(localMediaData1.forward).append(", dedup=");
            if (this.w != null) {
              break label1470;
            }
            bool1 = true;
            Log.d(bool1 + ", upload_result=" + paramc + ", uploadRetry=" + localMediaData1.uploadRetry + ", totalUploadTime=" + this.F.g() + ", userVisibleTime=" + this.F.h() + ", requestIQTime=" + this.F.b() + ", resumeCheckTime=" + this.F.i() + ", networkUploadTime=" + this.F.d() + ", connectTime=" + this.F.e() + ", uploadResponseWaitTime=" + this.F.f() + ", isStreamingUpload=" + f() + ", size=" + localj.t + ", uploadResumePoint=" + this.F.f + ", bytesSent=" + this.l + ", url=" + MediaFileUtils.a(localMediaData1.uploadUrl) + ", ip=" + this.F.k + ", exception=" + this.F.l + " " + this.t.j());
          }
          if (this.t.q())
          {
            localObject1 = amt.a();
            localj = this.t.n();
            if (!localMediaData1.uploadRetry) {
              break label1476;
            }
            i3 = 1;
            ((amt)localObject1).a(localj, i3, amt.c(i1));
          }
          if ((paramc != c.a) && (!isCancelled())) {
            this.t.a(new xo(paramc));
          }
          this.t.a(new xp(this, i2));
          return;
          i2 = 0;
          break;
          i1 = 3;
          break label210;
          switch (zh.c[paramc.ordinal()])
          {
          default: 
            i1 = 2;
            break;
          case 1: 
            i1 = 1;
            break;
          case 2: 
            i1 = 2;
            break;
          case 3: 
            i1 = 10;
            break;
          case 4: 
            i1 = 7;
            break;
          case 5: 
            i1 = 6;
            break;
          case 6: 
            i1 = 9;
            break;
          case 7: 
            i1 = 8;
            break;
          case 8: 
            i1 = 11;
            break;
          case 9: 
            i1 = 12;
            break;
          case 10: 
            i1 = 4;
            break;
          case 11: 
            i1 = 14;
            break;
          case 12: 
            i1 = 13;
            break;
          case 13: 
            i1 = 15;
            break;
            label1348:
            l1 = 0L;
            break label237;
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          com.whatsapp.fieldstats.events.av localav;
          Log.c("fieldstathelpers/postmediauploadevent MMS url attached to message is malformed; message.key=" + localj.e + " url=" + localj.p, localMalformedURLException);
          Object localObject2 = null;
          continue;
          label1408:
          boolean bool1 = false;
          continue;
          label1414:
          localObject2 = null;
          continue;
          label1420:
          l1 = 3L;
          continue;
          label1428:
          localObject2 = null;
          continue;
          label1434:
          localObject2 = null;
          continue;
          label1440:
          localObject2 = null;
          continue;
          label1446:
          localav.A = MediaFileUtils.a(localMediaData2.uploadUrl);
          l.c(u.a(), localav);
          continue;
          label1470:
          bool1 = false;
          continue;
          label1476:
          int i3 = 0;
        }
      }
    }
  }
  
  protected String b()
  {
    if (this.C == null) {
      this.C = a();
    }
    return this.C;
  }
  
  public final void b(j paramj)
  {
    a(paramj, true);
  }
  
  protected InputStream c()
  {
    FileInputStream localFileInputStream = new FileInputStream(this.t.h());
    MediaFileUtils.a(localFileInputStream);
    return localFileInputStream;
  }
  
  protected boolean d()
  {
    return af.b(this.t.h());
  }
  
  protected String e()
  {
    return af.a(af.f(this.t.h()));
  }
  
  protected boolean f()
  {
    return false;
  }
  
  protected String g()
  {
    return MediaFileUtils.c(this.t.h());
  }
  
  @Deprecated
  protected long h()
  {
    return this.t.n().t;
  }
  
  public final void j()
  {
    if (aic.c(p())) {
      this.f.c();
    }
    xw localxw = this.F;
    if (localxw.b == null) {
      localxw.b = Long.valueOf(SystemClock.uptimeMillis());
    }
    Log.i("mediaupload/start " + this.t.j() + " current:" + p.size() + " pending:" + q.size());
    if (p.size() > 10)
    {
      q.add(this);
      return;
    }
    p.add(this);
    this.F.a = SystemClock.uptimeMillis();
    bu.a(new AsyncTask()
    {
      xg.c a = xg.c.a;
      
      private Pair<String, MediaData> a()
      {
        Object localObject3 = null;
        xg.a(xg.this, aic.c(xg.q(xg.this)));
        xg.c(xg.this).j = xg.d(xg.this);
        Object localObject1;
        if (xg.d(xg.this))
        {
          long l1 = SystemClock.elapsedRealtime();
          xg.a(xg.this, xg.this.f.b());
          long l2 = SystemClock.elapsedRealtime();
          if (xg.e(xg.this) == null)
          {
            xg.this.cancel(true);
            return null;
          }
          localObject1 = xg.c(xg.this);
          l1 = l2 - l1;
          ((xw)localObject1).h = Long.valueOf(l1);
          Log.d("mediaupload/getselectedroute/took " + l1 + "ms to get route");
        }
        File localFile = xg.r(xg.this);
        if (xg.r(xg.this) != null) {
          localObject1 = xg.this.g();
        }
        for (;;)
        {
          MediaData localMediaData;
          if (localObject1 != null) {
            localMediaData = xg.this.g.a((String)localObject1, false);
          }
          try
          {
            bool = xg.this.c.a(localFile);
            if (!bool)
            {
              localObject2 = localObject3;
              if (localMediaData != null)
              {
                localObject2 = localObject3;
                if (localMediaData.transferred)
                {
                  localObject2 = localObject3;
                  if (localMediaData.file != null)
                  {
                    localObject2 = localObject3;
                    if (localMediaData.file.isAbsolute())
                    {
                      localObject2 = localObject3;
                      if (localMediaData.file.exists()) {
                        localObject2 = localMediaData.file;
                      }
                    }
                  }
                }
              }
              if (localObject2 == null) {
                localObject2 = MediaFileUtils.a(u.a(), xg.this.c, localFile, xg.s(xg.this), xg.t(xg.this));
              }
            }
          }
          catch (IOException localIOException1)
          {
            for (;;)
            {
              try
              {
                Object localObject2;
                MediaFileUtils.a(localFile, (File)localObject2);
                xg.f(xg.this).a((File)localObject2);
                return Pair.create(localObject1, localMediaData);
                localObject1 = null;
                break;
                localMediaData = null;
                continue;
                localIOException1 = localIOException1;
                Log.e("mediaupload/inmediafolder/ " + localIOException1);
                this.a = xg.c.d;
                boolean bool = false;
              }
              catch (FileNotFoundException localFileNotFoundException)
              {
                Log.d("mediaupload/requestupload/file-not-found", localFileNotFoundException);
                this.a = xg.c.h;
                continue;
              }
              catch (IOException localIOException2)
              {
                Log.d("mediaupload/requestupload/copy-failed", localIOException2);
                continue;
              }
              xg.f(xg.this).a(localIOException2);
              xg.this.g.a(localIOException2.getAbsolutePath(), xg.f(xg.this).r());
              continue;
              if ((xg.f(xg.this).p() > 1) && (!xg.f(xg.this).s())) {
                xg.this.g.a(localFile.getAbsolutePath(), xg.f(xg.this).p() - 1);
              }
            }
          }
        }
      }
    }, new Void[0]);
  }
  
  protected final boolean k()
  {
    try
    {
      URL localURL = new URL(this.o.c);
      if ((localURL.getHost() == null) || (localURL.getHost().length() == 0))
      {
        Log.e("mediaupload/url/no-host");
        this.t.b(this.e);
        return false;
      }
    }
    catch (Exception localException)
    {
      Log.w("mediaupload/url/error " + localException);
      if ((!this.D) && ((this.o.b == null) || (this.o.c == null) || (this.o.d == 0L)))
      {
        Log.e("mediaupload/missing keys in upload result");
        this.t.b(this.e);
        return false;
      }
      this.t.a(new xi(this));
    }
    return true;
  }
  
  protected void onCancelled()
  {
    Log.i("mediaupload/oncancelled " + this.t.j());
    if (this.I)
    {
      a(c.k);
      return;
    }
    a(c.m);
  }
  
  public final class a
    implements ae
  {
    public String a;
    public String b;
    public String c;
    public String d;
    @Deprecated
    public long e;
    public byte[] f;
    public boolean g;
    
    public a() {}
    
    private void a(xg.b paramb)
    {
      xg.this.a.a(xu.a(this, paramb));
    }
    
    public final void a(int paramInt)
    {
      Log.w("mediaupload/onerror " + paramInt + " " + xg.a(xg.this));
      xg.b(xg.this).cancel();
      xg.c(xg.this).a();
      xg.c localc = xg.c.j;
      xg.this.a.a(xv.a(this, localc));
      if (xg.d(xg.this)) {
        xg.this.f.a(paramInt);
      }
    }
    
    public final void a(com.whatsapp.protocol.ad paramad)
    {
      Log.i("mediaupload/onduplicate " + MediaFileUtils.a(paramad.c) + ' ' + paramad.f + ' ' + paramad.d + ' ' + xg.a(xg.this));
      xg.c(xg.this).a();
      xg.b(xg.this).cancel();
      xg.this.o = paramad;
      xg.h(xg.this);
      xg.this.n = true;
      a(null);
    }
    
    public final void a(String paramString1, String paramString2, int paramInt)
    {
      Log.i("mediaupload/onupload " + MediaFileUtils.a(paramString1) + ' ' + paramString2 + ' ' + paramInt + ' ' + xg.a(xg.this) + " isNewlyGeneratedMediaKey=" + this.g);
      xg.b(xg.this).cancel();
      xg.c(xg.this).a();
      paramString2 = paramString1;
      if (xg.e(xg.this) == null)
      {
        String str = xg.this.i.m();
        paramString2 = paramString1;
        if (str != null)
        {
          paramString1 = Uri.parse(paramString1);
          paramString2 = paramString1.buildUpon().authority(str).path(paramString1.getHost()).appendEncodedPath(paramString1.getEncodedPath()).build().toString();
        }
      }
      xg.f(xg.this).e(paramString2);
      if (!xg.g(xg.this)) {
        xg.f(xg.this).a(new xt(this));
      }
      if (!this.g)
      {
        bu.a(xs.a(this, paramString2));
        return;
      }
      a(new xg.b(xg.this, paramString2, paramInt));
    }
  }
  
  public final class b
  {
    public final String a;
    public final int b;
    
    public b(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
    }
  }
  
  public static enum c
  {
    private c() {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/xg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */