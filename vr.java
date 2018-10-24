package com.whatsapp;

import a.a.a.a.d;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.n;
import android.support.v4.content.b;
import android.support.v4.f.f;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.text.format.DateUtils;
import android.view.View;
import com.whatsapp.data.ac;
import com.whatsapp.data.l;
import com.whatsapp.data.y;
import com.whatsapp.gallerypicker.az;
import com.whatsapp.gallerypicker.ba;
import com.whatsapp.gallerypicker.bb;
import com.whatsapp.gallerypicker.bc;
import com.whatsapp.gallerypicker.bd;
import com.whatsapp.gallerypicker.bf;
import com.whatsapp.gallerypicker.q;
import com.whatsapp.gallerypicker.r;
import com.whatsapp.gallerypicker.w;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.ag;
import com.whatsapp.util.p;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class vr
  extends w
  implements MediaGallery.a
{
  private String a;
  private final l ad = l.a();
  private final y ae = y.a();
  private final ag af = ag.a();
  private final ac ag = ac.a();
  private final com.whatsapp.data.ab ah = new com.whatsapp.data.ab()
  {
    public final void a(Collection<j> paramAnonymousCollection, String paramAnonymousString, Map<String, Integer> paramAnonymousMap, boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousCollection != null) && (!paramAnonymousCollection.isEmpty()))
      {
        paramAnonymousCollection = paramAnonymousCollection.iterator();
        while (paramAnonymousCollection.hasNext()) {
          if (((j)paramAnonymousCollection.next()).e.a.equals(vr.a(vr.this)))
          {
            vr.c(vr.this).e();
            vr.d(vr.this).c();
          }
        }
      }
      while ((paramAnonymousString != null) && (!paramAnonymousString.equals(vr.a(vr.this)))) {
        return;
      }
      vr.c(vr.this).e();
      vr.e(vr.this).c();
    }
    
    public final void a(Collection<j> paramAnonymousCollection, Map<String, Integer> paramAnonymousMap)
    {
      paramAnonymousCollection = paramAnonymousCollection.iterator();
      while (paramAnonymousCollection.hasNext()) {
        if (((j)paramAnonymousCollection.next()).e.a.equals(vr.a(vr.this))) {
          vr.b(vr.this);
        }
      }
    }
  };
  
  public final void A()
  {
    Log.i("mediagalleryfragment/destroy");
    super.A();
    this.ag.unregisterObserver(this.ah);
  }
  
  protected final r a(boolean paramBoolean)
  {
    return new b(this.ad, this.ae, this.af, this.a, S());
  }
  
  public final void a()
  {
    this.e.c();
  }
  
  protected final void a(q paramq, com.whatsapp.gallerypicker.ab paramab)
  {
    paramq = ((bd)paramq).a;
    if (((jz)l()).O()) {
      paramab.setChecked(((jz)l()).b(paramq));
    }
    do
    {
      return;
      a(MediaView.a(paramq, this.a, l(), paramab, 2).putExtra("gallery", true));
    } while ((paramq.s != 1) || (!MediaView.l()));
    l().overridePendingTransition(0, 0);
  }
  
  public final void a(String paramString) {}
  
  public final com.whatsapp.gallerypicker.ab b()
  {
    return new a(l());
  }
  
  protected final boolean b(q paramq, com.whatsapp.gallerypicker.ab paramab)
  {
    paramq = ((bd)paramq).a;
    if (((jz)l()).O())
    {
      paramab.setChecked(((jz)l()).b(paramq));
      return true;
    }
    ((jz)l()).a(paramq);
    paramab.setChecked(true);
    return true;
  }
  
  public final void d(Bundle paramBundle)
  {
    Log.i("mediagalleryfragment/create");
    super.d(paramBundle);
    this.a = l().getIntent().getStringExtra("jid");
    android.support.v4.view.ab.D(this.d);
    android.support.v4.view.ab.D(x().findViewById(2131755782));
    a(false, false);
    if ((l() instanceof MediaGallery)) {
      this.d.setOnScrollListener(((MediaGallery)l()).p);
    }
    this.ag.registerObserver(this.ah);
  }
  
  protected final boolean d(int paramInt)
  {
    return ((jz)l()).c(((b)this.b).a(paramInt).a);
  }
  
  public static class a
    extends com.whatsapp.gallerypicker.ab
  {
    private Drawable a;
    private Drawable d;
    private Drawable e;
    private Drawable f;
    private Paint g;
    private boolean h;
    
    public a(Context paramContext)
    {
      super();
    }
    
    public final void a(Canvas paramCanvas)
    {
      super.a(paramCanvas);
      boolean bool;
      Object localObject;
      if ((this.b != null) && (getDrawable() != null))
      {
        bool = this.h;
        if ((bool) || (!d.b(this.b))) {
          break label553;
        }
        i = 1;
        if ((i == 0) && (!bool)) {
          break label596;
        }
        if (this.e == null) {
          this.e = b.a(getContext(), 2130840021);
        }
        if ((i != 0) && (this.a == null)) {
          this.a = b.a(getContext(), 2130840345);
        }
        if ((bool) && (this.d == null)) {
          this.d = b.a(getContext(), 2130840344);
        }
        if (i == 0) {
          break label558;
        }
        localObject = this.a;
        label130:
        this.e.setBounds(0, getHeight() - (((Drawable)localObject).getIntrinsicHeight() << 1), getWidth(), getHeight());
        this.e.draw(paramCanvas);
        i = ((Drawable)localObject).getIntrinsicHeight() / 4;
        ((Drawable)localObject).setBounds(i, getHeight() - ((Drawable)localObject).getIntrinsicHeight() - i, ((Drawable)localObject).getIntrinsicWidth() + i, getHeight() - i);
        ((Drawable)localObject).draw(paramCanvas);
      }
      label227:
      label309:
      label553:
      label558:
      label581:
      label586:
      label596:
      for (int i = ((Drawable)localObject).getIntrinsicWidth() + i;; i = 0)
      {
        long l;
        int j;
        if (bool)
        {
          l = 0L;
          if (l != 0L)
          {
            if (this.g == null)
            {
              this.g = new Paint(1);
              this.g.setColor(-1);
              this.g.setTextSize(getContext().getResources().getDimensionPixelSize(2131362047));
            }
            localObject = this.b.d();
            if ((localObject == null) || (!((String)localObject).startsWith("application/"))) {
              break label581;
            }
            j = 1;
            if (j == 0) {
              break label586;
            }
            localObject = p.a(this.b.d(), (int)l);
            if (this.e == null) {
              this.e = b.a(getContext(), 2130840021);
            }
            if (this.a == null) {
              this.a = b.a(getContext(), 2130840345);
            }
            this.e.setBounds(0, getHeight() - (this.a.getIntrinsicHeight() << 1), getWidth(), getHeight());
            this.e.draw(paramCanvas);
          }
        }
        for (;;)
        {
          paramCanvas.drawText((String)localObject, i + this.g.getTextSize() / 3.0F, getHeight() - this.g.getTextSize() / 3.0F, this.g);
          if ((this.b instanceof bd))
          {
            localObject = (bd)this.b;
            if ((((bd)localObject).a != null) && (((bd)localObject).a.T))
            {
              if (this.f == null) {
                this.f = b.a(getContext(), 2130840367);
              }
              this.f.setBounds(getWidth() - this.f.getIntrinsicWidth(), getHeight() - this.f.getIntrinsicHeight(), getWidth(), getHeight());
              this.f.draw(paramCanvas);
            }
          }
          return;
          i = 0;
          break;
          localObject = this.d;
          break label130;
          l = this.b.e();
          break label227;
          j = 0;
          break label309;
          localObject = DateUtils.formatElapsedTime(l);
        }
      }
    }
    
    public void setMediaItem(q paramq)
    {
      boolean bool = true;
      super.setMediaItem(paramq);
      if ((this.b instanceof bd))
      {
        if (((bd)this.b).a.s == 13) {}
        for (bool = true;; bool = false)
        {
          this.h = bool;
          return;
        }
      }
      if ((this.b != null) && (d.b(this.b)) && (GifHelper.a(new File(this.b.b())))) {}
      for (;;)
      {
        this.h = bool;
        return;
        bool = false;
      }
    }
  }
  
  static final class b
    implements r
  {
    private final String a;
    private final vj b;
    private final ContentResolver c;
    private final f<Integer, bd> d = new f(512);
    private final y e;
    private final ag f;
    
    public b(l paraml, y paramy, ag paramag, String paramString, ContentResolver paramContentResolver)
    {
      this.a = paramString;
      this.e = paramy;
      this.f = paramag;
      this.c = paramContentResolver;
      this.b = new vj(paraml, paramString, paramy.a(paramString));
    }
    
    public final bd a(int paramInt)
    {
      Object localObject1 = (bd)this.d.a(Integer.valueOf(paramInt));
      Object localObject2;
      if (localObject1 == null) {
        for (;;)
        {
          j localj;
          try
          {
            if (!this.b.moveToPosition(paramInt)) {
              break label308;
            }
            localj = this.b.a();
            MediaData localMediaData = localj.b();
            Object localObject3 = null;
            localObject1 = localObject3;
            if (localMediaData != null)
            {
              localObject1 = localObject3;
              if (localMediaData.file != null) {
                localObject1 = localMediaData.file.getAbsolutePath();
              }
            }
            switch (localj.s)
            {
            case 1: 
              localObject1 = new vr.c(this);
              ((bd)localObject1).a = localj;
              if (localObject1 != null) {
                this.d.a(Integer.valueOf(paramInt), localObject1);
              }
              return (bd)localObject1;
            }
          }
          finally {}
          localObject1 = new bc(this, this.c, (String)localObject1, localj.n);
          continue;
          localObject2 = new bb(this, str, localj.n, localj.w);
          continue;
          localObject2 = new bf(this, (String)localObject2, localj.n, localj.w);
          continue;
          localObject2 = new az(this, this.c, (String)localObject2, localj.n, localj.w);
          continue;
          localObject2 = new ba(this, this.f, this.c, (String)localObject2, localj.n, localj.x, localj.r);
          continue;
          label308:
          localObject2 = null;
        }
      }
      return (bd)localObject2;
    }
    
    public final HashMap<String, String> a()
    {
      return null;
    }
    
    public final void a(ContentObserver paramContentObserver)
    {
      if (this.b != null) {
        this.b.registerContentObserver(paramContentObserver);
      }
    }
    
    public final int b()
    {
      return this.b.getCount();
    }
    
    public final void b(ContentObserver paramContentObserver)
    {
      if (this.b != null) {
        this.b.unregisterContentObserver(paramContentObserver);
      }
    }
    
    public final boolean c()
    {
      return b() == 0;
    }
    
    public final void d()
    {
      this.b.close();
    }
    
    public final void e()
    {
      if (this.b != null)
      {
        vj localvj = this.b;
        Cursor localCursor = this.e.a(this.a);
        localvj.a.close();
        localvj.a = localCursor;
        localvj.b = -1;
        localvj.moveToPosition(-1);
      }
      this.d.a();
    }
  }
  
  static final class c
    extends bd
  {
    private final r b;
    
    public c(r paramr)
    {
      this.b = paramr;
    }
    
    public final Bitmap a(int paramInt)
    {
      return null;
    }
    
    public final Uri a()
    {
      return null;
    }
    
    public final String b()
    {
      return "";
    }
    
    public final long c()
    {
      return this.a.n;
    }
    
    public final String d()
    {
      return null;
    }
    
    public final long e()
    {
      return 0L;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/vr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */