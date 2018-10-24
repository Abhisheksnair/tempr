package com.whatsapp.messaging;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.whatsapp.al;
import com.whatsapp.and;
import com.whatsapp.aus;
import com.whatsapp.pd;
import com.whatsapp.pv;
import com.whatsapp.util.Log;

public class CaptivePortalActivity
  extends Activity
{
  private final pv a = pv.a();
  private final and b = and.a();
  private final aus c = aus.a();
  private final pd d = pd.a();
  
  /* Error */
  public static boolean a(pv parampv, android.net.NetworkInfo paramNetworkInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 56	android/net/NetworkInfo:getType	()I
    //   4: iconst_1
    //   5: if_icmpeq +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: new 58	java/lang/StringBuilder
    //   13: dup
    //   14: ldc 60
    //   16: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: getstatic 68	com/whatsapp/aut:a	Ljava/lang/String;
    //   22: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 80	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   31: new 82	java/net/URL
    //   34: dup
    //   35: getstatic 68	com/whatsapp/aut:a	Ljava/lang/String;
    //   38: invokespecial 83	java/net/URL:<init>	(Ljava/lang/String;)V
    //   41: invokevirtual 87	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   44: checkcast 89	java/net/HttpURLConnection
    //   47: astore_2
    //   48: aload_2
    //   49: iconst_0
    //   50: invokevirtual 93	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   53: aload_2
    //   54: sipush 10000
    //   57: invokevirtual 97	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   60: aload_2
    //   61: sipush 10000
    //   64: invokevirtual 100	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   67: aload_2
    //   68: iconst_0
    //   69: invokevirtual 103	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   72: aload_2
    //   73: invokevirtual 107	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   76: pop
    //   77: aload_2
    //   78: invokevirtual 110	java/net/HttpURLConnection:getResponseCode	()I
    //   81: sipush 204
    //   84: if_icmpne +18 -> 102
    //   87: ldc 112
    //   89: invokestatic 80	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   92: aload_2
    //   93: ifnull +7 -> 100
    //   96: aload_2
    //   97: invokevirtual 115	java/net/HttpURLConnection:disconnect	()V
    //   100: iconst_0
    //   101: ireturn
    //   102: aload_0
    //   103: ldc 117
    //   105: invokevirtual 119	com/whatsapp/pv:a	(Ljava/lang/String;)V
    //   108: new 58	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 121
    //   114: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_1
    //   118: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 127	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 115	java/net/HttpURLConnection:disconnect	()V
    //   135: iconst_1
    //   136: ireturn
    //   137: astore_2
    //   138: aconst_null
    //   139: astore_0
    //   140: new 58	java/lang/StringBuilder
    //   143: dup
    //   144: ldc -127
    //   146: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: aload_2
    //   150: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: ldc -125
    //   155: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_1
    //   159: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 80	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   168: aload_0
    //   169: ifnull +7 -> 176
    //   172: aload_0
    //   173: invokevirtual 115	java/net/HttpURLConnection:disconnect	()V
    //   176: iconst_0
    //   177: ireturn
    //   178: astore_1
    //   179: aconst_null
    //   180: astore_0
    //   181: aload_0
    //   182: ifnull +7 -> 189
    //   185: aload_0
    //   186: invokevirtual 115	java/net/HttpURLConnection:disconnect	()V
    //   189: aload_1
    //   190: athrow
    //   191: astore_1
    //   192: aload_2
    //   193: astore_0
    //   194: goto -13 -> 181
    //   197: astore_1
    //   198: goto -17 -> 181
    //   201: astore_3
    //   202: aload_2
    //   203: astore_0
    //   204: aload_3
    //   205: astore_2
    //   206: goto -66 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	parampv	pv
    //   0	209	1	paramNetworkInfo	android.net.NetworkInfo
    //   47	85	2	localHttpURLConnection	java.net.HttpURLConnection
    //   137	66	2	localIOException1	java.io.IOException
    //   205	1	2	localObject	Object
    //   201	4	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   31	48	137	java/io/IOException
    //   31	48	178	finally
    //   48	92	191	finally
    //   102	127	191	finally
    //   140	168	197	finally
    //   48	92	201	java/io/IOException
    //   102	127	201	java/io/IOException
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.c.e();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.c.e();
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (Build.VERSION.SDK_INT >= 11) {
      setFinishOnTouchOutside(false);
    }
    WifiManager localWifiManager = this.b.d;
    WifiInfo localWifiInfo;
    int i;
    label61:
    label134:
    Button localButton2;
    Button localButton3;
    TextView localTextView;
    View localView;
    if (localWifiManager == null)
    {
      Log.w("captiveportalactivity/create wm=null");
      localWifiInfo = null;
      if (localWifiInfo == null) {
        break label318;
      }
      i = localWifiInfo.getNetworkId();
      if ((localWifiInfo == null) || (localWifiInfo == null)) {
        break label326;
      }
      paramBundle = localWifiInfo.getSSID();
      if ((paramBundle == null) || (paramBundle.length() < 2) || ((!paramBundle.startsWith("\"")) && (!paramBundle.startsWith("'"))) || ((!paramBundle.endsWith("\"")) && (!paramBundle.endsWith("'")))) {
        break label323;
      }
      paramBundle = paramBundle.substring(1, paramBundle.length() - 1);
      setContentView(al.a(this.a, getLayoutInflater(), 2130903417));
      getWindow().setLayout(-1, -2);
      Button localButton1 = (Button)findViewById(2131756275);
      localButton2 = (Button)findViewById(2131756274);
      localButton3 = (Button)findViewById(2131756276);
      localTextView = (TextView)findViewById(2131756272);
      localView = findViewById(2131756273);
      localButton1.setOnClickListener(b.a(this));
      if (localWifiInfo == null) {
        break label331;
      }
      localButton2.setText(getString(2131296807, new Object[] { paramBundle }));
      localTextView.setText(getString(2131298209, new Object[] { paramBundle }));
    }
    for (;;)
    {
      localButton3.setOnClickListener(c.a(this, localWifiManager));
      localButton2.setOnClickListener(d.a(this, i, paramBundle, localWifiManager));
      Log.i("captive portal activity created for " + paramBundle);
      return;
      localWifiInfo = localWifiManager.getConnectionInfo();
      break;
      label318:
      i = -1;
      break label61;
      label323:
      break label134;
      label326:
      paramBundle = null;
      break label134;
      label331:
      localButton2.setVisibility(8);
      if (localView != null) {
        localView.setVisibility(8);
      }
      localTextView.setText(2131298208);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.d.d.removeMessages(1);
    this.d.b();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.d.d.sendEmptyMessageDelayed(1, 3000L);
  }
  
  public static final class a
    extends AsyncTask<Void, Void, Boolean>
  {
    private final Context a;
    private final m b = m.a();
    
    public a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    private Boolean a()
    {
      try
      {
        if ((this.b.d) && (m.h())) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
        return Boolean.valueOf(false);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/CaptivePortalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */