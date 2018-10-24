package com.whatsapp;

import a.a.a.a.d;
import com.whatsapp.data.ad;
import com.whatsapp.protocol.am;
import com.whatsapp.protocol.aw;
import com.whatsapp.protocol.x;
import com.whatsapp.util.Log;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class rj
  implements am, x, Runnable
{
  private static Timer a = new Timer();
  public String b;
  public String c;
  public List<String> d;
  public int e;
  public boolean f = false;
  public aw g;
  private boolean h = false;
  private a i;
  private final ant j;
  private final va k;
  private final ad l;
  private final qz m;
  private final hx n;
  
  public rj(ant paramant, va paramva, ad paramad, qz paramqz, hx paramhx, String paramString1, String paramString2, List<String> paramList, int paramInt)
  {
    if (paramString1 != null) {
      bool = true;
    }
    Log.a(bool);
    this.j = paramant;
    this.k = paramva;
    this.l = paramad;
    this.m = paramqz;
    this.n = paramhx;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramList;
    this.e = paramInt;
    paramva = new StringBuilder("GroupResponseHandler - gid:");
    paramant = paramString1;
    if (paramString1 == null) {
      paramant = "";
    }
    paramva = paramva.append(paramant).append(" subject:");
    paramant = paramString2;
    if (paramString2 == null) {
      paramant = "";
    }
    paramva = paramva.append(paramant).append(" pa:");
    if (paramList == null) {}
    for (paramant = "";; paramant = Arrays.deepToString(paramList.toArray()))
    {
      Log.d(paramant);
      this.i = new a(this);
      a.schedule(this.i, 20000L);
      return;
    }
  }
  
  public rj(ant paramant, va paramva, ad paramad, qz paramqz, hx paramhx, String paramString1, String paramString2, List<String> paramList, int paramInt, aw paramaw)
  {
    this(paramant, paramva, paramad, paramqz, paramhx, paramString1, paramString2, paramList, paramInt);
    this.g = paramaw;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    Log.e("groupmgr/request failed : " + paramInt + " | " + this.b + " | " + this.e);
    this.i.cancel();
    switch (this.e)
    {
    }
    for (;;)
    {
      if (this.g != null) {
        auj.b(this.g.a, paramInt);
      }
      this.n.a(this.b, false);
      a();
      return;
      qz.a().c(this.b);
      switch (paramInt)
      {
      default: 
        qz.a(12, this.c);
      }
      for (;;)
      {
        this.l.b(d.a(this.j, this.k, this.b, this.c, this.d, 3), -1);
        break;
        qz.a(13, this.c);
        continue;
        qz.a(14, this.c);
      }
      switch (paramInt)
      {
      case 402: 
      case 405: 
      default: 
        qz.a(15, null);
        break;
      case 401: 
        qz.a(16, null);
        break;
      case 403: 
        qz.a(17, null);
        break;
      case 404: 
        qz.a(18, null);
        break;
      case 406: 
        qz.a(19, this.c);
        continue;
        switch (paramInt)
        {
        case 402: 
        default: 
          qz.a(20, null);
          break;
        case 401: 
          qz.a(21, null);
          break;
        case 403: 
          qz.a(22, null);
          break;
        case 404: 
          qz.a(23, null);
          continue;
          switch (paramInt)
          {
          case 402: 
          default: 
            qz.a(24, null);
            break;
          case 401: 
            qz.a(25, null);
            break;
          case 403: 
            qz.a(26, null);
            break;
          case 404: 
            qz.a(27, null);
            continue;
            switch (paramInt)
            {
            case 402: 
            default: 
              qz.a(28, null);
              break;
            case 401: 
              qz.a(29, null);
              break;
            case 403: 
              qz.a(30, null);
              break;
            case 404: 
              qz.a(31, null);
              continue;
              switch (paramInt)
              {
              default: 
                qz.a(32, null);
                break;
              case 403: 
                qz.a(33, null);
                break;
              case 404: 
                qz.a(34, null);
                continue;
                qz.a(35, null);
              }
              break;
            }
            break;
          }
          break;
        }
        break;
      }
    }
  }
  
  public void a(String paramString)
  {
    this.i.cancel();
    this.h = true;
    Log.i("groupmgr/request success : " + paramString + " | " + this.e);
    if (this.g != null) {
      auj.b(this.g.a, 200);
    }
    this.n.a(this.b, false);
    a();
  }
  
  public void run()
  {
    this.i.cancel();
    Log.i("groupmgr/request success/" + this.e);
    a();
  }
  
  public static final class a
    extends TimerTask
  {
    rj a;
    
    public a(rj paramrj)
    {
      this.a = paramrj;
    }
    
    public final void run()
    {
      if (rj.a(this.a)) {
        return;
      }
      rj.b(this.a);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/rj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */