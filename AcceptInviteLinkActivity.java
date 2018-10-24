package com.whatsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.b;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.p;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.messaging.m;
import com.whatsapp.protocol.t;
import com.whatsapp.protocol.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.bu;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AcceptInviteLinkActivity
  extends nh
{
  String n;
  private final va o = va.a();
  private final com.whatsapp.data.d p = com.whatsapp.data.d.a();
  private final ad q = ad.a();
  private final com.whatsapp.data.e r = com.whatsapp.data.e.a();
  private final m s = m.a();
  private final rh t = rh.a();
  private final di.e u = di.a().b();
  private final hx v = hx.a();
  private final hx.a w = new hx.a()
  {
    public final void a()
    {
      Log.i("acceptlink/onConversationsListChanged");
      if (AcceptInviteLinkActivity.a(AcceptInviteLinkActivity.this) != null) {
        AcceptInviteLinkActivity.this.runOnUiThread(e.a(this));
      }
    }
    
    public final void a(String paramAnonymousString)
    {
      Log.i("acceptlink/onConversationChanged/" + paramAnonymousString);
      if ((AcceptInviteLinkActivity.a(AcceptInviteLinkActivity.this) != null) && (AcceptInviteLinkActivity.a(AcceptInviteLinkActivity.this).equals(paramAnonymousString))) {
        AcceptInviteLinkActivity.this.runOnUiThread(f.a(this));
      }
    }
  };
  private b x;
  private Runnable y;
  
  public static String a(Uri paramUri)
  {
    String str2 = null;
    String str1;
    if (paramUri == null) {
      str1 = str2;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return str1;
              if (!"whatsapp".equals(paramUri.getScheme())) {
                break;
              }
              str1 = str2;
            } while (!"chat".equals(paramUri.getHost()));
            str2 = paramUri.getQueryParameter("code");
            str1 = str2;
          } while (str2 != null);
          return paramUri.getLastPathSegment();
          if ("http".equals(paramUri.getScheme())) {
            break;
          }
          str1 = str2;
        } while (!"https".equals(paramUri.getScheme()));
        if ("chat.whatsapp.com".equals(paramUri.getHost())) {
          return paramUri.getLastPathSegment();
        }
        str1 = str2;
      } while (!"whatsapp.com".equals(paramUri.getHost()));
      str1 = str2;
    } while (!"chat".equals(paramUri.getLastPathSegment()));
    return paramUri.getQueryParameter("code");
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    Object localObject = paramIntent.getData();
    String str = paramIntent.getAction();
    if ("android.nfc.action.NDEF_DISCOVERED".equals(str))
    {
      localObject = (NdefMessage)paramIntent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES")[0];
      if (!"application/com.whatsapp.join".equals(new String(localObject.getRecords()[0].getType(), Charset.forName("US-ASCII")))) {
        break label174;
      }
      localObject = new String(localObject.getRecords()[0].getPayload(), Charset.forName("US-ASCII"));
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        Log.e("acceptlink/nfc/no-code");
        if (localObject != null)
        {
          paramIntent.setData(null);
          paramIntent = new Intent(paramActivity, AcceptInviteLinkActivity.class);
          paramIntent.putExtra("code", (String)localObject);
          paramActivity.startActivity(paramIntent);
        }
        return;
      }
      Log.i("acceptlink/nfc/code/" + (String)localObject);
    }
    for (;;)
    {
      break;
      if ("android.intent.action.VIEW".equals(str))
      {
        localObject = a((Uri)localObject);
        break;
      }
      localObject = null;
      break;
      label174:
      localObject = null;
    }
  }
  
  protected void onCreate(final Bundle paramBundle)
  {
    Log.i("acceptlink/create");
    super.onCreate(paramBundle);
    setContentView(2130903068);
    paramBundle = findViewById(2131755223);
    paramBundle.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        paramBundle.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        localTranslateAnimation.setDuration(200L);
        paramBundle.startAnimation(localTranslateAnimation);
      }
    });
    paramBundle = (RecyclerView)findViewById(2131755233);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this);
    localLinearLayoutManager.b(0);
    paramBundle.setLayoutManager(localLinearLayoutManager);
    this.x = new b();
    paramBundle.setAdapter(this.x);
    findViewById(2131755222).setOnClickListener(a.a(this));
    paramBundle = getIntent().getStringExtra("code");
    if (TextUtils.isEmpty(paramBundle))
    {
      pv.a(this, 2131296778, 1);
      finish();
    }
    for (;;)
    {
      this.v.registerObserver(this.w);
      if (Build.VERSION.SDK_INT >= 21)
      {
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(b.c(this, 2131623964));
      }
      return;
      Log.i("acceptlink/processcode/" + paramBundle);
      bu.a(new AsyncTask()
      {
        AcceptInviteLinkActivity.a a;
        int b;
        
        /* Error */
        private Void a()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 23	com/whatsapp/AcceptInviteLinkActivity$3:d	Lcom/whatsapp/AcceptInviteLinkActivity;
          //   4: invokestatic 39	com/whatsapp/AcceptInviteLinkActivity:c	(Lcom/whatsapp/AcceptInviteLinkActivity;)Lcom/whatsapp/messaging/m;
          //   7: ldc2_w 40
          //   10: invokevirtual 46	com/whatsapp/messaging/m:a	(J)V
          //   13: invokestatic 52	android/os/SystemClock:elapsedRealtime	()J
          //   16: lstore_1
          //   17: aload_0
          //   18: getfield 23	com/whatsapp/AcceptInviteLinkActivity$3:d	Lcom/whatsapp/AcceptInviteLinkActivity;
          //   21: getfield 56	com/whatsapp/AcceptInviteLinkActivity:ay	Lcom/whatsapp/messaging/w;
          //   24: aload_0
          //   25: getfield 25	com/whatsapp/AcceptInviteLinkActivity$3:c	Ljava/lang/String;
          //   28: new 9	com/whatsapp/AcceptInviteLinkActivity$3$1
          //   31: dup
          //   32: aload_0
          //   33: invokespecial 59	com/whatsapp/AcceptInviteLinkActivity$3$1:<init>	(Lcom/whatsapp/AcceptInviteLinkActivity$3;)V
          //   36: invokevirtual 64	com/whatsapp/messaging/w:a	(Ljava/lang/String;Lcom/whatsapp/protocol/t;)Ljava/util/concurrent/Future;
          //   39: astore_3
          //   40: aload_3
          //   41: ifnonnull +10 -> 51
          //   44: ldc 66
          //   46: invokestatic 72	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
          //   49: aconst_null
          //   50: areturn
          //   51: aload_3
          //   52: ldc2_w 40
          //   55: getstatic 78	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
          //   58: invokeinterface 84 4 0
          //   63: pop
          //   64: invokestatic 52	android/os/SystemClock:elapsedRealtime	()J
          //   67: lload_1
          //   68: lsub
          //   69: lstore_1
          //   70: lload_1
          //   71: ldc2_w 85
          //   74: lcmp
          //   75: ifge -26 -> 49
          //   78: ldc2_w 85
          //   81: lload_1
          //   82: lsub
          //   83: invokestatic 91	java/lang/Thread:sleep	(J)V
          //   86: aconst_null
          //   87: areturn
          //   88: astore_3
          //   89: aload_3
          //   90: invokevirtual 94	java/lang/InterruptedException:printStackTrace	()V
          //   93: aconst_null
          //   94: areturn
          //   95: astore_3
          //   96: ldc 96
          //   98: invokestatic 99	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
          //   101: aconst_null
          //   102: areturn
          //   103: astore_3
          //   104: aconst_null
          //   105: areturn
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	106	0	this	3
          //   16	66	1	l	long
          //   39	13	3	localFuture	java.util.concurrent.Future
          //   88	2	3	localInterruptedException	InterruptedException
          //   95	1	3	localException	Exception
          //   103	1	3	localzg	zg
          // Exception table:
          //   from	to	target	type
          //   78	86	88	java/lang/InterruptedException
          //   51	64	95	java/lang/Exception
          //   0	13	103	com/whatsapp/zg
        }
      }, new Void[0]);
    }
  }
  
  public void onDestroy()
  {
    Log.i("acceptlink/destroy");
    super.onDestroy();
    this.v.unregisterObserver(this.w);
    if (this.y != null) {
      this.aq.b(this.y);
    }
    this.u.a();
  }
  
  static final class a
  {
    final String a;
    final String b;
    final String c;
    final ArrayList<cs> d;
    
    a(String paramString1, String paramString2, String paramString3, ArrayList<cs> paramArrayList)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramArrayList;
    }
  }
  
  final class b
    extends RecyclerView.a<AcceptInviteLinkActivity.c>
  {
    List<cs> c;
    
    b() {}
    
    public final int a()
    {
      if (this.c == null) {
        return 0;
      }
      return this.c.size();
    }
  }
  
  static final class c
    extends RecyclerView.p
  {
    private final ImageView n;
    private final TextView o;
    
    private c(View paramView)
    {
      super();
      this.n = ((ImageView)paramView.findViewById(2131755236));
      this.o = ((TextView)paramView.findViewById(2131755237));
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/AcceptInviteLinkActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */