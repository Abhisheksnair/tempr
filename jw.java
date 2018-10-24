package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.f.h;
import android.view.View;
import android.view.Window;
import com.whatsapp.data.ad;
import com.whatsapp.data.e;
import com.whatsapp.data.l;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class jw
  extends nm
  implements jz
{
  android.support.v7.view.b Z;
  HashMap<j.b, j> aa;
  protected final va ab = va.a();
  protected final ad ac = ad.a();
  protected final di ad = di.a();
  protected final e ae = e.a();
  protected final l af = l.a();
  protected final atv ag = atv.a();
  protected final lt ah = lt.a();
  protected final jd ai = new jd(this.ad);
  protected final aoj aj = aoj.a();
  private j n;
  private HashMap<j.b, Integer> o;
  private Map<j.b, h<Long, Integer>> p;
  
  private static boolean a(long paramLong, int paramInt)
  {
    return (paramLong < 6000L) || (paramInt < 3);
  }
  
  private void l()
  {
    if (this.Z != null)
    {
      if (this.aa.size() == 0) {
        P();
      }
    }
    else {
      return;
    }
    this.Z.d();
  }
  
  /* Error */
  private void m()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 130	com/whatsapp/jw:p	Ljava/util/Map;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 130	com/whatsapp/jw:p	Ljava/util/Map;
    //   18: invokeinterface 135 1 0
    //   23: goto -12 -> 11
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	jw
    //   6	2	1	localMap	Map
    //   26	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   14	23	26	finally
  }
  
  public final boolean O()
  {
    return this.aa != null;
  }
  
  final void P()
  {
    if (this.Z != null) {
      this.Z.c();
    }
  }
  
  final Collection<j> Q()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.aa != null) {
      localArrayList.addAll(this.aa.values());
    }
    while (this.n == null) {
      return localArrayList;
    }
    localArrayList.add(this.n);
    return localArrayList;
  }
  
  public final void a(android.support.v7.view.b paramb)
  {
    super.a(paramb);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(android.support.v4.content.b.c(this, 2131623951));
    }
  }
  
  public final void a(j paramj)
  {
    this.aa = new HashMap();
    this.aa.put(paramj.e, paramj);
    w();
    l();
  }
  
  public final void a(j paramj, int paramInt)
  {
    if (this.o == null) {
      this.o = new HashMap();
    }
    this.o.put(paramj.e, Integer.valueOf(paramInt));
  }
  
  /* Error */
  public final boolean a(j.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 130	com/whatsapp/jw:p	Ljava/util/Map;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 130	com/whatsapp/jw:p	Ljava/util/Map;
    //   21: aload_1
    //   22: invokeinterface 216 2 0
    //   27: checkcast 218	android/support/v4/f/h
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +36 -> 68
    //   35: aload_1
    //   36: getfield 221	android/support/v4/f/h:a	Ljava/lang/Object;
    //   39: checkcast 223	java/lang/Long
    //   42: invokevirtual 227	java/lang/Long:longValue	()J
    //   45: aload_1
    //   46: getfield 230	android/support/v4/f/h:b	Ljava/lang/Object;
    //   49: checkcast 207	java/lang/Integer
    //   52: invokevirtual 233	java/lang/Integer:intValue	()I
    //   55: invokestatic 235	com/whatsapp/jw:a	(JI)Z
    //   58: istore_2
    //   59: iload_2
    //   60: ifeq +8 -> 68
    //   63: iconst_1
    //   64: istore_2
    //   65: goto -52 -> 13
    //   68: iconst_0
    //   69: istore_2
    //   70: goto -57 -> 13
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	jw
    //   0	78	1	paramb	j.b
    //   12	58	2	bool	boolean
    //   6	2	3	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   2	7	73	finally
    //   17	31	73	finally
    //   35	59	73	finally
  }
  
  /* Error */
  public final boolean a(j.b paramb, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 130	com/whatsapp/jw:p	Ljava/util/Map;
    //   6: astore 7
    //   8: aload 7
    //   10: ifnonnull +11 -> 21
    //   13: iconst_0
    //   14: istore 4
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 4
    //   20: ireturn
    //   21: aload_0
    //   22: getfield 130	com/whatsapp/jw:p	Ljava/util/Map;
    //   25: aload_1
    //   26: invokeinterface 216 2 0
    //   31: checkcast 218	android/support/v4/f/h
    //   34: astore 7
    //   36: aload 7
    //   38: ifnonnull +9 -> 47
    //   41: iconst_0
    //   42: istore 4
    //   44: goto -28 -> 16
    //   47: aload 7
    //   49: getfield 221	android/support/v4/f/h:a	Ljava/lang/Object;
    //   52: checkcast 223	java/lang/Long
    //   55: invokevirtual 227	java/lang/Long:longValue	()J
    //   58: lload_2
    //   59: ladd
    //   60: lstore_2
    //   61: aload 7
    //   63: getfield 230	android/support/v4/f/h:b	Ljava/lang/Object;
    //   66: checkcast 207	java/lang/Integer
    //   69: invokevirtual 233	java/lang/Integer:intValue	()I
    //   72: istore 6
    //   74: iload 6
    //   76: istore 5
    //   78: iload 4
    //   80: ifeq +9 -> 89
    //   83: iload 6
    //   85: iconst_1
    //   86: iadd
    //   87: istore 5
    //   89: aload_0
    //   90: getfield 130	com/whatsapp/jw:p	Ljava/util/Map;
    //   93: aload_1
    //   94: lload_2
    //   95: invokestatic 239	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   98: iload 5
    //   100: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: invokestatic 242	android/support/v4/f/h:a	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/support/v4/f/h;
    //   106: invokeinterface 243 3 0
    //   111: pop
    //   112: lload_2
    //   113: iload 5
    //   115: invokestatic 235	com/whatsapp/jw:a	(JI)Z
    //   118: istore 4
    //   120: goto -104 -> 16
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	jw
    //   0	128	1	paramb	j.b
    //   0	128	2	paramLong	long
    //   0	128	4	paramBoolean	boolean
    //   76	38	5	i	int
    //   72	15	6	j	int
    //   6	56	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	123	finally
    //   21	36	123	finally
    //   47	74	123	finally
    //   89	120	123	finally
  }
  
  public void animateStar(View paramView) {}
  
  public void b(android.support.v7.view.b paramb)
  {
    super.b(paramb);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(android.support.v4.content.b.c(this, 2131624092));
    }
  }
  
  public final void b(j.b paramb)
  {
    try
    {
      if (this.p == null) {
        this.p = new HashMap();
      }
      this.p.put(paramb, h.a(Long.valueOf(0L), Integer.valueOf(0)));
      return;
    }
    finally {}
  }
  
  public final boolean b(j paramj)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (this.aa != null)
    {
      if (!this.aa.containsKey(paramj.e)) {
        break label45;
      }
      this.aa.remove(paramj.e);
    }
    for (bool1 = bool2;; bool1 = true)
    {
      l();
      return bool1;
      label45:
      this.aa.put(paramj.e, paramj);
    }
  }
  
  public final boolean c(j paramj)
  {
    return (this.aa != null) && (this.aa.containsKey(paramj.e));
  }
  
  public final int d(j paramj)
  {
    if (this.o == null) {
      return 0;
    }
    paramj = (Integer)this.o.get(paramj.e);
    if (paramj == null) {
      return 0;
    }
    return paramj.intValue();
  }
  
  public final void e(j paramj)
  {
    P();
    this.n = paramj;
    Intent localIntent = new Intent(this, ContactPicker.class);
    localIntent.putExtra("forward", true);
    localIntent.putExtra("forward_jid", paramj.e.a);
    localIntent.putIntegerArrayListExtra("message_types", new ArrayList(Collections.singleton(Integer.valueOf(Byte.valueOf(paramj.s).intValue()))));
    if (paramj.s == 3) {}
    for (long l = paramj.w * 1000L;; l = 0L)
    {
      localIntent.putExtra("forward_video_duration", l);
      startActivityForResult(localIntent, 2);
      return;
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 13: 
      if ((this.aa == null) || (this.aa.isEmpty()))
      {
        Log.e("conversation/dialog/delete no messages");
        return super.onCreateDialog(paramInt);
      }
      Log.i("conversation/dialog/delete/" + this.aa.size());
      return d.a(this, this.aq, this.ao, this.aj, this.ae, this.aa.values(), null, 13, true, new jx(this));
    }
    if ((this.aa == null) || (this.aa.isEmpty()))
    {
      Log.e("conversation/dialog/revoke-no-messages");
      return super.onCreateDialog(paramInt);
    }
    Log.i("conversation/dialog/revoke/" + this.aa.size());
    return a.d.a(this, this.aq, this.aj, this.aa.values(), new jy(this));
  }
  
  protected void onDestroy()
  {
    this.ai.a();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    m();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle != null)
    {
      Object localObject = paramBundle.getParcelableArrayList("selected_messages");
      if (localObject != null)
      {
        this.aa = new HashMap();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FMessageKey localFMessageKey = (FMessageKey)((Iterator)localObject).next();
          this.aa.put(localFMessageKey.a, this.af.a(localFMessageKey.a));
        }
        w();
        l();
      }
      paramBundle = (FMessageKey)paramBundle.getParcelable("forwarded_message");
      if (paramBundle != null) {
        this.n = this.af.a(paramBundle.a);
      }
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.aa != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.aa.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new FMessageKey(((j)localIterator.next()).e));
      }
      paramBundle.putParcelableArrayList("selected_messages", localArrayList);
    }
    if (this.n != null) {
      paramBundle.putParcelable("forwarded_message", new FMessageKey(this.n.e));
    }
  }
  
  abstract boolean w();
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */