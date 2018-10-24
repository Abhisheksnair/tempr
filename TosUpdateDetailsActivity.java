package com.whatsapp;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.o;
import android.support.v7.app.a;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.whatsapp.messaging.w;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.az;
import com.whatsapp.util.bu;

public class TosUpdateDetailsActivity
  extends nh
{
  Toast n;
  private a o;
  
  public void onCreate(final Bundle paramBundle)
  {
    boolean bool1 = true;
    Log.i("tosupdatedetails/create");
    this.al = false;
    this.ak = false;
    super.onCreate(paramBundle);
    i().a(true);
    if (!this.aq.d()) {
      i().b(new az(getResources().getDrawable(2130840097)));
    }
    setContentView(2130903386);
    this.o = new a();
    bu.a(this.o, new Void[0]);
    ((TextView)findViewById(2131756138)).setText(Html.fromHtml(getString(2131297999)));
    boolean bool2 = getIntent().getBooleanExtra("opt_out", false);
    paramBundle = (CheckBox)findViewById(2131756139);
    if (!bool2) {}
    for (;;)
    {
      paramBundle.setChecked(bool1);
      paramBundle.setOnCheckedChangeListener(anw.a(this, paramBundle));
      Button localButton = (Button)findViewById(2131756134);
      aoa.b(localButton);
      localButton.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          boolean bool2 = true;
          TosUpdateDetailsActivity.this.setResult(-1);
          paramAnonymousView = TosUpdateDetailsActivity.this.at;
          if (!paramBundle.isChecked())
          {
            bool1 = true;
            paramAnonymousView.a(bool1);
            paramAnonymousView = TosUpdateDetailsActivity.this.ay;
            if (paramBundle.isChecked()) {
              break label73;
            }
          }
          label73:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            paramAnonymousView.a(bool1);
            TosUpdateDetailsActivity.this.finish();
            return;
            bool1 = false;
            break;
          }
        }
      });
      findViewById(2131755797).setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          TosUpdateDetailsActivity.a(TosUpdateDetailsActivity.this).cancel(true);
          TosUpdateDetailsActivity.a(TosUpdateDetailsActivity.this, new TosUpdateDetailsActivity.a(TosUpdateDetailsActivity.this));
          bu.a(TosUpdateDetailsActivity.a(TosUpdateDetailsActivity.this), new Void[0]);
        }
      });
      return;
      bool1 = false;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    o.a(paramMenu.add(0, 2131755076, 0, 2131297833).setIcon(2130840248), 2);
    return true;
  }
  
  public void onDestroy()
  {
    Log.i("tosupdatedetails/destroy");
    super.onDestroy();
    this.o.cancel(true);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755076)
    {
      paramMenuItem = new Intent("android.intent.action.SEND", Uri.parse("mailto:"));
      paramMenuItem.putExtra("android.intent.extra.SUBJECT", getString(2131297991));
      paramMenuItem.putExtra("android.intent.extra.TEXT", getString(2131297992, new Object[] { "https://www.whatsapp.com/legal/" }));
      paramMenuItem.setType("text/plain");
      paramMenuItem.addFlags(524288);
      startActivity(Intent.createChooser(paramMenuItem, null));
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public final class a
    extends AsyncTask<Void, Void, String>
  {
    protected a() {}
    
    /* Error */
    private String a()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: new 22	java/net/URL
      //   6: dup
      //   7: new 24	java/lang/StringBuilder
      //   10: dup
      //   11: ldc 26
      //   13: invokespecial 29	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   16: aload_0
      //   17: getfield 13	com/whatsapp/TosUpdateDetailsActivity$a:a	Lcom/whatsapp/TosUpdateDetailsActivity;
      //   20: getfield 33	com/whatsapp/TosUpdateDetailsActivity:aF	Lcom/whatsapp/aus;
      //   23: invokevirtual 38	com/whatsapp/aus:d	()Ljava/lang/String;
      //   26: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   29: ldc 44
      //   31: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   34: aload_0
      //   35: getfield 13	com/whatsapp/TosUpdateDetailsActivity$a:a	Lcom/whatsapp/TosUpdateDetailsActivity;
      //   38: getfield 33	com/whatsapp/TosUpdateDetailsActivity:aF	Lcom/whatsapp/aus;
      //   41: invokevirtual 47	com/whatsapp/aus:c	()Ljava/lang/String;
      //   44: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   47: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   50: invokespecial 51	java/net/URL:<init>	(Ljava/lang/String;)V
      //   53: invokevirtual 55	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   56: astore_2
      //   57: aload_2
      //   58: instanceof 57
      //   61: istore_1
      //   62: iload_1
      //   63: ifne +9 -> 72
      //   66: aconst_null
      //   67: invokestatic 62	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   70: aconst_null
      //   71: areturn
      //   72: aload_2
      //   73: checkcast 57	java/net/HttpURLConnection
      //   76: astore_2
      //   77: aload_2
      //   78: sipush 20000
      //   81: invokevirtual 66	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   84: aload_2
      //   85: sipush 20000
      //   88: invokevirtual 69	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   91: aload_2
      //   92: invokevirtual 72	java/net/HttpURLConnection:connect	()V
      //   95: aload_2
      //   96: invokevirtual 76	java/net/HttpURLConnection:getResponseCode	()I
      //   99: sipush 200
      //   102: if_icmpeq +21 -> 123
      //   105: aload_2
      //   106: invokevirtual 79	java/net/HttpURLConnection:disconnect	()V
      //   109: aload_2
      //   110: ifnull +7 -> 117
      //   113: aload_2
      //   114: invokevirtual 79	java/net/HttpURLConnection:disconnect	()V
      //   117: aconst_null
      //   118: invokestatic 62	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   121: aconst_null
      //   122: areturn
      //   123: aload_2
      //   124: invokevirtual 83	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   127: astore_3
      //   128: new 24	java/lang/StringBuilder
      //   131: dup
      //   132: invokespecial 84	java/lang/StringBuilder:<init>	()V
      //   135: astore 4
      //   137: new 86	java/io/BufferedReader
      //   140: dup
      //   141: new 88	java/io/InputStreamReader
      //   144: dup
      //   145: aload_3
      //   146: invokespecial 91	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   149: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   152: astore 5
      //   154: aload 5
      //   156: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   159: astore_3
      //   160: aload_3
      //   161: ifnull +19 -> 180
      //   164: aload 4
      //   166: aload_3
      //   167: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   170: pop
      //   171: aload 5
      //   173: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   176: astore_3
      //   177: goto -17 -> 160
      //   180: aload 4
      //   182: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   185: astore_3
      //   186: aload_2
      //   187: ifnull +7 -> 194
      //   190: aload_2
      //   191: invokevirtual 79	java/net/HttpURLConnection:disconnect	()V
      //   194: aload 5
      //   196: invokestatic 62	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   199: aload_3
      //   200: areturn
      //   201: astore 4
      //   203: aconst_null
      //   204: astore_3
      //   205: aconst_null
      //   206: astore_2
      //   207: ldc 99
      //   209: aload 4
      //   211: invokestatic 104	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   214: aload_3
      //   215: ifnull +7 -> 222
      //   218: aload_3
      //   219: invokevirtual 79	java/net/HttpURLConnection:disconnect	()V
      //   222: aload_2
      //   223: invokestatic 62	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   226: aconst_null
      //   227: areturn
      //   228: astore_3
      //   229: aconst_null
      //   230: astore_2
      //   231: aload 4
      //   233: ifnull +8 -> 241
      //   236: aload 4
      //   238: invokevirtual 79	java/net/HttpURLConnection:disconnect	()V
      //   241: aload_2
      //   242: invokestatic 62	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
      //   245: aload_3
      //   246: athrow
      //   247: astore_3
      //   248: aconst_null
      //   249: astore 5
      //   251: aload_2
      //   252: astore 4
      //   254: aload 5
      //   256: astore_2
      //   257: goto -26 -> 231
      //   260: astore_3
      //   261: aload_2
      //   262: astore 4
      //   264: aload 5
      //   266: astore_2
      //   267: goto -36 -> 231
      //   270: astore 5
      //   272: aload_3
      //   273: astore 4
      //   275: aload 5
      //   277: astore_3
      //   278: goto -47 -> 231
      //   281: astore 4
      //   283: aconst_null
      //   284: astore 5
      //   286: aload_2
      //   287: astore_3
      //   288: aload 5
      //   290: astore_2
      //   291: goto -84 -> 207
      //   294: astore 4
      //   296: aload_2
      //   297: astore_3
      //   298: aload 5
      //   300: astore_2
      //   301: goto -94 -> 207
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	304	0	this	a
      //   61	2	1	bool	boolean
      //   56	245	2	localObject1	Object
      //   127	92	3	localObject2	Object
      //   228	18	3	localObject3	Object
      //   247	1	3	localObject4	Object
      //   260	13	3	localObject5	Object
      //   277	21	3	localObject6	Object
      //   1	180	4	localStringBuilder	StringBuilder
      //   201	36	4	localException1	Exception
      //   252	22	4	localObject7	Object
      //   281	1	4	localException2	Exception
      //   294	1	4	localException3	Exception
      //   152	113	5	localBufferedReader	java.io.BufferedReader
      //   270	6	5	localObject8	Object
      //   284	15	5	localObject9	Object
      // Exception table:
      //   from	to	target	type
      //   3	62	201	java/lang/Exception
      //   72	77	201	java/lang/Exception
      //   3	62	228	finally
      //   72	77	228	finally
      //   77	109	247	finally
      //   123	154	247	finally
      //   154	160	260	finally
      //   164	177	260	finally
      //   180	186	260	finally
      //   207	214	270	finally
      //   77	109	281	java/lang/Exception
      //   123	154	281	java/lang/Exception
      //   154	160	294	java/lang/Exception
      //   164	177	294	java/lang/Exception
      //   180	186	294	java/lang/Exception
    }
    
    protected final void onPreExecute()
    {
      TosUpdateDetailsActivity.this.findViewById(2131755224).setVisibility(0);
      TosUpdateDetailsActivity.this.findViewById(2131756137).setVisibility(8);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/TosUpdateDetailsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */