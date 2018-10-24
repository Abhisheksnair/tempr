package com.whatsapp.camera;

import a.a.a.a.a.a.d;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.HandlerThread;
import android.support.v4.app.Fragment;
import android.support.v4.app.n;
import android.support.v4.app.r;
import android.support.v4.app.w;
import android.support.v4.f.f;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.whatsapp.ContactPicker;
import com.whatsapp.Conversation;
import com.whatsapp.GifHelper;
import com.whatsapp.PhotoView;
import com.whatsapp.ahx;
import com.whatsapp.aic;
import com.whatsapp.and;
import com.whatsapp.aqe;
import com.whatsapp.aqe.c;
import com.whatsapp.atv;
import com.whatsapp.crop.CropImage;
import com.whatsapp.data.co;
import com.whatsapp.data.cs;
import com.whatsapp.di;
import com.whatsapp.di.e;
import com.whatsapp.doodle.ColorPickerView;
import com.whatsapp.doodle.DoodleView;
import com.whatsapp.doodle.a.a;
import com.whatsapp.doodle.o;
import com.whatsapp.doodle.o.i;
import com.whatsapp.ng;
import com.whatsapp.oz;
import com.whatsapp.protocol.j;
import com.whatsapp.pv;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.MediaFileUtils.e;
import com.whatsapp.util.az;
import com.whatsapp.util.bu;
import com.whatsapp.va;
import com.whatsapp.videoplayback.VideoSurfaceView;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class ai
  extends Fragment
{
  TextView a;
  private boolean aa;
  private View ab;
  private Rect ac;
  private int ad;
  private PhotoView ae;
  private ImageButton af;
  private boolean ag;
  private final com.whatsapp.c.a ah = com.whatsapp.c.a.a();
  private final pv ai = pv.a();
  private final va aj = va.a();
  private final ahx ak = ahx.a();
  private final oz al = oz.a();
  private final aic am = aic.a();
  private final com.whatsapp.emoji.h an = com.whatsapp.emoji.h.a();
  private final di ao = di.a();
  private final com.whatsapp.data.e ap = com.whatsapp.data.e.a();
  private final and aq = and.a();
  private final com.whatsapp.data.l ar = com.whatsapp.data.l.a();
  private final co as = co.a();
  private final atv at = atv.a();
  private di.e au;
  com.whatsapp.doodle.a b;
  String c = "";
  ArrayList<String> d;
  private final List<String> e = new ArrayList();
  private Uri f;
  private File g;
  private int h;
  private int i;
  
  private int T()
  {
    int j = 0;
    if (this.f.getQueryParameter("rotation") != null) {
      j = Integer.parseInt(this.f.getQueryParameter("rotation"));
    }
    return (j + this.ad) % 360;
  }
  
  private void U()
  {
    if (x() == null) {
      return;
    }
    d(2131755435).setVisibility(0);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject).setDuration(220L);
    ((Animation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    ((Animation)localObject).setFillBefore(true);
    d(2131755435).startAnimation((Animation)localObject);
    d(2131755438).setVisibility(0);
    localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(125L);
    ((Animation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    ((Animation)localObject).setFillBefore(true);
    d(2131755445).startAnimation((Animation)localObject);
    d(2131755443).startAnimation((Animation)localObject);
    d(2131755444).startAnimation((Animation)localObject);
    d(2131755442).startAnimation((Animation)localObject);
    if (this.ai.d()) {}
    for (float f1 = -1.0F;; f1 = 1.0F)
    {
      localObject = new TranslateAnimation(1, f1, 1, 0.0F, 1, 0.0F, 1, 0.0F);
      ((Animation)localObject).setDuration(125L);
      ((Animation)localObject).setInterpolator(new DecelerateInterpolator());
      ((Animation)localObject).setFillBefore(true);
      d(2131755439).startAnimation((Animation)localObject);
      d(2131755440).startAnimation((Animation)localObject);
      if (this.f == null) {
        break;
      }
      bu.a(new AsyncTask()
      {
        private Bitmap a()
        {
          try
          {
            Bitmap localBitmap = MediaFileUtils.a(ai.f(ai.this), ai.g(ai.this), aic.x, aic.x);
            return localBitmap;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            Log.d("capturepreview/setuppreview", localOutOfMemoryError);
            return null;
          }
          catch (IOException localIOException)
          {
            for (;;) {}
          }
          catch (MediaFileUtils.e locale)
          {
            for (;;) {}
          }
        }
      }, new Void[0]);
      return;
    }
    this.ab.setBackgroundColor(-16777216);
  }
  
  private void V()
  {
    long l2 = 1L;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.b != null)
    {
      localObject1 = localObject2;
      if (this.b.a.b()) {
        localObject1 = this.b.a.getDoodle();
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new com.whatsapp.doodle.a.b();
    }
    int k;
    int j;
    if (this.ac == null)
    {
      k = 1;
      localObject1 = new com.whatsapp.fieldstats.events.at();
      if (!i().getBoolean("is_video")) {
        break label351;
      }
      if (!this.aa) {
        break label346;
      }
      j = 11;
      label105:
      ((com.whatsapp.fieldstats.events.at)localObject1).a = Integer.valueOf(j);
      ((com.whatsapp.fieldstats.events.at)localObject1).k = Integer.valueOf(i().getInt("origin", 12));
      if (this.e != null)
      {
        if (!this.e.contains("status@broadcast")) {
          break label356;
        }
        l1 = 1L;
        label158:
        ((com.whatsapp.fieldstats.events.at)localObject1).n = Long.valueOf(l1);
        ((com.whatsapp.fieldstats.events.at)localObject1).m = Long.valueOf(this.e.size() - ((com.whatsapp.fieldstats.events.at)localObject1).n.longValue());
      }
      ((com.whatsapp.fieldstats.events.at)localObject1).b = Long.valueOf(1L);
      if ((k == 0) || (!((com.whatsapp.doodle.a.b)localObject2).a())) {
        break label361;
      }
      l1 = 1L;
      label217:
      ((com.whatsapp.fieldstats.events.at)localObject1).c = Long.valueOf(l1);
      if ((k == 0) || (!((com.whatsapp.doodle.a.b)localObject2).a())) {
        break label366;
      }
      l1 = 0L;
      label240:
      ((com.whatsapp.fieldstats.events.at)localObject1).e = Long.valueOf(l1);
      ((com.whatsapp.fieldstats.events.at)localObject1).d = Long.valueOf(0L);
      if (k == 0) {
        break label371;
      }
      l1 = 0L;
      label264:
      ((com.whatsapp.fieldstats.events.at)localObject1).f = Long.valueOf(l1);
      if (!((com.whatsapp.doodle.a.b)localObject2).c()) {
        break label376;
      }
      l1 = 1L;
      label283:
      ((com.whatsapp.fieldstats.events.at)localObject1).g = Long.valueOf(l1);
      if (!((com.whatsapp.doodle.a.b)localObject2).d()) {
        break label381;
      }
      l1 = 1L;
      label302:
      ((com.whatsapp.fieldstats.events.at)localObject1).h = Long.valueOf(l1);
      if (!((com.whatsapp.doodle.a.b)localObject2).b()) {
        break label386;
      }
    }
    label346:
    label351:
    label356:
    label361:
    label366:
    label371:
    label376:
    label381:
    label386:
    for (long l1 = l2;; l1 = 0L)
    {
      ((com.whatsapp.fieldstats.events.at)localObject1).i = Long.valueOf(l1);
      com.whatsapp.fieldstats.l.a(k(), (com.whatsapp.fieldstats.e)localObject1);
      return;
      k = 0;
      break;
      j = 3;
      break label105;
      j = 2;
      break label105;
      l1 = 0L;
      break label158;
      l1 = 0L;
      break label217;
      l1 = 1L;
      break label240;
      l1 = 1L;
      break label264;
      l1 = 0L;
      break label283;
      l1 = 0L;
      break label302;
    }
  }
  
  private void W()
  {
    d(2131755423).setVisibility(0);
    final Object localObject1 = d(2131755428);
    int j;
    Object localObject2;
    if (this.aa)
    {
      j = 8;
      ((View)localObject1).setVisibility(j);
      localObject1 = (VideoSurfaceView)d(2131755424);
      ((VideoSurfaceView)localObject1).setOnErrorListener(am.a());
      if (this.aa) {
        ((VideoSurfaceView)localObject1).setOnPreparedListener(an.a());
      }
      ((VideoSurfaceView)localObject1).setVisibility(0);
      ((VideoSurfaceView)localObject1).setVideoPath(this.g.getAbsolutePath());
      if ((this.h == 0) || (this.i == 0)) {
        break label194;
      }
      ((VideoSurfaceView)localObject1).a(this.h, this.i);
      localObject2 = new RectF(0.0F, 0.0F, this.h, this.i);
      this.b.a((RectF)localObject2);
      this.b.b((RectF)localObject2);
    }
    for (;;)
    {
      ((VideoSurfaceView)localObject1).requestFocus();
      if (!this.aa) {
        break label245;
      }
      localObject2 = R();
      if (localObject2 != null) {
        ((h)localObject2).l();
      }
      ((VideoSurfaceView)localObject1).start();
      ((VideoSurfaceView)localObject1).postDelayed(new Runnable()
      {
        int a;
        
        public final void run()
        {
          if (localObject1.getBackground() != null)
          {
            if (localObject1.getCurrentPosition() > 50) {
              localObject1.setBackgroundDrawable(null);
            }
            this.a += 1;
            if (this.a < 100) {
              localObject1.postDelayed(this, 50L);
            }
          }
        }
      }, 0L);
      return;
      j = 0;
      break;
      label194:
      d(2131755443).setVisibility(8);
      d(2131755444).setVisibility(8);
      d(2131755445).setVisibility(8);
      d(2131755426).setVisibility(8);
    }
    label245:
    ((VideoSurfaceView)localObject1).seekTo(1);
  }
  
  public static ai a(String paramString, long paramLong, Uri paramUri, boolean paramBoolean1, Rect paramRect, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    ai localai = new ai();
    Bundle localBundle = new Bundle();
    localBundle.putString("jid", paramString);
    localBundle.putLong("quoted_message_row_id", paramLong);
    localBundle.putParcelable("uri", paramUri);
    localBundle.putBoolean("is_video", paramBoolean1);
    localBundle.putParcelable("rect", paramRect);
    localBundle.putBoolean("is_new_content", paramBoolean2);
    localBundle.putBoolean("chat_opened_from_url", paramBoolean3);
    localBundle.putInt("origin", paramInt);
    localai.f(localBundle);
    return localai;
  }
  
  private View d(int paramInt)
  {
    return ((View)a.d.a(x())).findViewById(paramInt);
  }
  
  public final void A()
  {
    super.A();
    Log.i("capturepreview/destroy");
    if (this.b != null)
    {
      o localo = this.b.d;
      localo.b.quit();
      localo.c.removeMessages(0);
      localo.c.removeMessages(1);
      localo.d.clear();
      this.b = null;
    }
    if (this.ab != null) {
      this.ab = null;
    }
    if (this.au != null)
    {
      this.au.a();
      this.au = null;
    }
  }
  
  final h R()
  {
    a locala = (a)l();
    if (locala == null) {
      return null;
    }
    return locala.m();
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = com.whatsapp.al.a(this.ai, paramLayoutInflater, 2130903102, paramViewGroup, false);
    this.ab = paramLayoutInflater.findViewById(2131755421);
    this.ae = ((PhotoView)paramLayoutInflater.findViewById(2131755422));
    this.af = ((ImageButton)paramLayoutInflater.findViewById(2131755437));
    paramViewGroup = (ImageView)paramLayoutInflater.findViewById(2131755439);
    paramViewGroup.setImageDrawable(new az(android.support.v4.content.b.a(k(), 2130840122)));
    paramViewGroup.setOnClickListener(new com.whatsapp.util.at()
    {
      public final void a(View paramAnonymousView)
      {
        ai.this.b();
      }
    });
    paramLayoutInflater.findViewById(2131755440).setOnClickListener(new com.whatsapp.util.at()
    {
      public final void a(View paramAnonymousView)
      {
        byte b = 1;
        paramAnonymousView = new Intent(ai.this.l(), ContactPicker.class);
        paramAnonymousView.putExtra("send", true);
        if (ai.this.i().getBoolean("is_video")) {
          if (!ai.a(ai.this)) {
            break label92;
          }
        }
        label92:
        for (b = 13;; b = 3)
        {
          paramAnonymousView.putIntegerArrayListExtra("message_types", new ArrayList(Collections.singleton(Integer.valueOf(Byte.valueOf(b).intValue()))));
          ai.this.startActivityForResult(paramAnonymousView, 3);
          return;
        }
      }
    });
    this.a = ((TextView)paramLayoutInflater.findViewById(2131755436));
    paramLayoutInflater.findViewById(2131755435).setOnClickListener(new com.whatsapp.util.at()
    {
      public final void a(View paramAnonymousView)
      {
        ai.b(ai.this);
      }
    });
    return paramLayoutInflater;
  }
  
  /* Error */
  final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 106	com/whatsapp/camera/ai:e	Ljava/util/List;
    //   4: invokeinterface 382 1 0
    //   9: iconst_1
    //   10: if_icmpne +53 -> 63
    //   13: aload_0
    //   14: getfield 106	com/whatsapp/camera/ai:e	Ljava/util/List;
    //   17: iconst_0
    //   18: invokeinterface 555 2 0
    //   23: checkcast 557	java/lang/String
    //   26: astore 4
    //   28: aload 4
    //   30: invokestatic 818	com/whatsapp/protocol/j:c	(Ljava/lang/String;)Z
    //   33: ifeq +36 -> 69
    //   36: aload_0
    //   37: getfield 194	com/whatsapp/camera/ai:as	Lcom/whatsapp/data/co;
    //   40: invokevirtual 819	com/whatsapp/data/co:b	()Z
    //   43: ifne +26 -> 69
    //   46: invokestatic 824	com/whatsapp/camera/aw:R	()Lcom/whatsapp/camera/aw;
    //   49: aload_0
    //   50: invokevirtual 827	com/whatsapp/camera/ai:n	()Landroid/support/v4/app/r;
    //   53: ldc_w 821
    //   56: invokevirtual 832	java/lang/Class:getName	()Ljava/lang/String;
    //   59: invokevirtual 835	com/whatsapp/camera/aw:a	(Landroid/support/v4/app/r;Ljava/lang/String;)V
    //   62: return
    //   63: aconst_null
    //   64: astore 4
    //   66: goto -38 -> 28
    //   69: aload_0
    //   70: getfield 106	com/whatsapp/camera/ai:e	Ljava/util/List;
    //   73: invokeinterface 838 1 0
    //   78: ifeq +109 -> 187
    //   81: new 632	android/content/Intent
    //   84: dup
    //   85: aload_0
    //   86: invokevirtual 551	com/whatsapp/camera/ai:l	()Landroid/support/v4/app/n;
    //   89: ldc_w 840
    //   92: invokespecial 637	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   95: astore 4
    //   97: aload 4
    //   99: ldc_w 842
    //   102: iconst_1
    //   103: invokevirtual 643	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   106: pop
    //   107: aload 4
    //   109: ldc_w 844
    //   112: iconst_1
    //   113: invokevirtual 643	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   116: pop
    //   117: aload_0
    //   118: invokevirtual 336	com/whatsapp/camera/ai:i	()Landroid/os/Bundle;
    //   121: ldc_w 338
    //   124: invokevirtual 344	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   127: ifeq +55 -> 182
    //   130: aload_0
    //   131: getfield 346	com/whatsapp/camera/ai:aa	Z
    //   134: ifeq +43 -> 177
    //   137: bipush 13
    //   139: istore_1
    //   140: aload 4
    //   142: ldc_w 846
    //   145: new 103	java/util/ArrayList
    //   148: dup
    //   149: iload_1
    //   150: invokestatic 851	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   153: invokevirtual 854	java/lang/Byte:intValue	()I
    //   156: invokestatic 350	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: invokestatic 860	java/util/Collections:singleton	(Ljava/lang/Object;)Ljava/util/Set;
    //   162: invokespecial 863	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   165: invokevirtual 867	android/content/Intent:putIntegerArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   168: pop
    //   169: aload_0
    //   170: aload 4
    //   172: iconst_2
    //   173: invokevirtual 700	com/whatsapp/camera/ai:startActivityForResult	(Landroid/content/Intent;I)V
    //   176: return
    //   177: iconst_3
    //   178: istore_1
    //   179: goto -39 -> 140
    //   182: iconst_1
    //   183: istore_1
    //   184: goto -44 -> 140
    //   187: aload_0
    //   188: getfield 617	com/whatsapp/camera/ai:af	Landroid/widget/ImageButton;
    //   191: iconst_0
    //   192: invokevirtual 870	android/widget/ImageButton:setEnabled	(Z)V
    //   195: aload_0
    //   196: invokevirtual 336	com/whatsapp/camera/ai:i	()Landroid/os/Bundle;
    //   199: ldc_w 338
    //   202: invokevirtual 344	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   205: ifeq +344 -> 549
    //   208: aload_0
    //   209: getfield 110	com/whatsapp/camera/ai:c	Ljava/lang/String;
    //   212: astore 6
    //   214: aconst_null
    //   215: astore 5
    //   217: aload 5
    //   219: astore 4
    //   221: aload_0
    //   222: getfield 312	com/whatsapp/camera/ai:b	Lcom/whatsapp/doodle/a;
    //   225: ifnull +32 -> 257
    //   228: aload 5
    //   230: astore 4
    //   232: aload_0
    //   233: getfield 312	com/whatsapp/camera/ai:b	Lcom/whatsapp/doodle/a;
    //   236: getfield 317	com/whatsapp/doodle/a:a	Lcom/whatsapp/doodle/DoodleView;
    //   239: invokevirtual 321	com/whatsapp/doodle/DoodleView:b	()Z
    //   242: ifeq +15 -> 257
    //   245: aload_0
    //   246: getfield 312	com/whatsapp/camera/ai:b	Lcom/whatsapp/doodle/a;
    //   249: getfield 317	com/whatsapp/doodle/a:a	Lcom/whatsapp/doodle/DoodleView;
    //   252: invokevirtual 325	com/whatsapp/doodle/DoodleView:getDoodle	()Lcom/whatsapp/doodle/a/b;
    //   255: astore 4
    //   257: aload_0
    //   258: invokevirtual 336	com/whatsapp/camera/ai:i	()Landroid/os/Bundle;
    //   261: ldc_w 511
    //   264: invokevirtual 874	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   267: lstore_2
    //   268: lload_2
    //   269: lconst_0
    //   270: lcmp
    //   271: ifeq +150 -> 421
    //   274: aload_0
    //   275: getfield 187	com/whatsapp/camera/ai:ar	Lcom/whatsapp/data/l;
    //   278: lload_2
    //   279: invokevirtual 877	com/whatsapp/data/l:a	(J)Lcom/whatsapp/protocol/j;
    //   282: astore 5
    //   284: aload_0
    //   285: getfield 138	com/whatsapp/camera/ai:ak	Lcom/whatsapp/ahx;
    //   288: aload_0
    //   289: getfield 106	com/whatsapp/camera/ai:e	Ljava/util/List;
    //   292: aload_0
    //   293: getfield 446	com/whatsapp/camera/ai:g	Ljava/io/File;
    //   296: aload 6
    //   298: aload 5
    //   300: aload_0
    //   301: getfield 879	com/whatsapp/camera/ai:d	Ljava/util/ArrayList;
    //   304: aload 4
    //   306: aload_0
    //   307: getfield 346	com/whatsapp/camera/ai:aa	Z
    //   310: aload_0
    //   311: invokevirtual 336	com/whatsapp/camera/ai:i	()Landroid/os/Bundle;
    //   314: ldc_w 531
    //   317: invokevirtual 344	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   320: invokevirtual 882	com/whatsapp/ahx:a	(Ljava/util/List;Ljava/io/File;Ljava/lang/String;Lcom/whatsapp/protocol/j;Ljava/util/List;Lcom/whatsapp/doodle/a/b;ZZ)Z
    //   323: pop
    //   324: aload_0
    //   325: invokespecial 884	com/whatsapp/camera/ai:V	()V
    //   328: aload_0
    //   329: invokevirtual 414	com/whatsapp/camera/ai:k	()Landroid/content/Context;
    //   332: aload_0
    //   333: getfield 446	com/whatsapp/camera/ai:g	Ljava/io/File;
    //   336: invokestatic 665	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   339: invokestatic 889	com/whatsapp/util/MediaFileUtils:a	(Landroid/content/Context;Landroid/net/Uri;)V
    //   342: aload_0
    //   343: invokevirtual 480	com/whatsapp/camera/ai:R	()Lcom/whatsapp/camera/h;
    //   346: astore 4
    //   348: aload 4
    //   350: ifnull +8 -> 358
    //   353: aload 4
    //   355: invokevirtual 891	com/whatsapp/camera/h:b	()V
    //   358: aload_0
    //   359: invokevirtual 336	com/whatsapp/camera/ai:i	()Landroid/os/Bundle;
    //   362: ldc_w 505
    //   365: invokevirtual 894	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   368: astore 4
    //   370: aload 4
    //   372: ifnull -310 -> 62
    //   375: aload_0
    //   376: getfield 106	com/whatsapp/camera/ai:e	Ljava/util/List;
    //   379: invokeinterface 382 1 0
    //   384: iconst_1
    //   385: if_icmpgt +24 -> 409
    //   388: aload_0
    //   389: getfield 106	com/whatsapp/camera/ai:e	Ljava/util/List;
    //   392: iconst_0
    //   393: invokeinterface 555 2 0
    //   398: checkcast 557	java/lang/String
    //   401: aload 4
    //   403: invokevirtual 897	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   406: ifne -344 -> 62
    //   409: aload_0
    //   410: invokevirtual 414	com/whatsapp/camera/ai:k	()Landroid/content/Context;
    //   413: ldc_w 898
    //   416: iconst_1
    //   417: invokestatic 901	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   420: return
    //   421: aconst_null
    //   422: astore 5
    //   424: goto -140 -> 284
    //   427: astore 4
    //   429: aload 4
    //   431: invokevirtual 904	java/io/IOException:getMessage	()Ljava/lang/String;
    //   434: ifnull +63 -> 497
    //   437: aload 4
    //   439: invokevirtual 904	java/io/IOException:getMessage	()Ljava/lang/String;
    //   442: ldc_w 906
    //   445: invokevirtual 909	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   448: ifeq +49 -> 497
    //   451: aload_0
    //   452: getfield 124	com/whatsapp/camera/ai:ai	Lcom/whatsapp/pv;
    //   455: aload_0
    //   456: invokevirtual 551	com/whatsapp/camera/ai:l	()Landroid/support/v4/app/n;
    //   459: checkcast 911	com/whatsapp/ng
    //   462: aload_0
    //   463: ldc_w 912
    //   466: invokevirtual 915	com/whatsapp/camera/ai:a	(I)Ljava/lang/String;
    //   469: invokevirtual 918	com/whatsapp/pv:a	(Lcom/whatsapp/ng;Ljava/lang/String;)V
    //   472: new 594	java/lang/StringBuilder
    //   475: dup
    //   476: ldc_w 920
    //   479: invokespecial 598	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   482: aload 4
    //   484: invokevirtual 921	java/io/IOException:toString	()Ljava/lang/String;
    //   487: invokevirtual 607	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 610	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 614	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   496: return
    //   497: aload_0
    //   498: invokevirtual 414	com/whatsapp/camera/ai:k	()Landroid/content/Context;
    //   501: ldc_w 922
    //   504: iconst_0
    //   505: invokestatic 901	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   508: goto -36 -> 472
    //   511: astore 4
    //   513: aload_0
    //   514: invokevirtual 414	com/whatsapp/camera/ai:k	()Landroid/content/Context;
    //   517: ldc_w 922
    //   520: iconst_0
    //   521: invokestatic 901	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   524: new 594	java/lang/StringBuilder
    //   527: dup
    //   528: ldc_w 920
    //   531: invokespecial 598	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   534: aload 4
    //   536: invokevirtual 923	org/json/JSONException:toString	()Ljava/lang/String;
    //   539: invokevirtual 607	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: invokevirtual 610	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: invokestatic 614	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   548: return
    //   549: aload_0
    //   550: getfield 110	com/whatsapp/camera/ai:c	Ljava/lang/String;
    //   553: invokestatic 927	com/whatsapp/emoji/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   556: astore 6
    //   558: aload_0
    //   559: getfield 312	com/whatsapp/camera/ai:b	Lcom/whatsapp/doodle/a;
    //   562: ifnull +16 -> 578
    //   565: aload_0
    //   566: getfield 312	com/whatsapp/camera/ai:b	Lcom/whatsapp/doodle/a;
    //   569: getfield 317	com/whatsapp/doodle/a:a	Lcom/whatsapp/doodle/DoodleView;
    //   572: invokevirtual 321	com/whatsapp/doodle/DoodleView:b	()Z
    //   575: ifne +282 -> 857
    //   578: aconst_null
    //   579: astore 4
    //   581: aload_0
    //   582: getfield 330	com/whatsapp/camera/ai:ac	Landroid/graphics/Rect;
    //   585: ifnonnull +330 -> 915
    //   588: aload 4
    //   590: ifnonnull +325 -> 915
    //   593: aload_0
    //   594: getfield 207	com/whatsapp/camera/ai:f	Landroid/net/Uri;
    //   597: astore 5
    //   599: aload 5
    //   601: invokevirtual 931	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   604: astore 5
    //   606: aload 4
    //   608: ifnull +338 -> 946
    //   611: aload 4
    //   613: aload_0
    //   614: getfield 145	com/whatsapp/camera/ai:al	Lcom/whatsapp/oz;
    //   617: ldc_w 658
    //   620: invokevirtual 661	com/whatsapp/oz:a	(Ljava/lang/String;)Ljava/io/File;
    //   623: getstatic 934	com/whatsapp/aic:w	I
    //   626: invokestatic 937	com/whatsapp/util/MediaFileUtils:a	(Landroid/graphics/Bitmap;Ljava/io/File;I)Z
    //   629: pop
    //   630: aload 5
    //   632: invokevirtual 943	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   635: astore 5
    //   637: aload_0
    //   638: getfield 879	com/whatsapp/camera/ai:d	Ljava/util/ArrayList;
    //   641: astore 7
    //   643: aload_0
    //   644: invokevirtual 336	com/whatsapp/camera/ai:i	()Landroid/os/Bundle;
    //   647: ldc_w 511
    //   650: invokevirtual 874	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   653: lstore_2
    //   654: lload_2
    //   655: lconst_0
    //   656: lcmp
    //   657: ifeq +339 -> 996
    //   660: aload_0
    //   661: getfield 187	com/whatsapp/camera/ai:ar	Lcom/whatsapp/data/l;
    //   664: lload_2
    //   665: invokevirtual 877	com/whatsapp/data/l:a	(J)Lcom/whatsapp/protocol/j;
    //   668: astore 4
    //   670: aload_0
    //   671: getfield 138	com/whatsapp/camera/ai:ak	Lcom/whatsapp/ahx;
    //   674: aload_0
    //   675: getfield 106	com/whatsapp/camera/ai:e	Ljava/util/List;
    //   678: aload 5
    //   680: iconst_5
    //   681: aload 4
    //   683: aload 7
    //   685: aload 6
    //   687: aload_0
    //   688: invokevirtual 336	com/whatsapp/camera/ai:i	()Landroid/os/Bundle;
    //   691: ldc_w 531
    //   694: invokevirtual 344	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   697: invokevirtual 946	com/whatsapp/ahx:a	(Ljava/util/List;Landroid/net/Uri;ILcom/whatsapp/protocol/j;Ljava/util/List;Ljava/lang/String;Z)V
    //   700: aload_0
    //   701: invokevirtual 480	com/whatsapp/camera/ai:R	()Lcom/whatsapp/camera/h;
    //   704: astore 4
    //   706: aload 4
    //   708: ifnull +8 -> 716
    //   711: aload 4
    //   713: invokevirtual 891	com/whatsapp/camera/h:b	()V
    //   716: aload_0
    //   717: invokevirtual 336	com/whatsapp/camera/ai:i	()Landroid/os/Bundle;
    //   720: ldc_w 505
    //   723: invokevirtual 894	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   726: astore 4
    //   728: aload 4
    //   730: ifnull +48 -> 778
    //   733: aload_0
    //   734: getfield 106	com/whatsapp/camera/ai:e	Ljava/util/List;
    //   737: invokeinterface 382 1 0
    //   742: iconst_1
    //   743: if_icmpgt +24 -> 767
    //   746: aload_0
    //   747: getfield 106	com/whatsapp/camera/ai:e	Ljava/util/List;
    //   750: iconst_0
    //   751: invokeinterface 555 2 0
    //   756: checkcast 557	java/lang/String
    //   759: aload 4
    //   761: invokevirtual 897	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   764: ifne +14 -> 778
    //   767: aload_0
    //   768: invokevirtual 414	com/whatsapp/camera/ai:k	()Landroid/content/Context;
    //   771: ldc_w 898
    //   774: iconst_1
    //   775: invokestatic 901	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   778: aload_0
    //   779: invokevirtual 414	com/whatsapp/camera/ai:k	()Landroid/content/Context;
    //   782: aload_0
    //   783: getfield 207	com/whatsapp/camera/ai:f	Landroid/net/Uri;
    //   786: invokestatic 889	com/whatsapp/util/MediaFileUtils:a	(Landroid/content/Context;Landroid/net/Uri;)V
    //   789: aload_0
    //   790: invokespecial 884	com/whatsapp/camera/ai:V	()V
    //   793: return
    //   794: astore 4
    //   796: new 594	java/lang/StringBuilder
    //   799: dup
    //   800: ldc_w 948
    //   803: invokespecial 598	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   806: aload 4
    //   808: invokevirtual 921	java/io/IOException:toString	()Ljava/lang/String;
    //   811: invokevirtual 607	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: invokevirtual 610	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: invokestatic 614	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   820: aload 4
    //   822: invokevirtual 904	java/io/IOException:getMessage	()Ljava/lang/String;
    //   825: ifnull +177 -> 1002
    //   828: aload 4
    //   830: invokevirtual 904	java/io/IOException:getMessage	()Ljava/lang/String;
    //   833: ldc_w 906
    //   836: invokevirtual 909	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   839: ifeq +163 -> 1002
    //   842: aload_0
    //   843: getfield 124	com/whatsapp/camera/ai:ai	Lcom/whatsapp/pv;
    //   846: invokestatic 952	com/whatsapp/u:a	()Landroid/content/Context;
    //   849: ldc_w 912
    //   852: iconst_0
    //   853: invokevirtual 954	com/whatsapp/pv:b	(Landroid/content/Context;II)V
    //   856: return
    //   857: aload_0
    //   858: getfield 628	com/whatsapp/camera/ai:ae	Lcom/whatsapp/PhotoView;
    //   861: invokevirtual 958	com/whatsapp/PhotoView:getPhoto	()Landroid/graphics/Bitmap;
    //   864: astore 4
    //   866: aload 4
    //   868: invokevirtual 963	android/graphics/Bitmap:isMutable	()Z
    //   871: ifeq +30 -> 901
    //   874: aload_0
    //   875: getfield 106	com/whatsapp/camera/ai:e	Ljava/util/List;
    //   878: invokeinterface 838 1 0
    //   883: ifne +18 -> 901
    //   886: aload_0
    //   887: getfield 312	com/whatsapp/camera/ai:b	Lcom/whatsapp/doodle/a;
    //   890: getfield 317	com/whatsapp/doodle/a:a	Lcom/whatsapp/doodle/DoodleView;
    //   893: aload 4
    //   895: invokevirtual 966	com/whatsapp/doodle/DoodleView:a	(Landroid/graphics/Bitmap;)V
    //   898: goto -317 -> 581
    //   901: aload 4
    //   903: getstatic 972	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   906: iconst_1
    //   907: invokevirtual 976	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   910: astore 4
    //   912: goto -26 -> 886
    //   915: aload_0
    //   916: getfield 145	com/whatsapp/camera/ai:al	Lcom/whatsapp/oz;
    //   919: ldc_w 658
    //   922: invokevirtual 661	com/whatsapp/oz:a	(Ljava/lang/String;)Ljava/io/File;
    //   925: invokestatic 665	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   928: astore 5
    //   930: goto -331 -> 599
    //   933: astore 4
    //   935: invokestatic 952	com/whatsapp/u:a	()Landroid/content/Context;
    //   938: ldc_w 977
    //   941: iconst_1
    //   942: invokestatic 901	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   945: return
    //   946: aload_0
    //   947: getfield 207	com/whatsapp/camera/ai:f	Landroid/net/Uri;
    //   950: ldc_w 694
    //   953: invokevirtual 215	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   956: ifnull +15 -> 971
    //   959: aload 5
    //   961: ldc_w 694
    //   964: ldc_w 979
    //   967: invokevirtual 983	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   970: pop
    //   971: aload_0
    //   972: invokespecial 692	com/whatsapp/camera/ai:T	()I
    //   975: ifeq -345 -> 630
    //   978: aload 5
    //   980: ldc -47
    //   982: aload_0
    //   983: invokespecial 692	com/whatsapp/camera/ai:T	()I
    //   986: invokestatic 985	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   989: invokevirtual 983	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   992: pop
    //   993: goto -363 -> 630
    //   996: aconst_null
    //   997: astore 4
    //   999: goto -329 -> 670
    //   1002: invokestatic 952	com/whatsapp/u:a	()Landroid/content/Context;
    //   1005: ldc_w 922
    //   1008: iconst_0
    //   1009: invokestatic 901	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   1012: return
    //   1013: astore 4
    //   1015: new 594	java/lang/StringBuilder
    //   1018: dup
    //   1019: ldc_w 948
    //   1022: invokespecial 598	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1025: aload 4
    //   1027: invokevirtual 986	com/whatsapp/util/MediaFileUtils$e:toString	()Ljava/lang/String;
    //   1030: invokevirtual 607	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: invokevirtual 610	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1036: invokestatic 614	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1039: aload_0
    //   1040: getfield 124	com/whatsapp/camera/ai:ai	Lcom/whatsapp/pv;
    //   1043: invokestatic 952	com/whatsapp/u:a	()Landroid/content/Context;
    //   1046: ldc_w 987
    //   1049: iconst_0
    //   1050: invokevirtual 954	com/whatsapp/pv:b	(Landroid/content/Context;II)V
    //   1053: return
    //   1054: astore 4
    //   1056: new 594	java/lang/StringBuilder
    //   1059: dup
    //   1060: ldc_w 948
    //   1063: invokespecial 598	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1066: aload 4
    //   1068: invokevirtual 988	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   1071: invokevirtual 607	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: invokevirtual 610	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1077: invokestatic 614	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1080: aload_0
    //   1081: getfield 124	com/whatsapp/camera/ai:ai	Lcom/whatsapp/pv;
    //   1084: invokestatic 952	com/whatsapp/u:a	()Landroid/content/Context;
    //   1087: ldc_w 989
    //   1090: iconst_0
    //   1091: invokevirtual 954	com/whatsapp/pv:b	(Landroid/content/Context;II)V
    //   1094: return
    //   1095: astore 4
    //   1097: new 594	java/lang/StringBuilder
    //   1100: dup
    //   1101: ldc_w 948
    //   1104: invokespecial 598	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1107: aload 4
    //   1109: invokevirtual 990	java/lang/SecurityException:toString	()Ljava/lang/String;
    //   1112: invokevirtual 607	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1115: invokevirtual 610	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1118: invokestatic 614	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1121: aload_0
    //   1122: getfield 124	com/whatsapp/camera/ai:ai	Lcom/whatsapp/pv;
    //   1125: invokestatic 952	com/whatsapp/u:a	()Landroid/content/Context;
    //   1128: ldc_w 991
    //   1131: iconst_0
    //   1132: invokevirtual 954	com/whatsapp/pv:b	(Landroid/content/Context;II)V
    //   1135: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1136	0	this	ai
    //   139	45	1	b1	byte
    //   267	398	2	l	long
    //   26	376	4	localObject1	Object
    //   427	56	4	localIOException1	IOException
    //   511	24	4	localJSONException	org.json.JSONException
    //   579	181	4	localObject2	Object
    //   794	35	4	localIOException2	IOException
    //   864	47	4	localBitmap	Bitmap
    //   933	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   997	1	4	localObject3	Object
    //   1013	13	4	locale	MediaFileUtils.e
    //   1054	13	4	localOutOfMemoryError	OutOfMemoryError
    //   1095	13	4	localSecurityException	SecurityException
    //   215	764	5	localObject4	Object
    //   212	474	6	str	String
    //   641	43	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   257	268	427	java/io/IOException
    //   274	284	427	java/io/IOException
    //   284	328	427	java/io/IOException
    //   257	268	511	org/json/JSONException
    //   274	284	511	org/json/JSONException
    //   284	328	511	org/json/JSONException
    //   643	654	794	java/io/IOException
    //   660	670	794	java/io/IOException
    //   670	706	794	java/io/IOException
    //   711	716	794	java/io/IOException
    //   716	728	794	java/io/IOException
    //   733	767	794	java/io/IOException
    //   767	778	794	java/io/IOException
    //   778	793	794	java/io/IOException
    //   611	630	933	java/io/FileNotFoundException
    //   643	654	1013	com/whatsapp/util/MediaFileUtils$e
    //   660	670	1013	com/whatsapp/util/MediaFileUtils$e
    //   670	706	1013	com/whatsapp/util/MediaFileUtils$e
    //   711	716	1013	com/whatsapp/util/MediaFileUtils$e
    //   716	728	1013	com/whatsapp/util/MediaFileUtils$e
    //   733	767	1013	com/whatsapp/util/MediaFileUtils$e
    //   767	778	1013	com/whatsapp/util/MediaFileUtils$e
    //   778	793	1013	com/whatsapp/util/MediaFileUtils$e
    //   643	654	1054	java/lang/OutOfMemoryError
    //   660	670	1054	java/lang/OutOfMemoryError
    //   670	706	1054	java/lang/OutOfMemoryError
    //   711	716	1054	java/lang/OutOfMemoryError
    //   716	728	1054	java/lang/OutOfMemoryError
    //   733	767	1054	java/lang/OutOfMemoryError
    //   767	778	1054	java/lang/OutOfMemoryError
    //   778	793	1054	java/lang/OutOfMemoryError
    //   643	654	1095	java/lang/SecurityException
    //   660	670	1095	java/lang/SecurityException
    //   670	706	1095	java/lang/SecurityException
    //   711	716	1095	java/lang/SecurityException
    //   716	728	1095	java/lang/SecurityException
    //   733	767	1095	java/lang/SecurityException
    //   767	778	1095	java/lang/SecurityException
    //   778	793	1095	java/lang/SecurityException
  }
  
  public final void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = null;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return;
      Object localObject2;
      if (paramInt2 == -1)
      {
        paramInt1 = paramIntent.getIntExtra("rotate", 0);
        this.ad = ((this.ad + paramInt1) % 360);
        localObject2 = Uri.fromFile(this.al.a("crop_result.jpg"));
        localObject1 = localObject2;
        if (this.f.getQueryParameter("flip-h") != null) {
          localObject1 = ((Uri)localObject2).buildUpon().appendQueryParameter("flip-h", "1").build();
        }
        paramInt2 = T();
        localObject2 = localObject1;
        if (paramInt2 != 0) {
          localObject2 = ((Uri)localObject1).buildUpon().appendQueryParameter("rotation", Integer.toString(paramInt2)).build();
        }
      }
      try
      {
        localObject1 = MediaFileUtils.a(this.aq, (Uri)localObject2, aic.x, aic.x);
        if (localObject1 == null)
        {
          Log.e("capturepreview/setuppreview/nullbitmap");
          pv.a(k(), 2131296390, 1);
          return;
        }
      }
      catch (OutOfMemoryError paramIntent)
      {
        Log.d("capturepreview/setuppreview", paramIntent);
        pv.a(k(), 2131296390, 1);
        return;
        this.ac = ((Rect)paramIntent.getParcelableExtra("rect"));
        this.ae.a((Bitmap)localObject1);
        if (this.b == null) {
          continue;
        }
        try
        {
          localObject1 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
          localObject2 = MediaFileUtils.a(this.aq, this.f);
          BitmapFactory.decodeStream((InputStream)localObject2, null, (BitmapFactory.Options)localObject1);
          ((InputStream)localObject2).close();
          RectF localRectF = new RectF(0.0F, 0.0F, ((BitmapFactory.Options)localObject1).outWidth, ((BitmapFactory.Options)localObject1).outHeight);
          localObject2 = MediaFileUtils.b(this.aq, this.f);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Matrix();
          }
          ((Matrix)localObject1).mapRect(localRectF);
          float f1 = localRectF.left;
          float f2 = localRectF.top;
          localObject2 = new RectF(this.ac);
          ((Matrix)localObject1).mapRect((RectF)localObject2);
          ((RectF)localObject2).offset(-f1, -f2);
          f1 = this.b.a.getBitmapRect().width() * 1.0F / localRectF.width();
          ((RectF)localObject2).left *= f1;
          ((RectF)localObject2).top *= f1;
          ((RectF)localObject2).right *= f1;
          ((RectF)localObject2).bottom = (f1 * ((RectF)localObject2).bottom);
          this.b.b((RectF)localObject2);
          this.b.a(paramInt1);
          return;
        }
        catch (IOException localIOException)
        {
          CropImage.a(this.ai, paramIntent, (ng)l());
          return;
        }
        if ((paramInt2 != 0) || (paramIntent == null) || (l() == null)) {
          continue;
        }
        CropImage.a(this.ai, paramIntent, (ng)l());
        return;
        if (paramInt2 == -1)
        {
          this.e.clear();
          this.e.addAll(paramIntent.getStringArrayListExtra("jids"));
          if ((this.e.size() > 1) || (this.e.contains("status@broadcast"))) {
            pv.a(k(), this.e);
          }
          for (;;)
          {
            a();
            return;
            if (this.e.size() == 1) {
              a(Conversation.a((String)this.e.get(0)));
            }
          }
        }
        this.af.setEnabled(true);
        return;
        if (paramInt2 != -1) {
          continue;
        }
        localObject2 = paramIntent.getStringArrayListExtra("jids");
        if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
          continue;
        }
        if (this.au != null)
        {
          this.au.a();
          this.au = null;
        }
        this.e.clear();
        this.e.addAll((Collection)localObject2);
        paramIntent = localIOException;
        if (((ArrayList)localObject2).size() == 1) {
          paramIntent = (String)((ArrayList)localObject2).get(0);
        }
        if (paramIntent != null)
        {
          if (j.c(paramIntent)) {}
          for (paramIntent = this.aj.c(); paramIntent != null; paramIntent = this.ap.d(paramIntent))
          {
            this.au = this.ao.b();
            this.au.a(paramIntent, (ImageView)d(2131755440));
            return;
          }
          ((ImageView)d(2131755440)).setImageBitmap(cs.b(2130837625));
          return;
        }
        ((ImageView)d(2131755440)).setImageBitmap(cs.b(2130837628));
        return;
      }
      catch (IOException paramIntent)
      {
        for (;;) {}
      }
      catch (MediaFileUtils.e paramIntent)
      {
        for (;;) {}
      }
    }
  }
  
  public final void b()
  {
    if (this.b != null)
    {
      boolean bool2;
      AlertDialog.Builder localBuilder;
      int j;
      if (!this.b.h())
      {
        if (this.b.a.getEditsCount() <= 2) {
          break label167;
        }
        boolean bool1 = i().getBoolean("is_new_content");
        bool2 = i().getBoolean("is_video");
        localBuilder = new AlertDialog.Builder(k());
        if (!bool1) {
          break label135;
        }
        if (!bool2) {
          break label128;
        }
        j = 2131296683;
        localBuilder = localBuilder.setTitle(j);
        if (!bool1) {
          break label149;
        }
        if (!bool2) {
          break label142;
        }
        j = 2131296682;
      }
      for (;;)
      {
        localBuilder.setMessage(j).setPositiveButton(2131296677, ao.a(this)).setNegativeButton(2131296676, ap.a()).show();
        return;
        label128:
        j = 2131296679;
        break;
        label135:
        j = 2131296675;
        break;
        label142:
        j = 2131296678;
        continue;
        label149:
        if (bool2) {
          j = 2131296684;
        } else {
          j = 2131296680;
        }
      }
      label167:
      c();
      return;
    }
    c();
  }
  
  final void c()
  {
    if (this.ag) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        this.ag = true;
        localObject1 = l();
      } while (localObject1 == null);
      Object localObject2 = (VideoSurfaceView)d(2131755424);
      if (((VideoSurfaceView)localObject2).isPlaying()) {
        ((VideoSurfaceView)localObject2).a();
      }
      localObject2 = (InputMethodManager)((n)localObject1).getSystemService("input_method");
      Object localObject3 = ((n)localObject1).getCurrentFocus();
      if (localObject3 != null) {
        ((InputMethodManager)localObject2).hideSoftInputFromWindow(((View)localObject3).getWindowToken(), 0);
      }
      d(2131755435).setVisibility(4);
      d(2131755438).setVisibility(4);
      d(2131755423).setVisibility(4);
      d(2131755428).setVisibility(4);
      this.ab.setBackgroundColor(0);
      this.af.setVisibility(4);
      d(2131755426).setVisibility(4);
      localObject2 = (Rect)i().getParcelable("rect");
      if (localObject2 == null)
      {
        localObject1 = new AnimationSet(true);
        localObject2 = new TranslateAnimation(1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F);
        localObject3 = new RotateAnimation(0.0F, 30.0F, 1, 0.5F, 1, 0.5F);
        ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
        ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
        ((AnimationSet)localObject1).setDuration(200L);
        ((AnimationSet)localObject1).setFillAfter(true);
        ((AnimationSet)localObject1).setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            ai.d(ai.this).a(null);
            if (ai.this.l() != null) {
              ai.i(ai.this).a(aq.a(this), 100L);
            }
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.ab.startAnimation((Animation)localObject1);
        return;
      }
      if (this.ae.getPhoto() != null)
      {
        this.ae.a((Rect)localObject2, false, new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            ai.d(ai.this).a(null);
            paramAnonymousAnimation = ai.this.l();
            if (paramAnonymousAnimation != null) {
              paramAnonymousAnimation.j_().a().a(ai.this).d();
            }
            paramAnonymousAnimation = ai.h(ai.this);
            if (paramAnonymousAnimation != null) {
              paramAnonymousAnimation.a(true);
            }
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        return;
      }
      ((n)localObject1).j_().a().a(this).d();
      localObject1 = R();
    } while (localObject1 == null);
    ((h)localObject1).a(true);
  }
  
  public final void d(final Bundle paramBundle)
  {
    super.d(paramBundle);
    Log.i("capturepreview/onactivitycreted");
    paramBundle = i().getString("jid");
    boolean bool = i().getBoolean("is_video");
    if ((l().getWindow().getAttributes().flags & 0x400) == 0) {
      l().getWindow().addFlags(1024);
    }
    label167:
    int j;
    if (paramBundle != null)
    {
      this.e.add(paramBundle);
      if (j.c(paramBundle))
      {
        paramBundle = this.aj.c();
        if (paramBundle != null)
        {
          this.au = this.ao.b();
          this.au.a(paramBundle, (ImageView)d(2131755440));
        }
        this.af.setImageDrawable(new az(android.support.v4.content.b.a(k(), 2130840323)));
        this.af.setContentDescription(a(2131297656));
        paramBundle = ((a)l()).n();
        d(2131755427).setPadding(paramBundle.left, paramBundle.top, paramBundle.right, paramBundle.bottom);
        d(2131755716).setPadding(paramBundle.left, 0, paramBundle.right, 0);
        d(2131755435).setVisibility(4);
        d(2131755438).setVisibility(4);
        if (i().getParcelable("rect") != null) {
          this.ab.setBackgroundColor(-16777216);
        }
        paramBundle = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
        paramBundle.setDuration(125L);
        paramBundle.setInterpolator(new AccelerateDecelerateInterpolator());
        paramBundle.setFillBefore(true);
        paramBundle.setStartOffset(100L);
        this.af.startAnimation(paramBundle);
        this.b = new com.whatsapp.doodle.a(l(), this.ai, this.ab, new a.a()
        {
          public final void a()
          {
            if (ai.c(ai.this).getVisibility() != 4)
            {
              AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
              localAlphaAnimation.setDuration(300L);
              ai.c(ai.this).setVisibility(4);
              ai.c(ai.this).startAnimation(localAlphaAnimation);
              View localView = ai.a(ai.this, 2131755429);
              localView.setVisibility(4);
              localView.startAnimation(localAlphaAnimation);
              localView = ai.a(ai.this, 2131755428);
              if ((!ai.a(ai.this)) && (localView.getVisibility() != 8))
              {
                localView.setVisibility(4);
                localView.startAnimation(localAlphaAnimation);
              }
            }
          }
          
          public final void a(com.whatsapp.doodle.a.e paramAnonymouse) {}
          
          public final void b()
          {
            if (ai.c(ai.this).getVisibility() != 0)
            {
              AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
              localAlphaAnimation.setDuration(300L);
              ai.c(ai.this).setVisibility(0);
              ai.c(ai.this).startAnimation(localAlphaAnimation);
              View localView = ai.a(ai.this, 2131755429);
              localView.setVisibility(0);
              localView.startAnimation(localAlphaAnimation);
              localView = ai.a(ai.this, 2131755428);
              if ((!ai.a(ai.this)) && (localView.getVisibility() != 8))
              {
                localView.setVisibility(0);
                localView.startAnimation(localAlphaAnimation);
              }
            }
          }
          
          public final void c()
          {
            ai.d(ai.this).a();
          }
          
          public final void d()
          {
            ai.d(ai.this).a();
            ai.e(ai.this);
          }
          
          public final void e()
          {
            ai.d(ai.this).a(false);
          }
          
          public final void f()
          {
            ai.d(ai.this).a(true);
          }
        });
        this.b.a(this.ab);
        paramBundle = (Uri)i().getParcelable("uri");
        if (!bool) {
          break label1061;
        }
        this.g = new File(paramBundle.getPath());
        this.aa = GifHelper.a(this.g);
        paramBundle = d(2131755428);
        if (!this.aa) {
          break label939;
        }
        j = 8;
        label432:
        paramBundle.setVisibility(j);
        d(2131755442).setVisibility(8);
        if (aqe.a() != aqe.c.a) {
          break label944;
        }
        d(2131755443).setVisibility(0);
        d(2131755444).setVisibility(0);
        d(2131755445).setVisibility(0);
        d(2131755426).setVisibility(0);
      }
    }
    for (;;)
    {
      long l1 = 0L;
      localObject2 = new MediaMetadataRetriever();
      try
      {
        ((MediaMetadataRetriever)localObject2).setDataSource(this.g.getAbsolutePath());
        paramBundle = ((MediaMetadataRetriever)localObject2).getFrameAtTime(0L);
        long l2 = Long.parseLong(((MediaMetadataRetriever)localObject2).extractMetadata(9));
        l1 = l2;
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          final Object localObject3;
          Log.e("videopreview/getvideothumb" + paramBundle.toString());
          paramBundle = MediaFileUtils.g(this.g.getAbsolutePath());
          continue;
          localObject1 = null;
          continue;
          U();
          W();
          continue;
          ((VideoSurfaceView)localObject3).setBackgroundColor(-16777216);
        }
        this.f = paramBundle;
        d(2131755442).setVisibility(0);
        d(2131755443).setVisibility(0);
        d(2131755444).setVisibility(0);
        d(2131755445).setVisibility(0);
        d(2131755426).setVisibility(0);
        d(2131755423).setVisibility(8);
        d(2131755428).setVisibility(8);
        localObject2 = (Rect)i().getParcelable("rect");
        this.ae.setVisibility(0);
        this.ae.a(true);
        if (localObject2 == null) {
          break label1255;
        }
        final Object localObject1 = (Bitmap)this.ah.a.a(paramBundle.toString());
        if (localObject1 == null) {
          break label1221;
        }
        paramBundle = (Bundle)localObject1;
        if (((Bitmap)localObject1).getWidth() != ((Bitmap)localObject1).getHeight()) {
          break label1247;
        }
        try
        {
          paramBundle = MediaFileUtils.a(this.aq, this.f, Math.max(((Rect)localObject2).width(), ((Rect)localObject2).height()), 0);
          this.ae.a(paramBundle);
          if (localObject2 == null) {
            break label1310;
          }
          this.ae.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              ai.d(ai.this).getViewTreeObserver().removeOnPreDrawListener(this);
              h localh = ai.h(ai.this);
              if (localh != null)
              {
                localh.m();
                ai.d(ai.this).a(localObject2, true, new Animation.AnimationListener()
                {
                  public final void onAnimationEnd(Animation paramAnonymous2Animation)
                  {
                    ai.m(ai.this);
                  }
                  
                  public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                  
                  public final void onAnimationStart(Animation paramAnonymous2Animation) {}
                });
              }
              return false;
            }
          });
          this.af.setOnClickListener(new com.whatsapp.util.at()
          {
            public final void a(View paramAnonymousView)
            {
              ai.this.a();
            }
          });
          return;
        }
        catch (OutOfMemoryError paramBundle)
        {
          for (;;)
          {
            Log.d("capturepreview/setuppreview", paramBundle);
            paramBundle = (Bundle)localObject1;
            continue;
            U();
          }
        }
        catch (IOException paramBundle)
        {
          for (;;) {}
        }
        catch (MediaFileUtils.e paramBundle)
        {
          for (;;) {}
        }
      }
      catch (NoSuchMethodError paramBundle)
      {
        for (;;) {}
      }
      if (this.e.size() != 1) {
        break label1033;
      }
      localObject1 = (String)this.e.get(0);
      if ((!j.c((String)localObject1)) || (l1 <= aic.f())) {
        break label1329;
      }
      pv.a(k());
      l1 = aic.f();
      if (paramBundle != null)
      {
        this.h = paramBundle.getWidth();
        this.i = paramBundle.getHeight();
      }
      ((MediaMetadataRetriever)localObject2).release();
      this.ae.setVisibility(0);
      localObject1 = (Rect)i().getParcelable("rect");
      if ((paramBundle == null) || (localObject1 == null)) {
        break label1039;
      }
      this.ae.a(paramBundle);
      this.ae.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          ai.d(ai.this).getViewTreeObserver().removeOnPreDrawListener(this);
          h localh = ai.h(ai.this);
          if (localh != null)
          {
            localh.m();
            ai.d(ai.this).a(localObject1, true, new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                if (ai.this.l() != null)
                {
                  ai.m(ai.this);
                  ai.n(ai.this);
                }
              }
              
              public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationStart(Animation paramAnonymous2Animation) {}
            });
          }
          return false;
        }
      });
      localObject1 = (SeekBar)d(2131755432);
      ((SeekBar)localObject1).setProgress(0);
      ((SeekBar)localObject1).setMax((int)l1);
      ((SeekBar)localObject1).setVisibility(0);
      localObject2 = (TextView)d(2131755431);
      localObject3 = (TextView)d(2131755433);
      ((TextView)localObject2).setText(DateUtils.formatElapsedTime(0L));
      ((TextView)localObject3).setText(DateUtils.formatElapsedTime(l1 / 1000L));
      localObject3 = (VideoSurfaceView)d(2131755424);
      if (paramBundle == null) {
        break label1050;
      }
      ((VideoSurfaceView)localObject3).setBackgroundDrawable(new BitmapDrawable(m(), paramBundle));
      ((SeekBar)localObject1).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
      {
        public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean) {
            localObject3.seekTo(paramAnonymousInt);
          }
          localObject2.setText(DateUtils.formatElapsedTime(paramAnonymousInt / 1000));
        }
        
        public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
        
        public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
          localObject3.seekTo(paramAnonymousSeekBar.getProgress());
        }
      });
      paramBundle = (ImageView)d(2131755430);
      localObject1 = al.a(this, (VideoSurfaceView)localObject3, paramBundle, (SeekBar)localObject1, new Runnable()
      {
        public final void run()
        {
          String str;
          if (localObject3.isPlaying())
          {
            localObject1.setProgress(localObject3.getCurrentPosition());
            localObject3.postDelayed(this, 50L);
            if (ai.o(ai.this).size() == 1)
            {
              str = (String)ai.o(ai.this).get(0);
              if (j.c(str))
              {
                long l = localObject3.getCurrentPosition();
                ai.p(ai.this);
                if (l >= aic.f()) {
                  localObject3.pause();
                }
              }
            }
          }
          do
          {
            return;
            str = null;
            break;
            paramBundle.setImageResource(2130840302);
          } while (ai.k(ai.this) == null);
          ai.k(ai.this).a.e();
        }
      });
      this.af.setOnClickListener(new com.whatsapp.util.at()
      {
        public final void a(View paramAnonymousView)
        {
          ai.this.a();
        }
      });
      localObject2 = d(2131755423);
      if (!this.aa)
      {
        ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
        paramBundle.setOnClickListener((View.OnClickListener)localObject1);
      }
      return;
      paramBundle = this.ap.d(paramBundle);
      break;
      this.af.setImageResource(2130840145);
      this.af.setContentDescription(a(2131296687));
      break label167;
      label939:
      j = 0;
      break label432;
      label944:
      d(2131755443).setVisibility(8);
      d(2131755444).setVisibility(8);
      d(2131755445).setVisibility(8);
      d(2131755426).setVisibility(8);
    }
  }
  
  public final void h(Bundle paramBundle)
  {
    super.h(paramBundle);
    if (this.b != null)
    {
      paramBundle = this.b;
      paramBundle.a.a(paramBundle.c.getSize(), paramBundle.c.getColor());
      paramBundle.g();
    }
  }
  
  public final void y()
  {
    super.y();
    if (this.aa)
    {
      VideoSurfaceView localVideoSurfaceView = (VideoSurfaceView)d(2131755424);
      if (!localVideoSurfaceView.isPlaying()) {
        localVideoSurfaceView.start();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract h m();
    
    public abstract Rect n();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/camera/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */