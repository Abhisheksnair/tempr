package com.whatsapp;

import a.a.a.a.a.a.d;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.net.Uri.Builder;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.view.ab;
import android.support.v4.view.o;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.google.c.q;
import com.whatsapp.data.cs;
import com.whatsapp.qrcode.QrCodeView;
import com.whatsapp.qrcode.QrCodeView.a;
import com.whatsapp.registration.bc;
import com.whatsapp.util.Log;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.whispersystems.a.b.g;
import org.whispersystems.a.b.h;
import org.whispersystems.a.m;

public class IdentityVerificationActivity
  extends nh
{
  private boolean A;
  private final com.whatsapp.data.e B = com.whatsapp.data.e.a();
  private final aus C = aus.a();
  private final com.whatsapp.a.c D = com.whatsapp.a.c.a();
  private final atv E = atv.a();
  private final Runnable F = si.a(this);
  cs n;
  QrCodeView o;
  TextView p;
  org.whispersystems.a.b.i q;
  ImageView r;
  final va s = va.a();
  final Camera.PreviewCallback t = new Camera.PreviewCallback()
  {
    public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
    {
      IdentityVerificationActivity.a(IdentityVerificationActivity.this).post(so.a(this, paramAnonymousArrayOfByte));
    }
  };
  private MenuItem u;
  private com.google.c.g.c.e v;
  private String w;
  private HandlerThread x;
  private Handler y;
  private final com.google.c.i z = new com.google.c.i();
  
  private a a(byte[] paramArrayOfByte)
  {
    try
    {
      boolean bool = this.q.a(paramArrayOfByte);
      if (bool) {
        return a.e;
      }
    }
    catch (g paramArrayOfByte)
    {
      Log.c("idverification/versionmismatch", paramArrayOfByte);
      return a.a;
    }
    catch (org.whispersystems.a.b.c paramArrayOfByte)
    {
      if (paramArrayOfByte.a().equals(paramArrayOfByte.b())) {
        return a.c;
      }
      return a.b;
    }
    catch (org.whispersystems.a.b.d paramArrayOfByte)
    {
      Log.c("idverification/invalidprotobuf", paramArrayOfByte);
      return a.a;
    }
    return a.d;
  }
  
  public static org.whispersystems.a.b.b a(va paramva, com.whatsapp.a.c paramc, String paramString)
  {
    paramString = com.whatsapp.a.c.a(paramString);
    com.whatsapp.a.a locala = paramc.b(paramString.a());
    if (locala.a == null)
    {
      Log.i("idverification/nokeyswillrequest");
      return null;
    }
    return new h().a(bc.a(paramva.b()), paramc.h().a(), bc.a(paramString.a()), locala.a);
  }
  
  private void a(Intent paramIntent)
  {
    Log.i("idverification/ndef");
    Object localObject = (NdefMessage)paramIntent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES")[0];
    paramIntent = localObject.getRecords()[0].getPayload();
    if (this.n == null)
    {
      localObject = new String(localObject.getRecords()[0].getId(), Charset.forName("US-ASCII"));
      Log.i("idverification/ndef/jid:" + (String)localObject);
      this.n = this.B.d((String)localObject);
      g(getString(2131298085, new Object[] { this.n.k() }));
      n();
    }
    if (this.q == null)
    {
      Log.w("idverification/ndef/no-fingerprint");
      return;
    }
    paramIntent = a(paramIntent);
    Log.w("idverification/ndef/result:" + paramIntent);
    switch (4.a[paramIntent.ordinal()])
    {
    default: 
      return;
    case 1: 
      pv.a(this, getString(2131298088, new Object[] { this.n.k() }), 1);
      return;
    case 2: 
      pv.a(this, getString(2131298089, new Object[] { this.n.k() }), 1);
      return;
    }
    if (paramIntent == a.e) {}
    for (boolean bool = true;; bool = false)
    {
      c(bool);
      return;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    int j = 0;
    if (this.u != null) {
      this.u.setVisible(paramBoolean);
    }
    View localView = findViewById(2131755524);
    if (paramBoolean)
    {
      i = 0;
      localView.setVisibility(i);
      localView = findViewById(2131755849);
      if (!paramBoolean) {
        break label90;
      }
      i = 0;
      label56:
      localView.setVisibility(i);
      localView = findViewById(2131755845);
      if (!paramBoolean) {
        break label96;
      }
    }
    label90:
    label96:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      return;
      i = 8;
      break;
      i = 8;
      break label56;
    }
  }
  
  private void n()
  {
    if (this.n == null) {
      return;
    }
    TextView localTextView = (TextView)findViewById(2131755848);
    Object localObject1 = a(this.s, this.D, this.n.t);
    if (localObject1 == null)
    {
      d(false);
      localTextView.setText(getString(2131298086, new Object[] { this.n.k() }));
      return;
    }
    this.q = ((org.whispersystems.a.b.b)localObject1).b();
    this.w = ((org.whispersystems.a.b.b)localObject1).a().a();
    localObject1 = (QrImageView)findViewById(2131755846);
    try
    {
      localObject2 = new EnumMap(com.google.c.f.class);
      this.v = com.google.c.g.c.c.a(new String(this.q.a(), "ISO-8859-1"), com.google.c.g.a.f.a, (Map)localObject2);
      QrImageView.a((QrImageView)localObject1, this.v);
      localStringBuilder = new StringBuilder();
      int j = this.w.length();
      localObject1 = null;
      i = 1;
      for (;;)
      {
        if (i > j) {
          break label315;
        }
        localStringBuilder.append(this.w.charAt(i - 1));
        localObject2 = localObject1;
        if (i != j)
        {
          if (i % 20 != 0) {
            break;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localStringBuilder.toString();
          }
          localStringBuilder.append('\n');
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    catch (q localq)
    {
      StringBuilder localStringBuilder;
      for (;;)
      {
        int i;
        Log.b("idverification/", localq);
        continue;
        if (i % 5 == 0)
        {
          localStringBuilder.append("     ");
          localObject2 = localq;
        }
        else
        {
          localStringBuilder.append(' ');
          localObject2 = localq;
        }
      }
      float f1 = localTextView.getTextSize();
      float f2 = localTextView.getPaint().measureText(localq);
      Object localObject2 = getWindowManager().getDefaultDisplay();
      float f3 = Math.min(((Display)localObject2).getWidth(), ((Display)localObject2).getHeight());
      float f4 = aoa.a().a;
      while ((f2 > f3 - 2.0F * f4 * 16.0F) && (f1 > 1.0F))
      {
        f1 -= 1.0F;
        localTextView.setTextSize(f1);
        f2 = localTextView.getPaint().measureText(localq);
      }
      localTextView.setText(localStringBuilder.toString());
      d(true);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label315:
      for (;;) {}
    }
  }
  
  private boolean o()
  {
    return (this.o != null) && (this.o.getVisibility() == 0);
  }
  
  final void a(final Runnable paramRunnable)
  {
    if (!o()) {
      return;
    }
    findViewById(2131755602).setVisibility(0);
    findViewById(2131755851).setVisibility(0);
    findViewById(2131755850).setVisibility(8);
    findViewById(2131755843).setVisibility(8);
    this.p.setVisibility(8);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setDuration(getResources().getInteger(17694721));
    localTranslateAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        IdentityVerificationActivity.d(IdentityVerificationActivity.this).setVisibility(8);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    findViewById(2131755602).startAnimation(localTranslateAnimation);
    this.A = false;
  }
  
  final void c(boolean paramBoolean)
  {
    this.r.setVisibility(0);
    Object localObject = this.r;
    if (paramBoolean)
    {
      i = 2130840027;
      ((ImageView)localObject).setBackgroundResource(i);
      localObject = this.r;
      if (!paramBoolean) {
        break label199;
      }
      i = 2131297034;
      label39:
      ((ImageView)localObject).setContentDescription(getString(i));
      localObject = this.r;
      if (!paramBoolean) {
        break label206;
      }
    }
    label199:
    label206:
    for (int i = 2130840289;; i = 2130840288)
    {
      ((ImageView)localObject).setImageResource(i);
      localObject = new AnimationSet(true);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      ((AnimationSet)localObject).addAnimation(localScaleAnimation);
      ((AnimationSet)localObject).addAnimation(localAlphaAnimation);
      ((AnimationSet)localObject).setInterpolator(new OvershootInterpolator());
      ((AnimationSet)localObject).setDuration(getResources().getInteger(17694721));
      this.r.startAnimation((Animation)localObject);
      this.r.setFocusable(true);
      this.r.setFocusableInTouchMode(true);
      this.r.requestFocus();
      this.aq.a(this.F, 4000L);
      return;
      i = 2130840473;
      break;
      i = 2131297033;
      break label39;
    }
  }
  
  public void finish()
  {
    if ((o()) && (findViewById(2131755602).getVisibility() == 8))
    {
      a(null);
      return;
    }
    super.finish();
  }
  
  final void l()
  {
    int i = 1;
    if (o()) {}
    do
    {
      do
      {
        return;
        if (this.aP.a("android.permission.CAMERA") != 0)
        {
          startActivityForResult(new Intent(this, RequestPermissionActivity.class).putExtra("drawable_id", 2130840436).putExtra("message_id", 2131297358).putExtra("perm_denial_message_id", 2131297357).putExtra("permissions", new String[] { "android.permission.CAMERA" }), 1);
          i = 0;
        }
      } while (i == 0);
      findViewById(2131755843).setVisibility(0);
      this.o.setVisibility(0);
      this.p.setVisibility(8);
      this.aq.b(this.F);
    } while (!this.A);
    this.o.getCamera().setOneShotPreviewCallback(this.t);
  }
  
  final void m()
  {
    runOnUiThread(sl.a(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1) {
        l();
      }
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("idverification/create");
    super.onCreate(paramBundle);
    i().a(true);
    paramBundle = getIntent().getStringExtra("jid");
    if (paramBundle != null)
    {
      this.n = this.B.d(paramBundle);
      g(getString(2131298085, new Object[] { this.n.k() }));
    }
    setContentView(2130903256);
    paramBundle = (TextEmojiLabel)findViewById(2131755849);
    paramBundle.setFocusable(false);
    paramBundle.setLinkHandler(new th());
    Object localObject = new SpannableStringBuilder(Html.fromHtml(getString(2131298090, new Object[] { aic.j().appendPath("general").appendPath("28030015").appendQueryParameter("lg", this.C.d()).appendQueryParameter("lc", this.C.c()).toString() })));
    URLSpan[] arrayOfURLSpan = (URLSpan[])((SpannableStringBuilder)localObject).getSpans(0, ((SpannableStringBuilder)localObject).length(), URLSpan.class);
    if (arrayOfURLSpan != null)
    {
      int j = arrayOfURLSpan.length;
      int i = 0;
      while (i < j)
      {
        URLSpan localURLSpan = arrayOfURLSpan[i];
        ((SpannableStringBuilder)localObject).setSpan(new ti(this.aq, localURLSpan.getURL(), android.support.v4.content.b.c(this, 2131623944)), ((SpannableStringBuilder)localObject).getSpanStart(localURLSpan), ((SpannableStringBuilder)localObject).getSpanEnd(localURLSpan), ((SpannableStringBuilder)localObject).getSpanFlags(localURLSpan));
        i += 1;
      }
      j = arrayOfURLSpan.length;
      i = 0;
      while (i < j)
      {
        ((SpannableStringBuilder)localObject).removeSpan(arrayOfURLSpan[i]);
        i += 1;
      }
    }
    paramBundle.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
    paramBundle = new HashMap();
    localObject = new ArrayList();
    ((ArrayList)localObject).add(com.google.c.a.l);
    paramBundle.put(com.google.c.e.c, localObject);
    paramBundle.put(com.google.c.e.e, "ISO-8859-1");
    this.z.a(paramBundle);
    this.x = new HandlerThread("IdDecode");
    this.x.start();
    this.y = new Handler(this.x.getLooper());
    this.p = ((TextView)findViewById(2131755844));
    this.o = ((QrCodeView)findViewById(2131755414));
    this.o.setThreadHandler(this.y);
    this.o.setCameraCallback(new QrCodeView.a()
    {
      public final void a()
      {
        Log.i("idverification/previewready");
        IdentityVerificationActivity.b(IdentityVerificationActivity.this);
        IdentityVerificationActivity.this.runOnUiThread(sq.a(this));
      }
      
      public final void a(int paramAnonymousInt)
      {
        Log.e("idverification/cameraerror");
        IdentityVerificationActivity.this.runOnUiThread(sp.a(this, paramAnonymousInt));
      }
    });
    n();
    this.r = ((ImageView)a.d.a(findViewById(2131755847)));
    ((View)a.d.a(findViewById(2131755851))).setOnClickListener(sj.a(this));
    if ((Build.VERSION.SDK_INT >= 14) && (this.aP.a("android.permission.NFC") == 0))
    {
      paramBundle = NfcAdapter.getDefaultAdapter(this);
      if (paramBundle == null) {}
    }
    try
    {
      paramBundle.setNdefPushMessageCallback(sk.a(this), this, new Activity[0]);
      if ("android.nfc.action.NDEF_DISCOVERED".equals(getIntent().getAction())) {
        a(getIntent());
      }
      b.a.a.c.a().a(this, false);
      return;
    }
    catch (IllegalStateException paramBundle)
    {
      for (;;)
      {
        Log.b("idverification/ ", paramBundle);
      }
    }
    catch (SecurityException paramBundle)
    {
      for (;;) {}
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool = false;
    this.u = paramMenu.add(0, 2131755076, 0, 2131297833).setIcon(2130840077);
    o.a(this.u, 2);
    MenuItem localMenuItem = this.u;
    if (this.q != null) {
      bool = true;
    }
    localMenuItem.setVisible(bool);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    Log.i("idverification/destroy");
    super.onDestroy();
    this.x.quit();
    b.a.a.c.a().a(this);
    this.aq.b(this.F);
  }
  
  public void onEvent(com.whatsapp.g.c paramc)
  {
    if ((this.n != null) && (this.n.t.equals(paramc.a))) {
      n();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    Log.i("idverification/newintent");
    setIntent(paramIntent);
    if ("android.nfc.action.NDEF_DISCOVERED".equals(paramIntent.getAction())) {
      a(paramIntent);
    }
  }
  
  /* Error */
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 1029 1 0
    //   6: ldc_w 982
    //   9: if_icmpne +577 -> 586
    //   12: aload_0
    //   13: invokevirtual 521	com/whatsapp/IdentityVerificationActivity:getWindowManager	()Landroid/view/WindowManager;
    //   16: invokeinterface 527 1 0
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 532	android/view/Display:getWidth	()I
    //   26: aload_1
    //   27: invokevirtual 535	android/view/Display:getHeight	()I
    //   30: invokestatic 541	java/lang/Math:min	(II)I
    //   33: iconst_2
    //   34: imul
    //   35: iconst_3
    //   36: idiv
    //   37: istore 4
    //   39: iload 4
    //   41: iload 4
    //   43: getstatic 1035	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   46: invokestatic 1041	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   49: astore 11
    //   51: new 1043	android/graphics/Canvas
    //   54: dup
    //   55: aload 11
    //   57: invokespecial 1046	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   60: astore_1
    //   61: aload_1
    //   62: iconst_m1
    //   63: invokevirtual 1049	android/graphics/Canvas:drawColor	(I)V
    //   66: aload_0
    //   67: getfield 483	com/whatsapp/IdentityVerificationActivity:v	Lcom/google/c/g/c/e;
    //   70: invokevirtual 1054	com/google/c/g/c/e:a	()Lcom/google/c/g/c/b;
    //   73: astore 9
    //   75: aload 9
    //   77: invokevirtual 1058	com/google/c/g/c/b:b	()I
    //   80: istore 6
    //   82: aload 9
    //   84: invokevirtual 1060	com/google/c/g/c/b:a	()I
    //   87: istore 7
    //   89: iload 4
    //   91: bipush 12
    //   93: idiv
    //   94: istore 8
    //   96: iload 4
    //   98: iload 8
    //   100: iconst_2
    //   101: imul
    //   102: isub
    //   103: istore 4
    //   105: fconst_1
    //   106: iload 4
    //   108: i2f
    //   109: fmul
    //   110: iload 6
    //   112: i2f
    //   113: fdiv
    //   114: fstore_2
    //   115: iload 4
    //   117: i2f
    //   118: fconst_1
    //   119: fmul
    //   120: iload 7
    //   122: i2f
    //   123: fdiv
    //   124: fstore_3
    //   125: new 1062	android/graphics/Paint
    //   128: dup
    //   129: invokespecial 1063	android/graphics/Paint:<init>	()V
    //   132: astore 10
    //   134: aload 10
    //   136: ldc_w 1064
    //   139: invokevirtual 1067	android/graphics/Paint:setColor	(I)V
    //   142: iconst_0
    //   143: istore 4
    //   145: iload 4
    //   147: iload 6
    //   149: if_icmpge +90 -> 239
    //   152: iconst_0
    //   153: istore 5
    //   155: iload 5
    //   157: iload 7
    //   159: if_icmpge +71 -> 230
    //   162: aload 9
    //   164: iload 4
    //   166: iload 5
    //   168: invokevirtual 1070	com/google/c/g/c/b:a	(II)B
    //   171: iconst_1
    //   172: if_icmpne +49 -> 221
    //   175: aload_1
    //   176: iload 8
    //   178: i2f
    //   179: iload 4
    //   181: i2f
    //   182: fload_2
    //   183: fmul
    //   184: fadd
    //   185: iload 8
    //   187: i2f
    //   188: iload 5
    //   190: i2f
    //   191: fload_3
    //   192: fmul
    //   193: fadd
    //   194: iload 8
    //   196: i2f
    //   197: iload 4
    //   199: iconst_1
    //   200: iadd
    //   201: i2f
    //   202: fload_2
    //   203: fmul
    //   204: fadd
    //   205: iload 8
    //   207: i2f
    //   208: iload 5
    //   210: iconst_1
    //   211: iadd
    //   212: i2f
    //   213: fload_3
    //   214: fmul
    //   215: fadd
    //   216: aload 10
    //   218: invokevirtual 1074	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   221: iload 5
    //   223: iconst_1
    //   224: iadd
    //   225: istore 5
    //   227: goto -72 -> 155
    //   230: iload 4
    //   232: iconst_1
    //   233: iadd
    //   234: istore 4
    //   236: goto -91 -> 145
    //   239: aload_0
    //   240: getfield 1078	com/whatsapp/IdentityVerificationActivity:au	Lcom/whatsapp/oz;
    //   243: ldc_w 1080
    //   246: invokevirtual 1085	com/whatsapp/oz:a	(Ljava/lang/String;)Ljava/io/File;
    //   249: astore 10
    //   251: new 1087	java/io/FileOutputStream
    //   254: dup
    //   255: aload 10
    //   257: invokespecial 1090	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   260: astore 9
    //   262: aload 9
    //   264: astore_1
    //   265: aload 11
    //   267: getstatic 1096	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   270: iconst_0
    //   271: aload 9
    //   273: invokevirtual 1100	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   276: pop
    //   277: aload 9
    //   279: invokestatic 1103	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   282: aload 11
    //   284: invokevirtual 1106	android/graphics/Bitmap:recycle	()V
    //   287: new 252	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 487	java/lang/StringBuilder:<init>	()V
    //   294: astore_1
    //   295: aload_0
    //   296: getfield 458	com/whatsapp/IdentityVerificationActivity:w	Ljava/lang/String;
    //   299: invokevirtual 490	java/lang/String:length	()I
    //   302: istore 5
    //   304: iconst_1
    //   305: istore 4
    //   307: iload 4
    //   309: iload 5
    //   311: if_icmpgt +123 -> 434
    //   314: aload_1
    //   315: aload_0
    //   316: getfield 458	com/whatsapp/IdentityVerificationActivity:w	Ljava/lang/String;
    //   319: iload 4
    //   321: iconst_1
    //   322: isub
    //   323: invokevirtual 494	java/lang/String:charAt	(I)C
    //   326: invokevirtual 497	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: iload 4
    //   332: iload 5
    //   334: if_icmpeq +18 -> 352
    //   337: iload 4
    //   339: bipush 20
    //   341: irem
    //   342: ifne +74 -> 416
    //   345: aload_1
    //   346: bipush 10
    //   348: invokevirtual 497	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: iload 4
    //   354: iconst_1
    //   355: iadd
    //   356: istore 4
    //   358: goto -51 -> 307
    //   361: astore 10
    //   363: aconst_null
    //   364: astore 9
    //   366: aload 9
    //   368: astore_1
    //   369: ldc_w 1108
    //   372: aload 10
    //   374: invokestatic 1110	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   377: aload 9
    //   379: astore_1
    //   380: aload_0
    //   381: ldc_w 1111
    //   384: iconst_0
    //   385: invokestatic 1114	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   388: aload 9
    //   390: invokestatic 1103	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   393: aload 11
    //   395: invokevirtual 1106	android/graphics/Bitmap:recycle	()V
    //   398: iconst_1
    //   399: ireturn
    //   400: astore 9
    //   402: aconst_null
    //   403: astore_1
    //   404: aload_1
    //   405: invokestatic 1103	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   408: aload 11
    //   410: invokevirtual 1106	android/graphics/Bitmap:recycle	()V
    //   413: aload 9
    //   415: athrow
    //   416: iload 4
    //   418: iconst_5
    //   419: irem
    //   420: ifne -68 -> 352
    //   423: aload_1
    //   424: ldc_w 1116
    //   427: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: goto -79 -> 352
    //   434: new 218	android/content/Intent
    //   437: dup
    //   438: ldc_w 1118
    //   441: ldc_w 1120
    //   444: invokestatic 1126	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   447: invokespecial 1129	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   450: astore 9
    //   452: aload 9
    //   454: ldc_w 1131
    //   457: aload_0
    //   458: ldc_w 1132
    //   461: iconst_2
    //   462: anewarray 269	java/lang/Object
    //   465: dup
    //   466: iconst_0
    //   467: aload_0
    //   468: getfield 104	com/whatsapp/IdentityVerificationActivity:E	Lcom/whatsapp/atv;
    //   471: invokevirtual 1134	com/whatsapp/atv:l	()Ljava/lang/String;
    //   474: aastore
    //   475: dup
    //   476: iconst_1
    //   477: aload_0
    //   478: getfield 76	com/whatsapp/IdentityVerificationActivity:s	Lcom/whatsapp/va;
    //   481: invokevirtual 194	com/whatsapp/va:b	()Ljava/lang/String;
    //   484: invokestatic 1135	com/whatsapp/data/cs:a	(Ljava/lang/String;)Ljava/lang/String;
    //   487: aastore
    //   488: invokevirtual 278	com/whatsapp/IdentityVerificationActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   491: invokevirtual 1138	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   494: pop
    //   495: aload 9
    //   497: ldc_w 1140
    //   500: new 252	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 487	java/lang/StringBuilder:<init>	()V
    //   507: aload_0
    //   508: ldc_w 1141
    //   511: invokevirtual 616	com/whatsapp/IdentityVerificationActivity:getString	(I)Ljava/lang/String;
    //   514: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: ldc_w 1143
    //   520: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: aload_1
    //   524: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokevirtual 1138	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   536: pop
    //   537: aload 9
    //   539: ldc_w 1145
    //   542: aload_0
    //   543: invokevirtual 1149	com/whatsapp/IdentityVerificationActivity:getApplicationContext	()Landroid/content/Context;
    //   546: aload 10
    //   548: invokestatic 1154	a/a/a/a/d:a	(Landroid/content/Context;Ljava/io/File;)Landroid/net/Uri;
    //   551: invokevirtual 1157	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   554: pop
    //   555: aload 9
    //   557: ldc_w 1159
    //   560: invokevirtual 1163	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
    //   563: pop
    //   564: aload 9
    //   566: ldc_w 1164
    //   569: invokevirtual 1168	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   572: pop
    //   573: aload_0
    //   574: aload 9
    //   576: aconst_null
    //   577: invokestatic 1172	android/content/Intent:createChooser	(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;
    //   580: invokevirtual 1175	com/whatsapp/IdentityVerificationActivity:startActivity	(Landroid/content/Intent;)V
    //   583: goto -185 -> 398
    //   586: aload_1
    //   587: invokeinterface 1029 1 0
    //   592: ldc_w 1176
    //   595: if_icmpne +9 -> 604
    //   598: aload_0
    //   599: invokevirtual 1177	com/whatsapp/IdentityVerificationActivity:finish	()V
    //   602: iconst_1
    //   603: ireturn
    //   604: aload_0
    //   605: aload_1
    //   606: invokespecial 1179	com/whatsapp/nh:onOptionsItemSelected	(Landroid/view/MenuItem;)Z
    //   609: ireturn
    //   610: astore 9
    //   612: goto -208 -> 404
    //   615: astore 10
    //   617: goto -251 -> 366
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	620	0	this	IdentityVerificationActivity
    //   0	620	1	paramMenuItem	MenuItem
    //   114	89	2	f1	float
    //   124	90	3	f2	float
    //   37	383	4	i	int
    //   153	182	5	j	int
    //   80	70	6	k	int
    //   87	73	7	m	int
    //   94	112	8	i1	int
    //   73	316	9	localObject1	Object
    //   400	14	9	localObject2	Object
    //   450	125	9	localIntent	Intent
    //   610	1	9	localObject3	Object
    //   132	124	10	localObject4	Object
    //   361	186	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   615	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   49	360	11	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   251	262	361	java/io/FileNotFoundException
    //   251	262	400	finally
    //   265	277	610	finally
    //   369	377	610	finally
    //   380	388	610	finally
    //   265	277	615	java/io/FileNotFoundException
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.o.getVisibility() == 0) {
      this.o.setVisibility(4);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.o.getVisibility() == 4) {
      this.o.setVisibility(0);
    }
  }
  
  public static class QrImageView
    extends View
  {
    private static final Random e = new Random();
    private com.google.c.g.c.e a;
    private ArrayList<Integer> b;
    private a c;
    private Paint d = new Paint();
    
    public QrImageView(Context paramContext)
    {
      super();
    }
    
    public QrImageView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public QrImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    @TargetApi(21)
    public QrImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
      super(paramAttributeSet, paramInt1, paramInt2);
    }
    
    private void b()
    {
      if (this.b == null)
      {
        int i = this.a.a().b();
        int j = this.a.a().a() * i;
        this.b = new ArrayList(j);
        i = 0;
        while (i < j)
        {
          this.b.add(Integer.valueOf(i));
          i += 1;
        }
      }
      this.c = new a((byte)0);
      this.c.setDuration(1200L);
      this.c.setInterpolator(new LinearInterpolator());
      startAnimation(this.c);
    }
    
    private void setQrCode(com.google.c.g.c.e parame)
    {
      this.a = parame;
      if ((ab.H(this)) && (parame != null)) {
        b();
      }
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      if (this.a != null) {
        b();
      }
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      this.b = null;
      clearAnimation();
    }
    
    public void onDraw(Canvas paramCanvas)
    {
      if (this.a == null) {}
      for (;;)
      {
        return;
        Object localObject = this.a.a();
        int k = ((com.google.c.g.c.b)localObject).b();
        int m = ((com.google.c.g.c.b)localObject).a();
        int i = getWidth() - getPaddingLeft() - getPaddingRight();
        int j = getHeight() - getPaddingTop() - getPaddingBottom();
        float f1 = 1.0F * i / k;
        float f2 = 1.0F * j / m;
        this.d.setColor(-1);
        paramCanvas.drawRect(getPaddingLeft(), getPaddingTop(), i + getPaddingLeft(), getPaddingTop() + j, this.d);
        this.d.setColor(-16777216);
        i = 0;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        while (i < k)
        {
          j = 0;
          while (j < m)
          {
            if (((com.google.c.g.c.b)localObject).a(i, j) == 1)
            {
              f3 = getPaddingLeft();
              f4 = i;
              f5 = getPaddingTop();
              f6 = j;
              f7 = getPaddingLeft();
              float f8 = i + 1;
              float f9 = getPaddingTop();
              paramCanvas.drawRect(f4 * f1 + f3, f6 * f2 + f5, f8 * f1 + f7, (j + 1) * f2 + f9, this.d);
            }
            j += 1;
          }
          i += 1;
        }
        this.d.setColor(-1);
        localObject = this.b.iterator();
        while (((Iterator)localObject).hasNext())
        {
          j = ((Integer)((Iterator)localObject).next()).intValue();
          i = j % k;
          j /= k;
          f3 = getPaddingLeft();
          f4 = i;
          f5 = getPaddingTop();
          f6 = j;
          f7 = getPaddingLeft();
          paramCanvas.drawRect(f3 + f4 * f1, f5 + f6 * f2, (i + 1) * f1 + f7, getPaddingTop() + (j + 1) * f2, this.d);
        }
      }
    }
    
    final class a
      extends Animation
    {
      private a() {}
      
      protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
      {
        if (paramFloat == 1.0F)
        {
          IdentityVerificationActivity.QrImageView.a(IdentityVerificationActivity.QrImageView.this).clear();
          IdentityVerificationActivity.QrImageView.this.invalidate();
          return;
        }
        if (paramFloat > 0.25F) {}
        for (paramFloat = (paramFloat - 0.25F) / 0.75F;; paramFloat = 0.0F)
        {
          int i = (int)((1.0F - paramFloat) * (IdentityVerificationActivity.QrImageView.b(IdentityVerificationActivity.QrImageView.this).a().b() * IdentityVerificationActivity.QrImageView.b(IdentityVerificationActivity.QrImageView.this).a().a()));
          while (IdentityVerificationActivity.QrImageView.a(IdentityVerificationActivity.QrImageView.this).size() > i) {
            IdentityVerificationActivity.QrImageView.a(IdentityVerificationActivity.QrImageView.this).remove(IdentityVerificationActivity.QrImageView.a().nextInt(IdentityVerificationActivity.QrImageView.a(IdentityVerificationActivity.QrImageView.this).size()));
          }
          break;
        }
      }
    }
  }
  
  static enum a
  {
    private a() {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/IdentityVerificationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */