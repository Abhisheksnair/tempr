package com.whatsapp;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.whatsapp.messaging.w;
import com.whatsapp.util.Log;

public class anv
{
  public static final int[] a = { 1, 3, 3 };
  private static volatile anv b;
  private final ant c;
  private final w d;
  private final aic e;
  private final atv f;
  
  private anv(ant paramant, w paramw, aic paramaic, atv paramatv)
  {
    this.c = paramant;
    this.d = paramw;
    this.e = paramaic;
    this.f = paramatv;
  }
  
  public static anv a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new anv(ant.a(), w.a(), aic.a(), atv.a());
      }
      return b;
    }
    finally {}
  }
  
  private void n()
  {
    try
    {
      Log.i("tosupdate/resetTosAcceptance");
      this.f.c().remove("tos_accepted_time").remove("tos_accepted_ack").remove("tos_opted_out").remove("tos_allow_opt_out").apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(int paramInt)
  {
    try
    {
      Log.i("tosupdate/onTosStageAck stage:" + paramInt);
      this.f.c().putBoolean("tos_stage_start_ack" + paramInt, true).apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final void a(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 92	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 113
    //   8: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: lload_1
    //   12: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15: ldc 118
    //   17: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: iload_3
    //   21: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   24: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 69	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 35	com/whatsapp/anv:f	Lcom/whatsapp/atv;
    //   34: invokevirtual 128	com/whatsapp/atv:L	()J
    //   37: lstore 4
    //   39: lload 4
    //   41: lconst_0
    //   42: lcmp
    //   43: ifle +65 -> 108
    //   46: lload_1
    //   47: lconst_0
    //   48: lcmp
    //   49: ifne +59 -> 108
    //   52: new 92	java/lang/StringBuilder
    //   55: dup
    //   56: ldc -126
    //   58: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: lload 4
    //   63: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   66: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 69	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   72: aload_0
    //   73: getfield 35	com/whatsapp/anv:f	Lcom/whatsapp/atv;
    //   76: invokevirtual 72	com/whatsapp/atv:c	()Landroid/content/SharedPreferences$Editor;
    //   79: ldc 82
    //   81: invokeinterface 80 2 0
    //   86: invokeinterface 89 1 0
    //   91: aload_0
    //   92: getfield 31	com/whatsapp/anv:d	Lcom/whatsapp/messaging/w;
    //   95: aload_0
    //   96: getfield 35	com/whatsapp/anv:f	Lcom/whatsapp/atv;
    //   99: invokevirtual 134	com/whatsapp/atv:N	()Z
    //   102: invokevirtual 137	com/whatsapp/messaging/w:a	(Z)V
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: aload_0
    //   109: getfield 35	com/whatsapp/anv:f	Lcom/whatsapp/atv;
    //   112: invokevirtual 72	com/whatsapp/atv:c	()Landroid/content/SharedPreferences$Editor;
    //   115: ldc 74
    //   117: lload_1
    //   118: invokeinterface 141 4 0
    //   123: ldc 82
    //   125: iconst_1
    //   126: invokeinterface 110 3 0
    //   131: ldc 86
    //   133: iload_3
    //   134: invokeinterface 110 3 0
    //   139: invokeinterface 89 1 0
    //   144: goto -39 -> 105
    //   147: astore 6
    //   149: aload_0
    //   150: monitorexit
    //   151: aload 6
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	anv
    //   0	154	1	paramLong	long
    //   0	154	3	paramBoolean	boolean
    //   37	25	4	l	long
    //   147	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	39	147	finally
    //   52	105	147	finally
    //   108	144	147	finally
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 92	java/lang/StringBuilder
    //   5: dup
    //   6: ldc -113
    //   8: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: iload_1
    //   12: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18: invokestatic 69	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   21: aload_0
    //   22: getfield 35	com/whatsapp/anv:f	Lcom/whatsapp/atv;
    //   25: astore 4
    //   27: aload_0
    //   28: getfield 29	com/whatsapp/anv:c	Lcom/whatsapp/ant;
    //   31: invokevirtual 145	com/whatsapp/ant:b	()J
    //   34: lstore_2
    //   35: aload 4
    //   37: invokevirtual 72	com/whatsapp/atv:c	()Landroid/content/SharedPreferences$Editor;
    //   40: ldc 74
    //   42: lload_2
    //   43: invokeinterface 141 4 0
    //   48: ldc 84
    //   50: iload_1
    //   51: invokeinterface 110 3 0
    //   56: astore 4
    //   58: iload_1
    //   59: ifne +23 -> 82
    //   62: iconst_1
    //   63: istore_1
    //   64: aload 4
    //   66: ldc 86
    //   68: iload_1
    //   69: invokeinterface 110 3 0
    //   74: invokeinterface 89 1 0
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: iconst_0
    //   83: istore_1
    //   84: goto -20 -> 64
    //   87: astore 4
    //   89: aload_0
    //   90: monitorexit
    //   91: aload 4
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	anv
    //   0	94	1	paramBoolean	boolean
    //   34	9	2	l	long
    //   25	40	4	localObject1	Object
    //   87	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	58	87	finally
    //   64	79	87	finally
  }
  
  public final int b()
  {
    int j = 1;
    int i = 3;
    for (;;)
    {
      try
      {
        if (this.f.L() == 0L)
        {
          boolean bool = aic.d();
          if (bool) {}
        }
        else
        {
          i = 0;
          return i;
        }
        int k = this.f.M();
        if (k != 3) {
          if (k == 0)
          {
            this.f.f(1);
            i = j;
            long l2 = this.f.g(i);
            long l1 = l2;
            if (l2 == 0L)
            {
              l1 = this.c.b();
              Log.i("tosupdate/init stage:" + i + " start:" + l1);
              this.f.a(i, l1);
            }
            j = i;
            if (l1 + aic.a(i) <= this.c.b())
            {
              j = i + 1;
              if ((aic.a(j) == 0L) && (j < 3))
              {
                j += 1;
                continue;
              }
              l1 = this.c.b();
              this.f.f(j);
              this.f.a(j, l1);
              Log.i("tosupdate/advance stage:" + j + " start:" + l1);
            }
            i = j;
            if (k != j)
            {
              this.d.a(j);
              i = j;
            }
          }
          else
          {
            i = k;
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public final void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: new 92	java/lang/StringBuilder
    //   7: dup
    //   8: ldc -84
    //   10: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   17: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: invokestatic 69	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: getfield 35	com/whatsapp/anv:f	Lcom/whatsapp/atv;
    //   27: invokevirtual 128	com/whatsapp/atv:L	()J
    //   30: lstore 5
    //   32: lload 5
    //   34: lstore_3
    //   35: lload 5
    //   37: lconst_0
    //   38: lcmp
    //   39: ifne +11 -> 50
    //   42: aload_0
    //   43: getfield 29	com/whatsapp/anv:c	Lcom/whatsapp/ant;
    //   46: invokevirtual 145	com/whatsapp/ant:b	()J
    //   49: lstore_3
    //   50: aload_0
    //   51: getfield 35	com/whatsapp/anv:f	Lcom/whatsapp/atv;
    //   54: invokevirtual 72	com/whatsapp/atv:c	()Landroid/content/SharedPreferences$Editor;
    //   57: ldc 74
    //   59: lload_3
    //   60: invokeinterface 141 4 0
    //   65: ldc 82
    //   67: iconst_1
    //   68: invokeinterface 110 3 0
    //   73: ldc 84
    //   75: iload_1
    //   76: invokeinterface 110 3 0
    //   81: astore 7
    //   83: iload_1
    //   84: ifne +23 -> 107
    //   87: iload_2
    //   88: istore_1
    //   89: aload 7
    //   91: ldc 86
    //   93: iload_1
    //   94: invokeinterface 110 3 0
    //   99: invokeinterface 89 1 0
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: iconst_0
    //   108: istore_1
    //   109: goto -20 -> 89
    //   112: astore 7
    //   114: aload_0
    //   115: monitorexit
    //   116: aload 7
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	anv
    //   0	119	1	paramBoolean	boolean
    //   1	87	2	bool	boolean
    //   34	26	3	l1	long
    //   30	6	5	l2	long
    //   81	9	7	localEditor	SharedPreferences.Editor
    //   112	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	32	112	finally
    //   42	50	112	finally
    //   50	83	112	finally
    //   89	104	112	finally
  }
  
  /* Error */
  public final int c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/whatsapp/anv:f	Lcom/whatsapp/atv;
    //   6: invokevirtual 128	com/whatsapp/atv:L	()J
    //   9: lconst_0
    //   10: lcmp
    //   11: ifne +11 -> 22
    //   14: invokestatic 148	com/whatsapp/aic:d	()Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifne +9 -> 28
    //   22: iconst_0
    //   23: istore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_1
    //   27: ireturn
    //   28: aload_0
    //   29: getfield 35	com/whatsapp/anv:f	Lcom/whatsapp/atv;
    //   32: invokevirtual 151	com/whatsapp/atv:M	()I
    //   35: istore_1
    //   36: goto -12 -> 24
    //   39: astore_3
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_3
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	anv
    //   23	13	1	i	int
    //   17	2	2	bool	boolean
    //   39	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	39	finally
    //   28	36	39	finally
  }
  
  /* Error */
  public final boolean d()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 174	com/whatsapp/anv:c	()I
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmpne +52 -> 63
    //   14: aload_0
    //   15: getfield 35	com/whatsapp/anv:f	Lcom/whatsapp/atv;
    //   18: getfield 177	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   21: ldc -77
    //   23: lconst_0
    //   24: invokeinterface 185 4 0
    //   29: lstore 4
    //   31: aload_0
    //   32: getfield 29	com/whatsapp/anv:c	Lcom/whatsapp/ant;
    //   35: invokevirtual 145	com/whatsapp/ant:b	()J
    //   38: lstore 6
    //   40: lload 4
    //   42: ldc2_w 186
    //   45: ladd
    //   46: lload 6
    //   48: lcmp
    //   49: ifge +9 -> 58
    //   52: iload_3
    //   53: istore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: iload_2
    //   57: ireturn
    //   58: iconst_0
    //   59: istore_2
    //   60: goto -6 -> 54
    //   63: iload_3
    //   64: istore_2
    //   65: iload_1
    //   66: iconst_2
    //   67: if_icmpeq -13 -> 54
    //   70: iload_3
    //   71: istore_2
    //   72: iload_1
    //   73: iconst_3
    //   74: if_icmpeq -20 -> 54
    //   77: iconst_0
    //   78: istore_2
    //   79: goto -25 -> 54
    //   82: astore 8
    //   84: aload_0
    //   85: monitorexit
    //   86: aload 8
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	anv
    //   8	67	1	i	int
    //   53	26	2	bool1	boolean
    //   1	70	3	bool2	boolean
    //   29	12	4	l1	long
    //   38	9	6	l2	long
    //   82	5	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	82	finally
    //   14	40	82	finally
  }
  
  public final boolean e()
  {
    int i = c();
    return (i != 2) && (i != 3);
  }
  
  /* Error */
  public final long f()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: lload_3
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 35	com/whatsapp/anv:f	Lcom/whatsapp/atv;
    //   10: invokevirtual 128	com/whatsapp/atv:L	()J
    //   13: lconst_0
    //   14: lcmp
    //   15: ifne +15 -> 30
    //   18: invokestatic 148	com/whatsapp/aic:d	()Z
    //   21: istore 5
    //   23: iload 5
    //   25: ifne +9 -> 34
    //   28: lload_3
    //   29: lstore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: lload_1
    //   33: lreturn
    //   34: aload_0
    //   35: getfield 35	com/whatsapp/anv:f	Lcom/whatsapp/atv;
    //   38: iconst_1
    //   39: invokevirtual 157	com/whatsapp/atv:g	(I)J
    //   42: lstore_1
    //   43: iconst_1
    //   44: invokestatic 166	com/whatsapp/aic:a	(I)J
    //   47: lstore_3
    //   48: lload_1
    //   49: lload_3
    //   50: ladd
    //   51: lstore_1
    //   52: goto -22 -> 30
    //   55: astore 6
    //   57: aload_0
    //   58: monitorexit
    //   59: aload 6
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	anv
    //   5	47	1	l1	long
    //   1	49	3	l2	long
    //   21	3	5	bool	boolean
    //   55	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	23	55	finally
    //   34	48	55	finally
  }
  
  public final boolean g()
  {
    boolean bool2 = false;
    try
    {
      long l = this.f.L();
      boolean bool1 = bool2;
      if (l != 0L)
      {
        bool1 = bool2;
        if (l + 2592000000L > this.c.b())
        {
          boolean bool3 = this.f.a.getBoolean("tos_allow_opt_out", false);
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    finally {}
  }
  
  /* Error */
  public final boolean h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/whatsapp/anv:f	Lcom/whatsapp/atv;
    //   6: invokevirtual 128	com/whatsapp/atv:L	()J
    //   9: lstore_1
    //   10: lload_1
    //   11: lconst_0
    //   12: lcmp
    //   13: ifle +9 -> 22
    //   16: iconst_1
    //   17: istore_3
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_3
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_3
    //   24: goto -6 -> 18
    //   27: astore 4
    //   29: aload_0
    //   30: monitorexit
    //   31: aload 4
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	anv
    //   9	2	1	l	long
    //   17	7	3	bool	boolean
    //   27	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	27	finally
  }
  
  public final boolean i()
  {
    try
    {
      boolean bool = this.f.N();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void j()
  {
    try
    {
      k();
      n();
      aic.e();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void k()
  {
    try
    {
      Log.i("tosupdate/resetTosUpdate");
      SharedPreferences.Editor localEditor = this.f.c().remove("tos_current_stage_id").remove("tos_last_stage_1_display_time");
      int[] arrayOfInt = a;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfInt[i];
        localEditor.remove("tos_stage_start_time" + k);
        localEditor.remove("tos_stage_start_ack" + k);
        i += 1;
      }
      localEditor.apply();
      return;
    }
    finally {}
  }
  
  public final void l()
  {
    try
    {
      Log.i("tosupdate/onTosStageOneDismissed");
      atv localatv = this.f;
      long l = this.c.b();
      localatv.c().putLong("tos_last_stage_1_display_time", l).apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void m()
  {
    try
    {
      int i = this.f.M();
      if ((i != 0) && (!this.f.a.getBoolean("tos_stage_start_ack" + i, false))) {
        this.d.a(i);
      }
      if ((this.f.L() != 0L) && (!this.f.a.getBoolean("tos_accepted_ack", false))) {
        this.d.a(this.f.N());
      }
      return;
    }
    finally {}
  }
  
  public static final class a
  {
    public long a;
    public int b;
    
    public a(long paramLong, int paramInt)
    {
      this.a = paramLong;
      this.b = paramInt;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/anv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */