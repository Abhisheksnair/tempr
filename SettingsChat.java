package com.whatsapp;

import a.a.a.a.d;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.support.v4.f.h;
import android.support.v7.app.b.a;
import android.text.TextUtils;
import com.whatsapp.data.ad;
import com.whatsapp.data.ad.c;
import com.whatsapp.data.cb;
import com.whatsapp.data.v;
import com.whatsapp.data.v.c;
import com.whatsapp.gdrive.GoogleDriveService;
import com.whatsapp.messaging.w;
import com.whatsapp.preference.WaLanguageListPreference;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.bu;
import com.whatsapp.util.l;
import com.whatsapp.wallpaper.g;
import java.util.Calendar;
import java.util.Locale;

public class SettingsChat
  extends nn
{
  private static acy n;
  private WaLanguageListPreference o;
  private int p;
  private final vv.a q = new vv.a()
  {
    private void e()
    {
      RequestPermissionActivity.b(SettingsChat.this, 2131297425, 2131297424);
    }
    
    public final void a()
    {
      Log.i("settings-chat/readonly-external-storage-readonly");
      SettingsChat localSettingsChat = SettingsChat.this;
      if (vv.i()) {}
      for (int i = 2131297502;; i = 2131297503)
      {
        localSettingsChat.a(2131297202, i, new Object[0]);
        return;
      }
    }
    
    public final void b()
    {
      Log.i("settings-chat/external-storage-unavailable");
      d.a(SettingsChat.this, 602);
    }
    
    public final void c()
    {
      Log.i("settings-chat/external-storage-unavailable-permission");
      e();
    }
    
    public final void d()
    {
      Log.i("settings-chat/readonly-external-storage-readonly-permission");
      e();
    }
  };
  private final w r = w.a();
  private final v s = v.a();
  
  public static Dialog a(Context paramContext)
  {
    long l = i().getTimeInMillis();
    acy localacy = new acy(paramContext);
    n = localacy;
    localacy.setTitle(paramContext.getString(2131297195));
    n.setMessage(paramContext.getString(2131297704, new Object[] { l.c(paramContext, l) }));
    n.setIndeterminate(true);
    n.setCancelable(false);
    return n;
  }
  
  public static String a(ad paramad, Context paramContext, aus paramaus)
  {
    Log.d("settings-chat/lastbackup/look at files");
    long l = paramad.c.h();
    if (l != -1L) {
      Log.d("settings-chat/lastbackup/fromfiles/set to " + l);
    }
    if (l == 0L) {
      return paramContext.getString(2131297272);
    }
    if (l == -1L) {
      return paramContext.getString(2131298061);
    }
    return l.g(paramContext, paramaus, l);
  }
  
  public static void a(Activity paramActivity, final ng paramng, final v paramv, final w paramw, final vv paramvv, final atu paramatu, final Runnable paramRunnable)
  {
    paramv.a(false, 3000L, new v.c()
    {
      public final void a()
      {
        d.a(this.a, 600);
      }
      
      public final void a(int paramAnonymousInt)
      {
        if (SettingsChat.c() != null) {
          SettingsChat.c().setMessage(SettingsChat.c().getContext().getString(2131297705, new Object[] { Integer.valueOf(paramAnonymousInt), l.c(SettingsChat.c().getContext(), SettingsChat.h().getTimeInMillis()) }));
        }
        if (paramAnonymousInt % 10 == 0) {
          Log.i(String.format(Locale.ENGLISH, "settings/backup/msgstore/progress/%d%%", new Object[] { Integer.valueOf(paramAnonymousInt) }));
        }
      }
      
      public final void a(ad.c paramAnonymousc)
      {
        paramv.a(this);
        d.b(this.a, 600);
        Object localObject;
        if (paramAnonymousc == ad.c.d)
        {
          r.m();
          paramAnonymousc = r.e();
          localObject = r.a(paramAnonymousc);
          if (localObject != null)
          {
            paramw.a((byte[])localObject, paramAnonymousc, null);
            paramng.b_(2131297199);
            Log.i("settings/backup/failed/missing-or-mismatch");
          }
        }
        do
        {
          return;
          paramng.b_(2131297196);
          Log.w("settings/backup/failed/null");
          return;
          if (paramAnonymousc == ad.c.a)
          {
            paramRunnable.run();
            return;
          }
          if (paramAnonymousc == ad.c.c)
          {
            localObject = paramng;
            if (vv.i()) {}
            for (paramAnonymousc = this.a.getString(2131297197) + " " + this.a.getString(2131297601);; paramAnonymousc = this.a.getString(2131297198) + " " + this.a.getString(2131297602))
            {
              ((ng)localObject).d(paramAnonymousc);
              return;
            }
          }
          if (paramAnonymousc == ad.c.b)
          {
            paramng.b_(2131297196);
            Log.w("settings/backup/failed/null");
            return;
          }
        } while (paramatu.b());
        Log.i("settings/backup/failed/missing-permissions");
        paramng.b_(2131297196);
      }
    });
  }
  
  private void a(Uri paramUri, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramUri != null) {
      this.h.a(this, false, -1, false, -1, paramUri, 0, 0);
    }
    for (;;)
    {
      MediaFileUtils.a(this, paramUri);
      pv.a(this, getString(2131298189), 0);
      return;
      if (paramInt2 == -1) {
        this.h.a(this, true, paramInt1, false, -1, null, 0, 0);
      } else {
        this.h.a(this, false, -1, true, paramInt2, null, paramInt3, paramInt4);
      }
    }
  }
  
  public static void a(pv parampv)
  {
    parampv = parampv.e;
    if ((parampv instanceof SettingsChat)) {
      ((SettingsChat)parampv).j();
    }
  }
  
  public static Dialog b(Context paramContext)
  {
    int j;
    int i;
    DialogInterface.OnClickListener localOnClickListener;
    if (vv.i()) {
      if ("unmounted".equals(Environment.getExternalStorageState()))
      {
        j = 2131297206;
        i = 2131297205;
        localOnClickListener = ajn.a(paramContext);
        paramContext = new b.a(paramContext).a(j).b(i).a(2131297331, null);
        if (localOnClickListener == null) {
          break label90;
        }
        paramContext = paramContext.a(2131296366, localOnClickListener);
      }
    }
    label90:
    for (;;)
    {
      return paramContext.a();
      j = 2131297204;
      i = 2131297203;
      localOnClickListener = null;
      break;
      j = 2131297202;
      i = 2131297294;
      localOnClickListener = null;
      break;
    }
  }
  
  private static Calendar i()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(14, 0);
    localCalendar.set(13, 0);
    localCalendar.set(12, 0);
    localCalendar.set(11, 2);
    return localCalendar;
  }
  
  private void j()
  {
    Preference localPreference = findPreference("settings_backup");
    String str = a(ad.a(), this, this.g);
    if ((localPreference != null) && (!GoogleDriveService.c()))
    {
      localPreference.setTitle(2131297782);
      if (this.j.b()) {
        localPreference.setSummary(String.format(getString(2131297784), new Object[] { str }));
      }
    }
    else
    {
      return;
    }
    localPreference.setSummary(2131297783);
  }
  
  private boolean k()
  {
    Me localMe = this.b.b;
    return (!TextUtils.isEmpty(localMe.cc)) && (localMe.cc.equals("91"));
  }
  
  /* Error */
  protected void onActivityResult(int paramInt1, int paramInt2, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: iload_2
    //   7: ifne +109 -> 116
    //   10: aload_3
    //   11: ifnull +105 -> 116
    //   14: aload_3
    //   15: ldc_w 394
    //   18: iconst_0
    //   19: invokevirtual 398	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   22: ifeq +26 -> 48
    //   25: ldc_w 400
    //   28: invokestatic 402	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 405	com/whatsapp/SettingsChat:a	Lcom/whatsapp/pv;
    //   35: aload_0
    //   36: invokestatic 410	com/whatsapp/u:a	()Landroid/content/Context;
    //   39: ldc_w 411
    //   42: invokevirtual 75	android/content/Context:getString	(I)Ljava/lang/String;
    //   45: invokevirtual 414	com/whatsapp/pv:a	(Lcom/whatsapp/ng;Ljava/lang/String;)V
    //   48: aload_3
    //   49: ldc_w 416
    //   52: iconst_0
    //   53: invokevirtual 398	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   56: ifeq +26 -> 82
    //   59: ldc_w 418
    //   62: invokestatic 402	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   65: aload_0
    //   66: getfield 405	com/whatsapp/SettingsChat:a	Lcom/whatsapp/pv;
    //   69: aload_0
    //   70: invokestatic 410	com/whatsapp/u:a	()Landroid/content/Context;
    //   73: ldc_w 419
    //   76: invokevirtual 75	android/content/Context:getString	(I)Ljava/lang/String;
    //   79: invokevirtual 414	com/whatsapp/pv:a	(Lcom/whatsapp/ng;Ljava/lang/String;)V
    //   82: aload_3
    //   83: ldc_w 421
    //   86: iconst_0
    //   87: invokevirtual 398	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   90: ifeq +26 -> 116
    //   93: ldc_w 423
    //   96: invokestatic 402	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 405	com/whatsapp/SettingsChat:a	Lcom/whatsapp/pv;
    //   103: aload_0
    //   104: invokestatic 410	com/whatsapp/u:a	()Landroid/content/Context;
    //   107: ldc_w 424
    //   110: invokevirtual 75	android/content/Context:getString	(I)Ljava/lang/String;
    //   113: invokevirtual 414	com/whatsapp/pv:a	(Lcom/whatsapp/ng;Ljava/lang/String;)V
    //   116: iload_1
    //   117: tableswitch	default:+23->140, 17:+82->199, 18:+31->148
    //   140: aload_0
    //   141: iload_1
    //   142: iload_2
    //   143: aload_3
    //   144: invokespecial 426	com/whatsapp/nn:onActivityResult	(IILandroid/content/Intent;)V
    //   147: return
    //   148: iload_2
    //   149: iconst_m1
    //   150: if_icmpne +29 -> 179
    //   153: aload_3
    //   154: ifnull +25 -> 179
    //   157: aload_3
    //   158: invokevirtual 430	android/content/Intent:getData	()Landroid/net/Uri;
    //   161: ifnull +18 -> 179
    //   164: aload_0
    //   165: aload_3
    //   166: invokevirtual 430	android/content/Intent:getData	()Landroid/net/Uri;
    //   169: iconst_m1
    //   170: iconst_m1
    //   171: iconst_0
    //   172: iconst_0
    //   173: invokespecial 432	com/whatsapp/SettingsChat:a	(Landroid/net/Uri;IIII)V
    //   176: goto -36 -> 140
    //   179: iload_2
    //   180: ifne -40 -> 140
    //   183: aload_3
    //   184: ifnull -44 -> 140
    //   187: aload_0
    //   188: getfield 405	com/whatsapp/SettingsChat:a	Lcom/whatsapp/pv;
    //   191: aload_3
    //   192: aload_0
    //   193: invokestatic 437	com/whatsapp/crop/CropImage:a	(Lcom/whatsapp/pv;Landroid/content/Intent;Lcom/whatsapp/ng;)V
    //   196: goto -56 -> 140
    //   199: iload_2
    //   200: iconst_m1
    //   201: if_icmpne -61 -> 140
    //   204: aload_3
    //   205: ifnull -65 -> 140
    //   208: aload_0
    //   209: invokestatic 441	com/whatsapp/wallpaper/g:f	(Landroid/content/Context;)Landroid/graphics/Point;
    //   212: astore 9
    //   214: aload_3
    //   215: invokevirtual 430	android/content/Intent:getData	()Landroid/net/Uri;
    //   218: ifnull +353 -> 571
    //   221: new 124	java/lang/StringBuilder
    //   224: dup
    //   225: ldc_w 443
    //   228: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   231: aload_3
    //   232: invokevirtual 430	android/content/Intent:getData	()Landroid/net/Uri;
    //   235: invokevirtual 446	android/net/Uri:toString	()Ljava/lang/String;
    //   238: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 341	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   247: aload_0
    //   248: getfield 452	com/whatsapp/SettingsChat:f	Lcom/whatsapp/and;
    //   251: getfield 457	com/whatsapp/and:f	Landroid/content/ContentResolver;
    //   254: astore 8
    //   256: aload 8
    //   258: ifnonnull +183 -> 441
    //   261: ldc_w 459
    //   264: invokestatic 462	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   267: aconst_null
    //   268: astore 7
    //   270: aload 7
    //   272: ifnull +192 -> 464
    //   275: aload 7
    //   277: invokeinterface 467 1 0
    //   282: pop
    //   283: aload 7
    //   285: ldc_w 469
    //   288: invokeinterface 472 2 0
    //   293: istore 4
    //   295: iload 4
    //   297: iflt +167 -> 464
    //   300: aload 7
    //   302: iload 4
    //   304: invokeinterface 473 2 0
    //   309: ldc_w 475
    //   312: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: ifeq +149 -> 464
    //   318: new 477	android/graphics/BitmapFactory$Options
    //   321: dup
    //   322: invokespecial 478	android/graphics/BitmapFactory$Options:<init>	()V
    //   325: astore 10
    //   327: aload 10
    //   329: iconst_1
    //   330: putfield 481	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   333: aload 8
    //   335: aload_3
    //   336: invokevirtual 430	android/content/Intent:getData	()Landroid/net/Uri;
    //   339: invokevirtual 487	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   342: astore 8
    //   344: aload 8
    //   346: astore 5
    //   348: aload 8
    //   350: astore 6
    //   352: aload 8
    //   354: aconst_null
    //   355: aload 10
    //   357: invokestatic 493	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   360: pop
    //   361: aload 8
    //   363: astore 5
    //   365: aload 8
    //   367: astore 6
    //   369: aload 10
    //   371: getfield 496	android/graphics/BitmapFactory$Options:outWidth	I
    //   374: aload 9
    //   376: getfield 501	android/graphics/Point:x	I
    //   379: if_icmpne +80 -> 459
    //   382: aload 8
    //   384: astore 5
    //   386: aload 8
    //   388: astore 6
    //   390: aload 10
    //   392: getfield 504	android/graphics/BitmapFactory$Options:outHeight	I
    //   395: aload 9
    //   397: getfield 507	android/graphics/Point:y	I
    //   400: if_icmpne +59 -> 459
    //   403: aload 8
    //   405: astore 5
    //   407: aload 8
    //   409: astore 6
    //   411: aload_0
    //   412: aload_3
    //   413: invokevirtual 430	android/content/Intent:getData	()Landroid/net/Uri;
    //   416: iconst_m1
    //   417: iconst_m1
    //   418: iconst_0
    //   419: iconst_0
    //   420: invokespecial 432	com/whatsapp/SettingsChat:a	(Landroid/net/Uri;IIII)V
    //   423: aload 8
    //   425: invokestatic 512	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   428: aload 7
    //   430: ifnull -283 -> 147
    //   433: aload 7
    //   435: invokeinterface 515 1 0
    //   440: return
    //   441: aload 8
    //   443: aload_3
    //   444: invokevirtual 430	android/content/Intent:getData	()Landroid/net/Uri;
    //   447: aconst_null
    //   448: aconst_null
    //   449: aconst_null
    //   450: aconst_null
    //   451: invokevirtual 519	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   454: astore 7
    //   456: goto -186 -> 270
    //   459: aload 8
    //   461: invokestatic 512	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   464: aload 7
    //   466: ifnull +10 -> 476
    //   469: aload 7
    //   471: invokeinterface 515 1 0
    //   476: new 249	android/content/Intent
    //   479: dup
    //   480: aload_0
    //   481: ldc_w 521
    //   484: invokespecial 524	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   487: astore 5
    //   489: aload 5
    //   491: aload_3
    //   492: invokevirtual 430	android/content/Intent:getData	()Landroid/net/Uri;
    //   495: invokevirtual 528	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   498: pop
    //   499: aload 5
    //   501: ldc_w 530
    //   504: aload_0
    //   505: getfield 155	com/whatsapp/SettingsChat:h	Lcom/whatsapp/wallpaper/g;
    //   508: invokevirtual 532	com/whatsapp/wallpaper/g:b	()Landroid/net/Uri;
    //   511: invokevirtual 536	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   514: pop
    //   515: aload_0
    //   516: aload 5
    //   518: bipush 18
    //   520: invokevirtual 540	com/whatsapp/SettingsChat:startActivityForResult	(Landroid/content/Intent;I)V
    //   523: goto -383 -> 140
    //   526: astore 8
    //   528: aload 5
    //   530: astore 6
    //   532: ldc_w 542
    //   535: aload 8
    //   537: invokestatic 545	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   540: aload 5
    //   542: invokestatic 512	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   545: goto -81 -> 464
    //   548: astore_3
    //   549: aload 7
    //   551: ifnull +10 -> 561
    //   554: aload 7
    //   556: invokeinterface 515 1 0
    //   561: aload_3
    //   562: athrow
    //   563: astore_3
    //   564: aload 6
    //   566: invokestatic 512	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   569: aload_3
    //   570: athrow
    //   571: aload_3
    //   572: ldc_w 547
    //   575: iconst_0
    //   576: invokevirtual 551	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   579: istore 4
    //   581: iload 4
    //   583: ifeq +79 -> 662
    //   586: new 124	java/lang/StringBuilder
    //   589: dup
    //   590: ldc_w 553
    //   593: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   596: iload 4
    //   598: invokevirtual 556	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   601: ldc_w 558
    //   604: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: aload 9
    //   609: getfield 501	android/graphics/Point:x	I
    //   612: invokevirtual 556	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   615: ldc_w 560
    //   618: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: aload 9
    //   623: getfield 507	android/graphics/Point:y	I
    //   626: invokevirtual 556	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   629: ldc_w 562
    //   632: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 341	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   641: aload_0
    //   642: aconst_null
    //   643: iconst_m1
    //   644: iload 4
    //   646: aload 9
    //   648: getfield 501	android/graphics/Point:x	I
    //   651: aload 9
    //   653: getfield 507	android/graphics/Point:y	I
    //   656: invokespecial 432	com/whatsapp/SettingsChat:a	(Landroid/net/Uri;IIII)V
    //   659: goto -519 -> 140
    //   662: aload_3
    //   663: ldc_w 564
    //   666: invokevirtual 568	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   669: ifeq +47 -> 716
    //   672: aload_3
    //   673: ldc_w 564
    //   676: iconst_0
    //   677: invokevirtual 551	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   680: istore 4
    //   682: new 124	java/lang/StringBuilder
    //   685: dup
    //   686: ldc_w 570
    //   689: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   692: iload 4
    //   694: invokevirtual 556	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   697: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 341	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   703: aload_0
    //   704: aconst_null
    //   705: iload 4
    //   707: iconst_m1
    //   708: iconst_0
    //   709: iconst_0
    //   710: invokespecial 432	com/whatsapp/SettingsChat:a	(Landroid/net/Uri;IIII)V
    //   713: goto -573 -> 140
    //   716: aload_3
    //   717: ldc_w 572
    //   720: iconst_0
    //   721: invokevirtual 398	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   724: ifeq +32 -> 756
    //   727: aload_0
    //   728: getfield 155	com/whatsapp/SettingsChat:h	Lcom/whatsapp/wallpaper/g;
    //   731: aload_0
    //   732: invokevirtual 574	com/whatsapp/wallpaper/g:b	(Landroid/content/Context;)V
    //   735: aload_0
    //   736: aload_0
    //   737: ldc_w 575
    //   740: invokevirtual 167	com/whatsapp/SettingsChat:getString	(I)Ljava/lang/String;
    //   743: iconst_0
    //   744: invokestatic 172	com/whatsapp/pv:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   747: ldc_w 577
    //   750: invokestatic 341	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   753: goto -613 -> 140
    //   756: aload_3
    //   757: ldc_w 579
    //   760: iconst_0
    //   761: invokevirtual 398	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   764: ifeq +31 -> 795
    //   767: aload_0
    //   768: getfield 155	com/whatsapp/SettingsChat:h	Lcom/whatsapp/wallpaper/g;
    //   771: aload_0
    //   772: invokevirtual 581	com/whatsapp/wallpaper/g:c	(Landroid/content/Context;)V
    //   775: aload_0
    //   776: aload_0
    //   777: ldc -90
    //   779: invokevirtual 167	com/whatsapp/SettingsChat:getString	(I)Ljava/lang/String;
    //   782: iconst_0
    //   783: invokestatic 172	com/whatsapp/pv:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   786: ldc_w 583
    //   789: invokestatic 341	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   792: goto -652 -> 140
    //   795: aload_0
    //   796: aload_0
    //   797: ldc_w 584
    //   800: invokevirtual 167	com/whatsapp/SettingsChat:getString	(I)Ljava/lang/String;
    //   803: iconst_0
    //   804: invokestatic 172	com/whatsapp/pv:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   807: new 124	java/lang/StringBuilder
    //   810: dup
    //   811: ldc_w 586
    //   814: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   817: aload_3
    //   818: invokevirtual 587	android/content/Intent:toString	()Ljava/lang/String;
    //   821: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: invokestatic 402	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   830: goto -690 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	833	0	this	SettingsChat
    //   0	833	1	paramInt1	int
    //   0	833	2	paramInt2	int
    //   0	833	3	paramIntent	android.content.Intent
    //   293	413	4	i	int
    //   4	537	5	localObject1	Object
    //   1	564	6	localObject2	Object
    //   268	287	7	localCursor	android.database.Cursor
    //   254	206	8	localObject3	Object
    //   526	10	8	localFileNotFoundException	java.io.FileNotFoundException
    //   212	440	9	localPoint	android.graphics.Point
    //   325	66	10	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   333	344	526	java/io/FileNotFoundException
    //   352	361	526	java/io/FileNotFoundException
    //   369	382	526	java/io/FileNotFoundException
    //   390	403	526	java/io/FileNotFoundException
    //   411	423	526	java/io/FileNotFoundException
    //   275	295	548	finally
    //   300	333	548	finally
    //   423	428	548	finally
    //   459	464	548	finally
    //   540	545	548	finally
    //   564	571	548	finally
    //   333	344	563	finally
    //   352	361	563	finally
    //   369	382	563	finally
    //   390	403	563	finally
    //   411	423	563	finally
    //   532	540	563	finally
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131099655);
    paramBundle = (CheckBoxPreference)findPreference("input_enter_send");
    paramBundle.setOnPreferenceClickListener(ajg.a(paramBundle));
    this.o = ((WaLanguageListPreference)findPreference("settings_language"));
    this.o.setOnPreferenceChangeListener(ajh.a(this));
    paramBundle = (ListPreference)findPreference("interface_font_size");
    paramBundle.setTitle(getString(2131297727, new Object[] { paramBundle.getEntry() }));
    paramBundle.setOnPreferenceChangeListener(aji.a(this));
    findPreference("settings_wallpaper").setOnPreferenceClickListener(ajj.a(this));
    findPreference("settings_chat_history").setOnPreferenceClickListener(ajk.a(this));
    paramBundle = findPreference("settings_backup");
    if (!GoogleDriveService.c())
    {
      j();
      paramBundle.setOnPreferenceClickListener(ajl.a(this));
      return;
    }
    paramBundle.setOnPreferenceClickListener(ajm.a(this));
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    case 601: 
    default: 
      return super.onCreateDialog(paramInt);
    case 600: 
      return a(this);
    }
    return b(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    j();
    if (!k())
    {
      Me localMe = this.b.b;
      if ((!TextUtils.isEmpty(localMe.cc)) && (localMe.cc.equals("880"))) {}
      for (int i = 1; i == 0; i = 0)
      {
        getPreferenceScreen().removePreference(this.o);
        return;
      }
    }
    bu.a(new AsyncTask() {}, new Void[0]);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SettingsChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */