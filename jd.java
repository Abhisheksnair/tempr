package com.whatsapp;

import android.content.Context;
import android.os.Handler;
import com.whatsapp.data.ProfilePhotoChange;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class jd
{
  private di.e a;
  private final di b;
  private List<iy> c;
  
  jd(di paramdi)
  {
    this.b = paramdi;
  }
  
  static int a(j paramj)
  {
    switch (paramj.s)
    {
    case 6: 
    case 7: 
    default: 
      if ((paramj.d != -1) || (paramj.s != -1)) {
        break label414;
      }
      if (!paramj.e.b) {
        break;
      }
    case 0: 
      do
      {
        return 6;
        if ((paramj.e.b) && (paramj.d == 6) && (paramj.t == 6L) && ((paramj.N instanceof ProfilePhotoChange))) {
          return 21;
        }
        if (paramj.d != 6) {
          break;
        }
      } while (paramj.e.b);
      return 16;
      if (paramj.e.b) {
        return 0;
      }
      return 10;
    case 2: 
      if (paramj.o == 1)
      {
        if (paramj.e.b) {
          return 7;
        }
        return 17;
      }
      if (paramj.e.b) {
        return 2;
      }
      return 12;
    case 1: 
      if (paramj.e.b) {
        return 1;
      }
      return 11;
    case 9: 
      if (paramj.e.b) {
        return 9;
      }
      return 19;
    case 13: 
      if (paramj.e.b) {
        return 26;
      }
      return 27;
    case 3: 
      if (paramj.e.b) {
        return 3;
      }
      if (vk.a(paramj)) {
        return 13;
      }
      return 25;
    case 5: 
      if (paramj.e.b) {
        return 4;
      }
      return 14;
    case 16: 
      if (paramj.e.b) {
        return 32;
      }
      return 33;
    case 4: 
      if (paramj.e.b) {
        return 5;
      }
      return 15;
    case 14: 
      if (paramj.e.b) {
        return 30;
      }
      return 31;
    case 8: 
      if (paramj.e.b) {
        return 8;
      }
      return 18;
    case 10: 
      return 23;
    case 11: 
      return 22;
    case 12: 
      return 24;
    case 15: 
      if (paramj.e.b) {
        return 28;
      }
      return 29;
    }
    return 16;
    label414:
    return -1;
  }
  
  private di.e b()
  {
    if (this.a == null) {
      this.a = this.b.b();
    }
    return this.a;
  }
  
  final hy a(Context paramContext, j paramj)
  {
    switch (paramj.s)
    {
    case 6: 
    case 7: 
    default: 
      if ((paramj.d == -1) && (paramj.s == -1)) {
        return new ip(paramContext, paramj);
      }
      break;
    case 0: 
      if ((paramj.e.b) && (paramj.d == 6) && (paramj.t == 6L) && ((paramj.N instanceof ProfilePhotoChange))) {
        return new jp(paramContext, paramj);
      }
      if (paramj.d == 6) {
        return new ip(paramContext, paramj);
      }
      return new jr(paramContext, paramj);
    case 2: 
      if (paramj.o == 1) {
        return new jv(paramContext, paramj, b());
      }
      return new ig(paramContext, paramj);
    case 1: 
      return new ConversationRowImage(paramContext, paramj);
    case 13: 
      paramContext = new iy(paramContext, paramj);
      if (this.c == null) {
        this.c = new ArrayList();
      }
      this.c.add(paramContext);
      return paramContext;
    case 3: 
      if ((vk.a(paramj)) || (paramj.e.b)) {
        return new ConversationRowVideo(paramContext, paramj);
      }
      return new je(paramContext, paramj);
    case 9: 
      return new ConversationRowDocument(paramContext, paramj);
    case 5: 
      return new jk(paramContext, paramj);
    case 16: 
      return new ji(paramContext, paramj, b());
    case 4: 
      return new ik(paramContext, paramj, b());
    case 14: 
      return new in(paramContext, paramj, b());
    case 8: 
      return new ij(paramContext, paramj);
    case 10: 
      return new jn(paramContext, paramj);
    case 11: 
      return new io(paramContext, paramj);
    case 12: 
      return new ix(paramContext, paramj);
    case 15: 
      return new jq(paramContext, paramj);
    }
    return new ix(paramContext, paramj);
  }
  
  final void a()
  {
    if (this.a != null) {
      this.a.a();
    }
    if (this.c != null)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (iy)localIterator.next();
        if (((iy)localObject).O != null)
        {
          localObject = ((iy)localObject).O;
          ((ss)localObject).l = false;
          ss.a.post(sw.a((ss)localObject));
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */