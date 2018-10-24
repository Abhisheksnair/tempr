package com.whatsapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.b;
import android.support.v7.app.a;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.b;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.whatsapp.emoji.c;
import com.whatsapp.util.Log;
import com.whatsapp.util.bi;
import com.whatsapp.util.bi.b;
import com.whatsapp.util.bu;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public class WebImagePicker
  extends nm
{
  private View.OnClickListener A;
  private final File B = new File(u.a().getCacheDir(), "Thumbs");
  private final vv.a C = new vv.a()
  {
    public final void a()
    {
      throw new IllegalStateException("must not be called");
    }
    
    public final void b()
    {
      Context localContext = WebImagePicker.this.getApplicationContext();
      if (vv.i()) {}
      for (int i = 2131297241;; i = 2131297242)
      {
        Toast.makeText(localContext, i, 1).show();
        WebImagePicker.this.finish();
        return;
      }
    }
    
    public final void c()
    {
      RequestPermissionActivity.b(WebImagePicker.this, 2131297449, 2131297448);
    }
    
    public final void d()
    {
      throw new IllegalStateException("must not be called");
    }
  };
  final ArrayList<aty> n = new ArrayList();
  Uri o;
  b p;
  private bi q;
  private c r;
  private aud s = new aud("", (byte)0);
  private ProgressBar t;
  private SearchView u;
  private View v;
  private View w;
  private int x = 4;
  private int y;
  private aoa z;
  
  private void m()
  {
    this.y = (this.z.l + (this.z.m << 1) + (int)this.z.n);
    Object localObject = getWindowManager().getDefaultDisplay();
    this.x = (((Display)localObject).getWidth() / this.y);
    this.y = (((Display)localObject).getWidth() / this.x - (int)this.z.n);
    if (this.q != null) {
      this.q.a(false);
    }
    localObject = new bi.b(this.B);
    ((bi.b)localObject).f = this.y;
    localObject = ((bi.b)localObject).a();
    ((bi.b)localObject).c = b.a(this, 2130840446);
    ((bi.b)localObject).d = b.a(this, 2130840204);
    this.q = ((bi.b)localObject).b();
  }
  
  final void l()
  {
    String str = this.u.getQuery().toString();
    if (TextUtils.isEmpty(str))
    {
      Toast.makeText(getApplicationContext(), getString(2131297460), 0).show();
      return;
    }
    ((InputMethodManager)u.a().getSystemService("input_method")).hideSoftInputFromWindow(this.u.getWindowToken(), 0);
    this.t.setVisibility(0);
    c.a(this.r, str);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 151)
    {
      if (paramInt2 == -1)
      {
        l();
        return;
      }
      finish();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    m();
    this.r.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("webimagesearch/create");
    super.onCreate(paramBundle);
    Object localObject = i();
    ((a)localObject).a(true);
    ((a)localObject).b();
    ((a)localObject).c();
    this.z = aoa.a();
    this.B.mkdirs();
    aud.a();
    setContentView(2130903407);
    this.t = ((ProgressBar)findViewById(2131756258));
    paramBundle = getIntent().getStringExtra("query");
    if (paramBundle != null) {
      paramBundle = c.a(paramBundle);
    }
    for (;;)
    {
      this.u = new SearchView(((a)localObject).h())
      {
        public final boolean d()
        {
          return false;
        }
      };
      ((TextView)this.u.findViewById(2131755212)).setTextColor(b.c(this, 2131624098));
      this.u.setQueryHint(getString(2131297635));
      this.u.setIconified(false);
      this.u.setOnCloseListener$2f0b952f(atz.a());
      this.u.setQuery$609c24db(paramBundle);
      this.u.setOnSearchClickListener(aua.a(this));
      this.u.setOnQueryTextListener(new SearchView.b()
      {
        public final boolean a(String paramAnonymousString)
        {
          WebImagePicker.a(WebImagePicker.this);
          return true;
        }
        
        public final boolean b(String paramAnonymousString)
        {
          return false;
        }
      });
      ((a)localObject).a(this.u);
      paramBundle = getIntent().getExtras();
      if (paramBundle != null) {
        this.o = ((Uri)paramBundle.getParcelable("output"));
      }
      paramBundle = W();
      paramBundle.requestFocus();
      paramBundle.setClickable(false);
      paramBundle.setBackgroundDrawable(null);
      paramBundle.setDividerHeight(0);
      localObject = getLayoutInflater().inflate(2130903408, paramBundle, false);
      paramBundle.addFooterView((View)localObject, null, false);
      paramBundle.setFooterDividersEnabled(false);
      this.v = ((View)localObject).findViewById(2131755224);
      this.w = ((View)localObject).findViewById(2131756259);
      this.r = new c();
      a(this.r);
      this.A = aub.a(this);
      m();
      this.aI.b(this.C);
      this.u.requestFocus();
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("webimagesearch/destroy");
    this.n.clear();
    this.q.a(true);
    if (this.p != null)
    {
      this.p.cancel(true);
      Log.i("webimagesearch/cancel_image_download_task");
      if (b.a(this.p) != null)
      {
        Log.i("webimagesearch/cancel_dialog");
        b.a(this.p).dismiss();
        b.b(this.p);
      }
      this.p = null;
    }
    c.a(this.r);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    finish();
    return true;
  }
  
  static enum a
  {
    private a() {}
  }
  
  final class b
    extends AsyncTask<Void, Integer, WebImagePicker.a>
  {
    ProgressDialog a;
    private aty c;
    
    b(aty paramaty)
    {
      this.c = paramaty;
    }
    
    /* Error */
    private WebImagePicker.a a()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 9
      //   3: aconst_null
      //   4: astore 10
      //   6: aconst_null
      //   7: astore 11
      //   9: aconst_null
      //   10: astore 13
      //   12: aconst_null
      //   13: astore 14
      //   15: aconst_null
      //   16: astore 12
      //   18: new 33	java/net/URL
      //   21: dup
      //   22: aload_0
      //   23: getfield 22	com/whatsapp/WebImagePicker$b:c	Lcom/whatsapp/aty;
      //   26: getfield 38	com/whatsapp/aty:b	Ljava/lang/String;
      //   29: ldc 40
      //   31: ldc 42
      //   33: invokevirtual 48	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   36: invokespecial 51	java/net/URL:<init>	(Ljava/lang/String;)V
      //   39: astore 7
      //   41: iconst_0
      //   42: istore_1
      //   43: ldc 53
      //   45: astore 6
      //   47: aconst_null
      //   48: astore 4
      //   50: iload_1
      //   51: bipush 20
      //   53: if_icmpge +1123 -> 1176
      //   56: aload 7
      //   58: invokevirtual 57	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   61: checkcast 59	java/net/HttpURLConnection
      //   64: astore 5
      //   66: aload 5
      //   68: sipush 15000
      //   71: invokevirtual 63	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   74: aload 5
      //   76: sipush 30000
      //   79: invokevirtual 66	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   82: aload 5
      //   84: ldc 68
      //   86: invokestatic 73	com/whatsapp/ape:a	()Ljava/lang/String;
      //   89: invokevirtual 77	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   92: aload 6
      //   94: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   97: ifne +12 -> 109
      //   100: aload 5
      //   102: ldc 85
      //   104: aload 6
      //   106: invokevirtual 77	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   109: aload 5
      //   111: invokevirtual 89	java/net/HttpURLConnection:getResponseCode	()I
      //   114: istore_2
      //   115: iload_2
      //   116: sipush 300
      //   119: if_icmpeq +38 -> 157
      //   122: iload_2
      //   123: sipush 301
      //   126: if_icmpeq +31 -> 157
      //   129: iload_2
      //   130: sipush 302
      //   133: if_icmpeq +24 -> 157
      //   136: iload_2
      //   137: sipush 303
      //   140: if_icmpeq +17 -> 157
      //   143: iload_2
      //   144: sipush 307
      //   147: if_icmpeq +10 -> 157
      //   150: iload_2
      //   151: sipush 308
      //   154: if_icmpne +179 -> 333
      //   157: aload 5
      //   159: ldc 91
      //   161: invokevirtual 95	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   164: astore 4
      //   166: aload 4
      //   168: ifnull +165 -> 333
      //   171: new 33	java/net/URL
      //   174: dup
      //   175: aload 7
      //   177: aload 4
      //   179: invokespecial 98	java/net/URL:<init>	(Ljava/net/URL;Ljava/lang/String;)V
      //   182: astore 8
      //   184: new 100	java/lang/StringBuilder
      //   187: dup
      //   188: ldc 102
      //   190: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   193: aload 7
      //   195: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   198: ldc 109
      //   200: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   203: aload 8
      //   205: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   208: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   211: invokestatic 120	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   214: aload 5
      //   216: ldc 122
      //   218: invokevirtual 95	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   221: astore 4
      //   223: aload 6
      //   225: astore 7
      //   227: aload 4
      //   229: ifnull +80 -> 309
      //   232: aload 4
      //   234: ldc 124
      //   236: invokevirtual 128	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   239: astore 7
      //   241: aload 7
      //   243: arraylength
      //   244: ifle +9 -> 253
      //   247: aload 7
      //   249: iconst_0
      //   250: aaload
      //   251: astore 4
      //   253: aload 6
      //   255: astore 7
      //   257: aload 6
      //   259: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   262: ifne +25 -> 287
      //   265: new 100	java/lang/StringBuilder
      //   268: dup
      //   269: invokespecial 129	java/lang/StringBuilder:<init>	()V
      //   272: aload 6
      //   274: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   277: ldc -125
      //   279: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   282: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   285: astore 7
      //   287: new 100	java/lang/StringBuilder
      //   290: dup
      //   291: invokespecial 129	java/lang/StringBuilder:<init>	()V
      //   294: aload 7
      //   296: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   299: aload 4
      //   301: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   304: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   307: astore 7
      //   309: aload 5
      //   311: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
      //   314: iload_1
      //   315: iconst_1
      //   316: iadd
      //   317: istore_1
      //   318: aload 5
      //   320: astore 4
      //   322: aload 7
      //   324: astore 6
      //   326: aload 8
      //   328: astore 7
      //   330: goto -280 -> 50
      //   333: aload 5
      //   335: astore 4
      //   337: aload 4
      //   339: invokevirtual 138	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   342: astore 5
      //   344: aload 13
      //   346: astore 7
      //   348: aload 5
      //   350: astore 9
      //   352: aload 4
      //   354: astore 8
      //   356: aload 14
      //   358: astore 10
      //   360: aload_0
      //   361: getfield 17	com/whatsapp/WebImagePicker$b:b	Lcom/whatsapp/WebImagePicker;
      //   364: getfield 142	com/whatsapp/WebImagePicker:aE	Lcom/whatsapp/and;
      //   367: getfield 148	com/whatsapp/and:f	Landroid/content/ContentResolver;
      //   370: astore 6
      //   372: aload 6
      //   374: ifnonnull +77 -> 451
      //   377: aload 13
      //   379: astore 7
      //   381: aload 5
      //   383: astore 9
      //   385: aload 4
      //   387: astore 8
      //   389: aload 14
      //   391: astore 10
      //   393: ldc -106
      //   395: invokestatic 153	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
      //   398: aload 12
      //   400: astore 6
      //   402: aload 6
      //   404: ifnonnull +80 -> 484
      //   407: aload 6
      //   409: astore 7
      //   411: aload 5
      //   413: astore 9
      //   415: aload 4
      //   417: astore 8
      //   419: aload 6
      //   421: astore 10
      //   423: getstatic 158	com/whatsapp/WebImagePicker$a:b	Lcom/whatsapp/WebImagePicker$a;
      //   426: astore 11
      //   428: aload 4
      //   430: ifnull +8 -> 438
      //   433: aload 4
      //   435: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
      //   438: aload 5
      //   440: invokestatic 163	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   443: aload 6
      //   445: invokestatic 163	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   448: aload 11
      //   450: areturn
      //   451: aload 13
      //   453: astore 7
      //   455: aload 5
      //   457: astore 9
      //   459: aload 4
      //   461: astore 8
      //   463: aload 14
      //   465: astore 10
      //   467: aload 6
      //   469: aload_0
      //   470: getfield 17	com/whatsapp/WebImagePicker$b:b	Lcom/whatsapp/WebImagePicker;
      //   473: invokestatic 166	com/whatsapp/WebImagePicker:b	(Lcom/whatsapp/WebImagePicker;)Landroid/net/Uri;
      //   476: invokevirtual 172	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
      //   479: astore 6
      //   481: goto -79 -> 402
      //   484: aload 6
      //   486: astore 7
      //   488: aload 5
      //   490: astore 9
      //   492: aload 4
      //   494: astore 8
      //   496: aload 6
      //   498: astore 10
      //   500: sipush 1024
      //   503: newarray <illegal type>
      //   505: astore 11
      //   507: iconst_0
      //   508: istore_1
      //   509: iconst_0
      //   510: istore_2
      //   511: aload 6
      //   513: astore 7
      //   515: aload 5
      //   517: astore 9
      //   519: aload 4
      //   521: astore 8
      //   523: aload 6
      //   525: astore 10
      //   527: aload_0
      //   528: invokevirtual 176	com/whatsapp/WebImagePicker$b:isCancelled	()Z
      //   531: ifne +163 -> 694
      //   534: aload 6
      //   536: astore 7
      //   538: aload 5
      //   540: astore 9
      //   542: aload 4
      //   544: astore 8
      //   546: aload 6
      //   548: astore 10
      //   550: aload 5
      //   552: aload 11
      //   554: iconst_0
      //   555: sipush 1024
      //   558: invokevirtual 182	java/io/InputStream:read	([BII)I
      //   561: istore_3
      //   562: iload_3
      //   563: iconst_m1
      //   564: if_icmpeq +130 -> 694
      //   567: aload 6
      //   569: astore 7
      //   571: aload 5
      //   573: astore 9
      //   575: aload 4
      //   577: astore 8
      //   579: aload 6
      //   581: astore 10
      //   583: aload 6
      //   585: aload 11
      //   587: iconst_0
      //   588: iload_3
      //   589: invokevirtual 188	java/io/OutputStream:write	([BII)V
      //   592: iload_3
      //   593: iload_2
      //   594: iadd
      //   595: istore_3
      //   596: aload 6
      //   598: astore 7
      //   600: aload 5
      //   602: astore 9
      //   604: aload 4
      //   606: astore 8
      //   608: aload 6
      //   610: astore 10
      //   612: aload_0
      //   613: getfield 22	com/whatsapp/WebImagePicker$b:c	Lcom/whatsapp/aty;
      //   616: getfield 192	com/whatsapp/aty:d	I
      //   619: ifeq +552 -> 1171
      //   622: aload 6
      //   624: astore 7
      //   626: aload 5
      //   628: astore 9
      //   630: aload 4
      //   632: astore 8
      //   634: aload 6
      //   636: astore 10
      //   638: iload_3
      //   639: bipush 100
      //   641: imul
      //   642: aload_0
      //   643: getfield 22	com/whatsapp/WebImagePicker$b:c	Lcom/whatsapp/aty;
      //   646: getfield 192	com/whatsapp/aty:d	I
      //   649: idiv
      //   650: istore_2
      //   651: iload_2
      //   652: iload_1
      //   653: if_icmpeq +513 -> 1166
      //   656: aload 6
      //   658: astore 7
      //   660: aload 5
      //   662: astore 9
      //   664: aload 4
      //   666: astore 8
      //   668: aload 6
      //   670: astore 10
      //   672: aload_0
      //   673: iconst_1
      //   674: anewarray 194	java/lang/Integer
      //   677: dup
      //   678: iconst_0
      //   679: iload_2
      //   680: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   683: aastore
      //   684: invokevirtual 202	com/whatsapp/WebImagePicker$b:publishProgress	([Ljava/lang/Object;)V
      //   687: iload_2
      //   688: istore_1
      //   689: iload_3
      //   690: istore_2
      //   691: goto -180 -> 511
      //   694: aload 4
      //   696: ifnull +8 -> 704
      //   699: aload 4
      //   701: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
      //   704: aload 5
      //   706: invokestatic 163	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   709: aload 6
      //   711: invokestatic 163	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   714: aload_0
      //   715: invokevirtual 176	com/whatsapp/WebImagePicker$b:isCancelled	()Z
      //   718: ifne +224 -> 942
      //   721: getstatic 204	com/whatsapp/WebImagePicker$a:a	Lcom/whatsapp/WebImagePicker$a;
      //   724: areturn
      //   725: astore 6
      //   727: aconst_null
      //   728: astore 4
      //   730: aconst_null
      //   731: astore 5
      //   733: aload 9
      //   735: astore 7
      //   737: aload_0
      //   738: invokevirtual 176	com/whatsapp/WebImagePicker$b:isCancelled	()Z
      //   741: ifne +52 -> 793
      //   744: aload 6
      //   746: invokevirtual 207	java/io/IOException:getMessage	()Ljava/lang/String;
      //   749: ifnull +44 -> 793
      //   752: aload 6
      //   754: invokevirtual 207	java/io/IOException:getMessage	()Ljava/lang/String;
      //   757: ldc -47
      //   759: invokevirtual 212	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   762: ifeq +31 -> 793
      //   765: getstatic 214	com/whatsapp/WebImagePicker$a:c	Lcom/whatsapp/WebImagePicker$a;
      //   768: astore 6
      //   770: aload 5
      //   772: ifnull +8 -> 780
      //   775: aload 5
      //   777: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
      //   780: aload 7
      //   782: invokestatic 163	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   785: aload 4
      //   787: invokestatic 163	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   790: aload 6
      //   792: areturn
      //   793: getstatic 158	com/whatsapp/WebImagePicker$a:b	Lcom/whatsapp/WebImagePicker$a;
      //   796: astore 6
      //   798: aload 5
      //   800: ifnull +8 -> 808
      //   803: aload 5
      //   805: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
      //   808: aload 7
      //   810: invokestatic 163	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   813: aload 4
      //   815: invokestatic 163	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   818: aload 6
      //   820: areturn
      //   821: astore 6
      //   823: aconst_null
      //   824: astore 5
      //   826: aconst_null
      //   827: astore 4
      //   829: aload 10
      //   831: astore 7
      //   833: aload 5
      //   835: astore 9
      //   837: aload 4
      //   839: astore 8
      //   841: aload_0
      //   842: invokevirtual 176	com/whatsapp/WebImagePicker$b:isCancelled	()Z
      //   845: ifne +22 -> 867
      //   848: aload 10
      //   850: astore 7
      //   852: aload 5
      //   854: astore 9
      //   856: aload 4
      //   858: astore 8
      //   860: ldc -40
      //   862: aload 6
      //   864: invokestatic 219	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   867: aload 10
      //   869: astore 7
      //   871: aload 5
      //   873: astore 9
      //   875: aload 4
      //   877: astore 8
      //   879: getstatic 158	com/whatsapp/WebImagePicker$a:b	Lcom/whatsapp/WebImagePicker$a;
      //   882: astore 6
      //   884: aload 4
      //   886: ifnull +8 -> 894
      //   889: aload 4
      //   891: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
      //   894: aload 5
      //   896: invokestatic 163	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   899: aload 10
      //   901: invokestatic 163	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   904: aload 6
      //   906: areturn
      //   907: astore 5
      //   909: aconst_null
      //   910: astore 6
      //   912: aconst_null
      //   913: astore 4
      //   915: aload 11
      //   917: astore 7
      //   919: aload 4
      //   921: ifnull +8 -> 929
      //   924: aload 4
      //   926: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
      //   929: aload 6
      //   931: invokestatic 163	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   934: aload 7
      //   936: invokestatic 163	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   939: aload 5
      //   941: athrow
      //   942: getstatic 158	com/whatsapp/WebImagePicker$a:b	Lcom/whatsapp/WebImagePicker$a;
      //   945: areturn
      //   946: astore 7
      //   948: aconst_null
      //   949: astore 6
      //   951: aload 5
      //   953: astore 4
      //   955: aload 7
      //   957: astore 5
      //   959: aload 11
      //   961: astore 7
      //   963: goto -44 -> 919
      //   966: astore 5
      //   968: aconst_null
      //   969: astore 6
      //   971: aload 11
      //   973: astore 7
      //   975: goto -56 -> 919
      //   978: astore 5
      //   980: aconst_null
      //   981: astore 6
      //   983: aload 11
      //   985: astore 7
      //   987: goto -68 -> 919
      //   990: astore 5
      //   992: aload 9
      //   994: astore 6
      //   996: aload 8
      //   998: astore 4
      //   1000: goto -81 -> 919
      //   1003: astore 9
      //   1005: aload 5
      //   1007: astore 8
      //   1009: aload 7
      //   1011: astore 6
      //   1013: aload 9
      //   1015: astore 5
      //   1017: aload 4
      //   1019: astore 7
      //   1021: aload 8
      //   1023: astore 4
      //   1025: goto -106 -> 919
      //   1028: astore 6
      //   1030: aconst_null
      //   1031: astore 7
      //   1033: aload 5
      //   1035: astore 4
      //   1037: aload 7
      //   1039: astore 5
      //   1041: goto -212 -> 829
      //   1044: astore 6
      //   1046: aconst_null
      //   1047: astore 5
      //   1049: goto -220 -> 829
      //   1052: astore 6
      //   1054: aconst_null
      //   1055: astore 5
      //   1057: goto -228 -> 829
      //   1060: astore 6
      //   1062: goto -233 -> 829
      //   1065: astore 6
      //   1067: aconst_null
      //   1068: astore 4
      //   1070: aload 9
      //   1072: astore 7
      //   1074: goto -337 -> 737
      //   1077: astore 6
      //   1079: aload 4
      //   1081: astore 5
      //   1083: aconst_null
      //   1084: astore 4
      //   1086: aload 9
      //   1088: astore 7
      //   1090: goto -353 -> 737
      //   1093: astore 6
      //   1095: aconst_null
      //   1096: astore 7
      //   1098: aload 4
      //   1100: astore 5
      //   1102: aload 7
      //   1104: astore 4
      //   1106: aload 9
      //   1108: astore 7
      //   1110: goto -373 -> 737
      //   1113: astore 6
      //   1115: aconst_null
      //   1116: astore 7
      //   1118: aload 4
      //   1120: astore 8
      //   1122: aload 7
      //   1124: astore 4
      //   1126: aload 5
      //   1128: astore 7
      //   1130: aload 8
      //   1132: astore 5
      //   1134: goto -397 -> 737
      //   1137: astore 9
      //   1139: aload 6
      //   1141: astore 7
      //   1143: aload 4
      //   1145: astore 8
      //   1147: aload 9
      //   1149: astore 6
      //   1151: aload 7
      //   1153: astore 4
      //   1155: aload 5
      //   1157: astore 7
      //   1159: aload 8
      //   1161: astore 5
      //   1163: goto -426 -> 737
      //   1166: iload_1
      //   1167: istore_2
      //   1168: goto -481 -> 687
      //   1171: iconst_0
      //   1172: istore_2
      //   1173: goto -522 -> 651
      //   1176: goto -839 -> 337
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1179	0	this	b
      //   42	1125	1	i	int
      //   114	1059	2	j	int
      //   561	129	3	k	int
      //   48	1106	4	localObject1	Object
      //   64	831	5	localObject2	Object
      //   907	45	5	localObject3	Object
      //   957	1	5	localObject4	Object
      //   966	1	5	localObject5	Object
      //   978	1	5	localObject6	Object
      //   990	16	5	localObject7	Object
      //   1015	147	5	localObject8	Object
      //   45	665	6	localObject9	Object
      //   725	28	6	localIOException1	IOException
      //   768	51	6	locala	WebImagePicker.a
      //   821	42	6	localException1	Exception
      //   882	130	6	localObject10	Object
      //   1028	1	6	localException2	Exception
      //   1044	1	6	localException3	Exception
      //   1052	1	6	localException4	Exception
      //   1060	1	6	localException5	Exception
      //   1065	1	6	localIOException2	IOException
      //   1077	1	6	localIOException3	IOException
      //   1093	1	6	localIOException4	IOException
      //   1113	27	6	localIOException5	IOException
      //   1149	1	6	localIOException6	IOException
      //   39	896	7	localObject11	Object
      //   946	10	7	localObject12	Object
      //   961	197	7	localObject13	Object
      //   182	978	8	localObject14	Object
      //   1	992	9	localObject15	Object
      //   1003	104	9	localObject16	Object
      //   1137	11	9	localIOException7	IOException
      //   4	896	10	localObject17	Object
      //   7	977	11	localObject18	Object
      //   16	383	12	localObject19	Object
      //   10	442	13	localObject20	Object
      //   13	451	14	localObject21	Object
      // Exception table:
      //   from	to	target	type
      //   18	41	725	java/io/IOException
      //   18	41	821	java/lang/Exception
      //   18	41	907	finally
      //   66	109	946	finally
      //   109	115	946	finally
      //   157	166	946	finally
      //   171	223	946	finally
      //   232	241	946	finally
      //   241	247	946	finally
      //   257	287	946	finally
      //   287	309	946	finally
      //   309	314	946	finally
      //   56	66	966	finally
      //   337	344	978	finally
      //   360	372	990	finally
      //   393	398	990	finally
      //   423	428	990	finally
      //   467	481	990	finally
      //   500	507	990	finally
      //   527	534	990	finally
      //   550	562	990	finally
      //   583	592	990	finally
      //   612	622	990	finally
      //   638	651	990	finally
      //   672	687	990	finally
      //   841	848	990	finally
      //   860	867	990	finally
      //   879	884	990	finally
      //   737	770	1003	finally
      //   793	798	1003	finally
      //   66	109	1028	java/lang/Exception
      //   109	115	1028	java/lang/Exception
      //   157	166	1028	java/lang/Exception
      //   171	223	1028	java/lang/Exception
      //   232	241	1028	java/lang/Exception
      //   241	247	1028	java/lang/Exception
      //   257	287	1028	java/lang/Exception
      //   287	309	1028	java/lang/Exception
      //   309	314	1028	java/lang/Exception
      //   56	66	1044	java/lang/Exception
      //   337	344	1052	java/lang/Exception
      //   360	372	1060	java/lang/Exception
      //   393	398	1060	java/lang/Exception
      //   423	428	1060	java/lang/Exception
      //   467	481	1060	java/lang/Exception
      //   500	507	1060	java/lang/Exception
      //   527	534	1060	java/lang/Exception
      //   550	562	1060	java/lang/Exception
      //   583	592	1060	java/lang/Exception
      //   612	622	1060	java/lang/Exception
      //   638	651	1060	java/lang/Exception
      //   672	687	1060	java/lang/Exception
      //   66	109	1065	java/io/IOException
      //   109	115	1065	java/io/IOException
      //   157	166	1065	java/io/IOException
      //   171	223	1065	java/io/IOException
      //   232	241	1065	java/io/IOException
      //   241	247	1065	java/io/IOException
      //   257	287	1065	java/io/IOException
      //   287	309	1065	java/io/IOException
      //   309	314	1065	java/io/IOException
      //   56	66	1077	java/io/IOException
      //   337	344	1093	java/io/IOException
      //   360	372	1113	java/io/IOException
      //   393	398	1113	java/io/IOException
      //   467	481	1113	java/io/IOException
      //   423	428	1137	java/io/IOException
      //   500	507	1137	java/io/IOException
      //   527	534	1137	java/io/IOException
      //   550	562	1137	java/io/IOException
      //   583	592	1137	java/io/IOException
      //   612	622	1137	java/io/IOException
      //   638	651	1137	java/io/IOException
      //   672	687	1137	java/io/IOException
    }
    
    protected final void onPreExecute()
    {
      this.a = new ProgressDialog(WebImagePicker.this);
      this.a.setProgressStyle(1);
      this.a.setMessage(WebImagePicker.this.getString(2131297458));
      this.a.setCancelable(true);
      this.a.setOnCancelListener(auc.a(this));
      this.a.show();
    }
  }
  
  final class c
    extends BaseAdapter
  {
    private boolean b;
    private a c;
    
    public c() {}
    
    private void a(String paramString)
    {
      if (paramString != null)
      {
        if (this.c != null) {
          this.c.cancel(false);
        }
        this.b = true;
        WebImagePicker.a(WebImagePicker.this, new aud(paramString, (byte)0));
        WebImagePicker.e(WebImagePicker.this).clear();
        WebImagePicker.j(WebImagePicker.this).a(false);
        WebImagePicker localWebImagePicker = WebImagePicker.this;
        bi.b localb = new bi.b(WebImagePicker.k(WebImagePicker.this));
        localb.f = WebImagePicker.h(WebImagePicker.this);
        localb = localb.a();
        localb.c = b.a(WebImagePicker.this, 2130840025);
        localb.d = b.a(WebImagePicker.this, 2130840204);
        WebImagePicker.a(localWebImagePicker, localb.b());
      }
      this.c = new a((byte)0);
      bu.a(this.c, new Void[0]);
      if (paramString != null) {
        notifyDataSetChanged();
      }
    }
    
    public final int getCount()
    {
      return (WebImagePicker.e(WebImagePicker.this).size() + WebImagePicker.f(WebImagePicker.this) - 1) / WebImagePicker.f(WebImagePicker.this);
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int k;
      int j;
      int i;
      if ((paramView == null) || (((LinearLayout)paramView).getChildCount() != WebImagePicker.f(WebImagePicker.this)))
      {
        paramView = new LinearLayout(WebImagePicker.this);
        paramView.setPadding(WebImagePicker.g(WebImagePicker.this).q, WebImagePicker.g(WebImagePicker.this).p, 0, WebImagePicker.g(WebImagePicker.this).p);
        paramView.setClickable(false);
        k = paramView.getChildCount();
        j = WebImagePicker.f(WebImagePicker.this) * paramInt;
        i = 0;
        label93:
        if (j >= (paramInt + 1) * WebImagePicker.f(WebImagePicker.this)) {
          break label372;
        }
        if (j >= WebImagePicker.e(WebImagePicker.this).size()) {
          break label335;
        }
        aty localaty = (aty)WebImagePicker.e(WebImagePicker.this).get(j);
        if (k > i) {
          break label317;
        }
        paramViewGroup = new ImageView(WebImagePicker.this);
        paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(WebImagePicker.h(WebImagePicker.this), WebImagePicker.h(WebImagePicker.this));
        paramViewGroup.setLayoutParams(localLayoutParams);
        localLayoutParams.rightMargin = ((int)WebImagePicker.g(WebImagePicker.this).n);
        paramViewGroup.setBackgroundResource(2130840501);
        paramViewGroup.setPadding(WebImagePicker.g(WebImagePicker.this).m, WebImagePicker.g(WebImagePicker.this).m, WebImagePicker.g(WebImagePicker.this).m, WebImagePicker.g(WebImagePicker.this).m);
        paramViewGroup.setOnClickListener(WebImagePicker.i(WebImagePicker.this));
        paramView.addView(paramViewGroup);
        label278:
        WebImagePicker.j(WebImagePicker.this).a(localaty.a, paramViewGroup);
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break label93;
        paramView = (LinearLayout)paramView;
        break;
        label317:
        paramViewGroup = (ImageView)paramView.getChildAt(i);
        paramViewGroup.setVisibility(0);
        break label278;
        label335:
        int m = j - WebImagePicker.f(WebImagePicker.this) * paramInt;
        if (k > m) {
          ((ImageView)paramView.getChildAt(m)).setVisibility(4);
        }
      }
      label372:
      if ((this.c == null) && (this.b) && (paramInt == (WebImagePicker.e(WebImagePicker.this).size() - 1) / WebImagePicker.f(WebImagePicker.this))) {
        a(null);
      }
      return paramView;
    }
    
    final class a
      extends AsyncTask<Void, Void, List<aty>>
    {
      private a() {}
      
      private List<aty> a()
      {
        try
        {
          List localList = WebImagePicker.l(WebImagePicker.this).b();
          return localList;
        }
        catch (JSONException localJSONException)
        {
          Log.e(localJSONException);
          return null;
        }
        catch (IOException localIOException)
        {
          for (;;) {}
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/WebImagePicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */