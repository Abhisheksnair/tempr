package com.whatsapp.messaging;

import android.os.ConditionVariable;
import android.os.Message;
import android.text.TextUtils;
import com.whatsapp.MediaData;
import com.whatsapp.att;
import com.whatsapp.auj;
import com.whatsapp.auj.m;
import com.whatsapp.auj.q;
import com.whatsapp.jobqueue.job.SendWebForwardJob;
import com.whatsapp.protocol.ar;
import com.whatsapp.protocol.av;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.aa;
import com.whatsapp.util.bu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ae
{
  private static volatile ae b;
  final att a;
  private final AtomicInteger c = new AtomicInteger();
  private final AtomicInteger d = new AtomicInteger();
  private final ReentrantLock e = new ReentrantLock();
  private final Condition f = this.e.newCondition();
  
  private ae(att paramatt)
  {
    this.a = paramatt;
  }
  
  public static ae a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new ae(att.a());
      }
      return b;
    }
    finally {}
  }
  
  public static av a(j paramj, j.b paramb)
  {
    int k = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramj.s == 10)
    {
      localObject1 = new av();
      ((av)localObject1).i = 16;
      ((av)localObject1).c = paramj.e.c;
      ((av)localObject1).d = paramj.e.a;
      ((av)localObject1).l = (paramj.n / 1000L);
      ((av)localObject1).p = paramj.e.b;
      ((av)localObject1).f = paramj.f;
      ((av)localObject1).a = paramj.z;
    }
    for (;;)
    {
      if ((localObject1 != null) && (paramj.e.equals(paramb))) {
        ((av)localObject1).o = true;
      }
      return (av)localObject1;
      if (paramj.d != 6) {
        break;
      }
      localObject1 = localObject2;
      if (paramj.d == 6)
      {
        localObject1 = new av();
        ((av)localObject1).c = paramj.e.c;
        ((av)localObject1).l = paramj.n;
        ((av)localObject1).e = paramj.e.a;
        ((av)localObject1).p = paramj.e.b;
        switch ((int)paramj.t)
        {
        case 2: 
        case 3: 
        case 8: 
        default: 
          localObject1 = localObject2;
          break;
        case 1: 
          ((av)localObject1).i = 10;
          ((av)localObject1).a = paramj.e();
          ((av)localObject1).d = paramj.f;
          break;
        case 11: 
          ((av)localObject1).i = 1;
          ((av)localObject1).a = paramj.e();
          ((av)localObject1).d = paramj.f;
          break;
        case 17: 
          ((av)localObject1).i = 2;
          ((av)localObject1).d = paramj.f;
          break;
        case 4: 
          if (j.b(((av)localObject1).e))
          {
            ((av)localObject1).i = 12;
            ((av)localObject1).d = paramj.f;
          }
          else
          {
            ((av)localObject1).i = 3;
            ((av)localObject1).t = new ArrayList(1);
            ((av)localObject1).t.add(paramj.f);
          }
          break;
        case 12: 
          ((av)localObject1).i = 3;
          ((av)localObject1).d = paramj.f;
          ((av)localObject1).t = ((List)paramj.N);
          break;
        case 20: 
          ((av)localObject1).i = 17;
          ((av)localObject1).d = paramj.f;
          ((av)localObject1).t = ((List)paramj.N);
          break;
        case 7: 
          if (j.b(((av)localObject1).e))
          {
            ((av)localObject1).i = 13;
            ((av)localObject1).d = paramj.f;
          }
          else
          {
            ((av)localObject1).i = 4;
            ((av)localObject1).t = new ArrayList(1);
            ((av)localObject1).t.add(paramj.f);
          }
          break;
        case 14: 
          ((av)localObject1).i = 4;
          ((av)localObject1).d = paramj.f;
          ((av)localObject1).t = ((List)paramj.N);
          break;
        case 5: 
          ((av)localObject1).i = 7;
          ((av)localObject1).t = new ArrayList(1);
          ((av)localObject1).t.add(paramj.f);
          break;
        case 13: 
          ((av)localObject1).i = 7;
          ((av)localObject1).d = paramj.f;
          ((av)localObject1).t = ((List)paramj.N);
          break;
        case 15: 
          ((av)localObject1).i = 5;
          ((av)localObject1).d = paramj.f;
          ((av)localObject1).t = ((List)paramj.N);
          break;
        case 16: 
          ((av)localObject1).i = 6;
          ((av)localObject1).d = paramj.f;
          ((av)localObject1).t = ((List)paramj.N);
          break;
        case 6: 
          ((av)localObject1).i = 8;
          ((av)localObject1).a = paramj.e();
          ((av)localObject1).d = paramj.f;
          break;
        case 10: 
          ((av)localObject1).i = 9;
          ((av)localObject1).d = paramj.f;
          ((av)localObject1).t = new ArrayList(1);
          ((av)localObject1).t.add(paramj.N);
          break;
        case 9: 
          ((av)localObject1).i = 11;
          ((av)localObject1).j = ((List)paramj.N).size();
          ((av)localObject1).d = paramj.f;
          break;
        case 18: 
          ((av)localObject1).i = 14;
          if (paramj.f == null) {}
          for (localObject2 = paramj.e.a;; localObject2 = paramj.f)
          {
            ((av)localObject1).d = ((String)localObject2);
            break;
          }
        case 19: 
          ((av)localObject1).i = 15;
          break;
        case 21: 
          ((av)localObject1).i = 18;
          ((av)localObject1).d = paramj.f;
        }
      }
    }
    localObject2 = new av();
    ((av)localObject2).s = paramj;
    int i;
    label945:
    int j;
    if (paramj.s == 0)
    {
      i = 1;
      j = k;
      if (i != 0) {
        if (TextUtils.isEmpty(paramj.z))
        {
          j = k;
          if (TextUtils.isEmpty(paramj.y)) {}
        }
        else
        {
          j = 1;
        }
      }
      if (i == 0) {
        break label1044;
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((MediaData)localObject1).mediaKey != null)) {
        ((av)localObject2).w = ((MediaData)localObject1).mediaKey;
      }
      if (j != 0)
      {
        localObject1 = aa.b(paramj.e());
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((av)localObject2).a = ((String)localObject1);
        }
      }
      localObject1 = localObject2;
      break;
      i = 0;
      break label945;
      label1044:
      localObject1 = paramj.b();
    }
  }
  
  public final void a(String paramString, List<j> paramList, final int paramInt1, boolean paramBoolean1, boolean paramBoolean2, final ConditionVariable paramConditionVariable1, final ConditionVariable paramConditionVariable2, int paramInt2, j.b paramb, HashMap<String, String> paramHashMap)
  {
    if (3 == paramInt1) {}
    for (final int i = this.c.getAndIncrement();; i = -1)
    {
      paramConditionVariable1 = new a(paramConditionVariable1, paramConditionVariable2, paramInt1, i);
      if (((paramString != null) || ((paramList != null) && ((paramList.size() != 0) || (paramInt1 == 0)))) && ((auj.c()) || (paramBoolean2))) {
        break;
      }
      paramConditionVariable1.b();
      return;
    }
    paramString = af.a(this, paramList, paramb, paramConditionVariable1, paramString, paramInt1, paramBoolean2, paramInt2, paramHashMap);
    if (paramBoolean1)
    {
      paramString.run();
      return;
    }
    try
    {
      bu.a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("app/xmpp/send/qr_msgs dispatch error " + paramString.toString());
      paramConditionVariable1.b();
    }
  }
  
  public final void a(String paramString, boolean paramBoolean, Collection<j> paramCollection, int paramInt)
  {
    if ((!auj.c()) || (paramString == null) || (paramCollection == null) || (paramCollection.size() == 0)) {
      return;
    }
    auj.m localm = new auj.m(new c(this, paramString, paramBoolean, paramCollection, paramInt));
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = new ArrayList(paramCollection.size());
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        localObject2 = a((j)paramCollection.next(), null);
        if (localObject2 != null) {
          ((List)localObject1).add(localObject2);
        }
      }
      localObject2 = null;
      paramCollection = (Collection<j>)localObject1;
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = auj.p();
      att localatt = this.a;
      localObject1 = new ci((String)localObject2, paramString, localm, (List)localObject1);
      ((ci)localObject1).e = paramCollection;
      if (paramBoolean) {}
      for (int i = 7;; i = 8)
      {
        ((ci)localObject1).j = new ar(paramString, i, paramInt);
        localatt.a(new SendWebForwardJob((String)localObject2, Message.obtain(null, 0, 55, 0, localObject1)));
        return;
        localObject1 = new ArrayList(paramCollection.size());
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
          ((List)localObject1).add(((j)paramCollection.next()).e);
        }
      }
      paramCollection = null;
    }
  }
  
  final class a
  {
    public final void a()
    {
      if (paramConditionVariable1 != null) {
        paramConditionVariable1.block(180000L);
      }
      if ((paramConditionVariable2 != null) && ((1 == paramInt1) || (5 == paramInt1))) {
        paramConditionVariable2.block(180000L);
      }
      if (3 == paramInt1) {
        ae.a(this.e).lock();
      }
      for (;;)
      {
        if (ae.b(this.e).get() < i) {}
        try
        {
          if (!ae.c(this.e).await(8L, TimeUnit.SECONDS))
          {
            Log.e("app/xmpp/send/qr_msgs await timeout " + ae.b(this.e).get() + ' ' + i);
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.e("app/xmpp/send/qr_msgs interrupted");
        }
      }
    }
    
    public final void b()
    {
      if ((paramConditionVariable2 != null) && (paramInt1 == 0)) {
        paramConditionVariable2.open();
      }
      if (3 == paramInt1)
      {
        ae.b(this.e).getAndIncrement();
        if (ae.a(this.e).isHeldByCurrentThread())
        {
          ae.c(this.e).signalAll();
          ae.a(this.e).unlock();
        }
      }
    }
  }
  
  static final class b
    extends auj.q
  {
    private final String a;
    private final List<j> b;
    private final int c;
    private final int e;
    private final boolean f;
    private final j.b g;
    private final ae h;
    
    public b(ae paramae, String paramString, List<j> paramList, int paramInt1, boolean paramBoolean, int paramInt2, j.b paramb)
    {
      this.h = paramae;
      this.a = paramString;
      this.b = paramList;
      this.c = paramInt1;
      this.f = paramBoolean;
      this.e = paramInt2;
      this.g = paramb;
    }
    
    public final void a()
    {
      ae.a(this.h, this.a, this.b, this.c, this.f, this.e, this.g);
    }
    
    public final String b()
    {
      if (this.a == null) {}
      for (String str = "most recent msgs";; str = "msg query id: " + this.a) {
        return "qr_msgs/" + str + "/fwdType:" + this.c + "/qryType:" + this.e + "/firstUnread:" + this.g + "/#msgs:" + this.b.size();
      }
    }
    
    public final boolean c()
    {
      return (this.f) || (super.c());
    }
  }
  
  static final class c
    extends auj.q
  {
    private final String a;
    private final boolean b;
    private final Collection<j> c;
    private final int e;
    private final ae f;
    
    public c(ae paramae, String paramString, boolean paramBoolean, Collection<j> paramCollection, int paramInt)
    {
      this.f = paramae;
      this.a = paramString;
      this.b = paramBoolean;
      this.c = paramCollection;
      this.e = paramInt;
    }
    
    public final void a()
    {
      this.f.a(this.a, this.b, this.c, this.e);
    }
    
    public final String b()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qr_star_msgs ");
      localStringBuilder.append(this.a).append(' ');
      localStringBuilder.append(this.b).append(' ');
      localStringBuilder.append(this.e);
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        localStringBuilder.append(" ");
        localStringBuilder.append(localj.e);
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */