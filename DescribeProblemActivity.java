package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.support.v7.app.a;
import android.util.Pair;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.whatsapp.fieldstats.events.p;
import com.whatsapp.fieldstats.l;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.MediaFileUtils.e;
import com.whatsapp.util.bu;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;

public class DescribeProblemActivity
  extends nh
{
  public static final String n;
  String o;
  int p;
  boolean q;
  b r;
  Uri[] s = new Uri[3];
  private String u;
  private String v;
  private EditText w;
  private a x;
  private final cc y = cc.a();
  private final vv z = vv.a();
  
  static
  {
    if (!DescribeProblemActivity.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      t = bool;
      n = au.b() + ".intent.action.REMOVE_SCREENSHOT";
      return;
    }
  }
  
  private void a(int paramInt, Uri paramUri)
  {
    this.s[paramInt] = paramUri;
    ImageView localImageView = (ImageView)((LinearLayout)a.d.a((LinearLayout)findViewById(2131755695))).getChildAt(paramInt);
    if (paramUri != null)
    {
      paramInt = getWindowManager().getDefaultDisplay().getWidth() / 3;
      try
      {
        Bitmap localBitmap = MediaFileUtils.a(this.aE, paramUri, paramInt / 2, paramInt);
        if (localBitmap != null)
        {
          localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          localImageView.setImageBitmap(localBitmap);
          return;
        }
        Log.e("descprob/screenshot/null-bitmap " + paramUri);
        b_(2131296737);
        return;
      }
      catch (IOException localIOException)
      {
        Log.d("descprob/screenshot/io-exception " + paramUri, localIOException);
        b_(2131296737);
        return;
      }
      catch (MediaFileUtils.e locale)
      {
        Log.e("descprob/screenshot/not-an-image " + paramUri);
        b_(2131296734);
        return;
      }
    }
    locale.setScaleType(ImageView.ScaleType.CENTER);
    locale.setImageResource(2130840087);
  }
  
  private void a(int paramInt, String paramString)
  {
    p localp = new p();
    localp.a = Integer.valueOf(paramInt);
    localp.g = paramString;
    l.a(this, localp);
  }
  
  final String l()
  {
    return this.w.getText().toString().trim();
  }
  
  final a m()
  {
    if ((this.x != null) && (this.x.getStatus() == AsyncTask.Status.RUNNING)) {
      this.x.cancel(false);
    }
    this.x = new a((byte)0);
    return this.x;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 > 0) && (paramInt1 < 4)) {
      if (paramIntent.getBooleanExtra("is_reset", false)) {
        a(paramInt1 - 1, null);
      }
    }
    while ((paramInt2 != -1) || (paramInt1 != 10))
    {
      return;
      paramIntent = paramIntent.getData();
      if (paramIntent != null) {
        try
        {
          grantUriPermission(au.b(), paramIntent, 1);
          a(paramInt1 - 1, paramIntent);
          return;
        }
        catch (SecurityException localSecurityException)
        {
          for (;;)
          {
            Log.c("descprob/permission", localSecurityException);
          }
        }
      }
      b_(2131296737);
      return;
    }
    finish();
  }
  
  public void onBackPressed()
  {
    a(1, null);
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("descproblem/create");
    super.onCreate(paramBundle);
    Object localObject1 = (a)a.d.a(i());
    ((a)localObject1).a(true);
    ((a)localObject1).c();
    setContentView(2130903192);
    this.w = ((EditText)findViewById(2131755693));
    al.b(this.aq, this.w);
    ((View)a.d.a(findViewById(2131755694))).setOnClickListener(nd.a(this));
    Object localObject2 = getIntent();
    this.u = ((Intent)localObject2).getStringExtra("com.whatsapp.DescribeProblemActivity.from");
    this.v = ((Intent)localObject2).getStringExtra("com.whatsapp.DescribeProblemActivity.serverstatus");
    this.o = ((Intent)localObject2).getStringExtra("com.whatsapp.DescribeProblemActivity.emailAddress");
    this.p = ((Intent)localObject2).getIntExtra("com.whatsapp.DescribeProblemActivity.type", 0);
    if ((this.p == 1) || (this.p == 2)) {
      ((a)localObject1).a(2131296653);
    }
    int i;
    for (;;)
    {
      localObject2 = ((Intent)localObject2).getStringExtra("com.whatsapp.DescribeProblemActivity.description");
      if ((localObject2 != null) && (((String)localObject2).length() > 0))
      {
        this.w.setText((CharSequence)localObject2);
        this.q = true;
      }
      d.a((a)localObject1, this.aq, getString(2131297280), ne.a(this));
      localObject1 = (LinearLayout)a.d.a((LinearLayout)findViewById(2131755695));
      ((LinearLayout)localObject1).removeAllViews();
      int k = getResources().getDimensionPixelSize(2131362049);
      int j = k / 4;
      i = j;
      if (j == 0) {
        i = 1;
      }
      j = 0;
      while (j < 3)
      {
        localObject2 = new ThumbnailButton(this)
        {
          public final void onDraw(Canvas paramAnonymousCanvas)
          {
            if ((!isSelected()) && (!isPressed())) {
              paramAnonymousCanvas.drawColor(getResources().getColor(2131624037));
            }
            super.onDraw(paramAnonymousCanvas);
          }
          
          protected final void onMeasure(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            super.onMeasure(paramAnonymousInt1, paramAnonymousInt2);
            setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth() * 4 / 3);
          }
        };
        ((ThumbnailButton)localObject2).g = true;
        ((ThumbnailButton)localObject2).setBorderSize(i);
        ((ThumbnailButton)localObject2).setBorderColor(getResources().getColor(2131624042));
        ((ThumbnailButton)localObject2).setScaleType(ImageView.ScaleType.CENTER);
        ((ThumbnailButton)localObject2).setImageResource(2130840087);
        ((ThumbnailButton)localObject2).setOnClickListener(nf.a(this, j));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
        localLayoutParams.bottomMargin = k;
        localLayoutParams.rightMargin = k;
        localLayoutParams.topMargin = k;
        localLayoutParams.leftMargin = k;
        ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
        j += 1;
      }
      ((a)localObject1).a(2131296652);
    }
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelableArray("screenshots");
      if ((!t) && (paramBundle == null)) {
        throw new AssertionError();
      }
      i = 0;
      while (i < paramBundle.length)
      {
        if (paramBundle[i] != null) {
          a(i, (Uri)paramBundle[i]);
        }
        i += 1;
      }
    }
    if (this.p == 2) {
      bu.a(m(), new Void[0]);
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 1: 
      localProgressDialog = new ProgressDialog(this);
      localProgressDialog.setMessage(getString(2131297551));
      localProgressDialog.setIndeterminate(true);
      localProgressDialog.setCancelable(false);
      return localProgressDialog;
    }
    ProgressDialog localProgressDialog = new ProgressDialog(this);
    localProgressDialog.setMessage(getString(2131297645));
    localProgressDialog.setIndeterminate(true);
    localProgressDialog.setCancelable(false);
    return localProgressDialog;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.r != null) {
      this.r.cancel(false);
    }
    if (this.x != null) {
      this.x.cancel(false);
    }
    Log.i("descprob/destroy");
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    a(1, null);
    finish();
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    Log.i("descprob/pause");
  }
  
  public void onResume()
  {
    super.onResume();
    Log.i("descprob/resume");
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelableArray("screenshots", this.s);
  }
  
  final class a
    extends AsyncTask<Void, Void, Pair<String, File>>
  {
    private long b;
    private long c;
    private String d;
    private final vv.a e = new vv.a()
    {
      public final void a()
      {
        throw new IllegalStateException("must not be called");
      }
      
      public final void b()
      {
        DescribeProblemActivity.a.a(DescribeProblemActivity.a.this);
        Log.i("describeproblemactivity/externalstorage/avail external storage not calculated, state=" + DescribeProblemActivity.a.b(DescribeProblemActivity.a.this));
      }
      
      public final void c()
      {
        DescribeProblemActivity.a.a(DescribeProblemActivity.a.this);
        Log.i("describeproblemactivity/externalstorage/avail external storage not calculated, permission denied");
      }
      
      public final void d()
      {
        throw new IllegalStateException("must not be called");
      }
    };
    
    private a() {}
    
    protected final void onPreExecute()
    {
      d.a(DescribeProblemActivity.this, 1);
      SharedPreferences localSharedPreferences = DescribeProblemActivity.this.getSharedPreferences("com.whatsapp_preferences", 0);
      Log.i("descprob/priv/last=" + SettingsPrivacy.a(localSharedPreferences.getInt("privacy_last_seen", 0)));
      Log.i("descprob/priv/pic=" + SettingsPrivacy.a(localSharedPreferences.getInt("privacy_profile_photo", 0)));
      Log.i("descprob/priv/status=" + SettingsPrivacy.a(localSharedPreferences.getInt("privacy_status", 0)));
      Log.i("descprob/priv/readreceipts=" + localSharedPreferences.getBoolean("read_receipts_enabled", true));
      DescribeProblemActivity.h(DescribeProblemActivity.this).g("descprob");
    }
  }
  
  final class b
    extends AsyncTask<Void, Void, Void>
  {
    private String b;
    private JSONArray c;
    private long d;
    private long e;
    private String f;
    private final vv.a g = new vv.a()
    {
      public final void a()
      {
        throw new IllegalStateException("must not be called");
      }
      
      public final void b()
      {
        DescribeProblemActivity.b.a(DescribeProblemActivity.b.this);
        Log.i("descprob/search/externalstorage/avail external storage not calculated, state=" + DescribeProblemActivity.b.b(DescribeProblemActivity.b.this));
      }
      
      public final void c()
      {
        DescribeProblemActivity.b.a(DescribeProblemActivity.b.this);
        Log.i("descprob/search/externalstorage/avail external storage not calculated, permission denied");
      }
      
      public final void d()
      {
        throw new IllegalStateException("must not be called");
      }
    };
    private final aus h = aus.a();
    
    private b() {}
    
    /* Error */
    private Void a()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aload_0
      //   4: getfield 27	com/whatsapp/DescribeProblemActivity$b:a	Lcom/whatsapp/DescribeProblemActivity;
      //   7: invokestatic 59	com/whatsapp/DescribeProblemActivity:b	(Lcom/whatsapp/DescribeProblemActivity;)Lcom/whatsapp/vv;
      //   10: pop
      //   11: aload_0
      //   12: invokestatic 64	com/whatsapp/vv:e	()J
      //   15: putfield 66	com/whatsapp/DescribeProblemActivity$b:d	J
      //   18: aload_0
      //   19: invokestatic 72	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
      //   22: putfield 74	com/whatsapp/DescribeProblemActivity$b:f	Ljava/lang/String;
      //   25: aload_0
      //   26: getfield 27	com/whatsapp/DescribeProblemActivity$b:a	Lcom/whatsapp/DescribeProblemActivity;
      //   29: invokestatic 59	com/whatsapp/DescribeProblemActivity:b	(Lcom/whatsapp/DescribeProblemActivity;)Lcom/whatsapp/vv;
      //   32: aload_0
      //   33: getfield 35	com/whatsapp/DescribeProblemActivity$b:g	Lcom/whatsapp/vv$a;
      //   36: invokevirtual 77	com/whatsapp/vv:b	(Lcom/whatsapp/vv$a;)Z
      //   39: ifeq +18 -> 57
      //   42: aload_0
      //   43: getfield 27	com/whatsapp/DescribeProblemActivity$b:a	Lcom/whatsapp/DescribeProblemActivity;
      //   46: invokestatic 59	com/whatsapp/DescribeProblemActivity:b	(Lcom/whatsapp/DescribeProblemActivity;)Lcom/whatsapp/vv;
      //   49: pop
      //   50: aload_0
      //   51: invokestatic 79	com/whatsapp/vv:f	()J
      //   54: putfield 51	com/whatsapp/DescribeProblemActivity$b:e	J
      //   57: aload_0
      //   58: getfield 27	com/whatsapp/DescribeProblemActivity$b:a	Lcom/whatsapp/DescribeProblemActivity;
      //   61: getfield 83	com/whatsapp/DescribeProblemActivity:aw	Lcom/whatsapp/od;
      //   64: aload_0
      //   65: getfield 27	com/whatsapp/DescribeProblemActivity$b:a	Lcom/whatsapp/DescribeProblemActivity;
      //   68: aload_0
      //   69: getfield 27	com/whatsapp/DescribeProblemActivity$b:a	Lcom/whatsapp/DescribeProblemActivity;
      //   72: invokestatic 86	com/whatsapp/DescribeProblemActivity:c	(Lcom/whatsapp/DescribeProblemActivity;)Ljava/lang/String;
      //   75: aload_0
      //   76: getfield 27	com/whatsapp/DescribeProblemActivity$b:a	Lcom/whatsapp/DescribeProblemActivity;
      //   79: invokestatic 88	com/whatsapp/DescribeProblemActivity:d	(Lcom/whatsapp/DescribeProblemActivity;)Ljava/lang/String;
      //   82: aconst_null
      //   83: iconst_1
      //   84: aload_0
      //   85: getfield 51	com/whatsapp/DescribeProblemActivity$b:e	J
      //   88: aload_0
      //   89: getfield 66	com/whatsapp/DescribeProblemActivity$b:d	J
      //   92: aload_0
      //   93: getfield 74	com/whatsapp/DescribeProblemActivity$b:f	Ljava/lang/String;
      //   96: iconst_1
      //   97: invokevirtual 93	com/whatsapp/od:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJJLjava/lang/String;Z)Ljava/lang/String;
      //   100: astore_1
      //   101: new 95	java/lang/StringBuilder
      //   104: dup
      //   105: ldc 97
      //   107: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   110: aload_1
      //   111: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   114: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   117: invokestatic 112	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   120: invokestatic 118	com/whatsapp/aic:j	()Landroid/net/Uri$Builder;
      //   123: ldc 120
      //   125: invokevirtual 126	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
      //   128: astore_2
      //   129: aload_2
      //   130: ldc -128
      //   132: ldc -126
      //   134: invokevirtual 134	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
      //   137: pop
      //   138: aload_2
      //   139: ldc -120
      //   141: aload_0
      //   142: getfield 42	com/whatsapp/DescribeProblemActivity$b:h	Lcom/whatsapp/aus;
      //   145: invokevirtual 138	com/whatsapp/aus:d	()Ljava/lang/String;
      //   148: invokevirtual 134	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
      //   151: pop
      //   152: aload_2
      //   153: ldc -116
      //   155: aload_0
      //   156: getfield 42	com/whatsapp/DescribeProblemActivity$b:h	Lcom/whatsapp/aus;
      //   159: invokevirtual 142	com/whatsapp/aus:c	()Ljava/lang/String;
      //   162: invokevirtual 134	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
      //   165: pop
      //   166: aload_2
      //   167: ldc -112
      //   169: aload_0
      //   170: getfield 146	com/whatsapp/DescribeProblemActivity$b:b	Ljava/lang/String;
      //   173: invokevirtual 134	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
      //   176: pop
      //   177: aload_2
      //   178: ldc -108
      //   180: getstatic 153	android/os/Build:MANUFACTURER	Ljava/lang/String;
      //   183: invokevirtual 134	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
      //   186: pop
      //   187: aload_2
      //   188: ldc -101
      //   190: getstatic 160	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
      //   193: invokevirtual 134	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
      //   196: pop
      //   197: aload_2
      //   198: ldc -94
      //   200: aload_0
      //   201: getfield 27	com/whatsapp/DescribeProblemActivity$b:a	Lcom/whatsapp/DescribeProblemActivity;
      //   204: getfield 166	com/whatsapp/DescribeProblemActivity:aQ	Lcom/whatsapp/atv;
      //   207: invokevirtual 171	com/whatsapp/atv:F	()Ljava/lang/String;
      //   210: invokevirtual 134	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
      //   213: pop
      //   214: aload_2
      //   215: ldc -83
      //   217: invokestatic 176	com/whatsapp/au:d	()Ljava/lang/String;
      //   220: invokevirtual 134	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
      //   223: pop
      //   224: new 178	java/net/URL
      //   227: dup
      //   228: aload_2
      //   229: invokevirtual 179	android/net/Uri$Builder:toString	()Ljava/lang/String;
      //   232: invokespecial 180	java/net/URL:<init>	(Ljava/lang/String;)V
      //   235: astore_2
      //   236: new 95	java/lang/StringBuilder
      //   239: dup
      //   240: ldc -74
      //   242: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   245: aload_2
      //   246: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   249: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   252: invokestatic 187	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
      //   255: aload_2
      //   256: invokevirtual 191	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   259: astore_2
      //   260: aload_2
      //   261: sipush 30000
      //   264: invokevirtual 197	java/net/URLConnection:setConnectTimeout	(I)V
      //   267: aload_2
      //   268: sipush 30000
      //   271: invokevirtual 200	java/net/URLConnection:setReadTimeout	(I)V
      //   274: aload_2
      //   275: checkcast 202	javax/net/ssl/HttpsURLConnection
      //   278: astore 5
      //   280: aload 5
      //   282: ldc -52
      //   284: invokevirtual 207	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   287: aload 5
      //   289: iconst_1
      //   290: invokevirtual 211	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
      //   293: invokestatic 217	java/util/UUID:randomUUID	()Ljava/util/UUID;
      //   296: invokevirtual 218	java/util/UUID:toString	()Ljava/lang/String;
      //   299: astore_3
      //   300: aload 5
      //   302: ldc -36
      //   304: new 95	java/lang/StringBuilder
      //   307: dup
      //   308: ldc -34
      //   310: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   313: aload_3
      //   314: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   317: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   320: invokevirtual 226	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   323: new 228	java/io/BufferedOutputStream
      //   326: dup
      //   327: aload_2
      //   328: invokevirtual 232	java/net/URLConnection:getOutputStream	()Ljava/io/OutputStream;
      //   331: invokespecial 235	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   334: astore 5
      //   336: aload 5
      //   338: new 95	java/lang/StringBuilder
      //   341: dup
      //   342: ldc -19
      //   344: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   347: aload_3
      //   348: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   351: ldc -17
      //   353: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   356: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   359: invokevirtual 245	java/lang/String:getBytes	()[B
      //   362: invokevirtual 249	java/io/BufferedOutputStream:write	([B)V
      //   365: aload 5
      //   367: ldc -5
      //   369: invokevirtual 245	java/lang/String:getBytes	()[B
      //   372: invokevirtual 249	java/io/BufferedOutputStream:write	([B)V
      //   375: aload 5
      //   377: aload_1
      //   378: invokevirtual 245	java/lang/String:getBytes	()[B
      //   381: invokevirtual 249	java/io/BufferedOutputStream:write	([B)V
      //   384: aload 5
      //   386: new 95	java/lang/StringBuilder
      //   389: dup
      //   390: ldc -3
      //   392: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   395: aload_3
      //   396: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   399: ldc -1
      //   401: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   404: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   407: invokevirtual 245	java/lang/String:getBytes	()[B
      //   410: invokevirtual 249	java/io/BufferedOutputStream:write	([B)V
      //   413: aload 5
      //   415: invokevirtual 258	java/io/BufferedOutputStream:flush	()V
      //   418: aload 5
      //   420: invokevirtual 261	java/io/BufferedOutputStream:close	()V
      //   423: aload_2
      //   424: invokevirtual 265	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
      //   427: astore_1
      //   428: new 95	java/lang/StringBuilder
      //   431: dup
      //   432: invokespecial 266	java/lang/StringBuilder:<init>	()V
      //   435: astore 5
      //   437: new 268	java/io/BufferedReader
      //   440: dup
      //   441: new 270	java/io/InputStreamReader
      //   444: dup
      //   445: aload_1
      //   446: invokespecial 273	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   449: invokespecial 276	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   452: astore_2
      //   453: aload_2
      //   454: astore_1
      //   455: aload_2
      //   456: invokevirtual 279	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   459: astore_3
      //   460: aload_3
      //   461: ifnull +76 -> 537
      //   464: aload_2
      //   465: astore_1
      //   466: aload 5
      //   468: aload_3
      //   469: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   472: pop
      //   473: aload_2
      //   474: astore_1
      //   475: aload_2
      //   476: invokevirtual 279	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   479: astore_3
      //   480: goto -20 -> 460
      //   483: astore_1
      //   484: aload_1
      //   485: athrow
      //   486: astore_2
      //   487: aload_1
      //   488: astore_3
      //   489: aload_2
      //   490: astore_1
      //   491: aload_3
      //   492: ifnull +27 -> 519
      //   495: aload 5
      //   497: invokevirtual 261	java/io/BufferedOutputStream:close	()V
      //   500: aload_1
      //   501: athrow
      //   502: astore_3
      //   503: aconst_null
      //   504: astore_2
      //   505: aload_2
      //   506: astore_1
      //   507: ldc -74
      //   509: aload_3
      //   510: invokestatic 282	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   513: aload_2
      //   514: invokestatic 287	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   517: aconst_null
      //   518: areturn
      //   519: aload 5
      //   521: invokevirtual 261	java/io/BufferedOutputStream:close	()V
      //   524: goto -24 -> 500
      //   527: astore_1
      //   528: aload 4
      //   530: astore_2
      //   531: aload_2
      //   532: invokestatic 287	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   535: aload_1
      //   536: athrow
      //   537: aload_2
      //   538: astore_1
      //   539: aload 5
      //   541: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   544: astore_3
      //   545: aload_2
      //   546: astore_1
      //   547: new 95	java/lang/StringBuilder
      //   550: dup
      //   551: ldc_w 289
      //   554: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   557: aload_3
      //   558: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   561: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   564: invokestatic 187	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
      //   567: aload_2
      //   568: astore_1
      //   569: aload_3
      //   570: invokestatic 295	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   573: ifeq +22 -> 595
      //   576: aload_2
      //   577: astore_1
      //   578: aload_0
      //   579: new 297	org/json/JSONArray
      //   582: dup
      //   583: invokespecial 298	org/json/JSONArray:<init>	()V
      //   586: putfield 300	com/whatsapp/DescribeProblemActivity$b:c	Lorg/json/JSONArray;
      //   589: aload_2
      //   590: invokestatic 287	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   593: aconst_null
      //   594: areturn
      //   595: aload_2
      //   596: astore_1
      //   597: aload_0
      //   598: new 297	org/json/JSONArray
      //   601: dup
      //   602: aload_3
      //   603: invokespecial 301	org/json/JSONArray:<init>	(Ljava/lang/String;)V
      //   606: putfield 300	com/whatsapp/DescribeProblemActivity$b:c	Lorg/json/JSONArray;
      //   609: goto -20 -> 589
      //   612: astore_3
      //   613: goto -108 -> 505
      //   616: astore_2
      //   617: goto -117 -> 500
      //   620: astore_3
      //   621: aload_1
      //   622: astore_2
      //   623: aload_3
      //   624: astore_1
      //   625: goto -94 -> 531
      //   628: astore_1
      //   629: aconst_null
      //   630: astore_3
      //   631: goto -140 -> 491
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	634	0	this	b
      //   100	375	1	localObject1	Object
      //   483	5	1	localThrowable1	Throwable
      //   490	17	1	localObject2	Object
      //   527	9	1	localObject3	Object
      //   538	87	1	localObject4	Object
      //   628	1	1	localObject5	Object
      //   128	348	2	localObject6	Object
      //   486	4	2	localObject7	Object
      //   504	92	2	localObject8	Object
      //   616	1	2	localThrowable2	Throwable
      //   622	1	2	localObject9	Object
      //   299	193	3	localObject10	Object
      //   502	8	3	localException1	Exception
      //   544	59	3	str	String
      //   612	1	3	localException2	Exception
      //   620	4	3	localObject11	Object
      //   630	1	3	localObject12	Object
      //   1	528	4	localObject13	Object
      //   278	262	5	localObject14	Object
      // Exception table:
      //   from	to	target	type
      //   336	418	483	java/lang/Throwable
      //   484	486	486	finally
      //   120	336	502	java/lang/Exception
      //   418	453	502	java/lang/Exception
      //   495	500	502	java/lang/Exception
      //   500	502	502	java/lang/Exception
      //   519	524	502	java/lang/Exception
      //   120	336	527	finally
      //   418	453	527	finally
      //   495	500	527	finally
      //   500	502	527	finally
      //   519	524	527	finally
      //   455	460	612	java/lang/Exception
      //   466	473	612	java/lang/Exception
      //   475	480	612	java/lang/Exception
      //   539	545	612	java/lang/Exception
      //   547	567	612	java/lang/Exception
      //   569	576	612	java/lang/Exception
      //   578	589	612	java/lang/Exception
      //   597	609	612	java/lang/Exception
      //   495	500	616	java/lang/Throwable
      //   455	460	620	finally
      //   466	473	620	finally
      //   475	480	620	finally
      //   507	513	620	finally
      //   539	545	620	finally
      //   547	567	620	finally
      //   569	576	620	finally
      //   578	589	620	finally
      //   597	609	620	finally
      //   336	418	628	finally
    }
    
    protected final void onPreExecute()
    {
      d.a(DescribeProblemActivity.this, 2);
      this.b = DescribeProblemActivity.a(DescribeProblemActivity.this);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/DescribeProblemActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */