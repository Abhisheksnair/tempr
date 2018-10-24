package com.whatsapp;

import a.a.a.a.a.a.e;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.f.f;
import android.text.TextUtils;
import android.widget.ImageView;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class di
{
  private static volatile di b;
  public final com.whatsapp.c.a a;
  private final pv c;
  private final va d;
  private final e e;
  
  private di(com.whatsapp.c.a parama, pv parampv, va paramva, e parame)
  {
    this.a = parama;
    this.c = parampv;
    this.d = paramva;
    this.e = parame;
  }
  
  public static di a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new di(com.whatsapp.c.a.a(), pv.a(), va.a(), e.a());
      }
      return b;
    }
    finally {}
  }
  
  public final Bitmap a(String paramString)
  {
    return (Bitmap)this.a.b.a(paramString);
  }
  
  public final e a(int paramInt, float paramFloat)
  {
    return new e(paramInt, paramFloat, (byte)0);
  }
  
  public final e b()
  {
    Resources localResources = u.a().getResources();
    return new e(localResources.getDimensionPixelSize(2131362090), localResources.getDimensionPixelSize(2131361833), (byte)0);
  }
  
  public final void c()
  {
    this.a.b.a(0);
  }
  
  final class a
    implements Runnable
  {
    private final Bitmap b;
    private final ImageView c;
    private final Object d;
    private final int e;
    private final di.d f;
    
    private a(di.d paramd, Bitmap paramBitmap, ImageView paramImageView, Object paramObject, int paramInt)
    {
      this.f = paramd;
      this.b = paramBitmap;
      this.c = paramImageView;
      this.d = paramObject;
      this.e = paramInt;
    }
    
    public final void run()
    {
      if (di.d.a(this.f)) {}
      Object localObject;
      do
      {
        do
        {
          return;
        } while ((this.c.getTag() == null) || (!this.c.getTag().equals(this.d)));
        if (this.b != null)
        {
          Drawable localDrawable = this.c.getDrawable();
          localObject = localDrawable;
          if ((localDrawable instanceof LayerDrawable))
          {
            LayerDrawable localLayerDrawable = (LayerDrawable)localDrawable;
            localObject = localDrawable;
            if (localLayerDrawable.getNumberOfLayers() > 0) {
              localObject = localLayerDrawable.getDrawable(localLayerDrawable.getNumberOfLayers() - 1);
            }
          }
          localObject = new TransitionDrawable(new Drawable[] { localObject, new BitmapDrawable(this.b) });
          ((TransitionDrawable)localObject).setCrossFadeEnabled(false);
          ((TransitionDrawable)localObject).startTransition(300);
          this.c.setImageDrawable((Drawable)localObject);
          return;
        }
        localObject = cs.b(this.e);
      } while (((this.c.getDrawable() instanceof BitmapDrawable)) && (((BitmapDrawable)this.c.getDrawable()).getBitmap() == localObject));
      this.c.setImageBitmap((Bitmap)localObject);
    }
  }
  
  static final class b
  {
    Object a;
    final ImageView b;
    final Object c;
    
    private b(Object paramObject1, ImageView paramImageView, Object paramObject2)
    {
      this.a = paramObject1;
      this.b = paramImageView;
      this.c = paramObject2;
    }
  }
  
  static final class c
  {
    final Stack<di.b> a = new Stack();
  }
  
  final class d
    extends Thread
  {
    volatile boolean a;
    private final di.c c;
    private final int d;
    private final float e;
    
    d(di.c paramc, int paramInt, float paramFloat)
    {
      super();
      this.c = paramc;
      this.d = paramInt;
      this.e = paramFloat;
    }
    
    private di.b a()
    {
      synchronized (this.c.a)
      {
        if (!this.c.a.isEmpty())
        {
          di.b localb = (di.b)this.c.a.pop();
          return localb;
        }
        return null;
      }
    }
    
    private void a(Bitmap paramBitmap, ImageView paramImageView, Object paramObject, int paramInt)
    {
      if (paramImageView.getTag().equals(paramObject))
      {
        paramBitmap = new di.a(di.this, this, paramBitmap, paramImageView, paramObject, paramInt, (byte)0);
        di.c(di.this).a(paramBitmap);
      }
    }
    
    private void a(cs paramcs, ImageView paramImageView, Object paramObject)
    {
      a(paramcs.a(this.d, this.e, true), paramImageView, paramObject, paramcs.e());
    }
    
    public final void run()
    {
      try
      {
        do
        {
          do
          {
            if ((this.a) || (this.c.a.isEmpty())) {}
            synchronized (this.c.a)
            {
              this.c.a.wait();
              boolean bool = this.a;
              if (bool) {
                return;
              }
            }
          } while (this.c.a.isEmpty());
          ??? = a();
        } while (??? == null);
        PhoneContactsSelector.a locala;
        ImageView localImageView;
        Object localObject3;
        if ((((di.b)???).a instanceof PhoneContactsSelector.a))
        {
          locala = (PhoneContactsSelector.a)((di.b)???).a;
          localImageView = ((di.b)???).b;
          localObject3 = ((di.b)???).c;
          if (localImageView.getTag().equals(localObject3))
          {
            int j = localImageView.getHeight();
            int i = j;
            if (j <= 0) {
              i = u.a().getResources().getDimensionPixelSize(2131362090);
            }
            locala.e = di.a(u.a().getContentResolver(), locala.c, i);
            if (locala.e != null) {
              break label310;
            }
            Iterator localIterator = a.a.a.a.a.a.a(Long.valueOf(locala.c).toString(), u.a()).values().iterator();
            while (localIterator.hasNext())
            {
              Object localObject4 = (String)localIterator.next();
              localObject4 = di.a(di.this).c((String)localObject4);
              if (localObject4 != null)
              {
                locala.g = ((cs)localObject4);
                a((cs)localObject4, localImageView, localObject3);
              }
            }
          }
        }
        while ((((di.b)???).a instanceof cs))
        {
          a((cs)((di.b)???).a, ((di.b)???).b, ((di.b)???).c);
          break;
          label310:
          a(locala.e, localImageView, localObject3, 2130837625);
        }
        return;
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public final class e
  {
    private di.d b;
    private final di.c c = new di.c((byte)0);
    private final int d;
    private final float e;
    
    private e(int paramInt, float paramFloat)
    {
      this.d = paramInt;
      this.e = paramFloat;
    }
    
    private void a(Object arg1, ImageView paramImageView, Object paramObject2)
    {
      for (;;)
      {
        int i;
        synchronized (this.c.a)
        {
          di.c localc = this.c;
          i = 0;
          if (i >= localc.a.size()) {
            break;
          }
          if (((di.b)localc.a.get(i)).b == paramImageView) {
            localc.a.remove(i);
          }
        }
        i += 1;
      }
      paramImageView = new di.b(???, paramImageView, paramObject2, (byte)0);
      synchronized (this.c.a)
      {
        this.c.a.add(0, paramImageView);
        this.c.a.notifyAll();
        if (this.b == null)
        {
          this.b = new di.d(di.this, this.c, this.d, this.e);
          this.b.setPriority(4);
          this.b.start();
        }
        return;
      }
    }
    
    public final void a()
    {
      if (this.b != null)
      {
        di.d locald = this.b;
        locald.a = true;
        locald.interrupt();
        this.b = null;
      }
    }
    
    public final void a(a.a.a.a.a.a parama, ImageView paramImageView)
    {
      paramImageView.setContentDescription(parama.a());
      if ((parama.f != null) && (parama.f.length > 0))
      {
        localObject = BitmapFactory.decodeByteArray(parama.f, 0, parama.f.length);
        if (localObject != null)
        {
          paramImageView.setImageBitmap((Bitmap)localObject);
          return;
        }
        Log.w("contactphotoloader/displaycontact bitmap decoding failed");
      }
      Object localObject = new ArrayList();
      if (parama.h != null)
      {
        parama = parama.h.iterator();
        while (parama.hasNext())
        {
          a.e locale = (a.e)parama.next();
          if (locale.e != null) {
            ((ArrayList)localObject).add(locale.e + "@s.whatsapp.net");
          }
        }
      }
      parama = ((ArrayList)localObject).iterator();
      while (parama.hasNext())
      {
        localObject = (String)parama.next();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).endsWith("@s.whatsapp.net")))
        {
          parama = di.a(di.this).c((String)localObject);
          if (parama != null)
          {
            a(parama, paramImageView);
            return;
          }
        }
      }
      paramImageView.setImageBitmap(cs.b(2130837625));
    }
    
    public final void a(PhoneContactsSelector.a parama, ImageView paramImageView)
    {
      paramImageView.setContentDescription(parama.a);
      String str = Long.valueOf(parama.c).toString();
      paramImageView.setTag(str);
      if (parama.e != null)
      {
        paramImageView.setImageBitmap(parama.e);
        return;
      }
      if (parama.g != null)
      {
        a(parama.g, paramImageView);
        return;
      }
      a(parama, paramImageView, str);
    }
    
    public final void a(cs paramcs, ImageView paramImageView)
    {
      String str;
      if (di.b(di.this).a(paramcs.t))
      {
        str = paramImageView.getContext().getResources().getString(2131298216);
        paramImageView.setContentDescription(str);
        str = paramcs.a(this.d, this.e);
        if (str != null) {
          break label81;
        }
        paramImageView.setImageBitmap(cs.b(paramcs.e()));
      }
      label81:
      do
      {
        return;
        str = paramcs.a(paramImageView.getContext());
        break;
        boolean bool = str.equals(paramImageView.getTag());
        paramImageView.setTag(str);
        Bitmap localBitmap = di.this.a(str);
        if (localBitmap != null)
        {
          paramImageView.setImageBitmap(localBitmap);
          return;
        }
        if (!bool) {
          paramImageView.setImageBitmap(cs.b(paramcs.e()));
        }
      } while (!paramcs.k);
      a(paramcs, paramImageView, str);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */