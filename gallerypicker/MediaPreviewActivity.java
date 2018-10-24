package com.whatsapp.gallerypicker;

import a.a.a.a.a.a.d;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.r;
import android.support.v4.f.f;
import android.support.v4.view.ViewPager.f;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.p;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.whatsapp.ContactPicker;
import com.whatsapp.Conversation;
import com.whatsapp.GifHelper;
import com.whatsapp.MediaData;
import com.whatsapp.PhotoView;
import com.whatsapp.PhotoViewPager;
import com.whatsapp.TextEmojiLabel;
import com.whatsapp.ahx;
import com.whatsapp.aic;
import com.whatsapp.ane;
import com.whatsapp.anf;
import com.whatsapp.aoa;
import com.whatsapp.aof;
import com.whatsapp.aoj;
import com.whatsapp.aqe;
import com.whatsapp.data.e;
import com.whatsapp.di;
import com.whatsapp.di.e;
import com.whatsapp.emoji.c;
import com.whatsapp.emoji.h;
import com.whatsapp.nh;
import com.whatsapp.oz;
import com.whatsapp.protocol.j;
import com.whatsapp.pv;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.MediaFileUtils.c;
import com.whatsapp.util.MediaFileUtils.e;
import com.whatsapp.util.MediaFileUtils.f;
import com.whatsapp.util.az;
import com.whatsapp.util.bm;
import com.whatsapp.util.bu;
import com.whatsapp.va;
import com.whatsapp.vp;
import com.whatsapp.vr.a;
import com.whatsapp.yr;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public class MediaPreviewActivity
  extends nh
  implements an.b
{
  HashMap<Uri, Boolean> A = new HashMap();
  HashMap<Uri, Point> B = new HashMap();
  final Rect C = new Rect();
  private PhotoViewPager D;
  private a E;
  private View F;
  private d G;
  private ArrayList<String> H = new ArrayList();
  private int I = -1;
  private final HashMap<Uri, Long> J = new HashMap();
  private final HashSet<Uri> K = new HashSet();
  private final HashMap<Uri, MediaFileUtils.f> L = new HashMap();
  private ao M;
  private b N;
  private final Handler O = new Handler(Looper.getMainLooper());
  private b P;
  private di.e Q;
  private f<String, Bitmap> R = new f((int)(Runtime.getRuntime().maxMemory() / 1024L / 6L)) {};
  private final com.whatsapp.c.a S = com.whatsapp.c.a.a();
  private final ahx T = ahx.a();
  private final oz U = oz.a();
  private final aoj V = aoj.a();
  private final vp W = vp.a();
  private final h X = h.a();
  private final di Y = di.a();
  private final e Z = e.a();
  private final com.whatsapp.data.l aa = com.whatsapp.data.l.a();
  private final ane ab = ane.a();
  private final View.OnTouchListener ac = new View.OnTouchListener()
  {
    float a;
    float b;
    
    public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      switch (paramAnonymousMotionEvent.getAction())
      {
      }
      do
      {
        return false;
        this.a = paramAnonymousMotionEvent.getX();
        this.b = paramAnonymousMotionEvent.getY();
        return false;
        paramAnonymousView = MediaPreviewActivity.e(MediaPreviewActivity.this);
        paramAnonymousView.n.removeCallbacks(paramAnonymousView.o);
        return false;
      } while (MediaPreviewActivity.e(MediaPreviewActivity.this).f != null);
      float f2 = this.b;
      float f3 = paramAnonymousMotionEvent.getY();
      float f1 = this.a - paramAnonymousMotionEvent.getX();
      Object localObject = (LinearLayoutManager)MediaPreviewActivity.f(MediaPreviewActivity.this).getLayoutManager();
      if (f1 > 0.0F) {
        if (((LinearLayoutManager)localObject).m() < MediaPreviewActivity.g(MediaPreviewActivity.this).a() - 1) {
          f1 = Math.abs(f1);
        }
      }
      for (;;)
      {
        if (f1 >= aoa.a().a * 2.0F) {
          break label577;
        }
        if (f2 - f3 <= aoa.a().a * 2.0F) {
          break;
        }
        paramAnonymousView = (MediaPreviewActivity.c)paramAnonymousView;
        localObject = MediaPreviewActivity.e(MediaPreviewActivity.this);
        PhotoViewPager localPhotoViewPager = MediaPreviewActivity.h(MediaPreviewActivity.this);
        f1 = paramAnonymousMotionEvent.getX();
        f2 = paramAnonymousMotionEvent.getY();
        ((b)localObject).f = paramAnonymousView;
        ((b)localObject).g = paramAnonymousView.getUri();
        ((b)localObject).c.setImageDrawable(paramAnonymousView.getDrawable());
        ((b)localObject).c.setMaxWidth(paramAnonymousView.getWidth());
        ((b)localObject).c.setMaxHeight(paramAnonymousView.getHeight());
        ((b)localObject).c.setLayoutParams(new FrameLayout.LayoutParams(paramAnonymousView.getWidth(), paramAnonymousView.getHeight()));
        ((b)localObject).i = f1;
        ((b)localObject).h = f2;
        ((b)localObject).f.invalidate();
        ((b)localObject).n.removeCallbacks(((b)localObject).o);
        ((b)localObject).n.postDelayed(((b)localObject).o, 100L);
        ((b)localObject).e.setBackgroundColor(0);
        ((b)localObject).d.setTextColor(0);
        ((b)localObject).l.setAlpha(0);
        ((b)localObject).a.setVisibility(0);
        ((b)localObject).b.getLocationOnScreen(((b)localObject).j);
        int i = localObject.j[0];
        int j = localObject.j[1];
        ((b)localObject).f.getLocationOnScreen(((b)localObject).j);
        int k = localObject.j[0];
        int m = localObject.j[1];
        ((b)localObject).b.setPadding(k - i, m - j, 0, 0);
        ((b)localObject).e.setPadding(0, 0, 0, ((b)localObject).a.getHeight() - localPhotoViewPager.getHeight());
        ((b)localObject).d.getLocationOnScreen(((b)localObject).j);
        if ((MediaPreviewActivity.i(MediaPreviewActivity.this) < 0) || (MediaPreviewActivity.c.a(paramAnonymousView) == MediaPreviewActivity.i(MediaPreviewActivity.this))) {
          break;
        }
        MediaPreviewActivity.b(MediaPreviewActivity.this, MediaPreviewActivity.c.a(paramAnonymousView));
        MediaPreviewActivity.g(MediaPreviewActivity.this).c();
        return false;
        f1 = 0.0F;
        continue;
        if (((LinearLayoutManager)localObject).l() > 0) {
          f1 = Math.abs(f1);
        } else {
          f1 = 0.0F;
        }
      }
      label577:
      this.a = -1.0F;
      this.b = -1.0F;
      return false;
    }
  };
  TextEmojiLabel n;
  ImageView o;
  View p;
  RecyclerView q;
  ArrayList<Uri> r;
  HashMap<Uri, Byte> s = new HashMap();
  HashMap<Uri, File> t = new HashMap();
  HashMap<Uri, String> u = new HashMap();
  HashMap<Uri, String> v = new HashMap();
  HashMap<Uri, String> w = new HashMap();
  HashMap<Uri, Integer> x = new HashMap();
  HashMap<Uri, Uri> y = new HashMap();
  HashMap<Uri, Rect> z = new HashMap();
  
  private Uri a(com.whatsapp.fieldstats.events.at paramat, Uri paramUri, j paramj, boolean paramBoolean)
  {
    Object localObject1;
    int i;
    if (this.y.containsKey(paramUri))
    {
      localObject1 = ((Uri)this.y.get(paramUri)).buildUpon();
      paramat.f = Long.valueOf(paramat.f.longValue() + 1L);
      i = 0;
    }
    for (;;)
    {
      Object localObject2 = (Integer)this.x.get(paramUri);
      if (localObject2 != null)
      {
        ((Uri.Builder)localObject1).appendQueryParameter("rotation", ((Integer)localObject2).toString());
        i = 0;
      }
      Object localObject6 = (String)this.w.get(paramUri);
      localObject2 = localObject1;
      int m = i;
      Object localObject7;
      Object localObject5;
      int i1;
      Object localObject4;
      int i2;
      if (!TextUtils.isEmpty((CharSequence)localObject6))
      {
        localObject7 = new com.whatsapp.doodle.a.b();
        localObject5 = localObject1;
        m = i;
        localObject2 = localObject1;
        i1 = i;
        localObject4 = localObject1;
        i2 = i;
      }
      try
      {
        ((com.whatsapp.doodle.a.b)localObject7).a((String)localObject6, this);
        localObject5 = localObject1;
        m = i;
        localObject2 = localObject1;
        i1 = i;
        localObject4 = localObject1;
        i2 = i;
        boolean bool = this.H.contains("status@broadcast");
        if (bool)
        {
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          j = aic.R;
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          localObject6 = MediaFileUtils.a(this.aE, ((Uri.Builder)localObject1).build(), j, j);
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          localObject1 = Uri.fromFile(u.a(this.U, paramUri)).buildUpon();
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          if (!((Bitmap)localObject6).isMutable()) {
            break label1210;
          }
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          j = ((com.whatsapp.doodle.a.b)localObject7).d;
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          localCanvas = new Canvas((Bitmap)localObject6);
          if (j % 180 != 90) {
            break label1248;
          }
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          f1 = ((Bitmap)localObject6).getHeight() / ((com.whatsapp.doodle.a.b)localObject7).c.width();
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          f2 = ((Bitmap)localObject6).getWidth() / ((com.whatsapp.doodle.a.b)localObject7).c.height();
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          localCanvas.scale(f1, f2);
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          localCanvas.rotate(j);
          if (j != 90) {
            break label1333;
          }
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          localCanvas.translate(0.0F, -((com.whatsapp.doodle.a.b)localObject7).c.height());
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          localCanvas.translate(-((com.whatsapp.doodle.a.b)localObject7).c.left, -((com.whatsapp.doodle.a.b)localObject7).c.top);
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          ((com.whatsapp.doodle.a.b)localObject7).a(localCanvas);
          j = i;
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          if (((com.whatsapp.doodle.a.b)localObject7).c())
          {
            localObject5 = localObject1;
            m = i;
            localObject2 = localObject1;
            i1 = i;
            localObject4 = localObject1;
            i2 = i;
            paramat.g = Long.valueOf(paramat.g.longValue() + 1L);
            j = 0;
          }
          int k = j;
          localObject5 = localObject1;
          m = j;
          localObject2 = localObject1;
          i1 = j;
          localObject4 = localObject1;
          i2 = j;
          if (((com.whatsapp.doodle.a.b)localObject7).d())
          {
            localObject5 = localObject1;
            m = j;
            localObject2 = localObject1;
            i1 = j;
            localObject4 = localObject1;
            i2 = j;
            paramat.h = Long.valueOf(paramat.h.longValue() + 1L);
            k = 0;
          }
          i = k;
          localObject5 = localObject1;
          m = k;
          localObject2 = localObject1;
          i1 = k;
          localObject4 = localObject1;
          i2 = k;
          if (((com.whatsapp.doodle.a.b)localObject7).b())
          {
            localObject5 = localObject1;
            m = k;
            localObject2 = localObject1;
            i1 = k;
            localObject4 = localObject1;
            i2 = k;
            paramat.i = Long.valueOf(paramat.i.longValue() + 1L);
            i = 0;
          }
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          localObject7 = new FileOutputStream(new File(((Uri.Builder)localObject1).build().getPath()));
          if (!bool) {
            break label1511;
          }
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          j = aic.Q;
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          ((Bitmap)localObject6).compress(Bitmap.CompressFormat.JPEG, j, (OutputStream)localObject7);
          localObject5 = localObject1;
          m = i;
          localObject2 = localObject1;
          i1 = i;
          localObject4 = localObject1;
          i2 = i;
          a.d.a((Closeable)localObject7);
          if (i == 0) {
            break label1543;
          }
          paramat.c = Long.valueOf(paramat.c.longValue() + 1L);
          if (this.u.get(paramUri) != null) {
            break label1562;
          }
          paramat = null;
          paramUri = (String)this.v.get(paramUri);
          if (!paramBoolean) {
            break label1777;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          try
          {
            Canvas localCanvas;
            this.T.a(this.H, ((Uri.Builder)localObject1).build(), 0, paramj, yr.a(paramUri), paramat, getIntent().getBooleanExtra("number_from_url", false));
            return ((Uri.Builder)localObject1).build();
            localObject1 = Uri.fromFile(b(paramUri)).buildUpon();
            i = 1;
            break;
            localObject5 = localObject1;
            m = i;
            localObject2 = localObject1;
            i1 = i;
            localObject4 = localObject1;
            i2 = i;
            int j = aic.x;
            continue;
            localObject5 = localObject1;
            m = i;
            localObject2 = localObject1;
            i1 = i;
            localObject4 = localObject1;
            i2 = i;
            localObject6 = ((Bitmap)localObject6).copy(Bitmap.Config.ARGB_8888, true);
            continue;
            localObject5 = localObject1;
            m = i;
            localObject2 = localObject1;
            i1 = i;
            localObject4 = localObject1;
            i2 = i;
            float f1 = ((Bitmap)localObject6).getWidth() / ((com.whatsapp.doodle.a.b)localObject7).c.width();
            localObject5 = localObject1;
            m = i;
            localObject2 = localObject1;
            i1 = i;
            localObject4 = localObject1;
            i2 = i;
            float f2 = ((Bitmap)localObject6).getHeight() / ((com.whatsapp.doodle.a.b)localObject7).c.height();
            continue;
            if (j == 180)
            {
              localObject5 = localObject1;
              m = i;
              localObject2 = localObject1;
              i1 = i;
              localObject4 = localObject1;
              i2 = i;
              localCanvas.translate(-((com.whatsapp.doodle.a.b)localObject7).c.width(), -((com.whatsapp.doodle.a.b)localObject7).c.height());
              continue;
              localJSONException = localJSONException;
              localObject1 = localObject5;
              localObject5 = localJSONException;
              Log.d("mediapreview/cannot load doodle", (Throwable)localObject5);
              localObject3 = localObject1;
              localObject1 = localObject3;
              i = m;
              continue;
            }
            if (j == 270)
            {
              localObject5 = localObject1;
              m = i;
              localObject3 = localObject1;
              i1 = i;
              localObject4 = localObject1;
              i2 = i;
              localCanvas.translate(-((com.whatsapp.doodle.a.b)localObject7).c.width(), 0.0F);
              continue;
            }
            if (j == 0) {
              continue;
            }
            localObject5 = localObject1;
            m = i;
            localObject3 = localObject1;
            i1 = i;
            localObject4 = localObject1;
            i2 = i;
            throw new IllegalArgumentException();
            localObject5 = localObject1;
            m = i;
            localObject3 = localObject1;
            i1 = i;
            localObject4 = localObject1;
            i2 = i;
            j = aic.w;
            continue;
            paramat.e = Long.valueOf(paramat.e.longValue() + 1L);
            continue;
            paramat = c.b((String)this.u.get(paramUri));
          }
          catch (IOException paramat)
          {
            Log.e("sendmedia/sendimages/share-failed/ " + paramat.toString());
            if ((paramat.getMessage() != null) && (paramat.getMessage().contains("No space")))
            {
              this.aq.b(com.whatsapp.u.a(), 2131296742, 0);
              continue;
            }
            pv.a(com.whatsapp.u.a(), 2131297841, 0);
            continue;
          }
          catch (MediaFileUtils.e paramat)
          {
            Log.e("sendmedia/sendimages/share-failed/ " + paramat.toString());
            this.aq.b(com.whatsapp.u.a(), 2131296734, 0);
            continue;
          }
          catch (OutOfMemoryError paramat)
          {
            Log.e("sendmedia/sendimages/share-failed/ " + paramat.toString());
            this.aq.b(com.whatsapp.u.a(), 2131296746, 0);
            continue;
          }
          catch (SecurityException paramat)
          {
            Log.e("sendmedia/sendimages/share-failed/ " + paramat.toString());
            this.aq.b(com.whatsapp.u.a(), 2131297282, 0);
            continue;
          }
          if (paramat != null) {
            ((Uri.Builder)localObject1).appendQueryParameter("caption", paramat);
          }
          if (paramUri != null) {
            ((Uri.Builder)localObject1).appendQueryParameter("mentions", paramUri);
          }
        }
      }
      catch (MediaFileUtils.e locale)
      {
        for (;;)
        {
          Object localObject3;
          localObject1 = localObject3;
          m = i1;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          label1210:
          label1248:
          label1333:
          label1511:
          label1543:
          label1562:
          label1777:
          localObject1 = localObject4;
          m = i2;
        }
      }
    }
  }
  
  private Uri b(com.whatsapp.fieldstats.events.at paramat, Uri paramUri, j paramj, boolean paramBoolean)
  {
    Object localObject1 = (Point)this.B.get(paramUri);
    long l2;
    long l1;
    int i;
    MediaData localMediaData;
    String str;
    Object localObject2;
    if (localObject1 != null)
    {
      l2 = ((Point)localObject1).x;
      l1 = ((Point)localObject1).y;
      i = 0;
      localObject1 = b(paramUri);
      localMediaData = new MediaData();
      localMediaData.file = ((File)localObject1);
      localMediaData.trimFrom = l2;
      localMediaData.trimTo = l1;
      str = (String)this.w.get(paramUri);
      if (!TextUtils.isEmpty(str)) {
        localObject2 = new com.whatsapp.doodle.a.b();
      }
    }
    else
    {
      try
      {
        ((com.whatsapp.doodle.a.b)localObject2).a(str, this);
        i = 0;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          label115:
          Log.d("mediapreview/cannot load doodle", localJSONException2);
        }
      }
      if (localObject2 != null) {
        break label288;
      }
      localObject1 = MediaFileUtils.a(((File)localObject1).getAbsolutePath(), 1000L * l2);
    }
    for (;;)
    {
      byte b = j(paramUri);
      if (this.A.containsKey(paramUri)) {
        b = 13;
      }
      if (i != 0)
      {
        paramat.c = Long.valueOf(paramat.c.longValue() + 1L);
        label179:
        if (this.u.get(paramUri) != null) {
          break label504;
        }
        paramat = null;
        label192:
        localObject2 = (String)this.v.get(paramUri);
        if (!paramBoolean) {
          break label522;
        }
        this.V.a(this.W.a(this.H, localMediaData, b, 0, paramat, null, paramj, yr.a((String)localObject2), getIntent().getBooleanExtra("number_from_url", false)), (byte[])localObject1, null);
        return paramUri;
        l1 = 0L;
        l2 = 0L;
        i = 1;
        break;
        localObject2 = null;
        break label115;
        label288:
        Bitmap localBitmap = MediaFileUtils.g(localMediaData.file.getAbsolutePath());
        localObject1 = localBitmap;
        if (localBitmap != null)
        {
          localObject1 = localBitmap;
          if (!localBitmap.isMutable()) {
            localObject1 = localBitmap.copy(Bitmap.Config.ARGB_8888, true);
          }
        }
        if (localObject1 != null)
        {
          ((com.whatsapp.doodle.a.b)localObject2).a((Bitmap)localObject1, 0);
          localObject1 = MediaFileUtils.a((Bitmap)localObject1);
          if (((com.whatsapp.doodle.a.b)localObject2).c())
          {
            paramat.g = Long.valueOf(paramat.g.longValue() + 1L);
            i = 0;
          }
          if (((com.whatsapp.doodle.a.b)localObject2).d())
          {
            paramat.h = Long.valueOf(paramat.h.longValue() + 1L);
            i = 0;
          }
          if (((com.whatsapp.doodle.a.b)localObject2).b())
          {
            paramat.i = Long.valueOf(paramat.i.longValue() + 1L);
            i = 0;
          }
          localMediaData.doodleId = MediaFileUtils.a(this.ar);
        }
      }
      try
      {
        ((com.whatsapp.doodle.a.b)localObject2).a(MediaFileUtils.a(this.U, localMediaData.doodleId));
        continue;
        localObject1 = null;
      }
      catch (JSONException localJSONException1)
      {
        Log.d("mediapreview/cannot save doodle", localJSONException1);
        continue;
        paramat.e = Long.valueOf(paramat.e.longValue() + 1L);
        break label179;
        paramat = c.b((String)this.u.get(paramUri));
        break label192;
        paramUri = paramUri.buildUpon();
        if (paramat != null) {
          paramUri.appendQueryParameter("caption", paramat);
        }
        if (localJSONException1 != null) {
          paramUri.appendQueryParameter("mentions", localJSONException1);
        }
        if ((l2 != 0L) && (l1 != 0L))
        {
          paramUri.appendQueryParameter("from", Long.toString(l2));
          paramUri.appendQueryParameter("to", Long.toString(l1));
        }
        if (localMediaData.doodleId != null) {
          paramUri.appendQueryParameter("doodle", localMediaData.doodleId);
        }
        return paramUri.build();
      }
      catch (IOException localIOException)
      {
        label504:
        label522:
        for (;;) {}
      }
    }
  }
  
  private void d(int paramInt)
  {
    Log.d("mediapreview/select " + paramInt);
    this.I = paramInt;
    this.G.c();
    this.q.c(this.I);
    Object localObject1 = s();
    Object localObject2 = S().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Fragment localFragment = (Fragment)((Iterator)localObject2).next();
      if (((localFragment instanceof an)) && (localFragment != localObject1)) {
        ((an)localFragment).b();
      }
    }
    if (localObject1 != null)
    {
      ((an)localObject1).c(findViewById(2131755835));
      ((an)localObject1).a();
    }
    localObject1 = l();
    localObject2 = (CharSequence)this.u.get(localObject1);
    if (localObject2 != null)
    {
      localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
      yr.a(this, this.Z, (SpannableStringBuilder)localObject2, yr.a((String)this.v.get(localObject1)), false, true);
      this.n.b((CharSequence)localObject2);
      return;
    }
    this.n.setText(null);
  }
  
  private byte j(Uri paramUri)
  {
    Byte localByte2 = (Byte)this.s.get(paramUri);
    Byte localByte1 = localByte2;
    if (localByte2 == null)
    {
      localByte2 = Byte.valueOf(MediaFileUtils.e(this.aE, paramUri));
      localByte1 = localByte2;
      if (localByte2.byteValue() == 3)
      {
        localByte1 = localByte2;
        if (GifHelper.a(b(paramUri))) {
          localByte1 = Byte.valueOf((byte)13);
        }
      }
      this.s.put(paramUri, localByte1);
    }
    return localByte1.byteValue();
  }
  
  private void u()
  {
    if (this.M != null)
    {
      this.M.a();
      this.M = null;
    }
    this.S.a.a(-1);
    if (this.D != null)
    {
      int i = 0;
      while (i < this.D.getChildCount())
      {
        View localView = this.D.getChildAt(i);
        if ((localView instanceof PhotoView)) {
          ((PhotoView)localView).c();
        }
        i += 1;
      }
    }
    bu.a(anf.a(this.ab));
  }
  
  final void a(Uri paramUri)
  {
    this.K.add(paramUri);
    this.r.remove(paramUri);
    this.x.remove(paramUri);
    this.y.remove(paramUri);
    this.z.remove(paramUri);
    this.u.remove(paramUri);
    this.v.remove(paramUri);
    this.w.remove(paramUri);
    this.B.remove(paramUri);
    this.A.remove(paramUri);
    if (this.r.isEmpty()) {
      finish();
    }
    do
    {
      return;
      this.E.c();
      this.G.c();
      if (this.I >= this.r.size()) {
        this.I = (this.r.size() - 1);
      }
      if (this.I >= 0)
      {
        this.D.setCurrentItem(this.I);
        d(this.I);
      }
    } while (this.r.size() != 1);
    this.q.setVisibility(8);
  }
  
  public final void a(Uri paramUri, long paramLong1, long paramLong2)
  {
    this.B.put(paramUri, new Point((int)paramLong1, (int)paramLong2));
  }
  
  public final void a(Uri paramUri1, Uri paramUri2, Rect paramRect, int paramInt)
  {
    if (paramRect == null)
    {
      this.z.remove(paramUri1);
      if (paramInt != 0) {
        break label134;
      }
      this.x.remove(paramUri1);
    }
    for (;;)
    {
      this.y.put(paramUri1, paramUri2);
      paramUri2 = this.S.a;
      paramUri2.b(paramUri1.toString());
      paramUri2.b(paramUri1.toString() + "-thumb");
      this.R.b(paramUri1.toString() + "-thumb");
      this.G.c();
      return;
      this.z.put(paramUri1, paramRect);
      break;
      label134:
      this.x.put(paramUri1, Integer.valueOf(paramInt));
    }
  }
  
  public final void a(Uri paramUri, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.A.put(paramUri, Boolean.valueOf(true));
      return;
    }
    this.A.remove(paramUri);
  }
  
  public final File b(Uri paramUri)
  {
    return (File)this.t.get(paramUri);
  }
  
  public final MediaFileUtils.f c(Uri paramUri)
  {
    return (MediaFileUtils.f)this.L.get(paramUri);
  }
  
  public final String d(Uri paramUri)
  {
    return (String)this.w.get(paramUri);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    b localb = this.P;
    Object localObject = this.D;
    int i;
    if (localb.f != null)
    {
      if (paramMotionEvent.getAction() == 2)
      {
        localb.a.setVisibility(0);
        localb.b.getLocationOnScreen(localb.j);
        localb.b.setPadding((int)paramMotionEvent.getX() - localb.j[0] - (int)localb.i, (int)paramMotionEvent.getY() - localb.j[1] - (int)localb.h, 0, 0);
        localb.e.setPadding(0, 0, 0, localb.a.getHeight() - ((View)localObject).getHeight());
        localb.d.getLocationOnScreen(localb.j);
        i = localb.j[1] + localb.d.getHeight();
        int j = localb.b.getHeight() - i;
        label313:
        float f;
        if (j > 0)
        {
          i = (int)Math.min(100.0F, (j - (paramMotionEvent.getY() - i)) * 100.0F / j);
          j = i;
          if (i < 0) {
            j = 0;
          }
          if (j > 70)
          {
            localb.e.setBackgroundColor(j * 2 / 3 * 255 / 100 << 24);
            if (!localb.k)
            {
              i = j * 255 / 100;
              localb.d.setTextColor(i << 24 | 0xFFFFFF);
              localb.l.setAlpha(i);
            }
            localb.e.clearAnimation();
            localb.n.removeCallbacks(localb.o);
          }
          if (j != 100) {
            break label484;
          }
          i = 1;
          if ((i == 0) || (localb.k)) {
            break label489;
          }
          localb.k = true;
          localb.d.setTextColor(-65536);
          localb.d.setCompoundDrawablesWithIntrinsicBounds(localb.m, null, null, null);
          f = 0.5F * localb.b.getWidth() / localb.d.getWidth();
          localObject = new ScaleAnimation(1.0F, f, 1.0F, f, 1, 0.5F, 1, 0.5F);
          ((Animation)localObject).setInterpolator(new BounceInterpolator());
          ((Animation)localObject).setDuration(800L);
          ((Animation)localObject).setFillAfter(true);
          localb.d.clearAnimation();
          localb.d.startAnimation((Animation)localObject);
          localb.c.invalidate();
        }
        for (;;)
        {
          localb.f.invalidate();
          i = 1;
          if ((i == 0) && (!super.dispatchTouchEvent(paramMotionEvent))) {
            break label761;
          }
          return true;
          i = 0;
          break;
          label484:
          i = 0;
          break label313;
          label489:
          if ((i == 0) && (localb.k))
          {
            localb.k = false;
            localb.d.setTextColor(-1);
            localb.d.setCompoundDrawablesWithIntrinsicBounds(localb.l, null, null, null);
            f = 0.5F * localb.b.getWidth() / localb.d.getWidth();
            localObject = new ScaleAnimation(f, 1.0F, f, 1.0F, 1, 0.5F, 1, 0.5F);
            ((Animation)localObject).setInterpolator(new LinearInterpolator());
            ((Animation)localObject).setDuration(500L);
            ((Animation)localObject).setFillAfter(true);
            localb.d.clearAnimation();
            localb.d.startAnimation((Animation)localObject);
            localb.c.invalidate();
          }
        }
      }
      if ((paramMotionEvent.getAction() != 1) || (!localb.k)) {
        break label750;
      }
      localb.a(localb.g);
    }
    for (;;)
    {
      localb.k = false;
      localb.g = null;
      localb.f = null;
      localb.a.setVisibility(8);
      localb.l.setAlpha(255);
      localb.d.clearAnimation();
      localb.d.setTextColor(16777215);
      localb.d.setCompoundDrawablesWithIntrinsicBounds(localb.l, null, null, null);
      localb.n.removeCallbacks(localb.o);
      i = 0;
      break;
      label750:
      localb.f.invalidate();
    }
    label761:
    return false;
  }
  
  public final Uri e(Uri paramUri)
  {
    return (Uri)this.y.get(paramUri);
  }
  
  public final Rect f(Uri paramUri)
  {
    return (Rect)this.z.get(paramUri);
  }
  
  public final Integer g(Uri paramUri)
  {
    return (Integer)this.x.get(paramUri);
  }
  
  public final Point h(Uri paramUri)
  {
    return (Point)this.B.get(paramUri);
  }
  
  public final boolean i(Uri paramUri)
  {
    return this.A.containsKey(paramUri);
  }
  
  final Uri l()
  {
    if (this.I < 0) {
      return null;
    }
    return (Uri)this.r.get(this.I);
  }
  
  final void m()
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((getIntent().getBooleanExtra("send", true)) && (this.H.isEmpty()))
    {
      localObject1 = new Intent(this, ContactPicker.class);
      ((Intent)localObject1).putExtra("send", true);
      ((Intent)localObject1).putExtra("skip_preview", true);
      localObject2 = new HashSet();
      localObject3 = this.s.values().iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((HashSet)localObject2).add(Integer.valueOf(((Byte)((Iterator)localObject3).next()).byteValue()));
      }
      ((Intent)localObject1).putIntegerArrayListExtra("message_types", new ArrayList((Collection)localObject2));
      startActivityForResult((Intent)localObject1, 1);
      return;
    }
    long l2 = SystemClock.elapsedRealtime();
    long l3 = getIntent().getLongExtra("picker_open_time", 0L);
    t();
    long l1 = getIntent().getLongExtra("quoted_message_row_id", 0L);
    label191:
    HashMap localHashMap2;
    ArrayList localArrayList;
    boolean bool;
    HashMap localHashMap1;
    label240:
    Uri localUri;
    byte b;
    if (l1 != 0L)
    {
      localObject1 = this.aa.a(l1);
      localHashMap2 = new HashMap();
      localArrayList = new ArrayList();
      bool = getIntent().getBooleanExtra("send", true);
      localHashMap1 = new HashMap();
      Iterator localIterator = this.r.iterator();
      if (!localIterator.hasNext()) {
        break label701;
      }
      localUri = (Uri)localIterator.next();
      b = j(localUri);
      if (!this.A.containsKey(localUri)) {
        break label931;
      }
      b = 13;
    }
    label415:
    label638:
    label701:
    label931:
    for (;;)
    {
      localHashMap1.put(localUri, Byte.valueOf(b));
      localObject3 = (com.whatsapp.fieldstats.events.at)localHashMap2.get(Byte.valueOf(b));
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject3 = new com.whatsapp.fieldstats.events.at();
        ((com.whatsapp.fieldstats.events.at)localObject3).b = Long.valueOf(0L);
        ((com.whatsapp.fieldstats.events.at)localObject3).c = Long.valueOf(0L);
        ((com.whatsapp.fieldstats.events.at)localObject3).d = Long.valueOf(0L);
        ((com.whatsapp.fieldstats.events.at)localObject3).e = Long.valueOf(0L);
        ((com.whatsapp.fieldstats.events.at)localObject3).f = Long.valueOf(0L);
        ((com.whatsapp.fieldstats.events.at)localObject3).g = Long.valueOf(0L);
        ((com.whatsapp.fieldstats.events.at)localObject3).h = Long.valueOf(0L);
        ((com.whatsapp.fieldstats.events.at)localObject3).i = Long.valueOf(0L);
        if (!this.H.contains("status@broadcast")) {
          break label638;
        }
        l1 = 1L;
        ((com.whatsapp.fieldstats.events.at)localObject3).n = Long.valueOf(l1);
        ((com.whatsapp.fieldstats.events.at)localObject3).m = Long.valueOf(this.H.size() - ((com.whatsapp.fieldstats.events.at)localObject3).n.longValue());
        switch (b)
        {
        }
      }
      for (;;)
      {
        ((com.whatsapp.fieldstats.events.at)localObject3).k = Integer.valueOf(getIntent().getIntExtra("origin", 1));
        localHashMap2.put(Byte.valueOf(b), localObject3);
        localObject2 = localObject3;
        if (l3 > 0L)
        {
          localObject2 = localObject3;
          if (l3 < l2)
          {
            ((com.whatsapp.fieldstats.events.at)localObject3).l = Double.valueOf(l2 - l3);
            localObject2 = localObject3;
          }
        }
        ((com.whatsapp.fieldstats.events.at)localObject2).b = Long.valueOf(((com.whatsapp.fieldstats.events.at)localObject2).b.longValue() + 1L);
        switch (b)
        {
        default: 
          break;
        case 1: 
          localArrayList.add(a((com.whatsapp.fieldstats.events.at)localObject2, localUri, (j)localObject1, bool));
          break;
          localObject1 = null;
          break label191;
          l1 = 0L;
          break label415;
          ((com.whatsapp.fieldstats.events.at)localObject3).a = Integer.valueOf(2);
          continue;
          ((com.whatsapp.fieldstats.events.at)localObject3).a = Integer.valueOf(3);
          continue;
          ((com.whatsapp.fieldstats.events.at)localObject3).a = Integer.valueOf(11);
        }
      }
      localArrayList.add(b((com.whatsapp.fieldstats.events.at)localObject2, localUri, (j)localObject1, bool));
      break label240;
      localObject1 = this.K.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.whatsapp.fieldstats.events.at)localHashMap2.get(Byte.valueOf(j((Uri)((Iterator)localObject1).next())));
        if (localObject2 != null) {
          ((com.whatsapp.fieldstats.events.at)localObject2).d = Long.valueOf(((com.whatsapp.fieldstats.events.at)localObject2).d.longValue() + 1L);
        }
      }
      localObject1 = localHashMap2.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        com.whatsapp.fieldstats.l.a(this, (com.whatsapp.fieldstats.events.at)((Iterator)localObject1).next());
      }
      if (!getIntent().getBooleanExtra("send", true))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putParcelableArrayListExtra("android.intent.extra.STREAM", localArrayList);
        ((Intent)localObject1).putExtra("types", localHashMap1);
        setResult(-1, (Intent)localObject1);
      }
      for (;;)
      {
        u();
        finish();
        return;
        if ((this.H.size() > 1) || ((this.H.size() == 1) && (j.c((String)this.H.get(0))))) {
          pv.a(getBaseContext(), this.H);
        }
        setResult(-1);
      }
    }
  }
  
  public final ao n()
  {
    return this.M;
  }
  
  public final View o()
  {
    return this.F;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    this.H.clear();
    this.H.addAll(paramIntent.getStringArrayListExtra("jids"));
    if ((this.H.size() > 1) || (this.H.contains("status@broadcast"))) {
      pv.a(this, this.H);
    }
    for (;;)
    {
      m();
      return;
      if (this.H.size() == 1) {
        startActivity(Conversation.a((String)this.H.get(0)));
      }
    }
  }
  
  public void onBackPressed()
  {
    an localan = s();
    if ((localan != null) && (localan.c.h())) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("mediapreview/create");
    super.onCreate(paramBundle);
    bu.a(anf.a(this.ab));
    if (paramBundle == null)
    {
      this.r = getIntent().getParcelableArrayListExtra("android.intent.extra.STREAM");
      paramBundle = getIntent().getExtras();
    }
    Object localObject;
    for (;;)
    {
      this.u = new HashMap();
      this.v = new HashMap();
      localObject = getIntent().getStringExtra("android.intent.extra.TEXT");
      Iterator localIterator = this.r.iterator();
      while (localIterator.hasNext())
      {
        Uri localUri = (Uri)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.u.put(localUri, localObject);
        }
        String str = localUri.getQueryParameter("caption");
        if (!TextUtils.isEmpty(str)) {
          this.u.put(localUri, str);
        }
        this.J.put(localUri, Long.valueOf(this.J.size()));
      }
      this.r = paramBundle.getParcelableArrayList("uris");
    }
    if (paramBundle != null)
    {
      this.s = ((HashMap)paramBundle.getSerializable("types"));
      if (this.s == null) {
        this.s = new HashMap();
      }
      localObject = (HashMap)paramBundle.getSerializable("files");
      if (localObject != null) {
        this.t = ((HashMap)localObject);
      }
      this.x = ((HashMap)paramBundle.getSerializable("rotations"));
      if (this.x == null) {
        this.x = new HashMap();
      }
      this.y = ((HashMap)paramBundle.getSerializable("cropuris"));
      if (this.y == null) {
        this.y = new HashMap();
      }
      this.z = ((HashMap)paramBundle.getSerializable("croprects"));
      if (this.z == null) {
        this.z = new HashMap();
      }
      localObject = (HashMap)paramBundle.getSerializable("captions");
      if (localObject != null) {
        this.u = ((HashMap)localObject);
      }
      localObject = (HashMap)paramBundle.getSerializable("mentions");
      if (localObject != null) {
        this.v = ((HashMap)localObject);
      }
      localObject = (HashMap)paramBundle.getSerializable("doodles");
      if (localObject != null) {
        this.w = ((HashMap)localObject);
      }
      localObject = (HashMap)paramBundle.getSerializable("trims");
      if (localObject != null) {
        this.B = ((HashMap)localObject);
      }
      paramBundle = (HashMap)paramBundle.getSerializable("send_as_gif");
      if (paramBundle != null) {
        this.A = paramBundle;
      }
    }
    paramBundle = getIntent().getStringExtra("jid");
    if (!TextUtils.isEmpty(paramBundle)) {
      this.H.add(paramBundle);
    }
    while (this.r == null)
    {
      finish();
      return;
      this.H = getIntent().getStringArrayListExtra("jids");
      if (this.H == null) {
        this.H = new ArrayList();
      }
    }
    setContentView(2130903288);
    this.M = new ao(this.S, getContentResolver(), this.O);
    this.P = new b(this)
    {
      final void a(Uri paramAnonymousUri)
      {
        MediaPreviewActivity.a(MediaPreviewActivity.this, paramAnonymousUri);
      }
    };
    if (this.H.size() == 1)
    {
      if (!j.c((String)this.H.get(0))) {
        break label1135;
      }
      paramBundle = this.ar.c();
      if (paramBundle != null)
      {
        this.Q = this.Y.b();
        this.Q.a(paramBundle, (ImageView)findViewById(2131755440));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().getDecorView().setSystemUiVisibility(1792);
      getWindow().addFlags(201326592);
    }
    this.D = ((PhotoViewPager)findViewById(2131755748));
    this.D.setPageMargin((int)(12.0F * getResources().getDisplayMetrics().density));
    this.D.a(false, null);
    this.D.setOnInterceptTouchListener(new af(this));
    this.D.setOnPageChangeListener(new ViewPager.f()
    {
      public final void a(int paramAnonymousInt) {}
      
      public final void a(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public final void b(int paramAnonymousInt)
      {
        MediaPreviewActivity.a(MediaPreviewActivity.this, paramAnonymousInt);
        MediaPreviewActivity.a(MediaPreviewActivity.this);
      }
    });
    this.F = findViewById(2131755438);
    this.n = ((TextEmojiLabel)findViewById(2131755436));
    this.p = findViewById(2131755435);
    this.p.setOnClickListener(new com.whatsapp.util.at()
    {
      public final void a(View paramAnonymousView)
      {
        MediaPreviewActivity.b(MediaPreviewActivity.this);
      }
    });
    this.o = ((ImageView)findViewById(2131755437));
    if ((getIntent().getBooleanExtra("send", true)) && (this.H.isEmpty()))
    {
      this.o.setImageResource(2130840145);
      this.o.setContentDescription(getString(2131296687));
      label854:
      this.o.setOnClickListener(new com.whatsapp.util.at()
      {
        public final void a(View paramAnonymousView)
        {
          MediaPreviewActivity.c(MediaPreviewActivity.this);
        }
      });
      paramBundle = findViewById(2131755545);
      paramBundle.setOnClickListener(ag.a(this));
      localObject = findViewById(2131755923);
      if (this.r.size() <= 1) {
        break label1195;
      }
    }
    label1135:
    label1195:
    for (final int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      ((View)localObject).setOnClickListener(ah.a(this));
      localObject = (ImageView)findViewById(2131755439);
      ((ImageView)localObject).setImageDrawable(new az(android.support.v4.content.b.a(this, 2130840122)));
      ((ImageView)localObject).setOnClickListener(ai.a(this));
      if (getIntent().getIntExtra("max_items", Integer.MAX_VALUE) == 0)
      {
        paramBundle.setVisibility(8);
        findViewById(2131755929).setVisibility(8);
      }
      this.q = ((RecyclerView)findViewById(2131755928));
      this.q.setHasFixedSize(true);
      i = getResources().getDimensionPixelSize(2131362003);
      this.q.a(new RecyclerView.f()
      {
        public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView)
        {
          if (MediaPreviewActivity.d(MediaPreviewActivity.this).d())
          {
            paramAnonymousRect.set(0, 0, i, 0);
            return;
          }
          paramAnonymousRect.set(i, 0, 0, 0);
        }
      });
      paramBundle = new LinearLayoutManager(this);
      paramBundle.b(0);
      this.q.setLayoutManager(paramBundle);
      this.G = new d((byte)0);
      if (this.r.size() == 1) {
        this.q.setVisibility(8);
      }
      android.support.v4.view.ab.a(this.D, new aj(this));
      this.N = new b((byte)0);
      bu.a(this.N, new Void[0]);
      return;
      paramBundle = this.Z.d((String)this.H.get(0));
      break;
      this.o.setImageDrawable(new az(android.support.v4.content.b.a(this, 2130840323)));
      this.o.setContentDescription(getString(2131297656));
      break label854;
    }
  }
  
  protected void onDestroy()
  {
    Log.i("mediapreview/destroy");
    if (this.D != null)
    {
      int i = 0;
      while (i < this.D.getChildCount())
      {
        View localView1 = this.D.getChildAt(i);
        if ((localView1 instanceof FrameLayout))
        {
          int j = 0;
          while (j < ((FrameLayout)localView1).getChildCount())
          {
            View localView2 = ((FrameLayout)localView1).getChildAt(j);
            if ((localView2 instanceof PhotoView)) {
              ((PhotoView)localView2).c();
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    super.onDestroy();
    if (this.M != null)
    {
      this.M.a();
      this.M = null;
    }
    if (this.Q != null)
    {
      this.Q.a();
      this.Q = null;
    }
    if (this.N != null)
    {
      this.N.cancel(true);
      this.N = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((com.whatsapp.av.j()) && (paramInt == 84))
    {
      bm.a(this);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelableArrayList("uris", this.r);
    paramBundle.putSerializable("types", this.s);
    paramBundle.putSerializable("files", this.t);
    paramBundle.putSerializable("captions", this.u);
    paramBundle.putSerializable("mentions", this.v);
    paramBundle.putSerializable("doodles", this.w);
    paramBundle.putSerializable("rotations", this.x);
    paramBundle.putSerializable("cropuris", this.y);
    paramBundle.putSerializable("croprects", this.z);
    paramBundle.putSerializable("trims", this.B);
    paramBundle.putSerializable("send_as_gif", this.A);
  }
  
  public final List<String> p()
  {
    return this.H;
  }
  
  public final void q()
  {
    if (this.o.getVisibility() != 4)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(300L);
      this.o.setVisibility(4);
      this.o.startAnimation(localAlphaAnimation);
      this.p.setVisibility(4);
      this.p.startAnimation(localAlphaAnimation);
      if (this.r.size() > 1)
      {
        this.q.setVisibility(4);
        this.q.startAnimation(localAlphaAnimation);
      }
    }
  }
  
  public final void r()
  {
    if (this.o.getVisibility() != 0)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(300L);
      this.o.setVisibility(0);
      this.o.startAnimation(localAlphaAnimation);
      this.p.setVisibility(0);
      this.p.startAnimation(localAlphaAnimation);
      if (this.r.size() > 1)
      {
        this.q.setVisibility(0);
        this.q.startAnimation(localAlphaAnimation);
      }
    }
  }
  
  final an s()
  {
    Uri localUri = l();
    Iterator localIterator = S().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (((localFragment instanceof an)) && (localUri.equals(((an)localFragment).b))) {
        return (an)localFragment;
      }
    }
    return null;
  }
  
  final void t()
  {
    Iterator localIterator = S().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Fragment)localIterator.next();
      if ((localObject1 instanceof an))
      {
        Object localObject2 = (an)localObject1;
        localObject1 = ((an)localObject2).S();
        localObject2 = ((an)localObject2).b;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          this.w.remove(localObject2);
        } else {
          this.w.put(localObject2, localObject1);
        }
      }
    }
  }
  
  final class a
    extends aof
  {
    a(r paramr)
    {
      super();
    }
    
    public final int a(Object paramObject)
    {
      paramObject = ((an)paramObject).b;
      int j = MediaPreviewActivity.m(MediaPreviewActivity.this).indexOf(paramObject);
      int i = j;
      if (j < 0) {
        i = -2;
      }
      return i;
    }
    
    public final Fragment a(int paramInt)
    {
      Uri localUri = (Uri)MediaPreviewActivity.m(MediaPreviewActivity.this).get(paramInt);
      switch (MediaPreviewActivity.b(MediaPreviewActivity.this, localUri))
      {
      default: 
        return null;
      case 1: 
        return u.a(localUri);
      case 3: 
        return av.a(localUri);
      }
      return p.a(localUri);
    }
    
    public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      if ((paramObject instanceof Fragment))
      {
        View localView = ((Fragment)paramObject).x();
        if (localView != null) {
          ((PhotoView)localView.findViewById(2131755422)).c();
        }
      }
      super.a(paramViewGroup, paramInt, paramObject);
    }
    
    public final int b()
    {
      return MediaPreviewActivity.m(MediaPreviewActivity.this).size();
    }
    
    public final long b(int paramInt)
    {
      return ((Long)MediaPreviewActivity.o(MediaPreviewActivity.this).get(MediaPreviewActivity.m(MediaPreviewActivity.this).get(paramInt))).longValue();
    }
    
    public final void b(ViewGroup paramViewGroup)
    {
      super.b(paramViewGroup);
      if (MediaPreviewActivity.i(MediaPreviewActivity.this) < 0) {
        MediaPreviewActivity.a(MediaPreviewActivity.this, 0);
      }
      paramViewGroup = MediaPreviewActivity.this.S().iterator();
      while (paramViewGroup.hasNext())
      {
        Fragment localFragment = (Fragment)paramViewGroup.next();
        if ((localFragment instanceof an)) {
          ((an)localFragment).a(MediaPreviewActivity.n(MediaPreviewActivity.this));
        }
      }
    }
  }
  
  final class b
    extends AsyncTask<Void, Void, Void>
  {
    private b() {}
    
    private Void a()
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = MediaPreviewActivity.m(MediaPreviewActivity.this).iterator();
      Uri localUri;
      if (localIterator.hasNext())
      {
        localUri = (Uri)localIterator.next();
        if (!isCancelled())
        {
          File localFile3 = (File)MediaPreviewActivity.w(MediaPreviewActivity.this).get(localUri);
          File localFile1 = localFile3;
          if (localFile3 == null) {}
          for (localFile1 = localFile3;; localFile2 = localFile3)
          {
            try
            {
              localFile3 = MediaFileUtils.a(MediaPreviewActivity.x(MediaPreviewActivity.this), MediaPreviewActivity.y(MediaPreviewActivity.this), MediaPreviewActivity.z(MediaPreviewActivity.this), localUri);
              if (localFile3 == null) {
                break label288;
              }
              localFile1 = localFile3;
              MediaPreviewActivity.w(MediaPreviewActivity.this).put(localUri, localFile3);
              localFile1 = localFile3;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                int i;
                label288:
                File localFile2;
                localHashSet.add(localUri);
                Log.d("mediapreview/ cannot get file for " + localUri, localIOException);
                continue;
                if (!aqe.a(localFile2))
                {
                  localHashSet.add(localUri);
                  Log.e("mediapreview/ cannot frim or transcode " + localUri);
                }
              }
            }
            if (!MediaPreviewActivity.w(MediaPreviewActivity.this).containsKey(localUri)) {
              break;
            }
            i = MediaPreviewActivity.b(MediaPreviewActivity.this, localUri);
            if ((i != 1) && (i != 3) && (i != 13))
            {
              localHashSet.add(localUri);
              Log.e("mediapreview/ bad type " + localUri);
            }
            if ((i != 3) && (i != 13)) {
              break;
            }
            if (!MediaFileUtils.a((byte)3, localFile1)) {
              break label358;
            }
            if (!MediaFileUtils.b((byte)3, localFile1))
            {
              localHashSet.add(localUri);
              Log.e("mediapreview/ cannot transcode " + localUri);
            }
            try
            {
              MediaPreviewActivity.A(MediaPreviewActivity.this).put(localUri, new MediaFileUtils.f(localFile1));
            }
            catch (MediaFileUtils.c localc)
            {
              Log.e("mediapreview/bad video");
              localHashSet.add(localUri);
            }
            break;
            localFile2 = localFile3;
            localHashSet.add(localUri);
            localFile2 = localFile3;
            Log.e("mediapreview/ cannot get file for " + localUri);
          }
        }
      }
      label358:
      MediaPreviewActivity.m(MediaPreviewActivity.this).removeAll(localHashSet);
      return null;
    }
    
    protected final void onPreExecute()
    {
      MediaPreviewActivity.u(MediaPreviewActivity.this).setVisibility(4);
      MediaPreviewActivity.v(MediaPreviewActivity.this).setVisibility(4);
      MediaPreviewActivity.this.findViewById(2131755224).setVisibility(0);
      Log.d("mediapreview/load-files " + MediaPreviewActivity.m(MediaPreviewActivity.this).size());
    }
  }
  
  class c
    extends vr.a
  {
    private Uri d;
    private int e;
    private final Matrix f = new Matrix();
    private final Paint g = new Paint();
    private Drawable h;
    
    public c(Context paramContext)
    {
      super();
      this.g.setColor(-16725026);
      this.g.setStrokeWidth(paramContext.getResources().getDimensionPixelSize(2131362002));
      this.g.setStyle(Paint.Style.STROKE);
      this.g.setAntiAlias(true);
      setOnTouchListener(MediaPreviewActivity.j(MediaPreviewActivity.this));
    }
    
    public Uri getUri()
    {
      return this.d;
    }
    
    public void onDraw(Canvas paramCanvas)
    {
      if ((MediaPreviewActivity.e(MediaPreviewActivity.this).f == this) || (MediaPreviewActivity.k(MediaPreviewActivity.this).contains(this.d))) {}
      do
      {
        return;
        paramCanvas.save();
        int i;
        if (MediaPreviewActivity.l(MediaPreviewActivity.this).containsKey(this.d))
        {
          i = ((Integer)MediaPreviewActivity.l(MediaPreviewActivity.this).get(this.d)).intValue();
          this.f.setRotate(i, getWidth() / 2, getHeight() / 2);
          paramCanvas.concat(this.f);
        }
        super.onDraw(paramCanvas);
        paramCanvas.restore();
        if (this.h != null)
        {
          i = this.h.getIntrinsicHeight() / 4;
          this.h.setBounds(i, getHeight() - this.h.getIntrinsicHeight() - i, this.h.getIntrinsicWidth() + i, getHeight() - i);
          this.h.draw(paramCanvas);
        }
      } while ((!isPressed()) && (!isSelected()));
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.g);
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      paramInt1 = getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
      setMeasuredDimension(paramInt1, paramInt1);
    }
  }
  
  final class d
    extends RecyclerView.a<a>
  {
    final Drawable c = new ColorDrawable(this.d);
    final int d = android.support.v4.content.b.c(MediaPreviewActivity.this, 2131623987);
    
    private d()
    {
      a(true);
    }
    
    public final int a()
    {
      if (MediaPreviewActivity.m(MediaPreviewActivity.this) == null) {
        return 0;
      }
      return MediaPreviewActivity.m(MediaPreviewActivity.this).size();
    }
    
    public final long b(int paramInt)
    {
      if (MediaPreviewActivity.m(MediaPreviewActivity.this) == null) {
        return 0L;
      }
      return ((Uri)MediaPreviewActivity.m(MediaPreviewActivity.this).get(paramInt)).hashCode();
    }
    
    final class a
      extends RecyclerView.p
    {
      final MediaPreviewActivity.c n;
      
      public a(MediaPreviewActivity.c paramc)
      {
        super();
        this.n = paramc;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/MediaPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */