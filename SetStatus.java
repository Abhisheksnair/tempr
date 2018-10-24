package com.whatsapp;

import a.a.a.a.d;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.a;
import android.support.v7.app.b.a;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.whatsapp.messaging.w;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.List;

public class SetStatus
  extends nh
{
  static ArrayList<String> n;
  static int u = 0;
  static int v = 2;
  private static int w = -1;
  final aaq o = aaq.a();
  final Handler p = new Handler(Looper.getMainLooper(), aid.a(this));
  TextEmojiLabel q;
  a r;
  boolean s;
  View t;
  private final dh x = dh.a();
  private final dh.a y = new dh.a()
  {
    public final void c(String paramAnonymousString)
    {
      SetStatus.this.runOnUiThread(ail.a(this, paramAnonymousString));
    }
  };
  
  /* Error */
  static void m()
  {
    // Byte code:
    //   0: new 104	java/io/ObjectOutputStream
    //   3: dup
    //   4: invokestatic 109	com/whatsapp/u:a	()Landroid/content/Context;
    //   7: ldc 111
    //   9: iconst_0
    //   10: invokevirtual 117	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   13: invokespecial 120	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_1
    //   17: aload_1
    //   18: astore_0
    //   19: new 122	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   26: astore_2
    //   27: aload_1
    //   28: astore_0
    //   29: getstatic 125	com/whatsapp/SetStatus:n	Ljava/util/ArrayList;
    //   32: invokevirtual 131	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   35: astore_3
    //   36: aload_1
    //   37: astore_0
    //   38: aload_3
    //   39: invokeinterface 137 1 0
    //   44: ifeq +39 -> 83
    //   47: aload_1
    //   48: astore_0
    //   49: aload_2
    //   50: aload_3
    //   51: invokeinterface 141 1 0
    //   56: checkcast 143	java/lang/String
    //   59: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc -107
    //   64: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: goto -32 -> 36
    //   71: astore_2
    //   72: aload_1
    //   73: astore_0
    //   74: aload_2
    //   75: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   78: aload_1
    //   79: invokestatic 157	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   82: return
    //   83: aload_1
    //   84: astore_0
    //   85: aload_2
    //   86: invokevirtual 161	java/lang/StringBuilder:length	()I
    //   89: iconst_1
    //   90: if_icmple +16 -> 106
    //   93: aload_1
    //   94: astore_0
    //   95: aload_2
    //   96: aload_2
    //   97: invokevirtual 161	java/lang/StringBuilder:length	()I
    //   100: iconst_1
    //   101: isub
    //   102: invokevirtual 165	java/lang/StringBuilder:deleteCharAt	(I)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_1
    //   107: astore_0
    //   108: new 122	java/lang/StringBuilder
    //   111: dup
    //   112: ldc -89
    //   114: invokespecial 170	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_2
    //   118: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 178	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   130: aload_1
    //   131: astore_0
    //   132: aload_1
    //   133: aload_2
    //   134: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokevirtual 182	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   140: aload_1
    //   141: invokestatic 157	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   144: return
    //   145: astore_1
    //   146: aconst_null
    //   147: astore_0
    //   148: aload_0
    //   149: invokestatic 157	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   152: aload_1
    //   153: athrow
    //   154: astore_1
    //   155: goto -7 -> 148
    //   158: astore_2
    //   159: aconst_null
    //   160: astore_1
    //   161: goto -89 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	131	0	localObjectOutputStream1	java.io.ObjectOutputStream
    //   16	125	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   145	8	1	localObject1	Object
    //   154	1	1	localObject2	Object
    //   160	1	1	localObject3	Object
    //   26	24	2	localStringBuilder	StringBuilder
    //   71	63	2	localIOException1	java.io.IOException
    //   158	1	2	localIOException2	java.io.IOException
    //   35	16	3	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   19	27	71	java/io/IOException
    //   29	36	71	java/io/IOException
    //   38	47	71	java/io/IOException
    //   49	68	71	java/io/IOException
    //   85	93	71	java/io/IOException
    //   95	106	71	java/io/IOException
    //   108	130	71	java/io/IOException
    //   132	140	71	java/io/IOException
    //   0	17	145	finally
    //   19	27	154	finally
    //   29	36	154	finally
    //   38	47	154	finally
    //   49	68	154	finally
    //   74	78	154	finally
    //   85	93	154	finally
    //   95	106	154	finally
    //   108	130	154	finally
    //   132	140	154	finally
    //   0	17	158	java/io/IOException
  }
  
  private ArrayList<String> p()
  {
    TypedArray localTypedArray = getResources().obtainTypedArray(2131689479);
    try
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localTypedArray.length())
      {
        localArrayList.add(localTypedArray.getString(i));
        i += 1;
      }
      return localArrayList;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
  
  /* Error */
  private boolean q()
  {
    // Byte code:
    //   0: new 217	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 221	com/whatsapp/SetStatus:getFilesDir	()Ljava/io/File;
    //   8: ldc 111
    //   10: invokespecial 224	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   13: invokevirtual 227	java/io/File:exists	()Z
    //   16: ifeq +113 -> 129
    //   19: new 229	java/io/ObjectInputStream
    //   22: dup
    //   23: aload_0
    //   24: ldc 111
    //   26: invokevirtual 233	com/whatsapp/SetStatus:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   29: invokespecial 236	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore 4
    //   34: aload 4
    //   36: astore_3
    //   37: aload 4
    //   39: invokevirtual 239	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   42: checkcast 143	java/lang/String
    //   45: astore 5
    //   47: aload 4
    //   49: astore_3
    //   50: new 127	java/util/ArrayList
    //   53: dup
    //   54: invokespecial 197	java/util/ArrayList:<init>	()V
    //   57: putstatic 125	com/whatsapp/SetStatus:n	Ljava/util/ArrayList;
    //   60: aload 4
    //   62: astore_3
    //   63: aload 5
    //   65: ldc -107
    //   67: invokevirtual 243	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   70: astore 5
    //   72: aload 4
    //   74: astore_3
    //   75: aload 5
    //   77: arraylength
    //   78: istore_2
    //   79: iconst_0
    //   80: istore_1
    //   81: iload_1
    //   82: iload_2
    //   83: if_icmpge +39 -> 122
    //   86: aload 5
    //   88: iload_1
    //   89: aaload
    //   90: astore 6
    //   92: aload 4
    //   94: astore_3
    //   95: aload 6
    //   97: invokevirtual 244	java/lang/String:length	()I
    //   100: ifle +15 -> 115
    //   103: aload 4
    //   105: astore_3
    //   106: getstatic 125	com/whatsapp/SetStatus:n	Ljava/util/ArrayList;
    //   109: aload 6
    //   111: invokevirtual 208	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   114: pop
    //   115: iload_1
    //   116: iconst_1
    //   117: iadd
    //   118: istore_1
    //   119: goto -38 -> 81
    //   122: aload 4
    //   124: invokestatic 157	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   127: iconst_1
    //   128: ireturn
    //   129: aconst_null
    //   130: invokestatic 157	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   133: iconst_0
    //   134: ireturn
    //   135: astore 5
    //   137: aconst_null
    //   138: astore 4
    //   140: aload 4
    //   142: astore_3
    //   143: ldc -10
    //   145: aload 5
    //   147: invokestatic 249	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   150: aload 4
    //   152: invokestatic 157	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   155: goto -22 -> 133
    //   158: astore 5
    //   160: aconst_null
    //   161: astore 4
    //   163: aload 4
    //   165: astore_3
    //   166: aload 5
    //   168: invokestatic 252	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   171: aload 4
    //   173: invokestatic 157	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   176: goto -43 -> 133
    //   179: astore 4
    //   181: aconst_null
    //   182: astore_3
    //   183: aload_3
    //   184: invokestatic 157	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   187: aload 4
    //   189: athrow
    //   190: astore 4
    //   192: goto -9 -> 183
    //   195: astore 5
    //   197: goto -34 -> 163
    //   200: astore 5
    //   202: goto -62 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	SetStatus
    //   80	39	1	i	int
    //   78	6	2	j	int
    //   36	148	3	localObjectInputStream1	java.io.ObjectInputStream
    //   32	140	4	localObjectInputStream2	java.io.ObjectInputStream
    //   179	9	4	localObject1	Object
    //   190	1	4	localObject2	Object
    //   45	42	5	localObject3	Object
    //   135	11	5	localClassNotFoundException1	ClassNotFoundException
    //   158	9	5	localIOException1	java.io.IOException
    //   195	1	5	localIOException2	java.io.IOException
    //   200	1	5	localClassNotFoundException2	ClassNotFoundException
    //   90	20	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	34	135	java/lang/ClassNotFoundException
    //   0	34	158	java/io/IOException
    //   0	34	179	finally
    //   37	47	190	finally
    //   50	60	190	finally
    //   63	72	190	finally
    //   75	79	190	finally
    //   95	103	190	finally
    //   106	115	190	finally
    //   143	150	190	finally
    //   166	171	190	finally
    //   37	47	195	java/io/IOException
    //   50	60	195	java/io/IOException
    //   63	72	195	java/io/IOException
    //   75	79	195	java/io/IOException
    //   95	103	195	java/io/IOException
    //   106	115	195	java/io/IOException
    //   37	47	200	java/lang/ClassNotFoundException
    //   50	60	200	java/lang/ClassNotFoundException
    //   63	72	200	java/lang/ClassNotFoundException
    //   75	79	200	java/lang/ClassNotFoundException
    //   95	103	200	java/lang/ClassNotFoundException
    //   106	115	200	java/lang/ClassNotFoundException
  }
  
  final void a(String paramString)
  {
    d.a(this, 2);
    if (!this.ay.a(paramString, new aie(this), new aif(this), new aig(this), null)) {
      l();
    }
    this.p.sendEmptyMessageDelayed(0, 32000L);
  }
  
  final void l()
  {
    this.p.removeMessages(0);
    this.p.sendEmptyMessage(0);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      paramIntent = paramIntent.getStringExtra("status");
      if (paramInt1 != u) {
        break label33;
      }
      n.add(0, paramIntent);
      a(paramIntent);
    }
    label33:
    do
    {
      return;
      if (w >= 0)
      {
        n.remove(w);
        n.add(w, paramIntent);
      }
    } while (paramInt1 != v);
    a(paramIntent);
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    switch (paramMenuItem.getItemId())
    {
    default: 
      return true;
    }
    n.remove(localAdapterContextMenuInfo.position);
    w = -1;
    this.r.notifyDataSetChanged();
    m();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("status/create");
    paramBundle = i();
    if (paramBundle != null) {
      paramBundle.a(true);
    }
    setContentView(2130903356);
    pb.a(14);
    this.t = findViewById(2131756069);
    this.t.setOnClickListener(aij.a(this));
    this.q = ((TextEmojiLabel)findViewById(2131756070));
    this.q.a(this.o.c());
    if (!q()) {
      n = p();
    }
    paramBundle = (ListView)findViewById(2131755943);
    paramBundle.setEmptyView(findViewById(2131756072));
    this.r = new a(this, n);
    paramBundle.setAdapter(this.r);
    paramBundle.setOnItemClickListener(aik.a(this));
    registerForContextMenu(paramBundle);
    this.x.registerObserver(this.y);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 1, 0, getString(2131296646));
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 0: 
      return ProgressDialog.show(this, getString(2131297051), getString(2131297050), true, false);
    case 1: 
      return ProgressDialog.show(this, getString(2131297048), getString(2131297047), true, false);
    case 50: 
      localObject = new aih(this);
      return new oe(this, 2131296298, this.o.c(), (oe.a)localObject, 139, 0, 2131297287);
    case 2: 
      localObject = new ProgressDialog(this);
      ((ProgressDialog)localObject).setMessage(getString(2131297051));
      ((ProgressDialog)localObject).setIndeterminate(true);
      ((ProgressDialog)localObject).setCancelable(false);
      return (Dialog)localObject;
    }
    return new b.a(this).b(2131296636).a(2131296633, aii.a(this)).b(2131296398, null).a();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(0, 0, 0, 2131296633);
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Log.i("status/destroy");
    this.x.unregisterObserver(this.y);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 0: 
      if (n.size() == 0)
      {
        b_(2131297291);
        return true;
      }
      d.a(this, 3);
      return true;
    }
    finish();
    return true;
  }
  
  final class a
    extends ArrayAdapter<String>
  {
    private ArrayList<String> b;
    
    public a(int paramInt)
    {
      super(2131756073, localList);
      this.b = localList;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramView = (LayoutInflater)SetStatus.this.getSystemService("layout_inflater");
        paramViewGroup = al.a(SetStatus.this.aq, paramView, 2130903357);
      }
      paramView = (String)this.b.get(paramInt);
      TextEmojiLabel localTextEmojiLabel;
      if (paramView != null)
      {
        localTextEmojiLabel = (TextEmojiLabel)paramViewGroup.findViewById(2131756073);
        if (localTextEmojiLabel != null)
        {
          if (!paramView.equals(SetStatus.a(SetStatus.this).c())) {
            break label108;
          }
          localTextEmojiLabel.setTextColor(Color.argb(255, 51, 102, 153));
        }
      }
      for (;;)
      {
        localTextEmojiLabel.a(paramView);
        return paramViewGroup;
        label108:
        localTextEmojiLabel.setTextColor(-16777216);
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SetStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */